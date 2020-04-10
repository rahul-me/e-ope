<div id="cost_analysis_location_modal" class="modal fade" tabindex="-1" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<form class="form-horizontal" id="cost_analysis_location_modal_form">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Site Location</h4>
						<h6><b>Note</b>: This will help us to analyse data for your location. More specific location works better. <br/>You can go with the location that has been provided by you (if yes) or you can choose different site location. </h6>
					</div>
					<div style="height: 15px; clear: both;"></div>					
					<div class="form-group">
						<label class="control-label col-xs-3">Address Line 1
							<span style="color: red;">*</span>
						</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="address_line_1"
								id="address_line_1">
						</div>
					</div>
					 
					<div class="form-group">
						<label class="control-label col-xs-3">Address Line 2					
						</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="address_line_2"
								id="address_line_2">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-3">City
							<span style="color: red;">*</span>
						</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="city"
								id="city">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-3">State							
						</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="state"
								id="state">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-3">Zip Code
							<span style="color: red;">*</span>
						</label>
						<div class="col-xs-9">
							<input type="number" class="form-control" name="zip_code"
								id="zip_code">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-xs-3">Country						
						</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="country"
								id="country">
						</div>
					</div>

					<div class="modal-footer">
						<button type="button" data-dismiss="modal" class="btn default">Close</button>
						<button type="button" id="analyse" class="btn green">Analyse</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
$("#cost_analysis_location_modal_form").validate({
	rules: {		
		address_line_one: {
			required: true,					
		},
		city: {
			required: true,
		},
		zip_code: {
			required: true,
			number:true
		}
	},
	messages: {
		address_line_one: "Address is a required.",
		city: "Provide city",
		zip_code: "Provide Zip Code"		
	}
});



</script>