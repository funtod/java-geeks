package com.hillel.elementary.javageeks.dir.pizza_service.web.servlets;

import com.hillel.elementary.javageeks.dir.pizza_service.context.Context;
import com.hillel.elementary.javageeks.dir.pizza_service.context.SimpleImplementationContext;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.PizzaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class PizzasShowAll extends HttpServlet {
    private final Context context = SimpleImplementationContext.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PizzaService pizzaService = context.getBean("pizzaService");
        Collection<Pizza> pizzas = pizzaService.getAll();
        req.setAttribute("pizzas", pizzas);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/PizzasShowAll.jsp");
        requestDispatcher.forward(req, resp);
    }
}
