<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
          <h2><span>Online Exam</span></h2><hr/>
               <a href="createExam.action">Create</a> | <a href="searchExam.action">Search</a> | <a href="allExam.action">List Self created Exams</a> | <a href="allPExam.action">List Purchased Exams</a>
        <hr/></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>

  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
