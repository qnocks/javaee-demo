<%--
  Created by IntelliJ IDEA.
  User: qnocks
  Date: 12/31/20
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">Home</a>
    <table>
        <tr>
            <th>Patient registration Number</th>
            <th>Doctor FullName</th>
            <th>ReferralDate</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${referrals}" var="referral">
            <tr>
                <td>${referral.patientRegistrationNumber}</td>
                <td>${referral.doctorFullName}</td>
                <td>${referral.referralDate}</td>
                <td><a href="${pageContext.request.contextPath}/referrals/update/${referral.id}">Edit</a></td>
                <td><a href="${pageContext.request.contextPath}/referrals/delete/${referral.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/referrals/create">Add new referral</a>
</body>
</html>
