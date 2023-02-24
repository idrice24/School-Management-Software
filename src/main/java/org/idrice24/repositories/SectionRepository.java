package org.idrice24.repositories;

import org.idrice24.entities.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SectionRepository extends CrudRepository<Section, Long>{
    Section findById(long id);
}