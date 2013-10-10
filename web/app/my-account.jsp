<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/global.css">
    <title></title>
</head>
<body>
<%@ include file="/header.jsp"%>
    Welcome, ${loggedUser}
    <br>
    Friends:
    <c:forEach items="${friends}" var="friend" varStatus="num">
        <li> ${friend.firstName} ${friend.lastName}</li>
    </c:forEach>
</body>
</html>