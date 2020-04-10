<div id="solar_detail_chart" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script type="text/javascript">
$(function () {
    $.getJSON('${pageContext.request.contextPath}/rest/analysis/get_solar_analysis', function (data) {

    	var solarData = [];
		var serverSolardata = data.solar;
		for(var i=0;i<serverSolardata.length;i++){
			var x =  serverSolardata[i][2];
			var y = eval(serverSolardata[i][3]);
			solarData.push([x,y])
		}
		
    	$('#solar_detail_chart').highcharts('StockChart', {
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
                name: 'Solar',
                color: 'blue',
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