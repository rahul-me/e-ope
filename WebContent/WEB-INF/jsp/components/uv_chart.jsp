<div id="uv_chart" style="height: 140px; margin: 0 auto"></div>
<script>
$(function () {
    $('#uv_chart').highcharts({
    	exporting: { enabled: false },
        chart: {
            type: 'gauge',
            plotBackgroundColor: null,
            plotBackgroundImage: null,
            plotBorderWidth: 0,
            plotShadow: false
        },
        title: {
            text: ''
        },
        credits: {
            enabled: false
        },
        pane: {
      	 size:[150],
         startAngle: -90,
         center: ['50%', '90%'],
         endAngle: 90,
         background: {backgroundColor: 'white', borderWidth: 0,innerradious:'10%'}
        },

        // the value axis
        yAxis: {
            min: 0,
            max: 80,
            minorTickInterval: 'auto',
            minorTickWidth: 0,
            minorTickLength: 10,
            minorTickPosition: 'inside',
            minorTickColor: '#666',
            tickPixelInterval: 30,
            tickWidth: 0,
            tickPosition: 'inside',
            tickLength: 10,
            tickColor: '#666',
            labels: {
                step: 2,
                rotation: 'auto'
            },
            plotBands: [{
                from: 0,
                to: 75,
                color: '#5c90e3' // blue
            }, {
                from: 75,
                to: 100,
                color: '#e6e6e6' 
            }]        
        },
        plotOptions: {
            gauge: {
                dataLabels: {
                    enabled: false      
                },
                pivot: {
                    radius: 10
                }
            }
        },
        series: [{
            name: 'Solar',
            data: [75],
            tooltip: {
                valueSuffix: ' Kw'
            }
        }]
    },
     function (chart) {
    	if (!chart.renderer.forExport) {
        	var point = chart.series[0].points[0];
        	$.ajax({
        		url : "${pageContext.request.contextPath}/rest/home/solar_data",
        		type : "GET",
        		contentType : "application/json",
        		dataType : "json",
        		success : function(response, textStatus, jqXHR) {
        			if(response.solar){
        				var solar = response.solar;
        				if(solar[0]!="" && solar[0]!=undefined){
        					point.update(eval(solar[0][3]));
        				}else{
        					point.update(0);
        				}
        			}else{
        				var solar = response.solar;
            			point.update(eval(0));
        			}
        		},
        		
        	});
            setInterval(function () {
                var newVal,
                inc = Math.round((Math.random() - 0.5) * 20);
                $.ajax({
            		url : "${pageContext.request.contextPath}/rest/home/solar_data",
            		type : "GET",
            		contentType : "application/json",
            		dataType : "json",
            		success : function(response, textStatus, jqXHR) {
            			if(response.solar){
            				var solar = response.solar;
            				if(solar[0]!="" && solar[0]!=undefined){
            					point.update(eval(solar[0][3]));
            				}else{
            					point.update(0);
            				}
                			
            			}else{
            				var solar = response.solar;
                			point.update(eval(0));
            			}
            		},
            		
            	});
            }, 1000*3);
        }
        });
});
</script>