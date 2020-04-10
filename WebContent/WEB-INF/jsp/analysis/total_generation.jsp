<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
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
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a
								href="${pageContext.request.contextPath}/rest/micro/list">
									Home </a> <i class="fa fa-angle-right"></i></li>							
							<li>Energy Usage</li>
							<li class="pull-right">
								<li class="btn-group">
									<jsp:include page="../components/back_btn.jsp"></jsp:include>
								</li>
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
								<div class="caption font-sm">Total Energy Usage</div>
								<div class="tools"></div>
							</div>
							<div class="portlet-body">
								<%-- <div class="row">
									<div class="col-md-3">
										<jsp:include page="../components/select_microgrid_id_list.jsp"></jsp:include>
									</div>
									<div class="col-md-3">
										<input type="text" id="port_cfg" class="form-control" placeholder="Port Cfg">
									</div>
									<div class="col-md-3">
										<div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
											<input type="text" class="form-control" id="event_date">
											
											<span class="input-group-btn">
												<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
											</span>
										</div>											
									</div>
									<div class="col-md-3">
										<button type="button" id="filter" class="btn btn-primary">Search</button>
									</div>
								</div> --%>
								<div style="height:10px;clear:both;"></div>
								<table id="example"
										class="display table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Micro Grid Controller (ID - Name)</th>
												<th>Solar Generation (kWh)</th>
												<th>Grid Consumption (kWh)</th>
											</tr>
										</thead>
									</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- END CONTAINER -->
	<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>

	<script>
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			Index.init();
			ComponentsPickers.init();
			//getMicrogridList();
			
			setTable();

			$("#dashBoard").click(function() {
				var microgrid_id = $.cookie("microgrid_id");
				window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"+ microgrid_id;
			});
			
		});
		function addZero(i) {
		    if (i < 10) {
		        i = "0" + i;
		    }
		    return i;
		}
		$("#filter").click(function(){
			setTable();
		});
		
		function setTable() {
			$("#example").dataTable({
				"serverSide": false,
				"paging": true,
				"searching": true,
				"bInfo": false,
				"bDestroy": true,
				"ajax": "${pageContext.request.contextPath}/rest/analysis/gettotalusage",
				"columns": [
				            {
				            	"data": "microgrid_name"
				            },
				            {
				            	"data": "latitude"	
				            },
				            {
				            	"data": "longitude"
				            }],
				
			});
		}
		
	</script>
</body>
</html>