package org.idrice24.services;

import org.idrice24.entities.Student;
import org.idrice24.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Iterable<Student> listAllStudents() {
        // TODO Auto-generated method stub

        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        // TODO Auto-generated method stub

        studentRepository.save(student);
        
    }

    @Override
    public long getLastId() {
        // TODO Auto-generated method stub
        return studentRepository.count();
    }
    
}