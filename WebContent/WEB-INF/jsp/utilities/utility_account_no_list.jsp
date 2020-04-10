<select id="utility_account_no_list" class="form-control"></select>
<script>
function getUtilityAccountNolist(){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/utility/get_account_no_list_from_interval_data",
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.data){
				var data = response.data;
				var option = '';
				for(var i=0;i<data.length;i++){
					var text = data[i].split("/");
					var dt = new Date(eval(text[1]))
					console.log(text);
					console.log(dt);
					var new_date = dt.getFullYear()+"-"+(dt.getMonth()+1)+"-"+dt.getDate()+" "+dt.getHours()+":"+dt.getMinutes();
					option += '<option value="'+data[i]+'">'+text[0]+" / "+new_date+'</option>'; 
				}
				$("#utility_account_no_list").html(option);
			}					
		},
		// callback handler that will be called on error
		error : function(jqXHR, textStatus, errorThrown) {

		}
  });
}
$(document).ready(function(){
	getUtilityAccountNolist();
});
</script>