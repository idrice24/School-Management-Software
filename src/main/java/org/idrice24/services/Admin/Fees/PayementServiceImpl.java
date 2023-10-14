package org.idrice24.services.Admin.Fees;

import java.util.Optional;

import javax.validation.Valid;

import org.idrice24.entities.Admin.Fee.Payement;
import org.idrice24.repositories.Admin.Fees.PayementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayementServiceImpl implements StudentBillServiceImpl {

    private PayementRepository payementRepository;

    @Autowired
    public void setPayementRepository(PayementRepository payementRepository){
        this.payementRepository = payementRepository;
    }

    @Override
    public Iterable<Payement> getAllPayement() {
        
        return payementRepository.findAll();
    }

    @Override
    public void save(@Valid Payement payement) {
        payementRepository.save(payement);
    }

    @Override
    public void delete(@Valid Payement payement) {
        payementRepository.delete(payement);
        
    }

    @Override
    public Optional<Payement> getPayementById(long id) {
        return payementRepository.findById(id);
    }
    
}
