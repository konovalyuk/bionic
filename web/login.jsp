<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>
    <form action="/bionic/app" method="POST">
        <input type="hidden" name="cmd" value="login"/>
        <input type="text" id="login" name="login"/><label for="login"> : Login</label> <br>
        <input type="text" id="password" name="password"/> <label for="password"> : Password</label><br>
        <input type="submit"/>
    </form>
</body>
</html>