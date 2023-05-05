<%@ page import="com.example.domain.dep.vo.Departments" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
      $(function () {

      });
    </script>
</head>
<%
    List<Departments> depList = (List<Departments>) request.getAttribute("depList");
%>
<body>
<h1>Department List</h1>
<table border="1">
    <thead>
    <tr>
        <th>Department ID</th>
        <th>Department Name</th>
        <th>Manager Id</th>
        <th>Location Id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="departments" items="${depList}">
        <tr>
            <td>${departments.departmentId}</td>
            <td>${departments.departmentName}</td>
            <td>${departments.managerId}</td>
            <td>${departments.locationId}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
