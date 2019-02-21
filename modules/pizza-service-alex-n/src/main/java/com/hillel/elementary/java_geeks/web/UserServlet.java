package com.hillel.elementary.java_geeks.web;

import com.hillel.elementary.java_geeks.configs.Context;
import com.hillel.elementary.java_geeks.configs.DefaultPizzaServiceContext;
import com.hillel.elementary.java_geeks.configs.PizzaServiceConfig;
import com.hillel.elementary.java_geeks.domain.Customer;
import com.hillel.elementary.java_geeks.services.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        Context context = DefaultPizzaServiceContext.getInstance(new PizzaServiceConfig());
        customerService = context.getBean("customerService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //if button exit was pressed
        if (req.getParameter("exit") != null) {
            req.getSession().invalidate();
        }
        //if button sign in was pressed
        if (req.getParameter("signIn") != null) {
            String name = req.getParameter("userName");
            String pass = req.getParameter("userPass");
            if (name == null || pass == null || name.isEmpty() || pass.isEmpty()) {
                req.setAttribute("errMsg", "Wrong data. Try Again");
            } else {
                Customer customer = customerService.signIn(name, pass);
                if (customer == null) {
                    req.setAttribute("errMsg", "Wrong name or password. Try again");
                } else {
                    req.getSession().setAttribute("customer" , customer);
                }
            }
        }
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
}
