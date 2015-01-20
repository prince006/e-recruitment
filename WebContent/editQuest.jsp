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
<h2><span>Edit Question</span></h2><hr/>
<a href="createQuest.action">Create</a> | <a href="searchQuest.action">Search</a>
| <a href="allQuest.action">List</a> <s:form method="post"
	theme="simple"><hr/>
	<ol>
		<li><label for="userid">Question ID</label> <s:textfield
			id="qus_no" name="qus_no" cssClass="text" theme="simple" readonly="true"></s:textfield>
		</li>
		<li><label for="Question">Question (required)</label> <s:textarea
			id="qus" name="qus" rows="6" cols="100" cssClass="text" theme="simple"/></li>
		<li><label for="Ansa">Ans - A (required)</label> <s:textarea
			id="ansa" name="ansa"   cssClass="text" theme="simple"/></li>
		<li><label for="Ansb">Ans - B (required)</label> <s:textarea
			id="ansb" name="ansb" rows="2" cols="100" cssClass="text" theme="simple"/></li>
		<li><label for="Ansc">Ans - C (required)</label> <s:textarea
			id="ansc" name="ansc" rows="2" cols="100" cssClass="text" theme="simple"/></li>
		<li><label for="Ansd">Ans - D (required)</label> <s:textarea
			id="ansd" name="ansd"  rows="2" cols="100" cssClass="text" theme="simple"/></li>
		<li><label for="CorrectAns">Correct Ans (required)</label> <s:textfield
			id="correctans" name="correctans"  cssClass="text" theme="simple"/></li>

		<li><label for="status">Status (required)</label> <s:select
			id="is_active" name="is_active"
			cssStyle="border:solid 1px grey; width:488px;" theme="simple"
			list="#{'Y':'Active','N':'Inactive','X':'Delete'}" headerKey="0"
			headerValue="--Select Status--"></s:select></li>
		<li><s:submit name="action" id="action" cssClass="send"
			theme="simple" value="Save" cssStyle="border:solid 1px grey;" />
		<div class="clr"></div>
		</li>
	</ol>
</s:form></div>
</div>
<div class="clr"></div>
</div>
</div>

<jsp:include page="footer.jsp" /></div>
</body>
</html>
