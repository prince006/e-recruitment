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
          <h2><span>Search Resume</span></h2><hr/>
 	     <a href="searchEResume.action">Search</a> | <a href="allEResume.action">List All</a> | <a href="viewSavedEResume.action"> View Saved</a> | <a href="viewPurchasedEResume.action"> View Purchased</a>
         <hr/> <s:form method="post" theme="simple">
          <ol>
          <li>
          	<label for="category">Title *</label>
            <s:textfield id="title" name="title"  cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="name">First Name*</label>
            <s:textfield id="first_name" name="first_name" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="name">Last Name*</label>
            <s:textfield id="last_name" name="last_name" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
          	<label for="category">Gender *</label>
            <s:select id="gender" name="gender" cssStyle="border:solid 1px grey; width:488px;" theme="simple" list="#{'M':'Male','F':'Female'}" headerKey="0" headerValue="--Select Gender--"></s:select>
          </li>
            <li>
          	<label for="category">Married *</label>
            <s:select id="is_married" name="is_married" cssStyle="border:solid 1px grey; width:488px;" theme="simple" list="#{'Y':'Yes','N':'No'}" headerKey="0" headerValue="--Select Status--"></s:select>
          </li>                       
          <li>
          	<label for="status">Experience</label>
            <s:textfield id="exp" name="emp" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
          	<label for="status">Rating</label>
			<s:textfield id="rating" name="rating" cssClass="text" theme="simple"></s:textfield>
          </li>   
             
          <li>
            <s:submit name="action" id="action" cssClass="send" theme="simple" value="Search" cssStyle="border:solid 1px grey;"/>
            <div class="clr"></div>
          </li>
          </ol>
          </s:form>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  
  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
