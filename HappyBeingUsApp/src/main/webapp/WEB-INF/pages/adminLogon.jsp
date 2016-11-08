<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet">
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
<title>Admin Login</title>
</head>
<body>
	<div class="row" style="background-color: black; height: 20px;"></div>
	<div class="row" style="background-color: #b3ecff; height: 20px;"></div>
	<form action="adminHome.action" method="post">
		<div class="modal-header">
			<h4 style="margin-left:35%">Admin Login</h4>
		</div>
		<div class="modal-body" style="width: 500px; height: 200px;margin-left:30%">
			<div class="form-group left-inner-addon">
				<div class="col-lg-8">
					<i class="glyphicon glyphicon-user"></i> <input type="text"
						class="form-control" name="username" placeholder="User name"
						required>
				</div>
			</div>
			<br></br>
			<div class="form-group left-inner-addon">
				<div class="col-lg-8">
					<i class="glyphicon glyphicon-lock"></i> <input type="password"
						class="form-control" name="password" placeholder="password"
						required>
				</div>
			</div>
			<br></br>
			<span id="AdminErr" style="display:none">Please check the Username/Password you have entered.</span>
			<div class="col-lg-6">
				<a href="#ForgotPassword" data-toggle="modal">Forgot Password</a>
			</div>
			<br></br>
		</div>
		<div class="modal-footer" style="margin-right:50%">
			<button class="btn btn-primary" type="submit">Login</button>

		</div>
	</form>
	
	<div class="modal fade" id="ForgotPassword" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content col-lg-10">
				<form action="forgotAdminPassword.action" method="post">
					<div class="modal-header">
						<h4>Reset Username Password</h4>
					</div>
					
					<div class="modal-body">
					<div class="form-group left-inner-addon">
					<div class="col-lg-8">
									<i class="glyphicon glyphicon-envelope"></i> <input
										type="email" path="user.email" class="form-control" maxlength = "80"
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
	
	
	<!-- Footer -->
	<%@ include file="footer.jsp" %>
	<script src="js/jquery.js"></script>
<input type="hidden" id="check" name="checkAdmin" value="${adminLogonErr}" />

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script>
	$(document).ready(function() {

		if ($("#checkAdmin")[0].value == 'false') {
			$('#AdminErr').css('display', 'block');
		}
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
	
	$("#adminEmail").change(function() {
		email = $('#adminEmail').val();
		$("#loadingDiv").modal("toggle");
		$("#adminEmailMsg")[0].innerHTML = "";
		$.ajax({
            type : "POST",
            url : "checkEmailExists.action",
            data : "email=" + email,
            success : function(data) {
            	$("#loadingDiv").modal("toggle");
            	$("#adminEmailMsg")[0].innerHTML = data;
            	
            	if(data != ""){
            		$("#adminEmail").val('');
            	}else{
            		
            	}
            }
        })
    });
	</script>
</body>
</html>