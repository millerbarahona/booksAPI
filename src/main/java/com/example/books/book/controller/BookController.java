package com.example.books.book.controller;

import com.example.books.autor.model.Author;
import com.example.books.autor.services.AuthorService;
import com.example.books.book.body.BookBody;
import com.example.books.book.body.BookResponse;
import com.example.books.book.model.Book;
import com.example.books.book.repository.BookRepository;
import com.example.books.book.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public Object getBooks(Book book){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Book> bookExample = Example.of(book, matcher);
        List<Book> books = bookRepository.findAll(bookExample);
        BookResponse bookResponse = new BookResponse();
        bookResponse.setBooks(books);
        bookResponse.setMessagge("Books succesfully retrieved");
        return bookResponse;
    }

    @PostMapping("/books")
    public String postBooks(@RequestBody BookBody bookBody){
        try{
            Author author = authorService.getAuthorById(bookBody.getAuthorId());

            if(author == null) {
                return "Author with this id doesn't exists.";
            }
            Book book = new Book();
            book.setIsbn(bookBody.getIsbn());
            book.setTitle(bookBody.getTitle());
            book.setAuthor(author);
            book.setPoster(bookBody.getPoster());
            book.setEpub_url(bookBody.getEpub_url());
            book.setSynopsis(bookBody.getSynopsis());
            bookRepository.save(book);
            return "Ok";
        }catch (Exception e){
            System.out.println(e);
            return "Oopps.";
        }
    }
}