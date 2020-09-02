package com.idrice24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idrice24.entities.Classe;
import com.idrice24.repositories.ClasseRepository;

/**
 * Product service implement.
 */
@Service
public class ClasseServiceImpl implements ClasseService {

    private ClasseRepository classeRepository;

    @Autowired
    public void setClasseRepository(ClasseRepository classeRepository) {
	this.classeRepository = classeRepository;
    }

    @Override
    public Iterable<Classe> listAllClasses() {
	return classeRepository.findAll();
    }

}
