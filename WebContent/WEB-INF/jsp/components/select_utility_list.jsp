<select id="utilityList" name="utilityId" class="form-control"></select>
<script>
function getUtilityList(){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/utility/list",
		type : "get",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
		  	if(response.data){
		  		var option = "";
		  		for(var i=0;i<response.data.length;i++){
		  			option += "<option value='"+response.data[i]['id']+"'>"+response.data[i]['name']+" / "+response.data[i]['account_no']+"</option>";
		  		}
		  		$("#utilityList").html(option);
		  	}else{
		  		$("#utilityList").html("");
		  	}
		}
    });
}
</script>