<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
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
<h2><span>Cleared Exams</span></h2><hr/>
<!-- <a href="searchExamJS.action">Search</a> |  --><a href="allExamJS.action">List Available Exams</a> | <a href="allExamPJS.action">View Passed Exams</a>
<hr/>
<div style="height: 400px;width:900px ;overflow: auto;">
<s:if test="test!=null">
<table width="100%">
	<tr style="background-color: #00adeb; color: #FFFFFF;">
		<th width="40px">#</th>
		<th >Exam ID</th>
		<th >Total Questions</th>
		<th >Min Passing Qus </th>
		<th >Exam Time (Mins.)</th>			
		<th width="60px">Status</th>
		
	</tr>
	<s:iterator value="examList" status="pojo">
		<s:if test="#pojo.count % 2 ==0">
			<tr style="background-color: #F0F8FF; color: navy;">
		</s:if>
		<s:else>
			<tr style="background-color: #E6E6FA; color: navy;">
		</s:else>
        <s:hidden name="no_of_qus"/>
		<th><s:property value="#pojo.count" /></th>
		<td><s:property value="exam_no" /></td>
		<td><s:property value="no_of_qus" /></td>
		<td><s:property value="min_pass" /></td>
		<td><s:property value="exam_time" /></td>		
		<td style="text-align: center;">Cleared	</td>
		</tr>
	</s:iterator>
</table>
  </s:if>
	<s:else>
	<h4><span>Sorry, No Record Found</span></h4>
	</s:else>
</div>
</div>
</div>
<div class="clr"></div>
</div>
</div>

<jsp:include page="footer.jsp" /></div>
</body>
</html>
