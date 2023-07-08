package pl.jankruk.it.forum.budowlane.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jankruk.it.forum.budowlane.database.IMainSectionDAO;
import pl.jankruk.it.forum.budowlane.database.memory.MainSectionDAO;
import pl.jankruk.it.forum.budowlane.entity.MainSection;
import pl.jankruk.it.forum.budowlane.services.IMainSectionService;

import java.util.List;

@Service
public class MainSectionService implements IMainSectionService {
    private IMainSectionDAO mainSectionDAO;


    @Autowired
    public MainSectionService(IMainSectionDAO mainSectionDAO) {
        this.mainSectionDAO = mainSectionDAO;
    }

    @Override
    public void persistMainSection(MainSection mainSection) {
        mainSectionDAO.persistMainSection(mainSection);
    }

    @Override
    public List<MainSection> getAllMainSections() {
       return mainSectionDAO.findAllMainSections();
    }

    @Override
    public MainSection findMainSection(int id) {
        return mainSectionDAO.findMainSection(id);
    }

}
