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
          <h2><span>Create Resume</span></h2><hr/>
              <s:if test='#session.resume=="notcreated"'><a href="createResume.action">Create</a> </s:if>
	          <s:else><a href="editResume.action">Edit Resume</a> | <a href="downloadResume.action">Download PDF Version</a></s:else>
         <hr/> <s:form method="post" theme="simple">
          <ol>
          <li>
          	<label for="category">Title *</label>
            <s:textfield id="title" name="title"  cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="name">First Name*</label>
            <s:textfield id="first_name" name="first_name" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="name">Last Name*</label>
            <s:textfield id="last_name" name="last_name" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
          	<label for="category">Gender *</label>
            <s:select id="gender" name="gender" cssStyle="border:solid 1px grey; width:488px;" theme="simple" list="#{'M':'Male','F':'Female'}" headerKey="0" headerValue="--Select Gender--"></s:select>
          </li>
            <li>
          	<label for="category">Married *</label>
            <s:select id="is_married" name="is_married" cssStyle="border:solid 1px grey; width:488px;" theme="simple" list="#{'Y':'Yes','N':'No'}" headerKey="0" headerValue="--Select Status--"></s:select>
          </li>
          <li>
            <label for="address">Current Address *</label>
            <s:textarea id="c_address" name="c_address" rows="4" cols="50" theme="simple"></s:textarea>
          </li>
          <li>
            <label for="address">Permanent Address *</label>
            <s:textarea id="p_address" name="p_address" rows="4" cols="50" theme="simple"></s:textarea>
          </li>     
          <li>
            <label for="email">Email Address *</label>
            <s:textfield id="email" name="email" cssClass="text" theme="simple"></s:textfield>
          </li>
          <li>
            <label for="mobile">Mobile *</label>
            <s:textfield id="mobile_no" name="mobile_no" cssClass="text" theme="simple"></s:textfield>
          </li>
          <h3>Qualifications Details</h3>
           <hr>
           <table width="100%">
			<tr style="background-color: #00adeb; color: #FFFFFF;">
				<th >Qualification</th>
				<th width>Board/University</th>
				<th width>Passing Year</th>
				<th width>Percentage</th>			
				<th width="60px">Grade</th>
			</tr>
			<s:iterator value="model" status="rowStatus">
				<tr style="background-color: #F0F8FF; color: navy;">
					<th><s:textfield name="model[%{#rowStatus.index}].qualification" cssClass="text" theme="simple"/></th>
					<td><s:textfield name="model[%{#rowStatus.index}].board_university" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="model[%{#rowStatus.index}].pass_year" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="model[%{#rowStatus.index}].percentage" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="model[%{#rowStatus.index}].grade" cssClass="text" theme="simple"/></td>
				</tr>
			</s:iterator>
		  </table>        
		  <h3>Experience Details</h3>
           <hr>
           <table width="100%">
			<tr style="background-color: #00adeb; color: #FFFFFF;">
				<th >Job Title</th>
				<th >Profile</th>
				<th >Responsibility</th>
				<th width="80px">Company</th>
				<th width="80px">Location</th>							
				<th width="60px">From(Year)</th>
				<th width="60px">To(Year)</th>
			</tr>			
			<tr style="background-color: #F0F8FF; color: navy;">
					<th><s:textfield name="job_title1" cssClass="text" theme="simple"/></th>
					<td><s:textfield name="job_profile1" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="job_responsibility1" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="company1" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="location1" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="from_date1" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="to_date1" cssClass="text" theme="simple"/></td>
			</tr>
			<tr style="background-color: #F0F8FF; color: navy;">
					<th><s:textfield name="job_title2"  cssClass="text" theme="simple"/></th>
					<td><s:textfield name="job_profile2" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="job_responsibility2" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="company2" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="location2" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="from_date2" cssClass="text" theme="simple"/></td>
					<td><s:textfield name="to_date2" cssClass="text" theme="simple"/></td>
			</tr>				
		  </table>
		  <li>
            <label > Skills*</label>
            <s:textarea rows="3" cols="15" id="skills" name="skills" theme="simple"/>
          </li>        
		  <li>
            <label >Experience(Years)*</label>
            <s:textfield id="exp" name="exp" theme="simple"/>
          </li>
           <li>
            <label >Remarks *</label>
            <s:textarea id="remarks" name="remarks" rows="4" cols="50" theme="simple"></s:textarea>
          </li>
          <li>
          	<label for="status">Status *</label>
            <s:select id="is_active" name="is_active" cssStyle="border:solid 1px grey; width:488px;" theme="simple" list="#{'Y':'Active','N':'Inactive','X':'Delete'}" headerKey="0" headerValue="--Select Status--"></s:select>
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
