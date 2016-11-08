<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
/* footer { */
/* 	background-color: #f2f2f2; */
/* 	padding: 25px; */
/* } */
</style>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/canvasjs/1.7.0/canvasjs.min.js"></script>

<script type="text/javascript">
	function renderPieChart() {
		var pieParams = [];
		$("#paramsContainer .paramContainer").each(function() {
			var paramVal = {y: $(this).find($('.param')).val(), indexLabel: $(this).find($('.paramLabel')).text()};
			pieParams.push(paramVal);
		});
		var chart = new CanvasJS.Chart("chartContainer",
		{
			title:{
				text: ""
			},
			legend: {
				maxWidth: 350,
				itemWidth: 120
			},
			data: [
			{
				type: "pie",
				showInLegend: true,
				toolTipContent: "{y}%",
				legendText: "{indexLabel}",
				dataPoints: pieParams
			}
			]
		});
		chart.render();
	}

	//		adding more parmeters for the pie chart
	$(document).on('click', '#addParamBtn', function(e) {
		e.preventDefault();
		if($('#paramText').val().trim() != ''){
		
			$('#paramsContainer').append(
				'<div class="paramContainer" class="form-group"> '
					+ '<div class="row"> '
					+ '<div class="col-sm-3 text-left"> '					
					+'<label for="points" class="paramLabel">'+$('#paramText').val()+'</label>'
					+'</div> '
					+'<div class="col-sm-3 text-left"> '
					+'<button class="removeParam btn btn-danger btn_lg" type="button">Remove</button>'
					+'</div>'
					+'</div><br>'
					+'<input type="range" data-show-value="true" data-highlight="true" name="points" class="param" value="0" min="0" max="100" ng-model="Q1" onchange="renderPieChart()"/><br>'
				+'</div>');
		}
		$('#paramText').val('');
	});


	//		remove pie chart parameter
	$(document).on('click', "#paramsContainer .removeParam", function() {
		this.parentNode.parentNode.parentNode.remove();
		//call the renderPieChart function to re-render
		renderPieChart();
	});
	
	$(document).ready(function() {
		$(".navigate-btn").on("click", function() {
			$("#actcon").val(this.id);
			$("#form").submit();
		});
	
		$('.card').click(function(){
	 		$(this).toggleClass('flipped');
	 	});
	
		});

	
	
	$(document).ready(function() {
		$("#button1").on("click", function() {
			
			$('.rtAnswer').css('display', 'block');
			
// 			if(("#sanswer").val()!=rightanswers)
			
		});
	});

</script>
</head>
<body>

