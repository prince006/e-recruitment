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
<h2><span>Available Questions</span></h2><hr/>
<a href="createQuest.action">Create</a> | <a href="searchQuest.action">Search</a>
| <a href="allQuest.action">List</a><hr/>
<div style="height: 400px;width:900px ;overflow: auto;">
<s:if test="size!=null">
<table width="100%">
	<tr style="background-color: #00adeb; color: #FFFFFF;">
		<th width="40px">#</th>
		<th width>Question</th>
		<th width>Ans-A</th>
		<th width>Ans-B</th>
		<th width>Ans-C</th>
		<th width>Ans-D</th>
		<th width>Correct Ans</th>		
		<th width="60px">Status</th>
		<th>&nbsp;</th>
	</tr>
	<s:iterator value="questList" status="pojo">
		<s:if test="#pojo.count % 2 ==0">
			<tr style="background-color: #F0F8FF; color: navy;">
		</s:if>
		<s:else>
			<tr style="background-color: #E6E6FA; color: navy;">
		</s:else>

		<th><s:property value="#pojo.count" /></th>
		<td><s:property value="qus" /></td>
		<td><s:property value="ansa" /></td>
		<td><s:property value="ansb" /></td>
		<td><s:property value="ansc" /></td>
		<td><s:property value="ansd" /></td>
		<td><s:property value="correctans" /></td>
		<td style="text-align: center;"><s:if test='is_active=="Y"'>Active</s:if><s:elseif
			test='is_active=="N"'>Inactive</s:elseif><s:else>Unknown</s:else></td>
		<td style="text-align: center;"><a
			href="editQuest.action?action=edit&qus_no=<s:property value='qus_no'/>">Edit</a></td>
		</tr>
	</s:iterator>
</table>
</s:if>
<s:else><h3>Sorry, No Record Found</h3></s:else>
</div>
</div>
</div>
<div class="clr"></div>
</div>
</div>

<jsp:include page="footer.jsp" /></div>
</body>
</html>
