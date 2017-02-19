<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div class="container">
    <div class="row">
        <h2>Songs</h2>

        <form method="GET">
            <div class=«well»>
            <div class="form-group">
                <input type="text" name="title" value="${title}"  class="form-control" placeholder="Title">
            </div>
            <div class="form-group">
                <input type="text" name="composer" value="${composer}"  class="form-control" placeholder="Composer">
            </div>
                <div class="form-group">
                    <input type="text" name="album" value="${album}"  class="form-control" placeholder="Album">
                </div>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary" value="Search"/><br><br>
            </div>
        </form>

        <c:forEach items="${songs}" var="song">
            <div class="col-sm-4">
                    ${song.title}<br>
                <img class="img-rounded" src="/resources/uploads/${song.fileName}"
                     width="300" height="300" alt="${song.fileName}"/><br>
                <td>by    ${song.composer}</td><br>
                <a class="btn btn-success" href="/${song.id}">To see this song</a></br></br>
            </div>
        </c:forEach>
    </div>
</div>

