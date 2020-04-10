<div id="container-line" class="chart" style="height:220px;"></div>
<script src="${pageContext.request.contextPath}/public/javascripts/multicolor_series.js"></script>
<script>
var chart;
var containerLine;
$(function () {
	 Highcharts.setOptions({
	    global : {
	        useUTC : false
	    }
	}); 
     containerLine = new Highcharts.Chart({
        chart: {
            renderTo: 'container-line',
            type: 'coloredline',
            zoomType: 'xy',
            borderRadius: 0,
            backgroundColor: 'white'
        },
        exporting: { enabled: false },
        credits: {
            enabled: false
        },
        tooltip: {
        	formatter: function() {
                return  '<b>' + this.series.name +'</b><br/>' +
                    Highcharts.dateFormat('%Y-%b-%e %H:%M',this.x)+' <b>'+ this.y+'</b> W';
            }
        },
        yAxis: {
            title: {
                text: 'Voltage'
            },  
            gridLineColor:'#ECECEC'
        },           
        xAxis: {
            type: 'datetime',
            title: {
                text: 'Time (Hours)'
            },
            labels: {
                style: {
                    fontSize:'8px'
                }
            },
            gridLineWidth:1,
            gridLineColor:'#ECECEC'
        },
        title: {
            style: {
                'fontSize': '1em'
            },
            useHTML: true,
            x: -27,
            y: 8,
            text: ''
        },
        series: [{
        	name: "Output Voltage",
        	showInLegend: false, 
            data: [0,0]
        }]
    });    
    

     function genData(n) {
         var d = [],
             i = 0;
         while (i < n) {
             var v = Math.round(i / 16);
             d.push({
                 y: Math.random() * 100,
                 segmentColor: color(v),
             });
             i++;
         }
         return d;
     }
     
     getData(0);
     
});

function getData(hour) {
	var microgrid_id = getMicroGridIdFromUrl();
    var d = [];
    var hourDiff = hour;
    $.ajax({
		url : "${pageContext.request.contextPath}/rest/battery/getbatterydata/"+hourDiff+"/"+microgrid_id,
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		success : function(response, textStatus, jqXHR) {
			// current_voltage data
			var current_voltage_data = response.current_voltage_data;
			var zone = response.zone;
			//console.log(zone);
			 // data for hour interval
			if(current_voltage_data.length > 0) {
				var hour = new Date(current_voltage_data[0][1]).getHours();
				dataHour = hour;
				//console.log('data available');
				//console.log(hour);
				$('#hourInterval').html('<p><i id="iconLeft" onClick="prevHour()" style="cursor: pointer; color: #B3B3B3;" data-value="'+currentHour+'" class="glyphicon glyphicon-chevron-left"></i>'+hour+':00 - '+(hour+1)+':00<i onClick="nextHour()" id="iconRight" data-value="'+currentHour+'" style="cursor: pointer; color: #B3B3B3;" class="glyphicon glyphicon-chevron-right"></i></p>');				
			} else {
				//console.log('Current Hour');
				//console.log(currentHour);
				var hour = parseInt(new Date().getHours()) + parseInt(currentHour);
				dataHour = hour;
				//console.log('data not available');
				//console.log(hour);
				$('#hourInterval').html('<p><i id="iconLeft" onClick="prevHour()" style="cursor: pointer; color: #B3B3B3;" data-value="'+currentHour+'" class="glyphicon glyphicon-chevron-left"></i>'+hour+':00 - '+(hour+1)+':00<i onClick="nextHour()" id="iconRight" data-value="'+currentHour+'" style="cursor: pointer; color: #B3B3B3;" class="glyphicon glyphicon-chevron-right"></i></p>');
			}
			// end for hour interval 
			var current_out_voltage_data = [];
			for(var i=0;i<current_voltage_data.length;i++){
				var state = current_voltage_data[i][3];
				var color = "red";
				if(state=="charging"){
					color = "green";	
				}
				var voltage_v = eval(current_voltage_data[i][2]).toFixed(4);
				current_out_voltage_data.push({
					x: adoptTimeZone(current_voltage_data[i][1], zone),
					y: eval(voltage_v),
					segmentColor: color,
					marker:{fillColor:color,states:{hover:{enabled: false}}}
				});
			}
			//var containerLine = $('#container-line').highcharts();
			containerLine.series[0].setData(current_out_voltage_data);			
		}
	});	    
}

</script>