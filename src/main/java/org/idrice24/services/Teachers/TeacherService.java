package org.idrice24.services.Teachers;

import org.idrice24.entities.Teachers.Teachers;

public interface TeacherService {

Iterable<Teachers> getAllTeachers();

void saveTeacher(Teachers teacher);

Teachers findById(long id);

void deleteTeacher(Teachers teachers);
    
}
