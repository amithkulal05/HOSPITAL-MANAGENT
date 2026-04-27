<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Hospital Reports</title>
</head>
<body>

<h2>Hospital Reports</h2>

<form action="report_form.jsp" method="get">

<h3>Select Report Type:</h3>

<input type="radio" name="type" value="doctor" required>
Patients by Doctor <br><br>

<input type="radio" name="type" value="ailment">
Patients by Ailment <br><br>

<input type="radio" name="type" value="date">
Patients by Date Range <br><br>

<input type="submit" value="Generate Report">

</form>

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>