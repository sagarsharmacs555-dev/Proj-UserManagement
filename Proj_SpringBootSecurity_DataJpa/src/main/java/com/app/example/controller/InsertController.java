package com.app.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.example.entity.UserEntity;
import com.app.example.repo.UserRepo;

@RestController
@RequestMapping("/insert")
public class InsertController {

	@Autowired
	public UserRepo userRepo;
	
	@Autowired
	public PasswordEncoder passEncoder;
	
	@PostMapping("/user")
	public String insertUser(@RequestBody UserEntity userEntity)
	{
		 userEntity.setPassword(passEncoder.encode(userEntity.getPassword()));
		 userRepo.save(userEntity);
		 return "user Saved successfully";
	}
}
