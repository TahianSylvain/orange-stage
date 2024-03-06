package org.camunda.bpm.quarkus.example.dto;

public class OrderItem {

  protected String name;
  protected double price;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}
