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
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					Solar Detail 
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
							Solar
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<div class="clearfix">
			</div>			
			<div class="col-md-12" style="padding:0px;">
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							Solar
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="btn-group">
								<button id="addNewSolar" class="btn green">
									Add New <i class="fa fa-plus"></i>
								</button>										
							</div>							
						</div>						
						<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>									
									<th>IMAGE</th>
									<th>TOTAL SIZE</th>
									<th>NO OF SOLAR PANEL</th>
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
<div class="modal fade" id="solar_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width:70%;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title">Add Solar</h4>
			</div>
			<div class="modal-body">
				 <div class="row">
				 	<form class="form-horizontal" id="solarfrm" enctype="multipart/form-data" action="${pageContext.request.contextPath}/rest/solar/save" method="POST">
					    <input type="hidden" id="id_solar" name="id">
					    <input type="hidden" id="microgrid_id" name="microgrid_id">
					    <div class="col-md-12">
					    	<div class="form-group">
					    		<label  class="control-label col-xs-2">Select MicroGrid</label>
					    		<div class="col-xs-10">
					    			<jsp:include page="../components/select_microgrid_id_list.jsp"></jsp:include>
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
						        <label for="inputPassword" class="control-label col-xs-2">Solar Pic</label>
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
											<div id="edit_image_solar" style="display:none;">
												<a href="javascript:void(0);" id="remove_pic" onclick="remove_pic_battery();">Click here to remove Uploaded Pic </a>/
												<a href="" target="_blank" id="view_pic">View Pic</a>
											</div>
										</div>
						        </div>
					        </div>
					    </div>
					    <div class="col-md-12">
						    <div class="form-group">
						        <label for="inputPassword" class="control-label col-xs-2">No Of Solar Panel</label>
						        <div class="col-xs-10">
						           <input type="number" class="form-control" id="no_of_solar_panel" name="no_of_solar_panel" placeholder="No of solar panel">
						        </div>
					        </div>
					    </div>
					    <div class="col-md-12">
					    	<div class="form-group">
					    		<label class="control-label col-xs-2">Station Identification</label>
					    		<div class="col-xs-10">
					    			<input type="text" class="form-control" id="station_id" name="station_id" placeholder="Enter Identification of Solar Station"/>
					    		</div>
					    	</div>
					    </div>
					    <div class="col-md-12">
						    <div class="form-group">
						        <label for="inputPassword" class="control-label col-xs-2">Solar Panel Description</label>
						        <div class="col-md-10">
						           <textarea id="solar_panel_description" name="solar_panel_description" class="wysihtml5 form-control" rows="6"></textarea>						           						          
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
	                var microgrid_id = $("#microgrid_list").val();
	                $("#microgrid_id").val(microgrid_id);
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
	        	$('#solarfrm')[0].reset();
	        	$("#solar_modal").modal("hide");
	        	setSolarTable();
	        	return false;
	        },
	        error : function() {
	        	alert("error");
	        }
	};
   $("#solarfrm").ajaxForm(options);	
   setSolarTable();
});



$("#addNewSolar").click(function(){
	$("#edit_image_solar").hide();
	$("#solar_modal").modal("show");
});

function setSolarTable(){
	
	$('#example').dataTable({
        "serverSide": true,
        "bDestroy": true,
		"ajax" : "${pageContext.request.contextPath}/rest/solar/list",
		"columns" : [
				{
					"data" : null,
					"render": function(data,type,row){
						var data = '<img src="https://drive.google.com/uc?export=view&id='+row.solar_pic+'" height=50 width=50>';
						return data;
					}
				},{
					"data":"total_size"
				},{
					"data":"no_of_solar_panel"
				},{
					"data":null,
					"render":function(data,type,row){
						var data = '<button type="button" class="btn btn-primary btn-xs" onclick="editSolar('+row.id+')"><i class="glyphicon glyphicon-edit"></i></button>';
						data += '&nbsp;<button type="button" class="btn btn-danger btn-xs" onclick="deleteSolar('+row.id+')"><i class="glyphicon glyphicon-trash"></i></button>';
						
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
	var id = $("#id_solar").val();
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/solar/removepic/"+id,
		type : "get",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
		  	if(response.status==true){
		  		toastr.success('Image delete successfuly.!');
		  		$("#edit_image_solar").hide();
		  		setSolarTable();
		  	}
		}
    });
}
function editSolar(id){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/solar/findbyid/"+id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			var data = response.data;
			if (data) {
				$("#id_solar").val(data['id']);							
				$("#total_size").val(data['total_size']);
				$("#no_of_solar_panel").val(data['no_of_solar_panel']);
				if(data['solar_pic']){
					$("#edit_image_solar").show();
					$("#view_pic").attr("href","https://drive.google.com/uc?export=view&id="+data['solar_pic']);
				}else{
					$("#edit_image_solar").hide();
				}				
				var editorObj = $("#solar_panel_description").data('wysihtml5');
				var editor = editorObj.editor;
				editor.setValue(data['solar_panel_description']);				
				$("#microgrid_list").val(data['microgrid_id']);
				$("#solar_modal").modal("show");
			}
		},
		error:function(data){
			
		}
	});
}
function deleteSolar(id){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/solar/delete/"+id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			setSolarTable();
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