<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 25.11.2020
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Welcome to site from JSP!</h1>
    <a href="${pageContext.servletContext.contextPath}/doctors">Check the doctors list</a>
    <a href="${pageContext.servletContext.contextPath}/patients">Check the patients list</a>

</body>
</html>
