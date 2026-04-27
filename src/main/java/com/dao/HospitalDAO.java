package com.dao;

import java.sql.*;
import java.util.*;
import com.model.Patient;

public class HospitalDAO {

    // DATABASE CONNECTION
    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospitaldbms",
                "root",
                "password"
        );
    }

    // ADD PATIENT
    public void addPatient(Patient p) throws Exception {

        String query = "INSERT INTO Patients " +
                "(patientID, patientName, age, gender, admissionDate, ailment, assignedDoctor) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, p.getPatientID());
            ps.setString(2, p.getPatientName());
            ps.setInt(3, p.getAge());
            ps.setString(4, p.getGender());
            ps.setString(5, p.getAdmissionDate());
            ps.setString(6, p.getAilment());
            ps.setString(7, p.getAssignedDoctor());

            ps.executeUpdate();
        }
    }

    // DISPLAY ALL PATIENTS
    public List<Patient> getAllPatients() throws Exception {

        List<Patient> list = new ArrayList<>();
        String query = "SELECT * FROM Patients";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {

                Patient p = new Patient();

                p.setPatientID(rs.getInt("patientID"));
                p.setPatientName(rs.getString("patientName"));
                p.setAge(rs.getInt("age"));
                p.setGender(rs.getString("gender"));
                p.setAdmissionDate(rs.getString("admissionDate"));
                p.setAilment(rs.getString("ailment"));
                p.setAssignedDoctor(rs.getString("assignedDoctor"));

                list.add(p);
            }
        }

        return list;
    }

    // DELETE PATIENT
    public void deletePatient(int id) throws Exception {

        String query = "DELETE FROM Patients WHERE patientID=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // GET PATIENT BY ID
    public Patient getPatientById(int id) throws Exception {

        Patient p = null;
        String query = "SELECT * FROM Patients WHERE patientID=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    p = new Patient();

                    p.setPatientID(rs.getInt("patientID"));
                    p.setPatientName(rs.getString("patientName"));
                    p.setAge(rs.getInt("age"));
                    p.setGender(rs.getString("gender"));
                    p.setAdmissionDate(rs.getString("admissionDate"));
                    p.setAilment(rs.getString("ailment"));
                    p.setAssignedDoctor(rs.getString("assignedDoctor"));
                }
            }
        }

        return p;
    }

    // UPDATE PATIENT
    public void updatePatient(Patient p) throws Exception {

        String query = "UPDATE Patients SET patientName=?, age=?, gender=?, admissionDate=?, ailment=?, assignedDoctor=? WHERE patientID=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, p.getPatientName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getGender());
            ps.setString(4, p.getAdmissionDate());
            ps.setString(5, p.getAilment());
            ps.setString(6, p.getAssignedDoctor());
            ps.setInt(7, p.getPatientID());

            ps.executeUpdate();
        }
    }

    // REPORT BY DOCTOR
    public List<Patient> getByDoctor(String doctor) throws Exception {

        List<Patient> list = new ArrayList<>();
        String query = "SELECT * FROM Patients WHERE assignedDoctor=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, doctor);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Patient p = new Patient();

                    p.setPatientID(rs.getInt("patientID"));
                    p.setPatientName(rs.getString("patientName"));
                    p.setAge(rs.getInt("age"));
                    p.setGender(rs.getString("gender"));
                    p.setAdmissionDate(rs.getString("admissionDate"));
                    p.setAilment(rs.getString("ailment"));
                    p.setAssignedDoctor(rs.getString("assignedDoctor"));

                    list.add(p);
                }
            }
        }

        return list;
    }

    // REPORT BY AILMENT
    public List<Patient> getByAilment(String ailment) throws Exception {

        List<Patient> list = new ArrayList<>();
        String query = "SELECT * FROM Patients WHERE ailment=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, ailment);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Patient p = new Patient();

                    p.setPatientID(rs.getInt("patientID"));
                    p.setPatientName(rs.getString("patientName"));
                    p.setAge(rs.getInt("age"));
                    p.setGender(rs.getString("gender"));
                    p.setAdmissionDate(rs.getString("admissionDate"));
                    p.setAilment(rs.getString("ailment"));
                    p.setAssignedDoctor(rs.getString("assignedDoctor"));

                    list.add(p);
                }
            }
        }

        return list;
    }

    // REPORT BY DATE RANGE
    public List<Patient> getByDateRange(String from, String to) throws Exception {

        List<Patient> list = new ArrayList<>();
        String query = "SELECT * FROM Patients WHERE admissionDate BETWEEN ? AND ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, from);
            ps.setString(2, to);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Patient p = new Patient();

                    p.setPatientID(rs.getInt("patientID"));
                    p.setPatientName(rs.getString("patientName"));
                    p.setAge(rs.getInt("age"));
                    p.setGender(rs.getString("gender"));
                    p.setAdmissionDate(rs.getString("admissionDate"));
                    p.setAilment(rs.getString("ailment"));
                    p.setAssignedDoctor(rs.getString("assignedDoctor"));

                    list.add(p);
                }
            }
        }

        return list;
    }
}