package org.idrice24.services.Admin.Fees;

import java.util.Optional;

import javax.validation.Valid;

import org.idrice24.entities.Admin.Fee.Payement;

public interface StudentBillServiceImpl {

    Iterable<Payement> getAllPayement();

    void save(@Valid Payement payement);

    void delete(@Valid Payement payement);

    Optional<Payement> getPayementById(long id);
    
}
