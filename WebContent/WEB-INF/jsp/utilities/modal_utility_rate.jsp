<div id="utility_rate_modal" class="modal fade" tabindex="-1"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<form class="form-horizontal" id="utility_rate_frm" method="POST"
					action="${pageContext.request.contextPath}/rest/utility/upload" enctype="multipart/form-data">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Add Utility Rate</h4>
					</div>
					<div style="height: 35px; clear: both;"></div>
					<div class="row">
						<div class="col-md-12">							
							<input type="hidden" id="id">
							<div class="col-md-12">
								<div class="form-group">
									<label id="utility_provider">Utility Provider</label>									
									<input type="hidden" id="provider_id" value="${id}">
									<input type="hidden" id="break_down_id" value="${b_id}">										
								</div>
								<div class="form-group">
									<label id="season">Season</label>									
								</div>
								<div class="form-group">
									<label>Generation</label>
									<input type="text" id="generation" class="form-control">	
								</div>
							</div>																										
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">							
							<input type="hidden" id="id">
							<div class="col-md-5">								
								<div class="form-group">
									<label class="control-label">Start Time</label>
									<div class="input-group">
										<input type="text" id="start_time" class="form-control timepicker timepicker-24">
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-clock-o"></i></button>
										</span>
									</div>
								</div>
							</div>				
							<div class="col-md-2"></div>			
							<div class="col-md-5">								
								<div class="form-group">
									<label class="control-label">End Time</label>
									<div class="input-group">
										<input type="text" id="end_time" class="form-control timepicker timepicker-24">
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-clock-o"></i></button>
										</span>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label>Rate</label>
									<input type="number" class="form-control" name="season_name" id="rate">	
								</div>				
							</div>																				
						</div>
					</div>
					<div class="modal-footer" style="padding-right: 0px;">
						<button type="button" data-dismiss="modal" class="btn default">Close</button>
						<button type="button" id="saveUtility_rate" class="btn btn-primary">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
$("#add_utility_rate").click(function(){	
	$("#id").val("");	
	$("#utility_rate_frm")[0].reset();
	$("#utility_rate_modal").modal("show");	
});

$("#saveUtility_rate").click(function(){
	var id = $("#id").val();
	var s_time = $("#start_time").val().split(":");
	var start_time = s_time[0]+":"+s_time[1];
	var e_time = $("#end_time").val().split(":");
	var end_time = e_time[0]+":"+e_time[1];
	var data = {
		id:id,	
		generation : $("#generation").val(),
		utility_break_down_id:$("#break_down_id").val(),
		rate:$("#rate").val(),
		startTime:start_time,
		end_time:end_time
	}
	data = JSON.stringify(data);				
	url = "${pageContext.request.contextPath}/rest/utility/save_utility_rate";				
	$.ajax({
		url : url,
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data : data,
		success : function(response, textStatus, jqXHR) {
			$("#utility_rate_modal").modal("hide");
			$('#utility_rate_frm')[0].reset();
			if(id!=""){
				toastr.success("Utility rate update successfully.!");
			}else{
				toastr.success("Utility rate add successfully.!");
			}
			setTable();
		},					
		error : function(jqXHR, textStatus, errorThrown) {

		}
   });
});
function editUtilityRate(id){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/utility/find_utility_rate_by_id/"+id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.data!=null){
				var data = response.data;
				$("#id").val(data['id']);
				$("#generation").val(data['generation']);
				$("#rate").val(data['rate']);
				$("#start_time").val(data['startTime']);
				$("#end_time").val(data['end_time']);	
				$("#utility_rate_modal").modal("show");
			}
		},					
		error : function(jqXHR, textStatus, errorThrown) {

		}
   });
}

function deleteUtilityRate(id){
	if(confirm("Are you sure?")){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/utility/delete_utility_rate/"+id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {
				if(response.status==true){	
					toastr.success("Utility rate delete successfully.!");
					setTable();
				}
			},					
			error : function(jqXHR, textStatus, errorThrown) {

			}
	   });	
	}
}

</script>