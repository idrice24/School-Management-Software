 package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Reportlist;

@Repository
public interface ReportlistRepository extends CrudRepository<Reportlist, Long> {
    
    List<Reportlist> findByName(String name);
    
}
