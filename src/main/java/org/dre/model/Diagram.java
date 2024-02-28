package org.dre.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.util.List;
import com.fasterxml.jackson
    .annotation.JsonProperty;

import jakarta.persistence.Entity;


@Entity
@Table(name = "diagram")
public class Diagram extends PanacheEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("descripition")
    private String description;

    @ManyToMany(mappedBy = "diagrams")
    private List<Personnel> personnelList;

    @Column(
     unique = true,
     nullable = true)
    //  columnDefinition=TEXT, CLOB) ///postgres_optimus
    private String bpmn2;   // XML as a String


    //-----------------------methods------------------
    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}
    public String getDescription(){return description;}
    public void setDescription(String description)
        {this.description = description;}
    public String getBpmn2(){return bpmn2;}
    public void setBpmn2(String bpmn2){this.bpmn2 = bpmn2;}
}
