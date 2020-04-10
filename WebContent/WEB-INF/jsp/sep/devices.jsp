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
					Devices <small></small>
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
						</li>
						<li class="pull-right">
								<li class="btn-group">
								<button type="button" id="downloadPublicCertificate"
									style="background: #4d90fe; color: white;" class="btn" title="Download Server's Public Certificate">
									Server's Certificate</button>
									</li>
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
							Devices
						</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding:0px;">
								<button id="addNewUtility" class="btn green">
									Add New Device <i class="fa fa-plus"></i> 
								</button>																									
							</div>							
						</div>		
						<div style="height:10px;clear:both;"></div>				
						<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>																		
									<th>SFDI</th>
									<th>Device Category Type</th>
									<th>Operation</th>
									<th>Configure Function Set</th>
									<th>Configure DER</th>
									<th>Subscribed DERPrograms</th>
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
					<form class="form-horizontal" id="addDevice">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">Device</h4>
						</div>
						<div style="height: 15px; clear: both;"></div>
						<input type="hidden" id="id" name="id">						
						<!--  <div class="form-group">
							<label for="inputsfId" class="control-label col-xs-3">SFDI
								<label style="color: red;">*</label>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="sfdi"
									placeholder="SFDI">
							</div>
						</div>-->
						<!-- <div class="form-group">
							<label for="inputuserid" class="col-lg-4 control-label">User ID</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="userid"
									placeholder="User ID">
							</div>
						</div> -->
						<div class="form-group">
							<label for="inputsfdi" class="col-lg-4 control-label">SFDI</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="sfdi"
									placeholder="SFDI">
							</div>
						</div>
						<div class="form-group">
							<label for="inputsfdi" class="col-lg-4 control-label">PIN</label>
							<div class="col-lg-8">
								<input type="number" class="form-control" id="pin" placeholder="pin">
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputdevicecat" class="col-lg-4 control-label">Device Category Type</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="devicecattype"
									placeholder="Device Category Type">
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn default">Close</button>
							<button type="submit" id="saveDevice" class="btn green">Save changes</button>
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

$("#addNewUtility").click(function(){
	console.log($('#addDevice'));
	$('#addDevice')[0].reset();
	$("#id").val("");
	$("#pin").val("");
	$("#version").val("0");
	
	$("#responsive").modal("show");
});

function setTable(){
	$('#example').dataTable({
        "serverSide": true,
        "bDestroy": true,
		"ajax" : "${pageContext.request.contextPath}/rest/sep/devices/list",
		"columns" : [				
				{
					"data" : "s_fdi"
				},
				{
					"data" : "device_category_type"
				},
				{
					"data":null,
					"render" : function(data,type,row){
						//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
						var data = "&nbsp;<button type='button' onclick='deleteDevice("+row.id+");' class='btn btn-danger btn-xs'><i class='fa fa-trash-o'></i></button>"  + 
						 "&nbsp;<button type='button' onclick='editDevice("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
						return data;
					},
				},
				{
					"data":null,
					"render" : function(data,type,row){
						//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
						var data = "&nbsp;<button type='button' onclick='addFunction("+row.id+");' title='Add FunctionSet' class='btn btn-success btn-xs'><i class='fa fa-cog'></i></button>";
						return data;
					},
				},
				{
					"data":null,
					"render" : function(data,type,row){
						//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
						var data = "&nbsp;<button type='button' onclick='addDER("+row.id+");' title='Add DER' class='btn btn-info btn-xs'><i class='fa fa-cog'></i></button>";
						return data;
					},
				},
				{
					"data":null,
					"render" : function(data,type,row){
						//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
						var data = "&nbsp;<button type='button' onclick='showAssociatedDERProgram("+row.id+");' title='Associated DERProgram' class='btn btn-warning btn-xs'><i class='fa fa-cog'></i></button>";
						return data;
					},
				}]
				
	});	
}

$("#saveDevice").click(function(){
	//console.log("valid = "+$("#addDevice").valid());
	//if($("#addDevice").valid()){
		var data = '';
		var userid = $.cookie('userid');
		var sfdi = $("#sfdi").val();
		var pin = $("#pin").val();		
		//var userName = $("#userName").val();
		var devicecattype = $("#devicecattype").val();
		var url = "";
		
		if($("#id").val()!=""){
			data = '{"id":"'+$("#id").val()+'","user_id":"'+userid+'","s_fdi":"'+sfdi+'","device_category_type":"'+devicecattype+'","pin":'+pin+'}';	
		}else{
			data = '{"user_id":"'+userid+'","s_fdi":"'+sfdi+'","device_category_type":"'+devicecattype+'","pin":'+pin+'}';
		}
		url = "${pageContext.request.contextPath}/rest/sep/devices/save";
		$.ajax({
			url : url,
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			data : data,
			success : function(response, textStatus, jqXHR) {
				console.log(response);
				if(response.status==false){
					toastr.error(response.message);
				}else{							
					$('#example').dataTable().fnDestroy();
					toastr.success("Device save.!");
					setTable();
				}
				$("#responsive").modal("hide");
				$('#addDevice')[0].reset();
				
			},
			// callback handler that will be called on error
			error : function(jqXHR, textStatus, errorThrown) {

			}
	   });
	   return false;
	/*}else{
		return false;
	}	*/
		
});


function editDevice(id){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/sep/devices/edit/"+id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {		
			if(response.data){
				$("#id").val(response.data['id']);			
				$("#sfdi").val(response.data['s_fdi']);
				$("#pin").val(response.data['pin']);				
				$("#devicecattype").val(response.data['device_category_type']);
				$("#responsive").modal("show");
			}					
		},
		// callback handler that will be called on error
		error : function(jqXHR, textStatus, errorThrown) {

		}
  });
}
	
	function addFunction(id){
		window.location = id+"/addfunction/index";
		/*$.ajax({
			url : "${pageContext.request.contextPath}/rest/sep/devices/"+id+"/addfunction/",
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {
								
			},
			// callback handler that will be called on error
			error : function(jqXHR, textStatus, errorThrown) {

			}
	  });*/
	}

function deleteDevice(id){
	if(confirm("Are you sure?")){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/sep/devices/delete/"+id,
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

$('#downloadPublicCertificate').on('click', function(){
	window.location.href = '${pageContext.request.contextPath}/rest/sep/certi/download';
});

function addDER(){
	var endDeviceId = arguments[0];
	window.location.href = '${pageContext.request.contextPath}/rest/edev/'+endDeviceId+'/der/page';
}

function showAssociatedDERProgram(){
	var endDeviceId = arguments[0];
	window.location.href = "${pageContext.request.contextPath}/rest/sep/derprograms/index/"+endDeviceId;	
}
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
