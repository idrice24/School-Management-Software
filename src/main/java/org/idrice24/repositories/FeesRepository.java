package org.idrice24.repositories;


import org.idrice24.entities.Fees;
//import org.idrice24.entities.Student;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRepository extends CrudRepository<Fees, Long> {
    Fees findById(long id);

    //@Query(value="SELECT s FROM student s WHERE s.sui IN : sui")
    //Student findStudentBySui(@Param("sui") String sui);
}
