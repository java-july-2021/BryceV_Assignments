package com.bryce.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bryce.loginreg.models.User;
import com.bryce.loginreg.services.UserService;
import com.bryce.loginreg.validators.Validator;

@Controller
public class UsersController {
	@Autowired
	private UserService userService;
	@Autowired
	private Validator validator;
	
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	@RequestMapping("/login")
	public String Login() {
		return "loginPage.jsp";
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
//		IF RESULT HAS ERRORS, RETURN THE REGISTRATION PAGE
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		}
//		ELSE, SAVE THE USER IN THE DATABASE, SAVE USER ID IN SESSION, AND REDIRECT TO /HOME ROUTE
		User u = userService.registerUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
//		IF THE USER IS AUTHENTICATED, SAVE THEIR USER ID IN SESSION
		boolean isAuthenticated = userService.authenticateUser(email,  password);
		if(isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/home";
		}
//		ELSE, ADD ERROR MESSAGES AND RETURN TO THE LOGIN PAGE
		else {
			model.addAttribute("error", "Invalid Credentials. Please try again.");
			return "loginPage.jsp";
		}
	}
	
		@RequestMapping("/home")
		public String home(HttpSession session, Model model) {
//			GET USER FROM SESSION, SAVE THEM IN THE MODEL AND RETURN TO THE HOME PAGE
			Long userId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(userId);
			model.addAttribute("user", u);
			return "homePage.jsp";
		}
		@RequestMapping("/logout")
		public String logout(HttpSession session) {
//			FLUSH SESSION
			session.invalidate();
			
//			REDIRECT TO LOGIN PAGE
			return "redirect:/login";
		}
	
}
