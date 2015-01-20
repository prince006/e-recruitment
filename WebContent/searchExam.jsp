<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<script src="js/rightClick.js" type="text/javascript"></script>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="main"><jsp:include page="header.jsp" />

<div class="content">
<div class="content_resize">
<div class="mainbar">
<div class="article">
<h2><span>Search Online Exams</span></h2><hr/>
<s:if test='#session.user.CATEGORY=="E"'>
<a href="createExam.action">Create</a> | <a href="searchExam.action">Search</a> | <a href="allExam.action">List Self created Exams</a> | <a href="allPExam.action">List Purchased Exams</a> 
</s:if>
<s:else>
<a href="searchExamJS.action">Search</a> | <a href="allExamJS.action">List Available Exams</a> | <a href="allExamPJS.action">View Passed Exams</a>
</s:else>
<s:form method="post" theme="simple">
	<hr/><ol>
		<li><label for="total questions">Total no Questions</label> <s:textfield id="no_of_qus" name="no_of_qus" cssClass="text" theme="simple"></s:textfield></li>
		<li><label for="min questions">Minimum Passing Questions</label> <s:textfield id="min_pass" name="min_pass" cssClass="text" theme="simple"></s:textfield></li>		
		<li><label for="Exam time">Exam Time (Minutes) </label> <s:textfield id="exam_time" name="exam_time" cssClass="text" theme="simple"></s:textfield></li>			
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
