package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Work;

@Repository
public interface WorkRepository extends CrudRepository<Work, Long> {
    
    List<Work> findById(String name);
    
}
