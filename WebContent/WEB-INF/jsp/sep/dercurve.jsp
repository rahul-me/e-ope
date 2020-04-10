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
				<input type="hidden" id="derpId" name="derpId" value="${derpId}">
				<!-- /.modal -->
				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

				<!-- BEGIN PAGE HEADER-->
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							DERCurve <small></small>
						</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="index.html">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> DERCurves </a></li>
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
						<div class="caption">DERCurve</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding: 0px;">
								<button id="addNewDerCurve" class="btn green">
									Add New DERCurve <i class="fa fa-plus"></i>
								</button>
							</div>
						</div>
						<div style="height: 10px; clear: both;"></div>
						<table id="example"
							class="display table table-striped table-bordered table-hover"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Description</th>									
									<th>Operation</th>
									<th>Configuare Curve Data</th>									
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

	<div id="derControlModal" class="modal fade bs-modal-lg" id="large"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="modal-title">Add DERCurve</h4>
				</div>
				<div class="modal-body" style="max-height: 400px; overflow: auto;">
					<form action="#"
						class="form-horizontal" id="derCurveModalForm"
						enctype="multipart/form-data" method="post">
						<input type="hidden" id="dcId" name="dcId">
						<input type="hidden" id="derpId" name="derpId" value="${derpId}">
						<input type="hidden" id="version" name="version">
						<div class="form-body">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">Description</label>
										<div class="col-md-10">
											<input type="text" class="form-control"
												placeholder="About DERControl" id="description"
												name="description">
										</div>
									</div>
								</div>
								<!--/span-->

								<!--/span-->
							</div>
