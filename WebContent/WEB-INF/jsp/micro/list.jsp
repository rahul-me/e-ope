<link href="../../public/assets/css/pages/news.css" rel="stylesheet" type="text/css"/>

<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<!-- END HEAD -->
<!-- BEGIN BODY -->
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
					<h3 class="page-title">
					Micro Grid Controller
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li class="btn-group">
							<jsp:include page="../components/back_btn.jsp"></jsp:include>							
							<button type="button" class="btn blue dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="1000" data-close-others="true">
							<span>
								Actions
							</span>
							<i class="fa fa-angle-down"></i>
							</button>
							<ul class="dropdown-menu pull-right" role="menu">
								<li>
									<a href="#" id="add_new_controller">
										Add New Controller
									</a>
								</li>
								<li>
									<a href="#" id="exportMicro">
										Export Details
									</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/rest/micro/locationMap.html">
										Go to Map
									</a>
								</li>
							</ul>
						</li>
						<li>
							<i class="fa fa-home"></i>
							<a href="${pageContext.request.contextPath}/rest/micro/locationMap.html">
								Home
							</a>							
						</li>												
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE HEADER-->			
			<!-- Block for filters -->
			<div class="row" id="searchbybox">
					<div class="col-md-12">
						<div class="portlet box blue customPanel">
							<div class="portlet-title customPanel-title">
								<div class="caption font-sm">Search By</div>
								<div class="tools"></div>
							</div>
							<div class="portlet-body">
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label col-md-4" title="Select User">User:</label>
											<div class="col-md-8">
												<select name="userNameList" id="userIdList"
													class="form-control" title="Select User">
													<option value="0"></option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label col-md-4" title="Select User">City:</label>
											<div class="col-md-8">
												<select name="cityNameList" id="cityIdList"
													class="form-control" title="Select User">
													<option value="0"></option>
												</select>
											</div>
										</div>
									</div>									
									<div class="col-md-2">
										<input type="text" name="microName" id="microId" class="form-control" placeholder="Enter Name"/>
									</div>									
									<div class="col-md-2">
										<button type="button" id="btnfilter" class="btn btn-primary" title="Fiter your micro controllers">Search</button>
									</div>
								</div>
								<div style="height:10px;clear:both;"></div>								
							</div>
						</div>
					</div>
				</div>
			<!-- End of filter block -->	
				<div class="row">								
					<div class="col-md-12" >
						<div style="text-align: center;font-weight: bold;" id="resultmsg"></div>
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<div class="row mix-grid" id="MicorGirdList"></div>
					</div>
					<!-- END FILTER -->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<div class="clearfix">
			</div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<script type="text/javascript" src="//maps.googleapis.com/maps/api/js?key=AIzaSyAn7bnyIGQZso-Mmkvxf-dJtrcWgSdo0wU"></script>
