package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    
    List<Course> findByName(String name);
    
}
