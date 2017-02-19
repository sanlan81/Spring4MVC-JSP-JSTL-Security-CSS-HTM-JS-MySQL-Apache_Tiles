<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="form-container">

    <h1>Add new song</h1>

    <form:form method="POST"   modelAttribute="song" class="form-horizontal"  enctype="multipart/form-data">

        <div class="row">
            <div class="form-group col-md-12">
                <label class="control-label col-sm-2" for="title">Title:</label>
                <div class="col-sm-10">
                    <form:input type="text" path="title"  name="title" value="" class="form-control" id="title" placeholder="Enter song's title"/>
                    <div class="has-error">
                        <form:errors path="title" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="control-label col-sm-2" for="composer">Composer:</label>
                <div class="col-sm-10">
                    <form:input type="text" path="composer"  name="composer" value="" class="form-control" id="composer" placeholder="Enter composer name"/>
                    <div class="has-error">
                        <form:errors path="composer" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="control-label col-sm-2" for="album">Album:</label>
                <div class="col-sm-10">
                    <form:input type="text" path="album"  name="album" value="" class="form-control" id="album" placeholder="Enter album"/>
                    <div class="has-error">
                        <form:errors path="album" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="control-label col-sm-2" for="description">Description:</label>
                <div class="col-sm-10">
                    <form:textarea type="text" path="description"  name="Description" value="" class="form-control" id="description" placeholder="Describe new song"/>
                    <div class="has-error">
                        <form:errors path="description" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="control-label col-sm-2" for="numberOfPages">Number Of Pages:</label>
                <div class="col-sm-10">
                    <form:input type="text" path="numberOfPages"  name="numberOfPages" value="" class="form-control" id="numberOfPages" placeholder="Enter Number Of Pages"/>
                    <div class="has-error">
                        <form:errors path="numberOfPages" class="help-inline"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="file" name="file" id="myFile" multiple size="50">
                <div class="has-error">
                    <form:errors path="file" class="help-inline"/>
                </div>
                <p id="demo"></p>

            </div>
        </div>
        <div class="row">
            <div class="form-actions floatRight">
                <button type="submit" class="btn btn-default">Create</button>
            </div>
        </div>
    </form:form>
</div>

<script  src="/static/js/create.js"></script>

