
package org.camunda.bpm.quarkus.example.rest;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.commons.utils.IoUtil;

// import jakarta.annotation.security.RolesAllowed;
// import org.camunda.bpm.quarkus.example.security.Roles;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
// import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

import java.io.InputStream;



@Path("/make-some-bakeries")
@Produces("application/json")
public class StartCakeRestResource {
    
  @Inject 
  public RuntimeService runtimeService;

  @Context
  SecurityContext securityContext;

  // @GET
  // @Consumes('application/json')
  // public void blabla(){}


  @POST
  @Consumes("application/json")
  //@RolesAllowed({Roles.USER, Roles.SERVICE})
  public void startProcess(InputStream payload) {
    String makeBakersAsString = IoUtil.inputStreamAsString(payload);
    ObjectValue makeBake = Variables.serializedObjectValue(makeBakersAsString)
      .objectTypeName(
        "java.util.ArrayList<org.camunda.bpm.quarkus.example.dto.CakeMaker>")
      .serializationDataFormat(Variables.SerializationDataFormats.JSON)
      .create();
    runtimeService.startProcessInstanceByKey("make-some-bakeries",
    Variables.putValueTyped("makeBake", makeBake));
  }
}
