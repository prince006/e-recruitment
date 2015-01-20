<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<script src="js/rightClick.js" type="text/javascript"></script>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function validatePassword()
{
	if(document.getElementById("PASSWORD").value=="")
		{
		 alert("Please Enter old Password");
		 document.getElementById("PASSWORD").focus();
		 return false;
		}
	
	if(document.getElementById("PASSWORD").value.length<5 || document.getElementById("PASSWORD").value.length>30)
	{
		alert("Password should be between 5 to 30 characters.");
		document.getElementById("PASSWORD").focus();
		return false;
	}
	
	
	if(document.getElementById("NEWPASS").value=="")
		{
		 alert("Please New Password");
		 document.getElementById("NEWPASS").focus();
		 return false;
		}
	
	
	if(document.getElementById("NEWPASS").value.length<5 || document.getElementById("PASSWORD").value.length>30)
	{
		alert("Password should be between 5 to 30 characters.");
		document.getElementById("NEWPASS").focus();
		return false;
	}
	
	if(document.getElementById("NEWPASS1").value=="")
	{
		 alert("Please Confirm Password");
	 document.getElementById("NEWPASS1").focus();
	 
	 return false;
	}
	

	
	if(document.getElementById("NEWPASS1").value.length<5 || document.getElementById("PASSWORD").value.length>30)
	{
		alert("Password should be between 5 to 30 characters.");
		document.getElementById("NEWPASS1").focus();
		return false;
	}
	
	
	if(document.getElementById("NEWPASS").value!=document.getElementById("NEWPASS1").value)
	{
		alert("Password Mismatch");
		document.getElementById("NEWPASS").value="";
		document.getElementById("NEWPASS").value="";
	 document.getElementById("NEWPASS").focus();
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
         <div style="height: 20px;">
        		<s:actionmessage />
        	</div>
          <h2><span>Reset Password</span></h2>
          <s:form method="post" theme="simple" action="reset">
          <ol>
          <li>
            <label for="Old password">Old Password</label>
            <s:password id="PASSWORD" name="PASSWORD" cssClass="text" theme="simple" ></s:password>
          </li>
          <li>
          	<label for="New pass">New Password(required)</label>
            <s:password id="NEWPASS" name="NEWPASS" cssClass="text" theme="simple" ></s:password>
          </li>
          <li>
          	<label for="New pass">Confirm Password(required)</label>
            <s:password id="NEWPASS1" name="NEWPASS1" cssClass="text" theme="simple" ></s:password>
          </li>                   
          <li>
            <s:submit name="action" id="action" cssClass="send" theme="simple" value="reset" cssStyle="border:solid 1px grey;" onclick="return validatePassword();"/>
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
