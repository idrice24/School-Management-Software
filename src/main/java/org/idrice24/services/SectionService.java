package org.idrice24.services;

import org.idrice24.entities.Section;

public interface SectionService {

    void deleteSection(Section section);

    Iterable<Section> getAllSection();

    void saveSection(Section section);

    Section getSectionById(long id);
    
}
