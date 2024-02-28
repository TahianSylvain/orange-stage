package org.dre.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.dre.model.Personnel;
import org.dre.repository.PersonnelRepository;
import java.util.List;

@ApplicationScoped
public class PersonnelService {
    @Inject
    PersonnelRepository personnelRepository;

    public List<Personnel> getAllPersonnel() {
        return Personnel.listAll();
    }

    public Personnel getPersonnelById(Long id) {
        return Personnel.findById(id);
    }

    @Transactional
    public Personnel createPersonnel(Personnel personnel) {
        personnel.persist();
        return personnel;
    }

    @Transactional
    public Personnel updatePersonnel(Personnel personnel) {
        personnelRepository.getEntityManager().merge(personnel);
        // personnel.update();
        return personnel;
    }

    @Transactional  
    public void deletePersonnel(Long id) {
        Personnel personnel = getPersonnelById(id);
        if (personnel != null) {
            personnel.delete();
        }
    }
}

