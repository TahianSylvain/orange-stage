package org.camunda.bpm.quarkus.example.rest;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.commons.utils.IoUtil;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.io.InputStream;

@Path("/store-order-items")
@Produces("application/json")
public class StartProcessRestResource {

  @Inject
  public RuntimeService runtimeService;

  @POST
  @Consumes("application/json")
  public void startProcess(InputStream payload) {
    String orderItemsAsString = IoUtil.inputStreamAsString(payload);

    ObjectValue orderItems = Variables.serializedObjectValue(orderItemsAsString)
        .objectTypeName("java.util.ArrayList<org.camunda.bpm.quarkus.example.dto.OrderItem>")
        .serializationDataFormat(Variables.SerializationDataFormats.JSON)
        .create();

    runtimeService.startProcessInstanceByKey("order-item-process",
        Variables.putValueTyped("orderItems", orderItems));
  }

}