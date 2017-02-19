<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div class="container">
    <h2>Song ${song.title} <br></h2>
    <div class="row">
        <div class="col-sm-4">
            <td> by ${song.composer}</td>
            </br>
            <img class="img-rounded" src="/resources/uploads/${song.fileName}"
                 width="300" height="300" alt="${song.fileName}"/><br><br>
            <a class="btn btn-success" href="/update/${song.id}">Update</a>
            <a class="btn btn-danger" href="/delete/${song.id}">Remove</a>
        </div>
        <div class="col-sm-6">
            <h3>From  album  ${song.album}</h3>
            <br>
            <td>${song.description}</td>
            <br>
            <td>Total : ${song.numberOfPages} pages</td>
            <br>
        </div>
    </div>
</div>