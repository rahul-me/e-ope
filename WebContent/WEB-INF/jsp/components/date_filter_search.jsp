<select id="search_filter" class="pull-right" style="padding: 2px;">
	<option value="week">Week</option>
	<option value="month">Month</option>
	<option value="year">Year</option>
</select>
<input type="hidden" id="startDate">
<input type="hidden" id="endDate">
<input type="hidden" id="month">
<input type="hidden" id="year">
<script>
	var monthNames = ["January", "February", "March", "April", "May", "June",
                  "July", "August", "September", "October", "November", "December"
                ];
	$(document).ready(function(){
		Date.prototype.getWeek = function() {
	        var onejan = new Date(this.getFullYear(), 0, 1);
	        return Math.ceil((((this - onejan) / 86400000) + onejan.getDay() + 1) / 7);
	    }
		//$("#search_filter").change();		
	});
	function zeroFillMonth(month){
		if(month<=9){
			return "0"+month;
		}else{
			return month;
		}
	}
	function zeroFillDate(date){
		if(date<=9){
			return "0"+date;
		}else{
			return date;
		}
	}
	$("#search_filter").change(function(){
		var search_filter = $(this).val();
		var curr = new Date;
		if(search_filter=="week"){
			var week = (new Date()).getWeek();			
			var firstday = new Date();
			firstday.setDate(firstday.getDate()-6);
			var lastday = new Date();
			var f_date = firstday.getFullYear()+"-"+zeroFillMonth((firstday.getMonth()+1))+"-"+zeroFillDate(firstday.getDate());
			var l_date = lastday.getFullYear()+"-"+zeroFillMonth((lastday.getMonth()+1))+"-"+zeroFillDate(lastday.getDate());		
			$("#startDate").val(f_date);
			$("#endDate").val(l_date);
			var weekData =  "<p><h4><i onclick='weekPre(this);' data-value='"+f_date+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-left'></i> From "+f_date;
			weekData += " to "+l_date+"<i onclick='weekNext(this);' data-value='"+l_date+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-right'></i></h4></p>";
			$("#week_data").html(weekData);	
		}else if(search_filter=="month"){
			var f_date = monthNames[curr.getMonth()]+" , "+curr.getFullYear();
			$("#month").val(curr.getMonth()+1);
			$("#year").val(curr.getFullYear());
			var weekData =  "<p><h4><i onclick='monthPre(this);' style='cursor:pointer;color:#B3B3B3;' data-value='"+(curr.getMonth()+1)+"-"+curr.getFullYear()+"' class='glyphicon glyphicon-chevron-left'></i> "+f_date;
			weekData += " <i onclick='monthNext(this);' style='cursor:pointer;color:#B3B3B3;' data-value='"+(curr.getMonth()+1)+"-"+curr.getFullYear()+"' class='glyphicon glyphicon-chevron-right'></i></h4></p>";
			$("#week_data").html(weekData);	
		}else if(search_filter=="year"){
			var dt = new Date();
			var year = dt.getFullYear();
			$("#year").val(year);
			var weekData =  "<p><h4><i onclick='yearPre(this);' data-value='"+year+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-left'></i><span> "+year;
			weekData += " </span><i onclick='yearNext(this);' data-value='"+year+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-right'></i></h4></p>";
			$("#week_data").html(weekData);	
		}
		set_chart();
	});
	function monthNext(e){		
		var val = $(e).attr("data-value");				
		var my = val.split("-");		
		var curr = new Date();
		var date = new Date(my[1],my[0],1);
		if(date.getFullYear()<=curr.getFullYear()){
			if(date.getFullYear()==curr.getFullYear() && date.getMonth()<=curr.getMonth()){
				var f_date = monthNames[date.getMonth()]+" , "+date.getFullYear();
				$("#month").val(date.getMonth()+1);
				$("#year").val(date.getFullYear());
				var weekData =  "<p><h4><i onclick='monthPre(this);' style='cursor:pointer;color:#B3B3B3;' data-value='"+(date.getMonth()+1)+"-"+date.getFullYear()+"' class='glyphicon glyphicon-chevron-left'></i> "+f_date;
				weekData += " <i onclick='monthNext(this);' data-value='"+(date.getMonth()+1)+"-"+date.getFullYear()+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-right'></i></h4></p>";
				$("#week_data").html(weekData);
				set_chart();
			}else if(date.getFullYear()<curr.getFullYear()){
				var f_date = monthNames[date.getMonth()]+" , "+date.getFullYear();
				$("#month").val(date.getMonth()+1);
				$("#year").val(date.getFullYear());
				var weekData =  "<p><h4><i onclick='monthPre(this);' style='cursor:pointer;color:#B3B3B3;' data-value='"+(date.getMonth()+1)+"-"+date.getFullYear()+"' class='glyphicon glyphicon-chevron-left'></i> "+f_date;
				weekData += " <i onclick='monthNext(this);' data-value='"+(date.getMonth()+1)+"-"+date.getFullYear()+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-right'></i></h4></p>";
				$("#week_data").html(weekData);
				set_chart();
			}
		}			
	}
	function monthPre(e){
		var val = $(e).attr("data-value");
		var my = val.split("-");
		var date = new Date(my[1],my[0]-2,1);
		var f_date = monthNames[date.getMonth()]+" , "+date.getFullYear();
		$("#month").val(date.getMonth()+1);
		$("#year").val(date.getFullYear());
		var weekData =  "<p><h4><i onclick='monthPre(this);' style='cursor:pointer;color:#B3B3B3;' data-value='"+(date.getMonth()+1)+"-"+date.getFullYear()+"' class='glyphicon glyphicon-chevron-left'></i> "+f_date;
		weekData += " <i onclick='monthNext(this);' data-value='"+(date.getMonth()+1)+"-"+date.getFullYear()+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-right'></i></h4></p>";
		$("#week_data").html(weekData);	
		set_chart();
	}
	function weekNext(e){
		var ldate = $(e).attr("data-value");
		var ldate = ldate.split("-");	    	
		var firstday = new Date(ldate[0],ldate[1]-1,ldate[2]);
		firstday.setDate(firstday.getDate()+1);		
		var lastday = new Date(firstday.getFullYear(),firstday.getMonth(),firstday.getDate());
		lastday.setDate(lastday.getDate()+6);
		var curr = new Date();
		if(lastday<=curr){
			var f_date = firstday.getFullYear()+"-"+zeroFillMonth((firstday.getMonth()+1))+"-"+zeroFillDate(firstday.getDate());		
			var l_date = lastday.getFullYear()+"-"+zeroFillMonth((lastday.getMonth()+1))+"-"+zeroFillDate(lastday.getDate());
			$("#startDate").val(f_date);
			$("#endDate").val(l_date);
			var weekData =  "<p><h4><i onclick='weekPre(this);' data-value='"+f_date+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-left'></i> From "+f_date;
			weekData += " to "+l_date+"<i onclick='weekNext(this);' data-value='"+l_date+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-right'></i></h4></p>";
			$("#week_data").html(weekData);	
			set_chart();
		}
	}
	function weekPre(e){
		var fdate = $(e).attr("data-value");
		var fdate = fdate.split("-");	    	
		var firstday = new Date(fdate[0],fdate[1]-1,fdate[2]);	
		var lastday = new Date(firstday.getFullYear(),firstday.getMonth(),firstday.getDate()-1);
		firstday.setDate(firstday.getDate()-7);
		var f_date = firstday.getFullYear()+"-"+zeroFillMonth(firstday.getMonth()+1)+"-"+zeroFillDate(firstday.getDate());
		var l_date = lastday.getFullYear()+"-"+zeroFillMonth(lastday.getMonth()+1)+"-"+zeroFillDate(lastday.getDate());
		$("#startDate").val(f_date);
		$("#endDate").val(l_date);
		var weekData =  "<p><h4><i onclick='weekPre(this);' data-value='"+f_date+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-left'></i> From "+f_date;
		weekData += " to "+l_date+"<i onclick='weekNext(this);' data-value='"+l_date+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-right'></i></h4></p>";
		$("#week_data").html(weekData);	 
		set_chart();
	}
	function yearNext(e){
		var year = $(e).attr("data-value");
		var year = eval(year) + 1;
		var date = new Date();
		var curr_year = date.getFullYear();
		if(year<=curr_year){
			$("#year").val(year);
			var weekData =  "<p><h4><i onclick='yearPre(this);' data-value='"+year+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-left'></i> "+year;
			weekData += " <i onclick='yearNext(this);' data-value='"+year+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-right'></i></h4></p>";
			$("#week_data").html(weekData);
			set_chart();
		}
	}
	function yearPre(e){
		var year = $(e).attr("data-value");
		var year = year - 1;
		$("#year").val(year);
		var weekData =  "<p><h4><i onclick='yearPre(this);' data-value='"+year+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-left'></i> "+year;
		weekData += " <i onclick='yearNext(this);' data-value='"+year+"' style='cursor:pointer;color:#B3B3B3;' class='glyphicon glyphicon-chevron-right'></i></h4></p>";
		$("#week_data").html(weekData);	
		set_chart();
	}
</script>