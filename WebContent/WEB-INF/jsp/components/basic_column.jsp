<div id="energy_source_chart" style="min-width: 310px; height: 330px; margin: 0 auto"></div>
<script type="text/javascript">
$(function () {
	var microgrid_id = getMicroGridIdFromUrl();
    $.getJSON('${pageContext.request.contextPath}/rest/analysis/getenergysourcedata/'+microgrid_id, function (data) {		    	
    	Highcharts.setOptions({
    	    global : {
    	        useUTC : false
    	    }
    	});
    	var loadData = [];    
        var serverloaddata = data.load;
        var zone = data.zone;
		for(var i=0;i<serverloaddata.length;i++){
			var x =  adoptTimeZone(serverloaddata[i][2], zone);
			var y = eval(serverloaddata[i][3].toFixed(4));
			loadData.push([x,y])
		}
		var solarData = [];
		var serverSolardata = data.solr;
		for(var i=0;i<serverSolardata.length;i++){
			var x =  adoptTimeZone(serverSolardata[i][2], zone);
			var y = eval(serverSolardata[i][3].toFixed(4));
			solarData.push([x,y])
		}
		var gridData = [];
		var serverGriddata = data.grid;
		for(var i=0;i<serverGriddata.length;i++){
			var x =  adoptTimeZone(serverGriddata[i][2], zone);
			var y = eval(serverGriddata[i][3].toFixed(4));
			gridData.push([x,y])
		}		
		
    	$('#energy_source_chart').highcharts('StockChart', {
            chart: {
                alignTicks: false
            },
            rangeSelector: {
                selected: 1
            },
            axisX:{
				   valueFormatString: "DDD-D",
			},
            credits: {
                enabled: false
            },
            exporting: { enabled: false },
            title: {
                text: ''
            },
            scrollbar : {
                enabled : false
            },
            navigator : {
                enabled : false
            },
            tooltip: {
           	  	shared:true,
            	formatter: function(){
            	        var p = '';
            	        if(this.point) {
            	          p += '<b>'+ Highcharts.dateFormat('%b %e, %Y', this.point.x) +'</b><br/>';
            	          p += this.point.config.text // This will add the text on the flags
            	        }
            	        else {              
            	          p += '<b>'+ Highcharts.dateFormat('%b %e, %Y', this.x) +'</b><br/>';
            	          $.each(this.points, function(i, series){
            	            p += '<span style="color:' + this.series.color + '">' + this.series.name + '</span>: <b>'+ this.y + ' kWh </b><br/>';
            	          });
            	        }
            	        return p;
           	      }
            },
            yAxis: {
            	labels: {
                    format: '{value}'
                }
            },
            series: [{
                type: 'column',
                name: 'load',
                color: 'blue',
                data: loadData,
                dataGrouping: {
                    units: [[
                        'week', // unit name
                        [1] // allowed multiples
                    ], [
                        'month',
                        [1, 2, 3, 4, 6]
                    ]]
                }
            },{
                type: 'column',
                name: 'grid',
                color: '#800080',
                data: gridData ,
                dataGrouping: {
                    units: [[
                        'week', // unit name
                        [1] // allowed multiples
                    ], [
                        'month',
                        [1, 2, 3, 4, 6]
                    ]]
                }
            },{
                type: 'column',
                name: 'solar',
                color: 'red',
                data: solarData,
                dataGrouping: {
                    units: [[
                        'week', // unit name
                        [1] // allowed multiples
                    ], [
                        'month',
                        [1, 2, 3, 4, 6]
                    ]]
                }
            }]
        });
    });
});
  </script>