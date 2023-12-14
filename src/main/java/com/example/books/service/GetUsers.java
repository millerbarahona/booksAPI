package com.example.books.service;

import com.example.books.model.User;
import com.example.books.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsers {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers (Example<User> userExample) {
        return userRepository.findAll(userExample);
    }
}
