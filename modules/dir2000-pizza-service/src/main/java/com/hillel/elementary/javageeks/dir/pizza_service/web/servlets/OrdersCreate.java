package com.hillel.elementary.javageeks.dir.pizza_service.web.servlets;

import com.hillel.elementary.javageeks.dir.pizza_service.context.Context;
import com.hillel.elementary.javageeks.dir.pizza_service.context.SimpleImplementationContext;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.services.order.OrderService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.PizzaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

public class OrdersCreate extends HttpServlet {
    private final Context context = SimpleImplementationContext.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PizzaService pizzaService = context.getBean("pizzaService");
        Collection<Pizza> pizzas = pizzaService.getAll();
        req.setAttribute("pizzas", pizzas);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/OrdersCreate.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        OrderService orderService = context.getBean("orderService");
        Customer customer = (Customer) session.getAttribute("customer");
        String[] values = req.getParameterValues("pizza_id");
        if (values == null || values.length == 0) {
            doGet(req, resp);
            return;
        }
        Long[] pizzasIds = new Long[values.length];
        for (int i = 0; i < values.length; i++) {
            pizzasIds[i] = Long.parseLong(values[i]);
        }
        orderService.placeNewOrder(customer, pizzasIds);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/orders_list");
        requestDispatcher.forward(req, resp);
    }
}
