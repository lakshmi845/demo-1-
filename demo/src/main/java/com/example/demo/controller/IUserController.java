package com.example.demo.controller;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.User;

public interface IUserController {
	ResponseEntity<User> register(User user);

	ResponseEntity<User> Logout(User user);

	ResponseEntity<User> Login(User user);
}