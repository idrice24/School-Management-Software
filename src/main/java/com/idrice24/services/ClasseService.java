package com.idrice24.services;

import com.idrice24.entities.Classe;
import com.idrice24.repositories.ClasseRepository;

public interface ClasseService {

    Iterable<Classe> listAllClasses();

    void setClasseRepository(ClasseRepository classeRepository);

}
