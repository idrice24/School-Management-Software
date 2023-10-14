package org.idrice24.repositories.Teachers;

import org.idrice24.entities.Teachers.Takes;
import org.springframework.data.repository.CrudRepository;

public interface TakesRepository extends CrudRepository<Takes, Long> {
    Takes findById(long id);
}
