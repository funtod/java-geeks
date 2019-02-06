package com.hillel.elementary.javageeks.dir.pizza_service.services.customer;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer.CustomerRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SimpleCustomerServiceTest {
    private final CustomerRepository repositoryMock = mock(CustomerRepository.class);
    private final Customer customerMock = mock(Customer.class);
    private final Optional<Customer> customerOptional = Optional.of(customerMock);
    private final CustomerService service = new SimpleCustomerService(repositoryMock);

     @Test
    void shouldGetCustomerById() {
        //given
        when(repositoryMock.findById(anyLong())).thenReturn(customerOptional);

        //when
        Customer customer = service.getById(anyLong());

        //then
        assertEquals(customerMock, customer);
    }

    @Test
    void shouldGetCustomerByName() {
        //given
        String name = "John";
        when(repositoryMock.findByName(name)).thenReturn(customerOptional);

        //when
        Customer customer = service.getByName(name);

        //then
        assertEquals(customerMock, customer);
    }

    @Test
    void registerShouldThrowExceptionForNullCustomer() {
        //when, then
        assertThrows(IllegalArgumentException.class, () ->
                service.register(null)
        );
    }

    @Test
    void registerShouldThrowExceptionForCustomerWithNotNullId() {
        //given
        Long someId = 1L;
        when(customerMock.getId()).thenReturn(someId);

        //when, then
        assertThrows(IllegalArgumentException.class, () ->
                service.register(customerMock)
        );
    }

    @Test
    void registerShouldThrowExceptionWhenCustomerWithSuchNameExists() {
        //given
        String someName = "John";

        //when
        when(repositoryMock.findByName(someName)).thenReturn(customerOptional);
        when(customerMock.getName()).thenReturn(someName);

        //then
        assertThrows(IllegalArgumentException.class, () ->
                service.register(customerMock)
        );
    }

    @Test
    void registerShouldReturnSomeCustomer() {
        //when
        when(repositoryMock.save(customerMock)).thenReturn(customerOptional);
        when(customerMock.getId()).thenReturn(null);
        Customer customer = service.register(customerMock);

        //then
        assertEquals(customerMock, customer);
    }
}