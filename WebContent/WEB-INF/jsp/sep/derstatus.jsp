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
							DERStatus <small></small>
						</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="index.html">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> DERStatus </a></li>
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
						<div class="caption">DERStatus</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding: 0px;">
								<button id="addNewDerControl" class="btn green">
									Add New DERStatus <i class="fa fa-plus"></i>
								</button>
							</div>
						</div>
						<div style="height: 10px; clear: both;"></div>
						<table id="example"
							class="display table table-striped table-bordered table-hover"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Id</th>
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

	<div id="derControlModal" class="modal fade bs-modal-lg" id="large"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="modal-title">Add DERStatus</h4>
				</div>
				<div class="modal-body" style="max-height: 400px; overflow: auto;">
					<form id="derStatusForm"><input type="hidden" id="hdone"/></form>
					<input type="hidden" id="dercId" name="dercId"> <input
						type="hidden" id="version" name="version">
					<div class="form-body">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Gen Connect
										Status </label>
									<div class="col-md-4">
										<div class="input-group input-medium date date-picker"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="genConnectStatusDate" name="genConnectStatusDate">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-calendar"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group">
											<input type="text"
												class="form-control timepicker timepicker-24"
												id="genConnectStatusTime" name="genConnectStatusTime">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="genConnectStatus" name="genConnectStatus">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Inverter Status </label>
									<div class="col-md-4">
										<div class="input-group input-medium date date-picker"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="inverterStatusDate" name="inverterStatusDate"> <span
												class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-calendar"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group">
											<input type="text"
												class="form-control timepicker timepicker-24"
												id="inverterStatusTime" name="inverterStatusTime"> <span
												class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="inverterStatus" name="inverterStatus">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Control Mode
										Status </label>
									<div class="col-md-4">
										<div class="input-group input-medium date date-picker"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="localControlModeStatusDate"
												name="localControlModeStatusDate"> <span
												class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-calendar"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group">
											<input type="text"
												class="form-control timepicker timepicker-24"
												id="localControlModeStatusTime"
												name="localControlModeStatusTime"> <span
												class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="localControlModeStatus" name="localControlModeStatus">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Manufacturer
										Status </label>
									<div class="col-md-4">
										<div class="input-group input-medium date date-picker"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="manufacturerStatusDate" name="manufacturerStatusDate">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-calendar"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group">
											<input type="text"
												class="form-control timepicker timepicker-24"
												id="manufacturerStatusTime" name="manufacturerStatus">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="manufacturerStatus" name="manufacturerStatus">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Operational Mode
										Status </label>
									<div class="col-md-4">
										<div class="input-group input-medium date date-picker"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="operationalModeStatusDate"
												name="operationalModeStatusDate"> <span
												class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-calendar"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group">
											<input type="text"
												class="form-control timepicker timepicker-24"
												id="operationalModeStatusTime"
												name="operationalModeStatusTime"> <span
												class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="operationalModeStatus" name="operationalModeStatus">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">State Of Charge
										Status </label>
									<div class="col-md-4">
										<div class="input-group input-medium date date-picker"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="stateOfChargeStatusDate" name="stateOfChargeStatusDate">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-calendar"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group">
											<input type="text"
												class="form-control timepicker timepicker-24"
												id="stateOfChargeStatusTime" name="stateOfChargeStatusDate">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="stateOfChargeStatus" name="stateOfChargeStatus">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Storage Mode
										Status </label>
									<div class="col-md-4">
										<div class="input-group input-medium date date-picker"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="storageModeStatusDate" name="storageModeStatusDate">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-calendar"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group">
											<input type="text"
												class="form-control timepicker timepicker-24"
												id="storageModeStatusTime" name="storageModeStatusTime">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="storageModeStatus" name="storageModeStatus">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Stor Connect
										Status </label>
									<div class="col-md-4">
										<div class="input-group input-medium date date-picker"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="storConnectStatusDate" name="storConnectStatusDate">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-calendar"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<div class="input-group">
											<input type="text"
												class="form-control timepicker timepicker-24"
												id="storConnectStatusTime" name="storConnectStatus">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="storConnectStatus" name="storConnectStatus">
									</div>
								</div>
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn default" data-dismiss="modal">Close</button>
						<button type="button" id="btnSaveDerStatus" class="btn blue">Save</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
	<!-- end derprogram modal -->



	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>

	<script>
		jQuery(document).ready(function() {
			App.init();
			ComponentsPickers.init();
			setTable();
		});

		$("#addNewDerControl").click(function() {
			$('#derControlModalForm')[0].reset();
			$("#id").val("");
			$('#version').val("0");
			var derpId = $('#derpId').val();
			$.ajax({
				url : '${pageContext.request.contextPath}/rest/derp/'+derpId+'/dc/list',
				type: 'GET',				
				success : function(response, textStatus, jqXHR) {
					if(response){
						if(response.status){
							$('#opModFreqWatt').html('');
							$('#opModHVRTLowerLimit').html('');
							$('#opModHVRTUpperLimit').html('');
							$('#opModLVRTLowerLimit').html('');
							$('#opModLVRTUpperLimit').html('');
							$('#opModVoltVAr').html('');
							$('#opModVoltWatt').html('');
							$('#opModWattPF').html('');
							$.each(response.data, function(index, value){
								$('#opModFreqWatt').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModHVRTLowerLimit').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModHVRTUpperLimit').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModLVRTLowerLimit').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModLVRTUpperLimit').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModVoltVAr').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModVoltWatt').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModWattPF').append($("<option></option>").text(value["description"]).val(value["id"]));
							});
						}
					}					
					$("#derControlModal").modal("show");
				}
			});
			
			
			$("#derControlModal").modal("show");
		});

		function setTable() {
			var derpId = $('#derpId').val();
			$('#example')
					.dataTable(
							{
								"serverSide" : true,
								"bDestroy" : true,
								"ajax" : "${pageContext.request.contextPath}/rest/sep/derprograms/"+derpId+"/derc/list",
								"columns" : [
										{
											"data" : "description"
										},
										{
											"data" : "eventStartTime",
											
										},
										{
											"data" : "eventDuration",
										},										
										{
											"data" : null,
											"render" : function(data, type, row) {
												//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
												var data = "&nbsp;<button type='button' onclick='deleteDERControl("
														+ row.id
														+ ");' class='btn btn-danger btn-xs'><i class='fa fa-trash-o'></i></button>"
														+ "&nbsp;<button type='button' onclick='editDerc("
														+ row.id
														+ ");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
												;
												return data;
											},
										} ]

							});
		}

		$("#btnSaveDerControl").on("click", function(){
			
			var obj = new Object();
			obj.id = $('#dercId').val();
			obj.description = $('#description').val();
			obj.randomizedDuration = $('#randomizeDuration').val();
			obj.randomizeStart = $('#randomizeStart').val();			
			obj.eventStartTime = $('#eventStartDate').val()+" "+$('#eventStartTime').val();
			obj.eventDuration = $('#eventDuration').val();
			obj.version = $('#version').val();
			
			//DERControlBase
			obj.opModFixedFlow = $('#opModFixedFlow').val();
			obj.opModFixedPFDisplacement = $('#opModFixedPFDisplacement').val();
			obj.opModFixedPFMultiplier = $('#opModFixedPFMultiplier').val();
			obj.opModFixedVArRefType = $('#opModFixedVArRefType').val();
			obj.opModFixedVArValue = $('#opModFixedVArValue').val();
			obj.opModFixedW = $('#opModFixedW').val();
			obj.opModFreqWatt = $('#opModFreqWatt').val();
			obj.opModHVRTLowerLimit = $('#opModHVRTLowerLimit').val();
			obj.opModHVRTUpperLimit = $('#opModHVRTUpperLimit').val();
			obj.opModLVRTLowerLimit = $('#opModLVRTLowerLimit').val();
			obj.opModLVRTUpperLimit = $('#opModLVRTUpperLimit').val();
			obj.opModVoltVAr = $('#opModVoltVAr').val();
			obj.opModVoltWatt = $('#opModVoltWatt').val();
			obj.opModWattPF = $('#opModWattPF').val();
			obj.rampTms = $('#rampTms').val();
			
			
			var derpId = $('#derpId').val();
			obj.derpId = derpId;
			$.ajax({
				url : '${pageContext.request.contextPath}/rest/sep/derprograms/'+derpId+'/derc/save',
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
		});

		function editDerc() {
			$('#derControlModalForm')[0].reset();
			var dercId = arguments[0];
			var derpId = $("#derpId").val();
			
			
			$.ajax({
				url : '${pageContext.request.contextPath}/rest/derp/'+derpId+'/dc/list',
				type: 'GET',				
				success : function(response, textStatus, jqXHR) {
					if(response){
						if(response.status){
							$('#opModFreqWatt').html('');
							$('#opModHVRTLowerLimit').html('');
							$('#opModHVRTUpperLimit').html('');
							$('#opModLVRTLowerLimit').html('');
							$('#opModLVRTUpperLimit').html('');
							$('#opModVoltVAr').html('');
							$('#opModVoltWatt').html('');
							$('#opModWattPF').html('');
							$.each(response.data, function(index, value){
								$('#opModFreqWatt').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModHVRTLowerLimit').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModHVRTUpperLimit').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModLVRTLowerLimit').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModLVRTUpperLimit').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModVoltVAr').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModVoltWatt').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#opModWattPF').append($("<option></option>").text(value["description"]).val(value["id"]));
							});
						}
					}					
					$("#derControlModal").modal("show");
				}
			});
			
			
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
								$('#version').val(response.data['version']);
								
								//DERControlBase
								$('#opModFixedFlow').val(response.data['opModFixedFlow']);
								$('#opModFixedPFDisplacement').val(response.data['opModFixedPFDisplacement']);
								$('#opModFixedPFMultiplier').val(response.data['opModFixedPFMultiplier']);
								$('#opModFixedVArRefType').val(response.data['opModFixedVArRefType']);
								$('#opModFixedVArValue').val(response.data['opModFixedVArValue']);
								$('#opModFixedW').val(response.data['opModFixedW']);																
								$('#rampTms').val(response.data['rampTms']);
								
								var opModFreqWatt =  response.data['opModFreqWatt'];
								var opModHVRTLowerLimit = response.data['opModHVRTLowerLimit'];
								var opModHVRTUpperLimit = response.data['opModHVRTUpperLimit'];
								var opModLVRTLowerLimit = response.data['opModLVRTLowerLimit'];
								var opModLVRTUpperLimit = response.data['opModLVRTUpperLimit'];
								var opModVoltVAr = response.data['opModVoltVAr'];
								var opModVoltWatt = response.data['opModVoltWatt'];
								var opModWattPF = response.data['opModWattPF'];
								
								$('#opModFreqWatt').val(opModFreqWatt);
								$('#opModHVRTLowerLimit').val(opModHVRTLowerLimit);
								$('#opModHVRTUpperLimit').val(opModHVRTUpperLimit);
								$('#opModLVRTLowerLimit').val(opModLVRTLowerLimit);
								$('#opModLVRTUpperLimit').val(opModLVRTUpperLimit);
								$('#opModVoltVAr').val(opModVoltVAr);
								$('#opModVoltWatt').val(opModVoltWatt);
								$('#opModWattPF').val(opModWattPF);																								
								$("#derControlModal").modal("show");
							}
						},
						// callback handler that will be called on error
						error : function(jqXHR, textStatus, errorThrown) {

						}
					});
		}

		

		function addDerControl() {
			var id = arguments[0];
			window.location = id + "/addfunction/index";
		}
		
		function deleteDERControl(){						
				if(confirm('Are you sure ?')){
					var dercId = arguments[0];
					var derpId = $("#derpId").val();
					$.ajax({
						url : "${pageContext.request.contextPath}/rest/sep/derprograms/"+derpId+"/derc/"+dercId,
						type: 'DELETE',
						success : function(response, textStatus, jqXHR){
							//alert('done');
							$("#derControlModal").modal("hide");
							$('#example').dataTable().fnDestroy();
							setTable();
							toastr.success('Data Deleted');
						},
						error : function(jqXHR, textStatus, errorThrown) {
							toastr.error('Something is wrong. Try again later.');
							$("#derControlModal").modal("hide");
						}
					});
				}						
		}
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
