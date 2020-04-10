<div id="battery_source" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script type="text/javascript">
$(function () {
	 $.getJSON('${pageContext.request.contextPath}/rest/analysis/get_battery_analysis', function (data) {
		var batteryData = [];    
        var serverBatteryData = data.battery;
		for(var i=0;i<serverBatteryData.length;i++){
			var x =  serverBatteryData[i][2];
			var y = eval(serverBatteryData[i][4]);
			batteryData.push([x,y])
		}   
	 	// Create the chart
        $('#battery_source').highcharts('StockChart', {
            rangeSelector : {
                selected : 1
            },

            title : {
                text : ''
            },
            credits: {
             enabled: false
            },
            exporting: { enabled: false },
            series : [{
                name : 'Battery',
                data : batteryData,
                tooltip: {
                    valueDecimals: 2
                }
            }]
        });
	});

// 	$.getJSON('${pageContext.request.contextPath}/rest/analysis/get_battery_analysis', function (data) {

//     	var batteryData = [];    
//         var serverBatteryData = data.battery;
// 		for(var i=0;i<serverBatteryData.length;i++){
// 			var x =  serverBatteryData[i][2];
// 			var y = eval(serverBatteryData[i][4]);
// 			batteryData.push([x,y])
// 		}
//     	$('#basic_column').highcharts('StockChart', {
//             chart: {
//                 alignTicks: false
//             },
//             rangeSelector: {
//                 selected: 1
//             },
//             axisX:{
// 				   valueFormatString: "DDD-D",
// 			},
//             credits: {
//                 enabled: false
//             },
//             exporting: { enabled: false },
//             title: {
//                 text: ''
//             },
//             scrollbar : {
//                 enabled : false
//             },
//             navigator : {
//                 enabled : false
//             },
//             tooltip: {
//            	  	shared:true,
//             	formatter: function(){
//             	        var p = '';
//             	        if(this.point) {
//             	          p += '<b>'+ Highcharts.dateFormat('%b %e, %Y', this.point.x) +'</b><br/>';
//             	          p += this.point.config.text // This will add the text on the flags
//             	        }
//             	        else {              
//             	          p += '<b>'+ Highcharts.dateFormat('%b %e, %Y', this.x) +'</b><br/>';
//             	          $.each(this.points, function(i, series){
//             	            p += '<span style="color:' + this.series.color + '">' + this.series.name + '</span>: <b>'+ this.y + ' kWh </b><br/>';
//             	          });
//             	        }
//             	        return p;
//            	      }
//             },
//             yAxis: {
//             	labels: {
//                     format: '{value}'
//                 }
//             },
//             series: [{
//                 type: 'column',
//                 name: 'Battery',
//                 color: 'red',
//                 data: batteryData,
//                 dataGrouping: {
//                     units: [[
//                         'week', // unit name
//                         [1] // allowed multiples
//                     ], [
//                         'month',
//                         [1, 2, 3, 4, 6]
//                     ]]
//                 }
//             }]
//         });
//     });
});
  </script>