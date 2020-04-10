<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header/javascript.jsp" />
<jsp:include page="header/header.jsp" />
<div id="wrapper">
	<jsp:include page="header/leftmenu.jsp" />
	<div id="page-content-wrapper">

		<hr style="border-top: 1px solid #CACAC7;">
		<div>
			<h4>User Details</h4>
		</div>
		<hr style="border-top: 1px solid #CACAC7;">
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
					<label for="inputUserId" class="col-lg-4 control-label">User
						Id</label>
					<div class="col-lg-8">
						<input type="text" class="form-control" id="userid"
							placeholder="User Id">
					</div>
				</div>

				<div class="form-group">
					<label for="inputFirstName" class="col-lg-4 control-label">First
						Name</label>
					<div class="col-lg-8">
						<input type="text" class="form-control" id="firstname"
							placeholder="First Name">
					</div>
				</div>

				<div class="form-group">
					<label for="inputMiddleName" class="col-lg-4 control-label">Last
						Name</label>
					<div class="col-lg-8">
						<input type="text" class="form-control" id="lastname"
							placeholder="Last Name">
					</div>
				</div>

				<div class="form-group">
					<label for="inputGender" class="col-lg-4 control-label">Organization
						Id</label>
					<div class="col-lg-8">
						<select class="form-control" id="orgId">
							<option></option>
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
				</div>

				<div class="form-group">
					<label for="inputGender" class="col-lg-4 control-label">Roll
						Type</label>
					<div class="col-lg-8">
						<select class="form-control" id="userRollType">
							<option>SELECT</option>
							<%
								Map<Long,String> mapUserRoll = (Map)request.getAttribute("userroll");
												System.out.println("map on jsp : "+mapUserRoll);
												Iterator<Map.Entry<Long, String>> iroll = mapUserRoll.entrySet().iterator();
												while (iroll.hasNext()) {
													Long key = iroll.next().getKey();
							%>
							<option value="<%=key%>"><%=mapUserRoll.get(key)%></option>
							<%
								}
							%>
						</select>
					</div>
				</div>

			</div>
			<div class="col-lg-6">

				<div class="form-group">
					<label for="inputUserName" class="col-lg-4 control-label">User
						Name</label>
					<div class="col-lg-8">
						<input type="text" class="form-control" id="username"
							placeholder="User Name">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="col-lg-4 control-label">Password</label>
					<div class="col-lg-8">
						<input type="text" class="form-control" id="password"
							placeholder="Password">
					</div>
				</div>

			</div>












			<!-- date picket -->

			<!-- date picket -->
		</form>

		<br> <br> <br>
		<hr style="clear: both; border-top: 1px solid #CACAC7;">
		<div style="clear: both; float: right; padding-bottom: 20px;">

			<button type="button" class="btn btn-default" id="close">Close</button>
			<button type="button" class="btn btn-primary" id="save">Save</button>
		</div>

	</div>

</div>
</div>
<script type="text/javascript">
	$("#close").click(function() {
		window.location.href = "/SpringUserManagement/rest/login/login";
	});
	var orgId = $.cookie("org");
	console.log(orgId)
	$("#save")
			.click(
					function() {
						if (orgId != null) {
							var details = ',"userRollType":{"id":"'
									+ $("#userRollType").val()
									+ '"},"orgId":{"id":"' + orgId + '"}}';
						} else {
							var details = ',"userRollType":{"id":"'
									+ $("#userRollType").val()
									+ '"},"orgId":{"id":"' + $("#orgId").val()
									+ '"}}';
						}

						var newdata = {
							firstName : $("#firstname").val(),
							lastName : $("#lastname").val(),
							userName : $("#username").val(),
							password : $("#password").val(),
						};
						var data = JSON.stringify(newdata);
						data = data.substring(0, (data.length - 1));
						data += details;
						if (data != '') {
							$
									.ajax({
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