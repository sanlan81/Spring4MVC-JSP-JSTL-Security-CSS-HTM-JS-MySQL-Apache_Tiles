<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 16.01.2017
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Create New Song</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
</head>
<body onload="myFunction()">

<div class="container">
    <h2>Add next song</h2>
    <form class="form-horizontal"  method="POST">
        <div class="form-group">
            <label class="control-label col-sm-2" for="title">Title:</label>
            <div class="col-sm-10">
                <input  type="text" path="title"  name="title" value="" class="form-control" id="title" placeholder="Enter song's title"/>

            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Composer:</label>
            <div class="col-sm-10">
                <input type="text" required name="composer" value="" class="form-control" id="pwd" placeholder="Enter composer name">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Year of Issue:</label>
            <div class="col-sm-10">
                <input type="text" required name="album" value="" class="form-control" id="pw" placeholder="Enter year of issue">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Description:</label>
            <div class="col-sm-10">
                <textarea type="text" required name="description" value="" class="form-control" rows="5" id="comment" placeholder="Describe your song "></textarea>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Number Of Pages:</label>
            <div class="col-sm-10">
                <input type="text" name="numberOfPages" required  value="" class="form-control" id="p" placeholder="Enter number of pages">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="file" id="myFile" multiple size="50" onchange="myFunction()">

                <p id="demo"></p>

                <script>
                    function myFunction(){
                        var x = document.getElementById("myFile");
                        var txt = "";
                        if ('files' in x) {
                            if (x.files.length == 0) {
                                txt = "Select  file.";
                            } else {
                                for (var i = 0; i < x.files.length; i++) {
                                    txt += "<br><strong>" + (i+1) + ". file</strong><br>";
                                    var file = x.files[i];
                                    if ('name' in file) {
                                        txt += "name: " + file.name + "<br>";
                                    }
                                    if ('size' in file) {
                                        txt += "size: " + file.size + " bytes <br>";
                                    }
                                }
                            }
                        }
                        else {
                            if (x.value == "") {
                                txt += "Select file.";
                            } else {
                                txt += "The files property is not supported by your browser!";
                                txt  += "<br>The path of the selected file: " + x.value; // If the browser does not support the files property, it will return the path of the selected file instead.
                            }
                        }
                        document.getElementById("demo").innerHTML = txt;
                    }
                </script>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Create</button>
            </div>
        </div>
    </form>

    <a href="/">&lt; Back to songs list</a>
</div>
</body>
</html>
