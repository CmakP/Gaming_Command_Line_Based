/**
 * Project: A00977249.Assignment1
 * File: Gis.java
 * Date: May 21, 2016
 * Time: 2:47:56 PM
 */
package a00977249;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00977249.data.Game;
import a00977249.data.Persona;
import a00977249.data.Player;
import a00977249.data.Score;
import a00977249.datajoint.PersonaScore;
import a00977249.datajoint.PlayerScore;
import a00977249.io.DataReader;
import a00977249.io.DataReport;
import a00977249.personascore.PersonaScoreSorters;

/**
 * @author Siamak Pourian, A009772249
 *
 *         Gis Class, point of entry to the GIS
 */
public class Gis {

	private static final String[] FILE_NAMES = { "games.dat", "personas.dat", "players.dat", "scores.dat" };
	private static Logger LOG;

	private static final int MAX_NUM_OF_ARGS = 4;

	private File[] dataFiles;
	private String[] configInput;

	private List<Score> scoreList;
	private Map<String, Game> gameMap;
	private Map<Integer, Persona> personaMap;
	private Map<Integer, Player> playerMap;

	private List<PersonaScore> leaderBoardList;
	private Map<Integer, PlayerScore> playersReport;

	private boolean playersConfig;
	private boolean total;
	private boolean byGame;
	private boolean byCount;
	private boolean desc;
	private String platForm;

	/**
	 * Overloaded Constructor
	 */
	public Gis(String[] args, File[] files) {
		LOG.debug("Created Gis");
		this.dataFiles = files;
		this.configInput = args;
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws ApplicationException
	 */
	public static void main(String[] args) throws ApplicationException, IOException {

		File[] files = new File[FILE_NAMES.length];
		Instant startTime = Instant.now();

		LOG = LogManager.getLogger(Gis.class);
		LOG.info(startTime);

		try {
			for (int i = 0; i < FILE_NAMES.length; i++) {
				files[i] = new File(FILE_NAMES[i]);
				if (!files[i].exists()) {
					throw new FileNotFoundException(String.format("\nFile %s doesn't exist in the source directory. Try adding it to the src path.", FILE_NAMES[i]));
				}
			}
			if (args.length == 0) {
				LOG.info("No arguments were passed, Generating report...");
			}
			new Gis(args, files).run();
		} catch (FileNotFoundException e) {
			LOG.fatal(e.getMessage());
		} finally {
			Instant endTime = Instant.now();
			LOG.info(endTime);
		}
	}

	/**
	 * Initializes the players and prints them
	 * 
	 * @throws ApplicationException
	 * @throws IOException
	 */
	private void run() throws ApplicationException, IOException {
		try {
			loadAllData();

			if (configInput.length != 0) {
				readArguments(configInput);
			}

			createReportFiles();

			if (playersConfig) {
				addPlayerReportToLog();
				LOG.debug(String.format("Added %d scores to %d personas", scoreList.size(), personaMap.size()));
				LOG.debug(String.format("Leaderboard has %d entries", leaderBoardList.size()));
			}
		} catch (ApplicationException e) {
			LOG.error(e.getMessage());
		}
	}

	/**
	 * Loads the dataFiles into the collections
	 * 
	 * @throws FileNotFoundException
	 */
	private void loadAllData() throws ApplicationException, FileNotFoundException {
		int i = 0;
		gameMap = DataReader.readGame(dataFiles[i++]);
		personaMap = DataReader.readPersona(dataFiles[i++]);
		playerMap = DataReader.readPlayer(dataFiles[i++]);
		scoreList = DataReader.readScore(dataFiles[i]);

		playersReport = DataReader.readPlayerReport(scoreList, personaMap);
		leaderBoardList = DataReader.readLeaderBoardReport(scoreList, personaMap, gameMap);
	}

	/**
	 * Creates the report files
	 * 
	 * @throws IOException
	 */
	private void createReportFiles() throws IOException {
		DataReport.writeLeaderBoardReportFile(leaderBoardList, total);
		DataReport.writePlayerReportFile(playerMap, playersReport);
	}

	/**
	 * Reads the input data from command line
	 * 
	 * @param args
	 *            the command line input
	 * @throws ApplicationException
	 */
	private void readArguments(String[] args) throws ApplicationException {
		if (!(args.length <= MAX_NUM_OF_ARGS)) {
			throw new ApplicationException(String.format("%d arguments were passed. The maximum number of arguments is %d.", args.length, MAX_NUM_OF_ARGS));
		}
		if (args.length == 1 && args[0].equals("players")) {
			playersConfig = true;
		} else {
			for (int i = 0; i < args.length; i++) {
				switch (args[i].toUpperCase()) {
				case "TOTAL":
					this.total = true;
					break;
				case "BY_GAME":
					this.byGame = true;
					break;
				case "BY_COUNT":
					this.byCount = true;
					break;
				case "DESC":
					this.desc = true;
					break;
				case "PLATFORM=AN":
					this.platForm = "AN";
					break;
				case "PLATFORM=IO":
					this.platForm = "IO";
					break;
				case "PLATFORM=PC":
					this.platForm = "PC";
					break;
				case "PLATFORM=PS":
					this.platForm = "PS";
					break;
				case "PLATFORM=XB":
					this.platForm = "XB";
					break;
				case "PLAYERS":
					throw new ApplicationException("CommandLine argument 'players' must be entered alone in order to generate the console report");
				default:
					throw new ApplicationException(String.format("CommandLine argument '%s' not recognized.", args[i]));
				}
			}
		}
		if (platForm != null) {
			leaderBoardList = new PersonaScoreSorters.CompareByPlatForm().filterPlatform(leaderBoardList, platForm);
		}
		if (byGame ^ byCount) {
			if (byGame) {
				Collections.sort(leaderBoardList, new PersonaScoreSorters.CompareByGame());
			} else {
				Collections.sort(leaderBoardList, new PersonaScoreSorters.CompareByCount());
			}
		} else if (byGame && byCount) {
			throw new ApplicationException("Only one of the sort arguments is valid each run. 'by_count' and 'by_game' are mutually exclusive.");
		}
		if (desc) {
			Collections.reverse(leaderBoardList);
		}
	}

	/**
	 * Appends the Players_report to the console LOG
	 * 
	 * @throws FileNotFoundException
	 */
	private void addPlayerReportToLog() {
		File playersReportFile = new File("players_report.txt");
		try {
			if (!playersReportFile.exists()) {
				throw new FileNotFoundException(String.format("\nFile %s doesn't exist in the source directory. Try adding it to the src path.", playersReportFile.getName()));
			}
			Scanner scanner = new Scanner(playersReportFile);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			LOG.error(e.getMessage());
		}
	}
}
