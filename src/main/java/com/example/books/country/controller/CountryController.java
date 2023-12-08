package com.example.books.country.controller;

import com.example.books.country.model.Country;
import com.example.books.country.repository.CountryRepository;
import com.example.books.country.body.CountryBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/countries")
    public Object getCountries(){
        List<Country> countries =  countryRepository.findAll();
        return countries;
    }

    @PostMapping("/countries")
    public String postCountries(@RequestBody CountryBody countryBody){
        try {
            Country country = new Country();
            country.setName(countryBody.getName());
            countryRepository.save(country);
            return "Ok";
        }catch (Exception e){
            return "Ooops";
        }
    }
}
