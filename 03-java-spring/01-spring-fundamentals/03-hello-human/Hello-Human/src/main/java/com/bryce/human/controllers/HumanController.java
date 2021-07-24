package com.bryce.human.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HumanController {
	@RequestMapping("/")
	public String index(@RequestParam(value="firstname", required=false, defaultValue="Human") String firstname,
			@RequestParam(value="lastname", required=false) String lastname, Model viewModel) {
		viewModel.addAttribute("firstname", firstname);
		viewModel.addAttribute("lastname", lastname);
		return "index.jsp";
	}
}
