<div id="green_column_chart" style="height: 223px; width: 100%;"></div>
<script>
	CanvasJS.addColorSet("greenShades", [ "gray","green" ]);
	var weekly_grid_dataPoints = new Array();
	var weekly_solar_dataPoints = new Array();
	var green_column_chart = new CanvasJS.Chart("green_column_chart", {
		colorSet : "greenShades",
		animationEnabled : true,
		title:{
			text: "",
			fontWeight: 'normal',
			fontSize: 15,
			fontFamily: 'arial'
		},
		backgroundColor:'#FFFFFF',
		axisX : {
			valueFormatString : "DDD",
			gridColor: "#F2F2F2" ,
		},
		axisY: {
			gridColor: "#F2F2F2",
			minimum: 0,			
		},
		toolTip:{
	        enabled: true,
	        content: "{x}: {y} kWh"
		},
		legend:{
			fontSize: 11,
			horizontalAlign: 'center',
			verticalAlign: 'top'
		},
		data : [{
			xValueType: "dateTime",
			type : "column", //change type to bar, line, area, pie, etc
			legendText: "Grid (kWh)",
			showInLegend: true, 
			dataPoints : weekly_grid_dataPoints
		},{
			xValueType: "dateTime",
			type : "column", //change type to bar, line, area, pie, etc
			legendText: "Renewable (kWh)",
			showInLegend: true, 
			dataPoints : weekly_solar_dataPoints
		} ]
	});
	
</script>	
