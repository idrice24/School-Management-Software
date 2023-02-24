package org.idrice24.services;


import org.idrice24.entities.Student;

public interface StudentService {

    Iterable<Student> listAllStudents();

    void saveStudent(Student student);

    long getLastId();
    
}
