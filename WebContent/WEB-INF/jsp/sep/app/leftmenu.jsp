<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar navbar-collapse collapse">
			<!-- add "navbar-no-scroll" class to disable the scrolling of the sidebar menu -->
			<!-- BEGIN SIDEBAR MENU -->
			<ul class="page-sidebar-menu" data-auto-scroll="true" data-slide-speed="200">
				<li class="sidebar-toggler-wrapper">
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone" style="margin: 4px;">
					</div>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>								
				<li class="start active_menu home">
					<a  href="${pageContext.request.contextPath}/rest/sep/home/index" class="open_dashboards">
						<i class="fa fa-tachometer"></i>
						<span class="title">
							Dashboard
						</span>
					</a>					
				</li>								
				<li class="active_menu micro">
					<a href="javascript:void(0);">
						<i class="fa fa-cog"></i>
						<span class="title">
							Devises
						</span>
						<span class="arrow">
						</span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="${pageContext.request.contextPath}/rest/sep/devices/index">								
								Devise List
							</a>
						</li>						
					</ul>
				</li>				
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->