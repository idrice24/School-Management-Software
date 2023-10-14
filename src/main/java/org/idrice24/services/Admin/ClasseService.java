package org.idrice24.services.Admin;



import org.idrice24.entities.Admin.Classe;

public interface ClasseService{

    Iterable<Classe> getAllClasse();

    void deleteClasse(Classe classe);

    void saveClasse(Classe classe);

    Classe getClasseById(long id);


	
}