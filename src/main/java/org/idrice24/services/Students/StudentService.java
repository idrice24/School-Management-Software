package org.idrice24.services.Students;

import org.idrice24.entities.Students.Student;

//import java.util.List;



public interface StudentService {

    Iterable<Student> listAllStudents();

    void saveStudent(Student student);

    long getLastId();

    //List<Student> findByClasse(Class<? extends Classe> s);
}
