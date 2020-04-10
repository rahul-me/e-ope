<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>

<!-- END HEAD -->
<!-- BEGIN BODY -->
<style>
.span{
color:black !important;
font-weight:600 !important;
}
</style>
<body class="page-header-fixed">
<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
<div class="clearfix">
</div>
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
					<h3 class="page-title" id="title">
					Microgrid Action 
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="${pageContext.request.contextPath}/rest/home/currentstatus/${id}">
								Home
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="${pageContext.request.contextPath}/rest/home/currentstatus/${id}">
								Micro Grid
							</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							Action
						</li>
						<li class="pull-right">>
							<li class="btn-group">
								<jsp:include page="../components/back_btn.jsp"></jsp:include>							
								<a href="${pageContext.request.contextPath}/rest/micro/command-history/${id}" style="color:white;" class="btn blue">
									Command History
								</a>										
							</li>
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<div class="clearfix">
			</div>
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<button class="btn btn-lg red command" style="width:100%" id="ilandingmode">Islanding</button>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<button class="btn btn-lg green command" style="width:100%" id="gridmode">Grid</button>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
						<button class="btn btn-lg btn-info command" style="width:100%">Battery</button>
					</div>
				<!--	<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12" style="display: none">
						<button class="btn btn-lg btn-default command" style="width:100%" id="testConnection">Test Connection</button>
					</div> -->
				</div>
				<div class="clearfix">
				</div>
				<div class="col-md-6 col-md-offset-3" style="padding-top:10px;">
				<div class="panel panel-default">
					  <div class="panel-heading">Current State OF Electricity</div>
					  <div class="panel-body" style="padding:0px;"> 
					<ul class="list-group" style="margin-bottom: 0px;">
					    <li class="list-group-item">
					    <span class=" pull-right label span" id="grid_status" style="font-size:14px !important;"></span>
					    Grid State
					  </li>
					    <li class="list-group-item">
					    <span class=" pull-right label span" id="grid_state" style="font-size:14px !important;"></span>
					    Grid Status
					  </li>
					    <li class="list-group-item">
					    <span class=" pull-right label span" id="solar_out_source" style="font-size:14px !important;"></span>
					    Solar Source Out
					  </li>
					    <li class="list-group-item">
					    <span class=" pull-right label span" id="solar_state" style="font-size:14px !important;"></span>
					    Solar State
					  </li>
					  <li class="list-group-item">
					    <span class=" pull-right label span" id="battery_in_source" style="font-size:14px !important;"></span>
					  		Battery source In
					  </li>
					  <li class="list-group-item">
					    <span class=" pull-right label span" id="battery_out_source" style="font-size:14px !important;"></span>
					    Battery Source Out
					  </li>
					  <li class="list-group-item">
					    <span class=" pull-right label span" id="battery_state" style="font-size:14px !important;"></span>
					    Battery State
					  </li>
					</ul>
					  </div>
					</div>
					
				</div>
			</div>
			
			
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<div id="testModal" class="modal fade" tabindex="-1"
		aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
				<h4 class="modal-title">Test Connection</h4>
			</div>
			<div class="modal-body">
				<textarea rows="10" cols="75" id="testMessage"></textarea>
				<!-- END FORM-->
			</div>
			<div class="modal-footer">
				<button type="button" class="btn default" data-dismiss="modal">Close</button>
				<button type="submit" id="btn_send" class="btn blue">Send</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- END CONTAINER -->
<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   Index.init();
   Index.initCharts(); // init index page's custom scripts
   Index.initMiniCharts();
   Index.initDashboardDaterange();
   Tasks.initDashboardWidget();
   showData();
   setInterval(function(){showData()}, 1000*30);
});
$("#testConnection").click(function(){
	$("#testModal").modal("show");
});
function showData(){
	var microgrid_id = $.cookie("microgrid_id");
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro/findbymicrogridid/"+microgrid_id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			if(response.data){
				if(response.status==true){
					$("#title").html(response.data.microgrid_name+"&nbsp;<button class='btn-sm btn btn-success'>on-line</button>");
				}else{
					$("#title").html(response.data.microgrid_name+"&nbsp;<button class='btn-sm btn btn-danger'>off-line</button>");
					$(".command").attr("disabled","disabled");
				}
			}
		},
		error:function(data){
			
		}
	});
	
	
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro_status/"+microgrid_id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			if(response.data){
				if(response.status==true){
					var data = response.data[0]
					$("#battery_in_source").html(data.battery_in_source);
					$("#battery_out_source").html(data.battery_out_source);
					$("#battery_state").html(data.battery_state);
					$("#grid_state").html(data.grid_state);
					$("#grid_status").html(data.grid_status);
					$("#solar_out_source").html(data.solar_out_source);
					$("#solar_state").html(data.solar_state);					
				}else{
					
				}
			}
		},
		error:function(data){
			
		}
	});
}
$("#btn_send").click(function(){
	var microgrid_id = $.cookie("microgrid_id");
	var message = $("#testMessage").val();
	
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro/testconnection?id="+microgrid_id+"&message="+message,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			if(response.status==true){
				$("#testModal").modal("hide");
				toastr.success("Connection test successfully");
			}
		},
		error:function(data){
			
		}
	});
});

$("#ilandingmode").click(function(){
	var microgrid_id = $.cookie("microgrid_id");
	var data =  {
		"microgrid_id" : microgrid_id,
		"mode": "Islanding"
	}
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/command/send",
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		data : data,
		success : function(response) {
			console.log(response)
		},
		error:function(data){
			
		}
	});
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>