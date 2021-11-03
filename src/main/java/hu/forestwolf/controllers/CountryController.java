package hu.forestwolf.controllers;

import hu.forestwolf.domain.Country;
import hu.forestwolf.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/countries")
    public List<Country> countries(){
        return service.getCountries();
    }

    @GetMapping("/country/{id}")
    public Country country(@PathVariable(value="id") int id){
        return service.getCountry(id);
    }


}
