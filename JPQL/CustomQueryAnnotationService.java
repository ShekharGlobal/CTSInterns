package com.cts.service;

import com.cts.entity.User;
import com.cts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomQueryAnnotationService {

    @Autowired
    private UserRepository userRepository;

    // JPQL
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    // Native SQL
    public List<User> searchByUsername(String name) {
        return userRepository.searchByUsername(name);
    }
}
