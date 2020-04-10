function doLogin(){
	var newdata = {
		email  :$('#login_user').find("#email").val(),
		password : $('#login_user').find("#password").val()
	};
	var site_url = $('#site_url').html();
	var data = JSON.stringify(newdata);
	if (data != '') {
		$.ajax({
			url : site_url+"/rest/login/dologin",
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			data : data,
			success : function(data) {
			  if(data.status == true){
					$.cookie("username",data.username,{ path: '/'});
					$.cookie("token", data.token,{ path: '/'});
					$.cookie("user", data.user,{ path: '/'});
					$.cookie("roleName",data.roleName,{path: '/'});
					$.cookie("image",data.image,{path: '/'});
					$.cookie("logintoken",data.logintoken,{path: '/'});
					$.cookie("fullname",data.fullname,{path: '/'});
					$.cookie("userid", data.userid,{path:'/'});
					$.cookie("sepOnly", data.sepOnly,{path:'/'})
					if(data.sepOnly){
						window.location.href = site_url+"/rest/sep/home/index";
					} else {
						window.location.href = site_url+"/rest/micro/locationMap";
					}
					
			  }else{
				  toastr.error("Invalid email and password.!"); 
				  $('#login_user').find("#email").val("");
				  $('#login_user').find("#password").val("");
			  }
			}
		});
	}
}
function forgotPassword(){
	var email = $("#fEmail").val();	
	var site_url = $('#site_url').html();
	if(email!=""){
	   var data = '{"email":"'+email+'"}';
	   var url = site_url+"/rest/login/forgotpassword";
	   $.ajax({
			url : url,
			type : "POST",
			contentType : "application/json",
			dataType : "json",
			data : data,
			success : function(data) {
				if (data.status == true) {
					toastr.success("Check your email for new password.!");
					$("#back-btn").click();
				}else{
					toastr.error("Email is not valid.!");
				}
			}
		});
	}
}

function registerUser(){
		
	var newdata = {						
		email : $('#register').find("#registeremail").val(),
		userName : $('#register').find("#login_name").val(),
		password : $('#register').find("#register_password").val()			
	};
	var data = JSON.stringify(newdata);	
	var site_url = $('#site_url').html();
	$.ajax({
		url : site_url+"/rest/users/save",
		type : "POST",
		contentType : "application/json",
		dataType : "json",
		data : data,
		success : function(data) {
			if (data.status == true) {
				toastr.success("User detail save successfully.!");
				$("#register-back-btn").click();
			}else{				
				toastr.error(data.message);
			}
		}
	});
}
var Login = function () {

	var handleLogin = function() {
		$('.login-form').validate({
	            errorElement: 'span', //default input error message container
	            errorClass: 'help-block', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            rules: {
	                username: {
	                    required: true
	                },
	                password: {
	                    required: true
	                },
	                remember: {
	                    required: false
	                }
	            },

	            messages: {
	                username: {
	                    required: "Username is required."
	                },
	                password: {
	                    required: "Password is required."
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   
	                $('.alert-danger', $('.login-form')).show();
	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.form-group').addClass('has-error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.form-group').removeClass('has-error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	                form.submit();
	            }
	        });

	        $('.login-form input').keypress(function (e) {
	            if (e.which == 13) {
	                if ($('.login-form').validate().form()) {
	                	doLogin();
	                	return false;
	                }
	                return false;
	            }
	        });
	}

	var handleForgetPassword = function () {
		$('.forget-form').validate({
	            errorElement: 'span', //default input error message container
	            errorClass: 'help-block', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                email: {
	                    required: true,
	                    email: true
	                }
	            },

	            messages: {
	                email: {
	                    required: "Email is required."
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   

	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.form-group').addClass('has-error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.form-group').removeClass('has-error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                error.insertAfter(element.closest('.input-icon'));
	            },

	            submitHandler: function (form) {
	                form.submit();
	            }
	        });

	        $('.forget-form input').keypress(function (e) {
	            if (e.which == 13) {
	                if ($('.forget-form').validate().form()) {
	                	forgotPassword();
	                	return false;
	                }
	                return false;
	            }
	        });

	        jQuery('#forget-password').click(function () {
	            jQuery('.login-form').hide();
	            jQuery('.forget-form').show();
	        });

	        jQuery('#back-btn').click(function () {
	            jQuery('.login-form').show();
	            jQuery('.forget-form').hide();
	        });

	}

	var handleRegister = function () {

		function format(state) {
            if (!state.id) return state.text; // optgroup
            return "<img class='flag' src='assets/img/flags/" + state.id.toLowerCase() + ".png'/>&nbsp;&nbsp;" + state.text;
        }


		$("#select2_sample4").select2({
		  	placeholder: '<i class="fa fa-map-marker"></i>&nbsp;Select a Country',
            allowClear: true,
            formatResult: format,
            formatSelection: format,
            escapeMarkup: function (m) {
                return m;
            }
        });


			$('#select2_sample4').change(function () {
                $('.register-form').validate().element($(this)); //revalidate the chosen dropdown value and show error or success message for the input
            });



         $('.register-form').validate({
	            errorElement: 'span', //default input error message container
	            errorClass: 'help-block', // default input error message class
	            focusInvalid: false, // do not focus the last invalid input
	            ignore: "",
	            rules: {
	                
	                fullname: {
	                    required: true
	                },
	                email: {
	                    required: true,
	                    email: true
	                },
	                address: {
	                    required: true
	                },
	                city: {
	                    required: true
	                },
	                country: {
	                    required: true
	                },

	                username: {
	                    required: true
	                },
	                password: {
	                    required: true
	                },
	                rpassword: {
	                    equalTo: "#register_password"
	                },

	                tnc: {
	                    required: true
	                }
	            },

	            messages: { // custom messages for radio buttons and checkboxes
	                tnc: {
	                    required: "Please accept TNC first."
	                }
	            },

	            invalidHandler: function (event, validator) { //display error alert on form submit   

	            },

	            highlight: function (element) { // hightlight error inputs
	                $(element)
	                    .closest('.form-group').addClass('has-error'); // set error class to the control group
	            },

	            success: function (label) {
	                label.closest('.form-group').removeClass('has-error');
	                label.remove();
	            },

	            errorPlacement: function (error, element) {
	                if (element.attr("name") == "tnc") { // insert checkbox errors after the container                  
	                    error.insertAfter($('#register_tnc_error'));
	                } else if (element.closest('.input-icon').size() === 1) {
	                    error.insertAfter(element.closest('.input-icon'));
	                } else {
	                	error.insertAfter(element);
	                }
	            },

	            submitHandler: function (form) {
	                form.submit();
	            }
	        });

			$('.register-form input').keypress(function (e) {
	            if (e.which == 13) {
	                if ($('.register-form').validate().form()) {
	                	registerUser();
	                	return false;
	                }
	                return false;
	            }
	        });

	        jQuery('#register-btn').click(function () {
	            jQuery('.login-form').hide();
	            jQuery('.register-form').show();
	        });

	        jQuery('#register-back-btn').click(function () {
	            jQuery('.login-form').show();
	            jQuery('.register-form').hide();
	        });
	}
    
    return {
        //main function to initiate the module
        init: function () {
        	
            handleLogin();
            handleForgetPassword();
            handleRegister();        
	       
	       	$.backstretch([
		        "../../public/assets/img/Login-page.jpg",
		        "../../public/assets/img/back_ground.jpg"
		        ], {
		          fade: 1000,
		          duration: 8000
		    });
        }

    };

}();