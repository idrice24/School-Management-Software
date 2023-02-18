package org.idrice24.services;

import org.idrice24.entities.Classe;
import org.idrice24.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClasseServiceImpl implements ClasseService {

    private ClasseRepository classeRepository;

    @Autowired
    public void setClasseRepository(ClasseRepository classeRepository){
        this.classeRepository = classeRepository;
    }

    @Override
    public Iterable<Classe> getAllClasse() {
        return classeRepository.findAll();
    }

    @Override
    public void deleteClasse(Classe classe) {
        classeRepository.delete(classe);
    }

    @Override
    public void saveClasse(Classe classe) {
        classeRepository.save(classe);
        
    }

    @Override
    public Classe getClasseById(long id) {
        return classeRepository.findById(id);
    }
    
}
