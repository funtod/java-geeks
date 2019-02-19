package com.hillel.elementary.javageeks.dir.pizza_service.web.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    private FilterConfig filterConfig = null;
    private final String errorPagePath = "/pages/error/401.jsp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("customer") != null;
        if (!loggedIn) {
            String contextPath = request.getContextPath();
            String errorURI = contextPath + errorPagePath;
            String forbiddenPaths = filterConfig.getInitParameter("forbiddenPaths");
            String[] paths = forbiddenPaths.split(",");
            for (int i = 0; i < paths.length; i++) {
                String path = contextPath + "/" + paths[i];
                if (request.getRequestURI().equals(path)) {
                    //response.sendRedirect(errorURI);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher(errorURI);
                    request.setAttribute("request_uri", path);
                    requestDispatcher.forward(request, response);
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }
}