package com.example.books.country.services;

import com.example.books.country.model.Country;
import com.example.books.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country findCountryById(int countryId){
        return countryRepository.findById(countryId).orElse(null);
    }
}
