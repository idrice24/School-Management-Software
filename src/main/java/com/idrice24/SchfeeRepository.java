package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Schfee;

@Repository
public interface SchfeeRepository extends CrudRepository<Schfee, Long> {
    
    List<Schfee> findByName(String name);
    
}
