<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Happy Being Us</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
/* footer { */
/* 	background-color: #f2f2f2; */
/* 	padding: 25px; */
/* } */
</style>



</head>

<body>
<%@ include file="header.jsp" %>
	<div class="jumbotron">
		<div class="container text-center">
			<h1>Happy Profile Quiz</h1>
			<p>Please answer to the following questions and click on SUBMIT !</p>
		</div>
	</div>
<body>
	<form:form action="dg.action" method="post">
		<c:forEach items="${activityAnswers}" var="activityAnswer">
			<div class="container">
				<h2>Question ${activityAnswer.activity.orderNo}</h2>
				<p>${activityAnswer.activity.activityText}</p>
				<c:forEach items="${activityAnswer.answers}" var="answer">
					<div class="radio">
						<label><input type="radio"
							name="scores[${activityAnswer.activity.orderNo}]"
							value="${answer.orderNo}">${answer.answerText}</label>
					</div>
				</c:forEach>
			</div>
		</c:forEach>
		<div class="modal-footer">
			<input class="btn btn-primary" type="submit" value="submit" />

		</div>
	</form:form>


	<!-- Footer -->
	<%@ include file="footer.jsp" %>

</body>
</html>