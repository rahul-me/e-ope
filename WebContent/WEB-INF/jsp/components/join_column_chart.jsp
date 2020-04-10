<div id="join_column_chart" style="height: 180px; width: 100%;"></div>
<script>
CanvasJS.addColorSet("greenShades",["#00FF00"]);
var join_dataPoints = new Array();
var join_column_chart = new CanvasJS.Chart("join_column_chart",
		{
			colorSet: "greenShades",
			animationEnabled: true,
			title:{
				text: "Monthly usage in kwh"
			},
			axisX:{
				   valueFormatString: "MMM-DD",
			},
			data: [
			{
				type: "column", //change type to bar, line, area, pie, etc
				dataPoints:join_dataPoints
			}
			]
		});

</script>