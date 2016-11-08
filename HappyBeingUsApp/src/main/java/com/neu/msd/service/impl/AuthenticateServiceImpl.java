/**
 * 
 */
package com.neu.msd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neu.msd.dao.AuthenticateDao;
import com.neu.msd.entities.Daughter;
import com.neu.msd.entities.DaughterRegistration;
import com.neu.msd.entities.Mother;
import com.neu.msd.entities.MotherRegistration;
import com.neu.msd.entities.User;
import com.neu.msd.entities.UserAuthentication;
import com.neu.msd.exception.AuthenticationException;
import com.neu.msd.service.AuthenticateService;

/**
 * @author Harsh
 *
 */
@Service("authenticateService")
public class AuthenticateServiceImpl implements AuthenticateService {

	@Autowired
	private AuthenticateDao authenticateDao;

	/**
	 * 
	 */
	public AuthenticateServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.neu.msd.service.AuthenticateService#registerDaughter(com.neu.msd.
	 * entities.DaughterRegistration)
	 */
	@Transactional(rollbackFor={AuthenticationException.class})
	public int registerDaughter(DaughterRegistration daughterRegistration) throws AuthenticationException {

		MotherRegistration motherRegistration = new MotherRegistration();
		motherRegistration.setMother(daughterRegistration.getDaughter().getMother());
		// Check if the daughter has already registered mother, if not create a
		// userId for the mother.
		Mother mother = registerMother(motherRegistration);
		daughterRegistration.getDaughter().setMother(mother);
		int daughterId = authenticateDao.registerDaughter(daughterRegistration.getDaughter());
		authenticateDao.registerDaughterAuthentication(daughterId, daughterRegistration);
		return daughterId;
	}

	
	@Transactional(rollbackFor={AuthenticationException.class})
	public Mother registerMother(MotherRegistration motherRegistration) throws AuthenticationException {

		String motherEmail = motherRegistration.getMother().getEmail();
		Mother mother = getMotherByEmail(motherEmail);
		if (null == mother.getEmail() || !mother.getEmail().equalsIgnoreCase(motherEmail)) {
			return authenticateDao.createMotherWithEmail(motherEmail);
		}
		return mother;
	}
	@Transactional(rollbackFor={AuthenticationException.class})
	public User validUser(UserAuthentication userAuthentication) throws AuthenticationException {

		User user = authenticateDao.validUser(userAuthentication.getUsername(), userAuthentication.getPassword());
		return user;
	}

	private Mother getMotherByEmail(String motherEmail) throws AuthenticationException{
		return getMotherRegistrationByEmail(motherEmail).getMother();
	}

	
	@Transactional(rollbackFor={AuthenticationException.class})
	public MotherRegistration getMotherRegistrationByEmail(String motherEmail) throws AuthenticationException {
		return authenticateDao.getMotherRegistrationByEmail(motherEmail);
	}

	public int updateMotherDetails(MotherRegistration motherRegistration) throws AuthenticationException {
		return authenticateDao.updateMotherDetails(motherRegistration);
		
	}

	public String resetUnamePassword(String emailID, String username, String password) throws AuthenticationException {
		return authenticateDao.resetUnamePassword(emailID,username,password);
		
	}

	public String checkUname(String uname) throws AuthenticationException {
		// TODO Auto-generated method stub
		return authenticateDao.checkUname(uname);
	}

	public String checkEmail(String email) throws AuthenticationException {
		return authenticateDao.checkEmail(email);
	}


}
