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
								href="${pageContext.request.contextPath}/rest/micro/list">Home</a>
								<i class="fa fa-angle-right"></i></li>
							<li>Error Details List</li>
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
								<div class="caption font-sm">Error Details List</div>
								<div class="tools"></div>
							</div>
							<div class="portlet-body">
								<div class="row">
									<div class="col-md-4">
										<div class="input-group date date-picker"
											data-date-format="yyyy-mm-dd">
											<input type="text" class="form-control" id="event_date">

											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-calendar"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-4">
										<button type="button" id="filter" class="btn btn-primary">Search</button>
									</div>
								</div>
								<div style="height: 10px; clear: both;"></div>
								<table id="example"
									class="display table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>ERROR CODE</th>
											<th>EVENT DATE TIME</th>
											<th>INIT BY</th>
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
		jQuery(document)
				.ready(
						function() {
							App.init(); // initlayout and core plugins
							Index.init();
							ComponentsPickers.init();
							
							doExperimentWithMoment();

							$("#dashBoard")
									.click(
											function() {
												var microgrid_id = $
														.cookie("microgrid_id");
												window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"
														+ microgrid_id;
											});

						});
		
		function doExperimentWithMoment(){
			var ddd = moment.tz(1481592251000,'Asia/Kolkata').format('YYYY-MM-DD HH:mm:ss');
			var date = new Date(ddd);			
		}
		
		function addZero(i) {
			if (i < 10) {
				i = "0" + i;
			}
			return i;
		}
		$("#filter").click(function() {
			setTable();
		});
		function setTable() {
			var event_date = $("#event_date").val();

			$('#example')
					.dataTable(
							{
								"serverSide" : true,
								"paging" : false,
								"searching" : false,
								"bInfo" : false,
								"bDestroy" : true,
								"ajax" : "${pageContext.request.contextPath}/rest/analysis/geterrorlist?event_date="
										+ event_date,
								"columns" : [
										{
											"data" : "error_code"
										},
										{
											"data" : null,
											"render" : function(data, type, row) {
												var event_time = new Date(
														row.event_time);
												var data = event_time
														.getFullYear()
														+ " - "
														+ addZero(event_time
																.getMonth() + 1)
														+ " - "
														+ addZero(event_time
																.getDate())
														+ " "
														+ addZero(event_time
																.getHours())
														+ ":"
														+ addZero(event_time
																.getMinutes())
														+ ":"
														+ addZero(event_time
																.getSeconds());
												return data;
											},
										}, {
											"data" : "init_by"
										} ]

							});
		}
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>