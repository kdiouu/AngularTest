package com.projectcompany.Projectname.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class hellocontroller {
	
	@RequestMapping("/s")
	public String toIndex() {
		return "index";
	}
}
