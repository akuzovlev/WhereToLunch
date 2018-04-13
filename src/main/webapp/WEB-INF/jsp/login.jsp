<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<br><br><br><br>
<div align="center">
<form role="form" action="spring_security_check" method="post">
    <div>
        <input type="text" placeholder="Email" name="username">
    </div><br>
    <div>
        <input type="password" placeholder="Password" name="password">
    </div><br>
    <button type="submit">
        Войти
    </button>
</form>
</div>

</body>
</html>
