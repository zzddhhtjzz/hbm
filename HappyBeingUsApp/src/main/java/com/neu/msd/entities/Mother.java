/**
 * 
 */
package com.neu.msd.entities;

import java.util.List;

/**
 * @author NISHA
 *
 */
public class Mother extends User {

	private List<User> daughters;
	
	public Mother() {
		UserType userType = new UserType();
		userType.setUserType("Mother");
		this.setUserType(userType);
	}

	/**
	 * @return the daughters
	 */
	public List<User> getDaughters() {
		return daughters;
	}

	/**
	 * @param daughters the daughters to set
	 */
	public void setDaughters(List<User> daughters) {
		this.daughters = daughters;
	}
	
	
}
