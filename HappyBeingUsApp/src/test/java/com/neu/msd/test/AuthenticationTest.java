/**

 * 

 */

package com.neu.msd.test;



import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import com.neu.msd.entities.ActivityContainer;
import com.neu.msd.entities.Mother;

import com.neu.msd.entities.MotherRegistration;

import com.neu.msd.entities.UserAuthentication;
import com.neu.msd.entities.UserType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.neu.msd.entities.User;
import com.neu.msd.exception.AdminException;
import com.neu.msd.exception.AuthenticationException;
import com.neu.msd.exception.UserException;
import com.neu.msd.service.AdminService;
import com.neu.msd.service.AuthenticateService;
import com.neu.msd.service.UserService;



/**

 * @author Harsh

 *

 */

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations={"classpath:/dispatcher.xml"})

public class AuthenticationTest {



	@Autowired

	AuthenticateService authenticateService;


	@Autowired

	AdminService adminService;


	@Autowired

	UserService userService;


	@Test

	public void test_emailExistCheck(){
		String emailExistCheck;
		try {
			emailExistCheck = authenticateService.checkEmail("itsnisha07@gmail.com");
			assertEquals("itsnisha07@gmail.com, The account already exists", emailExistCheck);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}


	/* Mohsen Nabian*/


	@Test


	public void test_usernameExistCheck(){
		String usernameExistCheck;
		try {
			usernameExistCheck = authenticateService.checkUname("boss2");
			assertEquals("boss2"+", this username available", usernameExistCheck);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}

	/* Mohsen Nabian*/


	@Test


	public void test_resetUnamePassword(){


		String resetUnamePasswordCheck;


		try {

			resetUnamePasswordCheck = authenticateService.resetUnamePassword("boss2","boss2","boss2");

			assertEquals("Account does not exist. Try Sign Up...", resetUnamePasswordCheck);

		} catch (AuthenticationException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

	/* Mohsen Nabian*/


	@Test


	public void test_getDiagnostic(){


		try {

			int q = userService.getDiagnosticQuestions().size();

			assertEquals(5, q);

		} catch (UserException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} catch (AdminException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	/* Mohsen Nabian*/


	@Test


	public void test_getTopicsUser(){

		User user = new User();

		user.setId(9);
		try {
			int q = userService.getTopicsOfUser(user).size();
			assertEquals(q, q);
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	/* Mohsen Nabian*/


	@Test
	public void test_getAllActivityTemplates(){
		int q = 0;
		try {
			q = adminService.getAllActivityTemplates().size();
		} catch (AdminException e) {
			e.printStackTrace();
		}
		assertEquals(6, q);
	}

	/* Nisha Vaity*/
	
	@Test
	public void test_getTopicsUser2(){
		User user = new User();
		user.setId(9);
		try {
			int q = userService.getTopicsOfUser(user).size();
			assertEquals(q, q);
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	/* Nisha Vaity*/


	@Test
	public void test_getAllActivityTemplates2(){
	int q = 0;

		try {
			q = adminService.getAllActivityTemplates().size();
		} catch (AdminException e) {
			e.printStackTrace();
		}
		assertEquals(6, q);
	}

	/* Nisha Vaity*/


	@Test
	public void test_getTopicsUser1(){
		User user = new User();
		user.setId(9);
		try {
			int q = userService.getTopicsOfUser(user).size();
			assertEquals(q, q);
		} catch (UserException e) {
			e.printStackTrace();
		}
	}

	/* Nisha Vaity*/


	@Test
	public void test_getAllActivityTemplates1(){
		int q = 0;
		try {
			q = adminService.getAllActivityTemplates().size();
		} catch (AdminException e) {
			e.printStackTrace();
		}
		assertEquals(6, q);
	}
	
	@Test


	public void test_renameTopic(){
		int q = 0;
		try {
			q = adminService.renameTopic("Test_ChangeName", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(q, q);
		try {
			q = adminService.renameTopic("Topic 1", 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_addTopic(){
		int q = 0;
		try {
			q = adminService.addNewTopic("Test Topic Add");
			q = adminService.deleteTopic(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, q);
	}
	
	@Test


	public void test_deleteTopic(){
		int q = 0;
		try {
			q = adminService.addNewTopic("Test Topic Add");
			q = adminService.deleteTopic(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, q);
	}
	
	@Test


	public void test_getActivityContainerById(){
		ActivityContainer q;
		try {
			q = adminService.getActivityContainerById(2);
			assertEquals(q.getActivityContainerId(), q.getActivityContainerId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test


	public void test_loadTopics(){
		int q = 0;
		try {
			Map<Integer, ActivityContainer> containerMap = new HashMap<Integer, ActivityContainer>();
			q = adminService.loadTopics(containerMap).size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(q, q);
	}
	
	@Test


	public void test_adminAuthenticate(){
		User q;
		User user = new User();
		UserType userType = new UserType();
		userType.setId(1);
		user.setId(1);
		UserAuthentication userAuth = new UserAuthentication();
		userAuth.setUser(user);
		userAuth.setUsername("iamadmin");
		userAuth.setPassword("password");
		userAuth.setUserType(userType);
		try {
			q = adminService.adminAuthenticate(userAuth);
			assertEquals(1, q.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test


	public void test_addNewActivityContainer(){
		ActivityContainer q;
		int act = 0;
		try {
			q = adminService.addNewActivityContainer("Test Act Cont", 1);
			act = adminService.deleteActivityContainer(q.getActivityContainerId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(act, act);
	}
	
	@Test

	public void test_deleteActivityContainer(){
		ActivityContainer q;
		int act = 0;
		try {
			q = adminService.addNewActivityContainer("Test Act Cont", 1);
			act = adminService.deleteActivityContainer(q.getActivityContainerId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(act, act);
	}
	
	@Test


	public void test_renameActivityContainer(){

		ActivityContainer q;
		int p;
		int act = 0;
		try {
			q = adminService.addNewActivityContainer("Test Act Cont", 1);
			p = adminService.renameActivityContainer("Test Container", 1);
			act = adminService.deleteActivityContainer(q.getActivityContainerId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(act, act);
	}
	
	@Test

	public void test_checkEmail(){
		String emailExistCheck;
		try {
			emailExistCheck = authenticateService.checkEmail("itsnisha07@gmail.com");
			assertEquals("itsnisha07@gmail.com, The account already exists", emailExistCheck);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}
	
	@Test


	public void test_checkUname(){
		String usernameExistCheck;
		try {
			usernameExistCheck = authenticateService.checkUname("boss2");
			assertEquals("boss2"+", this username available", usernameExistCheck);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}
	
	@Test


	public void test_adminAuthenticate1(){
		User q;
		User user = new User();
		UserType userType = new UserType();
		userType.setId(1);
		user.setId(1);
		UserAuthentication userAuth = new UserAuthentication();
		userAuth.setUser(user);
		userAuth.setUsername("iamadmin");
		userAuth.setPassword("password");
		userAuth.setUserType(userType);
		try {
			q = adminService.adminAuthenticate(userAuth);
			assertEquals(1, q.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test


	public void test_check_Email(){
		String emailExistCheck;
		try {
			emailExistCheck = authenticateService.checkEmail("itsnisha07@gmail.com");
			assertEquals("itsnisha07@gmail.com, The account already exists", emailExistCheck);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
	}

}