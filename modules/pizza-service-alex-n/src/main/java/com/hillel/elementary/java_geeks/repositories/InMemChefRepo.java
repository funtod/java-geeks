package com.hillel.elementary.java_geeks.repositories;

import com.hillel.elementary.java_geeks.domain.Chef;
import com.hillel.elementary.java_geeks.domain.ChefWorkingStatus;
import com.hillel.elementary.java_geeks.domain.Order;

import java.util.*;

public class InMemChefRepo implements ChefRepo {

    private ArrayList<Chef> chefs = new ArrayList<>();
    private Integer counter = 0;

    public InMemChefRepo() {
        save(new Chef(null, "Bob", ChefWorkingStatus.WORKING, null));
        save(new Chef(null, "Marty", ChefWorkingStatus.NO_WORKING, null));
        save(new Chef(null, "Jennie", ChefWorkingStatus.WORKING, null));
    }

    @Override
    public void save(Chef chef) {
        if (chef.getId() == null) {
            Chef chefWithId = new Chef(counter, chef.getName(), chef.getStatus(), chef.getOrders());
            counter++;
            chefs.add(chefWithId);
        } else {
            chefs.add(chef);
        }
    }

    @Override
    public Chef changeWorkingStatus(Integer chefId, ChefWorkingStatus status) {
        Chef updatedChef = null;
        for (int i = 0; i < chefs.size(); i++) {
            if (chefs.get(i).getId() == chefId){
                Chef chef = chefs.get(i);
                updatedChef = new Chef(chef.getId(), chef.getName(), chef.getStatus(), chef.getOrders());
                chefs.remove(chef);
                chefs.add(updatedChef);
            }
        }
        return updatedChef;
    }

    @Override
    public Chef getLessBusyChef() {
        int minBusyness = Integer.MAX_VALUE;
        Chef lessBusyChef = null;
        for (int i = 0; i < chefs.size(); i++) {
            if (chefs.get(i) != null &
                    chefs.get(i).getOrders().size() < minBusyness &
                    chefs.get(i).getStatus() == ChefWorkingStatus.WORKING) {
                minBusyness = chefs.get(i).getOrders().size();
                lessBusyChef = chefs.get(i);
            }
        }
        return lessBusyChef;
    }

    @Override
    public Collection<Chef> getChefs() {
        return chefs;
    }

    @Override
    public Chef getChef(Integer chefId) {
        Chef chef = null;
        for (int i = 0; i < chefs.size(); i++) {
            if (chefs.get(i).getId() == chefId){
                chef = chefs.get(i);
            }
        }
        return chef;
    }

    @Override
    public Chef assignOrderToChef(Order order) {
        Chef chef = getLessBusyChef();
        LinkedList<Order> orders = (LinkedList<Order>) chef.getOrders();
        orders.add(order);
        Chef chefWithOrder = new Chef(chef.getId(),chef.getName(),chef.getStatus(), orders);
        chefs.remove(chef);
        chefs.add(chefWithOrder);
        return chefWithOrder;
    }

    @Override
    public boolean hasOrders(Integer chefId) {
        return !getChef(chefId).getOrders().isEmpty();
    }

    @Override
    public void deleteOrder(Integer chefId, Order order) {
        Collection<Order> orders = getChef(chefId).getOrders();
        orders.remove(order);
    }
}
