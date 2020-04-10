<div id="microgridconfig" class="modal fade bs-modal-lg" id="large" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title">Edit Micro Grid Controller</h4>
			</div>
			<div class="modal-body" style="max-height:400px;overflow: auto;">
				<form action="${pageContext.request.contextPath}/rest/micro/save" class="form-horizontal" id="add_micro"  enctype="multipart/form-data" method="post">
					<input type="hidden" id="id" name="id">
					<div class="form-body">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Micro Grid Name</label>
									<div class="col-md-10">
										<input type="text" class="form-control" placeholder="Micro Grid Name" id="microgrid_name" name="microgrid_name">
									</div>
								</div>
							</div>							
						</div>
						<!--/row-->
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Micro Grid Pic</label>
									<div class="col-md-10">
									<div class="fileinput fileinput-new" data-provides="fileinput"><input type="hidden">
										<div class="input-group ">
											<div class="form-control uneditable-input span3" data-trigger="fileinput">
												<i class="fa fa-file fileinput-exists"></i>&nbsp;
												<span class="fileinput-filename">
												</span>
											</div>
											<span class="input-group-addon btn default btn-file">
												<span class="fileinput-new">
													 Select file
												</span>
												<span class="fileinput-exists">
													 Change
												</span>
												<input type="file" name="file1" id="filename" >
											</span>
											<a href="#" class="input-group-addon btn default fileinput-exists" data-dismiss="fileinput">
												 Remove
											</a>
										</div>										
										<div id="edit_image" style="display:none;">
											<a href="javascript:void(0);" id="remove_pic" onclick="remove_pic(this.id);">Click here to remove Uploaded Pic </a>/
											<a href="" target="_blank" id="view_pic_mg">View Pic</a>
										</div>
									</div>
									</div>
								</div>
							</div>
						
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Micro Grid Profile Pic</label>
									<div class="col-md-10">
									<div class="fileinput fileinput-new" data-provides="fileinput"><input type="hidden">
										<div class="input-group ">
											<div class="form-control uneditable-input span3" data-trigger="fileinput">
												<i class="fa fa-file fileinput-exists"></i>&nbsp;
												<span class="fileinput-filename">
												</span>
											</div>
											<span class="input-group-addon btn default btn-file">
												<span class="fileinput-new">
													 Select file
												</span>
												<span class="fileinput-exists">
													 Change
												</span>
												<input type="file" name="file2" id="filename" >
											</span>
											<a href="#" class="input-group-addon btn default fileinput-exists" data-dismiss="fileinput">
												 Remove
											</a>
										</div>
										<div id="edit_profile_image" style="display:none;">
											<a href="javascript:void(0);" id="remove_profile_pic" onclick="remove_pic(this.id);">Click here to remove Uploaded Pic </a>/
											<a href="" target="_blank" id="view_profile_pic_mg">View Pic</a>
										</div>
									</div>
									</div>
								</div>
							</div>
						</div>												
						<!--/row-->
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">About</label>
									<div class="col-md-10">
										 <textarea class="col-md-10" id="textarea" rows="4" placeholder="Enter a short synopsis" id="about" name="about"></textarea>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Time Zone</label>
									<div class="col-md-10">
										<select class="form-control" name="time_zone_list" id="time_zone_list"></select>	
										<input type="hidden" name="time_zone" id="time_zone"> 
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Utility</label>
									<div class="col-md-10">
										<jsp:include page="../components/select_utility_list.jsp"></jsp:include>	 
									</div>
								</div>
							</div>
						</div>
						<div class="row" id="is_active_div">
							<div class="col-md-12">
								<div class="form-group">
									<div class="col-xs-offset-2 col-xs-10" style="padding-left: 35px;">
										<div class="checkbox">
											<label>
												<input type="checkbox" name="active" id="is_active"> Active
											</label>	 									
										</div>
									</div>
								</div>	
							</div>
						</div>
						<h3 class="form-section" style="margin: 0px 0px 25px 0px;">Project Coordinator detail</h3>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Name</label>
									<div class="col-md-10">
										<input type="text" name="owner_manager_name" id="owner_manager_name" class="form-control">	 
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Contact No</label>
									<div class="col-md-10">
										<input type="text" name="owner_manager_contact" id="owner_manager_contact" class="form-control">	 
									</div>
								</div>
							</div>
						</div>
						<h3 class="form-section" style="margin: 0px 0px 25px 0px;">Maintenace manager detail</h3>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Name</label>
									<div class="col-md-10">
										<input type="text" name="maintenance_manager_name" id="maintenance_manager_name" class="form-control">	 
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Contact No</label>
									<div class="col-md-10">
										<input type="text" name="maintenance_manager_contact" id="maintenance_manager_contact" class="form-control">	 
									</div>
								</div>
							</div>
						</div>
						
						<h3 class="form-section" style="margin: 0px 0px 25px 0px;">Address</h3>
						<!--/row-->
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">Address 1</label>
									<div class="col-md-9">
										<input type="text" class="form-control" id="address_line_1" name="address_line_1">
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">Address 2</label>
									<div class="col-md-9">
										<input type="text" class="form-control"  id="address_line_2" name="address_line_2">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
								<label class="control-label col-md-3">City</label>
									<div class="col-md-9">
										<input type="text" class="form-control" id="city" name="city">
									</div>									
								</div>								
							</div>
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">State</label>
									<div class="col-md-9">
										<select class="form-control" id="state" name="state"></select>
									</div>
								</div>
							</div>
							<!--/span-->
						</div>
						<!--/row-->
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">Country</label>
									<div class="col-md-9">
										<select class="form-control" id="country" name="country">
											<option>USA</option>
											<option>IND</option>
											<option>UK</option>
										</select>
									</div>
								</div>								
							</div>
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label col-md-3">Zip Code</label>
									<div class="col-md-9">
										<input type="text" class="form-control" id="zip_code" name="zip_code">
									</div>
								</div>								
							</div>
							<!--/span-->
						</div>
						<!--/row-->
						<h3 class="form-section" style="margin: 0px 0px 25px 0px;">Power usage</h3>
						<!-- Meter chart max value -->
						<div class="row">
							<div class="col-md-8">
								<div class="form-group">
									<label class="control-label col-md-4">Maximum Display Value</label>
									<div class="col-md-8">
										<input type="text" class="form-control" id="max_meter_value" name="max_meter_value">
									</div>
								</div>								
							</div>							
						</div>
						
					</div>
					<input type="hidden" class="form-control" id="latitude" name="latitude">
					<input type="hidden" class="form-control" id="longitude" name="longitude">
	   				<input type="hidden" id="utility_name" name="utility_name">
				</form>
				<!-- END FORM-->
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn default" data-dismiss="modal">Close</button>
				<button type="submit" id="btn_save" class="btn blue">Save</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<script type="text/javascript" src="//maps.googleapis.com/maps/api/js?key=AIzaSyAn7bnyIGQZso-Mmkvxf-dJtrcWgSdo0wU"></script>
