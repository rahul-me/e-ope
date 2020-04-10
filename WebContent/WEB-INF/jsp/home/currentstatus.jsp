<style>
.tools{
	margin-top:0px !important;
}
.btn-gray{
	background: gray !important;
}
</style>
<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-sidebar-closed">
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
						<li>
							<i class="fa fa-home"></i>
							<a href="${pageContext.request.contextPath}/rest/micro/list">
								Home
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>				
								Dashboard							
						</li>
						<li class="pull-right">>
							<li class="btn-group">
								<jsp:include page="../components/back_btn.jsp"></jsp:include>
								<button type="button" class="btn blue dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="true">
								<span>
									Actions
								</span>
								<i class="fa fa-angle-down"></i>
								</button>
								<ul class="dropdown-menu pull-right" role="menu">
									<li>
										<a href="javascript:void(0);" id="command">
											Command
										</a>
									</li>
									<li>
										<a href="javascript:void(0);" id="status">
											Status
										</a>
									</li>
									<li>
										<a href="javascript:void(0);" id="pfd">
											Current Status
										</a>
									</li>									
								</ul>
							</li>
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN DASHBOARD STATS -->
			<div class="row">
				<div class="col-md-4">
					<div class="portlet box grey customPanel">
						<div class="portlet-title gray customPanel-title">
							<div class="caption font-sm" id="microgrid_name"
								style="font-weight: 700"></div>
								<div class="caption font-sm text-primary" id="microstatus"
								style="font-weight: 700"></div>
							<div class="tools">
								<a
									href="${pageContext.request.contextPath}/rest/micro/show/${id}"
									id="" class="font-sm">More</a>
							</div>
						</div>
						<div class="portlet-body" style="padding: 0px;">
							<img id="site_img" alt=""
								src="${pageContext.request.contextPath}/public/images/noimage.png"
								style="width: 100% !important; height: 245px;">
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="portlet box blue customPanel">
						<div class="portlet-title customPanel-title">
							<div class="caption font-sm">
								<b>Energy Usage</b>
							</div>
							<div class="tools">
								<a
									href="${pageContext.request.contextPath}/rest/analysis/load_analysis/${id}"
									id="" class="font-sm">More</a>
							</div>
						</div>
						<div class="portlet-body" style="padding-bottom: 0px;">
							<div class="row">
								<div class="col-md-4 col-sm-4" style="padding:5px;">
									<jsp:include page="../components/electricty_performance.jsp"></jsp:include>
								</div>
								<div class="col-md-4 col-sm-4" style="padding:5px;">
									<jsp:include page="../components/green_column_chart.jsp"></jsp:include>
									<h5 align="center" style="margin: 0px;font-size:15px;font-family:arial;"></h5>
								</div>
								<div class="col-md-4 col-sm-4">
									<jsp:include page="../components/meterchart.jsp"></jsp:include>
									<h5 align="center" style="margin: 0px;font-family:arial;"><b style="font-size:15px;">Current Load (kW)</b></h5>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
				<div class="portlet box blue customPanel">
					<div class="portlet-title customPanel-title">
						<div class="caption font-sm">
							<b>Microgrid Status</b>
						</div>
						<div class="tools">
							<a
								href="${pageContext.request.contextPath}/rest/analysis/${id}"
								id="" class="font-sm">More</a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="row">
							<div class="col-md-4">
								<jsp:include page="../components/microgrid-grid-status.jsp"></jsp:include>
							</div>
							<div class="col-md-1">
								<p class="text-center" style="font-size:15px;font-family:arial;padding-top:06px;"><b>Status</b></p>
								<div style="height:110px;clear:both;"></div>
								<button id="on" class="btn btn-success btn-block">ON</button>
							</div>
							<div class="col-md-7">
								<jsp:include page="../components/energy_load_distributor.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="portlet box blue customPanel">
						<div class="portlet-title customPanel-title">
							<div class="caption font-sm">
								<b>Solar</b>
							</div>
							<div class="tools">
								<a
									href="${pageContext.request.contextPath}/rest/solar/solar_detail/${id}"
									id="" class="font-sm">More</a>
							</div>
						</div>
						<div class="portlet-body" style="min-height:220px;">
							<div class="row">
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
									<img src="${pageContext.request.contextPath}/public/images/solar.png" style="width:80px;padding-top:0px;height: 118px;">
									<br><br>
									<!-- <p class="text-center">Generation</p> -->
									<p class="text-center" id="currentsolar" style="padding-top:8px;"></p>								
								</div>
								<div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">																		
									<jsp:include page="../components/timeseries.jsp"></jsp:include>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="portlet box blue customPanel">
						<div class="portlet-title customPanel-title">
							<div class="caption font-sm">
								<b>Emission</b>
							</div>
						</div>
						<div class="portlet-body" style="min-height:220px;">
							<div class="row font12"  style="text-align: center;">
								<div class="col-md-12" style="padding-left:5px;font-size:16px;"><b>Carbon footprint</b></div><br>
								<div>(past 30 days)</div>
							</div>
							<!-- <div style="height:5px;clear:both;"></div> -->
							<div class="row">
								<div class="col-md-12" style="padding:0px;">
								<div class="col-md-6 col-xs-6 col-sm-6" style="padding-left:15px;padding-right:0px;text-align: center;">									
									<div class="col-md-12" style="padding:0px;">
										Black Footprint<br>
										(Without Microgrid)
									</div>
									<div class="col-md-12">
										<img alt="" src="${pageContext.request.contextPath}/public/images/black_foot.png" class="" style="height:95px !important;">
										<p><span id="co2">0 lbs</span></p>
									</div>
								</div>
								<div class="col-md-6 col-xs-6 col-sm-6" style="padding-left:0px;padding-right:15px;text-align: center;">									
									<div class="col-md-12" style="padding:0px;">
									Green Footprint<br>
									(With Microgrid)
									</div>
									<div class="col-md-12">
									<img alt="" src="${pageContext.request.contextPath}/public/images/green_foot.png" class="" style="height:95px !important;">
									<p><span id="myco2">0 lbs</span></p>
								</div>
							</div>
							</div>
						</div>
					</div>
				</div>
				</div>
				<div class="col-md-5">
					<div class="portlet box blue customPanel">
						<div class="portlet-title customPanel-title">
							<div class="caption font-sm">
								<b>Battery</b>
							</div>
							<div class="tools">
								<a
									href="${pageContext.request.contextPath}/rest/battery/battery_detail/${id}"
									id="" class="font-sm">More</a>
							</div>
						</div>
						<div class="portlet-body" style="min-height:220px;">
							<div class="row">
								<div class="col-md-3">
									<div style="height:40px;clear:both;"></div>
									<div class="easy-pie-chart">
										<div id="battery_progress" class="number transactions" data-percent="0">
											<span id="text-data">
												 +0	
											</span>
											 %
										</div>										
									</div>		
									<!-- <p class="text-center">Battery Status</p> -->
									<p class="text-center" id="batteryStateText" style="padding-top:8px;"></p>							
									<!-- <p class="text-center" id="batteryStateText"></p> -->			
								</div>	
								<div class="col-md-9">
									<jsp:include page="../components/battery_bar_chart.jsp"></jsp:include>
									<!-- <h5 align="center" style="margin: 0px;font-size:14px;font-family:arial;">Time (hrs)</h5> -->
								</div>			
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END DASHBOARD STATS -->
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
<jsp:include page="set_data.jsp"></jsp:include>
<script src="${pageContext.request.contextPath}/public/javascripts/valid_microgrid.js"></script>
<script>
jQuery(document).ready(function() {
	getMicroGridIdFromUrl();
	var microgrid= '';
	   App.init(); // initlayout and core plugins

	   Index.init();// init index page's custom scripts
	   $('.transactions').easyPieChart({
		   barColor:"green",
           animate: 1000,
           lineWidth: 4,
       });
   $(".sidebar-toggler").hide();   
   $("#viewMore").click(function(){
	   //var microgrid_id = $.cookie("microgrid_id"); 
	  var microgrid_id = getMicroGridIdFromUrl();	  
	  window.location.href = "${pageContext.request.contextPath}/rest/micro/show/"+microgrid_id;
   });   
   $("#command").click(function(){
	  //var microgrid_id = $.cookie("microgrid_id");
	  var microgrid_id = getMicroGridIdFromUrl();
	  window.location.href = "${pageContext.request.contextPath}/rest/command/action/"+microgrid_id;
   });
   getMicroGridControllerStatus();
   showData(); 
   
});
function showData(){
	var microgrid_id = getMicroGridIdFromUrl();
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/home/showdata/"+microgrid_id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			 if(response.micro){
				 var micro = response.micro;
				 if(micro['pic_url']){
					 $("#site_img").prop("src","https://drive.google.com/uc?export=view&id="+micro['pic_url']);
				 }else{
					 $("#site_img").prop("src","${pageContext.request.contextPath}/public/images/noimage.png");
				 }								
				 $("#microgrid_name").html(micro['microgrid_name']);
			 }
			 if(response.battery){
				 var battery = response.battery;
				 if(battery['batteryPic']){
					 $("#battery_img").prop("src","${pageContext.request.contextPath}"+battery['batteryPic']);
				 }else{
					 $("#battery_img").prop("src","${pageContext.request.contextPath}/public/images/noimage.png"); 
				 } 
				 
				 var data = "Health : "+battery['stateOfHelth'];
				 data += "<br>Voltage : "+battery['voltage_v'];
				 data += "<br>Technology : "+battery['technology'];
				 data += "<br>Temp :"+battery['temprature'];
				 data += "<br>Status :"+battery['status'];
				 data += "<br>Level : "+battery['level'];
				 $('.progress-bar').css("width", battery['level']).attr('aria-valuenow', battery['level']); 
				 $("#battery_data").html(data);
			 }
		},
		// callback handler that will be called on error
		error : function(jqXHR, textStatus, errorThrown) {

		}
	});
}

function getMicroGridControllerStatus() {
	var microgrid_id = getMicroGridIdFromUrl();
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro/findbymicrogridid/"+microgrid_id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			if(response.data){
				if(response.status==true){				
					 $("#microstatus").html('On-Line');
				}else{
					$("#microstatus").html('Off-Line');
				}
			}
		},
		error:function(data){
			status = false;
		}
	});
}

$('#status').on('click', handleStatusCall);

function handleStatusCall(){
	var m_id = getMicroGridIdFromUrl();
	window.location.href = "${pageContext.request.contextPath}/rest/micro/errorstatus/"+m_id;
}

$('#pfd').on('click', function(){
	var m_id = getMicroGridIdFromUrl();
	window.location.href = "${pageContext.request.contextPath}/rest/pfd/page/"+m_id;
})


</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>