package com.idrice24.services;

import com.idrice24.entities.School;
import java.util.List;

public interface SchoolService {

   /*  Iterable<Product> listAllProducts(); */

    //Eleve16 getEleve16ByCodcli(String codcli);
    //Eleve16 saveEleve16(Eleve16 Eleve16);
    //void deleteStatus(Integer id);
	
	Iterable<School> listAllSchools();
	//List<School> listAllSchoolsList();
	School getSchoolById(long id);
}
