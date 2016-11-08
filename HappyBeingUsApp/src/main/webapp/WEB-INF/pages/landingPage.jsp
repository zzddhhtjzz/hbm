<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>Landing page</title>

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
<%@ include file="header.jsp" %>
	<!-- Half Page Image Background Carousel Header -->
<!-- 	<header id="myCarousel" class="carousel slide"> -->
<!-- 		<!-- Indicators --> -->
<!-- 		<ol class="carousel-indicators"> -->
<!-- 			<li data-target="#myCarousel" data-slide-to="0" class="active"></li> -->
<!-- 			<li data-target="#myCarousel" data-slide-to="1"></li> -->
<!-- 			<li data-target="#myCarousel" data-slide-to="2"></li> -->
<!-- 		</ol> -->

<!-- 		<!-- Wrapper for Slides --> -->
<!-- 		<div class="carousel-inner"> -->
<!-- 			<div class="item active"> -->
<!-- 				Set the first background image using inline CSS below. -->
<!-- 				<div class="fill" -->
<!-- 					style="background-image: url('http://placehold.it/1900x1080&amp;text=Slide One');"></div> -->
<!-- 				<div class="carousel-caption"> -->
<!-- 					<h2>Caption 1</h2> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="item"> -->
<!-- 				Set the second background image using inline CSS below. -->
<!-- 				<div class="fill" -->
<!-- 					style="background-image: url('http://placehold.it/1900x1080&amp;text=Slide Two');"></div> -->
<!-- 				<div class="carousel-caption"> -->
<!-- 					<h2>Caption 2</h2> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 			<div class="item"> -->
<!-- 				Set the third background image using inline CSS below. -->
<!-- 				<div class="fill" -->
<!-- 					style="background-image: url('http://placehold.it/1900x1080&amp;text=Slide Three');"></div> -->
<!-- 				<div class="carousel-caption"> -->
<!-- 					<h2>Caption 3</h2> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

<!-- 		<!-- Controls --> -->
<!-- 		<a class="left carousel-control" href="#myCarousel" data-slide="prev"> -->
<!-- 			<span class="icon-prev"></span> -->
<!-- 		</a> <a class="right carousel-control" href="#myCarousel" -->
<!-- 			data-slide="next"> <span class="icon-next"></span> -->
<!-- 		</a> -->

<!-- 	</header> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-lg-12"> -->
<!-- 				<img src="Images/Slide1.jpg" style="margin-left: 150px" /> -->
<!-- 			</div> -->
<!-- 		</div> -->
	<!-- Page Content -->
	<div class="container">

		<div class="row">
			<div class="col-lg-12">
				<img src="Images/landingPageImage.png" style="margin-left: 150px" />
			</div>
		</div>

		<hr>
	</div>

	<!-- Footer -->
	<footer>
		<div class="row" style="background-color: #952D54; height: 20px;"></div>
		<div class="row">
			<div class="col-lg-12">
				<p style="margin-left: 50px;">Copyright &copy; HappyBeingUs
					2016</p>
			</div>
		</div>
		<!-- /.row -->
