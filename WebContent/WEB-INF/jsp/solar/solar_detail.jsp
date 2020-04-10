<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<style>
.white_box{
	background:white;
	border:1px solid;
	min-height:460px;
}
</style>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
	<div class="clearfix"></div>
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
						<ul class="page-breadcrumb breadcrumb" style="margin-bottom:15px !important;">
							<li><i class="fa fa-home"></i> <a
								href="${pageContext.request.contextPath}/rest/micro/list">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#" id="dashBoard"> Dashboard </a><i class="fa fa-angle-right"></i></li>
							<li>Solar Details</li>
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
				<div class="col-md-12" style="padding:0px;">
					<input type="hidden" value=${id} id="microgrid_id">
					<div class="col-md-3 white_box" style="padding:0px;">
						<img class="thumbnail" style="height:200px;width:100%;" src="${pageContext.request.contextPath}/public/images/noimage.png" id="solar_img">					
						<div class="col-md-12">
							<p id="solar_data">
								
							</p>										
						</div>
					</div>
					<div class="col-md-9" style="padding-right:0px;">
						<div class="col-md-12 white_box">
							<div class="col-md-12">
								<div class="col-md-6">
								<h4>Solar Power(kW)</h4>
								</div>
								<div class="col-md-6" style="padding-top:10px;">
									<jsp:include page="../components/date_filter_search.jsp"></jsp:include>
								</div>
							</div>
							<div id="week_data" class="col-md-12 text-center">
								
							</div>		
							<div class="col-md-12">
								<jsp:include page="../components/solar_column_chart.jsp">
									<jsp:param value="solar_column_chart" name="id"/>
								</jsp:include>
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
	<script src="${pageContext.request.contextPath}/public/javascripts/valid_microgrid.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			Index.init();
			ComponentsKnobDials.init();

			$("#dashBoard").click(function() {
				var microgrid_id = $.cookie("microgrid_id"); 
				window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"+microgrid_id;
			});
			showSolarData();
			
		});
		
		function showSolarData(){
//			var microgrid_id = $.cookie("microgrid_id");
			var microgrid_id = getMicroGridIdFromUrl();
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/solar/findbymicrogrid_id/"+microgrid_id,
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response, textStatus, jqXHR) {					 
					 if(response.data){
						 var solar = response.data;
						 if(solar['solar_pic']){
							 $("#solar_img").prop("src","https://drive.google.com/uc?export=view&id="+solar['solar_pic']);
						 }else{
							 $("#solar_img").prop("src","${pageContext.request.contextPath}/public/images/noimage.png"); 
						 } 
						 $("#solar_data").html(solar['solar_panel_description']);
						 						 
					 }
				},
				// callback handler that will be called on error
				error : function(jqXHR, textStatus, errorThrown) {

				}
			});
		}
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>