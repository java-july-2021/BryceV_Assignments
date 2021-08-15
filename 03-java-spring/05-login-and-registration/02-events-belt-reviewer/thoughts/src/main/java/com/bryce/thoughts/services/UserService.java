package com.bryce.thoughts.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.bryce.thoughts.models.User;
import com.bryce.thoughts.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}
//	REGISTER USER AND HASH THEIR PASSWORD
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
	}
//	FIND USER BY EMAIL
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
//	FIND USER BY ID
	public User findUserById(Long id) {
		Optional<User> u = userRepository.findById(id);
		
		if(u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
//	AUTHENTICATE USER
	public boolean authenticateUser(String email, String password) {
//		FIRST FIND THE USER BY EMAIL
		User user = userRepository.findByEmail(email);
//		IF WE CAN'T FIND IT BY EMAIL, RETURN FALSE
		if(user == null) {
			return false;
		} else {
//			IF THE PASSWORDS MATCH, RETURN TRUE, ELSE, RETURN FALSE
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
}
