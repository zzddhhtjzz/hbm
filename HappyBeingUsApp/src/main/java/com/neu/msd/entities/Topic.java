/**
 * 
 */
package com.neu.msd.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Harsh
 *
 */
public class Topic {
	
	private int id;
	private String topicName;
	private TopicStatus topicStatus = new TopicStatus();
	private int completedActContainers; // currActCont
	private int maxActContainers =1;//maxActCont
	private int progress;// = (int)((curr_act_cont/max_act_cont) * 100);
	private List<ActivityContainer> activityContainers = new ArrayList<ActivityContainer>();
	
	public Topic() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Topic(int id, String topicName) {
		this.id = id;
		this.topicName = topicName;
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
	 * @return the topicName
	 */
	public String getTopicName() {
		return topicName;
	}

	/**
	 * @param topicName the topicName to set
	 */
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	/**
	 * @return the activityContainers
	 */
	public List<ActivityContainer> getActivityContainers() {
		return activityContainers;
	}

	/**
	 * @param activityContainers the activityContainers to set
	 */
	public void setActivityContainers(List<ActivityContainer> activityContainers) {
		this.activityContainers = activityContainers;
	}

	/**
	 * @return the topicStatus
	 */
	public TopicStatus getTopicStatus() {
		return topicStatus;
	}

	/**
	 * @param topicStatus the topicStatus to set
	 */
	public void setTopicStatus(TopicStatus topicStatus) {
		this.topicStatus = topicStatus;
	}
	
	public void setProgress() {
		this.progress = (int)(((double)completedActContainers/ (double) maxActContainers) * 100);
	}


	/**
	 * @return the completedActContainers
	 */
	public int getCompletedActContainers() {
		return completedActContainers;
	}


	/**
	 * @param completedActContainers the completedActContainers to set
	 */
	public void setCompletedActContainers(int completedActContainers) {
		this.completedActContainers = completedActContainers;
	}


	/**
	 * @return the maxActContainers
	 */
	public int getMaxActContainers() {
		return maxActContainers;
	}


	/**
	 * @param maxActContainers the maxActContainers to set
	 */
	public void setMaxActContainers(int maxActContainers) {
		this.maxActContainers = maxActContainers;
	}


	/**
	 * @return the progress
	 */
	public int getProgress() {
		return progress;
	}


	/**
	 * @param progress the progress to set
	 */
	public void setProgress(int progress) {
		this.progress = progress;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityContainers == null) ? 0 : activityContainers.hashCode());
		result = prime * result + completedActContainers;
		result = prime * result + id;
		result = prime * result + maxActContainers;
		result = prime * result + progress;
		result = prime * result + ((topicName == null) ? 0 : topicName.hashCode());
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
		Topic other = (Topic) obj;
		if (activityContainers == null) {
			if (other.activityContainers != null)
				return false;
		} else if (!activityContainers.equals(other.activityContainers))
			return false;
		if (completedActContainers != other.completedActContainers)
			return false;
		if (id != other.id)
			return false;
		if (maxActContainers != other.maxActContainers)
			return false;
		if (progress != other.progress)
			return false;
		if (topicName == null) {
			if (other.topicName != null)
				return false;
		} else if (!topicName.equals(other.topicName))
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
		return "Topic [id=" + id + ", topicName=" + topicName + ", topicStatus=" + topicStatus
				+ ", completedActContainers=" + completedActContainers + ", maxActContainers=" + maxActContainers
				+ ", progress=" + progress + ", activityContainers=" + activityContainers + "]";
	}

}
