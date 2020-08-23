package com.idrice24.services;

import com.idrice24.entities.Studmark;

public interface StudmarkService {

   /*  Iterable<Product> listAllProducts(); */

    Studmark getStudmarkById(Integer id);

    Studmark saveStudmark(Studmark studmark);

    void deleteStudmark(Integer id);

	Iterable<Studmark> listAllStudmarks();

}
