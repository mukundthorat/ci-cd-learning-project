package com.example.ci_cd_demo.service;

import com.example.ci_cd_demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    void testCreateUser(){
        User user=userService.createUser("Mukund");
        assertNotNull(user.getId());
        assertEquals("Mukund",user.getName());
    }

    void testGetAllUsers(){
        userService.createUser("TestUser");
        List<User> users=userService.getAllUsers();
        assertTrue(users.size()>0);
    }
}
