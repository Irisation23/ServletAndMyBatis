<%@ page import="com.example.domain.sal.vo.SalGrades" %>
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
    List<SalGrades> salList = (List<SalGrades>) request.getAttribute("salList");
    System.out.println(salList.size());
%>
<body>

<h1>Salgrades List</h1>
<table border="1">
    <thead>
    <tr>
        <th>Grade</th>
        <th>LoSal</th>
        <th>HiSal</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="salList" items="${salList}">
        <tr>
            <td>${salList.grade}</td>
            <td>${salList.losal}</td>
            <td>${salList.hisal}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
