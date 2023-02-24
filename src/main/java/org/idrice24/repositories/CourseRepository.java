package org.idrice24.repositories;

import org.idrice24.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findById(long id);
}