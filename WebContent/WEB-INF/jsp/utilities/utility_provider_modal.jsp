<div id="provider_modal" class="modal fade" tabindex="-1"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<form class="form-horizontal" id="provider_frm" method="POST"
					action="${pageContext.request.contextPath}/rest/utility/upload" enctype="multipart/form-data">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Add Utility Provider</h4>
					</div>
					<div style="height: 35px; clear: both;"></div>
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-10">							
							<input type="hidden" id="id">
							<div class="form-group">
								<label>Provider Name</label>							
								<input type="text" class="form-control" name="utilityName" id="utilityName">								
							</div>		
							<div class="form-group">
								<label>Meter fees per day</label>							
								<input type="number" class="form-control" name="meter_fees_per_day" id="meter_fees_per_day">								
							</div>																								
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="modal-footer" style="padding-right: 0px;">
						<button type="button" data-dismiss="modal" class="btn default">Close</button>
						<button type="button" id="saveUtilityProvider" class="btn btn-primary">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
$("#add_provider").click(function(){	
	$("#id").val("");
	$("#provider_modal").modal("show");	
});

$("#saveUtilityProvider").click(function(){
	var id = $("#id").val();
	var data = {
		id:id,	
		utilityName : $("#utilityName").val(),
		meter_fees_per_day : $("#meter_fees_per_day").val()
	}
	data = JSON.stringify(data);				
	url = "${pageContext.request.contextPath}/rest/utility/save_provider";				
	$.ajax({
		url : url,
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data : data,
		success : function(response, textStatus, jqXHR) {
			$("#provider_modal").modal("hide");
			$('#provider_frm')[0].reset();
			if(id!=""){
				toastr.success("Utility Provider update successfully.!");
			}else{
				toastr.success("Utility Provider add successfully.!");
			}
			setTable();
		},					
		error : function(jqXHR, textStatus, errorThrown) {

		}
   });
});
function editUtilityProvider(id){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/utility/find_utility_provider/"+id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.data!=null){
				var data = response.data;
				$("#id").val(data['id']);
				$("#utilityName").val(data['utilityName']);
				$("#meter_fees_per_day").val(data['meter_fees_per_day']);				
				$("#provider_modal").modal("show");
			}
		},					
		error : function(jqXHR, textStatus, errorThrown) {

		}
   });
}

function deleteUtilityProvider(id){
	if(confirm("Are you sure?")){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/utility/delete_utility_provider/"+id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {
				if(response.status==true){	
					toastr.success("Utility provider delete successfully.!");
					setTable();
				}
			},					
			error : function(jqXHR, textStatus, errorThrown) {

			}
	   });	
	}
}
</script>