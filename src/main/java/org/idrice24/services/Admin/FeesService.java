package org.idrice24.services.Admin;




import org.idrice24.entities.Admin.Fees;
import org.idrice24.entities.Students.Student;


public interface FeesService {

    Iterable<Fees> getAllFees();

    void save(Fees fees);

    Fees findById(long id);
    
    void delete(Fees fees);

    Student findBySui(String string);

    long count();
    
}
