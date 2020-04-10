<div id="microgrid-status" style="height: 330px; width: 100%;"></div>
<script>
$('#microgrid-status').highcharts({
    chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie',
        backgroundColor:'#FFFFFF',
    },
    title: {
    	align: "center",
    	text: 'Microgrid ON - Grid-Tied Mode',
        style: {
            color : 'black',
            fontFamily: 'arial',
            fontSize: '15px',
            fontWeight: 'bold'
        }
    },
    tooltip: {
        pointFormat: '<b>{point.percentage:.1f}%</b>'
    },
     credits: {
         enabled: false
     },
     exporting: { enabled: false },
    legend: {
         align: 'right',
         verticalAlign: 'top',
         itemStyle: {
             fontSize:'14px',
             color : 'black',
             fontFamily: 'arial',            
             fontWeight: 'bold'
         },
         layout: 'vertical',
         x: -10,
         y: 120
     },
    
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                formatter: function() {
                    return Math.round(this.percentage*100)/100 + ' %';
                },
                distance: -40,
                color: '#000000',
            },
            showInLegend: true            
        },
        series: {
            states: {
                hover: {
                    enabled: false
                }
            }
        }
    },
    series: [{
        name: "",
        colorByPoint: true,
        data: []
    }]
});

</script>