<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Title : ${title}</h1>
    <h1>Message : ${message}</h1>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Welcome : ${pageContext.request.userPrincipal.name}
            | <a href="<c:url value="/logout" />" > Logout</a></h2>
    </c:if>
</body>
</html>
