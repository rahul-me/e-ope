<script>
var sortObjectByKey = function(obj){
    var keys = [];
    var sorted_obj = {};
    for(var key in obj){
        if(obj.hasOwnProperty(key)){
            keys.push(key);
        }
    }
    // sort keys
    keys.sort();
    // create new array based on Sorted Keys
    jQuery.each(keys, function(i, key){
        sorted_obj[key] = obj[key];
    });
    return sorted_obj;
};
var convertToArray = function(obj){
	array = [];	
	 for(var key in obj){
        if(obj.hasOwnProperty(key)){
            array.push([eval(key), obj[key]])
        }
    }
 	return array
};
$(document).ready(function(){
	var microgrid_id = getMicroGridIdFromUrl();
	var updateChart = function () {
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/home/getgraphdata/"+microgrid_id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {
				// electricity data (kw)
				var zone = response.zone;
					         	
	         	// battery status data
				var battery_data = response.batterydata;
				var battery_points = new Array();
				for(var i=0;i<battery_data.length;i++){
					battery_points.push({
						x: adoptTimeZone(battery_data[i][1], zone),
						y: eval(battery_data[i][3])
					})								
				}
				var battery_discharge_data = response.battery_discharge_data;
				var battery_discharge_points = new Array();
				if(battery_discharge_data!=undefined && battery_discharge_data!=null){
					for(var i=0;i<battery_discharge_data.length;i++){
						battery_discharge_points.push({
							x: new Date(battery_discharge_data[i][1]),
							y: eval(battery_discharge_data[i][3])
						})
					}
				}
				battery_bar_chart.options.data[0].dataPoints = battery_points;
				
				//battery_bar_chart.options.data[1].dataPoints = battery_discharge_points;
				battery_bar_chart.render(); 
				
				// end battery status data
				// set microgridStatus data (current_c)
				var loaddata = response.loaddata;				
				var solardata = response.solardata;
				var griddata = response.griddata;				
				var microgrid_status = $('#microgrid-status').highcharts();
				var grid_kwh = 0;
				var battery_kwh = 0;
				var battery_soh = 0;
				var solar_kwh = 0;
				if(griddata!=undefined && griddata!=null && griddata.length>0){
					grid_kwh = griddata[0][3];
				}
				if(response.battery_status!=undefined && response.battery_status!=null && response.battery_status.length>0){	
					battery_kwh = eval(response.battery_status[0][4]);
					battery_soh = eval(response.battery_status[0][2]);
				}
				if(solardata!=undefined && solardata!=null && solardata.length>0){
					solar_kwh = eval(solardata[0][3]);
				}
				microgrid_status.series[0].setData([{name:"Grid",y:eval(grid_kwh),color:"gray"},
				                                    {name:"Battery",y:eval(battery_kwh),color:"#4cae4c"},
				                                    {name:"Solar",y:eval(solar_kwh),color:"rgb(222,107,22)"}]);
				
				// end
				
				// set grid status
				var grid_status_Data = response.grid_status_Data;
				if(grid_status_Data!=null && grid_status_Data.length>0){
					var grid_kwh = grid_status_Data[0][2];
					if(grid_kwh>0){						
						$("#on").addClass("btn-success");
						$("#on").removeClass("btn-danger");
						$("#on").html("ON");
					}else{
						$("#on").removeClass("btn-success");
						$("#on").addClass("btn-danger");
						$("#on").html("OFF");
					}
				}else{					
					$("#on").removeClass("btn-success");
					$("#on").addClass("btn-danger");
					$("#on").html("OFF");
				}				
				// end
				
											
			}
		});	
	};
	var energy_usage_weekly = function(){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/home/energy_usage_weekly/"+microgrid_id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {
				var zone = response.zone;
				// weekly grid and solar data (KWH)
				var weeklygriddata = response.weeklygriddata;
				var weekly_grid_data = new Array();
				
				var weeklysolardata = response.weeklysolardata;				
				var weekly_solar_data = new Array();
				
				var localDateArray = setLocalDateArrayForGreenColumnChart(zone);
				
				fillData(weeklygriddata, weekly_grid_data, localDateArray, zone);
				fillData(weeklysolardata, weekly_solar_data, localDateArray, zone);
				
				green_column_chart.options.data[0].dataPoints = weekly_grid_data;
				green_column_chart.options.data[1].dataPoints = weekly_solar_data;
				green_column_chart.render(); 
				// end
			}			
		});
	}
	var footprint_data = function(){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/home/footprint/"+microgrid_id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {
				// get grid kwh sum for (30 days carbon footprint)
				var gridkwhsum = response.gridkwhsum;
				var solarkwhsum = response.solarkwhsum;
				if(gridkwhsum){
					$("#co2").html(Math.round(gridkwhsum[0]*1.16)+" lbs");					
				}else{
					$("#co2").html("0 lbs");			
				}
				if(solarkwhsum){
					$("#myco2").html(Math.round(solarkwhsum[0]*1.16)+" lbs");
				}else{
					$("#myco2").html("0 lbs");
				}
				// end
			}});
	}
	var energy_usage = function(){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/home/energy_usage/"+microgrid_id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {
				// electricity data (kw)
				var zone = response.zone;
				var electricitydata = response.electricitydata;				
				var ele_data = new Array();
				for(var i=0;i<electricitydata.length;i++){
					ele_data.push({
						/* x: electricitydata[i][1], */
						x: adoptTimeZone(electricitydata[i][1], zone),
						y: eval((electricitydata[i][4]/1000).toFixed(4))
					});
				}
				electricty_performance.options.data[0].dataPoints = ele_data;
				electricty_performance.render(); 
				// end electricity data

				
			}
		});
	}
	var update_load_distribution = function(){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/home/load_distribution/"+microgrid_id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {
				// electricity data (kw)
				var zone = response.zone;
				
				// energy distribution (kwh)
				var solar_energy_data = response.energy_distribution_data;								
				var grid_energy_data = response.grid_energy_data;
				var load_energy_data = response.load_energy_data;
				var grid_energy_data_in = response.grid_energy_data_in;
				var solar_data_chartData=[];
				var grid_data_chartData = [];				
				var load_data_chartData = [];
				
				var grid_energy_data_in_object = {};
				
				grid_energy_data_in.forEach(function(value, index){
					grid_energy_data_in_object[eval(value[1] - (value[1]%60000))] = value[2];
				});
				
							
				for(var i=0;i<solar_energy_data.length;i++){
					var setMin = new Date(solar_energy_data[i][1]).setMinutes(0);
	            	var setSec = new Date(setMin).setSeconds(0);
					/* var x = setSec; */					
					
					var x = adoptTimeZone(solar_energy_data[i][1],zone);
					var y = eval(solar_energy_data[i][2].toFixed(4));		        
			        solar_data_chartData.push([x,y]);
				}			
				var gridStatus = 0;
				var addedIndex = [];
				for(var i=0;i<grid_energy_data.length;i++){
					var setMin = new Date(grid_energy_data[i][1]).setMinutes(0);
	            	var setSec = new Date(setMin).setSeconds(0);
					/* var x = setSec; */	
					
					var in_data = grid_energy_data_in_object[eval(grid_energy_data[i][1] - (grid_energy_data[i][1]%60000))];					
					var x = adoptTimeZone(grid_energy_data[i][1],zone);
					var y;/* = eval(grid_energy_data[i][2].toFixed(4)); */
					 if(!(in_data === undefined)){
						y = eval(eval(grid_energy_data[i][2] - in_data).toFixed(4));
						addedIndex.push(eval(grid_energy_data[i][1] - (grid_energy_data[i][1] % 60000)));
					} else {
						y = eval(grid_energy_data[i][2].toFixed(4));
					} 
			        
			        grid_data_chartData.push([x,y]);		        
				}
				grid_energy_data_in_array = convertToArray(grid_energy_data_in_object);
				if(grid_energy_data_in_array.length != addedIndex.length){
					for(var t=0;t < grid_energy_data_in_array.length ; t++){
						if(addedIndex.indexOf(grid_energy_data_in_array[t][0]) <= -1){
							var x = adoptTimeZone(grid_energy_data_in_array[t][0],zone);
							y = eval(grid_energy_data_in_array[t][1].toFixed(4));
							y = 0 - y
							grid_data_chartData.push([x,y]);
						}
					}
				}				
				for(var i=0;i<load_energy_data.length;i++){
					var setMin = new Date(load_energy_data[i][1]).setMinutes(0);
	            	var setSec = new Date(setMin).setSeconds(0);
					/* var x = setSec; */					
					var x = adoptTimeZone(load_energy_data[i][1],zone);
			        var y = eval(load_energy_data[i][2].toFixed(4));
			        load_data_chartData.push([x,y]);
				}										
				var option = $('#energy_load_distributor').highcharts();

				load_data_chartData.sort(function(a, b) {
					return a[0]- b[0];
				});
				grid_data_chartData.sort(function(a, b) {
					   return a[0]- b[0];
				});
				solar_data_chartData.sort(function(a, b) {
					   return a[0]- b[0];
				});
				option.series[0].setData(eval(load_data_chartData))
				option.series[1].setData(eval(grid_data_chartData))
				option.series[2].setData(eval(solar_data_chartData))
			}
			
		});
	}
	var toCamelCase = function (str) {
	    return str.toLowerCase().replace(/(?:(^.)|(\s+.))/g, function(match) {
	        return match.charAt(match.length-1).toUpperCase();
	    });
	};
	var daily_solar_data = function(){
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/home/daily_solar/"+microgrid_id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {
				// electricity data (kw)
				var zone = response.zone;
				
				// daily solar data (kwh)
				var dailySolarData = response.dailySolarData;
				var solar_daily_data = new Array();
				for(var i=0;i<dailySolarData.length;i++){
					var setMin = new Date(dailySolarData[i][1]).setMinutes(0);
					var setSec = new Date(setMin).setSeconds(0);
					solar_daily_data.push({
						x:adoptTimeZone(dailySolarData[i][1], zone),
						y:eval((dailySolarData[i][2]/1000).toFixed(4))
					});
				}
				var chart = $('#solarDailyViewChart').highcharts();
				solar_daily_data.sort(function(a, b) {
				   return a.x - b.x;
				});
		    		//console.log(solar_daily_data);
	            chart.series[0].setData(solar_daily_data);
	            chart.series[0].color = '#4d90fe';
				// end daily solar data
				
	          //Current solar
				if(response.currentsolar.length > 0){
					var num = eval(response.currentsolar[0][2]/1000);
					var pre = num.toFixed(2);
					$("#currentsolar").html("<span class='lead'>"+pre+"</span><span> kW</span>");
				} else {
					$("#currentsolar").html("<span class='lead'>0.00</span><span> kW</span>");
				}
			}		
		});
	}
	var updateBatteryStatus = function () {
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/home/get_battery_status/"+microgrid_id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {
				if(response.battery_status){
					if(response.battery_status.length > 0){
						var battery_status = response.battery_status;
						var soc = eval(battery_status[0][2]).toFixed(2);
						$("#text-data").html(soc);	
						$("#battery_progress").data('easyPieChart').update(soc);
						$("#battery_progress").data('easyPieChart').update(soc);
						if(battery_status[0][5] == 'charging' || battery_status[0][5] == 'idle') {						
							$("#batteryStateText").html('<span style="color:green;">'+toCamelCase(battery_status[0][5])+'</span>');
						} else {						
							$("#batteryStateText").html('<span style="color:red;">'+toCamelCase(battery_status[0][5])+'</span>');
						}
					} else {
						$("#text-data").html(0);	
						$("#battery_progress").data('easyPieChart').update(0);
						$("#battery_progress").data('easyPieChart').update(0);
					}
					
					
				}else{
					$("#text-data").html(0);	
					$("#battery_progress").data('easyPieChart').update(0);
					$("#battery_progress").data('easyPieChart').update(0);
					
				}
			}
		});
		
	};
	footprint_data();
	updateBatteryStatus();
	energy_usage_weekly();
	setInterval(function(){updateBatteryStatus()}, 1000*30);	
	updateChart();
	setInterval(function(){updateChart()}, 1000*30);	
	daily_solar_data();
	setInterval(function(){daily_solar_data()}, 1000*60);
	update_load_distribution();
	setInterval(function(){update_load_distribution()}, 1000*60);
	energy_usage();
	setInterval(function(){energy_usage()}, 1000*30);
});