</footer>

	<div class="modal fade" id="Login" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content col-lg-10">
				<form action="Login.action" method="post"
					modelAttribute="userAuthentication">
					<div class="modal-header">
						<h4>Login</h4>
					</div>
					<div class="modal-body">
						<div class="form-group left-inner-addon">
							<div class="col-lg-8">
								<i class="glyphicon glyphicon-user"></i> <input type="text" maxlength = "80"
									class="form-control" name="username" placeholder="User name"
									required>

							</div>
						</div>
						<br></br>
						<div class="form-group left-inner-addon">
							<div class="col-lg-8">
								<i class="glyphicon glyphicon-lock"></i> <input type="password" maxlength = "80"
									class="form-control" name="password" placeholder="password"
									required>
							</div>
						</div>
						<br></br>

						<div class="col-lg-6">
							<a href="#ForgotPassword" data-toggle = "modal">Forgot Password</a> <span
								id="checkusername" style="display: none">Error! Please check
								username or password entered.</span>
						</div>
						<br></br>
					</div>
					<div class="modal-footer">
						<a class="btn btn-default" data-dismiss="modal">Cancel</a>
						<button class="btn btn-primary" type="submit">Login</button>

					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade" id="SignUpDaughter" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content col-lg-10">

				<form:form action="signUp.action" method="post"
					modelAttribute="daughterRegistration">
					<div class="modal-header">
						<h4>Sign Up</h4>
					</div>

					<div class="modal-body">
						<div class="form-group">
							<div class="col-lg-5">
								<form:input type="text" path="daughter.firstName" maxlength = "80"
									class="form-control" name="Firstname" placeholder="First name"
									required="true" />
							</div>
							<div class="col-lg-5">
								<form:input type="text" path="daughter.lastName" maxlength = "80"
									class="form-control" name="Lastname" placeholder="Last Name"
									required="true" />
							</div>
							<br></br>
						</div>
						<div class="form-group left-inner-addon ">
							<div class="col-lg-10 ">
								<i class="glyphicon glyphicon-envelope"></i>
								<form:input type="email" path="daughter.email" maxlength = "80"
									class="form-control" id = "daughterEmail"  name="emailID" placeholder="Email"
									required="true" />
							</div>
							<span id="dauEmailMsg"></span>
							<br></br>
						</div>
						<div class="form-group left-inner-addon ">
							<div class="col-lg-7 ">
								<i class="glyphicon glyphicon-calendar"></i>
								<form:input type="date" path="daughter.birthdate"
									class="form-control" name="birthDate" max="2008-12-31" min="2000-01-02" placeholder="Birth Date"
									required="true" />
							</div>
							<br></br>
						</div>
						<div id="MGEmail" class="form-group left-inner-addon">
							<div class="col-lg-10">
								<i class="glyphicon glyphicon-envelope"></i>
								<form:input type="email" path="daughter.mother.email"
									class="form-control" id="MomEmailID" name="momEmail" maxlength = "80"
									placeholder="EmailID of Mommy" required="true" />
							</div>
							<br></br>
						</div>
						<div class="form-group left-inner-addon">
							<div class="col-lg-10">
								<i class="glyphicon glyphicon-user"></i>
								<form:input type="text" path="username" class="form-control" maxlength = "80" minlength = "6"
									name="userName" id = "daughterUname" placeholder="User name" required="true" />
									<div id="loadingDiv" class="modal">
									<img alt="loading" src="Images/loading.gif">
									</div>
								<span id="usernameMsg"></span>
							</div>
							<br></br>
						</div>
						<div class="form-group left-inner-addon">
							<div class="col-lg-10">
								<i class="glyphicon glyphicon-lock"></i>
								<form:input type="password" path="password" class="form-control" maxlength = "80" minlength = "6"
									name="password" placeholder="password" required="true" />
							</div>
						</div>
						<br></br>
						<div class="modal-footer">
							<a class="btn btn-default" data-dismiss="modal">Cancel</a> <input
								class="btn btn-primary" type="submit" value="Register" />

						</div>
					</div>
				</form:form>
			</div>
		</div>
</div>
		<div class="modal fade" id="SignUpMom" role="dialog" style = "dispaly:block">
			<div class="modal-dialog">
				<div class="modal-content col-lg-10">

					<form action="getMotherByEmail.action" method="post">
						<div class="modal-header">
							<h4>Sign Up</h4>
						</div>

						<div class="modal-body">
							<div class="form-group left-inner-addon ">
								<div class="col-lg-10 ">
									<i class="glyphicon glyphicon-envelope"></i> <input
										type="email" path="daughter.email" class="form-control" maxlength = "80"
										name="emailID" placeholder="Email" required />
								</div>
								<br></br>
							</div>
							<span id="motherEmailErr" style="display: none">${motherRegisterErr}</span>
							<div class="modal-footer">
								<a class="btn btn-default" data-dismiss="modal">Cancel</a> <input
									class="btn btn-primary" type="submit" value="Register" />

							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
		<div class="modal fade" id="UpdateMomDetails" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content col-lg-10">

					<form:form action="topicPage.action" method="post"
						modelAttribute="motherRegistration">
						<div class="modal-header">
							<h4>Sign Up</h4>
						</div>

						<div class="modal-body">
							<div class="form-group">
								<div class="col-lg-5">
									<form:input type="text" path="mother.firstName" maxlength = "80"
										class="form-control" name="Firstname" placeholder="First name"
										required="true" />
								</div>
								<div class="col-lg-5">
									<form:input type="text" path="mother.lastName" maxlength = "80"
										class="form-control" name="Lastname" placeholder="Last Name"
										required="true" />
								</div>
								<br></br>
							</div>
							<form:input type="hidden" path="mother.id" />
							<div class="form-group left-inner-addon ">
								<div class="col-lg-10 ">
									<i class="glyphicon glyphicon-envelope"></i>
									<form:input type="email" path="mother.email" readonly="true" maxlength = "80"
										class="form-control" name="emailID" placeholder="Email"
										required="true" />
								</div>
								<br></br>
								<div class="form-group left-inner-addon">
									<div class="col-lg-10">
										<i class="glyphicon glyphicon-user"></i>
										<form:input type="text" path="username" class="form-control" maxlength = "80" minlength = "6"
											name="userName" id = "motherUname"  placeholder="User name" required="true" />
									</div>
									<div id="loadingDiv" class="modal">
									</div>
									<br></br>
								<span id="momusernameMsg"></span>
								</div>
								<div class="form-group left-inner-addon">
									<div class="col-lg-10">
										<i class="glyphicon glyphicon-lock"></i>
										<form:input type="password" path="password" maxlength = "80" minlength = "6"
											class="form-control" name="password" placeholder="password"
											required="true" />
									</div>
								</div>
								<br></br>
								<div class="modal-footer">
									<a class="btn btn-default" data-dismiss="modal">Cancel</a> <input
										class="btn btn-primary" type="submit" value="Register" />

								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
