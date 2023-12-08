package com.example.books.book.services;

import com.example.books.autor.model.Author;
import com.example.books.autor.services.AuthorService;
import com.example.books.book.model.Book;
import com.example.books.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooksByAuthor(int authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

    public List<Book> getBooksByYear(int year) {
        return bookRepository.findByPublicationYear(year);
    }
}
