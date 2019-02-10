package com.hillel.elementary.javageeks.dir.pizza_service.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Create order");
        out.close();
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
//        requestDispatcher.forward(req, resp);

    }
}
