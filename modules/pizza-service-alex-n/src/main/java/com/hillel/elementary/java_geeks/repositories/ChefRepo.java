package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.domain.Chef;
import com.hillel.elementary.java_geeks.domain.ChefWorkingStatus;
import com.hillel.elementary.java_geeks.domain.Order;

import java.util.Collection;

public interface ChefRepo {

    void save(Chef chef);

    Chef changeWorkingStatus(Integer chefId, ChefWorkingStatus isWorking);

    Chef getLessBusyChef();

    Collection<Chef> getChefs();

    Chef getChef(Integer chefId);

    Chef assignOrderToChef(Order order);

    boolean hasOrders(Integer chefId);

    void deleteOrder(Integer chefId, Order order);

}
