<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<html>
<head>
<script src="js/rightClick.js" type="text/javascript"></script>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

function allowedNumber()
{
	if(event.keyCode >=48 && event.keyCode <= 57)
	{       			 			
		return true;
	}
	else
	{
		event.keyCode=0; 
		alert("Only Number Allowed Here");
		
		return false;   
	} 		
}

function validateMandatory()
{
	
	if(document.getElementById("no_of_qus").value=="")
	{
		alert("Number Of Questions Missing....");
		document.getElementById("no_of_qus").focus();
		return false;
	}
	
			
	if(document.getElementById("min_pass").value=="")
	{
		alert("Minimum Questions for passing Missing");
		document.getElementById("min_pass").focus();
		return false;
	}
	
	if(document.getElementById("exam_time").value=="")
	{
		alert("Exam Time is missing.");
		document.getElementById("exam_time").focus();
		return false;
	}
	
	return true;
	
}
</script>

</head>
<body>
<div class="main"><jsp:include page="header.jsp" />

<div class="content">
<div class="content_resize">
<div class="mainbar">
<div class="article">
<h2><span>Edit Online Exam </span></h2><hr/>
<a href="createExam.action">Create</a> | <a href="searchExam.action">Search</a> | <a href="allExam.action">List Self created Exams</a> | <a href="allPExam.action">List Purchased Exams</a>
 <hr/><s:form method="post" theme="simple">
	<ol>
		<li><label for="examid">Exam ID</label> <s:textfield id="exam_no" name="exam_no" cssClass="text" theme="simple"	readonly="true"></s:textfield></li>	
		<li><label for="total questions">Total no Questions</label> <s:textfield id="no_of_qus" name="no_of_qus" cssClass="text" theme="simple" onkeypress="return allowedNumber();" ></s:textfield></li>
		<li><label for="min questions">Minimum Passing Questions</label> <s:textfield id="min_pass" name="min_pass" cssClass="text" theme="simple" onkeypress="return allowedNumber();"></s:textfield></li>		
		<li><label for="Exam time">Exam Time (Minutes) </label> <s:textfield id="exam_time" name="exam_time" cssClass="text" theme="simple" onkeypress="return allowedNumber();"></s:textfield></li>
		<li><label for="status">Status (required)</label> <s:select	id="is_active" name="is_active"	cssStyle="border:solid 1px grey; width:488px;" theme="simple" list="#{'Y':'Active','N':'Inactive','X':'Delete'}" headerKey="0"
			headerValue="--Select Status--"></s:select></li>
		<li><s:submit name="action" id="action" cssClass="send" theme="simple" value="Save" cssStyle="border:solid 1px grey;" onclick="return validateMandatory();" />
		<div class="clr"></div>
		</li>
	</ol>
</s:form></div>
</div>
<div class="clr"></div>
</div>
</div>

<jsp:include page="footer.jsp" /></div>
</body>
</html>
