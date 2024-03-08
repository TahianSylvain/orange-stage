package org.camunda.bpm.quarkus.example.dto;

public class CakeMaker {

    protected String ingredient;
    protected String quantity;
    protected double price; // €
    protected double taxes;

    public String getIngredient() {
        return ingredient;
    }
	public String getQuantity() {
        return quantity;
    }
	public double getPrice() {
        return price;
    }
	public double getTaxes() {
        return taxes;
    }

}
