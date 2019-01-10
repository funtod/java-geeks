package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.domain.Customer;

public interface CustomerRepo {

    Customer save(Customer customer);
}
