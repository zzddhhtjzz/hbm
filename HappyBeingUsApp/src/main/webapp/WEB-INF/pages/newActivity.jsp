<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Activity here</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
	
</script>
<script>
	$(document).ready(function() {
// 		dropdown for all the templates.
		$('#activityTemplate').on('change', function() {
			var template_id = $('#activityTemplate').val();
			$("#activityTemplate > option").each(function() {
				if (template_id == this.value) {
					$("#"+this.value).css("display", "block");
				} else {
					$("#"+this.value).css("display", "none");
				}
			});
		});
		
	});
	

//		mcq template, update checkbox value with the input of user
	$(document).on('change', '#mcqOptions .option', function() {
		var num = this.id.split('_')[1];
		$('#mcqOptions #checkBox_'+num).val(this.name);
	});
	

//		adding more options inside the mcq template
	$(document).on('click', '#mcqMoreOptions', function() {
		var maxVal = $('#mcqMaxOptions').val();
		var nxtVal = parseInt(maxVal)+1;
		$('#mcqOptions').append(
				'<div class="mcqOption" id="mcqOption_'+nxtVal+'"> '
					+'<input type="Checkbox" name="correctAnswer" class="chkbx" id="checkBox_'+nxtVal+'" /> ' 
					+'<input class="option" type="text" name="option_'+nxtVal+'" id="option_'+nxtVal+'" /> '
					+'<button class="removeOption" id="removeOption_'+nxtVal+'" type="button">Remove</button><br> ' 
				+'</div>');
		$('#mcqMaxOptions').val(nxtVal);
		if(nxtVal == 5){
			$('#mcqMoreOptions').css("display", "none");
		}
	});
	
	//		mcq template, remove option
	$(document).on('click', "#mcqOptions .removeOption", function() {
		var removeId = this.id.split("_")[1];
		$('#mcqOptions #mcqOption_'+removeId).remove();
		var maxVal = $('#mcqMaxOptions').val();
		var newVal = parseInt(maxVal)-1;
		var initVal = 0;
		$("#mcqOptions .mcqOption").each(function() {
			initVal = initVal +1;
			this.id = "mcqOption_"+initVal;
			$('#'+this.id+' .chkbx')[0].id = "checkBox_"+initVal;
			$('#'+this.id+' .option')[0].id = "option_"+initVal;
			$('#'+this.id+' .option')[0].name = "option_"+initVal;
			$('#'+this.id+' .removeOption')[0].id = "removeOption_"+initVal;
		});
		$('#mcqMoreOptions').css("display", "block");
		$('#mcqMaxOptions').val(newVal);
	});
</script>
</head>
<body>
	<label>Template type : </label>

	<select name="activityTemplate" id="activityTemplate">
		<option value="-1">--SELECT--</option>
		<c:forEach items="${activityTemplates}" var="template">
			<option value="template_${template.id}">${template.templateName}</option>
		</c:forEach>
	</select>

	<div id="templateContainer">
		<c:forEach items="${activityTemplates}" var="template">
			<c:if test="${template.id==3}">
				<form:form action="addActivity.action" method="post"
					name="mcqForm" id="mcqForm" modelAttribute="activity">
					<div id="template_${template.id}" style="display: none">
						<p>Type the question below</p>
						<form:input style="width: 300px" type="text" name="Question" path="activityText" />
						<p>Type the Options below</p>
						<div id="mcqOptions">
							<div class="mcqOption" id="mcqOption_1">
								<input type="Checkbox" name="correctAnswer" class="chkbx" id="checkBox_1" /> 
								<input class="option" type="text" name="option_1" id="option_1" />
								<button class="removeOption" id="removeOption_1" type="button">Remove</button><br> 
							</div>
							
							<div class="mcqOption" id="mcqOption_2">
								<input type="Checkbox" name="correctAnswer" class="chkbx" id="checkBox_2" /> 
								<input class="option" type="text" name="option_2" id="option_2" />
								<button class="removeOption" id="removeOption_2" type="button">Remove</button><br> 
							</div>
							
							<div class="mcqOption" id="mcqOption_3">
								<input type="Checkbox" name="correctAnswer" class="chkbx" id="checkBox_3" />
								<input class="option" type="text" name="option_3" id="option_3" />
								<button class="removeOption" id="removeOption_3" type="button">Remove</button><br>
							</div>
<!-- 							<input type="Checkbox" name="Answer4" /> <input type="text" name="Option4" /><br>  -->
<!-- 							<input type="Checkbox" name="Answer5" /> <input type="text" name="Option5" /><br> -->
						</div>
						<br></br>
						<button id="mcqMoreOptions" type="button">Add more options</button>
						<button type="submit">Upload</button>
						<form:input type="hidden" path="activityType.id" />
						<form:input type="hidden" path="activityTemplate.id"
							value="${template.id}" />
						<form:input type="hidden" path="activityContainer.activityContainerId" />
					</div>
				</form:form>
				<input type="hidden" id="mcqMaxOptions" value="3"/>
			</c:if>
			<c:if test="${template.id==2}">
				<form:form action="addActivity.action" method="post"
					modelAttribute="activity">
					<div id="template_${template.id}" style="display: none">
						<p>Type the question below</p>
						<form:input style="width: 300px" type="text" name="Question"
							path="activityText" />
						<p>Type the Options below</p>
						<input type="Checkbox" name="Answer1" /><input type="text"
							name="Option1" /><br> <input type="Checkbox" name="Answer2" /><input
							type="text" name="Option2" /><br> <br></br>
						<button type="submit">Upload</button>
						<form:input type="hidden" path="activityType.id" />
						<form:input type="hidden" path="activityTemplate.id"
							value="${template.id}" />
						<form:input type="hidden" path="activityContainer.activityContainerId" />

					</div>
				</form:form>
			</c:if>
		</c:forEach>
	</div>
	<!-- Footer -->
	<%@ include file="footer.jsp" %>
</body>
</html>