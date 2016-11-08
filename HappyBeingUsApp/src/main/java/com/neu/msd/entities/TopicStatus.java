/**
 * 
 */
package com.neu.msd.entities;

/**
 * @author Harsh
 *
 */
public class TopicStatus {

	private int id;
	private String topicStatus;
	
	public TopicStatus() {
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
	 * @return the topicStatus
	 */
	public String getTopicStatus() {
		return topicStatus;
	}

	/**
	 * @param topicStatus the topicStatus to set
	 */
	public void setTopicStatus(String topicStatus) {
		this.topicStatus = topicStatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((topicStatus == null) ? 0 : topicStatus.hashCode());
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
		TopicStatus other = (TopicStatus) obj;
		if (id != other.id)
			return false;
		if (topicStatus == null) {
			if (other.topicStatus != null)
				return false;
		} else if (!topicStatus.equals(other.topicStatus))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TopicStatus [id=" + id + ", topicStatus=" + topicStatus + "]";
	}
	
}
