package org.idrice24.repositories;

import org.idrice24.entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository()
public interface ContactRepository extends CrudRepository<Contact, Long>{
	Contact findById(long id);
}
