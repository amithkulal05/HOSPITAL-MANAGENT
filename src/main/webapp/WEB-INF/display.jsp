<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.dao.HospitalDAO" %>
<%@ page import="com.model.Patient" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Patients</title>

<style>
body{
    font-family: Arial, sans-serif;
    margin: 30px;
}
table{
    border-collapse: collapse;
    width: 100%;
}
th, td{
    border: 1px solid black;
    padding: 8px;
    text-align: center;
}
th{
    background-color: lightgray;
}
a{
    text-decoration: none;
}
</style>

</head>
<body>

<h2>Patient Records</h2>

<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Gender</th>
    <th>Date</th>
    <th>Ailment</th>
    <th>Doctor</th>
    <th>Action</th>
</tr>

<%
try{
    HospitalDAO dao = new HospitalDAO();
    List<Patient> list = dao.getAllPatients();

    if(list != null && !list.isEmpty()){

        for(Patient p : list){
%>

<tr>
    <td><%= p.getPatientID() %></td>
    <td><%= p.getPatientName() %></td>
    <td><%= p.getAge() %></td>
    <td><%= p.getGender() %></td>
    <td><%= p.getAdmissionDate() %></td>
    <td><%= p.getAilment() %></td>
    <td><%= p.getAssignedDoctor() %></td>

    <td>
        <form action="deletePatient" method="post" 
              onsubmit="return confirm('Are you sure you want to delete?');">

            <input type="hidden" name="id" value="<%= p.getPatientID() %>">

            <input type="submit" value="Delete">
        </form>
    </td>
</tr>

<%
        }

    } else {
%>

<tr>
    <td colspan="8">No Records Found</td>
</tr>

<%
    }

}catch(Exception e){
%>

<tr>
    <td colspan="8">Error Loading Data</td>
</tr>

<%
}
%>

</table>

<br><br>

<a href="index.jsp">Back to Home</a>

</body>
</html>