package com.hillel.elementary.javageeks.dir.pizza_service.domain;

import java.util.Objects;

public class Customer {
  private final String name;
  private Long id;

  public Customer(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  @Override
  public boolean equals(Object argO) {
    if (this == argO) {
      return true;
    }
    if (argO == null || getClass() != argO.getClass()) {
      return false;
    }
    Customer customer = (Customer) argO;
    return Objects.equals(id, customer.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  public String getName() {
    return name;
  }
}
