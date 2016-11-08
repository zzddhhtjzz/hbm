<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
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
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

@import
	url(http://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700)
	;

.animation {
	-webkit-transition: all 0.3s ease;
	-moz-transition: all 0.3s ease;
	-ms-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
	transition: all 0.3s ease;
}

.pageTitle sup {
	font-size: .6em;
	color: #333;
}

.well {
	padding: 3%;
	margin: 20px auto;
	border: none;
	text-align: center;
}

.well p {
	font-weight: 300;
}

.content p {
	font-weight: 300;
}

.cardContainer {
	-webkit-transition: all .3s ease;
	-moz-transition: all .3s ease;
	-ms-transition: all .3s ease;
	transition: all .3s ease;
	/*depth of the elements */
	-webkit-perspective: 800px;
	-moz-perspective: 800px;
	-o-perspective: 800px;
	perspective: 800px;
	/*border: 1px solid #ff0000;*/
	padding-left: 1%;
}

.secondRow {
	margin-top: -1.4%
}

.card {
	width: 99%;
	height: 200px;
	cursor: pointer;
	/*transition effects */
	-webkit-transition: -webkit-transform 0.6s;
	-moz-transition: -moz-transform 0.6s;
	-o-transition: -o-transform 0.6s;
	transition: transform 0.6s;
	-webkit-transform-style: preserve-3d;
	-moz-transform-style: preserve-3d;
	-o-transform-style: preserve-3d;
	transform-style: preserve-3d;
}

.card.flipped {
	-webkit-transform: rotateY(180deg);
	-moz-transform: rotateY(180deg);
	-o-transform: rotateY(180deg);
	transform: rotateY(180deg);
}

.card.flipped: {
	
}

.card .front, .card .back {
	display: block;
	height: 100%;
	width: 100%;
	line-height: 60px;
	color: white;
	text-align: center;
	font-size: 4em;
	position: absolute;
	-webkit-backface-visibility: hidden;
	-moz-backface-visibility: hidden;
	-o-backface-visibility: hidden;
	backface-visibility: hidden;
	box-shadow: 3px 5px 20px 2px rgba(0, 0, 0, 0.25);
	-webkit-box-shadow: 0 2px 10px rgba(0, 0, 0, 0.16), 0 2px 5px
		rgba(0, 0, 0, 0.26);
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.16), 0 2px 5px
		rgba(0, 0, 0, 0.26);
}

.card .back {
	width: 100%;
	padding-left: 3%;
	padding-right: 3%;
	font-size: 16px;
	text-align: left;
	line-height: 25px;
}

.card .back {
	background: #03446A;
	-webkit-transform: rotateY(180deg);
	-moz-transform: rotateY(180deg);
	-o-transform: rotateY(180deg);
	transform: rotateY(180deg);
}

/*Colors for front and back applied here*/
.cardContainer:first-child .card .front {
	background: green;
}

.cardContainer:first-child .card .back {
	background: green;
}

.cardContainer:nth-child(2) .card .front {
	background: #2aa9e0;
}

.cardContainer:nth-child(2) .card .back {
	background: #2aa9e0;
}

.cardContainer:nth-child(3) .card .front {
	background: green;
}

.cardContainer:nth-child(3) .card .back {
	background: green;
}

.cardContainer:nth-child(4) .card .front {
	background: #D05800;
}

.cardContainer:nth-child(4) .card .back {
	background: #D05800;
}

h3.cardTitle {
	line-height: 1.2em;
	margin-top: 8%;
	font-weight: 600;
}

.content h3.cardTitle {
	margin-top: 0%;
}

.content {
	padding: 4%;
	font-weight: 100;
	text-align: left;
	font-weight: bold;
}

@media all and (max-width: 1000px) {
	h3.cardTitle {
		font-weight: 500;
	}
	.content p {
		margin-top: -15%;
		line-height: 1.2em;
	}
	.card {
		height: 175px;
	}
}

@media all and (max-width : 752px) {
	.secondRow {
		margin-top: -3%;
	}
	.cardContainer:nth-child(3), .cardContainer:nth-child(4) {
		margin-top: 3%;
	}
}

