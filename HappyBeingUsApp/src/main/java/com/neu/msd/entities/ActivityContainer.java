/**
 * 
 */
package com.neu.msd.entities;

import java.util.List;

/**
 * @author Harsh
 *
 */
public class ActivityContainer {
	
	private int activityContainerId;
	private String containerName;
	private int orderNo;
	private List<Activity> activities;
	
	public ActivityContainer() {
	}

	/**
	 * @return the activityContainerId
	 */
	public int getActivityContainerId() {
		return activityContainerId;
	}

	/**
	 * @param activityContainerId the activityContainerId to set
	 */
	public void setActivityContainerId(int activityContainerId) {
		this.activityContainerId = activityContainerId;
	}

	/**
	 * @return the containerName
	 */
	public String getContainerName() {
		return containerName;
	}

	/**
	 * @param containerName the containerName to set
	 */
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	/**
	 * @return the orderNo
	 */
	public int getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the activities
	 */
	public List<Activity> getActivities() {
		return activities;
	}

	/**
	 * @param activities the activities to set
	 */
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activities == null) ? 0 : activities.hashCode());
		result = prime * result + activityContainerId;
		result = prime * result + ((containerName == null) ? 0 : containerName.hashCode());
		result = prime * result + orderNo;
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
		ActivityContainer other = (ActivityContainer) obj;
		if (activities == null) {
			if (other.activities != null)
				return false;
		} else if (!activities.equals(other.activities))
			return false;
		if (activityContainerId != other.activityContainerId)
			return false;
		if (containerName == null) {
			if (other.containerName != null)
				return false;
		} else if (!containerName.equals(other.containerName))
			return false;
		if (orderNo != other.orderNo)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActivityContainer [activityContainerId=" + activityContainerId + ", containerName=" + containerName
				+ ", orderNo=" + orderNo + ", activities=" + activities + "]";
	}

	
}
