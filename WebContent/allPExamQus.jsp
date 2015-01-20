<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%> 
<html>
<head>
<script src="js/rightClick.js" type="text/javascript"></script>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script>
</script>

</head>
<body>
<div class="main"><jsp:include page="header.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<div class="article">
<h2><span>Add/Remove Question for the Exam</span></h2><hr/>
         <a href="createExam.action">Create</a> | <a href="searchExam.action">Search</a> | <a href="allExam.action">List Self created Exams</a> | <a href="allPExam.action">List Purchased Exams</a>
<hr/>
<s:actionmessage/>
<s:form method="post" theme="simple">
<s:hidden name="exam_no"/>
<s:hidden name="no_of_qus"/>
<table width="980px" cellspacing="3px">
	<tr style="background-color: #00adeb; color: #FFFFFF;" valign="top" align="left" >
		<th width="10px">#</th>
		<th width="510px">Question</th>
		<th width="200px">Ans-A</th>
		<th width="200px">Ans-B</th>
		<th width="200px">Ans-C</th>
		<th width="200px">Ans-D</th>
		<th width="10px">Correct Ans</th>			
	</tr>	
	<s:iterator value="model" status="rowStatus">
		<tr style="background-color: #F0F8FF; color: navy;" align="left" valign="top">
		    <th><s:property value="#rowStatus.count" /></th> 
			<th><s:property value="qus" /></th>
			<td><s:property value="ansa" /></td>
			<td><s:property value="ansb" /></td>
			<td><s:property value="ansc" /></td>
			<td><s:property value="ansd" /></td>
			<td><s:property value="correctans" /></td>
			
		</tr>			
	</s:iterator>			
</table>
</s:form>
</div>
</div>
<div class="clr"></div>
</div>
</div>

<jsp:include page="footer.jsp" /></div>
</body>
</html>
