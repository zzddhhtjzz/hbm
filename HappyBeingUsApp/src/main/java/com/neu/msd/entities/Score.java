/**
 * 
 */
package com.neu.msd.entities;

/**
 * @author Harsh
 *
 */
public class Score {
	
	private int id;
	private String scoreRange;
	
	public Score() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the scoreRange
	 */
	public String getScoreRange() {
		return scoreRange;
	}

	/**
	 * @param scoreRange the scoreRange to set
	 */
	public void setScoreRange(String scoreRange) {
		this.scoreRange = scoreRange;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((scoreRange == null) ? 0 : scoreRange.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (id != other.id)
			return false;
		if (scoreRange == null) {
			if (other.scoreRange != null)
				return false;
		} else if (!scoreRange.equals(other.scoreRange))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Score [id=" + id + ", scoreRange=" + scoreRange + "]";
	}
	
}