<script>
function editMicroGrid(){
	showData();
	$('#time_zone_list').timezones();
	$("#microgridconfig").modal("show");
}
function remove_pic(id){
	
	var key = '';
	if(id=="remove_pic"){
		key = "microgrid";
	}else {
		key = "profile"
	}
	var id = $("#id").val();
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro/removepic/"+id+"?key="+key,
		type : "get",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
		  	if(response.status==true){
		  		toastr.success('Image delete successfuly.!');
		  		if(key=="profile"){
		  			$("#edit_profile_image").hide();
		  		}else if(key == "microgrid"){
		  			$("#edit_image").hide();
		  		}
		  		showData();
		  	}
		}
    });
}
var options = {
        beforeSend : function() {
            $("#progressbox").show();
            // clear everything
            $("#progressbar").width('0%');
            $("#message").empty();
            $("#percent").html("0%");
        },
        uploadProgress : function(event, position, total, percentComplete) {
            $("#progressbar").width(percentComplete + '%');
            $("#percent").html(percentComplete + '%');
            // change message text to red after 50%
            if (percentComplete > 50) {
            $("#message").html("<font color='red'>File Upload is in progress</font>");
            }
        },
        success : function() {
            $("#progressbar").width('100%');
            $("#percent").html('100%');
        },
        complete : function(response) {
        	$('#large').modal('hide');
        	$('#add_micro')[0].reset();
        	$("#microgridconfig").modal("hide"); 
        	showData();
        },
        error : function() {
        	$("#message").html("<font color='red'> ERROR: unable to upload files</font>");
        }
};

$("#btn_save").click(function(){	
	if($("#add_micro").valid()){
		var dataoffset = $('#time_zone_list option:selected').attr('data-offset');
    	var val = $('#time_zone_list').val();
    	$('#time_zone').val(dataoffset+"##"+val);
		var text = $("#utilityList option:selected").text();
		$("#utility_name").val(text);
		var add = $("#address_line_1").val()+","+$("#address_line_2").val()+","+$("#city").val()+","+$("#state").val()+","+$("#zip_code").val()+","+$("#country").val();
		
		 /* getLatLong($("#country").val()+","+$("#zip_code").val(),function(geocode){
			  console.log(geocode)
			  $('#latitude').val(geocode.lat());
			  $('#longitude').val(geocode.lng());
			  var form = $('#add_micro');	
			  $("#add_micro").submit();
		   }); */
		 
		 var geocoder = new google.maps.Geocoder();
 		geocoder.geocode({'address':add}, function(results, status){
 			if(status == google.maps.GeocoderStatus.OK){    				
   			  $('#latitude').val(results[0].geometry.location.lat());
 			  $('#longitude').val(results[0].geometry.location.lng());
 			  var form = $('#add_micro');    	
 			  $("#add_micro").submit();
 			}else {
 				toastr["warning"]("Data will not be submitted untill valid address", "Address is not valid")
 				return;
 			}
 		});
		$("#add_micro").ajaxForm(options);		
	}else{
		return false;
	}
});

$("#add_micro").validate({
	rules: {
		microgrid_name: "required",
		microgrid_id: "required",
		address_line_1: "required",
		city: "required",
		state: "required",
		country: "required",
		zip_code: "required",		
		microgrid_name: {
			required: true,
		},
		microgrid_id: {
			required: true,
		},
		address_line_1: {
			required: true,
		},
		city: {
			required: true,
		},
		state: {
			required: true,
		},
		country: {
			required: true,
		},
		zip_code: {
			required: true,
		}
	},
	messages: {
		microgrid_name: "Please enter your microgrid name",
		country: "Please select country name",
		state: "Please select state name",
		city: "Please select city name",
		zip_code: "Please enter zip code",
		microgrid_id: "Please enter microgrid id",
		address_line_1: "Please enter your address details"
	}
});
</script>