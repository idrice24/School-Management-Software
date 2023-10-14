package org.idrice24.repositories.Admin;

import org.idrice24.entities.Admin.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SectionRepository extends CrudRepository<Section, Long>{
    Section findById(long id);
}