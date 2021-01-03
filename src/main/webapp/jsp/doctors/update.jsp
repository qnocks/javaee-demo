<%--
  Created by IntelliJ IDEA.
  User: qnocks
  Date: 1/3/21
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/doctors/update/${id}">
        <label for="fullName"> Full name
            <input type="text" id="fullName" name="fullName" value="${fullName}">
        </label>
        <label for="specialty"> Specialty
            <input type="text" id="specialty" name="specialty" value="${specialty}">
        </label>
        <label for="officeNumber"> OfficeNumber
            <input type="text" id="officeNumber" name="officeNumber" value="${officeNumber}">
        </label>
        <label for="schedule"> Schedule
            <input type="text" id="schedule" name="schedule" value="${schedule}">
        </label>
        <input type="submit" value="Add">
    </form>
</body>
</html>
