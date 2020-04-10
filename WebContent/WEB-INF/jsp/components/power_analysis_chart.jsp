<div id="power_analysis_chart" style="min-width: 310px; height: 350px; margin: 0 auto"></div>
<script type="text/javascript">
var monthNames = ["January", "February", "March", "April", "May", "June",
                  "July", "August", "September", "October", "November", "December"
                ];
function set_chart(){
	var url = "";
	var search_filter = $("#search_filter").val();
	if(search_filter=="week"){
		var startDate = $("#startDate").val();
		var endDate = $("#endDate").val();
		url = "${pageContext.request.contextPath}/rest/solar/get_ana_data?search_filter=week&start_date='"+startDate+"'&end_date='"+endDate+"'";
		var format = "%b %e";
		drawSolarPoweAnalysisChart(url, search_filter);
	}else if(search_filter=="month"){
		var month = $("#month").val();
		var year = $('#year').val();
		url = "${pageContext.request.contextPath}/rest/solar/get_ana_data?search_filter=month&month="+month+"&year="+year;
		var format = "%b %e";
		drawSolarPoweAnalysisChart(url, search_filter);
	}else if(search_filter=="year"){
		var year = $("#year").val();
		url = "${pageContext.request.contextPath}/rest/solar/get_ana_data?search_filter=year&year="+year;
		var format = "%b";
		drawSolarPoweAnalysisChart(url,search_filter);
	}
	//console.log(url);
}

function drawSolarPoweAnalysisChart(url, search_filter){
	var milsec = 24 * 3600 * 1000;
	if(search_filter == 'year'){
		milsec = 30 * 24 * 3600 * 1000;
	}
	option = {
			chart: {
				type: 'line'
			},
			title: {
				text: 'Generation and prediction analysis'
			},
			credits: {
				enabled: false
			},
			exporting: {
				enabled: false
			},
			xAxis:{
				type: 'datetime',
				tickInterval: milsec,
				labels:{
	            	formatter: function() {
	            		if(search_filter == 'year'){
	            			return Highcharts.dateFormat('%b', this.value);
	            		}else{
	            			return Highcharts.dateFormat('%e. %b', this.value);	
	            		}	                     
	                } 
	            } 
			},
			yAxis: {
				min: 0,
				title: {
					text: 'Power (kwh)'
				}
			},
			tooltip: {
				shadow: true,
				formatter: function(){
					if(search_filter == 'year'){
						return '<b>'+Highcharts.dateFormat("%b %Y", new Date(this.x))+"</b><br/>"+this.series.name+': <b>'+this.y+' kwh</b>';
					}
					return '<b>'+Highcharts.dateFormat("%d %b %Y", new Date(this.x))+"</b><br/>"+this.series.name+': <b>'+this.y+' kwh</b>';
				}
			},
			series: []
	};	
	
	$.getJSON(url, function(data){
		var generated = {name: 'Generated', data:[]};
		var estimated = {name: 'Estimated', data:[]};
		
		var gen_length = data.data.length;
		var est_length = data.service.length;
		
		if(gen_length > 0){
			if(est_length >0){
				var gf_start = data.data[0][1];
				var ef_start = data.service[0][1];
				var gf_end = data.data[data.data.length-1][1];
				var ef_end = data.service[data.service.length-1][1];
				if(gf_start<ef_start){
					var i = 0;
					while(data.data[i][1] < ef_start){
						estimated.data.push([data.data[i][1],0]);
						i++;
					}					
				}else{
					if(gf_start > ef_start){
						var i = 0;
						while(data.service[i][1] < gf_start ){
							generated.data.push([data.service[i][1], 0]);
							i++;
						}
					}
				}
			}
		}	
		
		if(data.data.length>0){			
		for(var i = 0; i< data.data.length ; i++){					
			generated.data.push([data.data[i][1],((data.data[i][2])/1000)]);			
			/* generated.data.push(((data.data[i][2])/1000));
			option.xAxis.categories.push(data.data[i][1]); */
		}		
		}
		if(data.service.length>0){
			for(var i=0; i< data.service.length; i++){
				estimated.data.push([data.service[i][1], (data.service[i][2]/1000)]);
				/* estimated.data.push((data.service[i][2]/1000));
				option.xAxis.categories.push(data.service[i][1]); */
			}	
		}else{
			if(data.data.length>0){
				for(var i = 0; i< data.data.length ; i++){
					//estimated.data.push(0);								
				}							
			}
		}
		
		
		
		if(gen_length > 0){
			if(est_length >0){
				var gf_start = data.data[0][1];
				var ef_start = data.service[0][1];
				var gf_end = data.data[data.data.length-1][1];
				var ef_end = data.service[data.service.length-1][1];
				if(gf_end > ef_end){
					estimated.data.push([gf_end,0]);
				}else{
					if(gf_end < ef_end){
						generated.data.push([ef_end, 0]);
					}
				}
			}else{
				for(var i =0 ; i< data.data.length; i++){
					estimated.data.push([data.data[i][1], 0]);
				}
			}
		}else{
			if(est_length >0){
				for(var i = 0 ; i < data.service.length; i++){
					generated.data.push([data.service[i][1], 0 ]);
				}
			}
		}
		
		/* var gf_start = data.data[0][1];
		var gf_end = data.data[data.data.length-1][1];
		console.log(gf_start);
		console.log(gf_end); */
		
		option.series.push(generated);
		option.series.push(estimated);
		$('#power_analysis_chart').highcharts(option);
	});
}



//$('#power_analysis_chart').highcharts(option);
</script>