/**
 * 
 */
package com.neu.msd.dao;

import com.neu.msd.entities.Daughter;
import com.neu.msd.entities.DaughterRegistration;
import com.neu.msd.entities.Mother;
import com.neu.msd.entities.MotherRegistration;
import com.neu.msd.entities.User;
import com.neu.msd.exception.AuthenticationException;

/**
 * @author Harsh
 *
 */
public interface AuthenticateDao {
	
	public int registerDaughter(Daughter daughter) throws AuthenticationException;

	public MotherRegistration getMotherRegistrationByEmail(String motherEmail) throws AuthenticationException;

	public Mother createMotherWithEmail(String email) throws AuthenticationException;

	public int registerDaughterAuthentication(int daughterId, DaughterRegistration daughterRegistration) throws AuthenticationException;

	public User validUser(String username, String password) throws AuthenticationException;

	public int updateMotherDetails(MotherRegistration motherRegistration) throws AuthenticationException;

	public String resetUnamePassword(String emailID, String username, String password) throws AuthenticationException;

	public String checkUname(String uname)throws AuthenticationException;

	public String checkEmail(String email)throws AuthenticationException;
}
