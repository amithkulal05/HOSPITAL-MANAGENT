<%@ page import="java.util.*,com.model.Patient" %>

<!DOCTYPE html>
<html>
<head>
<title>Report Result</title>
</head>
<body>

<h2>Patient Report Result</h2>

<table border="1" cellpadding="8" cellspacing="0">

<tr>
<th>ID</th>
<th>Name</th>
<th>Age</th>
<th>Gender</th>
<th>Admission Date</th>
<th>Ailment</th>
<th>Doctor</th>
</tr>

<%
List<Patient> list = (List<Patient>) request.getAttribute("reportData");

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
</tr>

<%
    }
} else {
%>

<tr>
<td colspan="7">No Records Found</td>
</tr>

<%
}
%>

</table>

<br>
<a href="reports.jsp">Back to Reports</a><br><br>
<a href="index.jsp">Back to Home</a>

</body>
</html>