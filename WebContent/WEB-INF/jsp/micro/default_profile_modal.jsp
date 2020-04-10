<div id="default_profile_modal" class="modal fade bs-modal-lg" id="large" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title" id="modal-title">Edit MicroGrid Profile</h4>
			</div>
			<form action="${pageContext.request.contextPath}/rest/micro/save_profile_management" class="form-horizontal" id="add_micro_grid_profile"  enctype="multipart/form-data" method="post">
			<div class="modal-body" style="max-height:400px;overflow: auto;">				
					<input type="hidden" id="id" name="id">
					
					<div class="col-md-6">
						<div class="form-group">
							<label class="col-md-4">Start Time</label>		
							<div id="start_time" class="col-md-8">
							</div>					
						</div>
						<div class="form-group">
							<label class="col-md-4">Battery Low Threshold</label>
							<div class="col-md-8">
								<input type="number" class="form-control" name="battery_low_threshold" id="battery_low_threshold">
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Standard Situation</label>
							<div class="col-md-8">
								<select class="form-control" name="standard_situation" id="standard_situation">
									<option value="solar">Solar</option>
									<option value="battery">Battery</option>
									<option value="grid">Grid</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Battery Low</label>
							<div class="col-md-8">
								<select class="form-control" name="battery_low" id="battery_low">
									<option value="solar">Solar</option>
									<option value="grid">Grid</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Battery High Threshold</label>
							<div class="col-md-8">
								<input type="number" name="battery_soc" id="battery_soc" class="form-control"/>
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
								<select class="form-control" name="battery_charge_source" id="battery_charge_source">
									<option value="solar">Solar</option>
									<option value="grid">Grid</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Critical Situation</label>
							<div class="col-md-8">
								<select class="form-control" name="critical_situation" id="critical_situation">
									<option value="solar">Solar</option>
									<option value="battery">Battery</option>
									<option value="grid">Grid</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Solar Low</label>
							<div class="col-md-8">
								<select class="form-control" name="solar_low" id="solar_low">
									<option value="battery">Battery</option>
									<option value="grid">Grid</option>
								</select>
							</div>
						</div>
						<div class="form-group">
						<div class="col-md-1"></div>
							<div class="checkbox col-md-4">
								<label><input type="checkbox" name="solar_present" id="solar_present"/>Solar Present</label>
							</div>
							<div class="checkbox col-md-3">
								<label><input type="checkbox" name="solar_gr_load" id="solar_gr_load"/>Solar > Load</label>
							</div>
						</div>
					</div>					
				
				<!-- END FORM-->
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn default" data-dismiss="modal">Close</button>
				<button type="button" id="btn_save" class="btn blue">Save</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<div id="set_default_profile" class="modal fade" id="large" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog ">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title" id="modal-title">Add MicroGrid Profile</h4>
			</div>
			<form class="form-horizontal" id="add_micro_grid_profile" method="post">
			<div class="modal-body" style="max-height:400px;overflow: auto;">									
					<div class="col-md-12">						
						<div class="form-group">
							<label>Select Time Slot</label>
							<select id="time_slot" name="time_slot" class="form-control">
								<option value="4">4</option>
								<option value="8">8</option>
								<option value="12">12</option>
							</select>
						</div>
					</div>					
				<!-- END FORM-->				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn default" data-dismiss="modal">Close</button>
				<button type="button" id="btn_generate_default_profile" class="btn blue">Generate Profile</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<script>
	$("#add_new_profile").click(function(){					
		$("#set_default_profile").modal("show");
	});	
	$(document).ready(function(){
		
	});
	$("#btn_generate_default_profile").click(function(){
		var data = {
			time_slot:$("#time_slot").val()
		};
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/micro/generate_default_profile",
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			data:JSON.stringify(data),
			success : function(response) {			 
				if(response.status==true){
					toastr.success("Profile generate Successfully.");	
				}else if(response.status==false){
					toastr.error(response.message);
				}			  	
			  	$("#set_default_profile").modal("hide");	
			  	loadProfile();
			}
	    });
	});
	$("#btn_save").click(function(){
		var data = {
				id:$("#id").val(),
				battery_low_threshold:$("#battery_low_threshold").val(),
				battery_charge_source:$("#battery_charge_source").val(),
				standard_situation:$("#standard_situation").val(),
				critical_situation:$("#critical_situation").val(),
				battery_low:$("#battery_low").val(),
				solar_low:$("#solar_low").val()
		};
		
		var obj = new Object();
		obj.id = $("#id").val();
		obj.battery_low_threshold = $("#battery_low_threshold").val();
		obj.battery_charge_source=$("#battery_charge_source").val();
		obj.standard_situation=$("#standard_situation").val();
		obj.critical_situation=$("#critical_situation").val();
		obj.battery_low=$("#battery_low").val();
		obj.solar_low=$("#solar_low").val();
		obj.solar_present=$('#solar_present').is(':checked');
		obj.solar_gr_load=$('#solar_gr_load').is(':checked');
		obj.battery_soc=$('#battery_soc').val();
		var mdata = JSON.stringify(obj);
		console.log(JSON.stringify(data));
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/micro/save_default_profile",
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			data:mdata,
			success : function(response) {			 
				if(response.status==true){
					toastr.success("Profile Save Successfully.");	
				}else if(response.status==false){
					toastr.error(response.message);
				}			  	
			  	$("#default_profile_modal").modal("hide");	
			  	loadProfile();
			}
	    });
		return false;
	});
	function editProfile(id){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/micro/edit_default_profile/"+id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response) {		
				var data = response.data;
				$("#id").val(data.id);				
				$("#start_time").html(data.start_time);				
				$("#end_time").html(data.end_time);
				$("#battery_low_threshold").val(data.battery_low_threshold);
				$("#battery_charge_source").val(data.battery_charge_source);
				$("#standard_situation").val(data.standard_situation);
				$("#critical_situation").val(data.critical_situation);
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
				$("#default_profile_modal").modal("show");
			}
	    });
	}
	
</script>