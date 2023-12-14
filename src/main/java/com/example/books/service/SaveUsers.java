package com.example.books.service;

import com.example.books.dto.UserDTO;
import com.example.books.model.Gender;
import com.example.books.model.User;
import com.example.books.repository.UserRepository;
import com.example.books.utils.PasswordEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveUsers {

    @Autowired
    UserRepository userRepository;

    public String saveUser(User user) {
        try {
            PasswordEncryption passwordEncryption = new PasswordEncryption();
            String encodedPassword = passwordEncryption.encryptPassword(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);
            return "Fine";
        }catch (Exception e) {
            return "Error";
        }
    }

    public User DTOtoEntity(UserDTO userDTO) {
        Gender gender = new Gender();
        gender.setId(userDTO.getGenderId());
        User user = new User();
        user.setAge(userDTO.getAge());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setGender(gender);
        return user;
    }
}
