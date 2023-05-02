package org.idrice24.services;

import org.idrice24.entities.Fees;
import org.idrice24.entities.Student;
import org.idrice24.repositories.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeesServiceImpl implements FeesService {
    private FeesRepository feesRepository;

    @Autowired
    public void setFeesService(FeesRepository feesRepository){
        this.feesRepository = feesRepository;
    }

    @Override
    public Iterable<Fees> getAllFees() {
        return feesRepository.findAll();
    }

    @Override
    public void save(Fees fees) {
        
        feesRepository.save(fees);
        
    }

    @Override
    public Fees findById(long id) {

        return feesRepository.findById(id);
    }

    @Override
    public void delete(Fees fees) {
        feesRepository.delete(fees);
        
    }

    @Override
    public Student findBySui(String sui) {
        return null;
    }

    @Override
    public long count() {
        return feesRepository.count();
    }
    
}
