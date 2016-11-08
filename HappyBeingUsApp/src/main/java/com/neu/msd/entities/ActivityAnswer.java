/**
 * 
 */
package com.neu.msd.entities;

import java.util.List;

/**
 * @author Harsh
 *
 */
public class ActivityAnswer {
	
	private Activity activity;
	private List<Answer> answers;
	private String answerDesc;
	
	public ActivityAnswer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the activity
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	/**
	 * @return the answers
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	/**
	 * @return the answerDesc
	 */
	public String getAnswerDesc() {
		return answerDesc;
	}

	/**
	 * @param answerDesc the answerDesc to set
	 */
	public void setAnswerDesc(String answerDesc) {
		this.answerDesc = answerDesc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + ((answerDesc == null) ? 0 : answerDesc.hashCode());
		result = prime * result + ((answers == null) ? 0 : answers.hashCode());
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
		ActivityAnswer other = (ActivityAnswer) obj;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (answerDesc == null) {
			if (other.answerDesc != null)
				return false;
		} else if (!answerDesc.equals(other.answerDesc))
			return false;
		if (answers == null) {
			if (other.answers != null)
				return false;
		} else if (!answers.equals(other.answers))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ActivityAnswer [activity=" + activity + ", answers=" + answers + ", answerDesc=" + answerDesc + "]";
	}

}
