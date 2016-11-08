<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Topics</title>
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
</style>
</head>

<body>
	<%@ include file="header.jsp"%>
	<!-- /.container -->
	<br></br>
	<div class="container">
		<div class="jumbotron" style="">
			<h1>My Topics</h1>
		</div>
		<div class="container" id="mytopics">
			<div class="container-fluid bg-3">
				<div class="row jumbotron" id="In progress">
					<h1 style="font-size: 300%;">To do</h1>
					<div class="col-sm-8">
						<c:forEach items="${topics}" var="topic" varStatus="topicNo">
							<c:if test="${topic.topicStatus.id <= 2}">
								<div class="topic_holder" style="padding: 10px">
									<div class="row">
										<div class="col-sm-4">
											<h2 class="">
												<span id="topic_name_${topic.id}">${topic.topicName}</span>
											</h2>
										</div>
										<div class="col-sm-8" style="padding: 20px">
											<div class="progress" style="width: 100%">
												<div class="progress-bar progress-bar-success"
													role="progressbar" style="width: ${topic.progress}%">${topic.progress}
													% Complete</div>
											</div>
										</div>
									</div>
									<br>
									<table style="border-spacing: 10px">
										<tbody>
											<tr>
												<c:forEach items="${topic.activityContainers}"
													var="activityContainer" varStatus="currCount">
													<td><a id="${topic.id}_${activityContainer.activityContainerId}"
														class="btn ${currCount.index+1 <= topic.completedActContainers+1?"
														btn-primary":"btn-primary disabled"}" role="button">
															${activityContainer.containerName} </a></td>
													<td style="width: 25px"></td>
												</c:forEach>
											</tr>
										</tbody>
									</table>
									<br>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
				<div class="row jumbotron" id="Completed">
					<h2 style="font-size: 300%;">Completed</h2>
					<div class="col-sm-8">

						<c:forEach items="${topics}" var="topic" varStatus="topicNo">
							<c:if test="${topic.topicStatus.id == 3}">
								<div class="topic_holder">
									<h2>
										<span id="topic_name_${topic.id}">${topic.topicName}</span>
									</h2>
									<table>
										<tbody>
											<tr>
												<c:forEach items="${topic.activityContainers}"
													var="activityContainer">
													<td><a href="#" class="btn btn-primary" role="button">${activityContainer.containerName}</a></td>
													<td style="width: 25px"></td>
												</c:forEach>
											</tr>
										</tbody>
									</table>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form id=form method="post" action="getActivitypage.action">
		<input type="hidden" id=actcon name=actcon />
	</form>
	<script>
		$(".btn").on("click", function() {
			$("#actcon").val(this.id);
			$("#form").submit();
		})
	</script>
	<%@ include file="footer.jsp"%>
	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>