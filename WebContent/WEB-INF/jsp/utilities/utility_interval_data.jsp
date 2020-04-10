<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<!-- END HEAD -->
<!-- BEGIN BODY -->

<body class="page-header-fixed">
	<input type="hidden" id="userId" value="${userId}"/>
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
						<h3 class="page-title">Cost Estimation</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="${pageContext.request.contextPath}/rest/micro/list">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> Utility </a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							Utility
						</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12">								
								<div class="col-md-4">
									<div class="form-group">								
										<label>Account No</label>
										<jsp:include page="utility_account_no_list.jsp"></jsp:include>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">								
										<label>Energy Cost On</label>
										<select class="form-control" id="energy_cost_on">
											<option value="predefined">Predefined</option>
											<option value="calculated">Calculated</option>
										</select>
									</div>
								</div>
								<div class="clearfix"></div>
								<div class="col-md-4">
									<div class="form-group">								
										<label>Total Solar available time </label>
										<input type="text" id="total_avaliable_solar_time" name="solar_output_per_day" class="form-control" placeholder="Avaliablity of solar in (hrs)">
									</div>
								</div>
										
								<div class="col-md-4">
									<div class="form-group">
										<label>Solar Panel Size</label>
										<input type="text" id="solar_panel_size" name="solar_panel_in_kw" class="form-control" placeholder="Solar panel size in kw">
									</div>
								</div>
								<input type="hidden" id="latVal"/><input type="hidden" id="longVal"/>
								<div class="clearfix"></div>
								<div class="col-md-4">
									<button type="button" class="btn blue" onclick="getLocationForAnalysis();">Estimate Solar Cost</button>
								</div>
							</div>
							<div class="col-md-12" style="padding:0px; display: none;" id="site_location_div">	
								<div class="col-md-12">
									<div class="col-md-6">
									<h4>Site Location</h4>
									</div>									
								</div>								
								<div class="col-md-12">															
									<div id="site_location_map" style="min-width: 300px; height: 300px; margin: 0 auto"></div>
								</div>			
							</div>							
							<div class="col-md-12" style="padding:0px;">	
								<div class="col-md-12">
									<div class="col-md-6">
									<h4>Usage kWh & Cost</h4>
									</div>
									<div class="col-md-6" style="padding-top:10px;">
										<jsp:include page="../components/date_filter_search.jsp"></jsp:include>
									</div>
								</div>
								<div id="week_data" class="col-md-12 text-center">
									
								</div>
								<div class="col-md-12">															
									<div id="utility_interval_data" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
								</div>			
							</div>
													
						</div>		
						<div style="height:10px;clear:both;"></div>									
					</div>
				</div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
	<!-- END CONTAINER -->	
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
		<jsp:include page="utility_interval_chart.jsp"></jsp:include>
		<jsp:include page="cost_analysis_location.jsp"></jsp:include>
		<script type="text/javascript" src="//maps.googleapis.com/maps/api/js?key=AIzaSyCvKBb0NzIMFkFQZZogygKt0bplHDCYgSo"></script>
	<!-- END JAVASCRIPTS -->	
	<script>
		jQuery(document).ready(function() {    
		   App.init(); 
		   Index.init();
		   //ComponentsIonSliders.init();
		   $("#total_avaliable_solar_time").ionRangeSlider({
			   min: 1,
               max: 10,
               type: 'single',
               step: 1,
               postfix: " Hrs",
               prettify: false,
               hasGrid: true
			});
		    $("#solar_panel_size").ionRangeSlider({
			   min: 1,
               max: 10,
               type: 'single',
               step: 0.5,
               postfix: " KW",
               prettify: false,
               hasGrid: true
			});
		   //set_chart();
		});
		
		function set_chart(){
			var latVal = $('#latVal').val();
			var longVal = $('#longVal').val();
			var url = "";
			var search_filter = $("#search_filter").val();
			var solar_avaliable_time = $("#total_avaliable_solar_time").val();
			var solar_panel_size = $("#solar_panel_size").val();
			var account_no = $("#utility_account_no_list").val();
			var energy_cost_on = $("#energy_cost_on").val();
			if(search_filter=="week"){
				var startDate = $("#startDate").val();
				var endDate = $("#endDate").val();
				url = "${pageContext.request.contextPath}/rest/utility/getintervaldatanew?search_filter=week&start_date='"+startDate+"'&end_date='"+endDate+"'";
				url += "&solar_avaliable_time="+solar_avaliable_time+"&solar_panel_size="+solar_panel_size+"&account_no="+account_no+"&energy_cost_on="+energy_cost_on+"&latVal="+latVal+"&longVal="+longVal;
				var format = "%b %e";
				setIntervalChart(url,format);
			}else if(search_filter=="month"){
				var month = $("#month").val();
				var year = $("#year").val();
				url = "${pageContext.request.contextPath}/rest/utility/getintervaldatanew?search_filter=month&month="+month+"&year="+year;
				url += "&solar_avaliable_time="+solar_avaliable_time+"&solar_panel_size="+solar_panel_size+"&account_no="+account_no+"&energy_cost_on="+energy_cost_on+"&latVal="+latVal+"&longVal="+longVal;
				var format = "%b %e";
				console.log(url)
				setIntervalChart(url,format);
			}else if(search_filter=="year"){
				var year = $("#year").val();
				url = "${pageContext.request.contextPath}/rest/utility/getintervaldatanew?search_filter=year&year="+year;
				url += "&solar_avaliable_time="+solar_avaliable_time+"&solar_panel_size="+solar_panel_size+"&account_no="+account_no+"&energy_cost_on="+energy_cost_on+"&latVal="+latVal+"&longVal="+longVal;
				var format = "%b";
				setIntervalChart(url,format);
			}	
			
		}
		
		function getLocationForAnalysis(){				
			$.ajax({
				url:'${pageContext.request.contextPath}/rest/users/location',
				type:'get',
				success: function(response){
					if(response.data){
						showExistingDetails(response.data);	
						
					}
				}
			});
		}
		
		function showExistingDetails(user){
			var formData = ['address_line_1','address_line_2','city', 'state', 'zip_code','country'];			
			$.each(formData, function(index, value){
				var data = user[value];
				if(data != null && data != ''){
					$('#'+value).val(data);
				}
			});
			$('#cost_analysis_location_modal').modal('show');
		}
		
		
		
		$('#analyse').on('click', function(){
			if($('#cost_analysis_location_modal_form').valid()){
				$('#cost_analysis_location_modal').modal('hide');
				var address = generateAddressLine();		
				var latLong = getLatLong(address);				
			} else {
				toastr["warning"]("Please fill required details as mentioned", "Given data is not valid");
			}
		});
		
		function generateAddressLine(){
			var formData = ['address_line_1','address_line_2','city', 'state', 'zip_code','country'];
			var address = addDataInAddress(formData);
			return address;
		}
		
		function addDataInAddress(){
			var address = '';
			var length = arguments[0].length;
			$.each(arguments[0], function(index, value){
				var data = $('#'+value).val();
				if(data.trim().length > 0){
					address += data;
					if(index != eval(eval(length)-1)){
						address += ",";
					}
				}
			});	
			return address;
		}
		
		function getLatLong(address){
			var geocoder = new google.maps.Geocoder();		
    		geocoder.geocode({'address':address}, function(results, status){
    			if(status == google.maps.GeocoderStatus.OK){    				
      			  var lat = results[0].geometry.location.lat();
      			  var lon = results[0].geometry.location.lng();
      			  $('#latVal').val(lat);
      			  $('#longVal').val(lon);
      			showMap();
    			}else {
    				$('#latVal').val('NaN');
        			  $('#longVal').val('Nan');
        			  showMap();
    				toastr["warning"]("Change your location preference. No geocode found for your location")
    				return null;
    			}
    		});    		
		}
		
		
		//map part
		function showMap(){
			var latVal = $('#latVal').val();
			var lonVal = $('#longVal').val();
			var zoomVal = 15;
			if(latVal == 'NaN' && lonVal == 'NaN'){
				zoomVal = 2;
				latVal = 0.0;
				lonVal = 0.0;
			}
			var latlng = new google.maps.LatLng(latVal, lonVal);
			var map = new google.maps.Map(document.getElementById('site_location_map'), {
	    		center: latlng,
	    		zoom: zoomVal,
	    		mapTypeId: google.maps.MapTypeId.ROADMAP
			});
			var marker = new google.maps.Marker({
	   			position: latlng,
	    		map: map,
	    		title: 'Set lat/lon values for this property',
	    		draggable: true
			});
			google.maps.event.addListener(marker, 'dragend', function(evt) {
	    		console.log(evt.latLng.lat().toFixed(8));
	    		console.log(evt.latLng.lng().toFixed(8));
	    		chnageInSiteLocation();
	    		// bingo!
	    		// a.latLng contains the co-ordinates where the marker was dropped
			});
			$('#site_location_div').css('display','block');
		}
		
		
		function changeInSiteLocation(){
			alert('getit');
		}
		
		
		
		
	</script>
</body>
<!-- END BODY -->
</html>