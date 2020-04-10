<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.net.URLEncoder"%>
<!-- BEGIN HEADER -->
<div class="header navbar navbar-fixed-top">
	<!-- BEGIN TOP NAVIGATION BAR -->
	<div class="header-inner">
		<!-- BEGIN LOGO -->
		<a class="navbar-brand" href="#" id="en_scope_logo_pic"
			<%-- href="${pageContext.request.contextPath}/rest/micro/locationMap" --%>
			style="padding: 7px; font-size: 29px; font-weight: 600; color: white;">
			<img style="max-width:100%; margin: 0px;" src="${pageContext.request.contextPath}/public/images/logos.png"> </a>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse"> <img
			src="${pageContext.request.contextPath}/public/assets/img/menu-toggler.png" alt="" />
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<ul class="nav navbar-nav pull-right">
			<!-- BEGIN NOTIFICATION DROPDOWN -->

			<!-- END NOTIFICATION DROPDOWN -->
			<!-- BEGIN INBOX DROPDOWN -->

			<!-- END INBOX DROPDOWN -->
			<!-- BEGIN TODO DROPDOWN -->
			<!-- END TODO DROPDOWN -->
			<!-- BEGIN USER LOGIN DROPDOWN -->
			<li class="dropdown user"><a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"
				data-close-others="true"> 
			
				<img alt="" id="login_user_pic" style="height:25px;width:25px;" src="${pageContext.request.contextPath}/public/images/user.png" />
				
				<span class="username" id="user_name" style="padding-left: 10px;">
					
				</span> 
				<i class="fa fa-angle-down"></i>
			</a>
				<ul class="dropdown-menu">
					<li><a
						href="${pageContext.request.contextPath}/rest/users/profile">
							<i class="fa fa-user"></i> My Profile
					</a></li>
					<li id="roleManagement"><a
						href="${pageContext.request.contextPath}/rest/role/index"> <i
							class="fa fa-calendar"></i> Role Management
					</a></li>
					<li id="userManagement"><a
						href="${pageContext.request.contextPath}/rest/users/index"> <i
							class="fa fa-calendar"></i> User Management
					</a></li>
					<li class="divider"></li>
					<li><a href="javascript:;" id="trigger_fullscreen"> <i
							class="fa fa-arrows"></i> Full Screen
					</a></li>
					<li><a href="#" id="logout_btn"> <i class="fa fa-key"></i>
							Log Out
					</a></li>
				</ul></li>
			<!-- END USER LOGIN DROPDOWN -->
		</ul>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->

