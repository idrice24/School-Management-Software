package org.idrice24.services.Students;

import org.idrice24.entities.Students.Student;
import org.idrice24.repositories.Students.StudentRepository;
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
        

        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        

        studentRepository.save(student);
        
    }

    @Override
    public long getLastId() {
        return studentRepository.count();
    }
    
}