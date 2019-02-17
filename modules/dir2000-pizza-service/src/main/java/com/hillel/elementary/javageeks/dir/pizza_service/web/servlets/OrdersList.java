package com.hillel.elementary.javageeks.dir.pizza_service.web.servlets;

import com.hillel.elementary.javageeks.dir.pizza_service.context.Context;
import com.hillel.elementary.javageeks.dir.pizza_service.context.SimpleImplementationContext;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.dir.pizza_service.services.order.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

public class OrdersList extends HttpServlet {
    private final Context context = SimpleImplementationContext.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        OrderService orderService = context.getBean("orderService");
        Collection<Order> orders = orderService.getAllCustomerOrders(customer);
        if (orders != null && orders.size() != 0) {
            req.setAttribute("orders", orders);
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/OrdersList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
