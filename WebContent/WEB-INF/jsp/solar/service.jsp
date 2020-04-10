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
	<div class="clearfix"></div>
		<div class=" clearfix page-content">
		<div class="clearfix"></div>
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					Solar Service 
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
							Solar Service
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
									Fetch data from solar service
								</button>										
							</div>
							
						</div>						
						<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>									
									<th>STATION ID</th>
									<th>DATETIME</th>
									<th>GHI</th>
									<th>POA</th>
									<th>PWR</th>
								</tr>
							</thead>
						</table>
						<div class="clearfix"></div>
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
   setSolarTable();
});
$("#addNewSolar").click(function(){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/solar/f_read_ftp/",
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			
		},
		error:function(data){
			
		}
	});
});

function setSolarTable(){
	
	$('#example').dataTable({
        "serverSide": false,
        "bDestroy": false,
		"ajax" : "${pageContext.request.contextPath}/rest/solar/servicelist",
		"columns" : [
				{
					"data" : "station_id"
				},{
					"data":null,
					"render": function(data,type,row){
						var data = new Date(row.datetime);
						data = data.getFullYear()+"-"+(data.getMonth()+1)+"-"+data.getDate()+" "+data.getHours()+":"+data.getMinutes();
						return data;
					}
				},{
					"data":"ghi"
				},{
					"data": "poa"
				},{
					"data": "pwr"
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