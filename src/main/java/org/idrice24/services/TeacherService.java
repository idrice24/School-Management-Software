package org.idrice24.services;


import org.idrice24.entities.Teachers;

public interface TeacherService {

Iterable<Teachers> getAllTeachers();

void saveTeacher(Teachers teacher);

Teachers findById(long id);

void deleteTeacher(Teachers teachers);
    
}
