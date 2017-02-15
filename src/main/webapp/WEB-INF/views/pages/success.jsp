<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Song Detail Confirmation</title>
	<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>

	<div class="success">
		Confirmation message : song ${success}
		<br>
	<%--	We have also sent you a confirmation mail to your email address : ${song.title}.--%>
	</div>
