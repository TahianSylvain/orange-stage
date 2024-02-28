package org.dre.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import org.dre.model.Diagram;
import org.dre.service.DiagramService;

import java.util.List;


@Path("/diagram")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DiagramResource {
    @Inject
    DiagramService diagramService;

    @GET
    public List<Diagram> getAllDiagram() {
        return diagramService.getAllDiagram();
    }

    @GET
    @Path("/{id}")
    public Diagram getDiagramById(@PathParam("id") Long id){
        return diagramService.getDiagramById(id);
    }

    @POST
    public Diagram createDiagram(Diagram diagram) {
        return diagramService.createDiagram(diagram);
    }

    @PUT
    @Path("/{id}")
    public Diagram updateDiagram(@PathParam("id") Long id, Diagram diagram) {
        diagram.setId(id); // Ensure ID matches URL parameter
        return diagramService.updateDiagram(diagram);
    }

    @DELETE
    @Path("/{id}")
    public void deleteDiagram(@PathParam("id") Long id) {
        diagramService.deleteDiagram(id);
    }
}


/* ... (similar code as before for creating diagram and diagram)
    diagram1.getDiagrams().add(diagram);
    diagram2.getDiagrams().add(diagram);

    // Now a diagram can also be associated with multiple diagram:
    Diagram anotherDiagram = new Diagram();
    anotherDiagram.setTitle("Project Y");
    anotherDiagram.setDescription("Design overview");

    diagram1.getDiagrams().add(anotherDiagram);
    diagram2.getDiagrams().add(anotherDiagram);

    // Persist the entities
    diagram.persist();
    anotherDiagram.persist();


    Diagram diagram = new Diagram();
    diagram.setTitle("My Process");
    diagram.setDescription("Process overview");
    diagram.setBpmn2("... your BPMN content as a string ..."); // Optional

    // Persist the diagram
    diagram.persist();*/
