<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Delete Patient</title>
</head>
<body>

<h2>Delete Patient</h2>

<form action="${pageContext.request.contextPath}/deletePatient" method="post">

    Patient ID:
    <input type="number" name="id" required><br><br>

    <input type="submit" value="Delete Patient">

</form>

<br><br>

<a href="index.jsp">Back</a>

</body>
</html>