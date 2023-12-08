package com.example.books.autor.controller;

import com.example.books.autor.body.AuthorBody;
import com.example.books.autor.model.Author;
import com.example.books.autor.repository.AutorRepository;
import com.example.books.country.model.Country;
import com.example.books.country.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    private CountryService countryService;

    @GetMapping("/authors")
    public Object getAuthors () {
        List<Author> authors = autorRepository.findAll();
        return authors;
    }

    @PostMapping("/authors")
    public String postAuthors (@RequestBody AuthorBody authorBody) {
        try{
            Country country = countryService.findCountryById(authorBody.getCountryId());
            if (country == null) {
                return "Country with this id doesn't exits.";
            }
            Author author = new Author();
            author.setCountry(country);
            author.setName(authorBody.getName());
            autorRepository.save(author);
            return "Ok";
        }catch (Exception e) {
            System.out.println(e);
            return "Ooops";
        }
    }

}
