package org.idrice24.services.Teachers;

import org.idrice24.entities.Teachers.Takes;

public interface TakesService {

	Iterable<Takes> listAllTakes();

	void saveTakes(Takes takes);

	Takes findById(long id);

	void deleteTakes(Takes takes);
    
}
