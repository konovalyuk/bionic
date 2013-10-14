<%@ taglib prefix="page" uri="/WEB-INF/tags/pageTags.tld" %>
<%--
  User: alex
  Date: 10/8/13
  Time: 8:41 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/global.css">
    <title></title>
</head>
<body>
    <page:header/>
    <form action="/app" method="POST">
        <h5>Please, fill the form</h5>
        <input type="hidden" name="cmd" value="registration">
        <label for="login" class="inline width200">Login</label><input id="login" name="login" type="text"/><br>
        <label for="firstName" class="inline width200">First Name</label><input id="firstName" name="firstName" type="text"/><br>
        <label for="lastName" class="inline width200">Last Name</label><input id="lastName" name="lastName" type="text"/><br>
        <label for="email" class="inline width200">Email</label><input id="email" name="email" type="text"/><br>
        <label for="sex" class="inline width200">Sex</label>
        <select id="sex" name="sex">
            <option value="1">Male</option>
            <option value="0">Female</option>
        </select><br>
        <label for="phoneNumber" class="inline width200">Phone  number</label><input id="phoneNumber" name="phoneNumber" type="text"/><br>
        <label for="passwd1" class="inline width200">Password</label><input id="passwd1" name="passwd1" type="password"/><br>
        <label for="passwd2" class="inline width200">Repeat your password</label><input id="passwd2" name="passwd2" type="password"/><br>
        <input type="submit" value="Register">
    </form>
    <page:footer/>
</body>
</html>