<!-- 	<nav class="navbar navbar-inverse"> -->
<!-- 		<div class="container-fluid"> -->
<!-- 			<div class="navbar-header"> -->
<!-- 				<button type="button" class="navbar-toggle" data-toggle="collapse" -->
<!-- 					data-target="#myNavbar"> -->
<!-- 					<span class="icon-bar"></span> <span class="icon-bar"></span> <span -->
<!-- 						class="icon-bar"></span> -->
<!-- 				</button> -->
<!-- 				<a class="navbar-brand" href="#">Home</a> -->
<!-- 			</div> -->
<!-- 			<div class="collapse navbar-collapse" id="myNavbar"> -->
<!-- 				<ul class="nav navbar-nav navbar-right"> -->
<!-- 					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> -->
<!-- 							Logout</a></li> -->
<!-- 				</ul> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</nav> -->
	<%@ include file="header.jsp" %>
	<c:if test="${c_act.activityTemplate.id ==1}">
		<div class="jumbotron">
			<div class="container text-center">
				<h2>${c_container.containerName}</h2>
				<p>Infer the video and reflect</p>
			</div>
		</div>
		
		<div class="container-fluid bg-3 text-left">

			<div class="row">
				<div class="col-sm-6">
					<c:if test="${fn:length(answers) > 0}">
						<c:forEach var="answer" items="${answers}" varStatus="loopCount">
							<c:if test="${loopCount.count eq 1}">
								<video width="600" controls>
									<source src="${answer.answerText}" type="video/mp4">
									<source src="${answer.answerText}" type="video/ogg">
									<ins>Your browser does not support the video tag.</ins>
								</video>
							</c:if>
						</c:forEach>
					</c:if>

				</div>
				<div class="col-sm-6">
					<h3>Question</h3>
					<p>${c_act.activityText }</p>
					<div class="form-group">
						<label for="comment">Answer:</label>

						<form id="form" method="post" action="reload.action">
							<input type="hidden" id="actcon" name="actcon" />
							<textarea class="form-control" rows="5" id="comment"
								name="userAnswer" placeholder="Enter Answer Here."><c:if test="${fn:length(answers) > 0}"><c:forEach var="answer" items="${answers}" varStatus="loopCount"><c:if test="${loopCount.count eq 3}">${answer.answerText}</c:if></c:forEach></c:if></textarea>
						</form>
					</div>
					<a class="btn btn-info" data-toggle="collapse"
						data-target="#videoIdeal" onclick="this.preventDefault();">Done</a>
					<tr>
						<td><br /></td>
					</tr>
					<div id="videoIdeal" class="collapse">
						<tr>
							<td><br /></td>
						</tr>
						<c:if test="${fn:length(answers) > 0}">
							<c:forEach var="answer" items="${answers}" varStatus="loopCount">
								<c:if test="${loopCount.count eq 2}">
									<p style="color: green;">${answer.answerText}</p>
								</c:if>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<c:if test="${c_act.activityTemplate.id ==2}">
		<div class="jumbotron">
			<div class="container text-center">
				<h2>${c_container.containerName}</h2>
				<p>Infer the picture and reflect</p>
			</div>
		</div>


		<div class="container-fluid bg-3 text-left">

			<div class="row">
				<div class="col-sm-6">
					<c:if test="${fn:length(answers) > 0}">
						<c:forEach var="answer" items="${answers}" varStatus="loopCount">
							<c:if test="${loopCount.count eq 1}">
								<img src="${answer.answerText}" class="img-responsive"
									alt="Cannot load image" width="600">
							</c:if>
						</c:forEach>
					</c:if>
				</div>
				<div class="col-sm-6">
					<h3>Question</h3>
					<p>${c_act.activityText }</p>
					<div class="form-group">
						<label for="comment">Answer:</label>

						<form id="form" method="post" action="reload.action">
							<input type="hidden" id="actcon" name="actcon" />
							<textarea class="form-control" rows="5" id="imageAnswer"
								name="userAnswer" placeholder="Enter Answer Here."><c:if test="${fn:length(answers) > 0}"><c:forEach var="answer" items="${answers}" varStatus="loopCount"><c:if test="${loopCount.count eq 3}">${answer.answerText}</c:if></c:forEach></c:if></textarea>
						</form>
					</div>
					<a class="btn btn-info" data-toggle="collapse"
						data-target="#imageIdeal">Done</a>
					<div id="imageIdeal" class="collapse">
						<tr>
							<td><br /></td>
						</tr>
						<c:if test="${fn:length(answers) > 0}">
							<c:forEach var="answer" items="${answers}" varStatus="loopCount">
								<c:if test="${loopCount.count eq 2}">
									<p style="color: green;">${answer.answerText}</p>
								</c:if>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${c_act.activityTemplate.id ==3}">
		<div class="jumbotron">
			<div class="container text-center">
				<h2>${c_container.containerName}</h2>
				<p>Which ones' do you think are right?</p>
			</div>
		</div>

		<div class="container">
			<h2 class="text-info">Question</h2>
			<p>${c_act.activityText }</p>

			<form id="form" method="post" action="reload.action">
				<input type="hidden" id="actcon" name="actcon" />

				<c:if test="${fn:length(answers) > 0}">
					<c:forEach var="answer" items="${answers}">
						<div id="check-info" class="checkbox">
							<div class="row">
								<div class="col-sm-4">
								<label><input type="checkbox" name="selectedAnswer" class="sanwser"
								value='${answer.id}' ${answer.isCorrect?"checked":""} required/>${answer.answerText}</label>
								</div>
								<div class="col-sm-2"><span class="rtAnswer btn-success text-center" style='display: none'>${answer.isRightanswer?"Correct Answer":""}</span></div>
								<div class="col-sm-6"></div>
							</div>
						</div>
					</c:forEach>
					<a id="button1" class="btn btn-primary">Check Answer</a>
				</c:if>
			</form>

		</div>
	</c:if>

	<c:if test="${c_act.activityTemplate.id ==4}">
		<div class="jumbotron">
			<div class="container text-center">
				<h2>${c_container.containerName}</h2>
				<p>Information</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<h4>${c_act.activityText }</h4>
			</div>
		</div>

		<form id="form" method="post" action="reload.action">
			<input type="hidden" id="actcon" name="actcon" />
		</form>
	</c:if>
	<c:if test="${c_act.activityTemplate.id ==5}">
		<div class="jumbotron">
			<div class="container text-center">
				<h2>${c_container.containerName}</h2>
				<p>click on each to see the answer on the back:</p>
			</div>
		</div>

		<div class="container">

			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<h3>Question</h3>
					<p>${c_act.activityText }</p>
				</div>
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
				<div class="col-lg-4  cardContainer">
					<div class="card">
						<div class="front">
							<c:if test="${fn:length(answers) > 0}">
								<c:forEach var="answer" items="${answers}" varStatus="loopCount">
									<c:if test="${loopCount.count eq 1}">
										<h3 class="cardTitle">${answer.answerText}</h3>
									</c:if>
								</c:forEach>
							</c:if>
						</div>
						<div class="back">
							<c:if test="${fn:length(answers) > 0}">
								<c:forEach var="answer" items="${answers}" varStatus="loopCount">
									<c:if test="${loopCount.count eq 2}">
										<div class="content">
											<c:choose>
												<c:when
													test="${not fn:contains(answer.answerText, 'resources/')}">
													<h3 class="cardTitle">${answer.answerText}</h3>
												</c:when>
												<c:otherwise>
													<img src="${answer.answerText}" class="img-responsive"
														alt="Cannot load image" width="600">
												</c:otherwise>
											</c:choose>
										</div>
									</c:if>
								</c:forEach>
							</c:if>
						</div>
					</div>
				</div>


				<div class="col-lg-4  cardContainer">
					<div class="card">
						<div class="front">
							<c:if test="${fn:length(answers) > 0}">
								<c:forEach var="answer" items="${answers}" varStatus="loopCount">
									<c:if test="${loopCount.count eq 3}">
										<h3 class="cardTitle">${answer.answerText}</h3>
									</c:if>
								</c:forEach>
							</c:if>
						</div>
						<div class="back">
							<c:if test="${fn:length(answers) > 0}">
								<c:forEach var="answer" items="${answers}" varStatus="loopCount">
									<c:if test="${loopCount.count eq 4}">
										<div class="content">
											<c:choose>
												<c:when
													test="${not fn:contains(answer.answerText, 'resources/')}">
													<h3 class="cardTitle">${answer.answerText}</h3>
												</c:when>
												<c:otherwise>
													<img src="${answer.answerText}" class="img-responsive"
														alt="Cannot load image">
												</c:otherwise>
											</c:choose>
										</div>
									</c:if>
								</c:forEach>
							</c:if>
						</div>
					</div>
				</div>

			</div>
			<!-- row1 -->


			<div class="row">
				<tr>
					<td><br /></td>
				</tr>
				<tr>
					<td><br /></td>
				</tr>
			</div>

			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-1"></div>
				<div class="col-lg-1"></div>
				<div class="col-lg-4  cardContainer">
					<div class="card">
						<div class="front">
							<c:if test="${fn:length(answers) > 0}">
								<c:forEach var="answer" items="${answers}" varStatus="loopCount">
									<c:if test="${loopCount.count eq 5}">
										<h3 class="cardTitle">${answer.answerText}</h3>
									</c:if>
								</c:forEach>
							</c:if>
						</div>
						<div class="back">
							<c:if test="${fn:length(answers) > 0}">
								<c:forEach var="answer" items="${answers}" varStatus="loopCount">
									<c:if test="${loopCount.count eq 6}">
										<div class="content">
											<c:choose>
												<c:when
													test="${not fn:contains(answer.answerText, 'resources/')}">
													<h3 class="cardTitle">${answer.answerText}</h3>
												</c:when>
												<c:otherwise>
													<img src="${answer.answerText}" class="img-responsive"
														alt="Cannot load image">
												</c:otherwise>
											</c:choose>
										</div>
									</c:if>
								</c:forEach>
							</c:if>
						</div>
					</div>
				</div>
			</div>
			<!-- row2 -->

			<!-- first Row End -->
		</div>
		<!--cardWrapper Ends-->

		<form id="form" method="post" action="reload.action">
			<input type="hidden" id="actcon" name="actcon" />
		</form>
	</c:if>
	<c:if test="${c_act.activityTemplate.id ==6}">
		<div class="jumbotron">
			<div class="container text-center">
				<h2>${c_container.containerName}</h2>
				<p>Pie Chart</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<h4>${c_act.activityText }</h4>
			</div>
		</div>
		<tr>
			<td><br /></td>
		</tr>
		<tr>
			<td><br /></td>
		</tr>
		<div class="container">
			<div class="row">
				<div class="col-sm-1">
					<div class="text-left">
						<!--input type="text" placeholder="Enter here" id="paramText"-->
					</div>
				</div>
				<div class="col-sm-3">
					<div class="text-left">
						<input type="text" placeholder="Enter here" id="paramText">
						<span id="addParamBtn" class="btn btn-primary btn_lg">Add</span>
					</div>
				</div>
			</div>
		</div>
		<tr>
			<td><br /></td>
		</tr>
		<div class="container">
			<div class="col-sm-4" style="position: center" id="paramsContainer">
			</div>
			<div class="col-sm-8">
				<div id="chartContainer" style="height: 400px; width: 100%;"></div>
			</div>
		</div>

		<form id="form" method="post" action="reload.action">
			<input type="hidden" id="actcon" name="actcon" />
		</form>
	</c:if>
	<!-- container -->
	<tr>
		<td><br /></td>
	</tr>
	<ul class="pager">
		<c:if test="${c_act.orderNo == 1 && c_container.orderNo !=1}">
			<li><a id="3" class="btn navigate-btn">Previous Block</a></li>
		</c:if>
		<c:if test="${c_act.orderNo != 1}">
			<li><a id="1" class="btn navigate-btn">Previous</a></li>
		</c:if>
		<c:if test="${c_act.orderNo!=act_max}">
			<li><a id="2" class="btn navigate-btn">Next</a></li>
		</c:if>
		<c:if
			test="${c_act.orderNo==act_max && c_container.orderNo!= con_max}">
			<li><a id="4" class="btn navigate-btn">Next Block</a></li>
		</c:if>
		<c:if test="${c_act.orderNo==act_max && c_container.orderNo== con_max}">
		<li><a id="5" class="btn navigate-btn"> Finish </a></li>
		</c:if>
	</ul>
	<tr>
		<td><br /></td>
	</tr>

	<script>
		
	</script>

<%@ include file="footer.jsp" %>
</body>
</html>