package com.example.ci_cd_demo.controller;

import com.example.ci_cd_demo.entity.User;
import com.example.ci_cd_demo.service.UserService;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello CI-CD";
    }

    @PostMapping("/users")
    public User createUser(@RequestParam String name){
        return userService.createUser(name);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

}