//fillData(dataFromDB, newly initializedArray, local date array(past seven days), zone)
function fillData(data, dataArray, localDateArray, zone){
	var dataDateArray = generateDateArray(data, zone);
	localDateArray.forEach(function(date, index){						
		dataArray.push({
				x : date,
				y : dataDateArray.indexOf(date) != -1 ? data[dataDateArray.indexOf(date)][2] : 0
			});					
	});
}


// this method will give you the array of dates that we received from the server. I will set time part to 00:00:00 and converts to server time zone
function generateDateArray(dataArray, zone){
	var dataDateArray = [];
	dataArray.forEach(function(data){
		dataDateArray.push(setDefaultTime(adoptTimeZone(data[1], zone)));
	});
	return dataDateArray;
}
// makes an array of dates having last seven days
function setLocalDateArrayForGreenColumnChart(){
	var zone = arguments[0];
	var localDateArray = [];
	//var todayDate = new Date();		
	var todayDate = new Date(adoptTimeZone(new Date().getTime(), zone));
	for (var i=0 ; i< 7; i++){		
		localDateArray.push(setDefaultTime(todayDate.getTime()));
		todayDate.setDate(todayDate.getDate()-1);
	}
	return localDateArray;
}
// set time part to 00:00:00
function setDefaultTime(dateTime){
	var date = new Date(dateTime);
	date.setHours(0);
	date.setMinutes(0);
	date.setSeconds(0);
	date.setMilliseconds(0);
	return date.getTime();
}
</script>