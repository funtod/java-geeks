package com.hillel.elementary.javageeks.dir.pizza_service.servlets.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommonServletActions {
    public static boolean NonAutenticatedRedirected(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Long customerID = (Long) session.getAttribute("customerID");
        if (customerID == null) {
            resp.sendRedirect("index.jsp");
        }
        return customerID == null;
    }
}
