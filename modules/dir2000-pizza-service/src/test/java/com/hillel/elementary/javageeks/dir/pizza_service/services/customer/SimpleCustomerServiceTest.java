package com.hillel.elementary.javageeks.dir.pizza_service.services.customer;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer.CustomerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SimpleCustomerServiceTest {
    private final CustomerRepository repositoryMock = mock(CustomerRepository.class);
    private final Customer customerMock = mock(Customer.class);
    private final CustomerService service = new SimpleCustomerService(repositoryMock);

    @Test
    void shouldGetCustomerById() {
        //given
        when(repositoryMock.findById(anyLong())).thenReturn(customerMock);

        //when
        Customer customer = service.getById(anyLong());

        //then
        assertEquals(customerMock, customer);
    }

    @Test
    void shouldGetCustomerByName() {
        //given
        String name = "John";
        when(repositoryMock.findByName(name)).thenReturn(customerMock);

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
        when(repositoryMock.findByName(someName)).thenReturn(customerMock);
        when(customerMock.getName()).thenReturn(someName);

        //then
        assertThrows(IllegalArgumentException.class, () ->
                service.register(customerMock)
        );
    }

    @Test
    void registerShouldReturnSomeCustomer() {
        //when
        when(repositoryMock.save(customerMock)).thenReturn(customerMock);
        when(customerMock.getId()).thenReturn(null);
        Customer customer = service.register(customerMock);

        //then
        assertEquals(customerMock, customer);
    }
}