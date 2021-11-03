package hu.forestwolf.repository;

import hu.forestwolf.domain.Country;
import hu.forestwolf.domain.Forest;
import hu.forestwolf.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForestRepository extends JpaRepository<Forest, Integer> {

    public List<Forest> findByCountry(Country country);
    public List<Forest> findBySpecies(Species species);

}
