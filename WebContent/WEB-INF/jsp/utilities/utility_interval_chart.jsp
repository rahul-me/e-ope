<script>
function setIntervalChart(url,format){
	$.getJSON(url, function (response) {
		var cost = [];
		var usage = [];
		var categories = [];
		var solar_cost = [];
		var monthNames = ["Jan", "Feb", "Mar", "April", "May", "June",
		                  "July", "Aug", "Sept", "Oct", "Nov", "Dec"
		                ];
		if(response.data){
			var interval_data = response.data;					
			var cost_val = 0;
			var usage_val = 0;
			for(i=0;i<interval_data.length;i++){
				cost_val = 0;
				if(interval_data[i][2]!=null){
					cost_val = interval_data[i][2].toFixed(2)		
				}
				cost.push(eval(cost_val));
				usage_val = 0;
				if(interval_data[i][3]!=null){
					usage_val = interval_data[i][3].toFixed(2)		
				}
				usage.push(eval(usage_val));
				var x =  new Date(interval_data[i][1]);
				if(format=="%b"){
					var month = monthNames[x.getMonth()];
					categories.push(month);
				}else{
					var c = x.getDate()+"-"+monthNames[x.getMonth()];
					categories.push(c);
				}
				
				var solarRate = 0;
				if(interval_data[i][4]!=null){	
					solarRate = interval_data[i][4];
				}
				solar_cost.push(eval(solarRate));
			}
			console.log(categories)
			$('#utility_interval_data').highcharts({
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
		        xAxis: [{
		            categories: categories,
		            crosshair: true
		        }],
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
		                format: '{value} Kwh',
		                style: {
		                    color: Highcharts.getOptions().colors[0]
		                }
		            },
		            
		            opposite: true
		        }],
		        tooltip: {
		        	
		            shared: true
		        },
		        legend: {
		            layout: 'vertical',
		            align: 'left',
		            x: 120,
		            verticalAlign: 'top',
		            y: 100,
		            floating: true,
		            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
		        },
		        series: [{
		            name: 'Usage',
		            type: 'column',
		            yAxis: 1,
		            data: usage,
		            tooltip: {
		                valueSuffix: ' Kwh'
		            },		            

		        }, {
		            name: 'Without Microgrid',
		            type: 'spline',
		            data: cost,
		            tooltip: {
		                valueSuffix: '$'
		            }
		        },{
		            name: 'With Microgrid',
		            type: 'spline',
		            data: solar_cost,
		            tooltip: {
		                valueSuffix: '$'
		            }
		        }]
		    });	
		}
		
	});
}

</script>