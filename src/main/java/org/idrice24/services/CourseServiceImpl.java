package org.idrice24.services;

import org.idrice24.entities.Course;
import org.idrice24.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl implements CourseService  {
    private CourseRepository courseRepositry;

    @Autowired
    public void setCourseRepositry(CourseRepository courseRepository){
        this.courseRepositry = courseRepository;
    }

    @Override
    public Iterable<Course> listAllCourses() {
        return courseRepositry.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepositry.save(course);
    }

    @Override
    public void deleteCourse(Course course) {
        courseRepositry.delete(course);
    }

    @Override
    public Course findById(long id) {
       return  courseRepositry.findById(id);
        
    }
    
}
