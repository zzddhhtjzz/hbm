/**
 * 
 */
package com.neu.msd.entities;

/**
 * @author Harsh
 *
 */
public class Activity {

	private int id;
	private String activityText;
	private int orderNo;
	private ActivityType activityType;
	private ActivityTemplate activityTemplate;
	private ActivityContainer activityContainer = new ActivityContainer();
	
	public Activity() {
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
	 * @return the activityText
	 */
	public String getActivityText() {
		return activityText;
	}

	/**
	 * @param activityText the activityText to set
	 */
	public void setActivityText(String activityText) {
		this.activityText = activityText;
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
	 * @return the activityType
	 */
	public ActivityType getActivityType() {
		return activityType;
	}

	/**
	 * @param activityType the activityType to set
	 */
	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	/**
	 * @return the activityTemplate
	 */
	public ActivityTemplate getActivityTemplate() {
		return activityTemplate;
	}

	/**
	 * @param activityTemplate the activityTemplate to set
	 */
	public void setActivityTemplate(ActivityTemplate activityTemplate) {
		this.activityTemplate = activityTemplate;
	}

	/**
	 * @return the activityContainer
	 */
	public ActivityContainer getActivityContainer() {
		return activityContainer;
	}

	/**
	 * @param activityContainer the activityContainer to set
	 */
	public void setActivityContainer(ActivityContainer activityContainer) {
		this.activityContainer = activityContainer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityContainer == null) ? 0 : activityContainer.hashCode());
		result = prime * result + ((activityTemplate == null) ? 0 : activityTemplate.hashCode());
		result = prime * result + ((activityText == null) ? 0 : activityText.hashCode());
		result = prime * result + ((activityType == null) ? 0 : activityType.hashCode());
		result = prime * result + id;
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
		Activity other = (Activity) obj;
		if (activityContainer == null) {
			if (other.activityContainer != null)
				return false;
		} else if (!activityContainer.equals(other.activityContainer))
			return false;
		if (activityTemplate == null) {
			if (other.activityTemplate != null)
				return false;
		} else if (!activityTemplate.equals(other.activityTemplate))
			return false;
		if (activityText == null) {
			if (other.activityText != null)
				return false;
		} else if (!activityText.equals(other.activityText))
			return false;
		if (activityType == null) {
			if (other.activityType != null)
				return false;
		} else if (!activityType.equals(other.activityType))
			return false;
		if (id != other.id)
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
		return "Activity [id=" + id + ", activityText=" + activityText + ", orderNo=" + orderNo + ", activityType="
				+ activityType + ", activityTemplate=" + activityTemplate + ", activityContainer=" + activityContainer
				+ "]";
	}

}
