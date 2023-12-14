package com.example.books.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryption {
    private  final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String encryptPassword (String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public boolean matches (String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public boolean isPasswordValid (String rawPassword, String encodedPassword) {
        return matches(rawPassword, encodedPassword);
    }
}
