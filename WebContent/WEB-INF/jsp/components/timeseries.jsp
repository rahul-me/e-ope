<div id="solarDailyViewChart" style="height: 190px; width: 100%;"></div>
<script type="text/javascript">
	
$(function () {
	 Highcharts.setOptions({
	    global : {
	        useUTC : false
	    }
	}); 

	$('#solarDailyViewChart').highcharts({
		/* global : {
	        useUTC : false
	    }, */    
		chart: {
                zoomType: 'x',
                backgroundColor:'#FFFFFF'
            },
            title: {
                text: '',
                style: {
                    fontSize: 16,
                    fontFamily: 'arial'
                }
            },
            exporting: { enabled: false },
            credits: {
                enabled: false
            },
            xAxis: {
                type: 'datetime',
                labels: {
                    style: {
                        fontSize:'8px'
                    }
                }
            },
            legend: {
                    align: 'center',
                    verticalAlign: 'top',
                    layout: 'vertical',
                    itemStyle: {
                        fontSize:'11px',
                        color : 'black',
                        fontFamily: 'arial',            
                        fontWeight: 'normal'
                    },
                    symbolHeight: 10,
                    symbolWidth: 10
            },
            yAxis: {
            	min: 0,
                title: {
                    text: ''
                },
                labels: {
                    style: {
                        fontSize:'8px'
                    }
                },                
            },
            tooltip: {
           	 formatter: function() {
                    return  '<b>' + this.series.name +'</b><br/>' +
                        Highcharts.dateFormat('%Y-%b-%e %H:%M',
                                              new Date(this.x))+' <b>'+ this.y+'</b> kW';
                }
            },
            plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                        ]
                    },
                    marker: {
                        radius: 2
                    },
                    lineWidth: 1,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },

            series: [{
                type: 'area',
                name: 'Solar Generation',
                data: []
            }]
        });
    });

</script>