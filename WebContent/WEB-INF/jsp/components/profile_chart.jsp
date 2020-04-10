<div id="profile_chart"
	style="min-width: 310px; height: 435px; margin: 0 auto;"></div>
<script>

	var current;
	
	var events = new Object();
	events.click = function() {
		clickEvent(this);
	};
	events.mouseover = function() {
		mouseOver(this);
	};
	events.mouseout = function() {
		mouseOut(this);
	};
	
	function mouseOut(object) {
		if (current != null && current != undefined && current.id != undefined) {
			if (current.options.from == object.options.from) {
				return;
			}
		}
		 /* object.svgElem.attr({
			fill : '#FCFFC5'
		});  */
		 
		//Dynamic
			var color = object.options.color;
			//console.log(color);
			//if(object.options.color == '#FFF633'){
				object.svgElem.attr({
					fill : color
				});
			//}
			/* if(object.options.color == '#A5FF33'){
				object.svgElem.attr({
					fill : color
				});
			}
			if(object.options.color == '#FF9933'){
				object.svgElem.attr({
					fill : color
				});
			}  */
	}

	function clickEvent(object) {
		  if (current != null && current != undefined  && current.id != undefined) {
			if (current.options.from == object.options.from) {
				/* current.svgElem.attr({
					fill : '#FCFFC5'
				}); */
				var color = current.options.color;
				//if(current.options.color == '#FFF633'){
					current.svgElem.attr({
						fill : color
					});
				//}
				/* if(current.options.color == '#A5FF33'){
					current.svgElem.attr({
						fill : '#C7FF33'
					});
				}
				if(current.options.color == '#FF9933'){
					current.svgElem.attr({
						fill : '#FFC733'
					});
				}  */
				current = null;
				hideDetails();
				return;
			} else {
				var color = current.options.color;
				//if(current.options.color == '#FFF633'){
					current.svgElem.attr({
						fill : color
					});
				//}
				/* if(current.options.color == '#F3FF33'){
					current.svgElem.attr({
						fill : '#FFF633'
					});
				}
				if(current.options.color == '#C7FF33'){
					current.svgElem.attr({
						fill : '#A5FF33'
					});
				}
				if(current.options.color == '#FFC733'){
					current.svgElem.attr({
						fill : '#FF9933'
					});
				} */
			}
		}
		current = object;
		if(object.options.color == '#F3FF33'){
			object.svgElem.attr({
				fill : '#FFF633'
			});
		}
		if(object.options.color == '#C7FF33'){
			object.svgElem.attr({
				fill : '#A5FF33'
			});
		}
		if(object.options.color == '#FFC733'){
			object.svgElem.attr({
				fill : '#FF9933'
			});
		} 
		showDetails(object.id);
	}

	 function mouseOver(object) {
		//console.log(current); 
		if (current != null && current != undefined  && current.id != undefined) {
			if (current.options.from == object.options.from) {
				return;
			}
		}
		object.svgElem.attr({
			fill : '#FCFFC5'
		});
		
		
		//Dynamic
		
		if(object.options.color == '#de6b16'){
			object.svgElem.attr({
				fill : '#FC7A1A'
			});
		}
		if(object.options.color == '#4cae4c'){
			object.svgElem.attr({
				fill : '#6CF56C'
			});
		}
		if(object.options.color == '#808080'){
			object.svgElem.attr({
				fill : '#AEADAD'
			});
		}

	} 

	$(function() {
		getData();
	});
	
	function getData() {
		$.ajax({	url : "${pageContext.request.contextPath}/rest/micro/getprofile/${profile}/${id}",
					type : "GET",
					contentType : "application/json",
					dataType : "json",
					success : function(response) {
						//console.log(response.status);
						if (response.status == 'successful') {
							//console.log(response.availability);
							if (response.availability == 'available') {
								//console.log(response.data);
								loadData(response);
							}
						}
					}
				});
	}

	function loadData(response) {
		
		//console.log('loadData');
		//console.log(response.status);
		var slot = eval(24 / eval(response.data.length));
		var date = new Date();
		var month = date.getMonth();
		var year = date.getFullYear();
		var day = date.getDate();
		
		var plotBands = [];

		

		for (var i = 0; i < response.data.length; i++) {
			//console.log(response.data);
			//console.log(current);
			var plotBand = new Object();
			var type = response.data[i].standard_situation;
			if(type == null || type == ''){			
					plotBand.color = '#FCFFC5'
			} else if(type.toUpperCase() == 'SOLAR'){				
					plotBand.color = '#de6b16';										
			} else if(type.toUpperCase() == 'BATTERY'){				
					plotBand.color = '#4cae4c';												
			} else if(type.toUpperCase() == 'GRID'){				
					plotBand.color = '#808080';												
			}			
			plotBand.from = Date.UTC(eval(year),eval(month),eval(day),eval(i*slot),0,0);
			plotBand.to=Date.UTC(eval(year),eval(month),eval(day),eval((i*slot)+slot),0,0);
			plotBand.events = events;
			plotBand.id = response.data[i].id;
			
			plotBands.push(plotBand);
		}
		
		var options = {
				chart: {
					type: 'spline'
				},
				credits: {
					enabled: false
				},
				exporting: {
					enabled: false
				},
				tooltip: {
					enabled: false	
				},
				yAxis: {
					gridLineWidth: 0,
					title: {
						text: ''
					},
					min: 5
				},
				title: {
					text: '',
					style: {
			             fontFamily: 'arial',
			             color : 'black',
			             fontWeight: 'bold',
			             fontSize: '15px',
			         }
				},
				plotOptions: {
			        series: {
			            states: {
			                hover: {
			                    enabled: false
			                }
			            },
			            color : '#000000'
			        }
			    },
			    xAxis: {
			    	plotBands: plotBands,
				    min: Date.UTC(eval(year), eval(month), eval(day),0,0,0),
				    max: Date.UTC(eval(year), eval(month), eval(day),23,59,59),
				    type: 'datetime',
				    labels: {
				    	formatter: function() {
				    		return Highcharts.dateFormat('%H:%M:%S',this.value);
				    	}
				    },
				    minTickInterval: 3600 * 1000 * eval(slot)
			    },
			    series: [{			    
			    	showInLegend: false,
			    	pointStart: Date.UTC(eval(year), eval(month), eval(day),0,0,0),
			    	name: 'Series',
			    	data: []
			    }]			 
		};
		
		var chartdata = [];
		var minDate = Date.UTC(eval(year), eval(month), eval(day),0,0,0);
		var midDate = Date.UTC(eval(year), eval(month), eval(day),12,00,00);
		var maxDate = Date.UTC(eval(year), eval(month), eval(day),23,59,59);
		var a = 5;
		var t = 0;
		while(minDate < midDate){
//			chartdata.push([minDate, eval((a * Math.pow(t,2))/10)]);
			chartdata.push([minDate, Math.pow(2,t)]);
			t+= 0.50;
			var date = new Date(minDate);
			date.setHours(date.getHours() + 1);
			//console.log(date);
			minDate = date.getTime();
		}
		t = 90;
		while(midDate <= maxDate) {
			chartdata.push([midDate, eval(40 * Math.sin(t))]);
			t += 0.10;
			var date = new Date(midDate);
			date.setHours(date.getHours() + 1);
			//console.log(date);
			midDate = date.getTime();
		}
		
		options.series[0].data = chartdata;
		
		
		
		$('#profile_chart').highcharts(options);

	}
	
	/* Chart Redraw  */
	
	$('.sidebar-toggler').on('click', function(){
		getData();
	});
	
</script>