<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script src="js/rightClick.js" type="text/javascript"></script>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<s:head />
</head>
<body>
<div class="main"><jsp:include page="header.jsp" />
<div class="content">
<div class="content_resize">
<div class="mainbar">
<div class="article" style="min-height: 200px;">
<h2><span>Upload Resume</span></h2><hr/>
<a href="jsviewProfile.action">View Profile</a> | <a
	href="jseditProfile.action?action=edit">Edit Profile</a> | <a
	href="jsupload.action?action=input">Upload Docs</a><hr/></div>
</div>
<div class="clr"><s:actionerror /> 
<s:form action="jsupload1" method="POST" enctype="multipart/form-data">
	<s:file name="uploadFile" label="Choose File" size="40" />	
	<s:submit value="Upload" name="submit" />
</s:form></div>
</div>
</div>

<jsp:include page="footer.jsp" /></div>
</body>
</html>
