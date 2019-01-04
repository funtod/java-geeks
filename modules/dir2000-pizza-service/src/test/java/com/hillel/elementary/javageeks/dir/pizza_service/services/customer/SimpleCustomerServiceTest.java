package com.hillel.elementary.javageeks.dir.pizza_service.services.customer;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer.CustomerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class SimpleCustomerServiceTest {
  @Mock  CustomerRepository repositoryMock = mock(CustomerRepository.class);
  @Mock  Customer customerMock = mock(Customer.class);
  CustomerService service = new SimpleCustomerService(repositoryMock);

  {
    MockitoAnnotations.initMocks(SimpleCustomerServiceTest.class);
  }

  @Test
  void getById() {
    //when
    when(repositoryMock.findById(anyLong())).thenReturn(customerMock);

    //then
    Customer customer = service.getById(anyLong());
    assertEquals(customerMock, customer);
  }

  @Test
  void getByName() {
  }

  @Test
  void register() {
  }
}