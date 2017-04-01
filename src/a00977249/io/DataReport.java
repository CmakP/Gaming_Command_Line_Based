/**
 * Project: A00977249Assignment1
 * File: DataReport.java
 * Date: May 23, 2016
 * Time: 12:59:18 PM
 */
package a00977249.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import a00977249.data.Player;
import a00977249.datajoint.PersonaScore;
import a00977249.datajoint.PlayerScore;

/**
 * @author Siamak Pourian, A009772249
 *
 *         DataReport Class
 */
public class DataReport {

	public static final String PLAYER_HEADER_FORMAT = "%-10s %-31s %-18s %-6s %-19s %-9s%n";
	public static final String PLAYER_ROW_FORMAT = "%-10d %-22s %-27s %-14d %-17d %-5d%n";
	public static final String PERSONA_HEADER_FORMAT = "%-10s %-18s %-16s %-16s%n";
	public static final String TOTAL_FORMAT = "%-16s %2d%n";
	public static final String SEPERATOR_LONG = "-------------------------------------------------------------------------------------------------------%n";
	public static final String SEPERATOR_SHORT = "---------------------------------------------------------%n";

	/**
	 * private Zero-Parameter Constructor to prevent initialization
	 */
	private DataReport() {
	}

	/**
	 * Outputs the report to a text file
	 * 
	 * @param playerList
	 *            collection of players
	 * @param scoreList
	 *            collection of scores
	 * @throws FileNotFoundException
	 */
	public static void writePlayerReportFile(Map<Integer, Player> playerMap, Map<Integer, PlayerScore> playersScore) throws IOException {

		Player player;
		PlayerScore playerScore;

		Formatter output = new Formatter("players_report.txt");
		int currentYear = LocalDateTime.now().getYear();
		output.format(PLAYER_HEADER_FORMAT, "Player ID", "Full name", "Email", "Age", "Total games played", "Total Wins");
		output.format(SEPERATOR_LONG);
		for (Map.Entry<Integer, Player> entry : playerMap.entrySet()) {
			player = entry.getValue();
			playerScore = playersScore.get(player.getId());
			output.format(PLAYER_ROW_FORMAT, player.getId(), player.getFirstName().concat(" " + player.getLastName()), player.getEmail(),
					currentYear - player.getBirthDate().getYear() - 1, playerScore.getTotalGamesPlayed(), playerScore.getWins());
		}
		output.format(SEPERATOR_LONG);
		output.close();
	}

	/**
	 * Generates the Map for Leader Board Report
	 *
	 * @param leaderBoardList
	 *            collection of the report elements
	 * @param total
	 *            true if the total count of each game played has to be included
	 *            in the Report
	 */
	public static void writeLeaderBoardReportFile(List<PersonaScore> leaderBoardList, boolean total) throws IOException {

		Map<String, Integer> playedCounts = new HashMap<String, Integer>();

		Integer counts;
		String gameName;
		int totalWin;
		int totalLoss;
		Formatter output = new Formatter("leaderboard_report.txt");
		output.format(PERSONA_HEADER_FORMAT, "Win:Loss", "Game Name", "Gamertag", "Platform");
		output.format(SEPERATOR_SHORT);
		for (PersonaScore personaScore : leaderBoardList) {
			gameName = personaScore.getGameName();
			totalWin = personaScore.getTotalWin();
			totalLoss = personaScore.getTotalLoss();
			output.format(PERSONA_HEADER_FORMAT, totalWin + ":" + totalLoss, gameName, personaScore.getGamerTag(), personaScore.getPlatForm());
			counts = playedCounts.get(gameName);
			if (counts == null) {
				playedCounts.put(gameName, totalWin + totalLoss);
			} else {
				counts = counts.intValue() + totalWin + totalLoss;
				playedCounts.put(gameName, counts);
			}
		}
		if (total) {
			output.format(SEPERATOR_SHORT);
			for (Entry<String, Integer> entryScore : playedCounts.entrySet()) {
				output.format(TOTAL_FORMAT, entryScore.getKey(), entryScore.getValue());
			}
			output.format(SEPERATOR_SHORT);
		}
		output.close();
	}
}
