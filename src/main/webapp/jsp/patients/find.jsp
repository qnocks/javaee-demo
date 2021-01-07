<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">Home</a>

    <p>You can find a patient by Registration Number or full name</p>

    <form method="post" action="${pageContext.request.contextPath}/patients/find">
        <label for="registrationNumber"> Registration Number
            <input type="text" id="registrationNumber" name="registrationNumber">
        </label>
        <label for="fullName"> Full Name
            <input type="text" id="fullName" name="fullName">
        </label>
        <input type="submit" value="Search">
    </form>

</body>
</html>
