package hu.forestwolf.service;

import hu.forestwolf.domain.Country;
import hu.forestwolf.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public List<Country> getCountries(){
        return repository.findAll();
    }

    public Country getCountry(int id) {
        Optional<Country> c = repository.findById(id);
        return c.get();
    }

    public List<Country> getCountries2(){
        return repository.findAllByOrderByNameAsc();
    }
}
