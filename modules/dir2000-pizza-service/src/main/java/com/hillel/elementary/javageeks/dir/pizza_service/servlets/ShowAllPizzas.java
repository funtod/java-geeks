package com.hillel.elementary.javageeks.dir.pizza_service.servlets;

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
import java.io.PrintWriter;
import java.util.Collection;

public class ShowAllPizzas extends HttpServlet {
    private final Context context = SimpleImplementationContext.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PizzaService pizzaService = context.getBean("pizzaService");
        Collection<Pizza> pizzas = pizzaService.getAll();
        req.setAttribute("pizzas", pizzas);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("pages/ShowallPizzas.jsp");
        requestDispatcher.forward(req, resp);
    }
}
