package org.idrice24.services;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.idrice24.entities.Course;

public interface CourseService {

    Course saveCourse(Course course);
    void deleteCourse(Course course);
    Optional findById(long id);

    Iterable<Course> listAllCourses();
    
}
