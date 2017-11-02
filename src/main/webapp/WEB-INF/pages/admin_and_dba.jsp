<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Title : ${title}</h1>
    <h1>Message : ${message}</h1>

    <security:authorize access= "hasAnyRole('ROLE_ADMIN','ROLE_DBA','ROLE_SUPERUSER', 'ROLE_USER')" var= "isUser"/>

    <div>
        <p>
            You have signed as:
            <security:authentication property= "principal.username"/>
        </p>
        <p>
            with role:
            <b><security:authentication property= "principal.authorities"/></b>
        </p>
    </div>

    <div>
        <ul>
            <li><a href= "<c:url value= "/j_spring_security_logout"/>">Logout</a></li>
            <li><a href="<c:url value="/" />">Home</a></li>
        </ul>
    </div>
</body>
</html>
