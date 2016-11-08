<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin Home Page</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- <link rel="stylesheet" -->
<!-- 	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script> -->
<!-- <script -->
<!-- 	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
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
.topic_holder .topic_name:after {
	/* symbol for "opening" panels */
	font-family: 'Glyphicons Halflings';
	/* essential for enabling glyphicon */
	content: "\e114"; /* adjust as needed, taken from bootstrap.css */
	float: right; /* adjust as needed */
	color: grey; /* adjust as needed */
}
.topic_holder .topic_name.collapsed:after {
	/* symbol for "collapsed" panels */
	content: "\e080"; /* adjust as needed, taken from bootstrap.css */
}
.topic-container {
	position: fixed;
	top: 50px;
	width: 100%;
	height: 200px;
	z-index: 50;
}
</style>


<script type="text/javascript">
		
	$(document).ready(function() {
		
		$("#addNewActivity").click(function() {
			$("#editForm").attr('action', 'newActivityLink.action');
			$('#id').val($("#addNewActivity").attr("name"));
			$("#editForm").submit();
		});
	});
	
	function editActivity(id){
		
		var form = document.getElementById("editForm");
		form.action="editActivity.action";
		form.children.namedItem("id").value=id;
		form.submit();
	}
	
	
	function renameActivityContainer(button) {
		var containerName = button.name;
		var containerId = button.id;
		$('#renameActivityContainer input[name=renameActivityContainer]').val(containerName);
		$('#renameActivityContainer input[name=renameActivityContainerId]').val(containerId);
		$("#renameActivityContainer").modal("toggle");
	}
	
	function deleteActivity(deletedTag){
		
		var deleteId = deletedTag.id.split("_")[1];
		var form = document.getElementById("confirmationForm");
		form.action = "deleteActivity.action";
		$("#deletableId").val(deleteId);
	}
	
	function deleteActivityContainer(deletedTag){
		
		var containerNotEmpty = $("#containerNotEmpty").val();
		
		if(containerNotEmpty=="true"){
			$("#warningDialog").modal("toggle");
		}else{
			var deleteId = deletedTag.id.split("_")[1];
			var form = document.getElementById("confirmationForm");
			form.action = "deleteActivityContainer.action";
			$("#deletableId").val(deleteId);
			$("#confirmationDialog").modal("toggle");
		}
	}
	$(document).ready(function() {
// 		Ajax for renaming the activity container name
		$("#changeActivityContainerName").click(function() {
			containerName = $('#renameActivityContainer input[name=renameActivityContainer]').val();
			containerId = $('#renameActivityContainer input[name=renameActivityContainerId]').val();
			$("#loadingDiv").modal("toggle");
			$("#renameActivityContainer").modal("toggle");
			$.ajax({
				type : "POST",
				url : "renameActivityContainer.action",
				data : "containerName=" + containerName + "&containerId=" + containerId,
				success : function(data) {
					$("#loadingDiv").modal("toggle");
					$("#containerName_" + containerId)[0].innerHTML = containerName;
					$('#'+containerId).attr('name', containerName);
				}
			});
		});
		
		$(".goBack").on("click",function(e) {
		    e.preventDefault(); // cancel the link itself
		    $("#editForm").attr('action', this.href);
			$("#editForm").submit();
		  });
		
		
	});
</script>

