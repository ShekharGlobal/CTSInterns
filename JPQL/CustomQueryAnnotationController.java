package com.cts.controller;

import com.cts.entity.User;
import com.cts.service.CustomQueryAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query")
public class CustomQueryAnnotationController {

    @Autowired
    private CustomQueryAnnotationService userQueryService;

    // JPQL Query
    //http://localhost:2024/query/email/vk@gmail.com
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userQueryService.getUserByEmail(email);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // Native SQL Query
    //http://localhost:2024/query/username/search/venkat
    @GetMapping("/username/search/{name}")
    public ResponseEntity<List<User>> searchByUsername(@PathVariable String name) {
        List<User> users = userQueryService.searchByUsername(name);
        return ResponseEntity.ok(users);
    }
}
