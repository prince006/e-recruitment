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
<div class="main"><jsp:include page="header.jsp" />

<div class="content">
<div class="content_resize">
<div class="mainbar">
<div class="article">
<h2><span>Search Questions</span></h2><hr/>
<a href="createQuest.action">Create</a> | <a href="searchQuest.action">Search</a>
| <a href="allQuest.action">List</a> 
 <hr/><s:form method="post" theme="simple">
	<ol>
		<li><label for="Question">Question (required)</label> <s:textfield
			id="qus" name="qus" cssClass="text" theme="simple"></s:textfield></li>
		<li><label for="Ansa">Ans - A (required)</label> <s:textfield
			id="ansa" name="ansa" cssClass="text" theme="simple"></s:textfield></li>
		<li><label for="Ansb">Ans - B (required)</label> <s:textfield
			id="ansb" name="ansb" cssClass="text" theme="simple"></s:textfield></li>
		<li><label for="Ansc">Ans - C (required)</label> <s:textfield
			id="ansc" name="ansc" cssClass="text" theme="simple"></s:textfield></li>
		<li><label for="Ansd">Ans - D (required)</label> <s:textfield
			id="ansd" name="ansd" cssClass="text" theme="simple"></s:textfield></li>
	    <li><label for="CorrectAns">Correct Ans (required)</label>
		    <s:select id="correctans" name="correctans" cssStyle="border:solid 1px grey; width:488px;" theme="simple" list="#{'a':'A','b':'B','c':'C','d':'D'}" headerKey="0" headerValue="--Select Answer--"></s:select>		
		</li>
		<s:submit name="action" id="action" cssClass="send"	theme="simple" value="Search" cssStyle="border:solid 1px grey;" />		
		<div class="clr">
		</div>		
	</ol>
</s:form>
<s:actionerror/>
</div>
</div>
<div class="clr"></div>
</div>
</div>

<jsp:include page="footer.jsp" /></div>
</body>
</html>
