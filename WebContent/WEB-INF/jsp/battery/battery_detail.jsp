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
							<li>
								<i class="fa fa-home"></i>
								<a href="${pageContext.request.contextPath}/rest/home/list">Home</a>
								<i class="fa fa-angle-right"></i>
							</li>
							<li><a href="#" id="dashBoard"> Dashboard </a><i class="fa fa-angle-right"></i></li>
							<li>Battery Details</li>
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
					<div class="col-md-2 white_box" style="padding:0px;">
						<img class="thumbnail" style="height:200px;width:100%;" src="${pageContext.request.contextPath}/public/images/noimage.png" id="battery_img">					
						<div class="col-md-12">
						<p id="battery_data">
							Samsung SDI Co Ltd<br>
							Total Size - 95.2kWh
						</p>
						<p id="no_of_rack">
														
						</p>
						<p id="rack_description">
												
						</p>						
						</div>
					</div>
					<div class="col-md-5">
						<div class="col-md-12 white_box text-center">
							<div class="row">
								<h4>
									Current Output Voltage									
								</h4>															
								<jsp:include page="../components/current_voltage_knob.jsp"></jsp:include>
							</div>						
								<div id="hourInterval" class="row primary text-center text-primary" style="padding-right:0px;">
									
								</div>					
							<div class="row">
								<jsp:include page="../components/current_out_voltage.jsp"></jsp:include>
							</div>						
						</div>					
					</div>
					<div class="col-md-5" style="padding-left:0px;">
						<div class="col-md-12 white_box text-center">
							<div class="row">
								<h4>
									Current SOH
								</h4>
								<jsp:include page="../components/current_soh_knob.jsp"></jsp:include>								
								<div class="row primary text-right" style="padding-right:50px;">									
									<select id="month_filter" style="background:#4D8FFD;color:white;">
										<option value="1">January</option>
										<option value="2">February</option>
										<option value="3">March</option>
										<option value="4">April</option>
										<option value="5">May</option>
										<option value="6">June</option>
										<option value="7">July</option>
										<option value="8">August</option>
										<option value="9">September</option>
										<option value="10">October</option>
										<option value="11">November</option>
										<option value="12">December</option>
									</select>
							</div>
							</div>
							
							<div class="row">
								<jsp:include page="../components/current_soh_chart.jsp"></jsp:include>
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
	var currentHour = 0;
	var dataHour = 0;
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			Index.init();
			ComponentsKnobDials.init();

			$("#dashBoard").click(function() {
				var microgrid_id = $.cookie("microgrid_id"); 
				window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"+microgrid_id;
			});
			showBatteryData();
		});
		
		function showBatteryData(){
			//var microgrid_id = $.cookie("microgrid_id");
			var microgrid_id = getMicroGridIdFromUrl();
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/battery/findbymicrogrid_id/"+microgrid_id,
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response, textStatus, jqXHR) {					 
					 if(response.data){
						 var battery = response.data;
						 if(battery['batteryPic']){
							 $("#battery_img").prop("src","https://drive.google.com/uc?export=view&id="+battery['batteryPic']);
						 }else{
							 $("#battery_img").prop("src","${pageContext.request.contextPath}/public/images/noimage.png"); 
						 } 
						 $("#battery_data").html(battery['manufacture']+"<p>Total Size - "+battery['total_size']);
						 $("#no_of_rack").html("<b>No. of Rack</b> - "+battery.no_of_rack);
						 $("#rack_description").html(battery.rack_description);
						 var data = "Health : "+battery['stateOfHelth'];
						 data += "<br>Voltage : "+battery['voltage_v'];
						 data += "<br>Technology : "+battery['technology'];
						 data += "<br>Temp :"+battery['temprature'];
						 data += "<br>Status :"+battery['status'];
						 data += "<br>Level : "+battery['level'];						 
					 }
				},
				// callback handler that will be called on error
				error : function(jqXHR, textStatus, errorThrown) {

				}
			});
		}
		
		function nextHour() {
			if(parseInt(dataHour) < 23) {
				currentHour += 1;
				//console.log(currentHour);
				getData(currentHour);
			}				
		}
		
		function prevHour() {
			if(parseInt(dataHour) > 1) {
				currentHour -= 1;
				//console.log(currentHour);
				getData(currentHour);
			}
			
		}
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>