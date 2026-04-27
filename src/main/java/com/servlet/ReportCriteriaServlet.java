package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReportCriteriaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String type = req.getParameter("type");

        if (type.equals("doctor")) {
            req.getRequestDispatcher("report_doctor.jsp").forward(req, res);
        } 
        else if (type.equals("ailment")) {
            req.getRequestDispatcher("report_ailment.jsp").forward(req, res);
        } 
        else if (type.equals("date")) {
            req.getRequestDispatcher("report_date.jsp").forward(req, res);
        }
    }
}