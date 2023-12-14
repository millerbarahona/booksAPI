package com.example.books.controller;

import com.example.books.model.Author;
import com.example.books.service.AuthorService;
import com.example.books.dto.BookDTO;
import com.example.books.book.body.BookResponse;
import com.example.books.model.Book;
import com.example.books.repository.BookRepository;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
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
    public String postBooks(@RequestBody BookDTO bookDTO){
        try{
            Author author = authorService.getAuthorById(bookDTO.getAuthorId());

            if(author == null) {
                return "Author with this id doesn't exists.";
            }
            Book book = new Book();
            book.setIsbn(bookDTO.getIsbn());
            book.setTitle(bookDTO.getTitle());
            book.setAuthor(author);
            book.setPoster(bookDTO.getPoster());
            book.setEpub_url(bookDTO.getEpub_url());
            book.setSynopsis(bookDTO.getSynopsis());
            bookRepository.save(book);
            return "Ok";
        }catch (Exception e){
            System.out.println(e);
            return "Oopps.";
        }
    }
}