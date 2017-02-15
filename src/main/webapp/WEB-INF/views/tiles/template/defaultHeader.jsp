<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">My Super Score</a>
			<%--logo--%>
			<%--<a href="${pageContext.request.contextPath}/"><img class="logo" src="${pageContext.request.contextPath}/static/img/MySuperScore.jpg"></a>--%>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="${pageContext.request.contextPath}/">Home</a></li>

			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Page 1-1</a></li>
					<li><a href="#">Page 1-2</a></li>
					<li><a href="#">Page 1-3</a></li>
				</ul>
			</li>
			<li><a href="${pageContext.request.contextPath}/products">All Songs</a></li>
			<li><a href="${pageContext.request.contextPath}/create">Add Song</a></li>
		</ul>
		<form class="navbar-form navbar-left">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</nav>
