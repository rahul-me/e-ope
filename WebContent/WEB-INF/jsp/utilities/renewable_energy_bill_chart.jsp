<div id="power_analysis_chart" style="min-width: 310px; height: 350px; margin: 0 auto"></div>


<script>
function showREGenerationUsageVsCost(){	
	$.ajax({
		url:'${pageContext.request.contextPath}/rest/micro/getReqREGenData?mgc_id='+arguments[0]+'&port_cfg='+arguments[1]+'&year='+arguments[2]+'&month='+arguments[3],
				type:'GET',
				success: function(response){
					if(response.status){
						if(response.data){
							$.each(response.data, function(index, value){
								console.log(value);
								
							});
							setChart(response.data);
						}
					}
				}
	});
}

function setChart(data){
	
	var usage = [];
	var cost = [];
	
	$.each(data, function(index, value){
		var usage_ = data[index][1];
		var cost_ = data[index][3];
		var time_ = data[index][2];
		usage.push([time_,usage_]);
		cost.push([time_,cost_]);
		console.log(usage);
		console.log(cost);
	});
	
	var options = {			
		        chart: {
		            zoomType: 'xy'
		        },
		        title: {
		            text: ''
		        },
		        exporting: { enabled: false },
				    credits: {
				       enabled: false
				    },
		        xAxis: {
		        	type: 'datetime',
		        },
		        yAxis: [{ // Primary yAxis
		        	min:0,
		            labels: {
		                format: '{value}$',
		                style: {
		                    color: Highcharts.getOptions().colors[1]
		                }
		            },
		            title: {
		                text: 'cost',
		                style: {
		                    color: Highcharts.getOptions().colors[1]
		                }
		            }
		        }, { // Secondary yAxis
		            title: {
		                text: 'Usage',
		                style: {
		                    color: Highcharts.getOptions().colors[0]
		                }
		            },
		            labels: {
		                format: '{value} kWh',
		                style: {
		                    color: Highcharts.getOptions().colors[0]
		                }
		            },
		            
		            opposite: true
		        }],
		        tooltip: {
		        	
		            shared: true
		        },
		        /* legend: {
		            layout: 'vertical',
		            align: 'left',
		            x: 100,
		            verticalAlign: 'top',
		            y: 100,
		            floating: true,
		            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
		        }, */
		        series: [{
		            name: 'Usage',
		            type: 'column',
		            yAxis: 1,
		            data: usage,
		            tooltip: {
		                valueSuffix: ' Kwh'
		            },		            

		        }, {
		            name: 'Energy Cost',
		            type: 'spline',
		            data: cost,
		            tooltip: {
		                valueSuffix: '$'
		            }
		        }]
		    };
	
	$('#power_analysis_chart').highcharts(options);
	}

</script>