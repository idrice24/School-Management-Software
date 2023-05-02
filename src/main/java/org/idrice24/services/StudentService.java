package org.idrice24.services;


//import java.util.List;

//import org.idrice24.entities.Classe;
import org.idrice24.entities.Student;

public interface StudentService {

    Iterable<Student> listAllStudents();

    void saveStudent(Student student);

    long getLastId();

    //List<Student> findByClasse(Class<? extends Classe> s);
}
