<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<style>
 .select2-display-none {
     z-index: 10050;
}
</style>

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
						<h3 class="page-title">User</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="index.html">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a href="#"> User </a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-user"></i>User
						</div>
						<div class="tools">
							<a href="" class="collapse"> </a> <a href="#portlet-config"
								data-toggle="modal" class="config"> </a> <a href=""
								class="reload"> </a> <a href="" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<div class="btn-group">
								<button id="addNewUser" class="btn green">
									Add New <i class="fa fa-plus"></i>
								</button>
								
							</div>
							<div class="btn-group pull-right">
								<button class="btn dropdown-toggle" data-toggle="dropdown">
									Tools <i class="fa fa-angle-down"></i>
								</button>
								<ul class="dropdown-menu pull-right">
									<li><a href="#" onclick="openPrintWin();"> Print </a></li>
									<li><a href="#" onclick="generatePDF();"> Save as PDF </a></li>
									<li><a href="#" onclick="generateExcel();"> Export to Excel </a></li>
								</ul>
							</div>
						</div>
						
						<table id="example"
							class="display table table-striped table-bordered table-hover"
							cellspacing="0" width="100%">
							<thead>
								<tr>
									<th>User Role</th>
									<th>Name</th>
									<th>Email</th>
									<th>User Name</th>
									<th>Status</th>
									<th>Action</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
	<!-- END CONTAINER -->
	
