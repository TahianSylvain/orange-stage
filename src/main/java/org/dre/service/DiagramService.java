package org.dre.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.dre.model.Diagram;
import org.dre.repository.DiagramRepository;
import java.util.List;


@RequestScoped
// @ApplicationScoped
public class DiagramService {
    @Inject 
    DiagramRepository diagramRepository;

    public List<Diagram> getAllDiagram() {
        return Diagram.listAll();
    }

    public Diagram getDiagramById(Long id) {
        return Diagram.findById(id);
    }

    @Transactional
    public Diagram createDiagram(Diagram diagram) {
        diagram.persist();
        return diagram;
    }

    @Transactional
    public Diagram updateDiagram(Diagram diagram) {
        diagramRepository.getEntityManager().merge(diagram);
        return diagram;
    }

    @Transactional  
    public void deleteDiagram(Long id) {
        Diagram diagram = getDiagramById(id);
        if (diagram != null) {
            diagram.delete();
        }
    }
}
