<div id="break_down_modal" class="modal fade" tabindex="-1"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<form class="form-horizontal" id="break_down_frm" method="POST"
					action="${pageContext.request.contextPath}/rest/utility/upload" enctype="multipart/form-data">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Add Break Down</h4>
					</div>
					<div style="height: 35px; clear: both;"></div>
					<div class="row">
						<div class="col-md-12">							
							<input type="hidden" id="id">
							<div class="col-md-12">
								<div class="form-group">
									<label id="utility_provider">
										Utility Provider									
									</label>
									<input type="hidden" id="utility_provider_id" value="${id}">
									
								</div>
								<div class="form-group">
									<label>Season Name</label>
									<input type="text" class="form-control" name="season_name" id="season_name">	
								</div>								
							</div>	
							<div class="col-md-5">
								<div class="form-group">
									<label>Start Date</label>
									<div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
										<input type="text" class="form-control" id="start_date">										
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>		
								</div>
							</div>			
							<div class="col-md-2"></div>			
							<div class="col-md-5">
								
								<div class="form-group">
									<label>End Date</label>
									<div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
										<input type="text" class="form-control" id="end_date">										
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>		
								</div>
							</div>																		
						</div>
					</div>
					<div class="modal-footer" style="padding-right: 0px;">
						<button type="button" data-dismiss="modal" class="btn default">Close</button>
						<button type="button" id="saveBreakDown" class="btn btn-primary">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
$("#add_break_down").click(function(){
	$('#break_down_frm')[0].reset();
	$("#id").val("");
	$("#break_down_modal").modal("show");	
});
function getUtilityProviderById(){
	var id = $("#utility_provider_id").val();
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/utility/find_utility_provider/"+id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.data){
				$("#utility_provider").html("<h4 style='margin:0px;'>Utility Provider : "+response.data['utilityName']+"</h4>");
			}
		},					
		error : function(jqXHR, textStatus, errorThrown) {

		}
   });
}
$("#saveBreakDown").click(function(){
	var id = $("#id").val();
	var data = {
		id:id,	
		season : $("#season_name").val(),
		start_date:$("#start_date").val(),
		end_date:$("#end_date").val(),
		utility_provider_id:$("#utility_provider_id").val()
	}
	data = JSON.stringify(data);				
	url = "${pageContext.request.contextPath}/rest/utility/save_break_down";				
	$.ajax({
		url : url,
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data : data,
		success : function(response, textStatus, jqXHR) {
			$("#break_down_modal").modal("hide");
			$('#break_down_frm')[0].reset();
			
			if(id!=""){
				toastr.success("Utility update successfully.!");
			}else{
				toastr.success("Utility add successfully.!");
			}
			setTable();
		},					
		error : function(jqXHR, textStatus, errorThrown) {

		}
   });
});
</script>