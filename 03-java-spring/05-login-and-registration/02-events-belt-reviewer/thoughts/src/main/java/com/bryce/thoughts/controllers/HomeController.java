package com.bryce.thoughts.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bryce.thoughts.models.Thought;
import com.bryce.thoughts.models.User;
import com.bryce.thoughts.services.ThoughtService;
import com.bryce.thoughts.services.UserService;
import com.bryce.thoughts.validators.Validator;

@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	@Autowired
	private Validator validator;
	@Autowired
	private ThoughtService tService;
	
	@GetMapping("/")
	public String loginReg(@ModelAttribute("user") User user) {
		return "login.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "login.jsp";
		}
		else {
		
			User u = uService.registerUser(user);
			session.setAttribute("userId", u.getId());
			return "redirect:/thoughts";
			}
		}
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("user") User user, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuthenticated = uService.authenticateUser(email,  password);
		if(isAuthenticated) {
			User u = uService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/thoughts";
		}
		else {
			model.addAttribute("error", "Invalid Credentials. Please try again.");
			return "login.jsp";
		}
	}
	@GetMapping("/thoughts")
	public String homePage(@ModelAttribute("thought") Thought thought, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User u = uService.findUserById(userId);
		model.addAttribute("user", u);
		
		  List<Thought> allThoughts = this.tService.allThoughts();
		  model.addAttribute("allThoughts", allThoughts);
		 
		return "thoughts.jsp";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		FLUSH SESSION
		session.invalidate();
		
//		REDIRECT TO LOGIN PAGE
		return "redirect:/";
	}
	@PostMapping("/postThought")
	public String createThought(@Valid @ModelAttribute("thought") Thought thought, BindingResult result) {
		if(result.hasErrors()) {
			return "thoughts.jsp";
		}
		else {
			this.tService.createThought(thought);
			return "redirect:/thoughts";
		}
	}
	@GetMapping("/like/{id}")
	public String likeThought(HttpSession session, @PathVariable("id") Long thoughtId) {
		Long userId = (Long)session.getAttribute("userId");
		User userToLike = this.uService.findUserById(userId);
		Thought thoughtToLike = this.tService.getSingleThought(thoughtId);
		this.tService.likeThought(thoughtToLike, userToLike);
		return "redirect:/thoughts";
	}
	@GetMapping("/unlike/{id}")
	public String unlikeThought(HttpSession session, @PathVariable("id") Long thoughtId) {
		Long userId = (Long)session.getAttribute("userId");
		User userToLike = this.uService.findUserById(userId);
		Thought thoughtToLike = this.tService.getSingleThought(thoughtId);
		this.tService.unLikeThought(thoughtToLike, userToLike);
		return "redirect:/thoughts";
	}
	@GetMapping("/edit/{id}")
	public String editThought(@PathVariable("id") Long id, @ModelAttribute("thought") Thought thought, HttpSession session, Model model) {
		Long loggedIn = (Long)session.getAttribute("userId");
		Thought thoughtEdit = this.tService.getSingleThought(id);
		if(thoughtEdit.getUser().getId() != loggedIn) {
			return "redirect:/thoughts";
		}
		model.addAttribute("thought", thoughtEdit);
		return "editThought.jsp";
	}
	@PostMapping("/edit/{id}")
	public String updateThought(@RequestParam("message") String message, Model model, @PathVariable("id") Long id, HttpSession session) {
		Thought thoughtEdit = this.tService.getSingleThought(id);
		if(message.length()<2) {
			model.addAttribute("error", "Thought too short");
			return "editThought.jsp";
		}
		else {
			thoughtEdit.setMessage(message);
			this.tService.update(thoughtEdit);
			return "redirect:/thoughts";
		}
	}
	@GetMapping("/delete/{id}")
	public String deleteThought(@PathVariable("id") Long id, @ModelAttribute("thought") Thought thought, HttpSession session, Model model) {
		Long loggedIn = (Long)session.getAttribute("userId");
		Thought thoughtEdit = this.tService.getSingleThought(id);
		if(thoughtEdit.getUser().getId() != loggedIn) {
			return "redirect:/thoughts";
		}
		this.tService.deleteThought(thoughtEdit);
		return "redirect:/thoughts";
	}
	
	
}
