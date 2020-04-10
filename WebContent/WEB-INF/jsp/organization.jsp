<jsp:include page="header/javascript.jsp"/>
<jsp:include page="header/header.jsp"/>
<div id="wrapper">
<jsp:include page="header/leftmenu.jsp"/>
<div id="page-content-wrapper">
     <div class="container-fluid">
         <div class="row">
             <div class="col-lg-12">
              <div style="padding-top: 50px;">
		<h2>Organization Information</h2>
	</div>
	
	<div style="padding-bottom: 20px;">
		<div style="display: inline-block; width: 100px">
			<!-- <a href="add"> -->
				<button type="button" id="saveuser" class="btn btn-primary"
					data-toggle="tooltip" title="Organization">
					<i class="glyphicon glyphicon-plus"></i> Add New
				</button>
			<!-- </a> -->
		</div>
		
		<!-- <div style="display: inline-block; width: 100px; padding-left: 30px;"
			data-toggle="tooltip" title="Station">
			<button type="submit" class="btn btn-primary">
				<i class="glyphicon glyphicon-remove"></i> Delete
			</button>
		</div> -->
	</div>

	<div id="content" class="row" style="height: 400px;">
		<table id="jqGrid01"></table>
		<div id="jqGridPager01"></div>
	</div>
	
	<div class="modal fade" id="basicModal">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">X</button>
				<h4 class="modal-title">Add Organization</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="userRegisterform">
					
					<div class="form-group">
						<label for="inputEmail" class="col-lg-3 control-label">Name</label>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="orgName"
								placeholder="Organization Name">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail" class="col-lg-3 control-label">Detail</label>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="orgDetail"
								placeholder="Organization Detail">
						</div>
					</div>

				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="saveOrganization">Save
					changes</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
             </div>
         </div>
     </div>
 </div>
</div>
<script type="text/javascript">
$(function() {
	$('#saveuser').click(function() {
		$('#userRegisterform').get(0).reset();
		$('#basicModal').modal("show");
	});
	
	$('#saveOrganization').click(function() {
		var data = {
			orgName : $('#orgName').val(),
			orgDetail : $('#orgDetail').val(),
		};
		$.ajax({
			url : "create",
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			data : JSON.stringify(data),
			error : function(status) {

			},
			beforeSend : function() {

			},
			complete : function(status) {

			},
			success : function(data) {
				$('#basicModal').modal("hide");
				$("#jqGrid01").trigger("reloadGrid");
				if (data.status) {
					alert(data.status);
				}
				if (data.error) {
					alert(data.status);
				}
			}
		});
	});
});
</script>
</body>
</html>