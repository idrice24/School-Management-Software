package com.idrice24.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.idrice24.entities.Classe;

@Repository
public interface ClasseRepository extends CrudRepository<Classe, Long> {

    List<Classe> findByName(String name);

}
