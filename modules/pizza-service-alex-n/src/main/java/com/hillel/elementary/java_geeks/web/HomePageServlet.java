package com.hillel.elementary.java_geeks.web;

import com.hillel.elementary.java_geeks.configs.Context;
import com.hillel.elementary.java_geeks.configs.DefaultPizzaServiceContext;
import com.hillel.elementary.java_geeks.configs.PizzaServiceConfig;
import com.hillel.elementary.java_geeks.services.PizzaService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.hillel.elementary.java_geeks.utils.CookieParser.getCookieValue;

public class HomePageServlet extends HttpServlet {

    private PizzaService pizzaService;
    private static final String ORDERED_PIZZAS_COOKIE_NAME = "orderedPizza";
    private static final int COOKIE_AGE = -1;


    @Override
    public void init() {
        Context context = DefaultPizzaServiceContext.getInstance(new PizzaServiceConfig());
        pizzaService = context.getBean("pizzaService");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookieValue = getCookieValue(ORDERED_PIZZAS_COOKIE_NAME, req);
        if (cookieValue != null){
            req.setAttribute("counter", cookieValue.split("\\+").length);
        }
        req.setAttribute("pizzas", pizzaService.getAllPizzas());
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookies = null;

        if (req.getParameter("add-btn") != null && !req.getParameter("add-btn").isEmpty()) {
            String cookieValue = getCookieValue(ORDERED_PIZZAS_COOKIE_NAME, req);
            if (cookieValue != null) {
                cookies = new Cookie(ORDERED_PIZZAS_COOKIE_NAME,
                        cookieValue.concat("+" + req.getParameter("add-btn")));
                resp.reset();
                resp.addCookie(cookies);
            } else {
                cookies = new Cookie(ORDERED_PIZZAS_COOKIE_NAME, req.getParameter("add-btn"));
                cookies.setMaxAge(COOKIE_AGE);
                resp.addCookie(cookies);
            }
        }
        if (cookies != null) {
            req.setAttribute("counter", cookies.getValue().split("\\+").length);
        }
        req.setAttribute("pizzas", pizzaService.getAllPizzas());
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
