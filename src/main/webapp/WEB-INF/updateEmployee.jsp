<%@ page import="com.example.companyemployeeservlet.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
<%Employee employee = (Employee) request.getAttribute("employee");%>
<a href="/employees"> Back </a>
<h2> Update Employee </h2>
<form action="/updateEmployee" method="post">
  <input name="id" type="hidden" value="<%=employee.getId()%>">
  name: <input type="text" name="name" value="<%=employee.getName()%>">
  surname: <input type="text" name="surname" value="<%=employee.getSurname()%>">
  email: <input type="text" name="email" value="<%=employee.getEmail()%>">
  company:<input type="text" name="company" value="<%=employee.getCompany()%>">
  <input type="submit" value="update">
</form>
</body>
</html>
