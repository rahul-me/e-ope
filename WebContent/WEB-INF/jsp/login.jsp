<jsp:include page="bootstrapheader/css.jsp"></jsp:include>

<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="login page-header-fixed page-full-width page-footer-fixed-mobile page-footer-fixed">
<jsp:include page="bootstrapheader/top-menu.jsp"></jsp:include>
<div class="clearfix" style="padding-top:50px">
</div>
<!-- BEGIN CONTAINER -->
<div class="text-center" style="padding:10px;">
	<img alt="" src="${pageContext.request.contextPath}/public/images/logos.png" style="height:45px">
</div>
<div class="content">
	<!-- BEGIN LOGIN FORM -->
	
	<form class="login-form" method="post" id="login_user">
		<h3 class="form-title">Login to your account</h3>
		<div class="alert alert-danger display-hide">
			<button class="close" data-close="alert"></button>
			<span>
				 Enter any username and password.
			</span>
		</div>
		<div class="form-group">
			<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
			<label class="control-label visible-ie8 visible-ie9">Email-</label>
			<div class="input-icon">
				<i class="fa fa-user"></i>
				<input class="form-control placeholder-no-fix" type="email" autocomplete="off" placeholder="Email Address" name="email" id="email" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Password</label>
			<div class="input-icon">
				<i class="fa fa-lock"></i>
				<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="Password" name="password" id="password" />
			</div>
		</div>
		<div class="form-actions" style="padding: 0px 30px 5px 48px;">
			<label class="checkbox">
			<input type="checkbox" name="remember" value="1"/> Remember me </label>
			<button type="submit" class="btn blue pull-right" id="loginuser">
				Login <i class="m-icon-swapright m-icon-white"></i>
			</button>
		</div>
		<div class="forget-password">
			<a href="javascript:;"><h4 id="forget-password">Forgot your password ?</h4></a>
		</div>
		  
	   <div class="create-account">
			<p>
				 Don't have an account yet ?&nbsp;
				<a href="javascript:;" id="register-btn">
					 Create an account
				</a>
			</p>
		</div>	
	</form>
	<!-- END LOGIN FORM -->
	<!-- BEGIN FORGOT PASSWORD FORM -->
	<form class="forget-form" method="post">
		<h3>Forget Password ?</h3>
		<p>
			 Enter your e-mail address below to reset your password.
		</p>
		<div class="form-group">
			<div class="input-icon">
				<i class="fa fa-envelope"></i>
				<input class="form-control placeholder-no-fix" type="text" id="fEmail" autocomplete="off" placeholder="Email" name="email"/>
			</div>
		</div>
		<div class="form-actions">
			<button type="button" id="back-btn" class="btn">
			<i class="m-icon-swapleft"></i> Back </button>
			<button type="submit" id="forgot_btn" class="btn blue pull-right">
			Submit <i class="m-icon-swapright m-icon-white"></i>
			</button>
		</div>
	</form>
	<!-- END FORGOT PASSWORD FORM -->
	<!-- BEGIN REGISTRATION FORM -->
	<form class="register-form" method="post" id="register">
		<h3>Sign Up</h3>
		<p>
			 Enter your account details below:
		</p>
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Username</label>
			<div class="input-icon">
				<i class="fa fa-user"></i>
				<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Username" name="username" id="login_name"/>
			</div>
		</div>
		<div class="form-group">
			<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
			<label class="control-label visible-ie8 visible-ie9">Email</label>
			<div class="input-icon">
				<i class="fa fa-envelope"></i>
				<input class="form-control placeholder-no-fix" autocomplete="off" type="text" placeholder="Email" name="email" id="registeremail" onchange="isvalidemail(this.value);"/>				
			</div>
		</div>
			
		<div class="form-group">
			<label class="control-label visible-ie8 visible-ie9">Password</label>
			<div class="input-icon">
				<i class="fa fa-lock"></i>
				<input class="form-control placeholder-no-fix" type="password" autocomplete="off" id="register_password" placeholder="Password" name="password"/>
			</div>
		</div>
		<div class="form-group">
<!-- 			<label> -->
<!-- 			<input type="checkbox" name="tnc"/> I agree to the -->
<!-- 			<a href="#"> -->
<!-- 				 Terms of Service -->
<!-- 			</a> -->
<!-- 			 and -->
<!-- 			<a href="#"> -->
<!-- 				 Privacy Policy -->
<!-- 			</a> -->
<!-- 			</label> -->
			<div id="register_tnc_error">
			</div>
		</div>
		<div class="form-actions">
			<button id="register-back-btn" type="button" class="btn">
			<i class="m-icon-swapleft"></i> Back </button>
			<button type="button" id="register_user_btn" class="btn blue pull-right">
			Sign Up <i class="m-icon-swapright m-icon-white"></i>
			</button>
		</div>
	</form>
	<!-- END REGISTRATION FORM -->
</div>
<!-- END CONTAINER -->

<jsp:include page="bootstrapheader/footer.jsp"></jsp:include>
<jsp:include page="bootstrapheader/javascript.jsp"></jsp:include>
<script>
$(document).ready(function() {    
   App.init(); // initlayout and core plugins
   Login.init();
   var site_url = $('#site_url').html();  
   $('#login_menu').addClass('active');   
   $("#loginuser").click(function(){
	   console.log($('.login-form').validate().form());
	   if ($('.login-form').validate().form()) {
	   		doLogin();
	   }
	   return false;
   });
   $("#forgot_btn").click(function(){
	   if ($('.forget-form').validate().form()) {
	   		forgotPassword();
	   }
	   return false;
   }); 
   $('#register_user_btn').click(function(){
	   if ($('.register-form').validate().form()) {
		   registerUser();
	   }
	   return false;
   });
});
function isvalidemail(val){
	var data = '{"email":"'+val+'"}';
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/users/isuniqueemail",
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data : data,
		success : function(response, textStatus, jqXHR) {
			if(response.status==false){
				toastr.error("Email already used. Change email.!");
				return false;
			}else{
				return true;
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {

		}
    });
}
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>