package com.hillel.elementary.javageeks.sasha.pizza_service.repository;

        import com.hillel.elementary.javageeks.sasha.pizza_service.domain.Order;

        import java.util.HashMap;
        import java.util.Map;

public class InMemOrderRepository implements OrderRepository {

    private Map<Long, Order> orders = new HashMap<>();
    private Long counter = 0l;

    @Override
    public Order findById(Long id){
        return orders.get(id);
    }

    @Override
    public Order save(Order order){
        if(order == null){
            throw new NullPointerException();
        }
        Order orderToSave;
        if(order.getId() == null){
            orderToSave = new Order.OrderBuilder()
                    .setId(++counter)
                    .setClient(order.getClient())
                    .setPizzas(order.getPizzas())
                    .setStatus(order.getStatus())
                    .setTotal(order.getTotal())
                    .build();

        }else if(orders.get(order.getId()) == null){
            throw new IllegalArgumentException("");
        }else {
            orderToSave = order;
        }
        orders.put(orderToSave.getId(),orderToSave);

        return orderToSave;
    }
}
