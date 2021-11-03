package hu.forestwolf.service;

import hu.forestwolf.domain.Species;
import hu.forestwolf.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository repository;

    public List<Species> getAllSpecies(){
        return repository.findAll();
    }

    public Species getASpecies(int id){
        Optional<Species> species = repository.findById(id);
        if(species.isPresent())
            return species.get();
        return null;
    }

}
