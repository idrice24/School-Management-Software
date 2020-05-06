package com.idrice24.services;

import com.idrice24.entities.Course;
import com.idrice24.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product service implement.
 */
@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

     @Override
    public Iterable<Course> listAllCourses() {
        return courseRepository.findAll();
    }
	

}
