package com.rastreiofacil.rastreamento_correios.controller;

import com.rastreiofacil.rastreamento_correios.model.User;
import com.rastreiofacil.rastreamento_correios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public User getUserByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }

}
