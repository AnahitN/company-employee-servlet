<%@ page import="com.example.companyemployeeservlet.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body style="background-color: lightpink">
<%User user = (User) session.getAttribute("user");%>
Welcome <%=user.getName()%> <a href="logout"> Logout </a> <br>

<a href ="/employees"> Employees </a> |
<a href ="/companies"> Companies </a>

</body>
</html>
