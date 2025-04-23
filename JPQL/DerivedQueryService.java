package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.User;
import com.cts.repository.UserRepository;

@Service
public class DerivedQueryService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getUsersByEmailContaining(String keyword) {
        return userRepository.findByEmailContaining(keyword);
    }

    public List<User> getUsersByUsernameAndEmail(String username, String email) {
        return userRepository.findByUsernameAndEmail(username, email);
    }

    public List<User> getUsersByUsernameStartingWith(String prefix) {
        return userRepository.findByUsernameStartingWith(prefix);
    }
}
