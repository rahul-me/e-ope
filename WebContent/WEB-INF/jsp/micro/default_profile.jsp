<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
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
							<a href="${pageContext.request.contextPath}/rest/micro/list">
								Home
							</a>
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
									Add New <i class="fa fa-plus"></i>
								</button>										
							</div>
							
						</div>						
						<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>
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
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<jsp:include page="default_profile_modal.jsp"></jsp:include>
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
function loadProfile(){
	$('#example').dataTable({
        "serverSide": true,
        "bDestroy": true,
        "bFilter":false,
		"ajax" : "${pageContext.request.contextPath}/rest/micro/list_default_profile",
		"columns" : [{
					"data":"start_time"
				},{
					"data":"end_time"
				},{
					"data":null,
					"render":function(data,type,row){
						var data = '<button class="btn btn-primary btn-xs" onclick="editProfile('+row.id+')"><i class="glyphicon glyphicon-edit"></i></button>';
						//data += '&nbsp;<button class="btn btn-danger btn-xs" onclick="deleteProfile('+row.id+')"><i class="glyphicon glyphicon-trash"></i></button>';
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

</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>