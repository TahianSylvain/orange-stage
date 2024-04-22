package org.camunda.bpm.quarkus.example.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.quarkus.example.dto.OrderItem;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Named
@Dependent
public class StoreOrderItemService implements JavaDelegate {

  protected static final Logger LOG = Logger.getLogger(StoreOrderItemService.class);

  @Override
  public void execute(DelegateExecution execution) {
    OrderItem orderItem = (OrderItem) execution.getVariable("orderItem");
    String name = orderItem.getName();
    double price = orderItem.getPrice();
    int period = orderItem.getPeriod();
    String origine = orderItem.getOrigine();
    String contact = orderItem.getContact();

    LOG.infov(
      "\n\tHurray, order item {0} with price {3}{1} by stored! Period is {2} months, and provider is {3}.\n\n",
      name, price, period, origine, contact);
  }

}
