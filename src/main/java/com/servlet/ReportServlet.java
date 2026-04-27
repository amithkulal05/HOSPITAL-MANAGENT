package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.dao.HospitalDAO;
import com.model.Patient;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            String doctor = req.getParameter("doctor");
            String ailment = req.getParameter("ailment");
            String from = req.getParameter("from");
            String to = req.getParameter("to");

            HospitalDAO dao = new HospitalDAO();
            List<Patient> list = null;

            if (doctor != null && !doctor.isEmpty()) {
                list = dao.getByDoctor(doctor);
            }
            else if (ailment != null && !ailment.isEmpty()) {
                list = dao.getByAilment(ailment);
            }
            else if (from != null && !from.isEmpty() && to != null && !to.isEmpty()) {
                list = dao.getByDateRange(from, to);
            }

            req.setAttribute("reportData", list);

            RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}