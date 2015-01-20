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
<h2><span>Available Messages</span></h2><hr/>

<div style="height: 400px;width:900px ;overflow: auto;">
<s:actionmessage />
<table width="100%">
	<tr style="background-color: #00adeb; color: #FFFFFF;">
		<th width="40px">#</th>
		<th >Name</th>
		<th >Email</th>
		<th >Message</th>
		
	</tr>
	<s:iterator value="contacMessageList" status="pojo">
		<s:if test="#pojo.count % 2 ==0">
			<tr style="background-color: #F0F8FF; color: navy;">
		</s:if>
		<s:else>
			<tr style="background-color: #E6E6FA; color: navy;">
		</s:else>

		<th><s:property value="#pojo.count" /></th>
		<td><s:property value="name" /></td>
		<td><s:property value="Email" /></td>
		<td><s:property value="yourMessage" /></td>
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
