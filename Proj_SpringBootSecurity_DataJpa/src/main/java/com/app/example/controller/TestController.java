package com.app.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/home")
	public String home()
	{
		return "homepage";
	}
	
	@GetMapping("/user")
	public String getUser()
	{
		return "userpage";
	}
	
	@GetMapping("/admin")
	public String getAdmin()
	{
		return "adminpage";
	}

}
