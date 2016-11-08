/**
 * 
 */
package com.neu.msd.entities;

/**
 * @author Harsh
 *
 */
public class MotherRegistration {

	private Mother mother = new Mother();
	private String username;
	private String password;
	
	public MotherRegistration() {
		// TODO Auto-generated constructor stub
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mother == null) ? 0 : mother.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		MotherRegistration other = (MotherRegistration) obj;
		if (mother == null) {
			if (other.mother != null)
				return false;
		} else if (!mother.equals(other.mother))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MotherRegistration [mother=" + mother + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