<jsp:include page="../components/micro_grid_form_modal.jsp"></jsp:include>
<script>
var userListFill = 0;
$(document).ready(function(){
	populateCountries("country", "state");
	
});
function loadmicrogrid(url){
	$.ajax({
	    contentType:'application/json',
		type : "get",
		url : url,
		success : function(response) {
			userListFill += 1;
			$('#MicorGirdList').html("");
			$('#resultmsg').html("");
			var htmldata ='';
			var custList = '';
			var cityList = '';
			var microList = '';
			var isAdminflag = false;
			var role = response.role;
			
			if(response.users.length > 0){
				isAdminflag = true;
				$('#searchbybox').show();				
			}
			if(isAdminflag){				
				if(parseInt(userListFill) == 1){ /* This condition is written for test whether system is filling dorp down list for the first time or not */
					$('#userIdList').html("<option value='0'>All</option>");
					for(var i=0; i<response.uniqueUsers.length; i++){				
						var username = response.uniqueUsers[i]['fullname'];
						if(username == null){
							username = response.uniqueUsers[i]['userName'];
							if(username == null){
								username = response.uniqueUsers[i]['email'];
							}
						}
						custList = '<option value="'+response.uniqueUsers[i]['id']+'">'+username+'</option>';
						$('#userIdList').append(custList);
					}
					$('#cityIdList').html("<option value='0'>All</option>");
					for(var i = 0 ; i<response.cities.length; i++){
						cityList = '<option value="'+response.cities[i]['city']+'">'+response.cities[i]['city']+'</option>';
						$('#cityIdList').append(cityList);
					}
				}
			}
			if(response.data.length == 0){
				$('#resultmsg').html("Result Not Found");
			}
			for(var i=0;i<response.data.length ; i++){
				var data = response.data[i];
				var user = response.users[i];
				var url = "/public/images/noimage.png";
				var about = data.about;
				var addcomponent = '';
				if(isAdminflag) {
					if(data.deleted == true) {
						addcomponent = '&nbsp;<a href="#" title="Set Profile"><button type="button" class="btn btn-primary btn-sm fa fa-reply" data-id="'+data.id+'" onclick="revertDeletion('+data.id+');"></button></a>';
					}
				}
				if(data.pic_url){
					url = data.pic_url;
				}
				if(data.about.length>70){
					about = about.substr(0,70);
					about += "...";
				}
				var start = new Date(data.created_at);
				var end = new Date();
				var diff =  Math.abs(new Date(end) - new Date(start));
				var seconds = Math.floor((diff)/1000); /* ignore any left over units smaller than a second */
				var minutes = Math.floor(seconds/60); 
				var hours = Math.floor(minutes/60);
				var active = data.active;
				var client = '';
				if(isAdminflag){
					var username = user.fullname;										
					if(username == null){
						username = user.userName;
						if(username == null){
							username = user.email;
						}
					}
					client = '<div class="news-block-tags"><strong>User: </strong><em>'+username+'</em></div>';					
				}
				var settings = '&nbsp;<a href="#" title="Set Profile"><button type="button" class="btn setProfile btn-warning btn-sm fa fa-cog" data-id="'+data.microgrid_id+'" onclick="setProfile();"></button></a>';
				if(role == 'operator'){
					settings = '';
				}
				
				
				htmldata ='<div class="col-md-4 col-sm-4">'+
							'<div class="news-blocks" id="box'+i+'">'+
								'<h3>'+
									'<a href="#" class="openDashboard" data-status="'+active+'" data-id="'+data.microgrid_id+'">'+data.microgrid_name+'</a>'+
								'</h3>'+client+
								'<div class="news-block-tags"><strong>'+data.city+', '+data.country+'</strong><em>'+hours+' hours ago</em></div>'+
								'<p>'+
									'<img src="https://drive.google.com/uc?export=view&id='+url+'" alt="" class="news-block-img pull-right"/>'+about+
								'</p>'+
								'<div class="pull-left">'+
								'<a href="#" title="Show"><button type="button" class="btn showdata btn-default btn-sm fa fa-eye" data-id="'+data.microgrid_id+'" onclick="showMicro();"></button></a>'+
								'<a href="#" title="Edit" style="padding:3px;"><button type="button" onclick="editMicro('+data.id+');" class="btn btn-primary btn-sm fa fa-pencil"></button></a>'+
								'<button type="button" title="Delete" onclick="deleteMicro('+data.id+')" class="btn btn-danger btn-sm fa fa-trash-o" id="userprocess_delete" data="'+data.microgrid_id+'"></button>'+
								settings+
								addcomponent +
								'</div>'+
								'<a href="#" data-status="'+active+'" data-id="'+data.microgrid_id+'" class="openDashboard news-block-btn">View More'+
									'<i class="m-icon-swapright m-icon-black">'+
									'</i>'+
								'</a>'+
							'</div>'+
						'</div>';
				$('#MicorGirdList').append(htmldata);
				
				getMicroGridControllerStatus(data.microgrid_id, i);
				//$('#box'+i).style.backgroundColor='#00ff00';
				//$('.news-blocks').css("background-color",'#00ff00');
				//var h = $('#box'+i).css("background-color",'#00ff00');
			}
			 $(".openDashboard").click(function(){
		    	var id = $(this).attr("data-id");
		    	var status = $(this).attr("data-status");
		    	if(status=="true"){
		    		$.cookie("microgrid_id",id,{ path: '/'});
			    	window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"+id;	
		    	}else{
		    		toastr.info("Microgrid Controller is not active!<br><em>Edit Microgrid Controller for active</em>");	
		    	}		    	
		    });
			$(".showdata").click(function(){
		    	var id = $(this).attr("data-id");
		    	$.cookie("microgrid_id",id,{ path: '/'});    	
		    	window.location.href = "${pageContext.request.contextPath}/rest/micro/show/"+id;
		    });
			$(".setProfile").click(function(){
				var id = $(this).attr("data-id");
				$.cookie("microgrid_id",id,{ path: '/'});    	
				window.location.href = "${pageContext.request.contextPath}/rest/micro/profile_management/"+id;
			});
		}
	});
}


