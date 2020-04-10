<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>

<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<jsp:include page="../bootstrapheader/leftmenu.jsp"></jsp:include>
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
							<h4 class="modal-title">Modal title</h4>
						</div>
						<div class="modal-body">
							 Widget settings form goes here
						</div>
						<div class="modal-footer">
							<button type="button" class="btn blue">Save changes</button>
							<button type="button" class="btn default" data-dismiss="modal">Close</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					FunctionSet <small></small>
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="index.html">
								Home
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/rest/sep/devices/index">
								Devices
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">
								FunctionSet
							</a>
						</li>
						<li class="pull-right">
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN DASHBOARD STATS -->
			
			<!-- END DASHBOARD STATS -->
			<div class="clearfix">
			</div>
			<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							FunctionSet
						</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding:0px;">
								<button id="addNewFunctionSet" class="btn green">
									Add New FunctionSet <i class="fa fa-plus"></i> 
								</button>																									
							</div>							
						</div>		
						<div style="height:10px;clear:both;"></div>				
						<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>											
									<th>MRID</th>
									<th>DESCRIPTION</th>									
									<th>SERVICE</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			<div class="clearfix">
			</div>
			
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->


<!-- 	add device modal -->
	<div id="responsive" class="modal fade" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-body">
					<form class="form-horizontal" id="addFunctionSet">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">FunctionSet</h4>
						</div>
						<div style="height: 15px; clear: both;"></div>
						<input type="hidden" id="id" name="id">
						<input type="hidden" id="version" name="version"/>						
						<input type="hidden" id="deviceId" name="deviceId" value="${deviceId}">												
						<div class="form-group">
							<label for="inputdesc" class="col-lg-4 control-label">Description</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="descr"
									placeholder="Description">
							</div>
						</div>										
						<div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn default">Close</button>
							<button type="button" id="saveFunctionSet" class="btn green">Save changes</button>
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>

	<!-- end device modal -->



<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<script>
jQuery(document).ready(function() {    
   App.init();
   setTable();
});

$("#addNewFunctionSet").click(function(){
	$('#addFunctionSet')[0].reset();
	$("#id").val("");
	$("#version").val("0");
	$("#responsive").modal("show");
});

function setTable(){
	var deviceId = $("#deviceId").val();
	$('#example').dataTable({
        "serverSide": true,
        "bDestroy": true,
		"ajax" : "${pageContext.request.contextPath}/rest/sep/devices/"+deviceId+"/addfunction/list",
		"columns" : [				
				{
					"data" : "m_rid"
				},
				{
					"data" : "description"
				},
				{
					"data":null,
					"render" : function(data,type,row){
						//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
						var data = "&nbsp;<button type='button' onclick='deleteFunctionSet("+row.id+");' class='btn btn-danger btn-xs'><i class='fa fa-trash-o'></i></button>"  + 
						 "&nbsp;<button type='button' onclick='editFunctionSet("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
						return data;
					},
				}]
				
	});	
}

$("#saveFunctionSet").click(function(){
	//console.log("valid = "+$("#addsaveFunctionSet").valid());
	//if($("#addsaveFunctionSet").valid()){
		var data = '';
		var userid = $.cookie("userid");			
		var deviceId = $("#deviceId").val();
		var descr = $("#descr").val();
		var url = "";
		var id = $('#id').val();
		var version = $('#version').val();
		//data = '{"device":'+deviceId+',"user_id":"'+userid+'","m_rid":"'+mrid+'","description":"'+descr+'","f_all":'+all+'}';
		//data = {"device_id":{"id": eval(deviceId) },"user_id":userid,"m_rid":mrid,"description":descr }
		
		var obj = new Object();
		var device = new Object();
		device.id = eval(deviceId);
		obj.device_id = device;
		obj.user_id = userid;
		obj.description = descr;
		obj.id = id;
		obj.version = version;
		
		url = "${pageContext.request.contextPath}/rest/sep/devices/"+deviceId+"/addfunction/save";
		
		$.ajax({
			url : url,
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			data : JSON.stringify(obj),
			success : function(response, textStatus, jqXHR) {
				if(response.status==true){					
					$("#responsive").modal("hide");
					$('#addFunctionSet')[0].reset();
					$('#example').dataTable().fnDestroy();
					toastr.success("FunctionSet save.!");
					setTable();					
				}else{							
					toastr.error(response.message);
				}
			},
			// callback handler that will be called on error
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error(jqXHR.message);
			}
	   });
		
});


function editFunctionSet(id){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/sep/devices/"+id+"/addfunction/edit/"+id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.data){
				$("#id").val(response.data['id']);
				$("#userid").val(response.data['user_id']);			
				$("#descr").val(response.data['description']);				
				$("#version").val(response.data['version']);
				$("#responsive").modal("show");				
			}					
		},
		// callback handler that will be called on error
		error : function(jqXHR, textStatus, errorThrown) {

		}
  });
}
	
function deleteFunctionSet(id){
	if(confirm("Are you sure?")){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/sep/devices/"+deviceId+"/addfunction/delete/"+id,
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
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
