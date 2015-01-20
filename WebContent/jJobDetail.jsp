<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<html>
<head>
<script src="js/rightClick.js" type="text/javascript"></script>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<sx:head/>
</head>
<body>
<div class="main"><jsp:include page="header.jsp" />

<div class="content">
<div class="content_resize">
<div class="mainbar">
<div class="article">
<h2><span>Job Requirement Details</span></h2>
<a href="job.action"><--Back to Vacancy Home</a>  
 <s:form method="post" theme="simple">
<ol>
	<li><label for="userid">Job ID</label> <s:textfield	id="job_no" name="job_no" cssClass="text" theme="simple" readonly="true"></s:textfield></li>
	<li><label for="title">Title (required)</label> <s:textfield id="title" name="title" cssClass="text" readonly="true" theme="simple"></s:textfield></li>
	<li><label for="desc">Description (required)</label> <s:textarea id="description" name="description" cssClass="text" rows="4" cols="50" readonly="true" theme="simple"></s:textarea></li>
	<li><label for="expiry date">Expiry Date (required)</label>	<s:textfield name="expire_dat" id="expire_dat" readonly="true" /></li>
		
	<li><label >Skill Required (required)</label> <s:textarea id="skill_req" name="skill_req" readonly="true" cssClass="text" rows="4" cols="50" theme="simple"></s:textarea></li>
    <li><label >Job Location (required)</label> <s:textfield id="location" name="location" readonly="true" cssClass="text" theme="simple"></s:textfield></li>
    <li><label >Job Role (required)</label> <s:textfield id="job_role" name="job_role" readonly="true" cssClass="text" theme="simple"></s:textfield></li>
    <li><label >Employee Type (required)</label> <s:textfield id="emp_type" name="emp_type" readonly="true" cssClass="text" theme="simple"></s:textfield></li>
    <li><label >Functional Area (required)</label> <s:textarea id="fun_area" name="fun_area" readonly="true" rows="4" cols="50" cssClass="text" theme="simple"></s:textarea></li>
    <li><label >Job Category (required)</label> <s:textfield id="job_cat" name="job_cat" cssClass="text" readonly="true" theme="simple"></s:textfield></li>
    
	<li><label for="min">Min Exp (required)</label> <s:textfield id="min_exp" name="min_exp" cssClass="text" readonly="true" theme="simple"></s:textfield></li>
	<li><label for="max">Max Exp (required)</label> <s:textfield id="max_exp" name="max_exp" cssClass="text" readonly="true" theme="simple"></s:textfield></li>

	<li> 
		<s:if test='is_applied!="1"'>
			<s:if test='is_saved!="1"'> 
				<a href="applyJob.action?action=save&job_no=<s:property value='job_no'/>"> <h3>Save</h3> </a>
		    </s:if> 	    
			<a href="applyJob.action?action=apply&job_no=<s:property value='job_no'/>"> <h3>Apply</h3></a>
		</s:if> 
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
