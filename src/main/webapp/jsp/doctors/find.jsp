<%--
  Created by IntelliJ IDEA.
  User: qnocks
  Date: 1/6/21
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">Home</a>

    <p>You can find a patient by full name or speciality</p>

    <form method="post" action="${pageContext.request.contextPath}/doctors/find">
        <label for="fullName"> Full Name
            <input type="text" id="fullName" name="fullName">
        </label>
        <label for="specialty"> Specialty
            <input type="text" id="specialty" name="specialty">
        </label>
        <input type="submit" value="Search">
    </form>
</body>
</html>
