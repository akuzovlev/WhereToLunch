
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Voting</title>
</head>
<body>

<%--<jsp:useBean id="dish" scope="page" type="wheretolunch.model.Dish"/>
<c:forEach items="${dish}" var="dish">

</c:forEach>--%>

Restaurant name   <button value = "vote">Vote</button>
<table cellspacing="10">
    <tr>
        <td>Fresh melon fruit salad</td>
        <td>2.30 $</td>
    </tr>
    <tr>
        <td>Zucchini light soup</td>
        <td>5.14 $</td>
    </tr>
    <tr>
        <td>Asparagus frittata</td>
        <td>7.14 $</td>
    </tr>
    <tr>
        <td>Baked apple</td>
        <td>1.04 $</td>
    </tr>
    <tr>
        <td>Green tea</td>
        <td>0.60 $</td>
    </tr>

</table>

</body>
</html>
