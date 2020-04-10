<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
	<div class="clearfix"></div>

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
							<li><a id="profileManagement" href="#">Profile
									Management</a><i class="fa fa-angle-right"></i></li>
							<li><div id="profileInfo"></div></li>
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
						<div class="portlet-body" id="energy-body"
							style="padding: 20px; min-height: 460px;">
							<div id="profileg">
								<jsp:include page="../components/profile_chart.jsp"></jsp:include>
							</div>
						</div>
						<div class="portlet-body" id="energy-body"
							style=" padding-bottom:35px; min-height: 20px;">
							<!-- <div class="row" style="font-family: 'Sans-serif'; font-weight: bold;"> -->
								<div class="col-md-1" style="text-align:center; ">Solar</div>
								<div class="col-md-1" style="background-color: #de6b16;min-height: 20px;"></div>
								<div class="col-md-1" style="text-align:center; ">Grid</div>
								<div class="col-md-1" style="background-color: #808080;min-height: 20px;"></div>
								<div class="col-md-1" style="text-align:center;">Battery</div>
								<div class="col-md-1" style="background-color:#4cae4c ;min-height: 20px;"></div>
							<!-- </div> -->
						</div>
						<div class="portlet-body" id="profile_details"
							style="padding: 25px; min-height: 403px; display: none;">
							<div id="profiledetails">
								<form class="form-horizontal" id="profile_details"
									enctype="multipart/form-data" method="post">
									<div class="modal-body"
										style="max-height: 400px; overflow: auto;">
										<input type="hidden" id="id" name="id" />
										<input type="hidden" id="plot_index" name="plot_index"/>																								
										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-4">Start Time</label>
												<div id="start_time" class="col-md-8"></div>
											</div>
											<div class="form-group">
												<label class="col-md-4">Battery Low Threshold</label>
												<div class="col-md-8">
													<input type="number" class="form-control"
														name="battery_low_threshold" id="battery_low_threshold">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4">Standard Situation</label>
												<div class="col-md-8">
													<select class="form-control" name="standard_situation"
														id="standard_situation">
														<option value="solar">Solar</option>
														<option value="battery">Battery</option>
														<option value="grid">Grid</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4">Battery Low</label>
												<div class="col-md-8">
													<select class="form-control" name="battery_low"
														id="battery_low">
														<option value="battery">Solar</option>
														<option value="grid">Grid</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4">Battery SOC</label>
												<div class="col-md-8">
													<input type="number" name="battery_soc" id="battery_soc"
														class="form-control" />
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label class="col-md-4">End Time</label>
												<div id="end_time" class="col-md-8"></div>
											</div>
											<div class="form-group">
												<label class="col-md-4">Battery Charge Source</label>
												<div class="col-md-8">
													<select
														class="js-example-basic-multiple js-states form-control"
														multiple="multiple" name="battery_charge_source"
														id="battery_charge_source">
														<!-- <option value="solar">Solar</option>
									<option value="grid">Grid</option> -->
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4">Critical Situation</label>
												<div class="col-md-8">
													<select class="form-control" name="critical_situation"
														id="critical_situation" multiple="multiple">
														<!-- <option value="solar">Solar</option>
									<option value="battery">Battery</option>
									<option value="grid">Grid</option> -->
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-4">Solar Low</label>
												<div class="col-md-8">
													<select class="form-control" name="solar_low"
														id="solar_low">
														<option value="battery">Battery</option>
														<option value="grid">Grid</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<div class="col-md-1"></div>
												<div class="checkbox col-md-4">
													<label><input type="checkbox" name="solar_present"
														id="solar_present" />Solar Present</label>
												</div>
												<div class="checkbox col-md-3">
													<label><input type="checkbox" name="solar_gr_load"
														id="solar_gr_load" />Solar > Load</label>
												</div>
											</div>

											<!-- END FORM-->
										</div>
									</div>
									<div class="modal-footer">								
										<button type="button" id="btn_save" class="btn blue">Save</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
	<script>
	var battery_source = [];
	var critical_source = [];
		jQuery(document)
				.ready(
						function() {
							App.init(); // initlayout and core plugins
							Index.init();
							$("#dashBoard")
									.click(
											function() {
												var microgrid_id = $
														.cookie("microgrid_id");
												window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"
														+ microgrid_id;
											});
							var id = getMicroGridIdFromUrl();
							$('#profileInfo').html("Profile [" + id + "]");
							
							
							
						});

		$('#profileManagement')
				.on(
						'click',
						function() {
							var microgrid_id = getMicroGridIdFromUrl();
							window.location.href = "${pageContext.request.contextPath}/rest/micro/profile_management/"
									+ microgrid_id;
						});

		function showDetails(id) {
			loadDetails(id);
			$('#profile_details').show();
		}

		function hideDetails() {
			$('#profile_details').hide();
		}
		
		$('#battery_charge_source').on('change', function() {
			var bat_charge_source_val = $('#battery_charge_source').val();
			if( $('#battery_charge_source').val() != null) {
				$.each(bat_charge_source_val, function(i,e){
					if(battery_source.indexOf(bat_charge_source_val[i]) < 0) {
						battery_source.push(bat_charge_source_val[i]);
					}
				});
				var temp = [];
				$.each(battery_source, function(i,e) {
					temp.push(e);
				});
				$.each(temp, function(i,e){
					if(bat_charge_source_val.indexOf(temp[i])< 0) {
						battery_source.splice(battery_source.indexOf(e), 1);
					}
				});
			} else {
				battery_source = [];
			}		
			//console.log(battery_source);
		});	
		
		$('#critical_situation').on('change', function() {
			var bat_charge_source_val = $('#critical_situation').val();
			if( $('#critical_situation').val() != null) {
				$.each(bat_charge_source_val, function(i,e){
					if(critical_source.indexOf(bat_charge_source_val[i]) < 0) {
						critical_source.push(bat_charge_source_val[i]);
					}
				});
				var temp = [];
				$.each(critical_source, function(i,e) {
					temp.push(e);
				});
				$.each(temp, function(i,e){
					if(bat_charge_source_val.indexOf(temp[i])< 0) {
						critical_source.splice(critical_source.indexOf(e), 1);
					}
				});
			} else {
				critical_source = [];
			}		
			//console.log(critical_source);
		});
		
		function loadDetails(id){
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/micro/edit_profile/"+id,
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response) {
					fillDetails(response);
				}
			});
		}
		
		
		function fillDetails(response){
			var critical_energy_sources = ["solar","grid","battery"];
			var battery_charge_sources = ["solar","grid"];
			var data = response.data;
			
			$("#id").val(data.id);									
			$("#start_time").html(data.start_time);				
			$("#end_time").html(data.end_time);
			$("#battery_low_threshold").val(data.battery_low_threshold);					
			$("#standard_situation").val(data.standard_situation);
			$("#battery_low").val(data.battery_low);
			$("#solar_low").val(data.solar_low);
			
			if(data.solar_present == false){									
				$('#solar_present').prop('checked', false);
			} else {
				$('#solar_present').prop('checked', true);
			}
			if(data.solar_gr_load == false){
				$('#solar_gr_load').prop('checked', false);
			} else {
				$('#solar_gr_load').prop('checked', true);
			}
			$('#battery_soc').val(data.battery_soc);
			
			
			battery_source = [];
			$('#battery_charge_source').html('');
			var battery_charge_source_temp = battery_charge_sources;
			if(data.battery_charge_source != null){
				var values = data.battery_charge_source;
				$.each(values.split(','), function(i,e) {
					$('#battery_charge_source').append('<option val="'+e+'" selected>'+e+'</option>');
					battery_charge_source_temp.splice(battery_charge_source_temp.indexOf(e),1);
					battery_source.push(e);
				});									
			}
			
			$.each(battery_charge_source_temp, function(i,e) {
				$('#battery_charge_source').append('<option val="'+battery_charge_source_temp[i]+'">'+battery_charge_source_temp[i]+'</option>');
			});
			
			critical_source = [];
			$('#critical_situation').html('');
			var critical_val_temp = critical_energy_sources;
			if(data.critical_situation != null) {
				var values = data.critical_situation;					
				$.each(values.split(','), function(i,e){
					$('#critical_situation').append('<option val="'+e+'" selected>'+e+'</option>');
					critical_val_temp.splice(critical_val_temp.indexOf(e),1);
					critical_source.push(e);
				} );
			}
															
			$.each(critical_val_temp, function(i,e) {
				$('#critical_situation').append('<option val="'+critical_val_temp[i]+'">'+critical_val_temp[i]+'</option>');
			});
			
			$('#battery_charge_source').select2();
			$('#critical_situation').select2();
		}
		
		$('#btn_save').on('click', function(){
			
			var battery_charge_source_val = null;
			if(battery_source.length > 0){
				battery_charge_source_val = '';
				for(var i = 0 ; i < battery_source.length ; i ++) {
					if(i == (battery_source.length-1)) {
						battery_charge_source_val += battery_source[i];
					} else {
						battery_charge_source_val += battery_source[i]+',';
					}			
				}
			}
					
			var critical_situation_val = null;
			if(critical_source.length > 0) {
				critical_situation_val = '';
				for(var i = 0 ; i < critical_source.length ; i ++) {
					if(i == (critical_source.length-1)) {
						critical_situation_val += critical_source[i];
					} else {
						critical_situation_val += critical_source[i]+',';
					}			
				}
			}
			
			
			
			var obj = new Object();
			obj.id = $("#id").val();
			obj.battery_low_threshold = $("#battery_low_threshold").val();
			obj.battery_charge_source=battery_charge_source_val;
			obj.standard_situation=$("#standard_situation").val();
			obj.critical_situation=critical_situation_val;
			obj.battery_low=$("#battery_low").val();
			obj.solar_low=$("#solar_low").val();
			obj.solar_present=$('#solar_present').is(':checked');
			obj.solar_gr_load=$('#solar_gr_load').is(':checked');
			obj.battery_soc=$('#battery_soc').val();
			var mdata = JSON.stringify(obj);
			
			saveOnServer(mdata);
			
		});
		
		function saveOnServer(mdata){
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/micro/save_profile_management",
				type : "POST",
				contentType : "application/json",
				dataType : "json",
				data:mdata,
				success : function(response) {			 
					if(response.status==true){
						toastr.success("Profile Saved Successfully.");
						getData();					
					}else if(response.status==false){
						toastr.error(response.message);
					}			  					  
				}
		    });
			
			
		}
		
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
