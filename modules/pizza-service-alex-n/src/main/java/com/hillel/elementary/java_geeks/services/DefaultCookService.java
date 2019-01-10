package com.hillel.elementary.java_geeks.services;

import com.hillel.elementary.java_geeks.domain.*;
import com.hillel.elementary.java_geeks.repositories.ChefRepo;
import com.hillel.elementary.java_geeks.repositories.InMemChefRepo;

import java.util.Collection;

public class DefaultCookService implements CookService {

    private final ChefRepo chefRepo = new InMemChefRepo();
    private OrderService orderService;

    DefaultCookService(OrderService orderService){
        this.orderService = orderService;
        for (Chef chef : chefRepo.getChefs()) {
            Thread thread = new Kitchen(chefRepo, chef, orderService);
            thread.start();
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

class Kitchen extends Thread {

    private OrderService orderService;
    private final ChefRepo chefRepo;
    private Chef chef;

    Kitchen(ChefRepo chefRepo, Chef chef, OrderService orderService) {
        this.chef = chef;
        this.chefRepo = chefRepo;
        this.orderService = orderService;
    }

    @Override
    public void run() {

        while (chefRepo.getChef(chef.getId()).getStatus() == ChefWorkingStatus.WORKING) {
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
            for (Order order: orders) {
                for (Pizza pizza: order.getPizzas()) {
                    try {
                        Thread.sleep(pizza.getCookingTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                orderService.changeStatus(OrderStatus.DONE, order.getId());
                System.out.println("Im ok.");//todo delete
                chefRepo.deleteOrder(chef.getId(), order);
            }
        }
    }
}
