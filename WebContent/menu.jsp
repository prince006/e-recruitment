<%@taglib prefix="s2" uri="/struts-tags"%>

<ul>
	<s2:if test='#session.user.CATEGORY=="A"'>
		<li><a href="advert.action">Advertisement</a></li>
		<li><a href="quest.action">Question</a></li>
		<li><a href="profile.action">Profile</a></li>
		<li><a href="vacancy.action">Vacancy</a></li>
		<li><a href="contactUsList.action">See Messages</a></li>
		<li><a href="reset.action">Settings</a></li>
		<li><a href="logout.action">Logout</a></li>
	</s2:if>
	<s2:elseif test='#session.user.CATEGORY=="E"'>
		<li><a href="job.action">Vacancy</a></li>
		<li><a href="eresume.action">Resume</a></li>
		<li><a href="exam.action">Online Exam</a></li>
		<li><a href="jsprofile.action">Profile</a></li>
		<li><a href="reset.action">Settings</a></li>
		<li><a href="logout.action">Logout</a></li>
	</s2:elseif>
	<s2:elseif test='#session.user.CATEGORY=="J"'>
		<li><a href="job.action">Vacancy</a></li>
		<li><a href="resume.action">Resume</a></li>
		<li><a href="examJS.action">Online Exam</a></li>
		<li><a href="jsprofile.action">Profile</a></li>
		<li><a href="reset.action">Settings</a></li>
		<li><a href="logout.action">Logout</a></li>
	</s2:elseif>
	<s2:else>
		<li><a href="aboutERS.action">About ERS</a></li>
		<li><a href="aboutDeveloper.action">About Developer</a></li>
		<li><a href="login.action">Login</a></li>
		<li><a href="registerNow.action">Register Now</a></li>
		<li><a href="contactUs.action">Contact Us</a></li>
	</s2:else>
</ul>