<div class="modal fade" id="ForgotPassword" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content col-lg-10">
				<form action="forgotPassword.action" method="post">
					<div class="modal-header">
						<h4>Reset Username Password</h4>
					</div>
					
					<div class="modal-body">
					<div class="form-group left-inner-addon">
					<div class="col-lg-8">
									<i class="glyphicon glyphicon-envelope"></i> <input
										type="email" path="daughter.email" class="form-control" maxlength = "80"
										name="emailID" placeholder="Email" required />
								</div>
								</div>
								<br></br>
						<div class="form-group left-inner-addon">
							<div class="col-lg-8">
								<i class="glyphicon glyphicon-user"></i> <input type="text" maxlength = "80"
									class="form-control" name="username" placeholder="User name" id ="newUserName"
									required>

							</div>
						</div>
						<span id="newusernameMsg"></span>
						<br></br>
						<div class="form-group left-inner-addon">
							<div class="col-lg-8">
								<i class="glyphicon glyphicon-lock"></i> <input type="password" maxlength = "80"
									class="form-control" name="password" placeholder="password"
									required>
							</div>
						</div>
						
						<br></br>
					</div>
					<div class="modal-footer">
						<a class="btn btn-default" data-dismiss="modal">Cancel</a>
						<button class="btn btn-primary" type="submit">Login</button>

					</div>
				</form>
			</div>
		</div>
	</div>
		<input type="hidden" id="usernameerr" name="usernameerr"
			value="${usernameerr}" /> 
		<input type="hidden" id="check"
			name="check" value="${motherRegister}" />

		<!-- /.container -->

		<!-- jQuery -->
		<script src="js/jquery.js"></script>
		
		<!-- Bootstrap Core JavaScript -->
		<script src="js/bootstrap.min.js"></script>

		<!-- Script to Activate the Carousel -->
		<script>
		
			$('.carousel').carousel({
				interval : 5000
			//changes the speed
			})

			$(document).ready(function() {
				$("#Login").click(function() {
					$('#checkusername').css('display', 'none');
				})

				if ($("#usernameerr")[0].value == 'false') {
					$('#Login').modal('toggle');
					$('#checkusername').css('display', 'block');
				}
				$('#SignUpMom').click(function() {
					$('#motherEmailErr').css('display', 'none');
				})
				if ($("#check")[0].value == 'true') {
					$('#UpdateMomDetails').modal('toggle');
				} else if ($("#check")[0].value == 'false') {
					$('#SignUpMom').modal('toggle');
					$('#motherEmailErr').css('display', 'block');
				}
				
				$("#daughterUname").change(function() {
					userName = $('#daughterUname').val();
					$("#loadingDiv").modal("toggle");
					$("#usernameMsg")[0].innerHTML = "Checking username availability.";
					$.ajax({
			            type : "POST",
			            url : "checkUsernameAvailability.action",
			            data : "userName=" + userName,
			            success : function(data) {
			            	$("#loadingDiv").modal("toggle");
			            	$("#usernameMsg")[0].innerHTML = data;
			            	
			            	if(data.indexOf('available') == -1){
			            		$("#daughterUname").val('');
			            	}else{
			            		
			            	}
			            }
			        })
			    });
				$("#motherUname").change(function() {
					userName = $('#motherUname').val();
					$("#loadingDiv").modal("toggle");
					$("#momusernameMsg")[0].innerHTML = "Checking username availability.";
					$.ajax({
			            type : "POST",
			            url : "checkUsernameAvailability.action",
			            data : "userName=" + userName,
			            success : function(data) {
			            	$("#loadingDiv").modal("toggle");
			            	$("#momusernameMsg")[0].innerHTML = data;
			            	
			            	if(data.indexOf('available') == -1){
			            		$("#motherUname").val('');
			            	}else{
			            		
			            	}
			            }
			        })
			    });
				
				$("#newUserName").change(function() {
					userName = $('#newUserName').val();
					$("#loadingDiv").modal("toggle");
					$("#newusernameMsg")[0].innerHTML = "Checking username availability.";
					$.ajax({
			            type : "POST",
			            url : "checkUsernameAvailability.action",
			            data : "userName=" + userName,
			            success : function(data) {
			            	$("#loadingDiv").modal("toggle");
			            	$("#newusernameMsg")[0].innerHTML = data;
			            	
			            	if(data.indexOf('available') == -1){
			            		$("#newUserName").val('');
			            	}else{
			            		
			            	}
			            }
			        })
			    });
				
				$("#daughterEmail").change(function() {
					email = $('#daughterEmail').val();
					$("#loadingDiv").modal("toggle");
					$("#dauEmailMsg")[0].innerHTML = "";
					$.ajax({
			            type : "POST",
			            url : "checkEmailExists.action",
			            data : "email=" + email,
			            success : function(data) {
			            	$("#loadingDiv").modal("toggle");
			            	$("#dauEmailMsg")[0].innerHTML = data;
			            	
			            	if(data != ""){
			            		$("#daughterEmail").val('');
			            	}else{
			            		
			            	}
			            }
			        })
			    });
				
			}); 
		</script>
</body>

</html>
