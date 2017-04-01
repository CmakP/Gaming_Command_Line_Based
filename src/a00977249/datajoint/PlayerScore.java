/**
 * Project: A00977249Assignment1
 * File: PlayerScore.java
 * Date: May 23, 2016
 * Time: 2:18:28 PM
 */
package a00977249.datajoint;

/**
 * @author Siamak Pourian, A009772249
 *
 *         PlayerScore Class
 */
public class PlayerScore {

	private int totalGamesPlayed;
	private int wins;
	private int loss;
	private int playerId;

	/**
	 * Overloaded Constructor Constructor
	 */
	public PlayerScore(int playerId) {
		this.playerId = playerId;
		totalGamesPlayed = 0;
		wins = 0;
		loss = 0;
	}

	/**
	 * @return the playerId
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId
	 *            the playerId to set
	 */
	public void setId(int playerId) {
		this.playerId = playerId;
	}

	/**
	 * @return the totalGamesPlayed
	 */
	public int getTotalGamesPlayed() {
		return totalGamesPlayed;
	}

	/**
	 * @param totalGamesPlayed
	 *            the totalGamesPlayed to set
	 */
	public void setTotalGamesPlayed(int totalGamesPlayed) {
		this.totalGamesPlayed = totalGamesPlayed;
	}

	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * @param wins
	 *            the wins to set
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}

	/**
	 * @return the loss
	 */
	public int getLoss() {
		return loss;
	}

	/**
	 * @param loss
	 *            the loss to set
	 */
	public void setLoss(int loss) {
		this.loss = loss;
	}

	/**
	 * Increments the total games played by one
	 */
	public void incTotalGames() {
		totalGamesPlayed++;
	}

	/**
	 * Increments the total wins by one
	 */
	public void incWins() {
		wins++;
	}

	/**
	 * Increments the total games played by one
	 */
	public void incLoss() {
		loss++;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayerScore [totalGamesPlayed=" + totalGamesPlayed + ", wins=" + wins + ", loss=" + loss + ", id=" + playerId + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + playerId;
		result = prime * result + loss;
		result = prime * result + totalGamesPlayed;
		result = prime * result + wins;
		return result;
	}

	/*
	 * (non-Javadoc)
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
		if (!(obj instanceof PlayerScore)) {
			return false;
		}
		PlayerScore other = (PlayerScore) obj;
		if (playerId != other.playerId) {
			return false;
		}
		if (loss != other.loss) {
			return false;
		}
		if (totalGamesPlayed != other.totalGamesPlayed) {
			return false;
		}
		if (wins != other.wins) {
			return false;
		}
		return true;
	}
}
