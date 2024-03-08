package org.camunda.bpm.quarkus.example.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.quarkus.example.dto.CakeMaker;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;


@Named
@Dependent
public class MakeCakeService implements JavaDelegate {
    protected static final Logger LOG = Logger.getLogger(
        MakeCakeService.class);

    @Override
    public void execute(DelegateExecution execution) {
        CakeMaker cakeMaker = (CakeMaker) execution.getVariable("cakeMaker");
        
        String ingredient = cakeMaker.getIngredient();
        String quantity = cakeMaker.getQuantity();
        double price = cakeMaker.getPrice();
        double taxes = cakeMaker.getTaxes();
                
        LOG.infov("{0} {1} {2} {3}", ingredient, quantity, price, taxes);
    }    
}