</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand goBack" href="adminLoadHome.action">Admin</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="adminLoadHome.action" class="goBack">Topics and Blocks</a></li>
<!-- 					<li class="active"><a href="#">Blocks and Activities</a></li> -->
					<li><a data-toggle="modal" id ="addAdmin" href="#addNewAdmin">Add New Admin</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="adminLogout.action"><span class="glyphicon glyphicon-log-out"></span> Logout </a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div>
		<div class="jumbotron">
			<div class="container text-center">
				<h1>Blocks and Activities</h1>
				<p>Add-Remove-Edit Blocks and Activities, all at one place.</p>
			</div>
		</div>
	</div>

	<div class="container-fluid bg-3 text-left">

		<div class="row">
			<div class="col-sm-8">
				<div class="jumbotron">
					<div> <!-- class="topic_holder" -->
						<h2>
							<span id="containerName_${activityContainer.activityContainerId}">${activityContainer.containerName}</span>

							<button type="button" class="btn btn-success"
								id="${activityContainer.activityContainerId}"
								name="${activityContainer.containerName}"
								onclick="renameActivityContainer(this)">Rename</button>
							<a class="btn btn-danger"  id="deleteId_${activityContainer.activityContainerId}" 
							 role="button" onclick="deleteActivityContainer(this)">Delete</a>
							 <input type="hidden" id="containerNotEmpty" value="${fn:length(activityContainer.activities)>0}"/>
						</h2>
					</div>
					<div id="container_for-${activityContainer.activityContainerId}">
						<table class="table table-hover">
							<tbody>
							<c:choose> 
							<c:when test="${fn:length(activityContainer.activities)>0}">
								<c:forEach items="${activityContainer.activities}" var="activity">
									<tr>
										<td><h5>${activity.activityText}</h5></td>
										<td><a class="btn btn-success" role="button"
											id="${activity.id}_${activity.activityTemplate.id}" onclick="editActivity(id)">Edit</a></td>
										<td><a class="btn btn-danger" data-toggle="modal"
							 					data-target="#confirmationDialog" id="deleteId_${activity.id}" 
							 					role="button" onclick="deleteActivity(this)">Delete</a></td>
									</tr>
								</c:forEach>
								</c:when>
								<c:otherwise>
									<div class="jumbotron">
										<h4>No activities available right now. You might want to add some activities first.</h4>
									</div>
								</c:otherwise>
							</c:choose>
								<tr>
									<td></td>
									<td></td>
									<td><a class="btn btn-warning" id="addNewActivity" 
									name="${activityContainer.activityContainerId}" role="button">Add New Activity</a></td>
								</tr>
							</tbody>

						</table>
					</div>
				</div>
			</div>
			<!-- 			<div class="col-sm-4"></div> -->
			<!-- Renaming the Activity container pop up modal  START-->
			<div class="modal fade" id="renameActivityContainer" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Rename Topic</h4>
						</div>
						<div class="modal-body">
							<input type="text" class="form-control" id="renameActivityContainer"
								name="renameActivityContainer" placeholder="Enter new activity container name" /> 
								<input type="hidden" name="renameActivityContainerId" id="renameActivityContainerId" />
						</div>
						<div class="modal-footer">
							<input type="button" id="changeActivityContainerName" class="btn btn-success"
								role="button" value="Change Name" />
						</div>
					</div>
				</div>
			</div>
			<!-- Renaming the Activity container pop up modal  END-->

<!-- 		Confirmation dialog before delete START -->
			<div class="modal fade" id="confirmationDialog" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Please confirm!</h4>
						</div>
						<form id="confirmationForm" name="confirmationForm" method="post">
							<div class="modal-body">
								<h4 class="modal-title">Do you really want to remove this?</h4>
								<input type="hidden" class="form-control" id="deletableId"  name="deletableId" />
							</div>
							<div class="modal-footer">
								<a class="btn btn-default" data-dismiss="modal">No</a>
								<input type="submit" class="btn btn-success" role="button" value="Yes"/>
							</div>
						</form>
					</div>
				</div>
			</div>
<!-- 		Confirmation dialog before delete END -->

<!-- 		Cannot delete warning START -->
			<div class="modal fade" id="warningDialog" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">No can do!!!</h4>
						</div>
						<div class="modal-body">
							<h4 class="modal-title">It seems that the topic is not empty. You cannot delete this topic.</h4>
						</div>
						<div class="modal-footer">
							<a class="btn btn-danger" data-dismiss="modal">OK</a>
						</div>
					</div>
				</div>
			</div>
<!-- 		Cannot delete warning  END -->




			<!-- 			Loading image Under progress -->
			<div id="loadingDiv" class="modal">
				<img alt="loading" src="Images/loading.gif">
			</div>
		</div>
	</div>
	<form name="editForm" id="editForm" action="#" method="post">
		<input type="hidden" id="id" name="id" value="" />
	</form>
	<!-- Footer -->
	<%@ include file="footer.jsp" %>
</body>
</html>
