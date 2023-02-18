package org.idrice24.repositories;

import org.idrice24.entities.Takes;
import org.springframework.data.repository.CrudRepository;

public interface TakesRepository extends CrudRepository<Takes, Long> {
    Takes findById(long id);
}
