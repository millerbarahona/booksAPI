package com.example.books.book.repository;

import com.example.books.autor.model.Author;
import com.example.books.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthorId(int authorId);

    List<Book> findByPublicationYear(int publicationYear);
}
