package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.idrice24.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    
    List<Student> findByName(String name);
    
    
    
}
