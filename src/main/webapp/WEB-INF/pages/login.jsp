<%@ page language= "java" contentType= "text/html; charset=UTF-8" pageEncoding= "UTF-8"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "spring" uri= "http://www.springframework.org/tags"%>
<%@ taglib prefix= "security" uri= "http://www.springframework.org/security/tags" %>

<html>
<head></head>
<body>
    <h1>Login page</h1>


    <security:authorize access= "hasAnyRole('ROLE_ADMIN','ROLE_DBA','ROLE_SUPERUSER', 'ROLE_USER')" var= "isUser"/>

    <c:if test= "${not isUser}">
        <form name="authorization_form" action="/j_spring_security_check" method="post">
            <c:if test= "${empty param.error and empty param.logout}">
                <p>You haven't signed in!</p>
            </c:if>

            <c:if test="${not empty param.logout}">
                <p>You have successfully logged out!</p>
            </c:if>

            <c:if test= "${not empty param.error}">
                <p class="red_text"><b>Bad credentials!</b></p>
            </c:if>

            <h2>Please, sign in:</h2>

            <label for= "inputEmail" >Email</label>
            <input id= "inputEmail" name= "j_username" required autofocus/>

            <label for= "inputPassword" >Password</label>
            <input type= "password" id= "inputPassword" name= "j_password" required/>

            <input type= "submit" value= "Sign in" >
        </form>
    </c:if>

    <c:if test= "${isUser}">
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


        <div><a href= "<c:url value= "/j_spring_security_logout"/>">Logout</a></div>
    </c:if>

    <div><a href="<c:url value="/" />">Home</a></div>
</body>
</html>
