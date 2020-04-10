/*******************************************************************************
 * Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
 * --------------------------
 * [2015] - [2020] Gridscape Solutions, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Gridscape Solutions, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to Gridscape Solutions, Inc.
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Gridscape Solutions.
 *******************************************************************************/
$(document).ready(function(){
	var site_url = $('#site_url').html();
	var microgrid_id = $.cookie("microgrid_id");
	var url = window.location.href;
	url = url.split("/");
	var id = url[url.length-1];
	var site_url = $("#site_url").html();
	
	/*if(microgrid_id!=id){
		toastr.info("Invalid Microgrid Id.!");
		window.setTimeout(function(){
			window.location.href = site_url+"/rest/micro/list";
	    }, 3000);	
	}*/
	checkvalid(id, site_url);
});

function checkvalid(id, site_url){
	$.ajax({
		url: site_url+'/rest/micro/checkvalidmid/'+id,
		type: 'GET',
		success: function(response){			
			if(response == false){
				toastr.info("Invalid Microgrid Id.!");
				window.setTimeout(function(){
					window.location.href = site_url+"/rest/micro/list";
			    }, 3000);
			}
		}
	});
}



