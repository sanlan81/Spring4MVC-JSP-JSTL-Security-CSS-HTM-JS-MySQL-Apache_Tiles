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
    <div class="row">
            <h2>Songs</h2>

        <c:forEach items="${songs}" var="song">
            <div class="col-sm-4">
                    ${song.title}<br>
                <img class="img-rounded" src="/resources/uploads/${song.fileName}"
                     width="300" height="300" alt="${song.fileName}"/><br><br>
                    <%--    <td> ${song.id}</td><br>
                        <td>${song.composer}</td></br>
                        <td>${song.album}</td><br>
                        <td>${song.description}</td><br>
                        <td>${song.numberOfPages}</td><br>
                        <td>${song.fileName}</td><br>--%>
                <a class="btn btn-success" href="/update?id=${song.id}">To see this song</a></br></br>
                    <%--<td>
                        <a class="btn btn-danger" href="/delete?id=${song.id}">Remove</a>
                    </td>--%>
            </div>
        </c:forEach>
    </div>
    <%-- <a class="btn btn-info" href="/insert">Create new song</a>--%>
</div>

</body>
</html>