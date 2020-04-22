package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.School;

@Repository
public interface SchoolRepository extends CrudRepository<School, Long> {
    
    List<School> findByName(String name);
    
}
