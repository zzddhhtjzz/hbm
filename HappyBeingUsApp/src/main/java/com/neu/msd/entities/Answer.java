/**
 * 
 */
package com.neu.msd.entities;

/**
 * @author Harsh
 *
 */
public class Answer {

	private int id;
	private String answerText;
	private int orderNo;
	private boolean isCorrect;
	private boolean isRightanswer;
	public Answer() {
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
	 * @return the answerText
	 */
	public String getAnswerText() {
		return answerText;
	}

	/**
	 * @param answerText the answerText to set
	 */
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
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
	 * @return the isCorrect
	 */
	public boolean getIsCorrect() {
		return isCorrect;
	}

	/**
	 * @param isCorrect the isCorrect to set
	 */
	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerText == null) ? 0 : answerText.hashCode());
		result = prime * result + (isCorrect ? 1231 : 1237);
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
		Answer other = (Answer) obj;
		if (answerText == null) {
			if (other.answerText != null)
				return false;
		} else if (!answerText.equals(other.answerText))
			return false;
		if (isCorrect != other.isCorrect)
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
		return "Answer [id=" + id + ", answerText=" + answerText + ", orderNo=" + orderNo + ", isCorrect=" + isCorrect
				+ "]";
	}

	public boolean getIsRightanswer() {
		return isRightanswer;
	}

	public void setIsRightanswer(boolean isRightanswer) {
		this.isRightanswer = isRightanswer;
	}

}
