<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Users</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- jqgrid -->
<link href="/SpringUserManagement/public/css/ui.jqgrid.css"
	rel="stylesheet" />
<link href="/SpringUserManagement/public/css/jquery-ui.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="/SpringUserManagement/public/css/custome.css">
	
<script
	src="/SpringUserManagement/public/javascripts/grid.locale-en.js"></script>
<script
	src="/SpringUserManagement/public/javascripts/jquery.jqGrid.min.js"></script>
<script src="/SpringUserManagement/public/javascripts/jquery-ui.min.js"></script>
<!-- jqgrid -->
<script src="/SpringUserManagement/public/javascripts/cookie.js" type="text/javascript"></script>
<script>
$(function () {
	var role = $.cookie("role");
	//console.log(role);
	if ( role != null && role=="admin"){
		$("#saveuser").show();
	}else if(role != null && role=="User"){
		$("#saveuser").hide();
	}else if(role != null && role=="organizer"){
		$("#saveuser").show();
	}

	var username = $.cookie("username");
	$("#usr").html("Welcome : "+username);
	//console.log(username);
});
</script>
<script>
	$(document).ready(function() {
		// Setup grid
		
		/* var user = $.cookie("token");
		
		if(user == null){
			window.location="/NEMA_Integration";
		}  */
		jQuery("#jqGrid01").jqGrid({
			url : "allUserRoll",
			datatype: "json",
			loadonce:true, 
			rowNum : 20,
			rowList : [20,30, 60, 90 ],
			colNames : [ 'id','userRollId', 'userRollType',
							'userRollDetail' ],
			colModel : [{
				name : 'id',
				index : 'id',
				editable : true,
				key: true,
				width : 60,
				sorttype : "string",
				align : "center",
				formatter : function(
						cellvalue,
						options,
						rowObject
					) {
						return "<a href="+"editStation/"+rowObject.siteID+">"+ cellvalue+ "</a>";
					}
			},
			{
				name : 'userRollId',
				index : 'userRollId',
				editable : true,
				width : 60,
				sorttype : "string",
				search : true,
				align : "center",
				formatter : function(
					cellvalue,
					options,
					rowObject
				) {
					return "<a href="+"editStation/"+rowObject.siteID+">"+ cellvalue+ "</a>";
				}
			},
			{
				name : 'userRollDetail',
				index : 'userRollDetail',
				editable : true,
				width : 80,
				align : "center"
			},
			{
				name : 'orgDetails',
				index : 'orgDetails',
				editable : true,
				width : 60,
				sorttype : "string",
				align : "center"
			},
			
			
		],
		jsonReader : {
			root : "data"
		},
			pager : "#jqGridPager01",
			viewrecords : true,
			gridview: true,
			rownumbers: true,
			add : false,
			edit : false,
			height:'auto',
			hidegrid : false

	});

		// Setup buttons
		jQuery("#jqGrid01").jqGrid('navGrid', '#jqGridPager01',
		{
			edit : false,
			add : false,
			del : false,
			search : false
		}, {
			height:'34',
			reloadAfterSubmit : true
		});
		// Setup filters
		//          jQuery("#jqGrid01").jqGrid('filterToolbar',{defaultSearch:true,stringResult:true});
		// Set grid width to #content
		$("#jqGrid01").jqGrid('setGridWidth',
			$("#content").width(), true);
			// Bootstrap customization
			
		});
</script>

</head>
<body>
<div class="container">
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<ul class="nav navbar-nav navbar-left" style="padding-right: 15px;">
				<li><a href="/SpringUserManagement/rest/login/login">User</a></li>
				<li><a href="/SpringUserManagement/rest/login/organization">Organization</a></li>
				<li><a href="/SpringUserManagement/rest/login/userroll">UserRoll</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right" style="padding-right: 15px;">
				<!-- <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Admin <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="/MyChargepoint_simulator/rest/users/userList">User Management</a></li>
						<li><a href="#">Role Management</a></li>
						<li><a href="#">User Role Assignment</a></li>
					</ul>
				</li> -->
		
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" id="usr"> <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">User Profile</a></li>
						<li><a href="#">User News </a></li>
						<li class="divider"></li>
						<li><a href="#">Logout</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
		
	<div style="padding-top: 50px;">
		<h2>User Roll Information</h2>
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
				<h4 class="modal-title">Add User Roll</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="userRegisterform">
					
					<div class="form-group">
						<label for="inputEmail" class="col-lg-3 control-label">userRollType</label>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="orgName"
								placeholder="userRollType">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail" class="col-lg-3 control-label">userRollDetail</label>
						<div class="col-lg-6">
							<input type="text" class="form-control" id="orgDetail"
								placeholder="userRollDetail">
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


<script type="text/javascript">
$(function() {
	$('#saveuser').click(function() {
		$('#userRegisterform').get(0).reset();
		$('#basicModal').modal("show");
	});
	
	$('#saveOrganization').click(function() {
		var data = {
			userRollType : $('#orgName').val(),
			userRollDetail : $('#orgDetail').val(),
		};
		$.ajax({
			url : "createUserRoll",
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