<!-- 	add user modal -->
	<div id="responsive" class="modal fade" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-body">
					<form class="form-horizontal" id="addUser">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">User</h4>
						</div>
						<div style="height:15px;clear:both;"></div>
						<input type="hidden" id="id" name="id">
						<div class="form-group">						
					        <label for="inputPassword" class="control-label col-xs-3">Role <label style="color:red;">*</label></label>
					        <div class="col-xs-9">
					            <jsp:include page="../components/select_user_roll.jsp"></jsp:include>
					        </div>
					    </div>
					    <div class="form-group" id="userList" style="display:none;">
					        <label for="inputPassword" class="control-label col-xs-3">User <label style="color:red;">*</label></label>
					        <div class="col-xs-9">
					            <jsp:include page="../components/select_user_customer_admin.jsp"></jsp:include>
					        </div>
					    </div>
					    <div class="form-group">
					        <label for="inputEmail" class="control-label col-xs-3">Email <label style="color:red;">*</label></label>
					        <div class="col-xs-9">
					            <input type="email" class="form-control" name="email" id="email" placeholder="Email">
					            <label id="validemail" style="display:none;"></label>
					        </div>
					    </div>
						<div class="form-group sep-access">
							<label for="sep_change" class="control-label col-xs-3">Access
							</label>							
							<div class="col-xs-9">
								<select class="form-control" name="accessibility_list" id="accessibility_list" multiple="multiple">
									<option value="sep">sep</option>
									<option value="sepOnly">seponly</option>
									<option value="analysisAccess">Analysis</option>
									<option value="analysisOnlyAccess">Analysis Only</option>									
								</select>
							</div>
						</div>						
						<div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn default">Close</button>
							<button type="submit" id="saveUser" class="btn green">Save changes</button>
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>

	<!-- end user modal -->
	
	<!-- Assign @Microgrid controller -->
	<div id="microgridControllerSelection" class="modal fade" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-body">
					<form class="form-horizontal" id="addUser">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">Assign Micro Grid Controller</h4>
						</div>
						<div style="height:15px;clear:both;"></div>
						<input type="hidden" id="operatorId" name="id">
						<div class="form-group">
							<div class="col-xs-5">
					            <select multiple id="controllerListLeft" class="form-control" name="userRollList"></select>
					        </div>
					        <div class="col-xs-2">
					            <div class="btn-group btn-group-lg">
					            	<button type="button" class="btn-sm fa fa-arrow-right btn default" id="btnToRight"></button>
  									<button type="button" class="btn-sm fa fa-arrow-left btn default" id="btnToLeft"></button>  									
								</div>
					        </div>
					        <div class="col-xs-5">
					            <select multiple id="controllerListRight" class="form-control" name="userRollList"></select>
					        </div>							
					    </div>
					    <div class="form-group" id="userList" style="display:none;">
					        <label for="inputPassword" class="control-label col-xs-3">User <label style="color:red;">*</label></label>
					        <div class="col-xs-9">
					            
					        </div>
					    </div>
					    <!-- <div class="form-group">
					        <label for="inputEmail" class="control-label col-xs-3">Email <label style="color:red;">*</label></label>
					        <div class="col-xs-9">
					            <input type="email" class="form-control" name="email" id="email" placeholder="Email">
					            <label id="validemail" style="display:none;"></label>
					        </div>
					    </div> -->
					    <div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn default" id="">Close</button>
							<button type="button" id="assignMicrogridController" class="btn green">Save changes</button>
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>
	<!-- Assign @Microgrid controller ends -->
	
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
	
	
	<!-- END JAVASCRIPTS -->
	<script>
		$(document).ready(function() {
			getRollSelect();
			getCustomerAdmin();
			setTable();
			var leftControllers = new Array();
			var rightControllers = new Array();
			
			var username = $.cookie("username");
			var token = $.cookie("token");			
			if(username && token){
				var roleName = $.cookie("roleName");
				if(roleName=="customer-admin"){
					checkSEPAccessAdministratorAuthority();
				}else if(roleName=="operator"){
					
				}
			}
			
		});
		
		$('#responsive').on('hidden.bs.modal', function() {	
			$('.select2-drop').css("display","none");
		});
		
		$("#userRollList").change(function(){
			var val = $(this).val();
			if(val==3){
				$("#userList").show();
			}else{
				$("#userList").hide();
			}
		});
		
		$("#addNewUser").click(function(){
			$('#addUser')[0].reset();
			$("#id").val("");
			$("#responsive").modal("show");
			$("#userList").hide();
			$('#accessibility_list').select2();
		});
		
		function setTable(){
			var role = $.cookie('roleName');
			console.log(role);
			$('#example').dataTable({
		        "serverSide": true,
		        "bDestroy": true,
				"ajax" : "${pageContext.request.contextPath}/rest/users/list",
				"columns" : [
{
	"data" : "userRole.role"
},
						{
							"data" : "fullname"
						},
						{
							"data" : "email"
						},
						{
							"data" : "userName"
						},
						{
							"data" : null,
							"render" : function(data, type,row) {
								var data = "";
								if (row.active == true) {
									data = '<input type="checkbox" id="status_'+row.id+'" onchange="updateStatus('+row.id+',this.id);" checked=true class="make-switch test" name="my-checkbox">';
								} else if (row.active == false) {
									data = '<input type="checkbox" id="status_'+row.id+'" onchange="updateStatus('+row.id+',this.id);" class="make-switch test" name="my-checkbox">';
								}
								$("#status_"+row.id).bootstrapToggle('destroy')
								$("#status_"+row.id).bootstrapToggle({
									"on" : "Active",
									"off" : "De-Active",
									"size":"mini",
									"onstyle":"success",
									"offstyle":"danger"
								});
								return data;
							},
						},{
							"data":null,
							"render" : function(data,type,row){
								//var data = "<button type='button' onclick='editUser("+row.id+");' class='btn btn-primary btn-xs'><i class='fa fa-edit'></i></button>"+
								 var data = "&nbsp;<button type='button' onclick='deleteUser("+row.id+");' class='btn btn-danger btn-xs'><i class='fa fa-trash-o'></i></button>";
								 if(role != 'super-admin'){
									 data = data + "&nbsp;<button type='button' onclick='assignMicrogrid("+row.id+");' title='Assign Microgrid' class='btn btn-primary btn-xs'><i class='fa fa-link'></i></button>" ;
								 } if(role == 'super-admin'){
									 data += "&nbsp;<button type='button' onclick='uploadCertificate("+row.id+");' title='Upload Certificate' class='btn btn-primary btn-xs'><i class='fa fa-file'></i></button>";
								 }
								 
								return data;
							},
						}],
						tableTools: {
				            "aButtons": [
				                "copy",
				                "csv",
				                "xls",
				                {
				                    "sExtends": "pdf",
				                    "sPdfOrientation": "landscape",
				                    "sPdfMessage": "Your custom message would go here."
				                },
				                "print"
				            ]
				        },
						
					"fnDrawCallback": function( oSettings ) {
						$(".test").bootstrapToggle('destroy')
						$(".test").bootstrapToggle({
							"on" : "Active",
							"off" : "De-Active",
							"size":"mini",
							"onstyle":"success",
							"offstyle":"danger"
						});
					}
			});	
		}
		
		
		$('#addUser').find("#email").blur(function(){
			var data = '{"email":"'+$(this).val()+'"}';
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/users/isuniqueemail",
				type : "POST",
				contentType : "application/json",
				dataType : "json",
				data : data,
				success : function(response, textStatus, jqXHR) {
					if(response.status==false){
						var roleName = $.cookie("roleName");
						if(roleName=="customer-admin"){
							
						}else if(roleName=="super-admin"){
							$("#validemail").html("Email already used. Change email");
							$("#validemail").show();
							$("#email").val("");
							$("#validemail").fadeOut(3000);
						}
					}else{
						$("#validemail").hide();
					}
				},
				// callback handler that will be called on error
				error : function(jqXHR, textStatus, errorThrown) {

				}
		    });
		});
		
		$("#addUser").validate({
			rules: {
				email: "required",
				userRollList: "required",
				email: {
					required: true,
					email : true
				},
				userRollList: {
					required: true,
				}
			},
			messages: {
				email: "Please enter your valid email address",
				userRollList: "Please select user role",
			}
		});
		
		$("#saveUser").click(function(){
			console.log("valid = "+$("#addUser").valid());
			if($("#addUser").valid()){
				var data = '';
				//var fullName = $("#fullName").val();
				var email = $("#email").val();
				//var userName = $("#userName").val();
				var roleId = $("#userRollList").val();
				var userRoleName = $("#userRollList option:selected").text();
				var parentId = $("#customer_user_list").val();
				var url = "";
				
				var sep_access = false;
				var sepOnly = false;
				var analysisAccess = false;
				var analysisOnlyAccess = false;
				var vals = $('#accessibility_list').val();				
				if(vals != null){
					if(vals.indexOf('sep') >= 0){
						sep_access = true;
					}
					if(vals.indexOf('sepOnly') >= 0){
						sepOnly = true;
					}
					if(vals.indexOf('analysisAccess') >= 0){
						analysisAccess = true;
					}
					if(vals.indexOf('analysisOnlyAccess') >= 0){
						analysisOnlyAccess = true;
					}
					if(analysisAccess && analysisOnlyAccess){
						toastr.error('Can not assign both Analysis and Analysis Only Access');
						return false;
					}
					if(sepOnly && analysisOnlyAccess){
						toastr.error('Can not assign both Sep Only and Analysis Only Access');
						return false;
					}
					if(sepOnly && analysisAccess){
						toastr.error('Can not assign both Sep Only access with Analysis access');
						return false;
					}
					if(sep_access && analysisOnlyAccess){
						toastr.error('Can not assign both Sep Only access with Sep access');
						return false;
					}
				}
				
				/* var classValue = $('.sep-access').attr('class');
				if(classValue.indexOf('hideMenu') == -1){
					
				} */
				
				if(userRoleName=='operator'){// Changed value from 5 to 2 as operator role id is 2.
					if($("#id").val()!=""){
						data = '{"id":"'+$("#id").val()+'","email":"'+email+'","active":'+true+',"roleId":"'+roleId+'","parentId":"'+parentId+'","sepAccess":'+sep_access+',"sepOnly":'+sepOnly+',"analysisAccess":'+analysisAccess+',"analysisOnlyAccess":'+analysisOnlyAccess+'}';
					}else{
						data = '{"email":"'+email+'","active":'+true+',"roleId":"'+roleId+'","parentId":"'+parentId+'","sepAccess":'+sep_access+',"sepOnly":'+sepOnly+',"analysisAccess":'+analysisAccess+',"analysisOnlyAccess":'+analysisOnlyAccess+'}';	
					}
					url = "${pageContext.request.contextPath}/rest/users/saveoperator";
				}else{
					if($("#id").val()!=""){
						data = '{"id":"'+$("#id").val()+'","email":"'+email+'","userRollType":{"id":"'+roleId+'"},"sepAccess":'+sep_access+',"sepOnly":'+sepOnly+',"analysisAccess":'+analysisAccess+',"analysisOnlyAccess":'+analysisOnlyAccess+'}';	
					}else{
						data = '{"email":"'+email+'","userRollType":{"id":"'+roleId+'"},"sepAccess":'+sep_access+',"sepOnly":'+sepOnly+',"analysisAccess":'+analysisAccess+',"analysisOnlyAccess":'+analysisOnlyAccess+'}';
					}
					url = "${pageContext.request.contextPath}/rest/users/save";
					console.log(data);
				}
				
				$.ajax({
					url : url,
					type : "POST",
					contentType : "application/json",
					dataType : "json",
					data : data,
					success : function(response, textStatus, jqXHR) {
						if(response.status==false){
							toastr.error(response.message);
						}else{							
							$('#example').dataTable().fnDestroy();
							toastr.success("User save.!");
							setTable();
						}
						$("#responsive").modal("hide");
						$('#addUser')[0].reset();
						
					},
					// callback handler that will be called on error
					error : function(jqXHR, textStatus, errorThrown) {
	
					}
			   });
			   return false;
			}else{
				return false;
			}	
				
		});
		
		 function assignMicrogrid(id){
			$.ajax({
				url : '${pageContext.request.contextPath}/rest/micro/find/operator/'+id,
				type: 'GET',
				contentType: 'application/json',
				dataType: 'json',
				success: function(response, textStatus, jqXHR) {
					if(response.data.length == 0) {
						toastr.success("There is no Micro Grid Controller to assign.");
					} else {
						fillLeftToRightSelectBox(response);
						showMicrogridCntrollerSelection();
						$("#operatorId").val(id);
					}
				}
			});
			
		} 
		
		 function fillLeftToRightSelectBox(response) {
			var microGrids = new Array();
			for(var i = 0 ; i< response.data.length ; i++) {
				microGrids.push(response.data[i]);
			}
			showInitialAssignment(response, microGrids);
		 } 
		
		 function showInitialAssignment(response, microGrids) {
			$("#controllerListLeft").html("");
			$("#controllerListRight").html("");
			leftControllers = new Array();
			rightControllers = new Array();
			for(var i = 0 ; i< microGrids.length ; i++) {
				var r = 0;
				for(var j = 0; j < response.assigned.length; j++) {
					if(response.assigned[j] == microGrids[i].id) {
						r = 1;
					} 
				}
				if(r == 0) {
					$("#controllerListLeft").append('<option value='+microGrids[i].id+'>'+microGrids[i].microgrid_id+'-'+microGrids[i].microgrid_name+'</option>');
					leftControllers.push(microGrids[i]);
				} else {
					$("#controllerListRight").append('<option value='+microGrids[i].id+'>'+microGrids[i].microgrid_id+'-'+microGrids[i].microgrid_name+'</option>');
					rightControllers.push(microGrids[i]);
				}
			}			
		 } 
				
		 function showMicrogridCntrollerSelection() {
			$("#microgridControllerSelection").modal("show");
		}
		
		$("#btnToRight").on("click", function() {
			if($("#controllerListLeft").val() != null) {
				performRight($("#controllerListLeft").val());
			} else {
				toastr.info('Select microgrid from the list');
			}						
		});
		
		$("#btnToLeft").on("click", function() {
			if($("#controllerListRight").val() != null) {
				performLeft($("#controllerListRight").val());
			} else {
				toastr.info('Select microgrid from the list');
			}
			
		});
		
		function performRight(ids) {
			console.log('left: '+leftControllers);
			for(var i =0 ; +i< leftControllers.length ; i++) {
				for(var j=0 ; j< ids.length; j++ ) {
					if(leftControllers[i].id == ids[j]) {
						rightControllers.push(leftControllers[i]);
						leftControllers.splice(i,1);
					}
				}				
			}
			fillRightList();
			fillLeftList();
		}
		
		function performLeft(ids) {
			console.log('left: '+rightControllers);
			for(var i =0 ; i< rightControllers.length ; i++) {
				for(var j=0 ; j< ids.length; j++ ) {
					if(rightControllers[i].id == ids[j]) {
						leftControllers.push(rightControllers[i]);
						rightControllers.splice(i,1);
					}
				}				
			}
			fillLeftList();
			fillRightList();
		}
		
		function fillLeftList() {
			$("#controllerListLeft").html("");
			for(var i=0 ; i< leftControllers.length ; i++) {
				$("#controllerListLeft").append('<option value='+leftControllers[i].id+'>'+leftControllers[i].microgrid_id+'-'+leftControllers[i].microgrid_name+'</option>');
			}
		}
		
		function fillRightList() {
			$("#controllerListRight").html("");
			for(var i=0 ; i< rightControllers.length ; i++) {
				$("#controllerListRight").append('<option value='+rightControllers[i].id+'>'+rightControllers[i].microgrid_id+'-'+rightControllers[i].microgrid_name+'</option>');
			}
		}
		
		 $("#assignMicrogridController").on("click", function() {
			var microgrids = new Array();
			$("#controllerListRight option").each(function () {
				microgrids.push($(this).val());
			});
							
				var ids= '';
				if(microgrids.length > 0) {
					for(var i = 0 ; i< microgrids.length; i++) {
						if(i == (microgrids.length-1)) {
							ids += microgrids[i];
						} else {
							ids += microgrids[i]+',';
						}						
					}
				}
											
				var obj = new Object();
				obj.operatorId = $("#operatorId").val();
				obj.microIds = ids;
				var str = JSON.stringify(obj);
				
				$.ajax({
					url : "${pageContext.request.contextPath}/rest/users/operatormicro",
					type : "POST",
					contentType : "application/json",
					dataType : "json",
					data: str,
					success : function(response, textStatus, jqXHR) {
						if(response.status == 'success') {
							toastr.success('Micro Grid Controller/Controllers assigned to this operator');
						}
					}
				});						
		}); 
		
		function assignMicro(data) {
			
		} 
		
		function editUser(id){			
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/users/edit/"+id,
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response, textStatus, jqXHR) {
					if(response.data){
						$("#id").val(response.data['id']);
						//$("#fullName").val(response.data['fullname']);
						$("#email").val(response.data['email']);				
						$("#sepAccessCheck").prop('checked',response.data['sepAccess']);						
						//$("#userName").val(response.data['userName']);
						console.log(response.data['userRollType']);
						if(response.data['userRollType']){
							$("#userRollList option[value='"+response.data['userRollType']['id']+"'").prop('selected', true); 
						}
						$("#responsive").modal("show");
					}					
				},
				// callback handler that will be called on error
				error : function(jqXHR, textStatus, errorThrown) {

				}
		  });
		}
		
		function updateStatus(userId,id){
			var isChecked = $("#"+id).is(":checked");
			var data = '{"id":"'+userId+'","active":'+isChecked+'}';
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/users/updatestatus",
				type : "POST",
				contentType : "application/json",
				dataType : "json",
				data : data,
				success : function(response, textStatus, jqXHR) {
					$('#example').dataTable().fnDestroy();
					setTable();
				},
				// callback handler that will be called on error
				error : function(jqXHR, textStatus, errorThrown) {

				}
		  });
		}
		
		function deleteUser(id){
			if(confirm("Are you sure?")){
				$.ajax({
					url : "${pageContext.request.contextPath}/rest/users/delete/"+id,
					type : "POST",
					contentType : "application/json",
					dataType : "json",
					success : function(response, textStatus, jqXHR) {
						$('#example').dataTable().fnDestroy();
						setTable();
					},
					// callback handler that will be called on error
					error : function(jqXHR, textStatus, errorThrown) {

					}
			  });
			}
		}
		function generateExcel(){
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/users/getlist",
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response, textStatus, jqXHR) {
					JSONToCSVConvertor(response.data,"User",true);
				},
				// callback handler that will be called on error
				error : function(jqXHR, textStatus, errorThrown) {

				}
			});
		}
		
		function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
		    //If JSONData is not an object then JSON.parse will parse the JSON string in an Object
		    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
		    
		    var CSV = '';    
		    //Set Report title in first row or line
		    
		    CSV += ReportTitle + '\r\n\n';

		    //This condition will generate the Label/Header
		    if (ShowLabel) {
		        var row = "";
		        
		        //This loop will extract the label from 1st index of on array
		        for (var index in arrData[0]) {
		            
		            //Now convert each value to string and comma-seprated
		            row += index + '\t';
		        }

		        row = row.slice(0, -1);
		        
		        //append Label row with line break
		        CSV += row + '\r\n';
		    }
		    
		    //1st loop is to extract each row
		    for (var i = 0; i < arrData.length; i++) {
		        var row = "";
		        
		        //2nd loop will extract each column and convert it in string comma-seprated
		        for (var index in arrData[i]) {
		            row += '"' + arrData[i][index] + '"\t';
		        }

		        row.slice(0, row.length - 1);
		        
		        //add a line break after each row
		        CSV += row + '\r\n';
		    }

		    if (CSV == '') {        
		        alert("Invalid data");
		        return;
		    }   
		    
		    //Generate a file name
		    var fileName = "MyReport_";
		    //this will remove the blank-spaces from the title and replace it with an underscore
		    fileName += ReportTitle.replace(/ /g,"_");   
		    
		    //Initialize file format you want csv or xls
		    var uri = 'data:text/xls;charset=utf-8,' + escape(CSV);
		    
		    // Now the little tricky part.
		    // you can use either>> window.open(uri);
		    // but this will not work in some browsers
		    // or you will not get the correct file extension    
		    
		    //this trick will generate a temp <a /> tag
		    var link = document.createElement("a");    
		    link.href = uri;
		    
		    //set the visibility hidden so it will not effect on your web-layout
		    link.style = "visibility:hidden";
		    link.download = fileName + ".xls";
		    
		    //this part will append the anchor tag and remove it after automatic click
		    document.body.appendChild(link);
		    link.click();
		    document.body.removeChild(link);
		}
		function openPrintWin(){
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/users/getlist",
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response, textStatus, jqXHR) {
					 var myWindow=window.open('','_blank','');
					    myWindow.document.write($("#example").html());
					    myWindow.document.close();
						myWindow.focus();
						myWindow.print();
						myWindow.close();
				},
				// callback handler that will be called on error
				error : function(jqXHR, textStatus, errorThrown) {

				}
			});
		   
	    }
		function generatePDF(){
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/users/getlist",
				type : "GET",
				contentType : "application/json",
				dataType : "json",
				success : function(response, textStatus, jqXHR) {
					if(response.data){
						var data = [], fontSize = 12, height = 0, doc;
						doc = new jsPDF('p', 'pt', 'a4', true);
						doc.setFont("times", "normal");
						doc.setFontSize(fontSize);
						//doc.text(20, 20, "hi table");
						data = [];
						//console.log(response.data);
						for(var i=0;i<response.data.length;i++){
							data.push({
								"name" : response.data[i]['fullname'],
								"email" : response.data[i]['email'],
								"userName":response.data[i]['userName']
							});
						}
						
						height = doc.drawTable(data, {
							xstart : 10,
							ystart : 10,
							tablestart : 40,
							marginright :100,
							xOffset : 10,
							yOffset : 10
						});
						//doc.text(50, height + 20, 'hi world');
						doc.save("userinfo.pdf");
					}	
						
				},
				// callback handler that will be called on error
				error : function(jqXHR, textStatus, errorThrown) {

				}
			});
		}
		
		function checkSEPAccessAdministratorAuthority(){
			var object = new Object();
			object.token = $.cookie("token");
			var data = JSON.stringify(object);
			console.log(data);
			$.ajax({
				url:'${pageContext.request.contextPath}/rest/users/checkUserAdminPerForSEP',
				type:'POST',
				contentType: 'application/json',
				data: data,
				success: function(response){
					console.log(response);
					if(response.status == 'success'){
						if(response.access == false){
							$('.sep-access').addClass('hideMenu');
						}
					} else {
						$('.sep-access').addClass('hideMenu');
					}
				}
				
			});	
		}
		
		function uploadCertificate(id){
			window.location.href = '${pageContext.request.contextPath}/rest/sep/certificate/'+id;			
		}
		
		
	</script>
	<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   Index.init();

});


</script>
</body>
<!-- END BODY -->
</html>
