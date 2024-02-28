package org.dre.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.JoinTable;
import java.util.List;


@Entity
@Table(name = "personnel")
public class Personnel extends PanacheEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    @JsonProperty("age")
    private int age;

    //  gmail,   intra-mail@orange.mg

    @ManyToMany
    @JoinTable(
        name = "personnel_diagrams",
        joinColumns = @JoinColumn(name = "personnel_id"),
        inverseJoinColumns = @JoinColumn(name = "diagram_id"))
    private List<Diagram> diagrams;


    //-----------------------methods------------------
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getNom(){return nom;}
    public void setNom(String nom){this.nom = nom;}
    public String getPrenom(){return prenom;}
    public void setPrenom(String prenom){this.prenom = prenom;}
    public int getAge(){return age;}
    public void setAge(int age){this.age = age;}
}