package com.example.Employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
	@GetMapping("")
	public String webPage() {
		return "webPage";
	}
	
	@GetMapping("/add")
	public String adding() {
		return "addingEmp";
	}
}
