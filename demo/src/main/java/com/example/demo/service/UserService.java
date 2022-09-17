package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.IncorrectLoginCredentialsException;
import com.example.demo.exception.LoginException;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;


@Service
public class UserService implements IUserService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IUserRepository userRepository;

	public boolean IsLoggedIn;

	// @Override
	public User registerUser(User user) {
		LOG.info("register");
		if (userRepository.findByUserName(user.getUserName()) != null) {
			throw new UserAlreadyExistsException();

		} else {
			return userRepository.save(user);
		}
	}

//  //This method is used for logout
	@Override
	public User Logout(User user) {
		LOG.info("Servce adminlogout");
		if (IsLoggedIn == true) {
			LOG.info("You will be logged out");
			IsLoggedIn = false;
			return null;
		} else {
			LOG.warn("You need to Login first");
			throw new LoginException("You need to be login first");
		}
	}

	@Override
	public User Login(User user) {
		LOG.info("Service login");
		if (userRepository.findByUserName(user.getUserName()) == null) {
			throw new IncorrectLoginCredentialsException("Incorrect Credentials");
		} else {
			User usr = userRepository.findByUserName(user.getUserName());
			if (user.getUserName().equals(usr.getUserName())) {
				if (user.getUserPassword().equals(usr.getUserPassword())) {
					return userRepository.findByUserName(user.getUserName());
				} else {
					throw new IncorrectLoginCredentialsException("Incorrect Credentials");
				}
			}
		}

		return null;
	}
	


}