<div id="responsive" class="modal fade" tabindex="-1" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<form class="form-horizontal" id="addUtility">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Utility</h4>
					</div>
					<div style="height: 15px; clear: both;"></div>
					<input type="hidden" id="id" name="id">
					<div class="form-group allowed_super_admin">
						<label for="inputPassword" class="control-label col-xs-3">Customer
							<span style="color: red;">*</span>
						</label>
						<div class="col-xs-9">
							<jsp:include page="../components/select_user_customer_admin.jsp"></jsp:include>
						</div>
					</div>
					 
					<div class="form-group">
						<label for="inputPassword" class="control-label col-xs-3">Name
							<span style="color: red;">*</span>
						</label>
						<div class="col-xs-9">
							<jsp:include page="utility_provider_name_list.jsp"></jsp:include>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="control-label col-xs-3">Account
							No <span style="color: red;">*</span>
						</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="account_no"
								id="account_no">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="control-label col-xs-3">Service
							<span style="color: red;">*</span>
						</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="service"
								id="service">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="control-label col-xs-3">Tariff
							Plan <span style="color: red;">*</span>
						</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="tariff_plan"
								id="tariff_plan">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="control-label col-xs-3">Emergency
							Contact <span style="color: red;">*</span>
						</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" name="emergency_contact"
								id="emergency_contact">
						</div>
					</div>

					<div class="modal-footer">
						<button type="button" data-dismiss="modal" class="btn default">Close</button>
						<button type="button" id="saveUtility" class="btn green">Save
							changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
$("#addUtility").validate({
	rules: {
		name: "required",
		account_no: "required",
		service: "required",
		emergency_contact: "required",
		name: {
			required: true,					
		},
		account_no: {
			required: true,
		},
		service: {
			required: true,
		},
		emergency_contact: {
			required: true,
		}
	},
	messages: {
		name: "Please enter utility name",
		account_no: "Please enter account no",
		service: "Please enter service",
		emergency_contact: "Please emergency contact",
	}
});


$("#saveUtility").click(function(){
	if($("#addUtility").valid()){
		var data = '';				
		var id = $("#id").val();
		var name = $("#utilityname option:selected").text();
		var utility_provider_id = $("#utilityname").val();
		var account_no = $("#account_no").val();
		var service = $("#service").val();
		var emergency_contact = $("#emergency_contact").val();
		var tariff_plan = $("#tariff_plan").val();
		var user_id = "";
		$(".form-group").each(function(){
			var flag = $(this).hasClass("allowed_super_admin");
			if(flag==true){
				user_id = $("#customer_user_list").val();
			}
		});
		
		var url = "";
		var utility = {
			id:id,
			name:name,
			account_no:account_no,
			service:service,
			emergency_contact:emergency_contact,
			tariff_plan:tariff_plan,
			utility_provider_id:utility_provider_id,
			user_id:user_id
		}
		var data = JSON.stringify(utility);				
		url = "${pageContext.request.contextPath}/rest/utility/save";				
		$.ajax({
			url : url,
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			data : data,
			success : function(response, textStatus, jqXHR) {
				$("#responsive").modal("hide");
				$('#addUtility')[0].reset();
				$('#example').dataTable().fnDestroy();
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
	   return false;
	}else{
		return false;
	}	
		
});

function editUtility(id){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/utility/findById/"+id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.data){
				$("#id").val(response.data['id']);
				$("#utilityname").val(response.data['utility_provider_id']);						
				$("#account_no").val(response.data['account_no']);
				$("#service").val(response.data['service']);
				$("#emergency_contact").val(response.data['emergency_contact']);
				$("#tariff_plan").val(response.data['tariff_plan']);
				$("#customer_user_list").val(response.data['user_id']);
				$("#responsive").modal("show");
			}					
		},
		// callback handler that will be called on error
		error : function(jqXHR, textStatus, errorThrown) {

		}
  });
}	
function deleteUtility(id){
	if(confirm("Are you sure?")){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/utility/deleteutility/"+id,
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {
				$('#example').dataTable().fnDestroy();
				setTable();
			},
			// callback handler that will be called on error
			error : function(jqXHR, textStatus, errorThrown) {

			}
	  });
	}
}
</script>