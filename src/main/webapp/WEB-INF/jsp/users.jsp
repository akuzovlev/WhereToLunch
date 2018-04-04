<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<c:forEach items="${users}" var="user">
    <jsp:useBean id="user" scope="page" type="wheretolunch.model.User"/>
    ${user.name}<br>
</c:forEach>

</body>
</html>
