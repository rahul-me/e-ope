<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<!-- END HEAD -->
<!-- BEGIN BODY -->


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
						<h3 class="page-title">Utility Analysis</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a
								href="${pageContext.request.contextPath}/rest/micro/list">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> Utility Analysis</a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">Utility Analysis</div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="col-md-12">
								<div class="col-md-6">
									<div style="height:10;clear:both;"></div>
									<label>Customer Name</label>
									<select id="customer_id">
									</select>
								</div>
								<div class="col-md-6" style="padding-top: 10px;">
									<jsp:include page="../components/date_filter_search.jsp"></jsp:include>
								</div>
							</div>
							<div id="week_data" class="col-md-12 text-center"></div>
						</div>
						<div style="height: 10px; clear: both;"></div>
						<div id="foothill_college_analysis_id">
							<jsp:include page="foothill_college_chart.jsp"></jsp:include>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- END CONTENT -->

	<!-- END CONTAINER -->
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>

	<!-- END JAVASCRIPTS -->
	<script>
		jQuery(document).ready(function() {
			App.init();
			Index.init();
			loadCustomer();
		});
		$.urlParam = function(name){
		    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
		    if(results){
		    	return results[1] || 0;
		    }else{
		    	return 0;
		    }
		}
		function loadCustomer() {
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/utility/utility_import_customer_list",
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response, textStatus, jqXHR) {
					if (response.status == true) {
						if (response.data) {
							var data = response.data;
							var option = '<option value="">Select Customer</option>';
							var customer_id = $.urlParam('customer_id');
							var selected = "";
							for (var i = 0; i < data.length; i++) {
								selected = "";
								if(customer_id==data[i][0]){
									selected = "selected";
								}
								option += '<option value="'+data[i][0]+'"'+selected+'>'
										+ data[i][1] + '</option>';
							}
							$("#customer_id").html(option);
						} else {
							$("#customer_id").html("");
						}
					} else {
						$("#customer_id").html("");
					}
				},
				// callback handler that will be called on error
				error : function(jqXHR, textStatus, errorThrown) {

				}
			});
		}
		$("#customer_id").change(function(){
			var val = $(this).val();
			if(val){
				var url = window.location.href+"?customer_id="+val
				window.location.href = url;
			}
		})
	</script>
</body>
<!-- END BODY -->
</html>