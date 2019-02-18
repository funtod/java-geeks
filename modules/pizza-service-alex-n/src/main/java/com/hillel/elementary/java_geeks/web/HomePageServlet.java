package com.hillel.elementary.java_geeks.web;

import com.hillel.elementary.java_geeks.configs.Context;
import com.hillel.elementary.java_geeks.configs.DefaultPizzaServiceContext;
import com.hillel.elementary.java_geeks.configs.PizzaServiceConfig;
import com.hillel.elementary.java_geeks.services.PizzaService;
import com.hillel.elementary.java_geeks.utils.Sessions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageServlet extends HttpServlet {

    private PizzaService pizzaService;
    private static final String ATTR_NAME = "orderedPizza";

    @Override
    public void init() {
        Context context = DefaultPizzaServiceContext.getInstance(new PizzaServiceConfig());
        pizzaService = context.getBean("pizzaService");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pizzas", pizzaService.getAllPizzas());
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add-btn") != null) {
            String pizzaId = req.getParameter("pizzaId");
            if (pizzaId != null) {
                Sessions.addPizzaToSessionOrder(req.getSession(),
                        ATTR_NAME,
                        pizzaService.getPizzaById(Integer.parseInt(pizzaId)));
            }
        }
        req.setAttribute("pizzas", pizzaService.getAllPizzas());
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

}
