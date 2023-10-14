package org.idrice24.services.Admin;

import org.idrice24.entities.Admin.Section;

public interface SectionService {

    void deleteSection(Section section);

    Iterable<Section> getAllSection();

    void saveSection(Section section);

    Section getSectionById(long id);
    
}
