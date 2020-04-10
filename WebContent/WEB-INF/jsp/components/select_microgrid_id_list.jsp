<select id="microgrid_list" name="microgrid_id" class="form-control" ></select>
<script>
function getMicrogridList(){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro/getlist",
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.data){
				var option = '';
				for(var i=0;i<response.data.length;i++){
					option += '<option value="'+response.data[i]['microgrid_id']+'">'+response.data[i]['microgrid_name']+'</option>';
				}
				$("#microgrid_list").append(option);
			}
		},
		// callback handler that will be called on error
		error : function(jqXHR, textStatus, errorThrown) {
			
		}
	});
}
</script>