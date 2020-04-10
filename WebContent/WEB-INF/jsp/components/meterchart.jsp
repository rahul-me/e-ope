<div id="meterchart" style="width:100%;"></div>
<script>
$(function () {

    $('#meterchart').highcharts({

        chart: {
            type: 'gauge',
            plotBackgroundColor: null,
            plotBackgroundImage: null,
            plotBorderWidth: 0,
            plotShadow: false,
            spacingTop: 0,
            spacingLeft: 0,
            spacingRight: 0,
            spacingBottom: 0,
            height:200,
            backgroundColor:'#FFFFFF',
            
        },
        
        plotOptions: {
            gauge: {
                dataLabels: {
                    enabled: true      
                },
                pivot: {
                    radius: 10
                }
            }
            
        },
        exporting: { enabled: false },
        title: {
            text: '',
            
        },
        credits: {
            enabled: false
        },
        pane: {
            startAngle: -150,
            endAngle: 150,
            background: [{
                backgroundColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                    stops: [
                        [0, '#FFF'],
                        [1, '#333']
                    ]
                },
                borderWidth: 0,
                outerRadius: '107%'
            }, {
                backgroundColor: {
                    linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
                    stops: [
                        [0, '#333'],
                        [1, '#FFF']
                    ]
                },
                borderWidth: 0,
                outerRadius: '107%'
            }, {
                // default background
            }, {
                backgroundColor: '#DDD',
                borderWidth: 0,
                outerRadius: '105%',
                innerRadius: '103%'
            }]
        },

        // the value axis
        yAxis: {
            min: 0,
            max: 100,
            minorTickInterval: 'auto',
            minorTickWidth: 0.5,
            minorTickLength: 10,
            minorTickPosition: 'outsude',
            minorTickColor: 'black',
            tickPixelInterval: 15,
            tickWidth: 1,
            tickPosition: 'outsude',
            tickLength: 15,
            tickColor: 'black', 
	    	offset: -30,
            labels: {
  				step: 2,
                distance: 18,
                rotation: 'auto',
                style: { color: 'black', fontWeight: '500',fontSize:'12px'}
            },
            title: {
                text: 'Kw'
            },
            /* plotBands: [{
                from: 0,
                to: 60,
                outerRadius: '100%',
                innerRadius: '65%',
                color: '#5cb85c' // green
            }, {
                from: 60,
                to: 80,
                outerRadius: '100%',
                innerRadius: '65%',
                color: '#DDDF0D' // yellow
            }, {
                from: 80,
                to: 100,
                outerRadius: '100%',
                innerRadius: '65%',
                color: '#DF5353' // red
            }] */
        },

        series: [{
            name: 'Load',
            data: [0],
            tooltip: {
                valueSuffix: ' Kw'
            }
        }]

    },
        // Add some life
        function (chart) {
    	var microgrid_id = getMicroGridIdFromUrl();
            if (!chart.renderer.forExport) {
            	var point = chart.series[0].points[0];
            	$.ajax({
            		url : "${pageContext.request.contextPath}/rest/home/load_data/"+microgrid_id,
            		type : "GET",
            		contentType : "application/json",
            		dataType : "json",
            		success : function(response, textStatus, jqXHR){
            			if(response.load){
            				var load = response.load;
            				if(load!="" && load!=undefined){
            					var point_val = eval(load[0][4])/1000;
            					point.update(eval(point_val.toFixed(2)));
            				}else{
            					point.update(0);	
            				}
            			}else{
            				var load = response.load;
                			point.update(eval(0));
            			}
            			
            			/* chart.yAxis[0].update({
            			    max: 200
            			});  */
            			
        				$.ajax({
        					url : "${pageContext.request.contextPath}/rest/micro/findbymicrogridid/"+microgrid_id,
        					type : "GET",
        					contentType : "application/json",
        					dataType : "json",
        					success : function(response) {        						               					
        						 if(response.data){
        							var max_meter_value = response.data['max_meter_value'];
        							var sixtyper = eval(max_meter_value * (60/100));
        							var twentyper = eval(max_meter_value * (20/100));
        							chart.yAxis[0].update({
                        			    max: eval(max_meter_value)
                        			});
        							 chart.yAxis[0].addPlotBand({
        				                from: 0,
        				                to: eval(sixtyper),
        				                outerRadius: '100%',
        				                innerRadius: '65%',
        				                color: '#5cb85c' // green
        				            });
        							 chart.yAxis[0].addPlotBand({
        				                from: sixtyper,
        				                to: eval(sixtyper+twentyper),
        				                outerRadius: '100%',
        				                innerRadius: '65%',
        				                color: '#DDDF0D' // yellow
        				            });
        							 chart.yAxis[0].addPlotBand( {
        				                from: eval(sixtyper+twentyper),
        				                to: max_meter_value,
        				                outerRadius: '100%',
        				                innerRadius: '65%',
        				                color: '#DF5353' // red
        				            });
        							
        						} 
        					},
        					error:function(data){
        						status = false;
        					}
        				});            			            		            			
            		},
            		
            	});
                setInterval(function () {
                        var newVal,
                        inc = Math.round((Math.random() - 0.5) * 20);
                    $.ajax({
                		url : "${pageContext.request.contextPath}/rest/home/load_data",
                		type : "GET",
                		contentType : "application/json",
                		dataType : "json",
                		success : function(response, textStatus, jqXHR) {
                			if(response.load){
                				var load = response.load;
                				if(load!="" && load!=undefined){
                					var point_val = eval(load[0][4])/1000;
                					point.update(eval(point_val.toFixed(2)));
                				}else{
                					point.update(0);	
                				}
                    			
                			}else{
                				var load = response.load;
                    			point.update(eval(0));
                			}
                		},
                		
                	});
                }, 1000*30);
            }
        });
});
</script>