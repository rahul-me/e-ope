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
						<h3 class="page-title">Role</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="index.html">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> Role </a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-user"></i>Role
						</div>
						<div class="tools">
							<a href="" class="collapse"> </a> <a href="#portlet-config"
								data-toggle="modal" class="config"> </a> <a href=""
								class="reload"> </a> <a href="" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="btn-group">
								<form class="form-inline">
								    <div class="form-group">
								        <label class="sr-only" for="inputEmail">Role</label>
								        <input type="hidden" id="id">
								        <input type="text" class="form-control" id="userRollType" placeholder="Role">
								    </div>
								    <button type="button" class="btn info" id="saveRoll">
										<i class="fa fa-save"></i> Save
									</button>
								</form>
								
							</div>
							<div class="btn-group pull-right">
								<button class="btn dropdown-toggle" data-toggle="dropdown">
									Tools <i class="fa fa-angle-down"></i>
								</button>
								<ul class="dropdown-menu pull-right">
									<li><a href="#"> Print </a></li>
									<li><a href="#"> Save as PDF </a></li>
									<li><a href="#"> Export to Excel </a></li>
								</ul>
							</div>
						</div>

						<table id="example"
							class="display table table-striped table-bordered table-hover"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>Name</th>
									<th>Action</th>
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
	<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
	
	<!-- END JAVASCRIPTS -->
	<script>
	  $(document).ready(function() {
		  setTable();				
	  });
		
	  function setTable(){
		  $('#example').dataTable({
			"ajax" : "${pageContext.request.contextPath}/rest/role/rolllist",
			"bProcessing" : true,
			"columns" : [
					{
						"data" : "role"
					},
					{
						"data":null,
						"render" : function(data, type, row) {
							var append = "<button type='button' class='btn btn-sm' onclick='editRoll("+row.id+");'><i class='fa fa-edit'></i></button>";
							return append;
						}
					},
				]
		  });
	  }	
	  $("#saveRoll").click(function(){
		  if($("#userRollType").val()!=""){
			  var data = '';
			  if($("#id").val()!=""){
				  data = '{"id":"'+$("#id").val()+'","role":"'+$("#userRollType").val()+'"}';  
			  }else{
				  data = '{"role":"'+$("#userRollType").val()+'"}';
			  }
			   
			  $.ajax({
					url : "${pageContext.request.contextPath}/rest/role/save",
					type : "POST",
					contentType : "application/json",
					dataType : "json",
					data : data,
					success : function(response, textStatus, jqXHR) {
						$("#userRollType").val("");
						$('#example').dataTable().fnDestroy();
						setTable();
					},
					// callback handler that will be called on error
					error : function(jqXHR, textStatus, errorThrown) {

					}
			  });
		  }
	  });
	 function editRoll(id){
		 $.ajax({
				url : "${pageContext.request.contextPath}/rest/role/edit/"+id,
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response, textStatus, jqXHR) {
					if(response.data){
						$("#userRollType").val(response.data['role']);	
						$("#id").val(response.data['id']);
					}
					
				},
				// callback handler that will be called on error
				error : function(jqXHR, textStatus, errorThrown) {

				}
		  });
	 }
	</script>
</body>
<!-- END BODY -->
</html>