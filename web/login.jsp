<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/global.css">
    <title></title>
</head>

<body>
    <form action="/app" method="POST">
        <div>
            <input type="hidden" name="cmd" value="login"/>
            <label for="login" class="inline width200">Login</label>
            <input type="text" id="login" name="login" value="${login}"/> <br>
            <label for="password" class="inline width200">Password</label>
            <input type="password" id="password" name="password"/><br>
            <input type="submit" value="Login"/>
        </div>
        <script>
            <c:if test="${invalidLogin}">
                alert('Please, check your credentials');
            </c:if>
        </script>
    </form>
</body>
</html>