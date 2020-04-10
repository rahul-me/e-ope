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
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a
								href="${pageContext.request.contextPath}/rest/micro/list">
									Home </a> <i class="fa fa-angle-right"></i></li>							
							<li>Energy Source List</li>
							<li class="pull-right">
								<li class="btn-group">
									<jsp:include page="../components/back_btn.jsp"></jsp:include>
								</li>
							</li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box blue customPanel">
							<div class="portlet-title customPanel-title">
								<div class="caption font-sm">Energy Source List</div>
								<div class="tools"></div>
							</div>
							<div class="portlet-body">
								<div class="row">
									<div class="col-md-3">
										<jsp:include page="../components/select_microgrid_id_list.jsp"></jsp:include>
									</div>
									<div class="col-md-3">
										<input type="text" id="port_cfg" class="form-control" placeholder="Port Cfg">
									</div>
									<div class="col-md-3">
										<div class="input-group date date-picker" data-date-format="yyyy-mm-dd">
											<input type="text" class="form-control" id="event_date">
											
											<span class="input-group-btn">
												<button class="btn default" type="button"><i class="fa fa-calendar"></i></button>
											</span>
										</div>											
									</div>
									<div class="col-md-3">
										<button type="button" id="filter" class="btn btn-primary">Search</button>
									</div>
								</div>
								<div style="height:10px;clear:both;"></div>								
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box blue customPanel">
							<div class="portlet-title customPanel-title">
								<div class="caption font-sm">Grid Data</div>
								<div class="tools"></div>
							</div>
							<div class="portlet-body">
								<div class="row" id="grid_data_checkboxes">														
								</div>
								<div class="row">
									<div class="col-md-12">
										<div id="gridDataChart" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
									</div>									
								</div>
								<div style="height:10px;clear:both;"></div>								
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box blue customPanel">
							<div class="portlet-title customPanel-title">
								<div class="caption font-sm">Inverter Data</div>
								<div class="tools"></div>
							</div>
							<div class="portlet-body">
								<div class="row">
								</div>
								<div class="row">
									<div id="inverterDataChart" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
								</div>
								<div style="height:10px;clear:both;"></div>								
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box blue customPanel">
							<div class="portlet-title customPanel-title">
								<div class="caption font-sm">Renewable Data</div>
								<div class="tools"></div>
							</div>
							<div class="portlet-body">
								<div class="row">
								</div>
								<div class="row">
									<div id="renewableDataChart" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
								</div>
								<div style="height:10px;clear:both;"></div>								
							</div>
						</div>
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box blue customPanel">
							<div class="portlet-title customPanel-title">
								<div class="caption font-sm">Solar Data</div>
								<div class="tools"></div>
							</div>
							<div class="portlet-body">
								<div class="row">
								</div>
								<div class="row">
									<div id="solarDataChart" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
								</div>
								<div style="height:10px;clear:both;"></div>								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- END CONTAINER -->
	<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>

	<script>
	
		var grid_data = [];
		var inverter_data = [];
		var solar_data = [];
		var renewable_data = [];
	
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			Index.init();
			ComponentsPickers.init();
			getMicrogridList();

			$("#dashBoard").click(function() {
				var microgrid_id = $.cookie("microgrid_id");
				window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"+ microgrid_id;
			});
			
		});
		function addZero(i) {
		    if (i < 10) {
		        i = "0" + i;
		    }
		    return i;
		}
		$("#filter").click(function(){
			getChartsIntoUseAndFillChartConfiguration();
		});
		
		function getChartsIntoUseAndFillChartConfiguration() {
			var event_date = $("#event_date").val();
			var port_cfg = $("#port_cfg").val();
			var microgrid_list = $("#microgrid_list").val();
			url = "${pageContext.request.contextPath}/rest/analysis/getenergysourcelist?port_cfg="+port_cfg+"&event_date="+event_date+"&microgrid_list="+microgrid_list;
			 $.get(url,function(data, status){
		    	data = data.data;
		    	console.log(data);
		    	grid_data = data.filter(function(e) {if(e.port_cfg == "grid"){return true}});
		    	inverter_data = data.filter(function(e) {if(e.port_cfg == "inverter"){return true}});
		    	renewable_data = data.filter(function(e) {if(e.port_cfg == "renewable"){return true}});
		    	solar_data = data.filter(function(e) {if(e.port_cfg == "solar"){return true}});
		    	fillCheckboxes(grid_data, 'grid');
		    	setChart('grid');
		    	
		    	
		    	console.log(grid_data)
		    	console.log(inverter_data)
		    	console.log(renewable_data)
		    	console.log(solar_data)
		    });
		/*$('#example').dataTable({
		        "serverSide": false,
		        "paging":   true,
		        "searching": false,
		        "bInfo" : false,
		        "bDestroy": true,
				"ajax" : "${pageContext.request.contextPath}/rest/analysis/getenergysourcelist?port_cfg="+port_cfg+"&event_date="+event_date+"&microgrid_list="+microgrid_list,
				"columns" : [
					{
						"data" : "port_cfg"
					},
					{
						"data":null,
						"render" : function(data,type,row){
							var event_time = new Date(row.event_time);
							var data = event_time.getFullYear()+" - "+addZero(event_time.getMonth()+1)+" - "+addZero(event_time.getDate())+" "+addZero(event_time.getHours())+":"+addZero(event_time.getMinutes())+":"+addZero(event_time.getSeconds());								
							return data;
						},
					},
					{
						"data" : "state"
					}
				]

			});	*/
		}
		
		
		function fillCheckboxes(){
			var dataArray = arguments[0];
			if(dataArray.length > 0){
				var json_string = dataArray[0].json_string;
				var checkbox_data = [];
				JSON.parse(json_string, (key, value) => {
					if(!isNaN(Number(value))){
						checkbox_data.push(key);
					}
				});
				var idName = '#'+arguments[1].trim()+'_data_checkboxes';
				var identifier = arguments[1].trim();
				$(idName).html('');
				checkbox_data.forEach(function(value, index){
					$(idName).append('<div class="col-md-2"><div class="checkbox"><label><input type="checkbox" class="'+identifier+'_checkbox_class" onClick="updateChart(this)" name="active" id="'+value+'">'+value+'</label></div></div>');
				});
				
			}
			
		}
		
		function updateChart(){
			var input_element = arguments[0];
			
			console.log(input_element);
			console.log(input_element.getAttribute("class"));
			var checked_elements = $('.'+input_element.getAttribute("class")+':checkbox:checked');
			
		}
		
		
		function setChart(){
			var options = {
					chart: {
						type: 'spline',
				        backgroundColor:'#FFFFFF'
					},
					title: {
				         text: arguments[0]+' data',
				         style: {
				             fontFamily: 'arial',
				             color : 'black',
				             fontWeight: 'bold',
				             fontSize: '15px',
				         }				         
				     },
				     credits: {
				         enabled: false
				     },
				     exporting: { enabled: false },
				     xAxis: {    	 
				    	 type:'datetime'				    	  			      				     					     	
				     },
				     tooltip: {
				    	  formatter: function() {    		 
				             return  '<b>' + this.series.name +'</b><br/>' +
				                 Highcharts.dateFormat('%Y-%b-%e %H:%M',this.x)+' <b>'+ this.y+'</b> kWh';
				         } 
				     },
				     series: []
			};
			$('#'+arguments[0].trim()+'DataChart').highcharts(options);
			
		}
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>