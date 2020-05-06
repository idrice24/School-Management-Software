package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Examtt;

@Repository
public interface ExamttRepository extends CrudRepository<Examtt, Long> {
    
    List<Examtt> findByDate(String date);
    
}
