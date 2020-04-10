<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<!-- END HEAD -->
<!-- BEGIN BODY -->

<body class="page-header-fixed">
	<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
	<div class="clearfix"></div>
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
						<h3 class="page-title">Utility</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li>
								<i class="fa fa-home"></i> 
								<a href="${pageContext.request.contextPath}/rest/utility/provider">Utility Provider</a> 
								<i class="fa fa-angle-right"></i></li>
							<li>
							<li>
								<a href="${pageContext.request.contextPath}/rest/utility/${id}/break_down">Utility Break Down</a> 
								<i class="fa fa-angle-right"></i></li>
							<li>
							<a href="#"> Utility Rate</a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							Utility Rate
						</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding:0px;">																
								<button id="add_utility_rate" class="btn">
									Add Utility Rate
								</button>										
							</div>							
						</div>		
						<div style="height:10px;clear:both;"></div>				
						<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>		
									<th>UTILITY PROVIDER</th>							
									<th>BREAK DOWN</th>
									<th>GENERATION</th>
									<th>START TIME</th>
									<th>END TIME</th>									
									<th>RATE</th>									
									<th>ACTIONS</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
	<!-- END CONTAINER -->	
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
	<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
	<jsp:include page="modal_utility_rate.jsp"></jsp:include>
	<!-- END JAVASCRIPTS -->	
	<script>
		jQuery(document).ready(function() {    
		   App.init(); 
		   Index.init();
		   ComponentsPickers.init();
		   setTable();
		   getBreakDownAndUtilityProviderDetail();
		});
		function setTable(){
			$('#example').dataTable({
		        "serverSide": false,
		        "bDestroy": true,
				"ajax" : "${pageContext.request.contextPath}/rest/utility/list_utility_rate",
				"columns" : [
						{
							"data":'utility_provider'
						},{
							"data":'utility_break_down_season'
						},{
							"data" : "generation"
						},{
							"data":"startTime"
						},{
							"data":"end_time"
						},{
							"data":"rate"
						},{
							"data":null,
							"render" : function(data,type,row){								
								//var	data = "<button type='button' title='Edit Utility' onclick='editUtility("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
								var data = "<button type='button' title='Edit Utility' onclick='editUtilityRate("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
								data += "&nbsp;<button type='button' title='Delete Utility' onclick='deleteUtilityRate("+row.id+");' class='btn btn-danger btn-xs'><i class='fa fa-trash-o'></i></button>";
								
								return data;
							},
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
		function getBreakDownAndUtilityProviderDetail(){
			var break_down_id = $("#break_down_id").val();
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/utility/find_break_down_by_id_with_json/"+break_down_id,
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response, textStatus, jqXHR) {
					if(response.data!=null){
						var data = response.data;
						$("#season").html("<h4> Season : "+data['season']+"</h4>");
						$("#utility_provider").html("<h4>Utility Provider : "+data['utility_provider_name']+"</h4>");
					}
				},					
				error : function(jqXHR, textStatus, errorThrown) {

				}
		   });
		}
	</script>
</body>
<!-- END BODY -->
</html>