package org.dre;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response obtenirExemple(@PathParam("id") int id) {


        // Logique pour récupérer l'exemple avec l'ID donné depuis la base de données
        String nom ;

        if(id== 1)
        {
            nom = "Jean";
        }else
            nom = "le(la) nouveau(lle)";

        String exemple = "Bonjour : " + nom;

        return Response.ok(exemple).build();
    }
//    @GET("/exporter")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String salut() {
//        return "Hello from RESTEasy Reactive";
//    }


}
