<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
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
<h2><span>Search Job</span></h2><hr/>
         <a href="searchJob.action">Search</a> | <s:if test='#session.resume!="notcreated"'><a href="preferedJob.action">My Preferred Job</a> |</s:if> <a href="allJob.action">List All</a> | <a href="viewSavedJob.action"> View Saved Job</a> | <a href="viewAppliedJob.action"> View Applied Job</a> 
<hr/><s:form method="post" theme="simple">
	<ol>
		<li><label for="title">Title (required)</label> <s:textfield
			id="title" name="title" cssClass="text" theme="simple"></s:textfield></li>
		<li><label for="desc">Description (required)</label> <s:textarea id="description" name="description" cssClass="text" rows="4" cols="50" theme="simple"></s:textarea></li>
		<li><label for="expiry date">Expiry Date (required)</label> <sx:datetimepicker name="expire_dat" id="expire_dat" type="date" displayFormat="yyyy-MM-dd"/></li>
		
		<li><label >Skill Required (required)</label> <s:textarea id="skill_req" name="skill_req" cssClass="text" rows="4" cols="50" theme="simple"></s:textarea></li>
	    <li><label >Job Location (required)</label> <s:textfield id="location" name="location" cssClass="text" theme="simple"></s:textfield></li>
	    <li><label >Job Role (required)</label> <s:textfield id="job_role" name="job_role" cssClass="text" theme="simple"></s:textfield></li>
	    <li><label >Employee Type (required)</label> <s:textfield id="emp_type" name="emp_type" cssClass="text" theme="simple"></s:textfield></li>
	    <li><label >Functional Area (required)</label> <s:textarea id="fun_area" name="fun_area" rows="4" cols="50" cssClass="text" theme="simple"></s:textarea></li>
	    <li><label >Job Category (required)</label> <s:textfield id="job_cat" name="job_cat" cssClass="text" theme="simple"></s:textfield></li>
	    
		<li><label for="min">Min Exp (required)</label> <s:textfield
			id="min_exp" name="min_exp" cssClass="text" theme="simple"></s:textfield></li>
		<li><label for="max">Max Exp (required)</label> <s:textfield
			id="max_exp" name="max_exp" cssClass="text" theme="simple"></s:textfield></li>			
		<li><s:submit name="action" id="action" cssClass="send"
			theme="simple" value="Search" cssStyle="border:solid 1px grey;" />
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
