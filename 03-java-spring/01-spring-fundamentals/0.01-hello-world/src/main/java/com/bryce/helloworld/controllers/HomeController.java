package com.bryce.helloworld.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(@RequestParam(value="q") String searchQuery, Model model) {
		model.addAttribute("search", searchQuery);
		return "index.jsp";
	}
	@RequestMapping("/test")
	public String test() {
	return "/index.jsp";
	}
	

}
