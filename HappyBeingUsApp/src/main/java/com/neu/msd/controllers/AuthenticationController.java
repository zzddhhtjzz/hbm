/**
 * 
 */
package com.neu.msd.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.msd.entities.Daughter;
import com.neu.msd.entities.DaughterRegistration;
import com.neu.msd.entities.MotherRegistration;
import com.neu.msd.entities.User;
import com.neu.msd.entities.UserAuthentication;
import com.neu.msd.exception.AuthenticationException;
import com.neu.msd.service.AuthenticateService;
import com.neu.msd.service.UserService;

/**
 * @author NISHA
 *
 */
@Controller
public class AuthenticationController {
	
	@Autowired
	private AuthenticateService authenticateService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/landingPage.action", method=RequestMethod.GET)
	public String loadLandingPage(Model model, HttpSession httpSession){
		
		DaughterRegistration daughterRegistration = new DaughterRegistration();
		MotherRegistration motherRegistration = new MotherRegistration();
		if(!model.containsAttribute("motherRegistration")){
			model.addAttribute("motherRegistration", motherRegistration);
		}
		
		model.addAttribute("daughterRegistration", daughterRegistration);			
			
		return "landingPage";
	}

	@RequestMapping(value="/signUp.action", method=RequestMethod.POST)
	public String registerDaughter(@ModelAttribute("daughterRegistration") DaughterRegistration daughterRegistration, 
			Model model, HttpSession httpSession){
		try {
			
			int uId = authenticateService.registerDaughter(daughterRegistration);
			Daughter daughter = daughterRegistration.getDaughter();
			daughter.setId(uId);
			daughter.getUserType().setId(3);
			daughter.setDiagnosticTaken(false);
			httpSession.setAttribute("user", daughter);
			return loadLandingPage(model, httpSession);
			
		} catch (AuthenticationException e) {
			return "errorPage";
		}
	}
	
	@RequestMapping(value="/getMotherByEmail.action", method=RequestMethod.POST)
	public String getMotherByEmail(@RequestParam("emailID") String emailID, Model model, HttpSession session){
		
		try {
			MotherRegistration motherRegistration = authenticateService.getMotherRegistrationByEmail(emailID);
			
//			DaughterRegistration daughterRegistration = new DaughterRegistration();
//			model.addAttribute("daughterRegistration", daughterRegistration);
			model.addAttribute("motherRegistration", motherRegistration);

			String invalidMotherEmailErr ="";

			if(motherRegistration.getMother().getId() == 0){
				invalidMotherEmailErr ="Please check the emailId you have entered.";
				model.addAttribute("motherRegister", "false");
				model.addAttribute("motherRegisterErr", invalidMotherEmailErr);
			}else if(null != motherRegistration.getUsername()){
				invalidMotherEmailErr ="The account already exists, please log in...";
			model.addAttribute("motherRegister", "false");
				model.addAttribute("motherRegisterErr", invalidMotherEmailErr);
			}
			else{
				
				model.addAttribute("motherRegister", "true");
			}
		
			return loadLandingPage(model, session);
			
		} catch (AuthenticationException e) {
			return "errorPage";
		}
	}

	@RequestMapping(value="/Login.action", method=RequestMethod.POST)
	public String loginUser(@ModelAttribute("userAuthentication") UserAuthentication userAuthentication, 
			Model model, HttpSession session){
		
//		TODO 
		try {
			User user=authenticateService.validUser(userAuthentication);
			if (user==null)
			{
				DaughterRegistration daughterRegistration = new DaughterRegistration();
				MotherRegistration motherRegistration = new MotherRegistration();
				model.addAttribute("daughterRegistration", daughterRegistration); 
				model.addAttribute("motherRegistration", motherRegistration); 
				model.addAttribute("usernameerr", "false");
				return "landingPage";
			}
			else{
				session.setAttribute("user", user);
				return loadLandingPage(model, session);
			}
			
		} catch (AuthenticationException e) {
			return "errorPage";
		}
	}
	
	@RequestMapping(value="/topicPage.action", method=RequestMethod.POST)
	public String registerMother(@ModelAttribute("motherRegistration") MotherRegistration motherRegistration, Model model, HttpSession httpSession){
		
		try {
			int records = authenticateService.updateMotherDetails(motherRegistration);
			httpSession.setAttribute("user", motherRegistration.getMother());
			return loadLandingPage(model, httpSession);
//			put user in the session
//			return to landing page
		} catch (AuthenticationException e) {
			return "errorPage";
		}
	}
	@RequestMapping(value="/forgotPassword.action", method=RequestMethod.POST)
	public String resetUnamePassword(@RequestParam("emailID") String emailID, @RequestParam("username") String username, 
			@RequestParam("password") String password, Model model, HttpSession httpSession){
		
		try {
			String status = authenticateService.resetUnamePassword(emailID,username,password);
			httpSession.removeAttribute("user");
			return loadLandingPage(model, httpSession);
//			remove user from the session before returning to the landing page
		} catch (AuthenticationException e) {
			return "errorPage";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/checkUsernameAvailability.action", method = RequestMethod.POST)
	public String checkUsernameAvailability(@RequestParam("userName") String uname)
	{
		try {
			return authenticateService.checkUname(uname);
		} catch (AuthenticationException e) {
			return "error";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/checkEmailExists.action", method = RequestMethod.POST)
	public String checkEmailExists(@RequestParam("email") String email)
	{
		try {
			return authenticateService.checkEmail(email);
		} catch (AuthenticationException e) {
			return "error";
		}
	}
	
	@RequestMapping(value="/logout.action", method=RequestMethod.GET)
	public String logoutUser(HttpSession httpSession, Model model){
		if(httpSession != null)
			httpSession.invalidate();
		return loadLandingPage(model, httpSession);
	}
	
	@InitBinder
	public void anyNameHere(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
		
	}
}
