package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Speciality;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
    
    List<Speciality> findByName(String name);
    
}
