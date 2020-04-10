<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<style>
.modal {
}
.vertical-alignment-helper {
    display:table;
    height: 100%;
    width: 100%;
}
.vertical-align-center {
    /* To center vertically */
    display: table-cell;
    vertical-align: middle;
}
.modal-content {
    /* Bootstrap sets the size of the modal in the modal-dialog class, we need to inherit it */
    width:inherit;
    height:inherit;
    /* To center horizontally */
    margin: 0 auto;
}
</style>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
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
						<h3 class="page-title">Calculate energy cost</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="${pageContext.request.contextPath}/rest/micro/list">
								Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> Calculate energy cost </a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							Energy cost
						</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding:0px;">																
								<div class="col-md-4">
									<jsp:include page="utility_account_no_list.jsp"></jsp:include>
								</div>
								<div class="col-md-2">
									<div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
										<input type="text" class="form-control" id="start_date">
										
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>											
								</div>
								<div class="col-md-2">
									<div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
										<input type="text" class="form-control" id="end_date">
										
										<span class="input-group-btn">
											<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
										</span>
									</div>											
								</div>	
								<div class="col-md-2">
									<button type="button" class="btn btn-primary" onclick="generateBill();">Generate</button>
								</div>								
							</div>							
						</div>		
						<div style="height:10px;clear:both;"></div>		
						<!-- <table id="example" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
							<thead>
								<tr>		
									<th>ACCOUNT NO</th>
									<th>START TIME</th>
									<th>END TIME</th>
									<th>USAGE</th>									
									<th>COST</th>
									<th>CAL_COST</th>
								</tr>
							</thead>
						</table> -->								
					</div>
				</div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
	<!-- END CONTAINER -->	
	<!-- loading modal -->
	<div id="loadModal" class="modal fade" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="width:257px;text-align: center;">									
				<div class="modal-body">
					<b>Your energy cost are calculating please wait or do not refresh page...!</b>
				</div>									
			</div>		
		</div>		
	</div>
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
	
	<!-- END JAVASCRIPTS -->	
	<script>
		jQuery(document).ready(function() {    
		   App.init(); 
		   Index.init();
		   ComponentsPickers.init();
		  // setTable();
		});
		function generateBill(){
			var start_date = $("#start_date").val();
			var end_date = $("#end_date").val();
			var account_no = $("#utility_account_no_list").val();
			
			if(start_date!="" && end_date!="" && account_no!=""){				
				$.ajax({
					url : "${pageContext.request.contextPath}/rest/utility/calculatebill?start_date="+start_date+"&end_date="+end_date+"&account_no="+account_no,
					type : "GET",
					contentType : "application/json",
					dataType : "json",
					beforeSend: function() {
						$('#loadModal').modal({backdrop: 'static', keyboard: false});
						$('#loadModal').modal("show");
				    },
					success : function(response, textStatus, jqXHR) {
						var data = response.status;
						console.log(data);
						if(data==true){
							$("#loadModal").modal("hide");
						}					
					},
					// callback handler that will be called on error
					error : function(jqXHR, textStatus, errorThrown) {

					}
			  });
			}else{
				alert("All fields are required.!");
			}
			
		}		
		function setTable(){
			$('#example').dataTable({
		        "serverSide": false,
		        "bDestroy": true,
				"ajax" : "${pageContext.request.contextPath}/rest/utility/get_interval_data_list",
				"columns" : [{
							"data":"account_no"
						},{
							"data":"start_time"
						},{
							"data":"end_time"
						},{
							"data":"usage"
						},{
							"data":'cost'
						},{
							"data":'cal_price'
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
</body>
<!-- END BODY -->
</html>