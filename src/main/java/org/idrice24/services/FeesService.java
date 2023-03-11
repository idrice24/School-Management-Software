package org.idrice24.services;




import org.idrice24.entities.Fees;
import org.idrice24.entities.Student;


public interface FeesService {

    Iterable<Fees> getAllFees();

    void save(Fees fees);

    Fees findById(long id);
    
    void delete(Fees fees);

    Student findBySui(String string);

    long count();
    
}
