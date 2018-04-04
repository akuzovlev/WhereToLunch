<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Voting</title>
</head>
<body>


<c:forEach items="${restaurants}" var="restaurant">
    <jsp:useBean id="restaurant" scope="page" type="wheretolunch.model.Restaurant"/>
    ${restaurant.name} <br> <button value = "vote">Vote</button> <br>
    <table cellspacing="10">

    <c:forEach items="${restaurant.dishes}" var="dish">
        <jsp:useBean id="dish" scope="page" type="wheretolunch.model.Dish"/>
        <tr>
                <td>${dish.description}</td>
                <td>${dish.price}</td>
        </tr>
    </c:forEach>
    </table>
</c:forEach>

</body>
</html>
