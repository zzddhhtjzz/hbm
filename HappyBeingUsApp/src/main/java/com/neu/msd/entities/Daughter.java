/**
 * 
 */
package com.neu.msd.entities;

/**
 * @author NISHA
 *
 */
public class Daughter extends User {
	
	private Mother mother = new Mother();
	
	public Daughter() {
		UserType userType = new UserType();
		userType.setUserType("Daughter");
		this.setUserType(userType);
	}

	/**
	 * @return the mother
	 */
	public Mother getMother() {
		return mother;
	}

	/**
	 * @param mother the mother to set
	 */
	public void setMother(Mother mother) {
		this.mother = mother;
	}


	
}
