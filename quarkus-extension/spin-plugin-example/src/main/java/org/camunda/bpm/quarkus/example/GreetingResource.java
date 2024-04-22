package org.camunda.bpm.quarkus.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
//import jakarta.inject.Inject;


@Path("/")
public class GreetingResource {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public void landing(){} 
}
