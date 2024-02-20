package org.acme;

// import javax.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/ourpsql")
public class OurPsqlResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(){
        return "hello";
    }
}