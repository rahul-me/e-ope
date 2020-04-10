<div id="battery_bar_chart" style="height: 187px; margin: 0 auto"></div>
<script>
var battery_bar_chart = new CanvasJS.Chart("battery_bar_chart",
	    {
	      title:{
	        text: "State Of Charge vs. Time",
	        fontWeight: 'bold',
			fontSize: 15,
			fontFamily: 'arial'
	      }, 
	      backgroundColor:'#FFFFFF',
	      animationEnabled: true,     
	      axisY:{
	        titleFontFamily: "arial",
	        titleFontSize: 12,
	        includeZero: false,
	        gridColor:"#F6F6F6",
	        interval:25,
	        maximum:100,
	        minimum:0
	      },
	      toolTip: {
	        shared: true,
	        content:"Time : <b>{x}</b><br> SOC : <b>{y}</b>" 
	      },
	      data: [
		      {        
		        xValueType: 'dateTime',
		    	type: "spline",  
		        name: "True SOC",        
		        showInLegend: true,
		        dataPoints: []
		      } ,
	      	 /*  {        
		        type: "spline",  
		        name: "Time",        
		        showInLegend: true,
		        dataPoints: []
		      } */
	      ],
	      legend:{
	        cursor:"pointer",
	        horizontalAlign: 'right',
	        verticalAlign: 'top',
	        fontSize:10,
	        itemclick:function(e){
	          if(typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
	          	e.dataSeries.visible = false;
	          }
	          else {
	          	e.dataSeries.visible = true;            
	          }
	          battery_bar_chart.render();
	        }
	      }
	    });

battery_bar_chart.render();
</script>