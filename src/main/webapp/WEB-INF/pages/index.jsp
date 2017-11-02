<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <security:authorize access= "hasAnyRole('ROLE_ADMIN','ROLE_DBA','ROLE_SUPERUSER', 'ROLE_USER')" var= "isUser"/>

    <c:if test= "${isUser}">
        <div>
            <p>
                Hello, <security:authentication property= "principal.username"/>!
            </p>
            <a href= "<c:url value= "/j_spring_security_logout"/>">Logout</a>
        </div>
    </c:if>

    <c:if test="${not isUser}">
        <a href="/login">Sign in</a>
    </c:if>


    <h1>Hello in our shop!</h1>
    <div>
        <ul>
            <li><a href="/category/">List of categories</a></li>
            <li><a href="/product/all/">All products</a></li>
            <li><a href="/cart/">Adding to cart (testing)</a></li>
        </ul>
    </div>

    <div>
        <ul>
            <li><a href="/admin">only for admin</a></li>
            <li><a href="/dba">only for dba</a></li>
        </ul>
    </div>
</body>
</html>