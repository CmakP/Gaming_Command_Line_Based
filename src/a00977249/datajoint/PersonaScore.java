/**
 * Project: A00977249Assignment1
 * File: PersonaScore.java
 * Date: Jun 1, 2016
 * Time: 6:27:54 PM
 */
package a00977249.datajoint;

/**
 * @author Siamak Pourian, A009772249
 *
 *         PersonaScore Class
 */
public class PersonaScore {

	int personaId;
	int totalWin;
	int totalLoss;

	String gameName;
	String gamerTag;
	String platForm;

	/**
	 * Overloaded constructor
	 */
	public PersonaScore(int personaId, String gameName) {
		this.personaId = personaId;
		this.totalWin = 0;
		this.totalLoss = 0;
		this.gameName = gameName;
		this.gamerTag = null;
		this.platForm = null;
	}

	/**
	 * @return the personaId
	 */
	public int getPersonaId() {
		return personaId;
	}

	/**
	 * @param personaId
	 *            the personaId to set
	 */
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}

	/**
	 * @return the totalWin
	 */
	public int getTotalWin() {
		return totalWin;
	}

	/**
	 * @param totalWin
	 *            the totalWin to set
	 */
	public void setTotalWin(int totalWin) {
		this.totalWin = totalWin;
	}

	/**
	 * @return the totalLoss
	 */
	public int getTotalLoss() {
		return totalLoss;
	}

	/**
	 * @param totalLoss
	 *            the totalLoss to set
	 */
	public void setTotalLoss(int totalLoss) {
		this.totalLoss = totalLoss;
	}

	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}

	/**
	 * @param gameName
	 *            the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	/**
	 * @return the gamerTag
	 */
	public String getGamerTag() {
		return gamerTag;
	}

	/**
	 * @param gamerTag
	 *            the gamerTag to set
	 */
	public void setGamerTag(String gamerTag) {
		this.gamerTag = gamerTag;
	}

	/**
	 * @return the platForm
	 */
	public String getPlatForm() {
		return platForm;
	}

	/**
	 * @param platForm
	 *            the platForm to set
	 */
	public void setPlatForm(String platForm) {
		this.platForm = platForm;
	}

	/**
	 * Increments the total wins by one
	 */
	public void incWins() {
		totalWin++;
	}

	/**
	 * Increments the total games played by one
	 */
	public void incLoss() {
		totalLoss++;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PersonaScore [personaId=" + personaId + ", totalWin=" + totalWin + ", totalLoss=" + totalLoss + ", gameName=" + gameName + ", gamerTag=" + gamerTag + ", platForm="
				+ platForm + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gameName == null) ? 0 : gameName.hashCode());
		result = prime * result + ((gamerTag == null) ? 0 : gamerTag.hashCode());
		result = prime * result + personaId;
		result = prime * result + ((platForm == null) ? 0 : platForm.hashCode());
		result = prime * result + totalLoss;
		result = prime * result + totalWin;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof PersonaScore)) {
			return false;
		}
		PersonaScore other = (PersonaScore) obj;
		if (gameName == null) {
			if (other.gameName != null) {
				return false;
			}
		} else if (!gameName.equals(other.gameName)) {
			return false;
		}
		if (gamerTag == null) {
			if (other.gamerTag != null) {
				return false;
			}
		} else if (!gamerTag.equals(other.gamerTag)) {
			return false;
		}
		if (personaId != other.personaId) {
			return false;
		}
		if (platForm == null) {
			if (other.platForm != null) {
				return false;
			}
		} else if (!platForm.equals(other.platForm)) {
			return false;
		}
		if (totalLoss != other.totalLoss) {
			return false;
		}
		if (totalWin != other.totalWin) {
			return false;
		}
		return true;
	}
}
