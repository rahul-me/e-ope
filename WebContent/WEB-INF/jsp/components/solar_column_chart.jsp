<div id="solar_column_chart" style="min-width: 310px; height: 370px; margin: 0 auto"></div>
<script type="text/javascript">
function set_chart(){
	var microgrid_id = getMicroGridIdFromUrl();
	var url = "";
	var search_filter = $("#search_filter").val();
	if(search_filter=="week"){
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		url = "${pageContext.request.contextPath}/rest/solar/get_solar_data/"+microgrid_id+"?search_filter=week&start_date='"+startDate+"'&end_date='"+endDate+"'";
		var format = "%b %e";
		setSolarColumnChart(url,format);
	}else if(search_filter=="month"){
		var month = $("#month").val();
		var year = $("#year").val();
		url = "${pageContext.request.contextPath}/rest/solar/get_solar_data/"+microgrid_id+"?search_filter=month&month="+month+"&year="+year;
		var format = "%b %e";
		setSolarColumnChart(url,format);
	}else if(search_filter=="year"){
		var year = $("#year").val();
		url = "${pageContext.request.contextPath}/rest/solar/get_solar_data/"+microgrid_id+"?search_filter=year&year="+year;
		var format = "%b";
		setSolarColumnChart(url,format);
	}
	//console.log(url);
}
function setSolarColumnChart(url,format){	
	$.getJSON(url, function (data) {
    	var solarData = [];
    	var categories = [];
		var serverSolardata = data.data;
		for(var i=0;i<serverSolardata.length;i++){
			//console.log(serverSolardata[i][1]);
			//console.log(new Date(serverSolardata[i][1]));
			var x =  new Date(serverSolardata[i][1]);
			var num = serverSolardata[i][3]
			var y = eval(num.toFixed(2));			
			solarData.push(y)
			categories.push(x);
		}
		//console.log(solarData)
		 $('#solar_column_chart').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: ''
		        },
		        credits: {
	                enabled: false
	            },
	            exporting: { enabled: false },
		        xAxis: {
		            categories: categories,
		            crosshair: true,
		            labels:{
		            	formatter: function() {
		                     return Highcharts.dateFormat(format, this.value);
		                }
		            }
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: 'kwh'
		            }
		        },
		        tooltip: {
		           	 formatter: function() {
		           		 if(format = "%b"){
		           			return  '<b>' + this.series.name +'</b><br/>' +
	                        Highcharts.dateFormat('%b',
	                                              new Date(this.x))+' <b>'+ this.y+'</b> kWh';
		           		 }else{
		                    return  '<b>' + this.series.name +'</b><br/>' +
		                        Highcharts.dateFormat('%Y-%b-%e %H:%M',
		                                              new Date(this.x))+' <b>'+ this.y+'</b> kWh';
		           		 }                             
		             }
		        },
		        plotOptions: {
		            column: {
		                pointPadding: 0.2,
		                borderWidth: 0
		            }
		        },
		        series: [{
		            name: 'Solar',
		            showInLegend:false,
		            data: solarData
		        }]
		    });
    });
}
  </script>