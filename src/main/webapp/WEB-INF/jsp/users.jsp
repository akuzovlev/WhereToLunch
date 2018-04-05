<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<table cellpadding="10" border="1">
<c:forEach items="${users}" var="user">
    <tr>
    <jsp:useBean id="user" scope="page" type="wheretolunch.model.User"/>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.admin}</td>
    </tr>
</c:forEach>

</body>
</html>
