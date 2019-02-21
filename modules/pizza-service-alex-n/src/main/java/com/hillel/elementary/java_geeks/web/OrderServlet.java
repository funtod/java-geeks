package com.hillel.elementary.java_geeks.web;

import com.hillel.elementary.java_geeks.configs.Context;
import com.hillel.elementary.java_geeks.configs.DefaultPizzaServiceContext;
import com.hillel.elementary.java_geeks.configs.PizzaServiceConfig;
import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.services.OrderService;
import com.hillel.elementary.java_geeks.services.PizzaService;
import com.hillel.elementary.java_geeks.utils.Sessions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class OrderServlet extends HttpServlet {

    private static final String ATTR_NAME = "orderedPizza";
    private OrderService orderService;
    private PizzaService pizzaService;

    @Override
    public void init() throws ServletException {
        Context context = DefaultPizzaServiceContext.getInstance(new PizzaServiceConfig());
        pizzaService = context.getBean("pizzaService");
        orderService = context.getBean("orderService");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pizza> pizzas = Sessions.getPizzasList(req.getSession(), ATTR_NAME);
        if (pizzas != null) {
            req.setAttribute("pizzas", pizzas);
            req.setAttribute("count", pizzas.size());
        }
        req.getRequestDispatcher("order.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userBtnValue = req.getParameter("usr-data-btn");
        if (userBtnValue != null) {
            if (userBtnValue.equals("delete all")) {
                req.getSession().removeAttribute(ATTR_NAME);
            } else if (userBtnValue.equals("create")) {
                String name = req.getParameter("name");
                //todo
            }
        }
        req.getRequestDispatcher("order.jsp").forward(req, resp);
    }
}
