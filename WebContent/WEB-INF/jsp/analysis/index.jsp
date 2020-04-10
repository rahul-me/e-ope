<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>

<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<jsp:include page="../bootstrapheader/leftmenu.jsp"></jsp:include>
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<!-- BEGIN PAGE HEADER-->
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a
								href="${pageContext.request.contextPath}/rest/micro/list">
									Home </a> <i class="fa fa-angle-right"></i></li>
							
							<li>Energy Details</li>
							<li class="pull-right">
							<li class="btn-group"><jsp:include
									page="../components/back_btn.jsp"></jsp:include></li>
							</li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>				
					<div class="row">
						<div class="col-md-12">
							<div class="portlet box blue customPanel">
								<div class="portlet-title customPanel-title">
									<div class="caption font-sm">Energy Source</div>
									<div class="tools">
										
									</div>
								</div>
								<div class="portlet-body" id="energy-body" style="padding: 0px;">
									<div id="energy_source_id">
										<jsp:include page="../components/basic_column.jsp"></jsp:include>
										<div class="container">
											<p class="text-center">
												<span style="font-size:20px;color:blue">&#9632;</span> Load
												<span style="font-size:20px;color:#800080">&#9632;</span> Grid
												<span style="font-size:20px;color:red">&#9632;</span> Solar												
												
											</p>
										</div>
										<div class="container">
											<p>
												<u><b>Source of Power Analysis</b></u>
												<br>Solar and Battery used during
												<br>utility peak to reduce cost
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>				
			</div>
		</div>
	</div>

	<!-- END CONTAINER -->
	
<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
<%-- <script src="${pageContext.request.contextPath}/public/javascripts/valid_microgrid.js"></script> --%>

<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   Index.init();
   $("#dashBoard").click(function() {
		var microgrid_id = $.cookie("microgrid_id"); 
		window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"+microgrid_id;
	});
});

</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>