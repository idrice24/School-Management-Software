package org.idrice24.repositories.Admin;

import org.idrice24.entities.Admin.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Course findById(long id);
}