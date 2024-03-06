package org.camunda.bpm.quarkus.example.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.camunda.bpm.quarkus.example.model.Personnel;

@ApplicationScoped
public class PersonnelRepository implements PanacheRepository<Personnel> {}