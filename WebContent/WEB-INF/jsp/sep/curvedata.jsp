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
				<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<div class="modal fade" id="portlet-config" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title">Modal title</h4>
							</div>
							<div class="modal-body">Widget settings form goes here</div>
							<div class="modal-footer">
								<button type="button" class="btn blue">Save changes</button>
								<button type="button" class="btn default" data-dismiss="modal">Close</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<input type="hidden" id="derpId" name="derpId"
					value="${derpId}">
					<input type="hidden" id="dcId" name="dcId"
					value="${dcId}">
					
				<!-- /.modal -->
				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

				<!-- BEGIN PAGE HEADER-->
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							Curve Data <small></small>
						</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="index.html">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> Curve Data </a></li>
							<li class="pull-right"></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN DASHBOARD STATS -->

				<!-- END DASHBOARD STATS -->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">Curve Data</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding: 0px;">
								<button id="addNewDerCurve" class="btn green">
									Add New Curve Data <i class="fa fa-plus"></i>
								</button>
							</div>
						</div>
						<div style="height: 10px; clear: both;"></div>
						<table id="example"
							class="display table table-striped table-bordered table-hover"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Exitation</th>
									<th>X Value</th>
									<th>Y Value</th>
									<th>Operation</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
	<!-- END CONTAINER -->

	<div id="curveDataModal" class="modal fade bs-modal-lg" id="large"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="modal-title">Add Curve Data</h4>
				</div>
				<div class="modal-body" style="max-height: 400px; overflow: auto;">
					<form action="#" class="form-horizontal" id="derCurveModalForm"
						enctype="multipart/form-data" method="post">
						<input type="hidden" id="curveDataId" name="curveDataId">
						<div class="form-body">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">Excitation</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="Exitation Value (Max 127)" id="exitation"
												name="exitation">
										</div>
									</div>
								</div>
								
							</div>
							

							<div class="row">

								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">X Value</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="value of x" id="xvalue" name="xvalue">
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">Y Value</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="value of y" id="yvalue" name="yvalue">
										</div>
									</div>
								</div>


							</div>
					</form>
					<!-- END FORM-->

				</div>
				<div class="modal-footer">
					<button type="button" class="btn default" data-dismiss="modal">Close</button>
					<button type="button" id="btnSaveCurveData" class="btn blue">Save</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>

	<!-- end derprogram modal -->



	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>

	<script>
		jQuery(document).ready(function() {
			App.init();
			ComponentsPickers.init();
			setTable();
		});

		$("#addNewDerCurve").click(function() {
			$('#derCurveModalForm')[0].reset();
			$("#id").val("");
			$("#curveDataModal").modal("show");
		});

		function setTable() {
			var derpId = $('#derpId').val();
			var dcId = $('#dcId').val();
			$('#example')
					.dataTable(
							{
								"serverSide" : true,
								"bDestroy" : true,
								"ajax" : "${pageContext.request.contextPath}/rest/derp/"+derpId+"/dc/"+dcId+"/list",
								"columns" : [
										{
											"data" : "exitation"
										},
										{
											"data" : "xvalue"
										},
										{
											"data" : "yvalue"
										},
										{
											"data" : null,
											"render" : function(data, type, row) {
												//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
												var data = "&nbsp;<button type='button' onclick='deleteCurveData("
														+ row.id
														+ ");' class='btn btn-danger btn-xs'><i class='fa fa-trash-o'></i></button>"
														/* + "&nbsp;<button type='button' onclick='editDerc("
														+ row.id
														+ ");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>" */;
												;
												return data;
											},
										} ]

							});
		}

		$("#btnSaveCurveData").on("click", function(){
			var obj = new Object();
			obj.id = $('#curveDataId').val();
			obj.exitation = $('#exitation').val();
			obj.xvalue = $('#xvalue').val();
			obj.yvalue = $('#yvalue').val();
						
			var derpId = $('#derpId').val();
			var dercId = $('#dcId').val();
			
			obj.derCurveId = dercId;
			$.ajax({
				url : '${pageContext.request.contextPath}/rest/derp/'+derpId+'/dc/'+dercId+'/save',
				type: 'POST',
				contentType: 'application/json',
				dataType: 'json',
				data: JSON.stringify(obj),
				success : function(response, textStatus, jqXHR) {
					$("#curveDataModal").modal("hide");
					$('#example').dataTable().fnDestroy();
					setTable();
				}
			});			
		});

		function editDerc() {
			var dercId = arguments[0];
			var derpId = $("#derpId").val();
			$
					.ajax({
						url : "${pageContext.request.contextPath}/rest/sep/derprograms/"+derpId+"/derc/"+dercId,
						type : "GET",
						contentType : "application/json",
						dataType : "json",
						success : function(response, textStatus, jqXHR) {
							if (response.data) {
								$("#description").val(response.data['description']);
								$("#randomizeStart").val(response.data['randomizeStart']);
								$("#randomizeDuration").val(response.data['randomizeDuration']);
								var eventStartTime = response.data['eventStartTime'];
								$("#eventStartDate").val(eventStartTime.split(" ")[0]);
								$("#eventStartTime").val(eventStartTime.split(" ")[1]);
								$("#eventDuration").val(response.data['eventDuration']);
								$('#dercId').val(response.data['id']);
								$("#curveDataModal").modal("show");
							}
						},
						// callback handler that will be called on error
						error : function(jqXHR, textStatus, errorThrown) {

						}
					});
		}

		function deleteDerp(id) {
			if (confirm("Are you sure?")) {
				$
						.ajax({
							url : "${pageContext.request.contextPath}/rest/sep/derprograms/delete/"
									+ id,
							type : "POST",
							contentType : "application/json",
							dataType : "json",
							success : function(response, textStatus, jqXHR) {
								$('#example').dataTable().fnDestroy();
								setTable();
							},
							// callback handler that will be called on error
							error : function(jqXHR, textStatus, errorThrown) {

							}
						});
			}
		}

		
		
		function deleteCurveData(){			
			if(confirm('Are you sure ?')){
				var curveDataId = arguments[0];
				var derpId = $('#derpId').val();
				var dcId = $('#dcId').val();
				$.ajax({
					url : "${pageContext.request.contextPath}/rest/derp/"+derpId+"/dc/"+dcId+"/"+curveDataId,
					type: 'DELETE',
					success : function(response, textStatus, jqXHR){
						//alert('done');						
						$('#example').dataTable().fnDestroy();
						setTable();
						toastr.success('Data Deleted');
					},
					error : function(jqXHR, textStatus, errorThrown) {
						toastr.error('Something is wrong. Try again later.');						
					}
				});
			}
		}
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
