<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Voting</title>
</head>
<body>

<button value = "add" style="margin: 10px">Add restaurant</button> <br>

<c:forEach items="${restaurants}" var="restaurant">
    <jsp:useBean id="restaurant" scope="page" type="wheretolunch.model.Restaurant"/>
    ${restaurant.name} <button value = "vote" style="margin: 10px">Vote</button> <button value = "edit" style="margin: 10px">Edit menu</button><br>
    <table cellpadding="10" border="1">

    <c:forEach items="${restaurant.dishes}" var="dish">
        <jsp:useBean id="dish" scope="page" type="wheretolunch.model.Dish"/>
        <tr>
                <td>${dish.description}</td>
                <td>${dish.price}</td>
        </tr>
    </c:forEach>
    </table> <br>
</c:forEach>

</body>
</html>
