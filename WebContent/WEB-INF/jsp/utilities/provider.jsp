<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
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
							<li><i class="fa fa-home"></i> <a href="${pageContext.request.contextPath}/rest/micro/list">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> Provider </a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							Utility Provider
						</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding:0px;">																
								<button id="add_provider" class="btn">
									Add Utility Provider
								</button>										
							</div>							
						</div>		
						<div style="height:10px;clear:both;"></div>				
						<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>									
									<th>NAME</th>
									<th>METER FEES PER DAY</th>									
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
	<jsp:include page="utility_provider_modal.jsp"></jsp:include>
	<!-- END JAVASCRIPTS -->	
	<script>
		jQuery(document).ready(function() {    
		   App.init(); 
		   Index.init();
		   setTable();
		});
		function setTable(){
			$('#example').dataTable({
		        "serverSide": false,
		        "bDestroy": true,
				"ajax" : "${pageContext.request.contextPath}/rest/utility/list_provider",
				"columns" : [
						{
							"data" : "utilityName"
						},{
							"data":"meter_fees_per_day"
						},{
							"data":null,
							"render" : function(data,type,row){								
								//var	data = "<button type='button' title='Edit Utility' onclick='editUtility("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
								var data = "<button type='button' title='Edit Utility' onclick='editUtilityProvider("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
								data += "&nbsp;<button type='button' title='Delete Utility' onclick='deleteUtilityProvider("+row.id+");' class='btn btn-danger btn-xs'><i class='fa fa-trash-o'></i></button>";
								data += "&nbsp;<button type='button' title='Tariff Plan' onclick='utilityBreakDown("+row.id+");' class='btn btn-warning btn-xs'><i class='fa fa-flash'></i></button>";
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
		function utilityBreakDown(id){
			window.location.href = "${pageContext.request.contextPath}/rest/utility/"+id+"/break_down";
		}
	</script>
</body>
<!-- END BODY -->
</html>