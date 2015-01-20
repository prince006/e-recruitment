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
<h2><span>Search Advertisement</span></h2><hr/>
<a href="createAdvert.action">Create</a> | <a href="searchAdvert.action">Search</a>
| <a href="allAdvert.action">List</a> <s:form method="post"
	theme="simple">
	<hr/><ol>
		<li><label for="subject">Subject</label> <s:textfield
			id="SUBJECT" name="SUBJECT" cssClass="text" theme="simple"></s:textfield>
		</li>
		<li><label for="description">Description</label> <s:textarea
			id="DESC" name="DESC" rows="4" cols="50" theme="simple"></s:textarea>
		</li>
		<li><s:submit name="action" id="action" cssClass="send"
			theme="simple" value="Search" cssStyle="border:solid 1px grey;" />
		<div class="clr"></div>
		</li>
	</ol>
</s:form>
<s:actionerror/>
</div>
</div>
<div class="clr"></div>
</div>
</div>

<jsp:include page="footer.jsp" /></div>
</body>
</html>
