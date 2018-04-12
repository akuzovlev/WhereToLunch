<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>


<form role="form" action="spring_security_check" method="post">
    <div>
        <input type="text" placeholder="Email" name="username">
    </div>
    <div>
        <input type="password" placeholder="Password" name="password">
    </div>
    <button type="submit">
        Войти
    </button>
</form>


</body>
</html>
