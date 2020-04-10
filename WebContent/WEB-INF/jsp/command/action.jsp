<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<style>
.tile .tile-object {
    position: absolute;
    bottom: 0;
    left: 24px;
    right: 0;
    min-height: 30px;
    background-color: transparent;
}	
</style>

<!-- END HEAD -->
<!-- BEGIN BODY -->
<style>
.span {
	color: black !important;
	font-weight: 600 !important;
}

.dashboard-stat.purple {
	background-color: #ffb848;
}

.dashboard-stat.blue {
	background-color: rgba(255, 87, 34, 0.86);
}

.tile .tile-object {
	position: absolute;
	bottom: 0;
	left: 29px;
	right: 0;
	min-height: 30px;
	background-color: transparent;
	*zoom: 1;
}
</style>
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
						<h3 class="page-title" id="title"></h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a
								href="${pageContext.request.contextPath}/rest/home/currentstatus/${id}">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a
								href="${pageContext.request.contextPath}/rest/home/currentstatus/${id}">
									Dashboard </a> <i class="fa fa-angle-right"></i></li>
							<li>Action</li>
							<li class="pull-right">>
							<li class="btn-group"><jsp:include
									page="../components/back_btn.jsp"></jsp:include>
								<button type="button" class="btn blue dropdown-toggle"
									data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
									data-close-others="true">
									<span> Actions </span> <i class="fa fa-angle-down"></i>
								</button>
								<ul class="dropdown-menu pull-right" role="menu">
									<li><a
										href="${pageContext.request.contextPath}/rest/command/history/${id}"
										> Command History </a></li>
									<li><a href="javascript:void(0);" id="testConnectionLink" show="false"> Test
											Connection </a></li>
								</ul></li>
							</li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<!-- <div class="row">
					<div class="col-md-12">
						<div class="portlet box grey">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-list-ul"></i>Command
								</div>
							</div>
							<div class="portlet-body">
								<div class="tiles" style="text-align:center;">
									<div class="col-sm-1"></div>
									<div class="col-sm-2">
										<div data-mode="islanding" class="tile bg-dark command" id="ilandingmode">
											<div class="tile-body">
												<i class="fa fa-play"  style="margin-top: 10px;"> </i>
											</div>
											<div class="tile-object">
												<center><div class="name">Islanding</div></center>
											</div>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="command tile bg-green" data-mode="chargebatteryfromgrid" id="gridmode">
											<div class="tile-body">
												<i class="fa fa-chain"  style="margin-top: 10px;"> </i>
											</div>
											<div class="tile-object">
												<div class="name">Charge Battery From Grid</div>
											</div>
										</div>
									</div>
									<div class="col-sm-2">
										<div data-mode="chargebatteryfromsolar" class="command tile bg-blue" id="btnReset">
											<div class="tile-body">
												<i class="fa fa-gear"  style="margin-top: 10px;"> </i>
											</div>
											<div class="tile-object">
												<div class="name">Charge Battery From Solar</div>
											</div>
										</div>
									</div>
									<div class="col-sm-2">
										<div data-mode="dischargebattery" class="command tile bg-yellow">
											<div class="tile-body">
												<i class="fa fa-flash"  style="margin-top: 10px;"> </i>
											</div>
											<div class="tile-object">
												<div class="name">Discharge Battery</div>
											</div>
										</div>
									</div>
									<div class="col-sm-2">
										<div data-mode="userstop" class="command tile bg-red">
											<div class="tile-body">
												<i class="fa fa-stop"  style="margin-top: 10px;"> </i>
											</div>
											<div class="tile-object">
												<center><div class="name">User Stop</div></center>
											</div>
										</div>	
									</div>
									<div class="col-sm-1"></div>																
								</div>
							</div>
						</div>
						
						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
						<button id="set_profile" class="btn btn-lg btn-warning command" style="width:100%">Set Profile</button>
					</div>
  						<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" >
						<button class="btn btn-lg btn-default command" style="width:100%" id="testConnection">Test Connection</button>
					</div>					</div>
					<div class="clearfix"></div>
					<div class="col-md-6 col-md-offset-3" style="padding-top: 10px;">
						<div class="panel panel-default">
					  <div class="panel-heading">Current State OF Electricity</div>
					  <div class="panel-body" style="padding:0px;"> 
					<ul class="list-group" style="margin-bottom: 0px;">
					    <li class="list-group-item">
					    <span class=" pull-right label span" id="grid_status" style="font-size:14px !important;"></span>
					    Grid State
					  </li>
					    <li class="list-group-item">
					    <span class=" pull-right label span" id="grid_state" style="font-size:14px !important;"></span>
					    Grid Status
					  </li>
					    <li class="list-group-item">
					    <span class=" pull-right label span" id="solar_out_source" style="font-size:14px !important;"></span>
					    Solar Source Out
					  </li>
					    <li class="list-group-item">
					    <span class=" pull-right label span" id="solar_state" style="font-size:14px !important;"></span>
					    Solar State
					  </li>
					  <li class="list-group-item">
					    <span class=" pull-right label span" id="battery_in_source" style="font-size:14px !important;"></span>
					  		Battery source In
					  </li>
					  <li class="list-group-item">
					    <span class=" pull-right label span" id="battery_out_source" style="font-size:14px !important;"></span>
					    Battery Source Out
					  </li>
					  <li class="list-group-item">
					    <span class=" pull-right label span" id="battery_state" style="font-size:14px !important;"></span>
					    Battery State
					  </li>
					</ul>
					  </div>
					</div>
					</div>
				</div> -->
				<div class="clearfix"></div>

				<div class="row">
					<div class="col-md-12">
						<div class="portlet box grey">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-list-ul"></i>Command
								</div>
							</div>
							<div class="portlet-body">
								<div class="tiles" style="text-align: center;">
									<div class="col-sm-1"></div>
									<div class="col-sm-2">
										<!-- <div data-mode="casethree" class="command tile bg-blue"
											id="btnReset">
											<div class="tile-body">
												<i class="fa fa-gear" style="margin-top: 10px;"> </i>
											</div>
											<div class="tile-object">
												<div class="name">CASE 3</div>
											</div>
										</div> -->
									</div>
									<div class="col-sm-2">
										<div data-mode="caseone" class="tile bg-dark command"
											id="ilandingmode">
											<div class="tile-body">
												<i class="fa fa-gear" style="margin-top: 10px;"> </i>
											</div>
											<div class="tile-object">
												<div class="name">CASE 1</div>
											</div>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="command tile bg-green" data-mode="casetwo"
											id="gridmode">
											<div class="tile-body">
												<i class="fa fa-gear" style="margin-top: 10px;"> </i>
											</div>
											<div class="tile-object">
												<div class="name">CASE (2-5)</div>
											</div>
										</div>
									</div>
									
									
									<div class="col-sm-2">
										<div data-mode="casefive" class="command tile bg-red">
											<div class="tile-body">
												<i class="fa fa-gear" style="margin-top: 10px;"> </i>
											</div>
											<div class="tile-object">
												<div class="name">CASE 6</div>
											</div>
										</div>
									</div>
									<div class="col-sm-2">
										<!-- <div data-mode="casefour" class="command tile bg-yellow">
											<div class="tile-body">
												<i class="fa fa-gear" style="margin-top: 10px;"> </i>
											</div>
											<div class="tile-object">
												<div class="name">CASE 4</div>
											</div>
										</div> -->
									</div> 
									<div class="col-sm-1"></div>

								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-24 col-xs-48">
						<button class="btn blue btn-block" style="margin-bottom: 23px; display: none"
							id="testConnection">Test Connection</button>
					</div>
				</div>
				<div class="clearfix"></div>
				<!--  -->
				<!-- <div class="row">
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <a class="dashboard-stat dashboard-stat-v2 blue" href="#">
                                    <div class="visual">
                                        <i class="fa fa-bolt"></i>
                                    </div>
                                    <div class="details">
                                        <div class="number">
                                            <span data-counter="counterup" data-value="1349">0</span> kW
                                        </div>
                                        <div class="desc">Solar</div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <a class="dashboard-stat dashboard-stat-v2 red" href="#">
                                    <div class="visual">
                                        <i class="fa fa-bolt"></i>
                                    </div>
                                    <div class="details">
                                        <div class="number">
                                            <span data-counter="counterup" data-value="12,5">0</span> kW </div>
                                        <div class="desc">Grid</div>
                                    </div>
                                </a>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <a class="dashboard-stat dashboard-stat-v2 green" href="#">
                                    <div class="visual">
                                        <i class="fa fa-bolt"></i>
                                    </div>
                                    <div class="details">
                                        <div class="number">
                                            <span data-counter="counterup" data-value="549">0</span> kW
                                        </div>
                                        <div class="desc">Battery</div>
                                    </div>
                                </a>
                            </div>                            
                        </div> -->
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-8 col-xs-17">


						<div class="portlet red box">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-info"></i>Grid Details
								</div>
								<div class="actions">
									<!-- <a href="#" class="btn default btn-sm">
																<i class="fa fa-pencil"></i> Edit
															</a> -->
								</div>
							</div>
							<div class="portlet-body">
								<div class="row static-info">
									<div class="col-md-7 name">Power:</div>
									<div class="col-md-5 value gridpower">
										
										<!-- <span class="label label-info label-sm">
																	 Email confirmation was sent
																</span> -->
									</div>
								</div>								
								<div class="row static-info">
									<div class="col-md-7 name">Voltage:</div>
									<div class="col-md-5 value gridvoltage">
										<!-- <span class="label label-success"> Closed </span> -->
									</div>
								</div>
								<div class="row static-info">
									<div class="col-md-7 name">State:</div>
									<div class="col-md-5 value gridstate"></div>
								</div>								
							</div>
						</div>




						<!-- <div class="dashboard-stat blue">
						<div class="visual">
							<i class="fa fa-bolt"></i>
							Grid
						</div>
						<div class="details">
							<div class="number" id="gridKW">
								 
							</div>
							<div class="desc">
								 Grid
							</div>
						</div>
						<a class="more" href="#">
							 View more <i class="m-icon-swapright m-icon-white"></i>
						</a>
					</div> -->
					</div>
					<div class="col-lg-4 col-md-4 col-sm-8 col-xs-16">
						<div class="portlet green box">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-info"></i>Battery Details
								</div>
								<div class="actions">
									<!-- <a href="#" class="btn default btn-sm">
																<i class="fa fa-pencil"></i> Edit
															</a> -->
								</div>
							</div>
							<div class="portlet-body">
								<div class="row static-info">
									<div class="col-md-7 name">Power:</div>
									<div class="col-md-5 value batterypower">
										
										<!-- <span class="label label-info label-sm">
																	 Email confirmation was sent
																</span> -->
									</div>
								</div>								
								<div class="row static-info">
									<div class="col-md-7 name">Voltage:</div>
									<div class="col-md-5 value batteryvoltage">
										<!-- <span class="label label-success"> Closed </span> -->
									</div>
								</div>
								<div class="row static-info">
									<div class="col-md-7 name">State:</div>
									<div class="col-md-5 value batterystate"></div>
								</div>							
								<!-- <div class="row static-info">
									<div class="col-md-7 name">Input Source:</div>
									<div class="col-md-5 value batteryinsource"></div>
								</div>
								<div class="row static-info">
									<div class="col-md-7 name">Output Source:</div>
									<div class="col-md-5 value batteryoutsource"></div>
								</div> -->
							</div>
						</div>

						<!-- <div class="dashboard-stat green">
						<div class="visual">
							<i class="fa fa-bolt"></i>
						</div>
						<div class="details">
							<div class="number" id="batteryKW">
								 
							</div>
							<div class="desc">
								 Battery
							</div>
						</div>
						<a class="more" href="#">
							 View more <i class="m-icon-swapright m-icon-white"></i>
						</a>
					</div> -->
					</div>
					<div class="col-lg-4 col-md-4 col-sm-8 col-xs-16">
						<div class="portlet yellow box">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-info"></i>Solar Details
								</div>
								<div class="actions">
									<!-- <a href="#" class="btn default btn-sm">
																<i class="fa fa-pencil"></i> Edit
															</a> -->
								</div>
							</div>
							<div class="portlet-body">
								<div class="row static-info">
									<div class="col-md-7 name">Power:</div>
									<div class="col-md-5 value solarpower">
										
										<!-- <span class="label label-info label-sm">
																	 Email confirmation was sent
																</span> -->
									</div>
								</div>								
								<div class="row static-info">
									<div class="col-md-7 name">Voltage:</div>
									<div class="col-md-5 value solarvoltage">
										<!-- <span class="label label-success"> Closed </span> -->
									</div>
								</div>
								<div class="row static-info">
									<div class="col-md-7 name">State:</div>
									<div class="col-md-5 value solarstate"></div>
								</div>								
								<!-- <div class="row static-info">
									<div class="col-md-7 name">Output Source:</div>
									<div class="col-md-5 value solaroutsource"></div>
								</div> -->
							</div>
						</div>

						<!-- <div class="dashboard-stat purple">
						<div class="visual">
							<i class="fa fa-bolt"></i>
						</div>
						<div class="details">
							<div class="number" id="solarKW">
								 
							</div>
							<div class="desc">
								 Solar
							</div>
						</div>
						<a class="more" href="#">
							 View more <i class="m-icon-swapright m-icon-white"></i>
						</a>
					</div> -->
					</div>
				</div>

				<!--  -->
			</div>
		</div>
		<!-- END CONTENT -->
	</div>

	<div id="testModal" class="modal fade" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">Test Connection</h4>
				</div>
				<div class="modal-body">
					<textarea rows="10" cols="75" id="testMessage"></textarea>
					<!-- END FORM-->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn default" data-dismiss="modal">Close</button>
					<button type="submit" id="btn_send" class="btn blue">Send</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<div id="profileConfiguration" class="modal fade" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">Configuration</h4>
				</div>
				<div class="modal-body">
					<textarea rows="10" cols="75" id="configmessage" readonly="readonly"></textarea>
					<input type="hidden" id="caseType" name="caseType">
					<!-- END FORM-->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn default" data-dismiss="modal">Close</button>
					<button type="submit" id="btn_cong_send" class="btn blue">Send</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<div id="loadModal" class="modal fade" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<center>
				<div class="modal-content" style="width: 257px;">

					<div class="modal-body">
						<b>Command execution in-progress...</b>
					</div>

				</div>
			</center>
		</div>
		<!-- /.modal-dialog -->
	</div>
	<div id="testModal" class="modal fade" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">Test Connection</h4>
				</div>
				<div class="modal-body">
					<textarea rows="10" cols="75" id="testMessage"></textarea>
					<!-- END FORM-->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn default" data-dismiss="modal">Close</button>
					<button type="submit" id="btn_send" class="btn blue">Send</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- END CONTAINER -->
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
	<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
	<script>
		jQuery(document).ready(function() {
			$('#testConnection').hide();
			App.init(); // initlayout and core plugins
			Index.init();
			Index.initCharts(); // init index page's custom scripts
			Index.initMiniCharts();
			Index.initDashboardDaterange();
			Tasks.initDashboardWidget();
			showData();
			var profileConfiguration = new Object();
			fillProfileConfiguration();
			currentStatus();
			setInterval(function(){currentStatus()}, 1000 * 15);
			setInterval(function(){showData()}, 1000*2);
			
			var testConnectionFlag = false;
		});
		$("#testConnection").click(function() {
			$("#testModal").modal("show");
		});
		function showData() {
			var microgrid_id = $.cookie("microgrid_id");
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/micro/findbymicrogridid/"+ microgrid_id,
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response) {
					if (response.data) {
						if (response.status == true) {
							$("#title").html(response.data.microgrid_name
													+ "&nbsp;<button class='microgrid-status btn-sm btn btn-success'>on-line</button>");							
						} else {
							$("#title").html(response.data.microgrid_name
													+ "&nbsp;<button class='microgrid-status btn-sm btn btn-danger'>off-line</button>");							
						}
					}
				},
				error : function(data) {

				}
			});

			/* $.ajax({
				url : "${pageContext.request.contextPath}/rest/micro_status/"+microgrid_id,
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response) {
					if(response.data){
						if(response.status==true){
							var data = response.data[0]
							console.log(data);					
							if(data!=undefined){
								$("#battery_in_source").html(data.battery_in_source);
								$("#battery_out_source").html(data.battery_out_source);
								$("#battery_state").html(data.battery_state);
								$("#grid_state").html(data.grid_state);
								$("#grid_status").html(data.grid_status);
								$("#solar_out_source").html(data.solar_out_source);
								$("#solar_state").html(data.solar_state);	
							}									
						}else{
							
						}
					}
				},
				error:function(data){
					
				}
			}); */
		}
		$("#btn_send").click(function() {
			var microgrid_id = $.cookie("microgrid_id");
			var message = $("#testMessage").val();
			var json = JSON.stringify({id:microgrid_id,message:message});
			//console.log(json)
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/micro/testconnection",
				type : "POST",
				data:json,
				contentType : "application/json",
				dataType : "json",
				success : function(response) {
					//console.log(response);
					if (response.status == true) {
						$("#testModal").modal("hide");
						toastr.success("Connection test successfully");
					} else if(response.status == false){
						toastr.warning("Connection test failed");
					}
				},
				error : function(data) {
	
				}
			});
		});
		
		$(".command").on("click", function(){
			$('#profileConfiguration').modal("show");
			$('#configmessage').val('');
			
			var caseStr = $(this).attr("data-mode")
			//$('#configmessage').val(profileConfiguration[caseStr]);
			$('#caseType').val(caseStr);
			getAppropriateProfileMessage(caseStr);
		});
		
		$("#btn_cong_send").on("click", function(){
			
			var microgrid_status = $(".microgrid-status").html();		
			if(microgrid_status=="on-line"){
				
				var caseType = $('#caseType').val();
				var microgrid_id = getMicroGridIdFromUrl();
				
				var data = {
					"microgrid_id" : microgrid_id,
					"message": $('#configmessage').val(),
					"caseType": caseType
				}
				//var jdata = JSON.stringify(data);
				$.ajax({
					url : "${pageContext.request.contextPath}/rest/command/sendProfile",
					type : "GET",
					contentType : "application/json",
					dataType : "json",
					data : data,				
					beforeSend: function() {
						
				    },
					success : function(response) {
						//console.log(response);
						var status = response.status;
						if(status == 'fail'){
							toastr.info("Client disconnected.!");
						}
						toastr.success("Profile has been set");
					},
					error : function(data) {

					},
					complete: function() {
						setTimeout(function(){
							  $('#profileConfiguration').modal('hide')
						}, 1*1000);
				    },
				});
			} else {
				toastr.info("Client is not connected.");
				setTimeout(function(){
					  $('#profileConfiguration').modal('hide')
				}, 1*1000);
			}
			
		});
		
