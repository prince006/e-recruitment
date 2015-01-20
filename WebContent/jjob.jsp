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
<div class="main">
	<jsp:include page="header.jsp" />
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article" style="min-height: 200px;">
          <h2><span>Job Requirement</span></h2><hr/>
         <a href="searchJob.action">Search</a> | <s:if test='#session.resume!="notcreated"'><a href="preferedJob.action">My Preferred Job</a> |</s:if> <a href="allJob.action">List All</a> | <a href="viewSavedJob.action"> View Saved Job</a> | <a href="viewAppliedJob.action"> View Applied Job</a>
        <hr/></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>

  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
