<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 16.01.2017
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2>Songs</h2>
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>title</th>
            <th>composer</th>
            <th>album</th>
            <th>description</th>
            <th>numberOfPages</th>
            <th>actions</th>
        </tr>
        <c:forEach items="${songs}" var="song">
            <tr>
                <td>${song.id}</td>
                <td>${song.title}</td>
                <td>${song.composer}</td>
                <td>${song.album}</td>
                <td>${song.description}</td>
                <td>${song.numberOfPages}</td>
                <td>
                    <a class="btn btn-success" href="/update?id=${song.id}">Edit</a>
                    <a class="btn btn-danger" href="/delete?id=${song.id}">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a class="btn btn-info" href="/insert">Create new song</a>
</div>
</body>
</html>
