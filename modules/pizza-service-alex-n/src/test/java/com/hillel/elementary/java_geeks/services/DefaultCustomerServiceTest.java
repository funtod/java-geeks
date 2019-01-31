package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.repositories.CustomerRepo;
import com.hillel.elementary.java_geeks.repositories.InMemCustomerRepo;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultCustomerServiceTest {

    private CustomerRepo mockCustomerRepo = mock(InMemCustomerRepo.class);

    @Test
    void shouldSaveAndGetCustomer() {

        //given
        Customer customer = new Customer(0L, "John");
        when(mockCustomerRepo.save(any())).thenReturn(customer);
        CustomerService customerService = new DefaultCustomerService(mockCustomerRepo);

        //when
        Customer registeredCustomer = customerService.registerCustomer(customer);

        //than
        assertThat(registeredCustomer).isEqualTo(customer);
    }

    @Test
    public void shouldThrowAnException() {

        Customer nullCustomer = null;
        Customer nullNameCustomer = new Customer(0L, null);
        CustomerService customerService = new DefaultCustomerService(mockCustomerRepo);


        assertThrows(IllegalArgumentException.class, () -> {
            customerService.registerCustomer(nullCustomer);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            customerService.registerCustomer(nullNameCustomer);
        });
    }
}