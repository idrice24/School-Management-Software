package com.idrice24.services;

import com.idrice24.entities.Student;

public interface StudentService {

//    /*  Iterable<Product> listAllProducts(); */

    Student getStudentById(Integer id);

    Student saveStudent(Student student);

    void deleteStudent(Integer id);

	Iterable<Student> listAllStudents();

}
