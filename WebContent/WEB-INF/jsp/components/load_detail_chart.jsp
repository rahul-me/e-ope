<div id="load_detail_chart" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script type="text/javascript">
var microgrid_id = getMicroGridIdFromUrl();
$(function () {		
    $.getJSON('${pageContext.request.contextPath}/rest/analysis/get_load_analysis/'+microgrid_id, function (data) {

    	var loadData = [];    
        var serverloaddata = data.load;
        var zone = data.zone;
		for(var i=0;i<serverloaddata.length;i++){
			var x =  adoptTimeZone(serverloaddata[i][2],zone);
			var y = eval(serverloaddata[i][3].toFixed(4));
			loadData.push([x,y]);
		}
		Highcharts.setOptions({
		    global : {
		        useUTC : false
		    }
		});
    	$('#load_detail_chart').highcharts('StockChart', {
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
            }]
        });
    });
});
  </script>