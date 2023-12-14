package com.example.books.controller;

import com.example.books.model.Country;
import com.example.books.repository.CountryRepository;
import com.example.books.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/countries")
    public Object getCountries(){
        List<Country> countries =  countryRepository.findAll();
        return countries;
    }

    @PostMapping("/countries")
    public String postCountries(@RequestBody CountryDTO countryDTO){
        try {
            Country country = new Country();
            country.setName(countryDTO.getName());
            countryRepository.save(country);
            return "Ok";
        }catch (Exception e){
            return "Ooops";
        }
    }
}
