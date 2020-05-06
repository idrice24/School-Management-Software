package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    
    List<Teacher> findByName(String teach_id);
    
}
