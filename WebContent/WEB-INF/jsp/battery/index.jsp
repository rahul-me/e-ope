<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
<div class="clearfix"></div>

<jsp:include page="../bootstrapheader/leftmenu.jsp"></jsp:include>
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					Battery Detail 
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li class="btn-group">
							<jsp:include page="../components/back_btn.jsp"></jsp:include>						
						</li>						
						<li>
							<i class="fa fa-home"></i>
							<a href="${pageContext.request.contextPath}/rest/micro/list">
								Home
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							Battery
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->			
			<div class="col-md-12" style="padding:0px;">
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							Battery
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="btn-group">
								<button id="addNewBattery" class="btn green">
									Add New <i class="fa fa-plus"></i>
								</button>										
							</div>							
						</div>						
						<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>									
									<th>IMAGE</th>
									<th>MANUFACTURE</th>
									<th>TECHNOLOGY</th>
									<th>ACTION</th>
								</tr>
							</thead>
						</table>					
					</div>
				</div>
			</div>
			<div class="clearfix"></div>			
		</div>		
	</div>	
	<!-- END CONTENT -->
</div>
<div class="clearfix"></div>

<div class="modal fade" id="battery_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="margin-left: 250px;">
		<div class="modal-content modal-lg">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title">Add Battery</h4>
			</div>
			<div class="modal-body">
				 <div class="row">
				 	<form class="form-horizontal" id="batteryfrm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/rest/battery/save" method="POST">
					    <input type="hidden" id="id_battery" name="id">
					    <div class="col-md-12">
					    	<div class="form-group">
					    		<label  class="control-label col-xs-2">Select MicroGrid</label>
					    		<div class="col-xs-10">
					    			<jsp:include page="../components/select_microgrid_id_list.jsp"></jsp:include>
					    		</div>
					    	</div>
					    </div>
					    <div class="col-md-6">
						    <div class="form-group">
						        <label for="inputPassword" class="control-label col-xs-4">Technology</label>
						        <div class="col-xs-8">
						           <input type="text" class="form-control" id="technology" name="technology" placeholder="Technology">
						        </div>
						    </div>
					    </div>
					    <div class="col-md-6">
						    <div class="form-group">
						        <label for="inputPassword" class="control-label col-xs-4">Manufacturer</label>
						        <div class="col-xs-8">
						           <input type="text" class="form-control" id="manufacturer" name="manufacture" placeholder="Manufacturer">
						        </div>
					        </div>
					    </div>	
					    <div class="col-md-12">
						    <div class="form-group">
						        <label for="inputPassword" class="control-label col-xs-2">Total Size</label>
						        <div class="col-xs-10">
						           <input type="text" class="form-control" id="total_size" name="total_size" placeholder="Total Size">
						        </div>
					        </div>
					    </div>					   
					    <div class="col-md-12">
						    <div class="form-group">
						        <label for="inputPassword" class="control-label col-xs-2">Battery Pic</label>
						        <div class="col-xs-10">
						           <div class="fileinput fileinput-new" data-provides="fileinput"><input type="hidden">
											<div class="input-group ">
												<div class="form-control uneditable-input span3" data-trigger="fileinput">
													<i class="fa fa-file fileinput-exists"></i>&nbsp;
													<span class="fileinput-filename">
													</span>
												</div>
												<span class="input-group-addon btn default btn-file">
													<span class="fileinput-new">
														 Select file
													</span>
													<span class="fileinput-exists">
														 Change
													</span>
													<input type="file" name="file" id="filename">
												</span>
												<a href="#" class="input-group-addon btn default fileinput-exists" data-dismiss="fileinput">
													 Remove
												</a>
											</div>
											<div id="edit_image_battery" style="display:none;">
												<a href="javascript:void(0);" id="remove_pic" onclick="remove_pic_battery();">Click here to remove Uploaded Pic </a>/
												<a href="" target="_blank" id="view_pic">View Pic</a>
											</div>
										</div>
						        </div>
					        </div>
					    </div>
					    <div class="col-md-12">
						    <div class="form-group">
						        <label for="inputPassword" class="control-label col-xs-2">No Of Rack</label>
						        <div class="col-xs-10">
						           <input type="number" class="form-control" id="no_of_rack" name="no_of_rack" placeholder="No of Rack">
						        </div>
					        </div>
					    </div>
					    <div class="col-md-12">
						    <div class="form-group">
						        <label for="inputPassword" class="control-label col-xs-2">Rack Description</label>
						        <div class="col-md-10">
						           <textarea id="rack_description" name="rack_description" class="wysihtml5 form-control" rows="6"></textarea>						           						          
						        </div>
					        </div>
					    </div>
					    
					    <div class="pull-right">
							<div class="col-md-12">
								<button type="submit" class="btn blue" id="save_battery">Save</button>
								<button type="button" class="btn default" data-dismiss="modal">Close</button>							
							</div>
						</div>
					</form>
				 </div>
			</div>
			
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- END CONTAINER -->
<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   Index.init();
   Index.initCharts(); // init index page's custom scripts
   Index.initMiniCharts();
   Index.initDashboardDaterange();
   Tasks.initDashboardWidget();
   getMicrogridList();
   ComponentsEditors.init();

   var options = {
	        beforeSend : function() {
	                $("#progressbox").show();
	                // clear everything
	                $("#progressbar").width('0%');
	                $("#message").empty();
	                $("#percent").html("0%");
	                var description = $("#rack_description").val();
	                console.log(description);
	        },
	        uploadProgress : function(event, position, total, percentComplete) {
	                $("#progressbar").width(percentComplete + '%');
	                $("#percent").html(percentComplete + '%');

	                // change message text to red after 50%
	                if (percentComplete > 50) {
	                $("#message").html("<font color='red'>File Upload is in progress</font>");
	                }
	        },
	        success : function() {
	                $("#progressbar").width('100%');
	                $("#percent").html('100%');	                
	        },
	        complete : function(response) {
	        	$('#batteryfrm')[0].reset();
	        	$("#battery_modal").modal("hide");
	        	setBatteryTable();
	        	return false;
	        },
	        error : function() {
	        	alert("error");
	        }
	};
   $("#batteryfrm").ajaxForm(options);	
   setBatteryTable();
});



