/**
 * Project: A00977249.Assignment1
 * File: Game.java
 * Date: May 21, 2016
 * Time: 2:51:24 PM
 */
package a00977249.data;

/**
 * @author Siamak Pourian, A009772249
 *
 *         Game Class
 */
public class Game {

	public static final String GAME_DATA_FORMAT = "ID|NAME|PRODUCER";
	public static final int NUMBER_OF_GAME_DATA_ELEMENTS = 3;

	private String id;
	private String name;
	private String producer;

	/**
	 * Zero-Parameter Constructor
	 */
	public Game() {
	}

	/**
	 * Overloaded Constructor
	 */
	public Game(String id, String name, String producer) {
		this.id = id;
		this.name = name;
		this.producer = producer;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the producer
	 */
	public String getProducer() {
		return producer;
	}

	/**
	 * @param producer
	 *            the producer to set
	 */
	public void setProducer(String producer) {
		this.producer = producer;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", producer=" + producer + "]";
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
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
		if (!(obj instanceof Game)) {
			return false;
		}
		Game other = (Game) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (producer == null) {
			if (other.producer != null) {
				return false;
			}
		} else if (!producer.equals(other.producer)) {
			return false;
		}
		return true;
	}
}
