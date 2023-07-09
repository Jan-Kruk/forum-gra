package pl.jankruk.it.forum.budowlane.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jankruk.it.forum.budowlane.database.ISectionDAO;
import pl.jankruk.it.forum.budowlane.entity.Section;
import pl.jankruk.it.forum.budowlane.services.ISectionService;

import java.util.List;

@Service
public class SectionService implements ISectionService {
private ISectionDAO sectionDAO;
@Autowired
    public SectionService(ISectionDAO sectionDAO) {
        this.sectionDAO = sectionDAO;
    }

    @Override
    public void persistSection(Section section) {
        sectionDAO.persistSection(section);
    }

    @Override
    public List<Section> findAllSections() {
        return sectionDAO.findAllSections();
    }

    @Override
    public Section findSectionById(int id) {
        return sectionDAO.findSectionById(id);
    }

}
