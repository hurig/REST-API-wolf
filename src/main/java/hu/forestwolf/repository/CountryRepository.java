package hu.forestwolf.repository;

import hu.forestwolf.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    public Country findByName(String name);
    public List<Country> findAllByOrderByNameAsc();

}
