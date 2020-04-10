<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MicroGrid</title>
<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<link href="${pageContext.request.contextPath}/public/assets/css/pages/profile.css" rel="stylesheet">
<style>
#progressbox {
	position: relative;
	width: 400px;
	border: 1px solid #ddd;
	padding: 1px;
	border-radius: 3px;
}

#progressbar {
	background-color: lightblue;
	width: 0%;
	height: 20px;
	border-radius: 4px;
}

#percent {
	position: absolute;
	display: inline-block;
	top: 3px;
	left: 48%;
}
</style>
	
</head>
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
				<!-- /.modal -->
				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

				<!-- BEGIN PAGE HEADER-->
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">User Profile</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="index.html">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> Profile </a></li>
							<li class="pull-right">
								<!-- 	<div id="dashboard-report-range" class="dashboard-date-range tooltips" data-placement="top" data-original-title="Change dashboard date range">
								<i class="fa fa-calendar"></i>
								<span>
								</span>
								<i class="fa fa-angle-down"></i>
							</div> -->
							</li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN PAGE CONTENT-->
				<div class="row profile">
					<div class="col-md-12">
						<!--BEGIN TABS-->
						<div class="tabbable tabbable-custom tabbable-full-width">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#tab_1_1" data-toggle="tab">
										Overview </a></li>
								<li><a href="#tab_1_3" data-toggle="tab"> Account </a></li>

							</ul>
							<div class="tab-content">
								<div class="tab-pane active" id="tab_1_1" style="padding:15px;">
									<div class="row">
										<div class="col-md-4">
											<ul class="list-unstyled profile-nav">
												<li>
													<img src="${pageContext.request.contextPath}/public/images/noimage.png" id="user_image" alt="" class="img-responsive" style="width: 300px;height:180px;" /></li>
											</ul>
										</div>
										<div class="col-md-8">
											<div class="row"  style="padding:15px;">
												<table class="table table-user-information">
													<tbody id="userinfo">

													</tbody>
												</table>
											</div>

											<!--end row-->

										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<h2>Address Details</h2>
											<table class="table ">
												<tbody id="addressdetail">
	
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<!--tab_1_2-->
								<div class="tab-pane" id="tab_1_3" style="padding:15px;">
									<div class="row profile-account">
										<div class="col-md-3">
											<ul class="ver-inline-menu tabbable margin-bottom-10">
												<li class="active">
													<a data-toggle="tab" href="#tab_1-1">
														<i class="fa fa-cog"></i> Personal info
													</a> 
													<span class="after"> </span>
												</li>
												<li>
													<a data-toggle="tab" href="#tab_4-4">
														<i class="fa fa-cog"></i> Address info
													</a> 
													<span class="after"> </span>
												</li>
												<li>
													<a data-toggle="tab" href="#tab_2-2"> 
														<i class="fa fa-picture-o"></i> Change Avatar
													</a>
												</li>
												<li>
													<a data-toggle="tab" href="#tab_3-3"> 
														<i class="fa fa-lock"></i> Change Password
													</a>
												</li>
											</ul>
										</div>
										<div class="col-md-9">
											<div class="tab-content">
												<div id="tab_1-1" class="tab-pane active">
													<form role="form" action="#" id="commentForm" method="post">
														
														<div class="form-group">
															<label class="control-label">Full Name</label> 
															<input type="text" id="fullName" name="name" placeholder="Full Name" class="form-control" />
														</div>
														<div class="form-group">
															<label class="control-label">Email</label> 
															<input type="text" id="email" placeholder="Email" name ="email" class="form-control" />
														</div>
														<div class="form-group">
															<label class="control-label">Display Name</label> 
															<input type="text" name="userName" id="userName" placeholder="Display Name" class="form-control" />
														</div>
														<div class="form-group">
															<label class="control-label">Mobile No</label> 
															<input type="text" name="mobile" id="mobile" placeholder="Mobile" class="form-control"  />
														</div>
														
														<div class="margiv-top-10">
															<button type="submit" class="btn green" id="savePersonalInfo">Save</button>
															 <a
																href="#" class="btn default"> Cancel </a>
														</div>
													</form>
												</div>
												
												<div id="tab_4-4" class="tab-pane">
													<form role="form" action="#" id="addressInfoFrm">
														<div class="form-group">
															<label class="control-label">Address line 1</label> 
															<input type="text" name="address_line_1" id="address_line_1" placeholder="Address line 1" class="form-control" />
														</div>
														<div class="form-group">
															<label class="control-label">Address line 2</label> 
															<input type="text" name="address_line_1" id="address_line_2" placeholder="Address line 2" class="form-control" />
														</div>
														<div class="form-group">
															<label class="control-label">Country</label> 
															<select id="country" name="country" class="form-control"></select>
														</div>
														<div class="form-group">
															<label class="control-label">State</label> 
															<select name="state" id="state" class="form-control"></select>
														</div>
														<div class="form-group">
															<label class="control-label">City</label> 
															<input type="text" name="city" id="city" placeholder="City" class="form-control" />
														</div>
														<div class="form-group">
															<label class="control-label">Zip Code</label>
															<input type="text" name="zip_code" id="zip_code" placeholder="Zip Code" class="form-control" />
														</div>
														<input type="hidden" class="form-control" id="latitude" name="latitude">
														<input type="hidden" class="form-control" id="longitude" name="longitude">
														<div class="margiv-top-10">
															<button type="submit" class="btn green" id="saveAddressInfo">Save</button>
															<a
																href="#" class="btn default"> Cancel </a>
														</div>
													</form>
												</div>
												
												
												<div id="tab_2-2" class="tab-pane">
													<form action="${pageContext.request.contextPath}/rest/users/saveimage" id="UploadForm" role="form" enctype="multipart/form-data" method="post">
														<input type="hidden" id="id" name="id">
														<div class="form-group">
															<div class="fileinput fileinput-new" data-provides="fileinput">
																<div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
																	<img src="${pageContext.request.contextPath}/public/images/noimage.png" alt="" />
																</div>
																<div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
																<div>
																	<span class="btn default btn-file"> 
																		<span class="fileinput-new"> Select image </span> 
																		<span class="fileinput-exists"> Change </span> 
																		<input type="file" name="myfile" id="myfile">
																	</span> 
																	<a href="#" class="btn default fileinput-exists" data-dismiss="fileinput"> Remove </a>
																</div>
															</div>
															<div class="clearfix margin-top-10">
																<span class="label label-danger"> NOTE! </span> 
																<span>
																	Attached image thumbnail is supported in Latest
																	Firefox, Chrome, Opera, Safari and Internet Explorer 10
																	only 
																</span>
															</div>
														</div>
														<div id="progressbox">
													         <div id="progressbar"></div>
													         <div id="percent">0%</div>
													    </div>
													    <div id="message"></div>
													    
														<div class="margin-top-10">
															<input type="submit" class="btn green" value="Upload">
															<a href="#" class="btn default"> Cancel </a>
														</div>
													</form>
												</div>
												<div id="tab_3-3" class="tab-pane">
													<form action="#" method="post" id="changePasswordFrm">
														<div class="form-group">
															<label class="control-label">Current Password</label> <input
																type="password" name="oldPassword" id="oldPassword" class="form-control" />
														</div>
														<div class="form-group">
															<label class="control-label">New Password</label> <input
																type="password" name="newPassword" id="newPassword" class="form-control" />
														</div>
														<div class="form-group">
															<label class="control-label">Re-type New Password</label>
															<input type="password" name="re_password" id="re_password" class="form-control" />
														</div>
														<div class="margin-top-10">
															<button type="submit" class="btn green" id="changePassword">Change Password</button>
															<a href="#" class="btn default"> Cancel </a>
														</div>
													</form>
												</div>


											</div>
										</div>
										<!--end col-md-9-->
									</div>
								</div>
								<!--end tab-pane-->

							</div>
							<!--END TABS-->
						</div>
					</div>
					<!-- END PAGE CONTENT-->

				</div>
			</div>
			<!-- END CONTENT -->
		</div>
		<!-- END CONTAINER -->

	</div>
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
	<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
	<!-- <script type="text/javascript" src="//maps.googleapis.com/maps/api/js?sensor=false"></script> -->
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyAn7bnyIGQZso-Mmkvxf-dJtrcWgSdo0wU"></script>
	<script>
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			Index.init();
			UIToastr.init();
		});
		
		$(document).ready(function(){
			populateCountries("country", "state");
			loadUserDetails();
			var options = {
			        beforeSend : function() {
			                $("#progressbox").show();
			                // clear everything
			                $("#progressbar").width('0%');
			                $("#message").empty();
			                $("#percent").html("0%");
			        },
			        uploadProgress : function(event, position, total, percentComplete) {
			                $("#progressbar").width(percentComplete + '%');
			                $("#percent").html(percentComplete + '%');

			                // change message text to red after 50%
			                if (percentComplete > 50) {
			                $("#message").html("<font color='red'>File Upload is in progress</font>");
			                }
			        },
			        success : function() {
			                $("#progressbar").width('100%');
			                $("#percent").html('100%');
			        },
			        complete : function(response) {
				        $("#message").html("<font color='blue'>Your file has been uploaded!</font>");
				        loadUserDetails();
			        },
			        error : function() {
			        	$("#message").html("<font color='red'> ERROR: unable to upload files</font>");
			        }
			};
			$("#UploadForm").ajaxForm(options);
		});
				
		function loadUserDetails(){
			var token = $.cookie("token");			
			if(token!="" && token!=null){
				var data = '{"dynamicToken":"'+token+'"}';
				$.ajax({
					url : "${pageContext.request.contextPath}/rest/users/gettokeninfo",
					type : "POST",
					contentType : "application/json",
					dataType : "json",
					data : data,
					success : function(response) {
					  if(response.data){
						 var data = response.data;
						 var userinfo = '<tr>';
						 userinfo += '<td>Name</td><td>'+data['fullname']+'</td></tr>';
						 userinfo += '<tr><td>Email</td><td>'+data['email']+'</td></tr>';
						 userinfo += '<tr><td>User Name</td><td>'+data['userName']+'</td>';
						 userinfo += '<tr><td>Mobile</td><td>'+data['mobile']+'</td>';
						 userinfo += '</tr>';
						 $("#userinfo").html(userinfo);
						 var address = '<tr><td>Address 1</td><td>'+data['address_line_1']+'</td></tr>';
						 address += '<tr><td>Address 2</td><td>'+data['address_line_2']+'</td></tr>';
						 address += '<tr><td>City</td><td>'+data['city']+'</td></tr>';
						 address += '<tr><td>State</td><td>'+data['state']+'</td></tr>';
						 address += '<tr><td>Country</td><td>'+data['country']+'</td></tr>';
						 address += '<tr><td>Zip Code</td><td>'+data['zip_code']+'</td></tr>';
						 if(data['image']){
							$("#user_image").prop("src","${pageContext.request.contextPath}"+data['image']);	
							$.cookie("image",data['image'],{path: '/'});
							$("#login_user_pic").prop("src","${pageContext.request.contextPath}"+data['image']);
						 }
						 $("#addressdetail").html(address);
						 $("#fullName").val(data['fullname']);
						 $("#email").val(data['email']);
						 $("#userName").val(data['userName']);
						 $.cookie("username",data['userName'],{path: '/'});
						 $("#mobile").val(data['mobile']);
						 $("#address_line_1").val(data['address_line_1']);
						 $("#address_line_2").val(data['address_line_2']);
						 $("#city").val(data['city']);
						 $("#country").val(data['country']);
						 $("#country").change();
						 $("#state").val(data['state']);
						 $("#zip_code").val(data['zip_code']);
						 $("#id").val(data['id']);
					  }else{
						 
					  }
					}
			    });
			}
		}
		$("#commentForm").validate({
			rules: {
				name: "required",
				email: "required",
				mobile: "required",
				userName: "required",
				name: {
					required: true,
					minlength: 2
				},
				
				email: {
					required: true,
					email: true
				},
				mobile: {
					required: true,
					minlength: 2
				},
				userName: {
					required: true,
					minlength: 2
				}
			},
			messages: {
				name: "Please enter your fulll name",
				email: "Please enter a valid email address",
				mobile: "Please enter a valid mobile no",
				userName: "Please enter your display name"
			}
		});
		$("#savePersonalInfo").click(function(){
		
			console.log("valid = "+$('#commentForm').validate().form());
			$('#commentForm').validate().form();
			console.log("valid = "+$('#commentForm').valid());
			if($('#commentForm').valid()){
				if($("#id").val()!=""){
					var personinfo = {
						id : $("#id").val(),
						fullname:$("#fullName").val(),
						email:$("#email").val(),
						userName:$("#userName").val(),
						mobile:$("#mobile").val(),
						address_line_1:$("#address_line_1").val(),
						address_line_2:$("#address_line_2").val(),
						country:$("#country").val(),
						state:$("#state").val(),
						city:$("#city").val(),
						zip_code:$("#zip_code").val(),
						latitude:$("#latitude").val(),
						longitude:$("#longitude").val()
					};
					var data = JSON.stringify(personinfo);
					$.ajax({
						url : "${pageContext.request.contextPath}/rest/users/save",
						type : "POST",
						contentType : "application/json",
						dataType : "json",
						data : data,
						success : function(response) {
						  if(response.status==true){
							  var userName = $("#userName").val();
							 toastr.success('Personal information is update successfully.');
							 $.cookie("username",userName,{ path: '/'});
							 $("#user_name").html(userName);
							 loadUserDetails();
						  }else{
							  toastr.error('Personal information is not update successfully.')
						  }
						}
				    });
				}
				return false;
			}else{
				
				return false;
			}
		})
		
		$("#addressInfoFrm").validate({
			rules: {
				address_line_1: "required",
				country: "required",
				state: "required",
				city: "required",
				zip_code: "required",
				address_line_1: {
					required: true,
					minlength: 2
				},
				
				country: {
					required: true,
				},
				zip_code: {
					required: true,
					minlength: 2
				},
				city: {
					required: true,
					minlength: 2
				},
				state: {
					required: true,
				}
			},
			messages: {
				address_line_1: "Please enter your address",
				country: "Please select country",
				state: "Please select state",
				city: "Please enter your city name",
				zip_code: "Please enter Zip Code"
			}
		});
		$("#saveAddressInfo").click(function(){
			if($("#addressInfoFrm").valid()){
				getLatLong($("#zip_code").val(),function(geocode){
					  console.log(geocode)
					   $('#latitude').val(geocode.A)
					   $('#longitude').val(geocode.F)
					   if($("#id").val()!=""){
							var personinfo = {
									fullname:$("#fullName").val(),
									email:$("#email").val(),
									userName:$("#userName").val(),
									mobile:$("#mobile").val(),	
								id : $("#id").val(),
								address_line_1:$("#address_line_1").val(),
								address_line_2:$("#address_line_2").val(),
								country:$("#country").val(),
								state:$("#state").val(),
								city:$("#city").val(),
								zip_code:$("#zip_code").val(),
								latitude:$("#latitude").val(),
								longitude:$("#longitude").val()
							};
							var data = JSON.stringify(personinfo);
							$.ajax({
								url : "${pageContext.request.contextPath}/rest/users/save",
								type : "POST",
								contentType : "application/json",
								dataType : "json",
								data : data,
								success : function(response) {
								  if(response.status==true){
									 toastr.success('Address information is update successfully.!');
									 loadUserDetails();
								  }else{
									 toastr.error('Address information not update.!');
								  }
								}
						    });
						}
					  return false;
				});
			  
				return false;
			}
			return false;
		});
		$("#changePasswordFrm").validate({
			rules: {
				oldPassword: "required",
				newPassword: "required",
				re_password: {
					equalTo: "#newPassword"	
				},
				
				newPassword: {
					required: true,
					minlength: 5
				},
				oldPassword: {
					required: true,
					minlength: 2
				}
			},
			messages: {
				oldPassword: "Please enter your old password",
				newPassword: "Please enter new password",
				re_password: "Re-type New Password does not match",
			}
		});
		
		$("#changePassword").click(function(){
			if($("#changePasswordFrm").valid()){
				var repassword = $("#re_password").val();
				var newPassword = $("#newPassword").val();
				if($("#id").val()!="" && repassword==newPassword && newPassword!=""){
					var personinfo = {
						id : $("#id").val(),
						oldPassword:$("#oldPassword").val(),
						newPassword:newPassword
					};
					var data = JSON.stringify(personinfo);
					$.ajax({
						url : "${pageContext.request.contextPath}/rest/users/savechangepassword",
						type : "POST",
						contentType : "application/json",
						dataType : "json",
						data : data,
						success : function(response) {
							if(response.status=="1"){
								toastr.success('Password update successfully.!');
							}else if(response.status=="0"){
								toastr.error("Old Password not match.!");
							}else{
								toastr.error("Password not change.!");								
							}
							$("#oldPassword").val("");
							$("#newPassword").val("");
							$("#re_password").val("");
						}
				    });
				}
				return false;
			}
			return false;
		});
		
	</script>
</body>
</html>
