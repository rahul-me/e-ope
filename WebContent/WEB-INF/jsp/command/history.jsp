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
					
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${pageContext.request.contextPath}/rest/home/currentstatus/${id}">
								Home
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/rest/home/currentstatus/${id}">
								Micro Grid
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							Command History
						</li>
						<li class="btn-group">
							<jsp:include page="../components/back_btn.jsp"></jsp:include>							
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<div class="clearfix">
			</div>
			<div class="row">								
				<div class="col-md-12" style="padding-top:10px;">
					<div class="portlet box grey">
						<div class="portlet-title"><div class="caption">Command History</div></div>
						<div class="portlet-body">
							<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
								<thead>
									<tr>									
										<th>METHOD</th>
										<th>MIROGRID ID</th>
										<th>REQUEST ID</th>
										<th>STATE</th>
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
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   Index.init();
   Index.initCharts(); // init index page's custom scripts
   Index.initMiniCharts();
   Index.initDashboardDaterange();
   Tasks.initDashboardWidget();
   setTable();
   showData();
   setInterval(function(){showData()}, 1000*2);
});

function showData(){
	var microgrid_id = $.cookie("microgrid_id");
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro/findbymicrogridid/"+microgrid_id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			if(response.data){
				if(response.status==true){
					$("#title").html(response.data.microgrid_name+"&nbsp;<button class='btn-sm btn btn-success'>on-line</button>");
				}else{
					$("#title").html(response.data.microgrid_name+"&nbsp;<button class='btn-sm btn btn-danger'>off-line</button>");
					$(".command").attr("disabled","disabled");
				}
			}
		},
		error:function(data){
			
		}
	});
		
}

function setTable(){
	$('#example').dataTable({
        "serverSide": false,
        "bDestroy": true,
		"ajax" : "${pageContext.request.contextPath}/rest/command/gethistorylist",
		"order": [[ 0, "desc" ]],
		"columns" : [
			{
				"data" : "method_number"
			},{
				"data":"micro_grid_id"
			},{
				"data":"request_id"
			},{
				"data":"state",					
			}
		]			
	});	
}
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>