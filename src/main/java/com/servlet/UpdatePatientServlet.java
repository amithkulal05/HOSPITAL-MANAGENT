package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HospitalDAO;
import com.model.Patient;

@WebServlet("/updatePatient")
public class UpdatePatientServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            Patient p = new Patient();

            p.setPatientID(Integer.parseInt(req.getParameter("id")));
            p.setPatientName(req.getParameter("name"));
            p.setAge(Integer.parseInt(req.getParameter("age")));
            p.setGender(req.getParameter("gender"));
            p.setAdmissionDate(req.getParameter("date"));
            p.setAilment(req.getParameter("ailment"));
            p.setAssignedDoctor(req.getParameter("doctor"));

            HospitalDAO dao = new HospitalDAO();
            dao.updatePatient(p);

            res.sendRedirect(req.getContextPath() + "/display.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("Error: " + e.getMessage());
        }
    }
}