function getMicroGridControllerStatus(microgrid_id, i) {
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro/findbymicrogridid/"+microgrid_id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response) {
			if(response.data){
				if(response.status==true){				
					$('#box'+i).css("background-color",'rgba(255, 218, 201, 0.77)');
				}else{
					
				}
			}
		},
		error:function(data){
			status = false;
		}
	});
}

function openDashboard(id){
	$.cookie("microgrid_id",id,{ path: '/'});
	window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"+id;
}
jQuery(document).ready(function() {   
	App.init(); 
    Index.init();
    loadmicrogrid("${pageContext.request.contextPath}/rest/micro/getlist");
    getUtilityList();
    $('#searchbybox').hide();
});	
function deleteMicro(id){
	bootbox.confirm('Are you sure?', function(result){
		if(result){
			$.ajax({
				url : "${pageContext.request.contextPath}/rest/micro/delete/"+id,
				type : "get",
				contentType : "application/json",
				dataType : "json",
				success : function(response) {
				  	if(response.status==true){
				  		toastr.success('Microgrid controller delete successfully.!');
				  		loadmicrogrid("${pageContext.request.contextPath}/rest/micro/getlist");
				  	}
				}
		    });
		}
	});
	
}

function revertDeletion(id) {	
	 if(confirm("It will revert the action of Micro Grid Controller deletion.\nAre you sure that you want to proceed?")) {
		$.ajax({
			url: "${pageContext.request.contextPath}/rest/micro/revertDeletion/"+id,
			type: "POST",
			contentType : "application/json",
			dataType: "json",
			success: function(response) {
				if(response.status == true) {
					toastr.success("Completed Successfully");
					loadmicrogrid("${pageContext.request.contextPath}/rest/micro/getlist");
				}
			} 
		});
	} 
}

$("#exportMicro").click(function(){
	$.ajax({
		url : "${pageContext.request.contextPath}/rest/micro/getlist",
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			if(response.data){
				JSONToCSVConvertor(response.data,"Micro List",true);
			}	
				
		},
		// callback handler that will be called on error
		error : function(jqXHR, textStatus, errorThrown) {

		}
	});
});
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
    var fileName = "MicroList_";
    //this will remove the blank-spaces from the title and replace it with an underscore
    fileName += ReportTitle.replace(/ /g,"_");   
    
    //Initialize file format you want csv or xls
    var uri = 'data:text/xls;charset=utf-8,' + escape(CSV);
 
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
/* function for do filter */
$('#btnfilter').on('click', function(){
	var userId = $('#userIdList').val();
	var microId = $('#microId').val();
	var cityName = $('#cityIdList').val();
	var url = "${pageContext.request.contextPath}/rest/micro/getlist?userId="+userId+"&microId="+microId+"&cityName="+cityName;
	loadmicrogrid(url);
});

function check(){
	var fno = 1483427106000;
	var zone = 'Etc/GMT+12';
	var rval = adoptTimeZone(fno,zone);	
	
}

</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
