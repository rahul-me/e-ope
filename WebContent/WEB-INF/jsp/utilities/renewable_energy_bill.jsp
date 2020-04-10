<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
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
							<li>Renewable Energy Bill</li>
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
						<div class="portlet box grey">
							<div class="portlet-title">
								<div class="caption">Select Micro Grid Controller</div>
								<div class="tools">
									<a href="" class="collapse"></a>
								</div>
							</div>
							<div class="portlet-body">
								<div class="table-toolbar">
									<div class="col-md-12" style="padding: 0px;">
										<div class="col-md-4">
											<%-- <jsp:include page="utility_account_no_list.jsp"></jsp:include> --%>
											<select name="mgc_list" id="mgc_list" class="form-control"></select>
										</div>
										<div class="col-md-2">
											<div class="input-group date date-picker"
												data-date-format="yyyy-mm-dd">
												<input type="text" class="form-control" id="start_date">

												<span class="input-group-btn">
													<button class="btn default" type="button">
														<i class="fa fa-calendar"></i>
													</button>
												</span>
											</div>
										</div>
										<div class="col-md-1">
											<label class="form-control">To</label>
										</div>
										<div class="col-md-2">
											<div class="input-group date date-picker"
												data-date-format="yyyy-mm-dd">
												<input type="text" class="form-control" id="end_date">

												<span class="input-group-btn">
													<button class="btn default" type="button">
														<i class="fa fa-calendar"></i>
													</button>
												</span>
											</div>
										</div>
										<div class="col-md-2">
									<button type="button" class="btn btn-primary" title="Download usage data between specified dates" id="downLoadDataBtn">Download Usage Data</button>
								</div>
									</div>
								</div>
								<div style="height: 10px; clear: both;"></div>
							</div>
						</div>
					</div>
				</div>
				<!--  Temp lines -->

				<!--  Temp Lines-->
				<div class="clearfix"></div>

				<!-- Addition of boxes to show bill details of last three months -->
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-8 col-xs-16">
						<div class="dashboard-stat blue">
							<div class="visual">
								<i class="fa fa-sun-o"></i>
							</div>
							<div class="details">
								<div class="number" id="cost0">0.00 $</div>
								<div class="desc" id="en_usage0">0.0000kWh</div>
							</div>
							<a class="more" href="#" id="month0">  <i
								class="m-icon-swapright m-icon-white"></i>
							</a>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-8 col-xs-16">
						<div class="dashboard-stat green">
							<div class="visual">
								<i class="fa fa-sun-o"></i>
							</div>
							<div class="details">
								<div class="number" id="cost1">0.00 $</div>
								<div class="desc" id="en_usage1">0.0000kWh</div>
							</div>
							<a class="more" href="#" id="month1"> <i
								class="m-icon-swapright m-icon-white"></i>
							</a>
						</div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-8 col-xs-16">
						<div class="dashboard-stat yellow">
							<div class="visual">
								<i class="fa fa-sun-o"></i>
							</div>
							<div class="details">
								<div class="number" id="cost2">0.00$</div>
								<div class="desc" id="en_usage2">0.0000kWh</div>
							</div>
							<a class="more" href="#" id="month2"> View more <i
								class="m-icon-swapright m-icon-white"></i>
							</a>
						</div>
					</div>
				</div>

				<div class="clearfix"></div>
				<!-- <div class="row">
					<div class="col-md-12">
						<div class="portlet box grey">
							<div class="portlet-title">
								<div class="caption">Energy Cost for last three months</div>
							</div>
							<div class="portlet-body">
								<div class="table-toolbar">
							<div class="btn-group">
								<button id="addNewBattery" class="btn green">
									Add New <i class="fa fa-plus"></i>
								</button>										
							</div>							
						</div>
								<table id="example"
									class="display table table-striped table-bordered table-hover"
									cellspacing="0" width="100%">
									<thead>
										<tr>
											<th>Month</th>
											<th>Generation (kWh)</th>
											<th>Cost</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div> -->

				<div class="clearfix"></div>

				<div class="row">
					<div class="col-md-12">
						<div class="portlet box grey">
							<div class="portlet-title">
								<div class="caption">Renewable Energy Generation Cost</div>
							</div>
							<div class="portlet-body">
								<div class="table-toolbar">
									<div class="col-md-12">
										<select class="pull-right" id="month_selector"></select>
									</div>
									<div class="col-md-12 text-center">
										<p>
										<h4>
											<i id="year_selector_left"
												style='cursor: pointer; color: #B3B3B3;'
												class='glyphicon glyphicon-chevron-left'></i><label><h4
													id="year_selector" style="padding-left: 5px;"></h4></label> <i
												id="year_selector_right"
												style='cursor: pointer; color: #B3B3B3;'
												class='glyphicon glyphicon-chevron-right'></i>
										</h4>
										</p>
									</div>

								</div>
								<jsp:include page="renewable_energy_bill_chart.jsp"></jsp:include>
								<div style="height: 75px; clear: both;"></div>
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
		jQuery(document)
				.ready(
						function() {
							App.init(); // initlayout and core plugins
							Index.init();
							ComponentsPickers.init();
							populateMonthSelector();
							populateYear();
							populateMGClist();
							//showChart("meth");
							//getMicrogridList();

							//setTable();

							$("#dashBoard")
									.click(
											function() {
												var microgrid_id = $
														.cookie("microgrid_id");
												window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"
														+ microgrid_id;
											});
							
							$('#start_date').val('');
							$('#end_date').val('')
						});
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

			var mgc_id = $('#mgc_list').val();
			$("#example")
					.dataTable(
							{
								"columnDefs" : [ {
									"width" : "30%",
									"targets" : 0
								}, {
									"width" : "35%",
									"targets" : 1
								}, {
									"width" : "35%",
									"targets" : 2
								} ],
								"order" : [],
								"serverSide" : false,
								"paging" : false,
								"searching" : false,
								"bInfo" : false,
								"bDestroy" : true,
								"ajax" : "${pageContext.request.contextPath}/rest/micro/reGenDataForPastThreeMonths?mgc_id="
										+ mgc_id
							});
		}

		function populateMGClist() {
			$
					.ajax({
						url : '${pageContext.request.contextPath}/rest/micro/userBasedMgcList',
						type : 'GET',
						success : function(response) {
							//console.log(response.status);
							var records_avail = true;
							if (response.status) {
								if (response.data) {
									if (response.data.length > 0) {
										$
												.each(
														response.data,
														function(index, value) {
															//console.log(value["microgrid_id"]);
															$('#mgc_list')
																	.append(
																			$(
																					"<option></option>")
																					.text(
																							value["microgrid_id"]
																									+ ":"
																									+ value["microgrid_name"])
																					.val(
																							value["microgrid_id"]));
														});
									} else {
										records_avail = false;
									}
								} else {
									records_avail = false;
								}
							} else {
								records_avail = false;
							}
							if (records_avail == false) {
								$('#mgc_list')
										.append(
												$("<option></option>")
														.text(
																"Micro Grid Controller is not available")
														.val("no_data"));
							}
							//populateBillData();
							if ($('#mgc_list').val() == 'no_data') {
								toastr["warning"]
										("Can't Proceed due to lack of data");
								return;
							}
							populateBillDataAndShowItInBoxes();
							//$('#mgc_list').select2();
							generateREGenerationCostVsUsage();
						}
					});
		}

		$('#populateBillDataBtn').on('click', function() {
			if ($('#mgc_list').val() == 'no_data') {
				toastr["warning"]("Can't Proceed due to lack of data");
				return;
			}
			//populateBillData();

		});

		function populateBillData() {
			setTable();
		}

		$('#mgc_list').on('change', function() {
			$('#example').dataTable().fnDestroy();
			//populateBillData();
			if ($('#mgc_list').val() == 'no_data') {
				toastr["warning"]("Can't Proceed due to lack of data");
				return;
			}
			populateBillDataAndShowItInBoxes();
		});

		function populateMonthSelector() {
			var months = [ "January", "February", "March", "April", "May",
					"June", "July", "August", "September", "October",
					"November", "December" ];
			$.each(months,
					function(index, value) {
						$('#month_selector').append(
								$('<option></option').text(value).val(
										eval(index + 1)));
					});
			$('#month_selector').val(eval(new Date().getMonth() + 1));
			return true;
		}

		function populateYear() {
			$('#year_selector').html(new Date().getFullYear());
			return true;
		}

		$('#year_selector_left').on('click', function() {
			//alert('getit');
			if ($('#mgc_list').val() == 'no_data') {
				toastr["warning"]("Can't Proceed due to lack of data");
				return;
			}
			var year = $('#year_selector').html();
			$('#year_selector').html(eval(eval(year) - 1));
			generateREGenerationCostVsUsage();
		});
		$('#year_selector_right').on('click', function() {
			if ($('#mgc_list').val() == 'no_data') {
				toastr["warning"]("Can't Proceed due to lack of data");
				return;
			}
			var year = $('#year_selector').html();
			$('#year_selector').html(eval(eval(year) + 1));
			generateREGenerationCostVsUsage();
		});

		$('#month_selector').on('change', function() {
			if ($('#mgc_list').val() == 'no_data') {
				toastr["warning"]("Can't Proceed due to lack of data");
				return;
			}
			var monthNumber = $('#month_selector').val();
			console.log(monthNumber);
			generateREGenerationCostVsUsage();
		});

		function generateREGenerationCostVsUsage() {
			var mgc_id = $('#mgc_list').val();
			var port_cfg = 'solar';
			var yearVal = $('#year_selector').html();
			var monthNumber = $('#month_selector').val();
			showREGenerationUsageVsCost(mgc_id, port_cfg, yearVal, monthNumber);
		}

		//display bill data of last three months in form of boxes

		function populateBillDataAndShowItInBoxes() {

			$
					.ajax({
						url : '${pageContext.request.contextPath}/rest/micro/reGenDataForPastThreeMonths?mgc_id='
								+ $('#mgc_list').val(),
						type : 'GET',
						success : function(response) {
							console.log(response);
							$.each(response.data, function(index, value) {
								console.log(value);
								console.log(index);
								$('#cost' + index).html(value[2]);
								$('#month' + index).html(
										'<h5>' + value[0] + '</h5>');
								$('#en_usage' + index).html(value[1] + " kWh");
							});
						}
					});
		}
		
		$('#downLoadDataBtn').on('click', function(){
			if ($('#mgc_list').val() == 'no_data') {
				toastr["warning"]("Can't Proceed due to lack of data");
				return;
			}
			
			//console.log($('#start_date').val());
			//console.log($('#end_date').val());
			
			if($('#start_date').val().length == 0 || $('#end_date').val().length == 0){
				toastr["warning"]("Fill the date limits on the left");
				return;
			}
			
			var startDate = $('#start_date').val();
			var endDate = $('#end_date').val();
				
			var mgc_id = $('#mgc_list').val();	
			
			/* $.ajax({
				url : "${pageContext.request.contextPath}/rest/micro/downLoadUsageData?mgc_id="+mgc_id+"&start_date="+start_date+"&end_date",
				type : "get"							
		    }); */
			
			window.location.href = "${pageContext.request.contextPath}/rest/micro/downLoadUsageData?mgc_id="+mgc_id+"&start_date="+startDate+"&end_date="+endDate
			
			
		});
	</script>
</body>
</html>