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

    @Transactional
    public void createUser(Personnel personnel) {
        Personnel personnelMerged = personnelRepository.getEntityManager().merge(personnel);
//        personnelRepository.persist(Personnel);
    }

    public List<Personnel> getAllPersonnel() {
        return personnelRepository.listAll();
    }

    public Personnel getPersonnelById(Long id) {
        return personnelRepository.findById(id);
    }

    @Transactional
    public void updatePersonnel(Personnel Personnel) {
        personnelRepository.getEntityManager().merge(Personnel);
    }

    @Transactional
    public boolean deletePersonnel(Long id) {
        Personnel Personnel = personnelRepository.findById(id);
        if (Personnel != null) {
            personnelRepository.delete(Personnel);
            return true;
        }
        return false;
    }
}
