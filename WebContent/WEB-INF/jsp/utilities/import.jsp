<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<style>
.modal {
	
}

.vertical-alignment-helper {
	display: table;
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
	width: inherit;
	height: inherit;
	/* To center horizontally */
	margin: 0 auto;
}
</style>
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
							<li><i class="fa fa-home"></i> <a
								href="${pageContext.request.contextPath}/rest/micro/list">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> Import Interval Data </a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">Import Interval Data</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body form">
						<!-- <div class="table-toolbar">
							<div class="col-md-12" style="padding: 0px;">
								<button id="import_utlity_data" class="btn">
									Import <i class="glyphicon glyphicon-import"></i>
								</button>
							</div>
						</div> -->
						<form class="form-horizontal" id="importUtilityFrm" method="POST"
							action="${pageContext.request.contextPath}/rest/utility/upload"
							enctype="multipart/form-data">
							<div class="form-body">
								<div class="form-group">
									<label class="col-md-3 control-label">Name<span
										class="required"> * </span>
									</label>
									<div class="col-md-4">
										<div class="input-icon">
											<i class="fa fa-user"></i>
											<input type="text" name="name" class="form-control"
												placeholder="Name">
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">Email Address<span
										class="required"> * </span></label>
									<div class="col-md-4">
										<div class="input-icon">
											<i class="fa fa-envelope"></i>
											<input type="email" class="form-control" name="email"
												placeholder="Email Address">
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label">Contact No.<span
										class="required"> * </span></label>
									<div class="col-md-4">
										<div class="input-icon">
											<i class="fa fa-bell-o"></i> <input type="text"
												class="form-control" name="contact_no"
												placeholder="Contact No">
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">Utility Format<span
										class="required"> * </span></label>
									<div class="col-md-4">
										<div class="input-icon right">
											<select class="form-control" name="utility_format"
												id="utility_format">
												<option value="">Select</option>
												<option value="1">Format 1</option>
												<option value="2">Foothill College PGE Interval
													Data</option>
											</select>

										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">Data In<span
										class="required"> * </span></label>
									<div class="col-md-4">
										<div class="radio-list" data-error-container="#form_2_membership_error">
											<label> <input type="radio" name="data_in" value="kw" />
												kW
											</label> <label> <input type="radio" name="data_in"
												value="kwh" checked /> kWh
											</label>
										</div>
										<div id="form_2_membership_error">
											</div>
										
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label">Upload Utility
										Data<span class="required"> * </span>
									</label>
									<div class="col-md-7">
										<div class="fileinput fileinput-new" data-provides="fileinput">
											<input type="hidden">
											<div class="input-group ">
												<div class="form-control uneditable-input span3"
													data-trigger="fileinput">
													<i class="fa fa-file fileinput-exists"></i>&nbsp; <span
														class="fileinput-filename"> </span>
												</div>
												<span class="input-group-addon btn default btn-file">
													<span class="fileinput-new"> Select file </span> <span
													class="fileinput-exists"> Change </span> <input type="file"
													name="file" id="utility_file">
												</span> <a href="#"
													class="input-group-addon btn default fileinput-exists"
													data-dismiss="fileinput">Remove</a>
											</div>
										</div>
									</div>
								</div>

							</div>
							<div class="form-actions fluid">
								<div class="col-md-offset-3 col-md-9">
									<button type="submit" class="btn blue">Submit</button>
									<button type="reset" class="btn default">Cancel</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
	<div id="loadModal" class="modal fade" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 257px; text-align: center;">
				<div class="modal-body">
					<b>We are uploading your energy interval data please wait or do
						not refresh page...!</b>
				</div>
			</div>
		</div>
	</div>
	<!-- END CONTAINER -->
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
	<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
	<!-- END JAVASCRIPTS -->
	<script>
		jQuery(document)
				.ready(
						function() {
							App.init();
							Index.init();
							var options = {
								beforeSend : function() {
									if ($("#importUtilityFrm").valid()) {
										$("#progressbox").show();
										// clear everything
										$("#progressbar").width('0%');
										$("#message").empty();
										$("#percent").html("0%");
										$("#import_csv_utility").modal("hide");
										$('#loadModal').modal({
											backdrop : 'static',
											keyboard : false
										});
										$('#loadModal').modal("show");
									} else {
										return false;
									}
								},
								uploadProgress : function(event, position,
										total, percentComplete) {
									$("#progressbar").width(
											percentComplete + '%');
									$("#percent").html(percentComplete + '%');

									// change message text to red after 50%
									if (percentComplete > 50) {
										$("#message")
												.html(
														"<font color='red'>File Upload is in progress</font>");
									}
								},
								success : function() {
									$("#progressbar").width('100%');
									$("#percent").html('100%');
								},
								complete : function(response) {
									$('#importUtilityFrm')[0].reset();
									$("#import_csv_utility").modal("hide");
									$('#loadModal').modal("hide");
									toastr.success("utility interval data upload successfully");
									return false;
								},
								error : function() {
									alert("error");
								}
							};
							$("#importUtilityFrm").ajaxForm(options);
						});

		$("#importUtilityFrm").validate({
			rules : {
				name : "required",
				email : "required",
				contact_no : "required",
				data_in : "required",
				utility_format : "required",
				name : {
					required : true,
				},
				email : {
					required : true,
				},
				contact_no : {
					required : true,
				},
				data_in : {
					required : true,
				},
				utility_format : {
					required : true,
				}
			},
			messages : {
				name : "Please enter name",
				email : "Please enter email",
				contact_no : "Please enter contact no",
				data_in : "Please select data in",
				utility_format : "Please select utility format",
			}
		});
	</script>
</body>
<!-- END BODY -->
</html>