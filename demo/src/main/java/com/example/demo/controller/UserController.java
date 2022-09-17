package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController implements IUserController {
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		LOG.info("Controller register");
		User us = userService.registerUser(user); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This user is added to the database.");
		LOG.info(headers.toString());
		ResponseEntity<User> response = new ResponseEntity<>(us, headers, HttpStatus.OK);
		return response;
	}

	@PostMapping("/login")
	public ResponseEntity<User> Login(@RequestBody User user) {
		LOG.info("Controller logInAppUser");
		User app = userService.Login(user);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Logged in successful...");
		LOG.info(headers.toString());
		ResponseEntity<User> response = new ResponseEntity<>(app, headers, HttpStatus.OK);
		return response;
	}

	@PostMapping("/logout")
	public ResponseEntity<User> Logout(@RequestBody User user) {
		LOG.info("Controller adminLogout");
		User usr = userService.Logout(user);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User logged out sucessfully");
		ResponseEntity<User> response = new ResponseEntity<User>(usr, headers, HttpStatus.OK);
		return response;

	}

}