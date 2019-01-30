package com.hillel.elementary.javageeks.dir.pizza_service.services.chef;

import com.hillel.elementary.javageeks.dir.pizza_service.annotations.Component;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.enums.OrderStatus;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.order.OrderRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.services.notifier.NotifierService;
import com.hillel.elementary.javageeks.dir.pizza_service.utility.Logging;
import com.hillel.elementary.javageeks.dir.pizza_service.utility.Utilities;

import java.util.concurrent.*;

@Component("chefService")
public class WaitingThreadChefService extends Thread implements ChefService {
    private final NotifierService notifierService;
    private final OrderRepository orderRepository;
    private final BlockingQueue<Order> orderQueue;
    private static final int ORDER_QUEUE_CAPACITY = 5;
    private static final int SECONDS_TO_FINISH_WORK = 3;
    private final ExecutorService pool = Executors.newSingleThreadExecutor();

    public WaitingThreadChefService(NotifierService notifierService, OrderRepository orderRepository) {
        this.notifierService = notifierService;
        this.orderRepository = orderRepository;
        orderQueue = new ArrayBlockingQueue<>(ORDER_QUEUE_CAPACITY);
        pool.submit(this);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Order order = orderQueue.take();
                int millisecondsToCook = order.getPizzas().stream()
                        .mapToInt(pizza -> pizza.getMillisecondsToCook())
                        .sum();
                Thread.sleep(millisecondsToCook);
                Order updatedOrder = new Order(order);
                updatedOrder.setOrderStatus(OrderStatus.COOKED);
                orderRepository.save(updatedOrder);
                notifierService.notifyCustomer(updatedOrder);
            } catch (InterruptedException e) {
                System.out.println("Exiting chef service...");
                return;
            }
        }
        System.out.println("Exiting chef service...");
    }

    @Override
    public void cook(Order order) {
        try {
            orderQueue.put(order);
        } catch (InterruptedException ex) {
            Logging.logStackTrace(ex);
        }
    }

    public void finishWork() {
        Utilities.shutdownAndAwaitTermination(pool, SECONDS_TO_FINISH_WORK, TimeUnit.SECONDS);
    }
}
