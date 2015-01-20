<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
 <script src="js/rightClick.js" type="text/javascript"></script>
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
	
			
	if(document.getElementById("PASSWORD").value=="")
	{
		alert("Password missing.");
		document.getElementById("PASSWORD").focus();
		return false;
	}
	
	if(document.getElementById("PASSWORD").value.length<5 || document.getElementById("PASSWORD").value.length>30)
	{
		alert("Password should be between 2 to 30 characters.");
		document.getElementById("PASSWORD").focus();
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
          <h2><span>Login</span></h2>
        </div>
        <div class="article">
          <s:form method="post" theme="simple">
          <ol>
          <li>
            <label for="email">Email Address (required)</label>
            <s:textfield id="EMAIL" name="EMAIL" cssClass="text" maxlength="40" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="password">Password (required)</label>
            <s:password id="PASSWORD" name="PASSWORD" maxlength="30" cssClass="text" theme="simple"></s:password>
          </li>
          <li>
            <div class="clr"></div>
            <s:submit name="action" id="action" value="Login" theme="simple" cssStyle="border:solid 1px grey; margin-top:40px;" onclick="return validateMandatory();"/>
          </li>
          </ol>
          </s:form>
          <br/><s:actionmessage />
        </div>
        <a href="forgotpass.action?action=Submit">Forgot Password</a>
      </div>
      <div class="clr"></div>
    </div>
  </div>

  <jsp:include page="footer.jsp" />
</div>
</body>
</html>
