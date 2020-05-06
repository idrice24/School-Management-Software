package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Worker;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {
    
    List<Worker> findById(String name);
    
}
