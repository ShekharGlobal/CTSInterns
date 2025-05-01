package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.User;
import com.cts.exception.UserNotFoundException;
import com.cts.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/*
	 * public UserService(UserRepository userRepository) { this.userRepository =
	 * userRepository; }
	 */

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User updatedUser) {
User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

		existingUser.setUsername(updatedUser.getUsername());
		existingUser.setEmail(updatedUser.getEmail());

		return userRepository.save(existingUser);
	}

	public void deleteUserById(Long id) {
		if (!userRepository.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		userRepository.deleteById(id);
	}
}
