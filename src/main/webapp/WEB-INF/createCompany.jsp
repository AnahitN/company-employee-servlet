<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Company</title>
</head>
<% List<String> countries = (List<String>) request.getAttribute("countryList");%>
<body>
<a href="/companies">Back</a>
<h2> Create Company</h2>
<form action="/createCompany" method="post">
    name: <input type="text" name="name"><br><br>
    country:
    <select name="country">
        <% for (String country : countries) { %>
        <option value="<%=country%>"><%=country%></option>
<%}%>
    </select> <br><br>
    <input type="submit" value="create">
</form>
</body>
</html>