$("#addNewBattery").click(function(){
	$("#edit_image_battery").hide();
	$("#battery_modal").modal("show");
});

function setBatteryTable(){
	
	$('#example').dataTable({
        "serverSide": true,
        "bDestroy": true,
		"ajax" : "${pageContext.request.contextPath}/rest/battery/list",
		"columns" : [
				{
					"data" : null,
					"render": function(data,type,row){
						var data = '<img src="https://drive.google.com/uc?export=view&id='+row.batteryPic+'" height=50 width=50>';
						return data;
					}
				},{
					"data":"manufacture"
				},{
					"data":"technology"
				},{
					"data":null,
					"render":function(data,type,row){
						var data = '<button type="button" class="btn btn-primary btn-xs" onclick="editBattery('+row.id+')"><i class="glyphicon glyphicon-edit"></i></button>';
						data += '&nbsp;<button type="button" class="btn btn-danger btn-xs" onclick="deleteBattery('+row.id+')"><i class="glyphicon glyphicon-trash"></i></button>';
						
						return data;
					}
				}
				],
				tableTools: {
		            "aButtons": [
		                "copy",
		                "csv",
		                "xls",
		                {
		                    "sExtends": "pdf",
		                    "sPdfOrientation": "landscape",
		                    "sPdfMessage": "Your custom message would go here."
		                },
		                "print"
		            ]
		        },
				
			"fnDrawCallback": function( oSettings ) {
				$(".test").bootstrapToggle('destroy')
				$(".test").bootstrapToggle({
					"on" : "Active",
					"off" : "De-Active",
					"size":"mini",
					"onstyle":"success",
					"offstyle":"danger"
				});
			}
	});	
	
	
}
function remove_pic_battery(){
	var id = $("#id_battery").val();
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/battery/removepic/"+id,
		type : "get",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
		  	if(response.status==true){
		  		toastr.success('Image delete successfuly.!');
		  		$("#edit_image").hide();
		  		showBattery();
		  	}
		}
    });
}
function editBattery(id){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/battery/findById/"+id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			var data = response.data;
			if (data) {
				$("#id_battery").val(data['id']);							
				$("#manf").html(data['manufacture']);
				$("#tech").html(data['technology']);
				if(data['batteryPic']){
					$("#edit_image_battery").show();
				}else{
					$("#edit_image_battery").hide();
				}
				$("#no_of_rack").val(data['no_of_rack']);
				console.log(data['rack_description']);
				var editorObj = $("#rack_description").data('wysihtml5');
				var editor = editorObj.editor;
				editor.setValue(data['rack_description']);
				$("#microgrid_list").val(data['microgrid_id']);
				$("#manufacturer").val(data['manufacture']);
				$("#technology").val(data['technology']);	
				$("#total_size").val(data['total_size']);
				$("#battery_modal").modal("show");
			}
		},
		error:function(data){
			
		}
	});
}
function deleteBattery(id){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/battery/delete/"+id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			setBatteryTable();
		},
		error:function(data){
			
		}
	});
}
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>