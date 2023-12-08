package com.example.books.autor.repository;

import com.example.books.autor.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Author, Integer> {
}
