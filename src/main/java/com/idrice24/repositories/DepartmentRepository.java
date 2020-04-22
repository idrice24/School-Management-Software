package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
    
    List<Department> findByName(String name);
    
}
