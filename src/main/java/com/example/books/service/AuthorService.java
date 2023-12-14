package com.example.books.service;

import com.example.books.model.Author;
import com.example.books.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AutorRepository autorRepository;

    public Author getAuthorById(int authorId){
        return autorRepository.findById(authorId).orElse(null);
    }
}
