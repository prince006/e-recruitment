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
<h2><span><s:property value="pagetitle"/></span></h2><hr/>
<a href="searchJob.action">Search</a> | <s:if test='#session.resume!="notcreated"'><a href="preferedJob.action">My Preferred Job</a> |</s:if> <a href="allJob.action">List All</a> | <a href="viewSavedJob.action"> View Saved Job</a> | <a href="viewAppliedJob.action"> View Applied Job</a>
<hr/><div style="height: 400px;width:900px ;overflow: auto;">
<s:actionmessage/>
<s:if test="test!=null">
	<table width="100%">
		<tr style="background-color: #00adeb; color: #FFFFFF;">
			<th width="40px">#</th>
			<th width>Title</th>
			<th width>Description</th>
			<th width>Expiry Date</th>
			<th width>Min Exp</th>
			<th width>Max Exp</th>			
			<th width="60px">Status</th>
			<th>&nbsp;</th>
		</tr>
		<s:iterator value="jobList" status="pojo">
			<s:if test="#pojo.count % 2 ==0">
				<tr style="background-color: #F0F8FF; color: navy;">
			</s:if>
			<s:else>
				<tr style="background-color: #E6E6FA; color: navy;">
			</s:else>
			<th><s:property value="#pojo.count" /></th>
			<td><s:property value="title" /></td>
			<td><s:property value="description" /></td>
			<td><s:property value="expire_date" /></td>
			<td><s:property value="min_exp" /></td>
			<td><s:property value="max_exp" /></td>
			<td style="text-align: center;">
			 <s:if test='is_active=="Y"'>Active</s:if>
			 <s:elseif test='is_active=="N"'>Inactive</s:elseif>
			 <s:else>Unknown</s:else></td>
			             
			<td style="text-align: center;">
 	        <a href="viewDetailedJob.action?action=view&job_no=<s:property value='job_no'/>"> View Detail</a>
			 </td>
			
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
