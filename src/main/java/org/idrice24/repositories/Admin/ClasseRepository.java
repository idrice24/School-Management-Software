package org.idrice24.repositories.Admin;

import org.idrice24.entities.Admin.Classe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClasseRepository extends CrudRepository<Classe, Long>{
    Classe findById(long id);
}