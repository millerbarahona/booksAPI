package com.example.books.autor.services;

import com.example.books.autor.model.Author;
import com.example.books.autor.repository.AutorRepository;
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
