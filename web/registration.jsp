<%--
  User: alex
  Date: 10/8/13
  Time: 8:41 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/bionic/css/global.css">
    <title></title>
</head>
<body>
    <form action="/bionic/app" method="POST">
        <h5>Please, fill the form</h5>
        <input type="hidden" name="cmd" value="registration">
        <label for="firstName">First Name</label> <input id="firstName" name="firstName" type="text"/><br>
        <label for="lastName">Last Name</label> <input id="lastName" name="lastName" type="text"/><br>
        <label for="email"></label>Email <input id="email" name="email" type="text"/><br>
        <label for="sex"></label>
        <select id="sex" name="sex">
            <option value="1">Male</option>
            <option value="0">Female</option>
        </select><br>
        <label for="phoneNumber"></label> <input id="phoneNumber" name="phoneNumber" type="text"/><br>
        <label for="passwd1"></label> <input id="passwd1" name="passwd1" type="password"/><br>
        <label for="passwd2"></label> <input id="passwd2" name="passwd2" type="password"/><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>