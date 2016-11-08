/**
 * 
 */
package com.neu.msd.service;

import com.neu.msd.entities.DaughterRegistration;
import com.neu.msd.entities.Mother;
import com.neu.msd.entities.MotherRegistration;
import com.neu.msd.entities.User;
import com.neu.msd.entities.UserAuthentication;
import com.neu.msd.exception.AuthenticationException;

/**
 * @author Harsh
 *
 */
public interface AuthenticateService {
	
	public int registerDaughter(DaughterRegistration daughterRegistration) throws AuthenticationException;
	
	public Mother registerMother(MotherRegistration motherRegistration) throws AuthenticationException;
	
	public MotherRegistration getMotherRegistrationByEmail(String motherEmail) throws AuthenticationException;
	
	public User validUser(UserAuthentication userAuthentication) throws AuthenticationException;

	public int updateMotherDetails(MotherRegistration motherRegistration) throws AuthenticationException;

	public String resetUnamePassword(String emailID, String username, String password)throws AuthenticationException;

	public String checkUname(String uname)throws AuthenticationException;

	public String checkEmail(String email)throws AuthenticationException;
	
}
