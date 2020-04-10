<div id="electricty_performance" style="height: 223px; width: 100%;"></div>
<script>
CanvasJS.addColorSet("greenShades",["#4d90fe"]);
var ele_dataPoints = [];
var electricty_performance = new CanvasJS.Chart("electricty_performance", { 
	zoomEnabled: true, 
	title: {
		text: "",
		fontWeight: 'normal',
		fontSize: 15,
		fontFamily: 'arial'
	},
	legend: {
		horizontalAlign: 'center',
		verticalAlign: 'top',
		fontSize: 11,
	},
	backgroundColor:'#FFFFFF',
	axisX:{		
		//valueFormatString: "HH:mm"		
	},
	axisY:{
		gridColor: "#F2F2F2"
	},
	colorSet: "greenShades",
	toolTip:{
     	content:"{x} : {y} kW" ,
	},
	data: [
	{
		legendText: 'Usage (kW)',
		showInLegend: true,
		xValueType: "dateTime",
		type: "line",
		dataPoints: ele_dataPoints
	}
	]
});


</script>