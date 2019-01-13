package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.*;
import com.hillel.elementary.java_geeks.repositories.ChefRepo;
import com.hillel.elementary.java_geeks.repositories.InMemChefRepo;

import java.util.Collection;

public class DefaultCookService implements CookService {

    private final ChefRepo chefRepo = new InMemChefRepo();

    public DefaultCookService(OrderService orderService) {
        for (Chef chef : chefRepo.getChefs()) {
            if (chef.getStatus() == ChefWorkingStatus.WORKING) {
                Thread thread = new ChefThread(chefRepo, chef, orderService);
                thread.start();
            }
        }
    }

    @Override
    public void passOrderToCook(Order order) {
        synchronized (chefRepo) {
            chefRepo.assignOrderToChef(order);
            chefRepo.notifyAll();
        }
    }
}

class ChefThread extends Thread {

    private OrderService orderService;
    private final ChefRepo chefRepo;
    private Chef chef;

    ChefThread(ChefRepo chefRepo, Chef chef, OrderService orderService) {
        this.chef = chef;
        this.chefRepo = chefRepo;
        this.orderService = orderService;
    }

    @Override
    public void run() {

        boolean isWorking = true;

        while (isWorking) {
            while (!chefRepo.hasOrders(chef.getId())) {
                synchronized (chefRepo) {
                    try {
                        chefRepo.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            Collection<Order> orders = chef.getOrders();
            for (Order order : orders) {
                for (Pizza pizza : order.getPizzas()) {
                    try {
                        Thread.sleep(pizza.getCookingTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                orderService.changeStatus(OrderStatus.DONE, order.getId());
                chefRepo.deleteOrder(chef.getId(), order);
            }
            /* in the end of making all orders, we check if working status changed and reassign
            isWorking variable to get out of the cycle */
            if (chefRepo.getChef(chef.getId()).getStatus() != ChefWorkingStatus.WORKING) {
                isWorking = false;
            }
        }
    }
}
