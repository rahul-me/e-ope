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
						<h3 class="page-title">Client</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="index.html">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> Client </a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-user"></i>Client
						</div>						
					</div>
					<div class="portlet-body">
						<div class="row">
							<form>
								<div class="col-md-12">
									<div class="form-group">
										<label>URL</label>
										<input type="url" id="url" class="form-control">
									</div>								
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>User Name</label>
										<input type="text" class="form-control" id="userName">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>Password</label>
										<input type="password" class="form-control" id="password">
									</div>
								</div>	
								<div class="col-md-12">	
									<button type="button" class="btn btn-primary" id="submit">Submit</button>
								</div>					
							</form>
						</div>											
					</div>
				</div>
				<div class="clearfix"></div>
				
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
	<!-- END CONTAINER -->
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
	<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
	<!-- END JAVASCRIPTS -->
</body>
<script>
	$("#submit").click(function(){
		var client = {
			url:$("#url").val(),
			userName:$("#userName").val(),
			password:$("#password").val()
		};
		var data = JSON.stringify(client);
		console.log(data);
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/client/getdata",
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			data:data,
			success : function(response, textStatus, jqXHR) {
				
			},
			// callback handler that will be called on error
			error : function(jqXHR, textStatus, errorThrown) {

			}
		});
	});
</script>
