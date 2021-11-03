package hu.forestwolf.repository;

import hu.forestwolf.domain.Wolf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WolfRepository extends JpaRepository<Wolf, Integer> {
    public List<Wolf> findAllByOrderByRankAsc();
}
