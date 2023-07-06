package pl.jankruk.it.forum.budowlane.database;

import pl.jankruk.it.forum.budowlane.entity.MainSection;

import java.util.List;

public interface IMainSectionDAO {
    void persistMainSection(MainSection mainSection);
    List<MainSection> findAllMainSections();
    MainSection findMainSection(int id);
}
