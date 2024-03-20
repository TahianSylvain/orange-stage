/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.quarkus.example.rest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.camunda.bpm.engine.ProcessEngineException;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.quarkus.example.model.Personnel;
import org.camunda.bpm.quarkus.example.security.Roles;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.camunda.bpm.quarkus.example.dto.OrderItem;
import org.camunda.commons.utils.IoUtil;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.annotation.security.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.core.MediaType;


@Path("/store-order-items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StartProcessRestResource {
  @Inject 
  public RuntimeService runtimeService;

  @Context
  SecurityContext securityContext;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @RolesAllowed({Roles.USER, Roles.SERVICE})
  public String startProcess(InputStream payload) {
    String orderItemsAsString = IoUtil.inputStreamAsString(payload);
    ObjectValue orderItems = Variables.serializedObjectValue(orderItemsAsString)
      .objectTypeName("java.util.ArrayList<org.camunda.bpm.quarkus.example.dto.OrderItem>")
      .serializationDataFormat(Variables.SerializationDataFormats.JSON)
      .create();
    runtimeService.startProcessInstanceByKey("order-item-process",
      Variables.putValueTyped("orderItems", orderItems));
    return "Processed? OK";
  }
}
