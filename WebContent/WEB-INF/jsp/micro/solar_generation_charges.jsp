<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<body class="page-header-fixed">
	<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
	<div class="clearfix"></div>
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<jsp:include page="../bootstrapheader/leftmenu.jsp"></jsp:include>
		
		<!-- Modal Begin -->
		<div id="modal_update_charges" class="modal fade" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">Rate</h4>
						</div>
						<div style="height: 15px; clear: both;"></div>
						<input type="hidden" id="mgc_id" name="mgc_id">
						<input type="hidden" id="init_type" name="init_type">					
						<div class="form-group">
							<label class="col-lg-4 control-label">Rate</label>
							<div class="col-lg-8">
								<input type="text" class="form-control pull-left" id="solar_generaion_rate"
									title="Solar Generation Rate">
							</div>
						</div>
						<div class="form-group" id="current_month_force">
							<label class="col-lg-4 control-label">Current Month</label>
							<div class="col-lg-8">
								<input type="checkbox" class="form-control" id="to_current" title="Force Changes to current month">
							</div>
						</div>								
						<div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn default">Close</button>
							<button type="button" id="saveChangesBtn" class="btn green">Save changes</button>
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>
		<!-- Modal End -->
		
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
							<li>Solar Generation Charges</li>
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
								<div class="caption font-sm">Charges</div>
								<div class="tools"></div>
							</div>
							<div class="portlet-body">								
								<div style="height:10px;clear:both;"></div>
								<table id="example"
										class="display table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>Micro Grid Controller (ID : Name)</th>
												<th>Rate</th>
												<th>Edit</th>
											</tr>
										</thead>
									</table>
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
		jQuery(document).ready(function() {
			App.init(); // initlayout and core plugins
			Index.init();
			ComponentsPickers.init();
			//getMicrogridList();
			
			setTable();

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
		
		
		function setTable() {
			$("#example").dataTable({
				"columnDefs" : [ {
					"width" : "40%",
					"targets" : 0
				}, {
					"width" : "40%",
					"targets" : 1
				}, {
					"width" : "20%",
					"targets" : 2
				} ],
				"serverSide": false,
				"paging": true,
				"searching": true,
				"bInfo": false,
				"bDestroy": true,
				"ajax": "${pageContext.request.contextPath}/rest/micro/getmgclist",
				"columns": [
				            {
				            	"data": null,
				            	"render":function(data, type, row){
				            		return data.microgrid_id+" : "+data.microgrid_name;
				            	}
				            },
				            {
				            	"data":null,
								"render":function(data,type,row){
									if(row.solar_generation_charge == '-1'){
										return 'Not Initialized';
									} else {
										return row.solar_generation_charge.toFixed(3)+ " $";
									}
								}
				            },
				            {
				            	"data":null,
								"render":function(data,type,row){												
									return '<button type="button" class="btn btn-primary btn-xs" onclick="edit('+data.id+','+data.solar_generation_charge+')"><i class="glyphicon glyphicon-edit"></i></button>';
								}
				            }],
				
			});
		}
		
	function edit(){
		//console.log(arguments);
		$('#mgc_id').val(arguments[0]);
		var solar_gen_charge = arguments[1];
		if(eval(solar_gen_charge) == -1){
			$('#solar_generaion_rate').val('0.00 ');
			$('#init_type').val('non-initialized');
			$('#current_month_force').css('display','none');
		} else {
			$('#init_type').val('initialized');
			$('#solar_generaion_rate').val(solar_gen_charge);
			$('#current_month_force').css('display','block');
		}
		$('#to_current').prop('checked', false);
		$('#modal_update_charges').modal('show');
	}
	
	$('#saveChangesBtn').on('click', function(){
		
		
		if(!$.isNumeric($('#solar_generaion_rate').val())){
			//console.log('Not Numeric');
			toastr["warning"]("Enter valid decimal data");
			return ;
		}
		
		if(eval($('#solar_generaion_rate').val()) < 0){
			toastr["warning"]("You can not assign negative charge");
			return;
		}
		
		var mgc_id = $('#mgc_id').val();
		var init_type = $('#init_type').val();
		var rate = $('#solar_generaion_rate').val();
		var to_current = $('#to_current').is(':checked');
		
		
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/micro/saveSolarGenerationCharge?mgc_id="+mgc_id+"&init_type="+init_type+"&rate="+rate+"&to_current="+to_current,
			type : "get",			
			success : function(response) {
				$('#example').dataTable().fnDestroy();
				setTable();
				$('#modal_update_charges').modal('hide');					
			}
	    });
	});
	</script>
</body>
</html>