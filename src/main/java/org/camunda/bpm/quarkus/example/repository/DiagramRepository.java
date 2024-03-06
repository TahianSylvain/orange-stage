package org.camunda.bpm.quarkus.example.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.camunda.bpm.quarkus.example.model.Diagram;

@ApplicationScoped
public class DiagramRepository implements PanacheRepository<Diagram> {}