package org.idrice24.services;

import org.idrice24.entities.Course;

public interface CourseService {

    Course saveCourse(Course course);
    void deleteCourse(Course course);
    Course findById(long id);

    Iterable<Course> listAllCourses();
    
}
