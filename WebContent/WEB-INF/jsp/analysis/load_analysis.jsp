<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/public/javascripts/valid_microgrid.js"></script>
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
							<li><a href="#" id="dashBoard"> Dashboard </a><i class="fa fa-angle-right"></i></li>
							<li>Load Details</li>
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
									<div class="caption font-sm">Load Source</div>
									<div class="tools">
										
									</div>
								</div>
								<div class="portlet-body" id="load-body" style="padding: 0px;">
									<jsp:include page="../components/load_detail_chart.jsp"></jsp:include>																	
								</div>
							</div>
						</div>
					</div>
				</div>				
			</div>
		</div>
	<!-- END CONTAINER -->
	
<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>

<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   Index.init();
   $("#dashBoard").click(function() {
		var microgrid_id = $.cookie("microgrid_id"); 
		window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"+microgrid_id;
	});
});
var height = $(window).height();
$('#load-body').css('height',height-220);	 
$("#load_detail_chart").css('height',height-220);
$( window ).resize(function() {
    var height = $(window).height();
    $('#load-body').css('height',height-220);	 
    $("#load_detail_chart").css('height',height-220);
})	
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>