<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/half-slider.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style type="text/css">
.left-inner-addon {
	position: relative;
}

.left-inner-addon input {
	padding-left: 30px;
}

.left-inner-addon i {
	position: absolute;
	padding: 10px 12px;
	pointer-events: none;
}

.right-inner-addon {
	position: relative;
}

.right-inner-addon input {
	padding-right: 30px;
}

.right-inner-addon i {
	position: absolute;
	right: 0px;
	padding: 10px 12px;
	pointer-events: none;
}
.flable {  
 color: gray;  
}  
  
.status {  
 font-family: verdana;  
 font-size: 12px;  
}  
  
.uname {  
 color: blue;  
}  
</style>
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="landingPage.action">Happy Being Us</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
					<c:if test="${null!=user}">
					<li><a href="loadUserTopicsPage.action"><b>Topics</b></a></li>
					</c:if>
				</ul>
				
			
				<ul class="nav navbar-nav navbar-right">
				<c:if test="${null==user}">
					<li><a href="#SignUpDaughter" data-toggle="modal"><span
							class="glyphicon glyphicon-user"></span> Sign Up Daughter</a></li>
					<li><a href="#SignUpMom" data-toggle="modal"
						id="signUpMomLink"><span class="glyphicon glyphicon-user"></span>
							Sign Up Mom </a></li>
					<li><a href="#Login" data-toggle="modal"><span
							class="glyphicon glyphicon-log-in"></span> Login </a></li>
				</c:if>
				<c:if test="${null!=user}">
				<li><a><span class="glyphicon glyphicon-user"></span>  Welcome, <b> ${user.firstName}</b></a></li>
				<li><a href="logout.action"><span
							class="glyphicon glyphicon-log-out"></span> Logout </a></li>
				</c:if>
				</ul>				
			</div>
		</div>
	</nav>
	<!-- jQuery -->
		<script src="js/jquery.js"></script>
		
		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js"></script>
</body>
</html>