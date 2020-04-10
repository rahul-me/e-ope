<select id="userRollList" class="form-control" name="userRollList">
</select>
<script>
function getRollSelect(){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/role/rolllist",
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.maprole){
				var option = '';
				for(var i=0;i<response.maprole.length;i++){
					option += '<option value="'+response.maprole[i]['id']+'">'+response.maprole[i]['role']+'</option>';
				}
				$("#userRollList").append(option);
			}
		},
		// callback handler that will be called on error
		error : function(jqXHR, textStatus, errorThrown) {

		}
	});
}
</script>