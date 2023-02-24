package org.idrice24.services;

import org.idrice24.entities.Takes;

public interface TakesService {

	Iterable<Takes> listAllTakes();

	void saveTakes(Takes takes);

	Takes findById(long id);

	void deleteTakes(Takes takes);
    
}
