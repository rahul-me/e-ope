<input id="current_voltage" class="knob current_soh" data-max=100 data-fgColor="#4D8FFD" data-angleoffset=-125 data-anglearc=250  data-width="160" data-height="160">
<script>
	$('.current_voltage_output').data('targetValue', 0);
	$(".current_soh").data('targetValue', 0);
	//basic setup
	$('.knob').knob({
		value : 0,
		'readOnly' : true,
		'width' : 160,
		'height' : 160,
		'dynamicDraw' : true,
		'thickness' : 0.2,
		'tickColorizeValues' : true,
		'skin' : 'tron'		
	});
	$.when($('.knob').each(function() {
		$(this).animate({
			value : parseInt($(this).data('targetValue'))
		}, {
			duration : 1000,
			easing : 'swing',
			progress : function() {
				$(this).val(Math.round(this.value)).trigger('change')
			}
		});
	})).then(function() {
		getCurrentVoltage();
	});

	function getCurrentVoltage() {		
		//$('.h').val(h).trigger("change");
		var microgrid_id = getMicroGridIdFromUrl();
		$.ajax({
			url : "${pageContext.request.contextPath}/rest/battery/getlatestbatteryvoltage/"+microgrid_id,
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			success : function(response, textStatus, jqXHR) {				
				var current_voltage = response.current_voltage;
				if(current_voltage!=null && current_voltage!=undefined){
					//console.log(current_voltage);
					$('.current_voltage_output').val(current_voltage.voltage_v).trigger("change");	
					var current_soh = current_voltage.stateOfHelth;
					$('.current_soh').val(current_soh).trigger("change");
					//console.log(current_voltage);	
				}				
			}
		});	
		setTimeout(getCurrentVoltage, 1000*50);
	}
	
</script>
<style>
input[readonly], select[readonly], textarea[readonly] {
    cursor: not-allowed;
    background-color: white !important;
}
</style>