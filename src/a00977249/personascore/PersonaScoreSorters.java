/**
 * Project: A00977249Assignment1
 * File: ScoreSorters.java
 * Date: Jun 2, 2016
 * Time: 6:22:30 PM
 */
package a00977249.personascore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import a00977249.datajoint.PersonaScore;

/**
 * @author Siamak Pourian, A009772249
 *
 *         ScoreSorters Class
 */
public class PersonaScoreSorters {

	/**
	 * CompareByGame Class
	 * 
	 * Sorts the report by Game name ascending
	 */
	public static class CompareByGame implements Comparator<PersonaScore> {

		@Override
		public int compare(PersonaScore ps1, PersonaScore ps2) {
			return ps1.getGameName().compareTo(ps2.getGameName());
		}
	}

	/**
	 * CompareByCount Class
	 * 
	 * Sorts the report by Game played count ascending
	 */
	public static class CompareByCount implements Comparator<PersonaScore> {

		@Override
		public int compare(PersonaScore ps1, PersonaScore ps2) {
			return (ps1.getTotalWin() + ps1.getTotalLoss()) - (ps2.getTotalWin() + ps2.getTotalLoss());
		}
	}

	/**
	 * CompareByPlatForm Class
	 * 
	 * Sorts the report by Game name ascending
	 */
	public static class CompareByPlatForm {

		public List<PersonaScore> filterPlatform(List<PersonaScore> leaderBoardList, String platForm) {

			List<PersonaScore> filteredListByPlatForm = new ArrayList<PersonaScore>();
			for (PersonaScore personaScore : leaderBoardList) {
				if (personaScore.getPlatForm().equals(platForm)) {
					filteredListByPlatForm.add(personaScore);
				}
			}
			Collections.sort(filteredListByPlatForm, new CompareByGame());
			return filteredListByPlatForm;
		}
	}

}
