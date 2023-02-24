package org.idrice24.services;



import org.idrice24.entities.Classe;

public interface ClasseService{

    Iterable<Classe> getAllClasse();

    void deleteClasse(Classe classe);

    void saveClasse(Classe classe);

    Classe getClasseById(long id);


	
}