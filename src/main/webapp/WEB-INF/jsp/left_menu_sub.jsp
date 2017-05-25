<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="sidebar" class="col-md-3 no-float nav-parent well sidebar-nav" style="width:22%"
	id="section1" style="margin-top: 2%">

	<ul class="nav nav-pills nav-stacked">
		<li class="active"><a href="/referral?pageid=1"><spring:message
					code="menu_myreferral" /></a></li>
		<li><a href="/referral?pageid=2" title="Title"><spring:message
					code="menu_rental" /></a></li>
		<li><a href="/referral?pageid=3" title="Title"><spring:message
					code="menu_sale" /></a></li>
		<li><a href="/referral?pageid=4" title="Title"><spring:message
					code="menu_matrimony" /></a></li>
	</ul>


	<ul class="nav nav-pills nav-stacked">
		<li class="active"><a href="/viewContacts?pageid=1"><spring:message
					code="menu_contacts" /></a></li>
		<li><a href="/viewContacts?pageid=1" title="Title"><spring:message
					code="menu_outbound" /></a></li>
		<li><a href="/viewContacts?pageid=1" title="Title"><spring:message
					code="menu_inbound" /></a></li>

	</ul>

	<ul class="nav nav-pills nav-stacked">
		<li class="active"><a href="#"><spring:message
					code="menu_profile" /></a></li>


	</ul>
</div>