
<link rel="stylesheet" href="../../public/css/bootstrap.min.css">
<link rel="stylesheet" href="../../public/css/style.css">
<link rel="stylesheet" href="../../public/css/font-awesome.css">
<script src="../../public/javascripts/jquery.min.js"></script>
<script src="../../public/javascripts/bootstrap.min.js"></script>
<script src="../../public/javascripts/cookie.js" type="text/javascript"></script>
<style>
.logged-user{
  display: inline-block;
  vertical-align: middle;
  text-align: left;
}
</style>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MicroGrid</title>
</head>
<body>
<div class="container-flud">
 <nav role="navigation" class="navbar navbar-default navbar-fixed-top">
      <div class="container-flud">
        
        <!-- Title -->
        <div class="navbar-header pull-left">
          <a href="/" class="navbar-brand" id="menu_toggle">MicroGrid OS</a>
        </div>
        
        <!-- 'Sticky' (non-collapsing) right-side menu item(s) -->
        <div class="navbar-header pull-right">
          <ul class="nav pull-left">
            <!-- This works well for static text, like a username -->
            <li class="navbar-text pull-left" id="user_name"></li>
            <!-- Add any additional bootstrap header items.  This is a drop-down from an icon -->
            <li class="dropdown pull-right">
              <a href="#" data-toggle="dropdown" style="color:#777; margin-top: 5px;" class="dropdown-toggle"><span class="glyphicon glyphicon-user"></span><b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="users/id" title="Profile"><i class="fa fa-user"></i> Profile</a>
                </li>
                <li>
                  <a href="#" title="Logout" id="logoutbtn"><i class="fa fa-power-off"></i>Logout</a>
                </li>
              </ul>
            </li>
          </ul>

          <!-- Required bootstrap placeholder for the collapsed menu -->
          <button type="button" data-toggle="collapse" data-target=".navbar-collapse" class="navbar-toggle"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
        </div>
        <!-- The Collapsing items            navbar-left or navbar-right -->
        <div class="collapse navbar-collapse navbar-left">
          <!--                      pull-right keeps the drop-down in line
          <ul class="nav navbar-nav pull-right">
            <li><a href="/news">News</a></li>
            <li><a href="/Shop">Shop</a></li>
          </ul>
           -->
        </div>

        <!-- Additional navbar items -->
        <div class="collapse navbar-collapse navbar-right">
          <!--                      pull-right keeps the drop-down in line
          <ul class="nav navbar-nav pull-right">
            <li><a href="/locator">Locator</a></li>
            <li><a href="/extras">Extras</a></li>
          </ul> -->
        </div>
      </div>
    </nav>
 </div>
<script type="text/javascript">

$("#menu_toggle").click(function(e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
});
$('.dropdown-toggle').dropdown();
$(document).on('click','#menu-content li',function(e) {
    $('.sub-menu.collapse').collapse('hide');
});

var role = $.cookie("role");
if ( role != null && role=="Admin"){
	$("#reg").show();
}else{
	$("#reg").hide();
}
var username = $.cookie("username");
var token = $.cookie("token");
if(username && token){
	$("#user_name").html(username);
}else{
	window.location.href = "/MicroGrid-OS";	
}


</script>
