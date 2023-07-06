package pl.jankruk.it.forum.budowlane.services;

import pl.jankruk.it.forum.budowlane.entity.Section;

import java.util.List;

public interface ISectionService {
    void persistSection(Section section);
    List<Section> findAllSections();
}
