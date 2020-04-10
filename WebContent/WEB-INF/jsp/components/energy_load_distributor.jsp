
<div id="energy_load_distributor" style="height: 330px; width: 100%;"></div>
<script>
var option;
 Highcharts.setOptions({
    global : {
        useUTC : false
    }
}); 
$(function () {
	var c_date = new Date();
	 Highcharts.setOptions({
	    global : {
	        useUTC : false
	    }
	});
	
  option = {
     animation: false,
     chart: {
         type: 'spline',
         backgroundColor:'#FFFFFF'        
     },
     title: {
         text: 'Energy Distribution',
         style: {
             fontFamily: 'arial',
             color : 'black',
             fontWeight: 'bold',
             fontSize: '15px',
         }         
     },
     legend: {
         align: 'right',
         verticalAlign: 'top',
         layout: 'vertical',
         itemStyle: {
             fontSize:'14px',
             color : 'black',
             fontFamily: 'arial',            
             fontWeight: 'bold'
         },
         x: -10,
         y: 120
     },
     credits: {
         enabled: false
     },
     exporting: { enabled: false },
     xAxis: {    	 
    	 type:'datetime',
    	  labels: {
             formatter: function () {            	 
                 return Highcharts.dateFormat('%H:%M',this.value);
             }
         },
         
     	/* gridLineWidth:2,
     	gridLineColor:'#ECECEC', */
     	tickInterval: 3600 * 1000,
     	 plotBands: [{
             from: 1485739841000,
             to: 1485743441000,
             color: 'rgba(68, 170, 213, .1)',
             events: {
            	 click: function(e, from, to){
            		 var b = this;
            	 }
             }
          }, {
        	  from: 1485743441000,
              to: 1485747041000,
             color: 'rgba(213, 68, 213, .1)'
          }]
     	
     },
     yAxis: {
         title: {
             text: ''
         },
         gridColor:"#808080"
     },
     tooltip: {
    	  formatter: function() {    		 
             return  '<b>' + this.series.name +'</b><br/>' +
                 Highcharts.dateFormat('%Y-%b-%e %H:%M',this.x)+' <b>'+ this.y+'</b> kWh';
         } 
     },
     plotOptions: {
         area: {
              pointStart: Date.UTC(c_date.getFullYear(),c_date.getMonth(), c_date.getDate()),
             marker: {
                 enabled: false,
                 symbol: 'circle',
                 radius: 2,
                 states: {
                     hover: {
                         enabled: true
                     }
                 }
             }
         }
     },
     series: [{        
    	 name: 'Load',
         color: '#13496d',
         data: []
     },{
         name: 'Grid',
         color: '#4d90fe',
         data: []
     },{
         name: 'Solar',
         color: 'rgb(222,107,22)',
         data: []
     }]     
 };
  $('#energy_load_distributor').highcharts(option);
});
</script>