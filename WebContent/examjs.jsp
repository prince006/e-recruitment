<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script src="js/rightClick.js" type="text/javascript"></script>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script>
function openWindow()
{
window.open('giveExamReal.action?exam_no=<s:property value='exam_no'/>','a','height=600,width=1220');
}
</script>
</head>
<body>
<div class="main">
<s:if test="giveExam=='true'"> 
<body onload="openWindow();"/>
</s:if>
	<jsp:include page="header.jsp" />
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article" style="min-height: 200px;">
          <h2><span>Online Exam</span></h2><hr/>
             <!--  <a href="searchExamJS.action">Search</a> | --> <a href="allExamJS.action">List Available Exams</a> | <a href="allExamPJS.action">View Passed Exams</a>
        <hr/></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>

  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