@media all and (max-width : 390px) {
	.card {
		width: 100%;
		height: 200px;
	}
	.secondRow {
		margin-top: -9%;
	}
	.well {
		padding: 1%;
	}
	.cardContainer:nth-child(3), .cardContainer:nth-child(4) {
		margin-top: 5%;
	}
	h3.cardTitle {
		font-weight: 300;
	}
	.content p {
		margin-top: -20%;
		line-height: 1.2em;
	}
	.cardWrapper {
		margin-left: 4%;
	}
}
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}
</style>



</head>

<body>
<%@ include file="header.jsp" %>
	<div class="jumbotron">
		<div class="container text-center">
			<h1>${c_container.containerName}</h1>
			<p>${c_act.activityText }</p>
		</div>
	</div>
<body>

	<c:if test="${c_act.activityTemplate.id==1}">


		<c:forEach items="${answers}" var="answer">
			<c:if test="${answer.orderNo==1}">
				<video width="600" controls="">
					<source src="${answer.answerText}">
					<source src="${answer.answerText}">
					<ins>Your browser does not support the video tag.</ins>
				</video>
			</c:if>
			<c:if test="${answer.orderNo!=1}">
				<div>${answer.answerText}</div>

			</c:if>	
		</c:forEach>
	</c:if>
	<c:if test="${c_act.activityTemplate.id==2}">


		<c:forEach items="${answers}" var="answer">
			<c:if test="${answer.orderNo==1}">
				<div class="col-sm-6">



					<img src="${answer.answerText}" class="img-responsive"
						alt="Image not present" width="600">





				</div>
			</c:if>
			<c:if test="${answer.orderNo!=1}">
				<div>${answer.answerText}</div>
			</c:if>
		</c:forEach>

	</c:if>


	<c:if test="${c_act.activityTemplate.id==3}">

		<form:form>
			<c:forEach items="${answers}" var="answer">
				<div class="radio">
					<label><input type="radio" name="scores"
						value="${answer.orderNo}">${answer.answerText}</label>
				</div>
			</c:forEach>
			<div class="modal-footer">
				<input class="btn btn-primary" type="submit" value="submit" />

			</div>

		</form:form>
	</c:if>
	<c:if test="${c_act.activityTemplate.id==4}">


		<c:forEach items="${answers}" var="answer">
			<div>
				<label>${answer.answerText}</label>
			</div>
		</c:forEach>



	</c:if>


	<c:if test="${c_act.activityTemplate.id ==5}">

		<div class="container">

			<div class="row">
				<tr>
					<td><br /></td>
				</tr>
				<tr>
					<td><br /></td>
				</tr>
			</div>

			<!-- first Row -->
			<div class="row">

				<div class="col-lg-2"></div>
				<c:forEach items="${answers}" var="answer">
					<div class="col-lg-4  cardContainer">
						<div class="card">
							<div class="front">
								<h3 class="cardTitle">Flip me!</h3>
							</div>
							<div class="back">
								<div class="content">
									<h3 class="cardTitle">${answer.answerText}</h3>
									<br />
									<p id="happy"></p>
								</div>
							</div>
						</div>
					</div>

				</c:forEach>
				<!-- row1 -->



				<div></div>
			</div>
			<!--cardWrapper Ends-->
			<!-- container -->
	</c:if>

	<script>
		$('.card').click(function() {
			$(this).toggleClass('flipped');
		});
	</script>

	<td><a id=1 class="btn ${c_act.orderNo != 1?"
		btn-primary":"btn-primary disabled"}" role="button"> previous
			activity</a></td>
	<td><a id=2 class="btn ${c_act.orderNo!=act_max?"
		btn-primary":"btn-primary disabled"}" role="button"> next activity</a></td>
	<td><a id=3 class="btn ${c_container.orderNo !=1 ?"
		btn-primary":"btn-primary disabled"}" role="button"> previous
			container</a></td>
	<td><a id=4 class="btn ${c_container.orderNo!= con_max?"
		btn-primary":"btn-primary disabled"}" role="button"> next
			container</a></td>
    
	
	<td style="width: 25px"></td>

	<form id=form method="post" action="reload.action">
		<input type="hidden" id=actcon name=actcon />
	</form>

	<script>
		$(".btn").on("click", function() {
			$("#actcon").val(this.id);
			$("#form").submit();
		})
	</script>



	<!-- Footer -->
	<%@ include file="footer.jsp" %>

</body>
</html>