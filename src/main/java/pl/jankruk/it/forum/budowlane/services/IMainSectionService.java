package pl.jankruk.it.forum.budowlane.services;

import pl.jankruk.it.forum.budowlane.entity.MainSection;

import java.util.List;

public interface IMainSectionService {
    void persistMainSection(MainSection mainSection);
    List<MainSection> getAllMainSections();
}
