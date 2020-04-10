<div id="current_soh_chart" style="width:95%; height:235px"></div> 
<script>
var current_soh_data = [];
var current_soh_chart = new CanvasJS.Chart("current_soh_chart", { 
	title: {
		text: ""
	},
	axisX:{
	   title : "Days",	
       gridColor: "#ECECEC" ,
       gridThickness: 2,
       valueFormatString: "DD",
    },
    axisY:{    
       title : "SOH (%)",		
       gridColor: "#ECECEC"
    },
	data: [
		{
			type: "line",
			color:'#5796FD',
			dataPoints: current_soh_data
		}
	]
});
current_soh_chart.render();	

$(document).ready(function(){
	var dt = new Date();
	var month = dt.getMonth()+1;
	$("#month_filter").val(month);	
	var updateChart = function () {
		var microgrid_id = getMicroGridIdFromUrl();
		var month = $("#month_filter").val();
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/battery/getbatterydatamonth/"+microgrid_id+"?month="+month,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {				 
				var soh = response.soh;
				var soh_data = new Array();
				for(var i=0;i<soh.length;i++){
					var dt = new Date(soh[i][1]);
					soh_data.push({
						x: new Date(dt.getFullYear(),dt.getMonth(),dt.getDate()),
						y: eval(soh[i][2])
					});
				}	
				current_soh_chart.options.data[0].dataPoints = soh_data;
				current_soh_chart.render(); 
			}
		});	
	}
	updateChart();
	$("#month_filter").change(function(){
		updateChart();
	});
});	


</script>