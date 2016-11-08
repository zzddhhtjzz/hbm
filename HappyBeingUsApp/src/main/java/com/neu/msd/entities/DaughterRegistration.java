/**
 * 
 */
package com.neu.msd.entities;

/**
 * @author NISHA
 *
 */
public class DaughterRegistration {
	
	private Daughter daughter = new Daughter();
	private String username;
	private String password;
	
	public DaughterRegistration() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the daughter
	 */
	public Daughter getDaughter() {
		return daughter;
	}

	/**
	 * @param daughter the daughter to set
	 */
	public void setDaughter(Daughter daughter) {
		this.daughter = daughter;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
