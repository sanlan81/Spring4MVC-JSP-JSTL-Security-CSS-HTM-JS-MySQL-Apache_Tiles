<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Registration page</title>
<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css"/>

        <div class="form-container-registration">

            <form:form method="POST" modelAttribute="user" class="form-horizontal" enctype="multipart/form-data">

                <div class="input-group input-sm">
                    <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>

                    <form:input type="text" path="username" name="username" value="" class="form-control" id="username"
                                placeholder="Enter Username"/>
                    <div class="has-error">
                        <form:errors path="username" class="help-inline"/>
                    </div>
                </div>
                <div class="input-group input-sm">
                    <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                    <span style="float: right" id="strengthValue">
                        </span>

                    <span style="float: right" id="strengthValue">
                        </span>
                    <form:input type="password" path="password" onkeyup="doAjax()" class="form-control" id="password"
                                name="password" placeholder="Enter Password"/>
                    <div class="has-error">
                        <form:errors path="password" class="help-inline"/>
                    </div>

                </div>

                <div class="input-group input-sm">
                    <label class="input-group-addon" for="passwordConfirm"><i class="fa fa-lock"></i></label>
                    <span style="float: right" id="strengthValu">
                        </span>
                    <form:input type="password" path="passwordConfirm" class="form-control" id="passwordConfirm"
                                name="passwordConfirm" placeholder="Confirm Password "/>
                    <div class="has-error">
                        <form:errors path="passwordConfirm" class="help-inline"/>
                    </div>
                </div>
                <div class=" input-sm">
                <div class="form-actions">
                    <input type="submit"
                           class="btn btn-block btn-primary btn-default" value="Submit">
                </div>
                    </div>
            </form:form>
</div>

<script src="/static/js/login.js"></script>


