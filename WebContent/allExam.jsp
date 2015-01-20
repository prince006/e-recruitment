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
<h2><span>Self Created Online Exam</span></h2><hr/>
<a href="createExam.action">Create</a> | <a href="searchExam.action">Search</a> | <a href="allExam.action">List Self created Exams</a> | <a href="allPExam.action">List Purchased Exams</a>
<hr/>
<div style="height: 400px;width:900px ;overflow: auto;">
<table width="100%">
	<tr style="background-color: #00adeb; color: #FFFFFF;">
		<th width="40px">#</th>
		<th >Exam ID</th>
		<th >Total Questions</th>
		<th >Min Passing Qus </th>
		<th >Exam Time (Mins.)</th>			
		<th width="60px">Status</th>
		<th>&nbsp;</th>
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
		<td style="text-align: center;"><s:if test='is_active=="Y"'>Active</s:if><s:elseif
			test='is_active=="N"'>Inactive</s:elseif><s:else>Unknown</s:else></td>
		<td style="text-align: center;">
		<a href="editExam.action?action=edit&exam_no=<s:property value='exam_no'/>">Edit Exam |</a>
		<a href="examQAdd.action?action=show&exam_no=<s:property value='exam_no'/>&no_of_qus=<s:property value='no_of_qus'/>">Add/Remove Questions</a>
		<a href="clearedUser.action?link=allExam.action&exam_no=<s:property value='exam_no'/>">Cleared User</a>
		</td>
		</tr>
	</s:iterator>
</table>
</div>
</div>
</div>
<div class="clr"></div>
</div>
</div>

<jsp:include page="footer.jsp" /></div>
</body>
</html>
