<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 28.11.2020
  Time: 14:12
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
            <th>Id</th>
            <th>RegistrationNumber</th>
            <th>FullName</th>
            <th>BirthDate</th>
            <th>Address</th>
            <th>Job</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${patients}" var="patient">
            <tr>
                <td>${patient.id}</td>
                <td>${patient.registrationNumber}</td>
                <td>${patient.fullName}</td>
                <td>${patient.birthDate}</td>
                <td>${patient.address}</td>
                <td>${patient.job}</td>
                <td><a href="${pageContext.servletContext.contextPath}/${patient.id}/update">Edit</a></td>
                <td><a href="${pageContext.servletContext.contextPath}/${patient.id}/delete">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/patients/create">Add new patient</a>
</body>
</html>
