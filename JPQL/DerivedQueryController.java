package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cts.entity.User;
import com.cts.service.DerivedQueryService;

@RestController
@RequestMapping("/derived-query")
public class DerivedQueryController {

    @Autowired
    private DerivedQueryService userQueryService;
    
    //http://localhost:2024/derived-query/username/venkat
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return userQueryService.getUserByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //http://localhost:2024/derived-query/email/contains/vk@gmail.com
    @GetMapping("/email/contains/{keyword}")
    public ResponseEntity<List<User>> getUsersByEmailContaining(@PathVariable String keyword) {
        return ResponseEntity.ok(userQueryService.getUsersByEmailContaining(keyword));
    }

    // http://localhost:2024/derived-query/search?username=venkat&email=vk@gmail.com

    @GetMapping("/search")
    public ResponseEntity<List<User>> getUsersByUsernameAndEmail(
            @RequestParam String username,
            @RequestParam String email) {
        return ResponseEntity.ok(userQueryService.getUsersByUsernameAndEmail(username, email));
    }

    // http://localhost:2024/derived-query/username/starts-with/ra

    @GetMapping("/username/starts-with/{prefix}")
    public ResponseEntity<List<User>> getUsersByUsernameStartingWith(@PathVariable String prefix) {
        return ResponseEntity.ok(userQueryService.getUsersByUsernameStartingWith(prefix));
    }
}
