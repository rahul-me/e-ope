<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<style>
 .select2-display-none {
     z-index: 10050;
}
</style>
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
				<!-- ex modal -->
				<div id="derStatusModal" class="modal fade bs-modal-lg" id="large"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="modal-title">Add DERStatus</h4>
				</div>
				<div class="modal-body" style="max-height: 400px; overflow: auto;">
					<form id="derStatusForm">
					<input type="hidden" id="dercId" name="dercId"> <input
						type="hidden" id="version" name="version">
					<div class="form-body">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Gen Connect
										Status </label>
									<div class="col-md-4">
										<div class="input-group input-medium date"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="genConnectStatusDate" name="genConnectStatusDate" readonly="readonly">
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
												class="form-control timepicker"
												id="genConnectStatusTime" name="genConnectStatusTime" readonly="readonly">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="genConnectStatus" name="genConnectStatus" readonly="readonly">
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="control-label col-md-2">Inverter Status</label>
									<div class="col-md-4">
										<div class="input-group input-medium date"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="inverterStatusDate" name="inverterStatusDate" readonly="readonly">
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
												class="form-control timepicker"
												id="inverterStatusTime" name=""inverterStatusTime"" readonly="readonly">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="inverterStatus" name="inverterStatus" readonly="readonly">
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
										<div class="input-group input-medium date"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="localControlModeStatusDate"
												name="localControlModeStatusDate" readonly="readonly"> <span
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
												class="form-control timepicker"
												id="localControlModeStatusTime"
												name="localControlModeStatusTime" readonly="readonly"> <span
												class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="localControlModeStatus" name="localControlModeStatus" readonly="readonly">
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
										<div class="input-group input-medium date"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="manufacturerStatusDate" name="manufacturerStatusDate" readonly="readonly">
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
												class="form-control timepicker"
												id="manufacturerStatusTime" name="manufacturerStatus" readonly="readonly">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="manufacturerStatus" name="manufacturerStatus" readonly="readonly">
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
										<div class="input-group input-medium date"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="operationalModeStatusDate"
												name="operationalModeStatusDate" readonly="readonly"> <span
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
												class="form-control timepicker"
												id="operationalModeStatusTime"
												name="operationalModeStatusTime" readonly="readonly"> <span
												class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="operationalModeStatus" name="operationalModeStatus" readonly="readonly">
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
										<div class="input-group input-medium date"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="stateOfChargeStatusDate" name="stateOfChargeStatusDate" readonly="readonly">
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
												class="form-control timepicker"
												id="stateOfChargeStatusTime" name="stateOfChargeStatusDate" readonly="readonly">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="stateOfChargeStatus" name="stateOfChargeStatus" readonly="readonly">
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
										<div class="input-group input-medium date"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="storageModeStatusDate" name="storageModeStatusDate" readonly="readonly">
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
												class="form-control timepicker"
												id="storageModeStatusTime" name="storageModeStatusTime" readonly="readonly">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="storageModeStatus" name="storageModeStatus" readonly="readonly">
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
										<div class="input-group input-medium date"
											data-date-format="yyyy-mm-dd" data-date-start-date="+0d">
											<input type="text" class="form-control"
												id="storConnectStatusDate" name="storConnectStatusDate" readonly="readonly">
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
												class="form-control timepicker"
												id="storConnectStatusTime" name="storConnectStatus" readonly="readonly">
											<span class="input-group-btn">
												<button class="btn default" type="button">
													<i class="fa fa-clock-o"></i>
												</button>
											</span>
										</div>
									</div>
									<div class="col-md-3">
										<input type="number" class="form-control" placeholder="Value"
											id="storConnectStatus" name="storConnectStatus" readonly="readonly">
									</div>
								</div>
							</div>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn default" data-dismiss="modal">Close</button>
						<!-- <button type="button" id="btnSaveDerStatus" class="btn blue">Save</button> -->
					</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
				<!-- ex modal -->
				<input type="hidden" id="endDeviceId" name="endDeviceId"
					value="${endDeviceId}">
				<!-- /.modal -->
				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

				<!-- BEGIN PAGE HEADER-->
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							DER <small></small>
						</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="index.html">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> DER </a></li>
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
						<div class="caption">DER</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12" style="padding: 0px;">
								<button id="addNewDer" class="btn green">
									Add New DER <i class="fa fa-plus"></i>
								</button>
							</div>
						</div>
						<div style="height: 10px; clear: both;"></div>
						<table id="example"
							class="display table table-striped table-bordered table-hover"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>CurrentDERProgram</th>
									<th>Operation</th>
									<th>View Status</th>
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

	<div id="derModal" class="modal fade bs-modal-lg"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title" id="modal-title">Add DER</h4>
				</div>
				<div class="modal-body" style="max-height: 400px; overflow: auto;">
					<form action="#" class="form-horizontal" id="derModalForm"
						enctype="multipart/form-data" method="post">
						<input type="hidden" />
						<div class="form-body">
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">DER Programs</label>
										<div class="col-md-10">
											<select class="form-control" name="derPrograms"
												id="derPrograms" multiple="multiple">												
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label col-md-2">Current DER Program</label>
										<div class="col-md-10">
											<select class="form-control" name="currentDERProgram"
												id="currentDERProgram">												
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
					<button type="button" id="btnSaveDer" class="btn blue">Save</button>
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

		$("#addNewDer").click(function() {
			$('#derModalForm')[0].reset();
			$('#derPrograms').html('');
			$('#currentDERProgram').html('');
			var endDeviceId = $('#endDeviceId').val();
			$.ajax({
				url : '${pageContext.request.contextPath}/rest/edev/'+endDeviceId+'/der/derp',
				type: 'GET',				
				success : function(response, textStatus, jqXHR) {
					if(response){
						if(response.status){
							$.each(response.data, function(index, value){
								$('#derPrograms').append($("<option></option>").text(value["description"]).val(value["id"]));
								$('#currentDERProgram').append($("<option></option>").text(value["description"]).val(value["id"]));
							});
						}
					}
					$("#derPrograms").select2();
					$("#derModal").modal("show");
				}
			});
			
			
			
			$("#id").val("");
			
			$("#derPrograms").select2();
			$("#derModal").modal("show");
		});

		function setTable() {
			var endDeviceId = $('#endDeviceId').val();
			$('#example')
					.dataTable(
							{
								"serverSide" : true,
								"bDestroy" : true,
								"ajax" : "${pageContext.request.contextPath}/rest/edev/"+endDeviceId+"/der/list",
								"columns" : [
										{
											"data" : null,
											"render": function(data, type, row) {												
												var edi = data.endDeviceId;
												var id = data.id;
												var datas = "/edev/"+edi+"/der/"+id+"/cdp";
												return datas;
											}
										},																			
										{
											"data" : null,
											"render" : function(data, type, row) {
												//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
												var data = "&nbsp;<button type='button' onclick='deleteDER("
														+ row.id
														+ ");' class='btn btn-danger btn-xs'><i class='fa fa-trash-o'></i></button>";
												;
												return data;
											},
										},																			
										{
											"data" : null,
											"render" : function(data, type, row) {
												//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>";
												var data = "&nbsp;<button title='View Status' type='button' onclick='viewStatus("
														+ row.id
														+ ");' class='btn btn-warning btn-xs'><i class='fa fa-eye'></i></button>";
												;
												return data;
											},
										} ]

							});
		}

		$("#btnSaveDer").on("click", function(){
			
			var obj = new Object();
			obj.derPrograms = $('#derPrograms').val();
			obj.currentDERProgram = $('#currentDERProgram').val();
			console.log(obj);
			
			var endDeviceId = $('#endDeviceId').val();
			$.ajax({
				url : '${pageContext.request.contextPath}/rest/edev/'+endDeviceId+'/der/save',
				type: 'POST',
				contentType: 'application/json',
				dataType: 'json',
				data: JSON.stringify(obj),
				success : function(response, textStatus, jqXHR) {
					$("#derModal").modal("hide");
					$('#example').dataTable().fnDestroy();
					setTable();
					console.log(jqXHR);
					toastr.success('Data Saved');
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
								$("#derModal").modal("show");
							}
						},
						// callback handler that will be called on error
						error : function(jqXHR, textStatus, errorThrown) {

						}
					});
		}

		

		
		
		$('#derModal').on('hidden.bs.modal', function() {	
			$('.select2-drop').css("display","none");
		});
		
		
		function deleteDER(){
			if(confirm('Are you sure ?')){
				var endDeviceId = $('#endDeviceId').val();
				var derId = arguments[0];
				$.ajax({
					url : '${pageContext.request.contextPath}/rest/edev/'+endDeviceId+'/der/'+derId,
					type: 'DELETE',
					success : function(response, textStatus, jqXHR){
						//alert('done');
						$("#derModal").modal("hide");
						$('#example').dataTable().fnDestroy();
						setTable();
						toastr.success('Data Deleted');
					},
					error : function(jqXHR, textStatus, errorThrown) {
						toastr.error('Something is wrong. Try again later.');
						$("#derModal").modal("hide");
					}
				});
			}			
		}
		
		
		function viewStatus(){
			var endDeviceId = $('#endDeviceId').val();
			var derId = arguments[0];
			/* window.location.href = "${pageContext.request.contextPath}/rest/edev/"+endDeviceId+"/der/"+derId+"/ders/page"; */
			
			$.ajax({
					url : '${pageContext.request.contextPath}/rest/edev/'+endDeviceId+'/der/'+derId+'/ders',
					type: 'GET',
					success : function(response, textStatus, jqXHR){
						//alert('done');
						$('#derStatusForm')[0].reset();						
						if(response.status){
							var disData = ["genConnectStatus","inverterStatus","localControlModeStatus","manufacturerStatus","operationalModeStatus","stateOfChargeStatus","storageModeStatus","storConnectStatus"];
							var derStatus = response.data;														
							$.each(disData, function(index, value){
								var attr = value+"Time";
								var time = derStatus[attr];
								if(time != 0){
									var d = new Date(time * 1000);
									var dateTime = getDateTimeString(d);
									$('#'+value+'Date').val(dateTime[0]);
									$('#'+value+'Time').val(dateTime[1]);
									$('#'+value).val(derStatus[value]);
								} else {
									$('#'+value+'Date').val('');
									$('#'+value+'Time').val('');
									$('#'+value).val('');
								}
							});
							
							
						}
						$('#derStatusModal').modal("show");
					},
					error : function(jqXHR, textStatus, errorThrown) {
						
					}
				});
			
		}
		
		function getDateTimeString(){
			var d = arguments[0];
			var dateTime = [];
			var dateString, timeString;
			dateString = d.getFullYear()+"-"+eval(d.getMonth() + 1)+"-"+d.getDate();
			timeString = d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
			dateTime.push(dateString);
			dateTime.push(timeString);
			return dateTime;
		}
		
		
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
