package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.Order;

public interface CookService {

    void passOrderToCook(Order order);
}
