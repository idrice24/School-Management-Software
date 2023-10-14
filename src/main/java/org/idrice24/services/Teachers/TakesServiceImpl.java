package org.idrice24.services.Teachers;

import org.idrice24.entities.Teachers.Takes;
import org.idrice24.repositories.Teachers.TakesRepository;
import org.springframework.stereotype.Service;

@Service
public class TakesServiceImpl implements TakesService {
    private TakesRepository takesRepository;


    @Override
    public Iterable<Takes> listAllTakes() {
        return takesRepository.findAll();
    }

    @Override
    public void saveTakes(Takes takes) {
        
        takesRepository.save(takes);
    }

    @Override
    public Takes findById(long id) {
        return takesRepository.findById(id);
    }

    @Override
    public void deleteTakes(Takes takes) {
        takesRepository.delete(takes);
        
    }
    
}
