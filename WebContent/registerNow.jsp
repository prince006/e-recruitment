<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<script src="js/rightClick.js" type="text/javascript"></script>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">


function allowedNumber()
{
	if(event.keyCode >=48 && event.keyCode <= 57)
	{       			 			
		return true;
	}
	else
	{
		event.keyCode=0; 
		alert("Only Number Allowed Here");
		
		return false;   
	} 		
}


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
	
	//For Selecting the user type
	if(document.getElementById("CATEGORY").nodeValue=="--Select Category--")
	{
		alert("Please Choose Category");
		document.getElementById("CATEGORY").focus();
		return false;
	}
	//For selecting the Name
	if(document.getElementById("NAME").value=="")
	{
		alert("Name Missing");
		document.getElementById("NAME").focus();
		return false;
	}
	
	// For selecting the Address
	if(document.getElementById("ADDRESS").value=="")
	{
		alert("Address Missing");
		document.getElementById("ADDRESS").focus();
		return false;
	}
	
	if(document.getElementById("CITY").value=="")
	{
		alert("City Missing");
		document.getElementById("CITY").focus();
		return false;
	}
	
	if(document.getElementById("STATE").value=="")
	{
		alert("State Missing");
		document.getElementById("STATE").focus();
		return false;
	}
	
	if(document.getElementById("EMAIL").value=="")
	{
		alert("Email Missing");
		document.getElementById("EMAIL").focus();
		return false;
	}
	
	if(document.getElementById("MOBILE").value=="")
	{
		alert("MOBILE Missing");
		document.getElementById("MOBILE").focus();
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
        <h4><s:actionmessage/></h4>
          <h2><span>User Registration</span></h2>
        </div>
        <div class="article">
          <s:form method="post" theme="simple">
          <ol>
          <li>
          	<label for="category">Category (required)</label>
            <s:select id="CATEGORY" name="CATEGORY" cssStyle="border:solid 1px grey; width:488px;" theme="simple" list="#{'E':'Employer','J':'Job Seekers'}" headerKey="0" required="true" headerValue="--Select Category--"></s:select>
          </li>
          <li>
            <label for="name">Name (required)</label>
            <s:textfield id="NAME" name="NAME" maxlength="40" required="true" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="address">Address (required)</label>
            <s:textarea id="ADDRESS" name="ADDRESS"  rows="4"  required="true" cols="50"  theme="simple"></s:textarea>
          </li>
          <li>
            <label for="city">City (required)</label>
            <s:textfield id="CITY" name="CITY" cssClass="text" required="true" maxlength="40" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="state">State (required)</label>
            <s:textfield id="STATE" name="STATE" cssClass="text" required="true" maxlength="40" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="email">Email Address (required)</label>
            <s:textfield id="EMAIL" name="EMAIL" cssClass="text" required="true" maxlength="50" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="mobile">Mobile (required)</label>
            <s:textfield id="MOBILE" name="MOBILE" cssClass="text" required="true" maxlength="10" theme="simple" onkeypress="return allowedNumber();"></s:textfield>
          </li>
          <li>
            <s:submit name="action" id="action" cssClass="send" theme="simple" value="Save"  cssStyle="border:solid 1px grey;" onclick="return validateMandatory();"/>
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
