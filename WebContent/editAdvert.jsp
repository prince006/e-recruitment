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
          <h2><span>Edit Advertisement</span></h2><hr/>
         <a href="createAdvert.action">Create</a> | <a href="searchAdvert.action">Search</a> | <a href="allAdvert.action">List</a>
          <hr/><s:form method="post" theme="simple">
          <ol>
          <li>
            <label for="userid">Advert ID</label>
            <s:textfield id="ID" name="ID" cssClass="text" theme="simple" readonly="true" ></s:textfield>
          </li>
          <li>
          	<label for="category">Subject(required)</label>
            <s:textfield id="SUBJECT" name="SUBJECT" theme="simple" ></s:textfield>
          </li>
           <li>
            <label for="description">Description (required)</label>
            <s:textarea id="DESC" name="DESC" rows="4" cols="50" theme="simple"></s:textarea>
          </li>
          <li>
          	<label for="status">Status (required)</label>
            <s:select id="IS_ACTIVE" name="IS_ACTIVE" cssStyle="border:solid 1px grey; width:488px;" theme="simple" list="#{'Y':'Active','N':'Inactive','X':'Delete'}" headerKey="0" headerValue="--Select Status--"></s:select>
          </li>         
          <li>
            <s:submit name="action" id="action" cssClass="send" theme="simple" value="Save" cssStyle="border:solid 1px grey;"/>
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
