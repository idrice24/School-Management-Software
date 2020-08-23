package com.idrice24.services;

import com.idrice24.entities.Schfee;
import java.util.List;

public interface SchfeeService {

    Iterable<Schfee> listAllSchfees();

    Schfee getSchfeeById(Integer id);

    Schfee saveSchfee(Schfee schfee);

    void deleteSchfee(Integer id);
	
}
