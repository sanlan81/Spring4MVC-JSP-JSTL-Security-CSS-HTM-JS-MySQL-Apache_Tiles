<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">My Super Score</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/create">Add Song</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <c:choose>
                <c:when test="${not empty pageContext.request.userPrincipal}">
                    <li><a href="/profile">Hello, <c:out value="${pageContext.request.userPrincipal.name}"/></a>
                    </li>
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
                    <li><a href="/registration"><span class="glyphicon glyphicon-plus-sign"></span> Sign up</a></li>
                </c:otherwise>
            </c:choose>

        </ul>
    </div>
</nav>
