package com.idrice24.services;

import com.idrice24.entities.School;
import com.idrice24.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product service implement.
 */
@Service
public class SchoolServiceMpl implements SchoolService {

    private SchoolRepository schoolRepository;

    @Autowired
    public void setSchoolRepository(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

/*     @Override
    public Iterable<Product> listAllProducts() {
        return productRepository.findAll();
    } */
	
	@Override
    public Iterable<School> listAllSchools() {
        return schoolRepository.findAll();
    }
	
    @Override
    public School getSchoolById(long id) {
        School school=schoolRepository.findById(id).orElse(null);
		return school;
    }

    //@Override
    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    //@Override
    public void deleteSchool(long id) {
        schoolRepository.deleteById(id);
    }

}
