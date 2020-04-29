package com.idrice24.services;

import com.idrice24.entities.Teacher;

public interface TeacherService {

   /*  Iterable<Product> listAllProducts(); */

     Teacher getTeacherById(Integer id);

     Teacher saveTeacher(Teacher teacher);

     void deleteTeacher(Integer id);
	
	Iterable<Teacher> listAllTeachers();
	
}
