package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Studlist;

@Repository
public interface StudlistRepository extends CrudRepository<Studlist, Long> {
    
    List<Studlist> findByName(String name);
    
}
