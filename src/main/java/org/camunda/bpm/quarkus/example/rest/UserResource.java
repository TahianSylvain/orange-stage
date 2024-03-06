package org.camunda.bpm.quarkus.example.rest;

import org.camunda.bpm.quarkus.example.model.Personnel;
import org.camunda.bpm.quarkus.example.service.TokenService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    TokenService service;

    @POST
    @Path("/register")
    @Transactional
    public Personnel register(Personnel user) {
        user.persist(); //super simplified registration, no checks of uniqueness
        return user;
    }

    @GET
    @Path("/login")
    public String login(@QueryParam("login")String login, @QueryParam("password") String password) {
        Personnel existingUser = Personnel.find("login", login).firstResult();
        if(existingUser == null || !existingUser.password.equals(password)) {
            throw new WebApplicationException(Response.status(404).entity("No user found or password is incorrect").build());
        }
        return service.generateUserToken(existingUser.email, password);
    }
}
