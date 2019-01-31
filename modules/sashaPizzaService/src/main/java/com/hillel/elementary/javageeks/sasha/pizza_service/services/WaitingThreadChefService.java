package com.hillel.elementary.javageeks.sasha.pizza_service.services;



import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Status;
import com.hillel.elementary.javageeks.sasha.pizza_service.repository.OrderRepository;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitingThreadChefService implements ChefService {

    private OrderRepository orderRepository;
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    public WaitingThreadChefService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void cook(Order order){

        Runnable runnable = new Runnable(){

            @Override
            public void run(){
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                Order updateOrder = new Order.OrderBuilder()
                        .fromOrder(order)
                        .setStatus(Status.FINISHED)
                        .build();
                orderRepository.save(updateOrder);

            }
        };
        executor.submit(runnable);
    }
}
