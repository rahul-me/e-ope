<div id="datapointchart" style="height: 200px; width: 100%;"></div>

<script type="text/javascript">
$(function () {
	
	 Highcharts.setOptions({
	    global : {
	        useUTC : false
	    }
	}); 
	  var array = [[1230854400000,12.96],[1231113600000,13.51],[1231200000000,13.29],[1231286400000,13.00],[1231372800000,13.24],[1231459200000,12.94]];

			var chartOptions = {
			    chart: {
			        renderTo: 'datapointchart'
			    },
			    rangeSelector : {
	                 selected : 1
	             },
	             title : {
	                 text : ''
	             },
	             navigator : {
	                 enabled : true,
	                 height: 10
	             },
	             xAxis: {
            	    type: 'datetime',
	           	},
	             exporting: { enabled: false },
	             series : [{
	                 name : '',
	                 data : []	                 
	             }] 
			};
			chart1 = new Highcharts.StockChart(chartOptions);
			chart1.redraw();
			$.ajax({
        		url : "${pageContext.request.contextPath}/rest/home/getgraphsolrdata",
        		type : "GET",
        		contentType : "application/json",
        		dataType : "json",
        		success : function(response, textStatus, jqXHR) {
        			if(response.solardata){
        				var solardata = response.solardata;
						var points = [];        				
        				for(var i=0;i<solardata.length;i++){
        					var x =  solardata[i][2];
            				var y = eval(solardata[i][3]);
            				points.push([x,y])
        				}
        				
        				var chart = $('#datapointchart').highcharts();
                        chart.series[0].setData(points);
        			}
        			
        		},
        		
        	});
	    setInterval(function () {
        	$.ajax({
        		url : "${pageContext.request.contextPath}/rest/home/getgraphsolrdata",
        		type : "GET",
        		contentType : "application/json",
        		dataType : "json",
        		success : function(response, textStatus, jqXHR) {
        			if(response.solardata){
        				var solardata = response.solardata;
        			 	console.log(solardata)	
						var points = [];        				
        				for(var i=0;i<solardata.length;i++){
        					var x =  solardata[i][2];
        					console.log("new message");
        					console.log(new Date(solardata[i][2]));
            				var y = eval(solardata[i][3]);
            				console.log("old message");
            				points.push([x,y])
        				}
        				
        				var chart = $('#datapointchart').highcharts();
                        chart.series[0].setData(points);
        			}
        			
        		},
        		
        	});
            	
        }, 1000*30);
	});

</script>