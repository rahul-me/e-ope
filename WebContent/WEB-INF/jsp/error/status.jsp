<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
<div class="clearfix"></div>


<jsp:include page="../bootstrapheader/leftmenu.jsp"></jsp:include>
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					Error Status 
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li class="btn-group">
							<jsp:include page="../components/back_btn.jsp"></jsp:include>						
						</li>						
						<li>
							<i class="fa fa-home"></i>
							<a href="${pageContext.request.contextPath}/rest/micro/list">
								Home
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							Error Status
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->			
			
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-6 well" style="padding: 0px">
						<div class="col-md-6""><h4 style="padding-top:4%">Total Error Occurred</h4></div>	
						<div class="col-md-6"><h3 style="color: red" id="err_tot"></h3></div>										
					</div>
					<div class="col-md-6 well" style="padding: 0px">
						<div class="col-md-6"><h4 style="padding-top:4%">Total Error Resolved</h4></div>	
						<div class="col-md-6"><h3 style="color: green" id="err_res"></h3></div>											
					</div>
				</div>				
			</div>
			
			
			
			<!-- rd -->
			
							<div class="row profile">
					<div class="col-md-12">
						<!--BEGIN TABS-->
						<div class="tabbable tabbable-custom tabbable-full-width">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#tab_1_1" data-toggle="tab">
										Inverter </a></li>
								<li><a href="#tab_1_3" data-toggle="tab"> Battery </a></li>
								<li><a href="#tab_1_4" data-toggle="tab"> Energy Meter </a></li>
								<li><a href="#tab_1_5" data-toggle="tab"> ATS </a></li>

							</ul>
							<div class="tab-content">
								<div class="tab-pane active" id="tab_1_1" style="padding:15px;">
									<div class="row">
										<div class="col-md-12" style="padding: 9px;">
											<div class="portlet box grey">
												<div class="portlet-title">
													<div class="caption">CODE 100</div>
												</div>
												<div class="portlet-body">
													<!-- <div class="table-toolbar">
							<div class="btn-group">
								<button id="addNewBattery" class="btn green">
									Add New <i class="fa fa-plus"></i>
								</button>										
							</div>							
						</div> -->
													<table id="code100"
														class="display table table-striped table-bordered table-hover"
														cellspacing="0" width="100%">
														<thead>
															<tr>											
																<th>Error Detail</th>
																<th>Status On</th>
																<th>Status</th>
															</tr>
														</thead>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!--tab_1_2-->
								<div class="tab-pane" id="tab_1_3" style="padding:15px;">
									<div class="row">
										<div class="col-md-12" style="padding:9px;">
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							CODE 200
						</div>
					</div>
					<div class="portlet-body">
						<!-- <div class="table-toolbar">
							<div class="btn-group">
								<button id="addNewBattery" class="btn green">
									Add New <i class="fa fa-plus"></i>
								</button>										
							</div>							
						</div> -->						
						<table id="code200" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>																	
									<th>Error Detail</th>
									<th>Status On</th>
									<th>Status</th>									
								</tr>
							</thead>
						</table>					
					</div>
				</div>
			</div>
									</div>
								</div>
								<div class="tab-pane" id="tab_1_4" style="padding:15px;">
									<div class="row">
										<div class="col-md-12" style="padding:9px;">
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							CODE 300
						</div>
					</div>
					<div class="portlet-body">
						<!-- <div class="table-toolbar">
							<div class="btn-group">
								<button id="addNewBattery" class="btn green">
									Add New <i class="fa fa-plus"></i>
								</button>										
							</div>							
						</div> -->						
						<table id="code300" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>																		
									<th>Error Detail</th>
									<th>Status On</th>
									<th>Status</th>									
								</tr>
							</thead>
						</table>					
					</div>
				</div>
			</div>
									</div>
								</div>
								<div class="tab-pane" id="tab_1_5" style="padding:15px;">
									<div class="row">
										<div class="col-md-12" style="padding:9px;">
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							CODE 400
						</div>
					</div>
					<div class="portlet-body">
						<!-- <div class="table-toolbar">
							<div class="btn-group">
								<button id="addNewBattery" class="btn green">
									Add New <i class="fa fa-plus"></i>
								</button>										
							</div>							
						</div> -->						
						<table id="code400" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>															
									<th>Error Detail</th>
									<th>Status On</th>
									<th>Status</th>									
								</tr>
							</thead>
						</table>					
					</div>
				</div>
			</div>
									</div>
								</div>
								<!--end tab-pane-->

							</div>
							<!--END TABS-->
						</div>
					</div>
					<!-- END PAGE CONTENT-->

				</div>
			
			<!-- rd -->
			
			
			<div class="clearfix"></div>			
		</div>		
	</div>	
	<!-- END CONTENT -->
</div>
<div class="clearfix"></div>


<!-- END CONTAINER -->
<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   Index.init();
   Index.initCharts(); // init index page's custom scripts
   Index.initMiniCharts();
   Index.initDashboardDaterange();
   Tasks.initDashboardWidget();   
   ComponentsEditors.init();
   setCode100();
   getErrorStatistics();
});

