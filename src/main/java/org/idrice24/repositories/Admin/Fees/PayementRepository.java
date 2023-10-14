package org.idrice24.repositories.Admin.Fees;

import org.idrice24.entities.Admin.Fee.Payement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayementRepository extends CrudRepository<Payement, Long> {
    
}
