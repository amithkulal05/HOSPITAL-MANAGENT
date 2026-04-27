package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.HospitalDAO;
import com.model.Patient;

public class DisplayPatientsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            HospitalDAO dao = new HospitalDAO();
            List<Patient> list = dao.getAllPatients();

            req.setAttribute("patients", list);
            RequestDispatcher rd = req.getRequestDispatcher("patientdisplay.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}