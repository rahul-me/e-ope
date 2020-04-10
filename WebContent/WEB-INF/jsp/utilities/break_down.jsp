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
							<li><i class="fa fa-home"></i> <a href="${pageContext.request.contextPath}/rest/utility/index">
									Utility </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="${pageContext.request.contextPath}/rest/utility/provider">
									Utility Provider</a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> Break Down </a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							Utility Break Down
						</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding:0px;">																
								<button id="add_break_down" class="btn">
									Add Season
								</button>										
							</div>							
						</div>		
						<div style="height:10px;clear:both;"></div>		
						<table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>									
									<th>UTILITY PROVIDER</th>
									<th>SEASON</th>
									<th>START DATE</th>
									<th>END DATE</th>									
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
	<jsp:include page="break_down_modal.jsp"></jsp:include>
	<!-- END JAVASCRIPTS -->	
	<script>
		jQuery(document).ready(function() {    
		   App.init(); 
		   Index.init();
		   ComponentsPickers.init();
		   setTable();		 
		   getUtilityProviderById();
		});
		function setTable(){
			var id = $("#utility_provider_id").val();
			$('#example').dataTable({
		        "serverSide": false,
		        "bDestroy": true,
				"ajax" : "${pageContext.request.contextPath}/rest/utility/find_break_down_list_by_utility_provider_id/"+id,
				"columns" : [
						{
							"data" : "utility_provider_name"
						},{
							"data":"season"
						},{
							"data":null,
							"render" : function(data,type,row){								
								var data = new Date(row.start_date);
								var monthNames = ["January", "February", "March", "April", "May", "June",
								                  "July", "August", "September", "October", "November", "December"
								                ];
								var start_date = data.getDate()+" - "+monthNames[(data.getMonth())];
								return start_date;
							},
						},{
							"data":null,
							"render" : function(data,type,row){								
								var data = new Date(row.end_date);
								var monthNames = ["January", "February", "March", "April", "May", "June",
								                  "July", "August", "September", "October", "November", "December"
								                ];
								var end_date = data.getDate()+" - "+monthNames[(data.getMonth())];
								return end_date;
							},
						},{
							"data":null,
							"render" : function(data,type,row){								
								//var	data = "<button type='button' title='Edit Utility' onclick='editUtility("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
								var data = "<button type='button' title='Edit Utility' onclick='editBreakDown("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
								data += "&nbsp;<button type='button' title='Delete Utility' onclick='deleteBreakDown("+row.id+");' class='btn btn-danger btn-xs'><i class='fa fa-trash-o'></i></button>";
								data += "&nbsp;<button type='button' title='Utility Rate' onclick='utilityRate("+row.id+");' class='btn btn-warning btn-xs'><i class='fa  fa-dollar'></i></button>";
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
		function editBreakDown(id){
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/utility/find_break_down/"+id,
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response, textStatus, jqXHR) {
					if(response.data!=null){
						var data = response.data;
						$("#id").val(data['id']);						
						$("#season_name").val(data['season']);
						var s_date = new Date(data['start_date']);
						$("#start_date").val(s_date.getFullYear()+"-"+fillDateWithZero((s_date.getMonth()+1))+"-"+fillDateWithZero(s_date.getDate()));
						var e_date = new Date(data['end_date']);
						$("#end_date").val(e_date.getFullYear()+"-"+fillDateWithZero((e_date.getMonth()+1))+"-"+fillDateWithZero(e_date.getDate()));
						$("#break_down_modal").modal("show");
					}
				},					
				error : function(jqXHR, textStatus, errorThrown) {

				}
		   });
		}
		function fillDateWithZero(val){
			if(val>9){
				return val;
			}else{
				return "0"+val;	
			}
		}
		function deleteBreakDown(id){
			if(confirm("Are you sure?")){
				$.ajax({
					url : "${pageContext.request.contextPath}/rest/utility/delete_break_down/"+id,
					type : "GET",
					contentType : "application/json",
					dataType : "json",
					success : function(response, textStatus, jqXHR) {
						if(response.status==true){	
							toastr.success("Utility break down delete successfully.!");
							setTable();
						}
					},					
					error : function(jqXHR, textStatus, errorThrown) {

					}
			   });	
			}
		}
		function utilityRate(id){
			var utility_provider_id = $("#utility_provider_id").val();
			window.location.href="${pageContext.request.contextPath}/rest/utility/"+utility_provider_id+"/break_down/"+id+"/utility_rate";
		}
	</script>
</body>
<!-- END BODY -->
</html>