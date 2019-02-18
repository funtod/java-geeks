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

public class RegistrationServlet extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        Context context = DefaultPizzaServiceContext.getInstance(new PizzaServiceConfig());
        customerService = context.getBean("customerService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("register") != null) {
            String name = req.getParameter("userName");
            String pass = req.getParameter("userPass");
            String phone = req.getParameter("userPhone");
            if (name == null || pass == null || phone == null || name.isEmpty() || pass.isEmpty() || phone.isEmpty()) {
                req.setAttribute("errMsg", "you must fill all fields");
            } else {
                //todo data validation ? [> 6 chars], [not contains symbols ] ...
                Customer customer = customerService.registerCustomer(name, pass, phone);
                if (customer == null) {
                    req.setAttribute("errMsg", "can not create user with such data.");
                } else {
                    req.setAttribute("msg", "UserServlet: " + customer.getName() + ", successfully created");
                    req.setAttribute("userName" , "");
                    req.setAttribute("userPass", "");
                    req.setAttribute("userPhone", "");
                }
            }
        }
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }
}
