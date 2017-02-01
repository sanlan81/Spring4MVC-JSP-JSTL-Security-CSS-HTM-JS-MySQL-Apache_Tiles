<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 17.01.2017
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Edit song ${song.title} </title>
</head>
<body>
<div class="container">
    <h2>Edit ${song.title} </h2>

    <form class="form-horizontal" method="POST">
        <div class="form-group">
            <%--@declare id="email"--%><label class="control-label col-sm-2" for="email">Title:</label>
            <div class="col-sm-10">
                <input type="text" required name="title" value="${song.title}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <%--@declare id="pwd"--%><label class="control-label col-sm-2" for="pwd">Composer:</label>
            <div class="col-sm-10">
                <input type="text" required name="composer" value="${song.composer}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <%--@declare id="pwd"--%><label class="control-label col-sm-2" for="pwd">Album:</label>
            <div class="col-sm-10">
                <input type="text" required name="album" value="${song.album}" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <%--@declare id="pwd"--%><label class="control-label col-sm-2" for="pwd">Description:</label>
            <div class="col-sm-10">
                <textarea type="text" required name="description" value="${song.description}" class="form-control">${song.description}</textarea>
            </div>
        </div>

        <div class="form-group">
            <%--@declare id="pwd"--%><label class="control-label col-sm-2" for="pwd">Number Of Pages:</label>
            <div class="col-sm-10">
                <input type="text" required name="numberOfPages" value="${song.numberOfPages}" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Update</button>
            </div>
        </div>
    </form>

    <a href="/">&lt; Back to songs list</a>
</div>
</body>
</html>
