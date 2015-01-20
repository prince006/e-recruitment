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
        <div class="article">
          <h2><span>Purchased Resumes</span></h2><hr/>
        <a href="searchEResume.action">Search</a> | <a href="allEResume.action">List All</a> | <a href="viewSavedEResume.action"> View Saved</a> | <a href="viewPurchasedEResume.action"> View Purchased</a>
         <hr/>
         <div style="height: 400px;width:900px ;overflow: auto;">
         <s:actionmessage/>
      <s:if test="test!=null">
          <table width="100%">
          	<tr style="background-color:#00adeb; color: #FFFFFF;">
          		<th width="20px">#</th>
          		<th width="200px">Title</th>
          		<th width="200px">Name</th>
          		<th width="100px">Experience</th>
          		<th width="50px">Gender</th>
          		<th width="50px">Married</th>
          		<th width="50px">Rating</th>
          		<th>&nbsp;</th>
          	</tr>
          	<s:iterator value="resumes" status="userPojo">
          	<s:if test="#userPojo.count % 2 ==0">
          		<tr style="background-color:#F0F8FF; color: navy;">
          	</s:if>
          	<s:else>
          		<tr style="background-color:#E6E6FA; color: navy;">
          	</s:else>
          		<th><s:property value="#userPojo.count"/></th>          	
          		<td style="text-align: center;"><s:property value="title"/></td>
          		<td style="text-align: center;"><s:property value="first_name"/></td>
          		<td style="text-align: center;"><s:property value="exp"/></td>
          		<td style="text-align: center;"><s:property value="gender"/></td>
          		<td style="text-align: center;"><s:property value="is_married"/></td>
          		<td style="text-align: center;"><s:property value="rating"/></td>          		          		
          		<td style="text-align: center;">          		
          		<a href="downloadResume.action?action=dwResume&resume_no=<s:property value='resume_no'/>"> View/Download Resume	</a>                          		
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
  
  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
