package org.dre.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.dre.model.Personnel;
import org.dre.service.PersonnelService;

import java.util.List;

@Path("/accueil")

public class Accueil {


    @Inject
    PersonnelService personnelService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String personnels() {
        List<Personnel> personnels = Personnel.listAll() ;
        String nom ="";
        for( Personnel p : personnels )
        {
            nom+=p.getNom();
        }
                return "Bienvenue sur la page d'accueil zandry "+nom+ "!";
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersonnel() {
        // Récupérer les données depuis PostgreSQL
        List<Personnel> personnels = personnelService.getAllPersonnel();
        return Response.ok(personnels).build();
    }

    @POST
    @Path("/c")
    public Response createUser(Personnel personnel) {
        personnelService.createUser(personnel);
        return Response.status(Response.Status.CREATED).entity(personnel).build();
    }

    //PUT || UPDATE
    @PUT
    @Path("/u/{id}")
    public Response updateUser(@PathParam("id") Long id, Personnel updatedPersonnel) {
        updatedPersonnel.setId(id); // Assure que l'ID de l'utilisateur est correctement défini
        personnelService.updatePersonnel(updatedPersonnel);
        return Response.ok(updatedPersonnel).build();
    }

    //DELETE
    @DELETE
    @Path("/d/{id}")
    public Response deletePersonnel(@PathParam("id") Long personnelId) {
        personnelService.deletePersonnel(personnelId);
        return Response.noContent().build();
    }

    @GET
    @Path("/one")
    @Produces(MediaType.APPLICATION_JSON)
    public Personnel getOnePersonnel() {

        Personnel p =  new Personnel();
        p.setId(2L);
        p.setNom("Andrew");
        p.setPrenom("Mathew");
        p.setAge(12);
        return p;

    }


}
