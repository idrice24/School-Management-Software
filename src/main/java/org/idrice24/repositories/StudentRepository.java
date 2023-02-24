package org.idrice24.repositories;

import org.idrice24.entities.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findById(long id);
}
