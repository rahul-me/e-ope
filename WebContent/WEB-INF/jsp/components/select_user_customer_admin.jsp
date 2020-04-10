<select id="customer_user_list" class="form-control"></select>
<script>
function getCustomerAdmin(){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/users/listcustomeradmin",
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.data){
				var option = '';
				for(var i=0;i<response.data.length;i++){
					option += '<option value="'+response.data[i]['id']+'">'+response.data[i]['email']+'</option>';
				}
				$("#customer_user_list").html(option);
			}
		},
		// callback handler that will be called on error
		error : function(jqXHR, textStatus, errorThrown) {

		}
	});
}

</script>