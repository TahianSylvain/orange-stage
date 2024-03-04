package org.dre.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.dre.model.Diagram;

@ApplicationScoped
public class DiagramRepository implements PanacheRepository<Diagram> {}