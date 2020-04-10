<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<body class="page-header-fixed">
	<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
	<div class="clearfix"></div>
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
						<h3 class="page-title">Microgrid Detail</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li class="btn-group"><jsp:include
									page="../components/back_btn.jsp"></jsp:include>
								<button class="btn btn-primary" onclick="editMicroGrid();">Edit</button>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/rest/home/currentstatus/${id}">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li>View</li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="row">
					  <div class="col-md-6" style="min-height: 450px;">
							<img
								src="/MicroGrid-OS/public/images/micro_controller/1/page2.jpg" id="microgrid_profile_img"
								style="width: 100%; height: 450px; border: 4px solid; border-color: white;">
							<div id="microgrid_details">	
								<h4>
									<b>Fire Station #11</b><br>47200 Lakeview Blwd, Fremont, CA
									94538
								</h4>
							</div>
						</div>
						
						<div class="col-md-3" >
							<div class="thumbnail" style="min-height: 450px;">
								<img src="/MicroGrid-OS/public/images/team.jpg" alt=""
									style="width: 100%; height: 200px;">
								<div class="caption" id="owner_details">
									<h4>
										Fire chief: Amlel Thurston<br>Tel:
									</h4>
									<p>
										City of Fremont:<br> Project Coordinator<br> Rachael
										DiFranco<br> Tel: +1 510-944-4541<br>
									</p>
									<p>
										Maintenance Department<br> Bill Shaffer<br> Tel: +1
										510-999-7531
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-3" >
							<div class="thumbnail" style="min-height: 450px;">
								<img src="/MicroGrid-OS/public/images/power.jpg" alt=""
									style="width: 100%; height: 200px;">
								<div class="caption">
									<h4>
										Utilty:<img src="/MicroGrid-OS/public/images/PGE_logo.jpg"
											alt="" style="width: 75%; height: 40px; float: right;">
									</h4>
									<div id="utility_data_details">
										<p style="padding-top: 20px;">
											Account #: 110-352-1460<br> Service #: 110-352-1358<br>
											Tariff Plan: E-19 TOU Service<br>
										</p>
										<p>
											Emergency Contact:<br> +1 800-743-5000
										</p>
									</div>
								</div>
							</div>
						</div>
					
					
				</div>
			</div>
			<!-- END CONTENT -->
		</div>
	</div>	
	<!-- END CONTAINER -->
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
	<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
	<jsp:include page="../components/micro_grid_edit_modal.jsp"></jsp:include>
	<script src="${pageContext.request.contextPath}/public/javascripts/valid_microgrid.js"></script>
	<script>
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			Index.init();
			Index.initCharts(); // init index page's custom scripts
			Index.initMiniCharts();
			Index.initDashboardDaterange();
			Tasks.initDashboardWidget();
			populateCountries("country", "state");
			getUtilityList();
			
			var options = {
				beforeSend : function() {
					$("#progressbox").show();
					// clear everything
					$("#progressbar").width('0%');
					$("#message").empty();
					$("#percent").html("0%");
				},
				uploadProgress : function(event, position,
						total, percentComplete) {
					$("#progressbar").width(
							percentComplete + '%');
					$("#percent").html(
							percentComplete + '%');

					// change message text to red after 50%
					if (percentComplete > 50) {
						$("#message")
								.html(
										"<font color='red'>File Upload is in progress</font>");
					}
				},
				success : function() {
					$("#progressbar").width('100%');
					$("#percent").html('100%');

				},
				complete : function(response) {
					$('#batteryfrm')[0].reset();
					$("#battery_modal").modal("hide");
					showBattery();
					return false;
				},
				error : function() {
					alert("error");
				}
			};
			$("#batteryfrm").ajaxForm(options);
			showData();
			
		});

		function showData() {
			//var microgrid_id = $.cookie("microgrid_id");
			var microgrid_id = getMicroGridIdFromUrl();
			//console.log("microgrid_id == "+microgrid_id);
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/micro/findbymicrogridid/"+ microgrid_id,
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response) {
					var data = response.data;
					if (data) {
						if (data.profile_img) {
							$("#microgrid_profile_img").prop("src","https://drive.google.com/uc?export=view&id="+data.profile_img);
						} else {
							$("#microgrid_profile_img").prop("src","${pageContext.request.contextPath}/public/images/noimage.png");
						}
						var microgrid_details = "<h4><b>"+data.microgrid_name+" # "+ data.microgrid_id + "</b>";
						microgrid_details += "<br>"+data.address_line_1+",";
						if(data.address_line_2!=""){
							microgrid_details += data.address_line_2+",";
						}
						
						microgrid_details += data.city + " , ";
						microgrid_details += data.state + " ,";
						microgrid_details += data.zip_code + "</h4>";
						$("#microgrid_details").html(microgrid_details);
						// set value for edit microgrid modal
						$("#id").val(response.data['id']);
						$("#microgrid_name").val(response.data['microgrid_name']);
						$("#microgrid_id").val(response.data['microgrid_id']);
						var username = $.cookie("username");
						var fullname = $.cookie("fullname");
						var name = username;
						if(fullname!="" && fullname!=undefined){
							name = fullname;
						}
						var owner = "<h4>Fire chief :"+ name + "</h4>";
						owner += "<p>City of "+ response.data['city']+ "<br>Project Coordinator:<br>"
								+ response.data['owner_manager_name']+ "<br>Tel : "
								+ response.data['owner_manager_contact']+ "</p>";
						owner += "<p>Maintenance Department<br>"+ response.data['maintenance_manager_name']	+ "<br>";
						owner += "Tel : "+ response.data['maintenance_manager_contact']+ "</p>";
						$("#owner_details").html(owner);
						if (response.data['pic_url']) {
							$("#edit_image").show();
							$("#view_pic_mg").prop("href","${pageContext.request.contextPath}"+ response.data['pic_url']);
						} else {
							$("#edit_image").hide();
						}
						if (response.data['profile_img']) {
							$("#edit_profile_image").show();
							$("#view_profile_pic_mg").prop("href","${pageContext.request.contextPath}"+ response.data['profile_img']);
						} else {
							$("#edit_profile_image").hide();
						}
						var time_zone = response.data['time_zone'];
						var time_zone_val = time_zone.split("##");
						$("#time_zone_list").val(time_zone_val[1]);
						$("#utilityList").val(response.data['utilityId']);
						if (response.data['active'] == true) {
							$("#is_active").prop("checked", true);
						} else {
							$("#is_active").prop("checked", false);
						}
						$("#owner_manager_name").val(response.data['owner_manager_name']);
						$("#owner_manager_contact").val(response.data['owner_manager_contact']);
						$("#maintenance_manager_name").val(response.data['maintenance_manager_name']);
						$("#maintenance_manager_contact").val(response.data['maintenance_manager_contact']);
						$("#textarea").val(response.data['about']);
						$("#address_line_1").val(response.data['address_line_1']);
						$("#address_line_2").val(response.data['address_line_2']);
						$("#city").val(response.data['city']);
						$("#country").val(response.data['country']);
						$("#country").change();
						$("#state").val(response.data['state']);
						$("#zip_code").val(response.data['zip_code']);
						$("#max_meter_value").val(response.data['max_meter_value']);
						// end
						getUtilityDetails(response.data['utilityId']);
					}
				},
				error : function(data) {

				}
			});
		}	
		function getUtilityDetails(id){			
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/utility/findById/"+ id,
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response) {
					var data = response.data;
					if (data) {						
						var data_val = '<p style="padding-top:20px;">Account # '+data.account_no+'<br>';
						data_val += "Service # "+data.service+"<br>";
						data_val += "Tariff Plan : "+data.tariff_plan+"</p>";
						data_val += "<p>Emergency Contact:"+data.emergency_contact+"</p>";						
						$("#utility_data_details").html(data_val);
					}
				},				
				error : function(data) {

				}
			});
		}
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>