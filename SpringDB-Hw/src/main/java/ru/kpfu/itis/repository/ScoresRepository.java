package ru.kpfu.itis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Scores;

@Repository
public interface ScoresRepository extends CrudRepository<Scores, Long>{
}
