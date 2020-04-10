<style>
 .select2-display-none {
     z-index: 10050;
}
</style>
<div id="profile_management_modal" class="modal fade bs-modal-lg" id="large" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title" id="modal-title">Edit MicroGrid Profile</h4>
			</div>
			<form action="${pageContext.request.contextPath}/rest/micro/save_profile_management" class="form-horizontal" id="add_micro_grid_profile"  enctype="multipart/form-data" method="post">
			<div class="modal-body" style="max-height:400px;overflow: auto;">				
					<input type="hidden" id="id" name="id"/>					
					<div class="col-md-12">
						<div class="form-group">
							<label id="microgrid_id" class="col-md-2">Select Micro Grid</label>
							
						</div>
					</div>
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
								<select class="js-example-basic-multiple js-states form-control" multiple="multiple" name="battery_charge_source" id="battery_charge_source" >
									<!-- <option value="solar">Solar</option>
									<option value="grid">Grid</option> -->
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4">Critical Situation</label>
							<div class="col-md-8">
								<select class="form-control" name="critical_situation" id="critical_situation" multiple="multiple">
									<!-- <option value="solar">Solar</option>
									<option value="battery">Battery</option>
									<option value="grid">Grid</option> -->
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
				
				<!-- END FORM-->				
			</div>
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
			<form action="${pageContext.request.contextPath}/rest/micro/save_profile_management" class="form-horizontal" id="add_micro_grid_profile"  enctype="multipart/form-data" method="post">
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
				<button type="button" id="btn_generate_profile" class="btn blue">Generate Profile</button>
			</div>
			</form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<script>
	var battery_source = [];
	var critical_source = [];
	$(document).ready(function() {
		
	});
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
		console.log(battery_source);
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
		console.log(critical_source);
	});
	
	$("#add_new_profile").click(function(){					
		$("#set_default_profile").modal("show");
	});	
	$("#btn_generate_profile").click(function(){
		var m_id = getMicroGridIdFromUrl();
		var data = {
			microgrid_id:m_id,
			time_slot:$("#time_slot").val()
		};
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/micro/generate_profilet",
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
		
		
		
		var data = {
				id:$("#id").val(),
				battery_low_threshold:$("#battery_low_threshold").val(),
				battery_charge_source:battery_charge_source_val,
				standard_situation:$("#standard_situation").val(),
				critical_situation:critical_situation_val,
				battery_low:$("#battery_low").val(),
				solar_low:$("#solar_low").val()
		};
		
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
		console.log(mdata);
		console.log(JSON.stringify(data));
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/micro/save_profile_management",
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
			  	$("#profile_management_modal").modal("hide");	
			  	loadProfile();
			}
	    });
		return false;
	});
	function editProfile(id){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/micro/edit_profile/"+id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response) {
				var critical_energy_sources = ["solar","grid","battery"];
				var battery_charge_sources = ["solar","grid"];
				var data = response.data;
				
				$("#id").val(data.id);
				$("#microgrid_id").html(data.microgrid_name+"#"+data.microgrid_id);					
				$("#start_time").html(data.start_time);				
				$("#end_time").html(data.end_time);
				$("#battery_low_threshold").val(data.battery_low_threshold);
				//$("#battery_charge_source").val(data.battery_charge_source);
				$("#standard_situation").val(data.standard_situation);
				//$("#critical_situation").val(data.critical_situation);
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
				$("#profile_management_modal").modal("show");			
				
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
				/* if(data.critical_situation != null) {
					var vals = data.critical_situation.split(',');
					$("#critical_situation").val(vals).trigger("change");
				} else {
					$("#critical_situation").val('').trigger("change");
				} */
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
				
				$("select.js-example-basic-multiple").select2();
				$("#critical_situation").select2();
				
			}
	    });
	}
	function deleteProfile(id){
		if(confirm("Are you sure?")){
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/micro/delete_profile/"+id,
				type : "POST",
				contentType : "application/json",
				dataType : "json",
				success : function(response) {		
					if(response.status==true){
						toastr.success("Profile delete successfully.");
						loadProfile();
					}
				}
		    });
		}			
	}
</script>