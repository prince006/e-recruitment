<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script src="js/rightClick.js" type="text/javascript"></script>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function checkEmail() 
{
	 var email = document.getElementById("EMAIL");
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	
	if (!filter.test(email.value)) 
	{
		alert('Please provide a valid email address');
		email.focus;
		return false;
		} 
	
	return true;
}
function validateMandatory()
{
	
	if(document.getElementById("EMAIL").value=="")
	{
		alert("Email missing.");
		document.getElementById("EMAIL").focus();
		return false;
	}
	
			
	return checkEmail();	
	
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
          <h2><span>Forgot Password</span></h2>
        </div>
        <div class="article">
          <s:form method="post" theme="simple">
          <ol>
          <li>
            <label for="email">Email Address (required)</label>
            <s:textfield id="EMAIL" name="EMAIL" cssClass="text" maxlength="40" theme="simple"></s:textfield>
          </li>
         
          <li>
            <div class="clr"></div>
            <s:submit name="action" id="action" value="Submit" theme="simple" cssStyle="border:solid 1px grey; margin-top:40px;" onclick="return validateMandatory();"/>
          </li>
          </ol>
          </s:form>
          <br/><s:actionmessage />
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>

  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
