package com.hillel.elementary.javageeks.dir.pizza_service.servlets;

import com.hillel.elementary.javageeks.dir.pizza_service.context.Context;
import com.hillel.elementary.javageeks.dir.pizza_service.context.SimpleImplementationContext;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.dir.pizza_service.services.customer.CustomerService;
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
        Long customerID = (Long) session.getAttribute("customerID");
        if (customerID == null) {
            resp.sendRedirect("index.jsp");
            return;
        }
        OrderService orderService = context.getBean("orderService");
        CustomerService customerService = context.getBean("customerService");
        Customer customer = customerService.getById(customerID);
        Collection<Order> orders = orderService.getAllCustomerOrders(customer);
        req.setAttribute("orders", orders);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/OrdersList.jsp");
        requestDispatcher.forward(req, resp);
    }
}
