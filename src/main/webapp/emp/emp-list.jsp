<%@ page import="com.example.domain.emp.vo.Employees" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee List</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
      $(function () {
        // javascript code here
      });
    </script>
</head>
<%
    List<Employees> list = (List<Employees>) request.getAttribute("list");
%>
<body>
<h1>Employee List</h1>
<table border="1">
    <thead>
    <tr>
        <th>Employee ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Hire Date</th>
        <th>Salary</th>
        <th>Commission Pct</th>
        <th>Manager ID</th>
        <th>Department ID</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${list}">
        <tr>
            <td>${employee.employeeId}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.email}</td>
            <td>${employee.phoneNumber}</td>
            <td>${employee.hireDate}</td>
            <td>${employee.salary}</td>
            <td>${employee.commissionPct}</td>
            <td>${employee.managerId}</td>
            <td>${employee.departmentId}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>