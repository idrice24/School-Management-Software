package org.idrice24.repositories;

import org.idrice24.entities.Teachers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teachers, Long> {
    Teachers findById(long id);
}
