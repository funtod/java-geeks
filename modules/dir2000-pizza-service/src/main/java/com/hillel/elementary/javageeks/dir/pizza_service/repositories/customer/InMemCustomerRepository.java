package com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Component;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component("customerRepository")
public class InMemCustomerRepository implements CustomerRepository {
    private final Map<Long, Customer> customers = new HashMap<>();
    private Long counter = 0L;

    @Override
    public synchronized Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customers.get(id));
    }

    @Override
    public synchronized Optional<Customer>  save(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("The customer should not be null");
        }

        if (customer.getId() != null && customers.get(customer.getId()) == null) {
            throw new IllegalStateException("The customer " + customer + " has id, but isn't in the database");
        }

        Customer customerToSave = createAndSave(customer);
        return Optional.of(customerToSave);
    }

    private Customer createAndSave(Customer customer)  {
        Customer customerToSave = new Customer(++counter, customer.getName());
        customers.put(customerToSave.getId(), customerToSave);
        return customerToSave;
    }

    @Override
    public synchronized Optional<Customer> findByName(String name) {
        for (Customer customer : customers.values()) {
            if (customer.getName().equals(name)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }
}
