<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<%-- <jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include> --%>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<style>
.span{
color:black !important;
font-weight:600 !important;
}
</style>
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
					<h3 class="page-title" id="title">
					Profile Management 
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li class="btn-group">
							<jsp:include page="../components/back_btn.jsp"></jsp:include>														
						</li>
						<li>
							<i class="fa fa-home"></i>
							<a href="${pageContext.request.contextPath}/rest/micro/locationMap">
								Home
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/rest/micro/list">Micro Grid Configured</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="#">
								Profile Management
							</a>
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<div class="clearfix">
			</div>
			<div class="row">								
				<div class="col-md-12">
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							Profile
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="btn-group">
								<button id="add_new_profile" class="btn green">
									<i class="fa fa-plus"></i> Add New 
								</button>																	
							</div>
							<div class="btn-group">
								<button id="set_standard_profile" onclick="setStandarProfile();" class="btn yellow">
									<i class="fa fa-cog"></i> Set Standard Profile
								</button>																
							</div>
							<div class="btn-group">
								<button id="send_profile_to_client" class="btn blue">
									<i class="fa fa-upload"></i> Send Profile to Micro Grid 
								</button>																
							</div>
							<div class="btn-group">
								<button id="showingraph" class="btn btn-info">
									<i class="fa fa-info-circle"></i> Details
								</button>																
							</div>
						</div>						
						<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>									
									<th>MICROGRID ID</th>
									<th>START TIME</th>
									<th>END TIME</th>
									<th>ACTION</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>

<!-- END CONTAINER -->
<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>

<jsp:include page="profile_management_modal.jsp"></jsp:include>
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   Index.init();
   Index.initCharts(); // init index page's custom scripts
   Index.initMiniCharts();
   Index.initDashboardDaterange();
   Tasks.initDashboardWidget();
   ComponentsPickers.init();
   loadProfile();  
});

$('#profile_management_modal').on('hidden.bs.modal', function() {	
	$('.select2-drop').css("display","none");
});
function loadProfile(){
	var microgrid_id = getMicroGridIdFromUrl();
	$('#example').dataTable({
        "serverSide": true,
        "bDestroy": true,
        "bFilter":false,
		"ajax" : "${pageContext.request.contextPath}/rest/micro/find_profile_list_by_microgrid_id/"+microgrid_id,
		"columns" : [
				{
					"data":"microgrid_id","width": "20%"
				},{
					"data":"start_time","width": "20%"
				},{
					"data":"end_time","width": "20%"
				},{
					"data":null,"width": "20%",
					"render":function(data,type,row){
						var data = '<button class="btn btn-primary btn-xs" onclick="editProfile('+row.id+')"><i class="glyphicon glyphicon-edit"></i> Edit</button>';
						//data += '&nbsp;<button class="btn btn-danger btn-xs" onclick="deleteProfile('+row.id+')"><i class="glyphicon glyphicon-trash"></i></button>';
						//data += '&nbsp;<button class="btn btn-warning btn-xs" onclick="setStandarProfile('+row.id+')">Set Standar Profile</button>';
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
function setStandarProfile(){	
	var microgrid_id = getMicroGridIdFromUrl();
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro/set_standar_profile/"+microgrid_id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {		
			if(response.status==true){
				toastr.success(response.message);
				loadProfile();
			}
		}
    });
}
$("#send_profile_to_client").click(function(){
	var microgrid_id = getMicroGridIdFromUrl();
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro/send_profile_to_microgrid_client/"+microgrid_id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {		
			if(response.status==true){
				if(response.error==false){
					toastr.success(response.message);
				}else{
					toastr.warning(response.message);
				}
								
			}
		}
    });
});

$('#showingraph').on('click', function(){
	var microgrid_id = getMicroGridIdFromUrl();
	window.location.href = '${pageContext.request.contextPath}/rest/micro/profileg/nd/'+microgrid_id;
});
</script>

<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>