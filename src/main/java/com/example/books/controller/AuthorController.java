package com.example.books.controller;

import com.example.books.dto.AuthorDTO;
import com.example.books.model.Author;
import com.example.books.repository.AutorRepository;
import com.example.books.model.Country;
import com.example.books.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
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
    public String postAuthors (@RequestBody AuthorDTO authorDTO) {
        try{
            Country country = countryService.findCountryById(authorDTO.getCountryId());
            if (country == null) {
                return "Country with this id doesn't exits.";
            }
            Author author = new Author();
            author.setCountry(country);
            author.setName(authorDTO.getName());
            autorRepository.save(author);
            return "Ok";
        }catch (Exception e) {
            System.out.println(e);
            return "Ooops";
        }
    }

}
