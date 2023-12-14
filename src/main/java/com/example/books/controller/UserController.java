package com.example.books.controller;

import com.example.books.dto.UserDTO;
import com.example.books.model.User;
import com.example.books.service.GetUsers;
import com.example.books.service.SaveUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    GetUsers getUsers;
    @Autowired
    SaveUsers saveUsers;

    @GetMapping("/users")
    public Object getUsers(User user) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<User> userExample = Example.of(user, matcher);
        System.out.println(userExample.toString());
        List<User> userList = getUsers.getUsers(userExample);
        return userList;
    }

    @PostMapping("/users")
    public String postUsers(@RequestBody UserDTO userDTO) {
        try {
            User user = saveUsers.DTOtoEntity(userDTO);
            saveUsers.saveUser(user);
            return "User saved succesfully";
        }catch (Exception e){
            return "Error saving user";
        }
    }
}
