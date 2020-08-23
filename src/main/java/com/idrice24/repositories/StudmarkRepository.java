package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Studmark;

@Repository
public interface StudmarkRepository extends CrudRepository<Studmark, Integer> {
    
    List<Studmark> findByName(String name);
    
}
