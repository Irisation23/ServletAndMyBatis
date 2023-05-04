<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="com.example.conf.SqlSessionManager" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.domain.emp.vo.Employees" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    SqlSessionFactory sessionFactory = SqlSessionManager.getSqlSessionFactory();
    SqlSession sqlSession = sessionFactory.openSession();

    List<Employees> findAll = sqlSession.selectList("findAll");

    for (Employees employees : findAll) {
        out.println(employees);
    }
%>

<%--EMP <%=sqlSession.selectList("findAll") %>--%>

</body>
</html>
