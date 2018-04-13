<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Voting</title>
</head>
<body>

<button onclick="window.location.href='/editMenu?id=0'" value = "add" style="margin: 10px">Add restaurant</button> <br><br>

<c:forEach items="${restaurants}" var="restaurant">
    <jsp:useBean id="restaurant" scope="page" type="wheretolunch.model.Restaurant"/>

    ${restaurant.name}
    <form action="/vote/${restaurant.id}" method="post" style="display: inline-block;}">
        <button type="submit" style="margin: 10px">Vote</button>
    </form>
     <button onclick="window.location.href='/editMenu?id=${restaurant.id}'" value = "edit" style="margin: 10px">Edit menu</button><br>
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
