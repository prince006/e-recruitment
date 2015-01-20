<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<script src="js/rightClick.js" type="text/javascript"></script>
<title>E Recruitment System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script>
   function show_msg(theForm) {
      var a= theForm.exam_time.value * 60000;
      setTimeout('document.frmExam.submit()',a);
   }  
</script>
<script language="JavaScript">
TargetDate = "${targetDate}";
BackColor = "white";
ForeColor = "navy";
CountActive = true;
CountStepper = -1;
LeadingZero = true;
DisplayFormat = "%%D%% Days, %%H%% Hours, %%M%% Minutes, %%S%% Seconds.";
FinishMessage = "Time's Up!";
</script>
<script language="JavaScript" src="js/countdown.js"></script>
</head>
<body onload="show_msg(frmExam)">
<div style="height: 1000px;width:1140px ;overflow: auto;" align="center">
<s:form name="frmExam" action="examResult">
<table width="100%">
<tr>
 <td><h3>Exam Id :<s:property value="exam_no"/></h3></td> <td align="center"><h3>Correct Answers required to Pass the Exam <s:property value="min_pass"/></h3></td><td align="right"><h3>Time : <s:property value="exam_time"/> Mins </h3></td>
<s:hidden id="exam_time" name="exam_time"/>
<s:hidden name="exam_no"/>
<s:hidden name="min_pass"/>
</tr>
</table>
	<table width="100%" cellpadding="1" cellspacing="5" border="0">
	<tr style="background-color: #00adeb; color: #FFFFFF;" align="left" valign="top">
		<th width="2px">#</th>
		<th >Question</th>
		<th >A</th>
		<th >B</th>
		<th >C</th>
		<th >D</th>
		<th >Choose Answer</th>
	</tr>
	
	
	<s:iterator value="model" status="rowStatus">
		<tr style="background-color: #F0F8FF; color: navy;" align="left" valign="top">
		    <th><s:property value="#rowStatus.count" /></th> 
		    <s:hidden name="model[%{#rowStatus.index}].qus_no"/>
			<th><s:property value="qus" /></th>
			<td><s:property value="ansa" /></td>
			<td><s:property value="ansb" /></td>
			<td><s:property value="ansc" /></td>
			<td><s:property value="ansd" /></td>
			<td><s:radio name="model[%{#rowStatus.index}].reponse" list="#{'A':'A','B':'B','C':'C','D':'D'}" value="A" theme="simple"/></td>
			<s:hidden name="model[%{#rowStatus.index}].correctans"/>		   		    
		</tr>			
	</s:iterator>	
</table>
<div align="center" style="border:1px solid black;background-color:#33A1C9">
<s:submit name="action" id="action" cssClass="send" theme="simple" value="Submit Exam" cssStyle="border:solid 1px grey;" align="center"/>
</div>
</s:form>
</div>
</body>
</html>