function getErrorStatistics(){
	var microgrid_id = getMicroGridIdFromUrl();
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro/getErrorStatistics/"+microgrid_id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			if(response.data){
				document.getElementById("err_tot").innerHTML = response.data.err_tot;
				document.getElementById("err_res").innerHTML = response.data.err_res;
			}
		},
		error:function(data){			
		}
	});
}



function setCode100(){
	var m_id = getMicroGridIdFromUrl();
	$('#code100').dataTable({
        "paging": false,
		"searching": false,
		"bInfo": false,
		"serverSide": true,
        "bDestroy": true,
		"ajax" : "${pageContext.request.contextPath}/rest/micro/getErrorState/100/"+m_id,
		"columns" : [								
			    {
					"data":"error_details"
				},{
					"data":null,
					"render": function(data, type, row){
						var time =row.event_time;
						time = time.substring(0, time.length-1)
						return time.split('T')[0]+' '+time.split('T')[1];
					}
				},{
					"data":null,
					"render": function(data, type, row){
						return row.status.toUpperCase();
					}
				}
				],
				tableTools: {
		            "aButtons": [
		                "copy",
		                "csv",
		                "xls",
		                {
		                    "sExtends": "pdf",
		                    "sPdfOrientation": "landscape",
		                    "sPdfMessage": "Your custom message would go here."
		                },
		                "print"
		            ]
		        },
				
			"fnDrawCallback": function( oSettings ) {
				$(".test").bootstrapToggle('destroy')
				$(".test").bootstrapToggle({
					"on" : "Active",
					"off" : "De-Active",
					"size":"mini",
					"onstyle":"success",
					"offstyle":"danger"
				});
			}
	});
	
	$('#code200').dataTable({
		"paging": false,
		"searching": false,
		"bInfo": false,
		"serverSide": true,
        "bDestroy": true,
		"ajax" : "${pageContext.request.contextPath}/rest/micro/getErrorState/200/"+m_id,
		"columns" : [
				{
					"data":"error_details"
				},{
					"data":null,
					"render": function(data, type, row){
						var time =row.event_time;
						time = time.substring(0, time.length-1)
						return time.split('T')[0]+' '+time.split('T')[1];
					}
				},{
					"data":null,
					"render": function(data, type, row){
						return row.status.toUpperCase();
					}
				}
				],
				tableTools: {
		            "aButtons": [
		                "copy",
		                "csv",
		                "xls",
		                {
		                    "sExtends": "pdf",
		                    "sPdfOrientation": "landscape",
		                    "sPdfMessage": "Your custom message would go here."
		                },
		                "print"
		            ]
		        },
				
			"fnDrawCallback": function( oSettings ) {
				$(".test").bootstrapToggle('destroy')
				$(".test").bootstrapToggle({
					"on" : "Active",
					"off" : "De-Active",
					"size":"mini",
					"onstyle":"success",
					"offstyle":"danger"
				});
			}
	});
	
	$('#code300').dataTable({
		"paging": false,
		"searching": false,
		"bInfo": false,
		"serverSide": true,
        "bDestroy": true,
		"ajax" : "${pageContext.request.contextPath}/rest/micro/getErrorState/300/"+m_id,
		"columns" : [
				{
					"data":"error_details"
				},{
					"data":null,
					"render": function(data, type, row){
						var time =row.event_time;
						time = time.substring(0, time.length-1)
						return time.split('T')[0]+' '+time.split('T')[1];
					}
				},{
					"data":null,
					"render": function(data, type, row){
						return row.status.toUpperCase();
					}
				}
				],
				tableTools: {
		            "aButtons": [
		                "copy",
		                "csv",
		                "xls",
		                {
		                    "sExtends": "pdf",
		                    "sPdfOrientation": "landscape",
		                    "sPdfMessage": "Your custom message would go here."
		                },
		                "print"
		            ]
		        },
				
			"fnDrawCallback": function( oSettings ) {
				$(".test").bootstrapToggle('destroy')
				$(".test").bootstrapToggle({
					"on" : "Active",
					"off" : "De-Active",
					"size":"mini",
					"onstyle":"success",
					"offstyle":"danger"
				});
			}
	});
	
	$('#code400').dataTable({
		"paging": false,
		"searching": false,
		"bInfo": false,
		"serverSide": true,
        "bDestroy": true,
		"ajax" : "${pageContext.request.contextPath}/rest/micro/getErrorState/400/"+m_id,
		"columns" : [
				{
					"data":"error_details"
				},{
					"data":null,
					"render": function(data, type, row){
						var time =row.event_time;
						time = time.substring(0, time.length-1)
						return time.split('T')[0]+' '+time.split('T')[1];
					}
				},{
					"data":null,
					"render": function(data, type, row){
						return row.status.toUpperCase();
					}
				}
				],
				tableTools: {
		            "aButtons": [
		                "copy",
		                "csv",
		                "xls",
		                {
		                    "sExtends": "pdf",
		                    "sPdfOrientation": "landscape",
		                    "sPdfMessage": "Your custom message would go here."
		                },
		                "print"
		            ]
		        },
				
			"fnDrawCallback": function( oSettings ) {
				$(".test").bootstrapToggle('destroy')
				$(".test").bootstrapToggle({
					"on" : "Active",
					"off" : "De-Active",
					"size":"mini",
					"onstyle":"success",
					"offstyle":"danger"
				});
			}
	});
	
	
}


</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>