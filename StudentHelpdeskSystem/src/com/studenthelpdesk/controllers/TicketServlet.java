package com.studenthelpdesk.controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.studenthelpdesk.dao.TicketDao;

public class TicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("login.html");
            return;
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        TicketDao ticketDao = new TicketDao();
        ticketDao.createTicket(username, title, description);

        response.sendRedirect("dashboard.html");
    }
}
