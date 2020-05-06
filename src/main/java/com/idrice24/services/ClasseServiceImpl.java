package com.idrice24.services;

import com.idrice24.entities.Classe;
import com.idrice24.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product service implement.
 */
@Service
public class ClasseServiceImpl implements ClasseService {

    private ClasseRepository ClasseRepository;

    @Autowired
    public void setClasseRepository(ClasseRepository ClasseRepository) {
        this.ClasseRepository = ClasseRepository;
    }

     @Override
    public Iterable<Classe> listAllClasses() {
        return ClasseRepository.findAll();
    } 
	

}
