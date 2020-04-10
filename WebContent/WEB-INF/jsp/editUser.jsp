<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registor</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>



<!-- date picket -->

<!-- date picket -->

</head>

<body>

<div class="header_main">
<div class="navbar navbar-default navbar-fixed-top">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/SpringIntegration/rest/home/index">Home</a>
			<div class="navbar-collapse collapse navbar-responsive-collapse">
				<ul class="nav navbar-nav navbar-right" style="padding-right: 15px;">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Admin <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="/MyChargepoint_simulator/rest/users/userList">User
									Management</a></li>
							<li><a href="#">Role Management</a></li>
							<li><a href="#">User Role Assignment</a></li>
						</ul>
					</li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Welcome : admin@grid-scape.com <b
							class="caret"></b></a>
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
</div>

<div class="body_main" style="padding-top: 50px;padding-bottom:20px;">
<div class="container">
	<hr style="border-top:1px solid #CACAC7;">
		<div>
			<h4>User Details</h4>
		</div>
	<hr style="border-top:1px solid #CACAC7;">
	<form class="form-horizontal">
<div class="col-lg-6">
	<%-- <div class="form-group">
		<label for="inputEmail" class="col-lg-4 control-label">Organization</label>
		<div class="col-lg-8">
			 <select class="form-control" id="orgId">
				<option>SELECT</option>
			<%
				Map<Long,String> map = (Map)request.getAttribute("org");
												Iterator<Map.Entry<Long, String>> i = map.entrySet().iterator();
												while (i.hasNext()) {
													Long key = i.next().getKey();
			%>
			<option value="<%=key%>"><%=map.get(key)%></option>
			<%
				}
			%>
			</select> 
		</div>
	</div> --%>
	
	<%-- <div class="form-group">
		<label for="inputEmail" class="col-lg-4 control-label">CPN</label>
		<div class="col-lg-8">
			<select class="form-control" id="cpnId">
			<%
				Map<Long,String> cpnMap = (Map)request.getAttribute("cpn");
					Iterator<Map.Entry<Long, String>> itr = cpnMap.entrySet().iterator();
					while (itr.hasNext()) {
						Long key = itr.next().getKey();
			%>
			<option value="<%=key%>"><%=cpnMap.get(key)%></option>
			<%
				}
			%>
		</select>
		</div>
	</div> --%>
	<div class="form-group">
		<label for="inputUserId" class="col-lg-4 control-label">User Id</label>
		<div class="col-lg-8">
			<input type="text" class="form-control" id="userid"
				placeholder="User Id">
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputFirstName" class="col-lg-4 control-label">First Name</label>
		<div class="col-lg-8">
			<input type="text" class="form-control" id="firstname"
				placeholder="First Name">
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputMiddleName" class="col-lg-4 control-label">Last Name</label>
		<div class="col-lg-8">
			<input type="text" class="form-control" id="lastname"
				placeholder="Last Name">
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputGender" class="col-lg-4 control-label">Organization Id</label>
		<div class="col-lg-8">
			<select class="form-control" id="gender">
				<option value=Male>Male</option>
				<option value=Female>Female</option>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label for="inputGender" class="col-lg-4 control-label">Roll Type</label>
		<div class="col-lg-8">
			<select class="form-control" id="gender">
				<option value=Male>Male</option>
				<option value=Female>Female</option>
			</select>
		</div>
	</div>
			
</div>



<div class="col-lg-6">
	
	<div class="form-group">
		<label for="inputUserName" class="col-lg-4 control-label">User Name</label>
		<div class="col-lg-8">
			<input type="text" class="form-control" id="username"
				placeholder="User Name">
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword" class="col-lg-4 control-label">Password</label>
		<div class="col-lg-8">
			<input type="text" class="form-control" id="password" placeholder="Password">
		</div>
	</div>
	
</div>












<!-- date picket -->

<!-- date picket -->
</form>

<br>
<br>
<br>
<hr style="clear: both;border-top:1px solid #CACAC7;">
<div style="clear: both; float: right;padding-bottom: 20px;">

	<button type="button" class="btn btn-default" id="close">Close</button>
	<button type="button" class="btn btn-primary" id="save">Save</button>
</div>

</div>

</div>

<script type="text/javascript">
	$("#close").click(function() {
		window.location.href = "/SpringUserManagement/rest/login/login";
	});

	$("#save").click(function() {
	//	var details = ',"cpn":{"id":"'+$("#cpnId").val()+'"},"orgId":{"id":"' + $("#orgId").val() + '"}}';
		var newdata = {
			firstName  : $("#firstname").val(),
			lastName : $("#lastname").val(),
		};
		var data = JSON.stringify(newdata);
	//	data = data.substring(0, (data.length - 1));
	//	data += details;
		if (data != '') {
			$.ajax({
				url : "createUser",
				type : "POST",
				contentType : "application/json",
				dataType : "json",
				data : data,
				success : function(data) {
					if (data != "") {
						/* alert("Record Save Successfully..."); */
						window.location.href = "/SpringUserManagement/rest/login/login";
					}
				}
			});
		}
	});
</script>
</body>
</html>