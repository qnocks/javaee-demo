<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 28.11.2020
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>FullName</th>
            <th>Specialty</th>
            <th>OfficeNumber</th>
            <th>Schedule</th>
        </tr>
        <c:forEach items="${doctors}" var="doctor">
            <tr>
                <td>${doctor.fullName}</td>
                <td>${doctor.specialty}</td>
                <td>${doctor.officeNumber}</td>
                <td>${doctor.schedule}</td>
            </tr>
        </c:forEach>
        <a href="${pageContext.servletContext.contextPath}/create"></a>
    </table>
    <a href="${pageContext.request.contextPath}/doctors/create">Add new doctor</a>
</body>
</html>
