/**
 * Project: A00977249.Assignment1
 * File: Persona.java
 * Date: May 21, 2016
 * Time: 2:51:24 PM
 */
package a00977249.data;

/**
 * @author Siamak Pourian, A009772249
 *
 *         Persona Class
 */
public class Persona {

	public static final String PERSONA_DATA_FORMAT = "ID|PLAYER_ID|GAMERTAG|PLATFORM";
	public static final int NUMBER_OF_PERSONA_DATA_ELEMENTS = 4;

	private int id;
	private int playerId;

	private String gamerTag;
	private String platForm;

	/**
	 * Zero-Parameter Constructor
	 */
	public Persona() {
	}

	/**
	 * Overloaded Constructor
	 */
	public Persona(int id, int playerId, String gamerTag, String platForm) {
		this.id = id;
		this.playerId = playerId;
		this.gamerTag = gamerTag;
		this.platForm = platForm;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
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

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Persona [id=" + id + ", playerId=" + playerId + ", gamerTag=" + gamerTag + ", platForm=" + platForm + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gamerTag == null) ? 0 : gamerTag.hashCode());
		result = prime * result + id;
		result = prime * result + ((platForm == null) ? 0 : platForm.hashCode());
		result = prime * result + playerId;
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
		if (!(obj instanceof Persona)) {
			return false;
		}
		Persona other = (Persona) obj;
		if (gamerTag == null) {
			if (other.gamerTag != null) {
				return false;
			}
		} else if (!gamerTag.equals(other.gamerTag)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (platForm == null) {
			if (other.platForm != null) {
				return false;
			}
		} else if (!platForm.equals(other.platForm)) {
			return false;
		}
		if (playerId != other.playerId) {
			return false;
		}
		return true;
	}
}
