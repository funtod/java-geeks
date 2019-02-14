package com.hillel.elementary.java_geeks.web;

import com.hillel.elementary.java_geeks.configs.Context;
import com.hillel.elementary.java_geeks.configs.DefaultPizzaServiceContext;
import com.hillel.elementary.java_geeks.configs.PizzaServiceConfig;
import com.hillel.elementary.java_geeks.domain.Pizza;
import com.hillel.elementary.java_geeks.services.OrderService;
import com.hillel.elementary.java_geeks.services.PizzaService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.hillel.elementary.java_geeks.utils.CookieParser.getCookieValue;


public class OrderServlet extends HttpServlet {

    private static final String ORDERED_PIZZAS_COOKIE_NAME = "orderedPizza";
    private OrderService orderService;
    private PizzaService pizzaService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pizzaIds = getCookieValue(ORDERED_PIZZAS_COOKIE_NAME, req);

        if (pizzaIds != null) {
            List<Pizza> pizzas = Arrays.stream(pizzaIds.split("\\+"))
                    .map(Integer::parseInt)
                    .map(id -> pizzaService.getPizzaById(id))
                    .collect(Collectors.toList());
            req.setAttribute("pizzas", pizzas);
            req.setAttribute("count", pizzas.size());
        }

        req.getRequestDispatcher("order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("usr-data-btn") != null) {
            Cookie emptyCookie = new Cookie(ORDERED_PIZZAS_COOKIE_NAME, "");
            emptyCookie.setMaxAge(0);
            resp.addCookie(emptyCookie);
        }
        req.getRequestDispatcher("order.jsp").forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        Context context = DefaultPizzaServiceContext.getInstance(new PizzaServiceConfig());
        pizzaService = context.getBean("pizzaService");
        orderService = context.getBean("orderService");
    }

}
