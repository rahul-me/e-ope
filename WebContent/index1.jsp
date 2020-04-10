<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MicroGrid OS</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="public/css/bootstrap.min.css">
<link rel="stylesheet" href="public/css/font-awesome.css">
<!-- jQuery library -->
<script src="public/javascripts/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="public/javascripts/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="public/javascripts/cookie.js" type="text/javascript"></script>
<script src="public/javascripts/jquery.backstretch.min.js" type="text/javascript"></script>


</head>
<body>

<div class="container">
    <div style="padding-top: 80px;"></div>
        <div class="row" id="login_user">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login-</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" name="loginForm" method="POST" >
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" id="email" placeholder="E-mail" name="email" type="email" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id="password" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label style="font-weight: bold;">
                                        <input name="remember" id="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                    <span class="pull-right">
                                    	<a data-toggle="modal" href="#" class="forgot_btn" > Forgot Password?</a>
                                	</span>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <!--<a href="/NEMA_Integration/rest/home/index" class="btn btn-lg btn-success btn-block">Login</a>-->
								<div class="buttondiv" style="padding-bottom:10px">
									<button type="button" id="loginuser" class="btn btn-lg btn-success btn-block" type="button">
										Login 
									</button>
								</div>
								
								<!--<a href="/NEMA_Integration/rest/home/registration">Registor Here</a>-->
								
                            </fieldset>
                        </form>
                         <div class="registration">Don't have an account yet? <a class="register_user" href="#">Create an account</a></div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row" id="register">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Create Your Account</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" >
                            <fieldset>
                            <div class="form-group">
                                    <input class="form-control" id="fname" placeholder="First name"  type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id="lname" placeholder="last name"type="text" >
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id="email" placeholder="E-mail" name="email" type="email" >
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id="password" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id="re-password" placeholder="Re -Password" name="password" type="password" value="">
                                </div>
                                <div class="checkbox">
                                    <label style="font-weight: bold;">
                                        <input name="remember" id="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <!--<a href="/NEMA_Integration/rest/home/index" class="btn btn-lg btn-success btn-block">Login</a>-->
								<div class="buttondiv" style="padding-bottom:10px">
									<button class="btn btn-success btn-lg btn-block btn-auth" id="register_user_btn" type="button">
									
									<i class="fa fa-check-circle"></i> Create Account
									</button>
								</div>
                            </fieldset>
                        </form>
                        <div class="registration">
                           if you have account ? <a class="login_btn" href="#">login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        
         <div class="row" id="forgotpass">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Reset Password</h3>
                    </div>
                     <div class="panel-body">
                      <form role="form" >
                        <fieldset>
	                        <div class="form-group">
	                      	<p>Enter your e-mail address below to reset your password.</p>
	                      	<input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
	                     	</div>	
	                      	<div class="buttondiv" style="padding-bottom:10px">
							<button class="btn btn-success btn-lg btn-block btn-auth" id="register_user_btn">
							<i class="fa fa-check-circle"></i> Send
							</button>
						</div>
						 </fieldset>
						</form >
						<div class="registration">Don't have an account yet? <a class="register_user" href="#">Create an account</a></div>
                     </div>
					 
                </div>
            </div>
        </div>
    </div>
</body>
<script>
 $(document).ready(function() {
	/*  $('#loginuser').click(function(){
		 window.location.href = "/SpringUserManagement/rest/login/login";
	 }); */
	 $('#login_user').show();
	 $('#forgotpass').hide();
	 $('#register').hide();
	 
	 $('.register_user').click(function(){
		 $('#forgotpass').hide();
		 $('#register').show();
		 $('#login_user').hide();
		 
	 });
	 $('.login_btn').click(function(){
		 $('#forgotpass').hide();
		 $('#register').hide();
		 $('#login_user').show();
		 
	 });
	 $('.forgot_btn').click(function(){
		 $('#forgotpass').show();
		 $('#register').hide();
		 $('#login_user').hide();
	 });
	 $.backstretch("public/css/images/back_ground.jpg");
	 $('#register_user_btn').click(function(){
			var newdata = {
				firstName: $('#register').find("#fname").val(),
				lastName : $('#register').find("#lname").val(),
				userName : $('#register').find("#email").val(),
				password : $('#register').find("#password").val(),
			};
			console.log(newdata);
			var data = JSON.stringify(newdata);
			//data = data.substring(0, (data.length - 1));
			//data += details;
			$.ajax({
				url : "rest/login/createUser",
				type : "POST",
				contentType : "application/json",
				dataType : "json",
				data : data,
				success : function(data) {
					console.log(data);
					if (data != "") {
						/* alert("Record Save Successfully..."); */
						//window.location.href = "/SpringUserManagement/rest/login/login";
					}
				}
			});
	 });
	 
	 
	 
	   $('#loginuser').click(function(){
		   var newdata = {
		    userName  :$('#login_user').find("#email").val(),
		    password : $('#login_user').find("#password").val()
		   };
		   var data = JSON.stringify(newdata);
		   if (data != '') {
		    $.ajax({
		     url : "rest/login/dologin",
		     type : "POST",
		     contentType : "application/json",
		     dataType : "json",
		     data : data,
		     success : function(data) {
		       if(data.status == "true"){
		        //alert("Record Save Successfully...");
		        	$.cookie("username",data.username,{ path: '/'});
		              $.cookie("role", data.role,{ path: '/'});
		              $.cookie("token", data.token,{ path: '/'});
		              $.cookie("org", data.orgId,{ path: '/'});
       			 window.location.href = "rest/home/index.jsp";
		       }else{
		       
		       }
		     }
		    });
		   }
		   }); 
		  
 });
 </script>
</html>