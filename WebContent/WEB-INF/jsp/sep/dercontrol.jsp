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
							DERControls <small></small>
						</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="index.html">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> DERControls </a></li>
							<li class="pull-right"></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN DASHBOARD STATS -->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">Default DERControl</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding: 0px;">
								<button id="addDefaultDc" class="btn green">
									Add Default DERControl <i class="fa fa-plus"></i>
								</button>
							</div>
						</div>
						<div style="height: 10px; clear: both;"></div>
						<table id="exampleDefault"
							class="display table table-striped table-bordered table-hover"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Description</th>
									<th>Start Time</th>
									<th>Duration</th>
									<th>Operation</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
				<div class="clearfix"></div>
				<!-- END DASHBOARD STATS -->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">DERControl</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding: 0px;">
								<button id="addNewDerControl" class="btn green">
									Add New DERControl <i class="fa fa-plus"></i>
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
									<th>Start Time</th>
									<th>Duration</th>
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
					<h4 class="modal-title" id="modal-title">Add DERControl</h4>
				</div>
				<div class="modal-body" style="max-height: 400px; overflow: auto;">
					<form action="#" class="form-horizontal" id="derControlModalForm"
						enctype="multipart/form-data" method="post">
						<input type="hidden" id="dercId" name="dercId">
						<input type="hidden" id="version" name="version">
						<input type="hidden" id="type" name="type"/>
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
							</div>


							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">Randomize
											Duration</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="Randomize Duration In seconds (Max 3600)"
												id="randomizeDuration" name="randomizeDuration">
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">Randomize Start</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="Randomize Start In seconds (Max 3600)"
												id="randomizeStart" name="randomizeStart">
										</div>
									</div>
								</div>
							</div>
							<h3 class="form-section" style="margin: 0px 0px 25px 0px;">Event</h3>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">Start Time</label>
										<div class="col-md-5">
											<div class="input-group input-medium date date-picker"
												data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
												<input type="text" class="form-control" id="eventStartDate"
													name="eventStartDate"> <span
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
													id="eventStartTime" name="eventCreationDate"> <span
													class="input-group-btn">
													<button class="btn default" type="button">
														<i class="fa fa-clock-o"></i>
													</button>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">Duration</label>
										<div class="col-md-10">
											<input type="number" name="eventDuration" id="eventDuration"
												class="form-control">
										</div>
									</div>
								</div>
							</div>

							<h3 class="form-section" style="margin: 0px 0px 25px 0px;">DER
								Control Base values</h3>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">opModFixedFlow</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="About DERControl" id="opModFixedFlow"
												name="opModFixedFlow">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">opModFixedPF</label>
										<div class="col-md-5">

											<input placeholder="Displacement (Max 32767)" type="number"
												class="form-control" id="opModFixedPFDisplacement" name="opModFixedPFDisplacement" />

										</div>
										<div class="col-md-3">
											<div class="input-group">
												<input type="number" placeholder="Multiplier (Max 127)"
													class="form-control" id="opModFixedPFMultiplier" name="opModFixedPFMultiplier" />
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">opModFixedVAr</label>
										<div class="col-md-5">

											<input placeholder="Displacement (Max 32767)" type="number"
												class="form-control" id="opModFixedVAr" name="opModFixedVAr" />

										</div>
										<div class="col-md-3">
											<div class="input-group">
												<input type="number" placeholder="Multiplier (Max 127)"
													class="form-control" id="opModFixedVAr" name="opModFixedVAr" />
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">opModFixedW</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="opModFixedW" id="opModFixedW"
												name="opModFixedW">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">opModFreqWatt</label>
										<div class="col-md-10">
											<select class="form-control" name="opModFreqWatt"
												id="opModFreqWatt">												
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">opModHVRT</label>
										<div class="col-md-5">
											<select class="form-control" name="opModHVRTLowerLimit"
												id="opModHVRTLowerLimit">												
											</select>
										</div>
										<div class="col-md-3">
											<select class="form-control" name="opModHVRTUpperLimit"
												id="opModHVRTUpperLimit">												
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">opModLVRT</label>
										<div class="col-md-5">
											<select class="form-control" name="opModLVRTLowerLimit"
												id="opModLVRTLowerLimit">												
											</select>
										</div>
										<div class="col-md-3">
											<select class="form-control" name="opModLVRTUpperLimit"
												id="opModLVRTUpperLimit">												
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">opModVoltVAr</label>
										<div class="col-md-10">
											<select class="form-control" name="opModVoltVAr"
												id="opModVoltVAr">												
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">opModVoltWatt</label>
										<div class="col-md-10">
											<select class="form-control" name="opModVoltWatt"
												id="opModVoltWatt">												
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">opModWattPF</label>
										<div class="col-md-10">
											<select class="form-control" name="opModWattPF"
												id="opModWattPF">												
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">rampTms</label>
										<div class="col-md-10">
											<input type="number" class="form-control"
												placeholder="rampTms" id="rampTms"
												name="rampTms">
										</div>
									</div>
								</div>
							</div>
					</form>
					<!-- END FORM-->

				</div>
				<div class="modal-footer">
					<button type="button" class="btn default" data-dismiss="modal">Close</button>
					<button type="button" id="btnSaveDerControl" class="btn blue">Save</button>
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
			setDefaultDERControlTable();
		});

		$("#addNewDerControl").click(function() {
			buildDERControlModal("normal");
		});
		
		$("#addDefaultDc").click(function() {
			buildDERControlModal("default");
		});
		
		function buildDERControlModal(){
			var type = arguments[0];
			$('#derControlModalForm')[0].reset();
			$("#id").val("");
			$('#version').val("0");
			$('#type').val(type);
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
		}

		function setTable() {
			var type = 'normalType';
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
														+ row.id +",1"
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
		
		function setDefaultDERControlTable() {
			var derType = 'defaultType';
			var derpId = $('#derpId').val();			
			$('#exampleDefault')
					.dataTable(
							{
								"serverSide" : true,
								"bDestroy" : true,
								"ajax" : "${pageContext.request.contextPath}/rest/sep/derprograms/"+derpId+"/derc/default",
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
												$('#addDefaultDc').hide();
												//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
												var data = "&nbsp;<button type='button' onclick='deleteDERControl("
														+ row.id+",2"
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
			
			var type = $('#type').val();
			if(type == 'default'){
				obj.defaultDERControl = true;
			} else {
				obj.defaultDERControl = false;
			}
			
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
					if(type == 'default'){
						$("#derControlModal").modal("hide");
						$('#exampleDefault').dataTable().fnDestroy();
						setDefaultDERControlTable();
					} else {
						$("#derControlModal").modal("hide");
						$('#example').dataTable().fnDestroy();
						setTable();
					}
					
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
								
								var type = response.data['defaultDERControl'];
								if(type){
									$('#type').val('default');
								} else {
									$('#type').val('normal');
								}
								
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
					var type = arguments[1];
					var dercId = arguments[0];
					var derpId = $("#derpId").val();
					$.ajax({
						url : "${pageContext.request.contextPath}/rest/sep/derprograms/"+derpId+"/derc/"+dercId,
						type: 'DELETE',
						success : function(response, textStatus, jqXHR){
							//alert('done');
							$("#derControlModal").modal("hide");
							if(type == 1){
								$('#example').dataTable().fnDestroy();
								setTable();
							} else {
								$('#exampleDefault').dataTable().fnDestroy();
								setDefaultDERControlTable();
								$('#addDefaultDc').show();
							}
							
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
