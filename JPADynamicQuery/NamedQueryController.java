package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.User;
import com.cts.service.NamedQueryService;

@RestController
@RequestMapping("/api/users")
public class NamedQueryController {

    @Autowired
    private NamedQueryService namedqueryservice;

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return namedqueryservice.findUserByEmail(email);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return namedqueryservice.findAllUsers();
    }
}