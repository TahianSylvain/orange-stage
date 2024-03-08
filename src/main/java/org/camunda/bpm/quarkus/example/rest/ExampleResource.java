package org.camunda.bpm.quarkus.example.rest;

import org.camunda.bpm.quarkus.example.model.Personnel;
import org.camunda.bpm.quarkus.example.security.Roles;

import jakarta.annotation.security.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;


@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleResource {

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/me")
    @RolesAllowed({Roles.USER, Roles.SERVICE})
    public Personnel me() {
        return Personnel.find("email", 
        securityContext.getUserPrincipal().getName()).firstResult();
    }

    @GET
    @Path("/void")
    @DenyAll
    public String nothing() {
        return "This method should always return 403";
    }
}