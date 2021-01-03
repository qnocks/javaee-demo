<%--
  Created by IntelliJ IDEA.
  User: qnocks
  Date: 1/3/21
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/referrals/update/${id}">
        <label for="patientRegistrationNumber"> Registration Number
            <input type="text" id="patientRegistrationNumber" name="patientRegistrationNumber" value="${patientRegistrationNumber}">
        </label>
        <label for="doctorFullName"> Full name
            <input type="text" id="doctorFullName" name="doctorFullName" value="${doctorFullName}">
        </label>
        <label for="referralDate"> BirthDate
            <input type="text" id="referralDate" name="referralDate" value="${referralDate}">
        </label>
        <input type="submit" value="Add">
    </form>
</body>
</html>
