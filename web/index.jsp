<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" uri="/WEB-INF/tags/pageTags.tld" %>
<%@ taglib prefix="user" uri="/WEB-INF/tags/userTags.tld" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/global.css">
    <title></title>
</head>

<body>
<user:clearUser/>
<page:header/>
<form name="loginForm" action="/app" method="POST">
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
<hr>
<div>Don't have account yet? <a href="/registration.jsp"> Register for free!</a></div>
<page:footer/>
</body>
</html>