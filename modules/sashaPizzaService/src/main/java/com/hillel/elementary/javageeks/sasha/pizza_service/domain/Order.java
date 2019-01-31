package com.hillel.elementary.javageeks.sasha.pizza_service.domain;


import com.hillel.elementary.javageeks.sasha.pizza_service.utility.Validations;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

public class Order {
    private  Long id;
    private  Client client;
    private  Collection<Pizza> pizzas;
    private  BigDecimal total;
    private  Status status;




    private Order() {
    }

    public Status getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Collection<Pizza> getPizzas() {
        return pizzas;
    }

    public BigDecimal getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", pizzas=" + pizzas +
                ", total=" + total +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(client, order.client) &&
                Objects.equals(pizzas, order.pizzas) &&
                Objects.equals(total, order.total) &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, pizzas, total, status);
    }

    public static class OrderBuilder {

        private  Long id;
        private  Client client;
        private  Collection<Pizza> pizzas;
        private  BigDecimal total;
        private  Status status;

        public OrderBuilder fromOrder(Order order){
            setId(order.getId());
            setClient(order.getClient());
            setPizzas(order.getPizzas());
            setTotal(order.getTotal());
            setStatus(order.getStatus());

            return this;
        }

        public OrderBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public OrderBuilder setClient(Client client) {
            this.client = client;
            return this;
        }

        public OrderBuilder setPizzas(Collection<Pizza> pizzas) {
            this.pizzas = pizzas;
            return this;
        }

        public OrderBuilder setTotal(BigDecimal total) {
            this.total = total;
            return this;
        }

        public OrderBuilder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Order build(){
            validation();
            Order order = new Order();
            order.id = this.id;
            order.client = this.client;
            order.pizzas = this.pizzas;
            order.total = this.total;
            order.status = this.status;

            return order;
        }
        public void validation(){
            Validations.checkNotNull(this.client,"order client");
            Validations.checkNotNull(this.pizzas,"order pizzas");
            Validations.checkNotNull(this.status,"order status");
            Validations.checkNotNull(this.total,"order total");
        }
    }

}
