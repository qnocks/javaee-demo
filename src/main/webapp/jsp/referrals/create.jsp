<%--
  Created by IntelliJ IDEA.
  User: qnocks
  Date: 12/31/20
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/referrals/create">
        <label for="patientRegistrationNumber"> Patient Registration Number
            <input type="text" id="patientRegistrationNumber" name="patientRegistrationNumber">
        </label>
        <label for="doctorFullName"> Doctor fullname
            <input type="text" id="doctorFullName" name="doctorFullName">
        </label>
        <label for="referralDate"> Referral Date
            <input type="text" id="referralDate" name="referralDate">
        </label>
        <input type="submit" value="Add">
    </form>
</body>
</html>
