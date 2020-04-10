 
$.fn.serializeObject = function()
  {
      var o = {};
      var a = this.serializeArray();
      $.each(a, function() {
          if (o[this.name] !== undefined) {
              if (!o[this.name].push) {
                  o[this.name] = [o[this.name]];
              }
              o[this.name].push(this.value || '');
          } else {
              o[this.name] = this.value || '';
          }
      });
      return o;
  };

  function getLatLong(zipcode,callback) {
	    geocoder = new google.maps.Geocoder();
	    geocoder.geocode({
	        'address': zipcode
	    }, function(results, status) {
	        if (status == google.maps.GeocoderStatus.OK) {
	        	if(typeof callback == 'function')
	            {
	        		console.log(results[0].geometry.location);
	        		callback.call(this, results[0].geometry.location);
	            }
	        	
	        } else {
	            alert("Geocode was not successful for the following reason: " + status);
	        }
	    });
	}