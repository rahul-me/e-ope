<!-- BEGIN SIDEBAR -->
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.gridscape.service.UserService"%>
<%@page import="com.gridscape.model.User"%>
<div class="page-sidebar-wrapper">
	<div class="page-sidebar navbar-collapse collapse">
		<!-- add "navbar-no-scroll" class to disable the scrolling of the sidebar menu -->
		<!-- BEGIN SIDEBAR MENU -->
		<ul class="page-sidebar-menu" data-auto-scroll="true"
			data-slide-speed="200">
			<li class="sidebar-toggler-wrapper">
				<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				<div class="sidebar-toggler hidden-phone" style="margin: 4px;">
				</div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
			</li>

			<li class="start active_menu home seponly" style="display: none">
				<a href="javascript:void(0);" class="open_dashboards" id="dashboard">
					<i class="fa fa-tachometer"></i> <span class="title">
						Dashboard </span>
			</a>
			</li>

			<li class="active_menu utility seponly" style="display: none"><a
				href="javascript:;"> <i class="fa fa-bolt"></i> <span
					class="title"> Utility </span> <span class="arrow"> </span>
			</a>
				<ul class="sub-menu">
					<li class="tooltips li_custom_menu" data-user-role="super-admin"
						data-container="body" data-placement="right" data-html="true"
						data-original-title=""><a
						href="${pageContext.request.contextPath}/rest/utility/provider">
							<span class="title"> Utility Provider </span>
					</a></li>
					<li class="tooltips" data-container="body" data-placement="right"
						data-html="true" data-original-title=""><a
						href="${pageContext.request.contextPath}/rest/utility/index">
							<span class="title"> Utility Configuration </span>
					</a></li>					
					<li class="li_custom_menu" data-user-role="super-admin"><a
						href="${pageContext.request.contextPath}/rest/utility/bill"> <i
							class=""></i> Energy cost
					</a></li>					
					<li class="tooltips" data-container="body" data-placement="right"
						data-html="true" data-original-title=""><a
						href="${pageContext.request.contextPath}/rest/utility/renewable_energy_bill">
							<span class="title"> Renewable Energy Bill </span>
					</a></li>					
				</ul></li>
			<li class="active_menu micro seponly" style="display: none"><a
				href="javascript:void(0);"> <i class="fa fa-cog"></i> <span
					class="title"> Micro Grid </span> <span class="arrow"> </span>
			</a>
				<ul class="sub-menu">
					<li><a
						href="${pageContext.request.contextPath}/rest/micro/list">
							Configuration </a></li>
					<li data-user-role="super-admin" class="li_custom_menu"><a
						href="${pageContext.request.contextPath}/rest/micro/default_profile">
							<i class=""></i> Default Profile
					</a></li>
					<li class="hiper"><a
						href="${pageContext.request.contextPath}/rest/battery/index">
							<i class=""></i> Battery
					</a></li>
					<li class="hiper"><a
						href="${pageContext.request.contextPath}/rest/solar/index"> <i
							class=""></i> Solar
					</a></li>
					<li class="hiper"><a
						href="${pageContext.request.contextPath}/rest/solar/service">
							<i class=""></i> Solar Service
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/rest/micro/locationMap">
							<i class=""></i> Location Map
					</a></li>
				</ul></li>
			<li class="active_menu analysis seponly" style="display: none">
				<a href="javascript:;"> <i class="fa-list-alt"></i> <span
					class="title"> Analysis </span> <span class="arrow"> </span>
			</a>
				<ul class="sub-menu">
					<li class="tooltips hiper" data-container="body"
						data-placement="right" data-html="true" data-original-title="">
						<a
						href="${pageContext.request.contextPath}/rest/analysis/generation">
							<span class="title"> Energy Usage </span>
					</a>
					</li>
					<li class="tooltips hiper" data-container="body"
						data-placement="right" data-html="true" data-original-title="">
						<a
						href="${pageContext.request.contextPath}/rest/analysis/power_analysis">
							<span class="title"> Solar Power Analysis </span>
					</a>
					</li>
					<%-- <li class="tooltips" data-container="body" data-placement="right" data-html="true" data-original-title="">
							<a href="${pageContext.request.contextPath}/rest/analysis/index">
								<span class="title">
									Energy Source
								</span>
							</a>
						</li> --%>
					<li class="tooltips hiper" data-container="body"
						data-placement="right" data-html="true" data-original-title="">
						<a
						href="${pageContext.request.contextPath}/rest/analysis/energy_source_list">
							<span class="title"> Energy Source List </span>
					</a>
					</li>
					<li class="tooltips hiper" data-container="body"
						data-placement="right" data-html="true" data-original-title=""><a
						href="${pageContext.request.contextPath}/rest/analysis/message_error_list">
							<span class="title"> Message Error List </span>
					</a></li>

				</ul> <!-- END SIDEBAR MENU -->
			</li>

			<li class="active_menu devicee sep devices" style="display: none">
				<a href="javascript:;"> <i class="fa fa-cog"></i> <span
					class="title"> Devises </span> <span class="arrow"> </span>
			</a>
				<ul class="sub-menu">
					<li><a
						href="${pageContext.request.contextPath}/rest/sep/devices/index">
							Devise List </a></li>
				</ul>
			</li>
			<li class="active_menu devicee sep derprograms" style="display: none">
				<a href="javascript:;"> <i class="fa fa-cog"></i> <span
					class="title"> DERPrograms </span> <span class="arrow"> </span>
			</a>
				<ul class="sub-menu">
					<li><a
						href="${pageContext.request.contextPath}/rest/sep/derprograms/index">
							DERProgram List </a></li>
				</ul>
			</li>
			<li class="active_menu analysis" style="display: none"><a
				href="javascript:;"> <i class="fa fa-bars"></i> <span
					class="title">Report and Analysis</span> <span class="arrow"> </span>
			</a>
				<ul class="sub-menu">					
					<li class="li_custom_menu" data-user-role="super-admin"><a
						href="${pageContext.request.contextPath}/rest/utility/import">
							<i class=""></i> Import Interval Data
					</a></li>
					<li class="li_custom_menu" data-user-role="super-admin"><a
						href="${pageContext.request.contextPath}/rest/utility/utility_interval_data">
							<i class=""></i> Cost estimation
					</a></li>
					<li class="li_custom_menu" data-user-role="super-admin"><a
						href="${pageContext.request.contextPath}/rest/utility/foothill_college_analysis">
							<i class=""></i> Foothill College Analysis
					</a></li>						
				</ul></li>
		</ul>
		<!-- END SIDEBAR MENU -->
	</div>
</div>
<!-- END SIDEBAR -->

