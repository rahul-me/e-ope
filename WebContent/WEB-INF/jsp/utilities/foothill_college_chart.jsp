<div id="power_analysis_chart"
	style="min-width: 310px; height: 350px; margin: 0 auto"></div>
<script type="text/javascript">
var monthNames = ["January", "February", "March", "April", "May", "June",
                  "July", "August", "September", "October", "November", "December"
                ];
function set_chart(){
	var url = "";
	var search_filter = $("#search_filter").val();
	var customerId = $.urlParam('customer_id');
	console.log(customerId)
	if(search_filter=="week"){
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		url = "${pageContext.request.contextPath}/rest/utility/interval_data_list_by_search_filter?search_filter=week&start_date='"+startDate+"'&end_date='"+endDate+"'&customer_id="+customerId;
		var format = "%b %e";
		drawSolarPoweAnalysisChart(url, search_filter);
	}else if(search_filter=="month"){
		var month = $("#month").val();
		var year = $('#year').val();
		url = "${pageContext.request.contextPath}/rest/utility/interval_data_list_by_search_filter?search_filter=month&month="+month+"&year="+year+"&customer_id="+customerId;
		var format = "%b %e";
		drawSolarPoweAnalysisChart(url, search_filter);
	}else if(search_filter=="year"){
		var year = $("#year").val();
		url = "${pageContext.request.contextPath}/rest/utility/interval_data_list_by_search_filter?search_filter=year&year="+year+"&customer_id="+customerId;
		var format = "%b";
		drawSolarPoweAnalysisChart(url,search_filter);
	}
	console.log(url);
}

function drawSolarPoweAnalysisChart(url, search_filter){
	var milsec = 24 * 3600 * 1000;
	if(search_filter == 'year'){
		milsec = 30 * 24 * 3600 * 1000;
	}
	option = {
			chart: {
				type: 'line'
			},
			title: {
				text: 'Generation and prediction analysis'
			},
			credits: {
				enabled: false
			},
			exporting: {
				enabled: false
			},
			xAxis:{
				type: 'datetime',
				tickInterval: milsec,
				labels:{
	            	formatter: function() {
	            		if(search_filter == 'year'){
	            			return Highcharts.dateFormat('%b', this.value);
	            		}else{
	            			return Highcharts.dateFormat('%e. %b', this.value);	
	            		}	                     
	                } 
	            } 
			},
			yAxis: {
				min: 0,
				title: {
					text: 'Power (kwh)'
				}
			},
			tooltip: {
				shadow: true,
				formatter: function(){
					if(search_filter == 'year'){
						return '<b>'+Highcharts.dateFormat("%b %Y", new Date(this.x))+"</b><br/>"+this.series.name+': <b>'+this.y+' kwh</b>';
					}
					return '<b>'+Highcharts.dateFormat("%d %b %Y", new Date(this.x))+"</b><br/>"+this.series.name+': <b>'+this.y+' kwh</b>';
				}
			},
			series: []
	};	
	
	$.getJSON(url, function(data){
		var generated = {name: 'Generated', data:[]};
		console.log(option);
		if(data.data.length>0){			
			for(var i = 0; i< data.data.length ; i++){					
				generated.data.push([data.data[i][1],((data.data[i][2]))]);		
			}	
		}
		option.series.push(generated);
		$('#power_analysis_chart').highcharts(option);
	});
}



//$('#power_analysis_chart').highcharts(option);
</script>