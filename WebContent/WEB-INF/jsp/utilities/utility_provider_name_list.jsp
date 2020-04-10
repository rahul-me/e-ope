<select name="name" id="utilityname" class="form-control">					            
</select>
<script>
function getUtilityProvider(){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/utility/utilityproviderlist/",
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.data){
				var data = response.data;
				var option = '';
				for(var i=0;i<data.length;i++){
					option += '<option value="'+data[i]['id']+'">'+data[i]['utilityName']+'</option>'; 
				}
				$("#utilityname").html(option);
			}					
		},
		// callback handler that will be called on error
		error : function(jqXHR, textStatus, errorThrown) {

		}
  });
}	
</script>