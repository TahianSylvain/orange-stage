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
import org.dre.model.Personnel;
import org.dre.service.PersonnelService;

import java.util.List;


@Path("/personnel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PersonnelResource {

    @Inject
    PersonnelService personnelService;

    @GET
    public List<Personnel> getAllPersonnel() {
        return personnelService.getAllPersonnel();
    }

    @GET
    @Path("/{id}")
    public Personnel getPersonnelById(@PathParam("id") Long id){
        return personnelService.getPersonnelById(id);
    }

    @POST
    public Personnel createPersonnel(Personnel personnel) {
        return personnelService.createPersonnel(personnel);
    }

    @PUT
    @Path("/{id}")
    public Personnel updatePersonnel(@PathParam("id") Long id, Personnel personnel) {
        personnel.setId(id); // Ensure ID matches URL parameter
        return personnelService.updatePersonnel(personnel);
    }

    @DELETE
    @Path("/{id}")
    public void deletePersonnel(@PathParam("id") Long id) {
        personnelService.deletePersonnel(id);
    }
}
