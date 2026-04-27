package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.HospitalDAO;

@WebServlet("/deletePatient")
public class DeletePatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            HospitalDAO dao = new HospitalDAO();
            dao.deletePatient(id);

            res.sendRedirect("patientdisplay.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}