/* 		$(".command").click(function() {
			var microgrid_status = $(".microgrid-status").html();
			if(microgrid_status=="on-line"){
				var microgrid_id = $.cookie("microgrid_id");
				mode = $(this).attr("data-mode")
				var data = {
					"microgrid_id" : microgrid_id,
					"mode" : mode
				}
				//console.log(data)
				$.ajax({
					url : "${pageContext.request.contextPath}/rest/command/send",
					type : "GET",
					contentType : "application/json",
					dataType : "json",
					data : data,				
					beforeSend: function() {
						$('#loadModal').modal({backdrop: 'static', keyboard: false});
						$('#loadModal').modal("show");
				    },
					success : function(response) {
						
					},
					complete: function() {
						setTimeout(function(){
							  $('#loadModal').modal('hide')
						}, 2*1000);
				    },
					error : function(data) {

					}
				});
			}else{
				toastr.info("Client disconnected.!");
			}
			
		}); */
		/* $("#set_profile").click(function(){
		 var microgrid_id = $.cookie("microgrid_id");
		 var data =  {
		 "microgrid_id" : microgrid_id
		 }
		 $.ajax({
		 url : "${pageContext.request.contextPath}/rest/command/set_profile",
		 type : "GET",
		 contentType : "application/json",
		 dataType : "json",
		 data : data,
		 success : function(response) {
		 console.log(response)
		 },
		 error:function(data){
		
		 }
		 });
		 }); */
		 
		 function fillProfileConfiguration(){
			 profileConfiguration = new Object();
			 profileConfiguration.caseone = '{\n"battery_low_threshold":"30",\n"critical_situation":"grid",\n"solar_low":"battery,grid",\n"standard_situation":"solar",\n"battery_low":"solar,grid",\n"battery_charge_source":"solar"\n}';
			 profileConfiguration.casetwo = '{\n"battery_low_threshold":"30",\n"critical_situation":"grid",\n"solar_low":"battery,grid",\n"standard_situation":"solar",\n"battery_low":"solar,grid",\n"battery_charge_source":"solar"\n}';
			 profileConfiguration.casethree = '{\n"battery_low_threshold":"30",\n"critical_situation":"grid",\n"solar_low":"battery,grid",\n"standard_situation":"solar",\n"battery_low":"solar,grid",\n"battery_charge_source":"solar"\n}';
			 profileConfiguration.casefour = '{\n"battery_low_threshold":"30",\n"critical_situation":"grid",\n"solar_low":"battery,grid",\n"standard_situation":"solar",\n"battery_low":"solar,grid",\n"battery_charge_source":"solar"\n}';
			 profileConfiguration.casefive = '{\n"battery_low_threshold":"30",\n"critical_situation":"grid",\n"solar_low":"battery,grid",\n"standard_situation":"solar",\n"battery_low":"solar,grid",\n"battery_charge_source":"solar"\n}';
		 }
		 
		 
		function currentStatus() {
			var microgrid_id = getMicroGridIdFromUrl();

			var data = new Object();
			data.microgrid_id = microgrid_id;
			
			var jdata = JSON.stringify(data);
			
			$.ajax({
				url:"${pageContext.request.contextPath}/rest/micro/currentStatus",
				type:'POST',
				contentType:'application/json',
				data:jdata,
				success: function(response){
					//console.log(response);
					if(response.solaravail == true){
						$('.solarpower').html(response.solarpower+' kW');
						$('.solarvoltage').html(response.solarvoltage+' V');
						$('.solarstate').html(response.solarstate);
					} else {
						$('.solarpower').html('0 kW');
						$('.solarvoltage').html('0 V');
						$('.solarstate').html('Unavailable');
					}
					if(response.batteryavail == true){
						$('.batterypower').html(response.batterypower+' kW');
						$('.batteryvoltage').html(response.batteryvoltage+' V');
						
						var val = response.batterypower;						
						if(eval(Math.abs(eval(val))) < 0.3){
							$('.batterystate').html('');
						} else {
							$('.batterystate').html(response.batterystate);
						}
						
					} else {
						$('.batterypower').html('0 kW');
						$('.batteryvoltage').html('0 V');
						$('.batterystate').html('');
					}
					if(response.gridavail == true){
						$('.gridpower').html(response.gridpower+' kW');
						$('.gridvoltage').html(response.gridvoltage+' V');
						$('.gridstate').html(response.gridstate);
					} else {
						$('.gridpower').html('0 kW');
						$('.gridvoltage').html('0 V');
						$('.gridstate').html('Unavailable');
					}
									
					// status part
					/* if(response.microcontrollerstatusavail == true){
						$('.batteryinsource').html(response.batteryinsource);
						$('.batteryoutsource').html(response.batteryoutsource);
						$('.solaroutsource').html(response.solaroutsource);
					} else {
						$('.batteryinsource').html('Info Unavilable');
						$('.batteryoutsource').html('Info Unavilable');
						$('.solaroutsource').html('Info Unavilable');
					} */
					
				},
				error: function(){
					//alert('error');
					// If error comes do something that prevent this method to call server.
					//
				}
			});
			
			//console.log('called');
			
			
		}
		
		$('#testConnectionLink').on('click', function(){
			var v = document.getElementById('testConnection');
			if(v.style.display === 'none'){
				v.style.display = 'block';
			} else {
				v.style.display = 'none';
			}
		});
		
		
		function getAppropriateProfileMessage(caseStr){
			
			var microgrid_id = getMicroGridIdFromUrl();
			
			var object = new Object();
			object.microgrid_id = microgrid_id;
			var jsonData = JSON.stringify(object);
			$.ajax({
				url:'${pageContext.request.contextPath}/rest/micro/lastSoc',
				type: 'POST',
				contentType: 'application/json',
				data: jsonData,
				success: function(response){
					var soc = response.soc;
					getAppropriateMessage(caseStr,soc);
				}
			});
			
			
		}
		
		function getAppropriateMessage(){
			var socTot = '';
			var soc = arguments[1];
			switch(arguments[0]){
			case 'caseone':
				var val = eval(eval(soc)+10);
				socTot = (eval(val) > 100) ? 100 : eval(val);							
				break;
			case 'casetwo':
				socTot = eval(eval(soc)-5);
				break;
			case 'casethree':
				socTot = soc;
				break;
			case 'casefour':
				socTot = soc;
				break;
			case 'casefive':
				break;
			}
			message = '{\n"battery_low_threshold":"'+socTot+'",\n"critical_situation":"grid",\n"solar_low":"battery,grid",\n"standard_situation":"solar",\n"battery_low":"solar,grid",\n"battery_charge_source":"solar"\n}';
			if(arguments[0] == 'casefive'){
				message = '{\n"m":"300",\n"command_name":"I-Landing",\n"init":"server"\n}';
			}
			$('#configmessage').val(message);
		}				
		
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>