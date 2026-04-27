<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Patient</title>

<style>
body{
    font-family: Arial, sans-serif;
    margin: 30px;
}
input{
    padding: 6px;
    margin: 4px;
}
</style>

</head>
<body>

<h2>Update Patient</h2>

<form action="<%=request.getContextPath()%>/updatePatient" method="post">

Patient ID:
<input type="text" name="id" required>
<br><br>

Name:
<input type="text" name="name" required>
<br><br>

Age:
<input type="text" name="age" required>
<br><br>

Gender:
<input type="text" name="gender" required>
<br><br>

Date:
<input type="date" name="date" required>
<br><br>

Ailment:
<input type="text" name="ailment" required>
<br><br>

Doctor:
<input type="text" name="doctor" required>
<br><br>

<input type="submit" value="Update Patient">

</form>

<br><br>

<a href="index.jsp">Back</a>

</body>
</html>