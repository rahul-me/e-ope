<div id="solar_monthly" style="height:120px;"></div>
<script>
CanvasJS.addColorSet("orangeShades",["#FFA500"]);
var solar_monthly_dataPoints = new Array();
var solar_monthly = new CanvasJS.Chart("solar_monthly",
		{
			colorSet: "orangeShades",
			animationEnabled: true,
			title:{
				text: "Month View"
			},
			data: [
			{
				type: "column", //change type to bar, line, area, pie, etc
				dataPoints: solar_monthly_dataPoints
			}
			]
		});

solar_monthly.render();
</script>