<!-- 							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">Creation Time</label>
										<div class="col-md-5">
											<div class="input-group input-medium date date-picker"
												data-date-format="dd-mm-yyyy" data-date-start-date="+0d">
												<input id="eventCreationDate" name="eventCreationDate" type="text" class="form-control"> <span
													class="input-group-btn">
													<button class="btn default" type="button">
														<i class="fa fa-calendar"></i>
													</button>
												</span>
											</div>
										</div>
										<div class="col-md-3">
											<div class="input-group">
												<input type="text" id="eventCreationTime" name="eventCreationTime"
													class="form-control timepicker timepicker-24"> <span
													class="input-group-btn">
													<button class="btn default" type="button">
														<i class="fa fa-clock-o"></i>
													</button>
												</span>
											</div>
										</div>
									</div>
								</div>
								/span

								/span
							</div> -->
							<!--/row-->
							<!--/row-->

							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">Curve Type</label>
										<div class="col-md-10">
											<select class="form-control" id="derCurveType" name="derCurveType">
												<option value="0">Volt-VAr Mode</option>
												<option value="1">Frequency-Watt Curve Mode</option>
												<option value="2">Watt-PowerFactor Mode </option>												
												<option value="3">Volt-Watt Mode</option>
												<option value="4">Low Voltage Ride Through Mode</option>
												<option value="5">High Voltage Ride Through Mode</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">rampDecTmst</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="rampDecTms" id="rampDecTms"
												name="rampDecTms">
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">rampIncTms</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="rampIncTms" id="rampIncTms"
												name="rampIncTms">
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">rampPT1Tms</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="rampPT1Tms" id="rampPT1Tms"
												name="rampPT1Tms">
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">xMultiplier</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="xMultiplier (Max 127, Min -128)" id="xMultiplier"
												name="xMultiplier">
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">yMultiplier</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="yMultiplier (Max 127, Min -128)" id="yMultiplier"
												name="yMultiplier">
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">DERUnitRefType</label>
										<div class="col-md-10">
											<select class="form-control" id="yRefType" name="yRefType">
												<option value="0">N/A</option>
												<option value="1">%setMaxW</option>
												<option value="2">%setMaxVAr </option>												
												<option value="3">%statVArAvail</option>
												<option value="4">%setEffectiveV</option>
												<option value="5">%setMaxChargeRate</option>
												<option value="6">%setMaxDischargeRate</option>
											</select>
										</div>
									</div>
								</div>									
							</div>							
							
							
												</form>
					<!-- END FORM-->

				</div>
				<div class="modal-footer">
					<button type="button" class="btn default" data-dismiss="modal">Close</button>
					<button type="button" id="btnSaveDerCurve" class="btn blue">Save</button>
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
			$("#dcId").val("");
			$("#version").val("0");
			$("#derControlModal").modal("show");
		});

		function setTable() {
			var derpId = $('#derpId').val();
			$('#example')
					.dataTable(
							{
								"serverSide" : true,
								"bDestroy" : true,
								"ajax" : "${pageContext.request.contextPath}/rest/derp/"+derpId+"/dc/list",
								"columns" : [
										{
											"data" : "description"
										},																			
										{
											"data" : null,
											"render" : function(data, type, row) {
												//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
												var data = /* "&nbsp;<button type='button' onclick='deleteDerc("
														+ row.id
														+ ");' class='btn btn-danger btn-xs'><i class='fa fa-trash-o'></i></button>" */
														/* +  */"&nbsp;<button type='button' onclick='editDerc("
														+ row.id
														+ ");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
												;
												return data;
											},
										},																			
										{
											"data" : null,
											"render" : function(data, type, row) {
												//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
												var data = "&nbsp;<button title='Link To Curve Data' type='button' onclick='linkCurveData("
														+ row.id
														+ ");' class='btn btn-success btn-xs'><i class='fa fa-cog'></i></button>";
												;
												return data;
											},
										} ]

							});
		}

		$("#btnSaveDerCurve").on("click", function(){
			var obj = new Object();
			obj.id = $('#dcId').val();
			obj.derCurveType = $('#derCurveType').val();
			obj.description = $('#description').val();
			obj.rampDecTms = $('#rampDecTms').val();
			obj.rampIncTms = $('#rampIncTms').val();			
			obj.rampPT1Tms = $('#rampPT1Tms').val();
			obj.xMultiplier = $('#xMultiplier').val();
			obj.yMultiplier = $('#yMultiplier').val();
			obj.derUnitRefType = $('#yRefType').val();
			obj.version = $('#version').val();
			var derpId = $('#derpId').val();
			obj.derpId = derpId;
			$.ajax({
				url : '${pageContext.request.contextPath}/rest/derp/'+derpId+'/dc/save',
				type: 'POST',
				contentType: 'application/json',
				dataType: 'json',
				data: JSON.stringify(obj),
				success : function(response, textStatus, jqXHR) {
					$("#derControlModal").modal("hide");
					$('#example').dataTable().fnDestroy();
					setTable();
				}
			});
			/* $.ajax({
				url : '${pageContext.request.contextPath}/rest/derp/'+derpId+'/dc/save',
				type: 'POST',
				data: new FormData(document.getElementById('derCurveModalForm')),
				processData: false,
		        contentType: false,
				success : function(response, textStatus, jqXHR) {
					$("#derControlModal").modal("hide");
					$('#example').dataTable().fnDestroy();
					//setTable();
				}
			}); */
		});

		function editDerc() {
			var dcId = arguments[0];
			var derpId = $("#derpId").val();
			$
					.ajax({
						url : "${pageContext.request.contextPath}/rest/derp/"+derpId+"/dc/"+dcId,
						type : "GET",
						contentType : "application/json",
						dataType : "json",
						success : function(response, textStatus, jqXHR) {
							if (response.data) {
								$("#description").val(response.data['description']);
								$("#derCurveType").val(response.data['derCurveType']);
								$("#rampDecTms").val(response.data['rampDecTms']);								
								$("#rampIncTms").val(response.data['rampIncTms']);
								$("#rampPT1Tms").val(response.data['rampIncTms']);
								$("#yMultiplier").val(response.data['yMultiplier']);
								$("#derUnitRefType").val(response.data['derUnitRefType']);								
								$('#dcId').val(response.data['id']);
								$('#version').val(response.data['version']);
								$("#derControlModal").modal("show");
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

		function linkCurveData() {
			var derCurveId = arguments[0];
			var derpId = $('#derpId').val();
			window.location.href = "${pageContext.request.contextPath}/rest/derp/"+derpId+"/dc/"+derCurveId+"/page";
		}
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
