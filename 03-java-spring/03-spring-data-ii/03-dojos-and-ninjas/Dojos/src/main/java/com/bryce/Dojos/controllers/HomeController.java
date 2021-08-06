package com.bryce.Dojos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bryce.Dojos.models.Dojo;
import com.bryce.Dojos.services.AppService;

@Controller
public class HomeController {
	@Autowired
	private AppService aService;
	
	@GetMapping("/")
	public String viewDojos(Model viewModel) {
		List<Dojo> allDojos = this.aService.allDojos();
		viewModel.addAttribute("allDojos", allDojos);
		return "index.jsp";
	}
}
