package com.example.books.repository;

import com.example.books.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Author, Integer> {
}
