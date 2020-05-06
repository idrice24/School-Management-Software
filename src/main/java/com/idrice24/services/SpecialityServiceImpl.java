package com.idrice24.services;

import com.idrice24.entities.Speciality;
import com.idrice24.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product service implement.
 */
@Service
public class SpecialityServiceImpl implements SpecialityService {

    private SpecialityRepository specialityRepository;

    @Autowired
    public void setSpecialityRepository(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Iterable<Speciality> listAllSpecialitys() {
        return specialityRepository.findAll();
    }
	

}
