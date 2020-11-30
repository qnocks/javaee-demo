<%--
  Created by IntelliJ IDEA.
  User: 1
  Date: 28.11.2020
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/patients/create">
        <label for="registrationNumber"> Registration Number
            <input type="text" id="registrationNumber" name="registrationNumber">
        </label>
        <label for="fullName"> Full Name
            <input type="text" id="fullName" name="fullName">
        </label>
        <label for="birthDate"> Birth Date
            <input type="text" id="birthDate" name="birthDate">
        </label>
        <label for="address"> Address
            <input type="text" id="address" name="address">
        </label>
        <label for="job"> Job
            <input type="text" id="job" name="job">
        </label>
        <input type="submit" value="Add">
    </form>
</body>
</html>
