<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<script src="js/rightClick.js" type="text/javascript"></script>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function validateAdverts()
	{
		if(document.getElementById("SUBJECT").value=="")
		{
		 alert("Subject Missing");
		 document.getElementById("SUBJECT").focus();
		 return false;
		}
		

		if(document.getElementById("DESC").value=="")
		{
		 alert("Description Missing");
		 document.getElementById("DESC").focus();
		 return false;
		}
		return true;
	}
</script>

</head>
<body>
<div class="main">

	<jsp:include page="header.jsp" />

  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2><span>Create Advertisement</span></h2><hr/>
           <a href="createAdvert.action">Create</a> | <a href="searchAdvert.action">Search</a> | <a href="allAdvert.action">List</a>
         <hr/> <s:form method="post" theme="simple" method="POST" enctype="multipart/form-data" >
          <ol>
         
          <li>
           	<label for="subject">Subject (required)</label>
            <s:textfield id="SUBJECT" name="SUBJECT" maxlength="100" cssClass="text"  required="true" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="description">Description (required)</label>
            <s:textarea id="DESC" name="DESC" rows="4"  cols="50" required="true"  theme="simple"></s:textarea>
          </li>
          <li>
            <label for="file">Choose an Image (required)</label>
            <s:file name="uploadFile" label="Choose File" size="200" required="true" />	
          </li>
            <s:submit name="action" id="action" cssClass="send" theme="simple" value="Save" cssStyle="border:solid 1px grey;" onclick="return validateAdverts();"/>
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
