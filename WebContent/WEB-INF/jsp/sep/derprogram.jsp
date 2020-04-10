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
			
			<input type="hidden" id="endDeviceId" value="${endDeviceId}"/>
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					DERPrograms <small></small>
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
							<a href="#">
								DERPrograms
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
							DERPrograms
						</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding:0px;">
								<button id="addNewderp" class="btn green">
									Add New DERProgram <i class="fa fa-plus"></i> 
								</button>																									
							</div>							
						</div>		
						<div style="height:10px;clear:both;"></div>				
						<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>									
									<th>PrimacyType</th>
									<th>MRID</th>
									<th>Description</th>
									<th>Version</th>
									<th>Actions</th>
									<th>Configure DERControl</th>
									<th>Configure DERCurve</th>
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


<!-- 	add derprogram modal -->
	<div id="responsive" class="modal fade" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-body">
					<form class="form-horizontal" id="addderp">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">DERProgram</h4>
						</div>
						<div style="height: 15px; clear: both;"></div>
						<input type="hidden" id="derProgramId" name="derProgramId">
						<input type="hidden" id="version" name="version">
						<!-- <div class="form-group">
							<label for="inputuserid" class="col-lg-4 control-label">User ID</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="userid"
									placeholder="User ID">
							</div>
						</div> -->
						<div class="form-group">
							<label for="inputprimacy" class="col-lg-4 control-label">Primacy</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="primacy"
									placeholder="Primacy">
							</div>
						</div>						
						<div class="form-group">
							<label for="inputdescr" class="col-lg-4 control-label">Description</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="descr"
									placeholder="Description">
							</div>
						</div>				
						<div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn default">Close</button>
							<button type="button" id="saveDerp" class="btn green">Save changes</button>
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>

	<!-- end derprogram modal -->



<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<script>
jQuery(document).ready(function() {    
   App.init();
   setTable();
});

$("#addNewderp").click(function(){
	$('#addderp')[0].reset();
	$("#derProgramId").val("");
	$("#version").val("0");
	$("#responsive").modal("show");
});

function setTable(){
	var url = "${pageContext.request.contextPath}/rest/sep/derprograms/list";
	var endDeviceId = $("#endDeviceId").val();
	if( endDeviceId != 0){
		url = "${pageContext.request.contextPath}/rest/sep/derprograms/list/"+endDeviceId;
	}
	$('#example').dataTable({
        "serverSide": true,
        "bDestroy": true,
		"ajax" : url,
		"columns" : [
				{
					"data" : "primacy"
				},
				{
					"data" : "m_rid"
				},
				{
					"data" : "description"
				},
				{
					"data" : "version"
				},
				{
					"data":null,
					"render" : function(data,type,row){
						//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
						var data = "&nbsp;<button type='button' onclick='deleteDerp("+row.id+");' class='btn btn-danger btn-xs'><i class='fa fa-trash-o'></i></button>"  + 
						 "&nbsp;<button type='button' onclick='editDerp("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
						return data;
					},
				},
				{
					"data": null,
					"render": function(data, type, row){
						var data = "&nbsp;<button type='button' onclick='addDerControl("+row.id+");' title='Add Der Control' class='btn btn-info btn-xs'><i class='fa fa-cog'></i></button>";
						return data;
					}
				},
				{
					"data": null,
					"render": function(data, type, row){
						var data =  "&nbsp;<button type='button' onclick='addDerCurve("+row.id+");' title='Add Der Curve' class='btn btn-success btn-xs'><i class='fa fa-cog'></i></button>";
						return data;
					}
				}]
				
	});	
}

$("#saveDerp").click(function(){
	
		var data = '';
		var userid = $.cookie("userid");
		var primacy = $("#primacy").val();		
		var descr = $("#descr").val();
		var version = $("#version").val();
		var url = "";
		
		var obj = new Object();
		obj.id = $("#derProgramId").val();
		obj.user_id = userid;
		obj.primacy = primacy;		
		obj.description = descr;
		obj.version = version;
		//data = '{"id":"'+$("#id").val()+'","user_id":"'+userid+'","primacy":'+primacy+',"m_rid":"'+mrid+'","description":"'+descr+'","version":'+versn+'}';
		
		url = "${pageContext.request.contextPath}/rest/sep/derprograms/save";
		$.ajax({
			url : url,
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			data : JSON.stringify(obj),
			success : function(response, textStatus, jqXHR) {
				if(response.status==false){
					toastr.error(response.message);
				}else{		
					$("#responsive").modal("hide");
					$('#addderp')[0].reset();
					$('#example').dataTable().fnDestroy();
					toastr.success("DERProgram save.!");
					setTable();
				}	
			},
			// callback handler that will be called on error
			error : function(jqXHR, textStatus, errorThrown) {

			}
	   });
	
});


function editDerp(id){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/sep/derprograms/edit/"+id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.data){
				$("#derProgramId").val(response.data['id']);
				$("#userid").val(response.data['user_id']);
				$("#primacy").val(response.data['primacy']);				
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

function deleteDerp(id){
	if(confirm("Are you sure?")){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/sep/derprograms/delete/"+id,
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

function addDerControl(){
	var id = arguments[0];
	window.location.href = "${pageContext.request.contextPath}/rest/sep/derprograms/"+id+"/derc"
}

function addDerCurve(){
	var derpId = arguments[0];
	window.location.href = "${pageContext.request.contextPath}/rest/derp/"+derpId+"/dc/page"
}
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
