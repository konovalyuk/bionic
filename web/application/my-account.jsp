<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="user" uri="/WEB-INF/tags/userTags.tld" %>
<%@ taglib prefix="page" uri="/WEB-INF/tags/pageTags.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/global.css">
    <title></title>
</head>
<body>
    <page:header/>
    Welcome, <user:info/>
    <br>
    Friends:
    <c:forEach items="${friends}" var="friend" varStatus="num">
        <li> ${friend.firstName} ${friend.lastName}</li>
    </c:forEach>
</body>
</html>