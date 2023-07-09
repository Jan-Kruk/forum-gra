package pl.jankruk.it.forum.budowlane.database;

import pl.jankruk.it.forum.budowlane.entity.Section;

import java.util.List;

public interface ISectionDAO {
    void persistSection(Section section);

    List<Section> findAllSections();

    Section findSectionById(int id);
}
