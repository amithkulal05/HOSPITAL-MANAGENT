<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Patient Report</title>
</head>
<body>

<h2>Generate Patient Report</h2>

<form action="report" method="post">

Doctor Name:
<input type="text" name="doctor"><br><br>

OR Ailment:
<input type="text" name="ailment"><br><br>

OR Date Range:<br><br>

From:
<input type="date" name="from"><br><br>

To:
<input type="date" name="to"><br><br>

<input type="submit" value="Get Report">

</form>

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>