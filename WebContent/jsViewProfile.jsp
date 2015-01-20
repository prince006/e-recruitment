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
          <h2><span>User Profile</span></h2><hr/>
            <a href="jsviewProfile.action">View Profile</a> | <a href="jseditProfile.action?action=edit">Edit Profile</a><hr/>
          <s:form method="post" theme="simple">
          <table align="left" cellpadding="3" cellspacing="4">
	          <tr valign="top" align="left">
	          <th> <label for="name">Name </label>
			</th>
	          	<td><s:property value="NAME" /></td>
	          </tr>
	           <tr valign="top" align="left">
	          <th><label for="address">Address </label>
            </th>
	          	<td><s:property value="ADDRESS" /></td>
	          </tr>
	           <tr valign="top" align="left">
	          <th> <label for="city">City</label>
           </th>
	          	<td> <s:property value="CITY" /></td>
	          </tr>
	           <tr valign="top" align="left">
	          <th><label for="state">State </label>
           </th>
	          	<td> <s:property value="STATE" /></td>
	          </tr>
	           <tr valign="top" align="left">
	          <th><label for="email">Email Address </label>
			</th>
	          	<td><s:property value="EMAIL" /></td>
	          </tr>
	           <tr valign="top" align="left">
	          <th><label for="mobile">Mobile </label>
           </th>
	          	<td> <s:property value="MOBILE" /></td>
	          </tr>
	           <tr valign="top" align="left">
	          <th><div class="clr"></div></th>
	          	
	          </tr>
          </table>
          
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
