<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed page-full-width">
	<jsp:include page="../bootstrapheader/top-menu.jsp"></jsp:include>
	<div class="clearfix"></div>
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<div class="portlet customPanel">
							<div class="portlet-title gray customPanel-title" style="margin-bottom:0px;">
								<div class="caption" style="color:white;padding-top: 7px;">
									<i class="fa fa-reorder"></i>Micro Grid Location Map
								</div>
								<div class="tools" style="padding-right:5px;color:white;">
									<img src="http://www.google.com/intl/en_us/mapfiles/ms/micons/green-dot.png">
								    Fully operational
								    <img src="http://www.google.com/intl/en_us/mapfiles/ms/micons/red-dot.png">
								    Non Operational
								    <img src="http://www.google.com/intl/en_us/mapfiles/ms/micons/orange-dot.png">
								    Active but not configured
									<a href="javascript:;" style="padding:5px;" class="reload"> </a>
								</div>
							</div>
							<div class="portlet-body">
								<div id="gmap_marker" class="gmaps" style="height: 520px;">
								</div>
							</div>
							<!-- END PAGE TITLE & BREADCRUMB-->
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- END CONTENT -->
	</div>
	<!-- END CONTAINER -->
	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
	<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
	<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>	
	<script type="text/javascript" src="http://google-maps-utility-library-v3.googlecode.com/svn/trunk/markerclusterer/src/markerclusterer.js"></script>	
	<script>
		$(document).ready(function(){
			var height = $(window).height();
			$('#mapbox').css('height', height - 50);
			$("#gmap_marker").css('height', height - 50);
			$("#gmap_marker").css('width', "100%");
			$(window).resize(function() {
				var height = $(window).height();
				$('#mapbox').css('height', height - 100);
				$("#gmap_marker").css('height', height - 100);
			})
			initMap();
		});
		
		function initMap() {
			var map = new google.maps.Map(document
					.getElementById('gmap_marker'), {
				zoom : 2,
				center : {
					lat : -33,
					lng : 151
				},
			});
			var bounds = new google.maps.LatLngBounds();
			var infowindow = new google.maps.InfoWindow();
			var infowindow = null;

			$.ajax({
				contentType : 'application/json',
				type : "get",
				url : "${pageContext.request.contextPath}/rest/micro/mapdata",
				success : function(response) {
					console.log(response.data);
					var markers = [];
					if (response.data != undefined
							&& response.data != null) {
						for (var i = 0; i < response.data.length; i++) {
							var data = response.data[i];
							var text = "<div class='col-md-12' style='color:black;padding-left:0px;'>";
							if (data['color'] == "orange") {
								text += "<a href='javascript:void(0);' onclick='notActiveError(this)' class='openDashboard' data-id='"
										+ data.microgrid_id
										+ "'><h5>"
										+ data.microgrid_name
										+ "</h5></a></div>";
							} else {
								text += "<a href='javascript:void(0);' onclick='openDashboard(this);' class='openDashboard' data-id='"
										+ data.microgrid_id
										+ "'><h5>"
										+ data.microgrid_name
										+ "</h5></a></div>";
							}
							text += "<div class='row' style='margin:0px;width:230px;'>";
							text += "<div class='col-md-6' style='padding-left:0px;'>";
							if (data['pic_url']) {
								text += "<img src='https://drive.google.com/uc?export=view&id="+data['pic_url']+"' width=80 height=50>";
							} else {
								text += "<img src='${pageContext.request.contextPath}/public/images/noimage.png' width=30 height=20>";
							}
							text += "</div><div class='col-md-6' style='color:black;padding:0px;'>";
							text += "<p>Country : " + data.country
									+ "</p>";
							text += "<p>State : " + data.state + "</p>";
							text += "<p>City : " + data.city + "</p>";
							text += "</div>";
							text += "</div>";
							var icon = "";
							if (data['color'] == "green") {
								icon = "http://www.google.com/intl/en_us/mapfiles/ms/micons/green-dot.png";
							} else if (data['color'] == "red") {
								icon = "http://www.google.com/intl/en_us/mapfiles/ms/micons/red-dot.png";
							} else if (data['color'] == "orange") {
								icon = "http://www.google.com/intl/en_us/mapfiles/ms/micons/orange-dot.png";
							}
							var marker = new google.maps.Marker({
								position : {
									lat : eval(data.latitude),
									lng : eval(data.longitude)
								},
								map : map,
								icon : icon,
								text:text
							});
							map.setCenter(marker.getPosition())
							google.maps.event.addListener(marker, 'click', (function(marker, i) {
							    return function() {
							      var infowindow = new google.maps.InfoWindow({
										content: marker.text
								  });
							      infowindow.open(map, marker);
							    }
							})(marker, i));
							markers.push(marker);
						}
						
						var mcOptions = {
								styles: [{height:53, width: 53, url: "${pageContext.request.contextPath}/public/images/m1.png"},
								         {height:56, width: 56, url: "${pageContext.request.contextPath}/public/images/m2.png"},
								         {height:66, width: 66, url: "${pageContext.request.contextPath}/public/images/m3.png"},
								         {height:78, width: 78, url: "${pageContext.request.contextPath}/public/images/m4.png"},
								         {height:90, width: 90, url: "${pageContext.request.contextPath}/public/images/m5.png"}
								]
						};
						// create a Marker Clusterer that clusters markers
						markerCluster = new MarkerClusterer(map, markers, mcOptions);
					}
				}
			});

		}
		function AutoCenter() {
			//  Create a new viewpoint bound
			var bounds = new google.maps.LatLngBounds();
			//  Go through each...
			$.each(markers, function(index, marker) {
				bounds.extend(marker.position);
			});
			//  Fit these bounds to the map
			map.fitBounds(bounds);
		}
		function openDashboard(identifier) {
			var id = $(identifier).data('id');
			$.cookie("microgrid_id", id, {
				path : '/'
			});
			window.location.href = "${pageContext.request.contextPath}/rest/home/currentstatus/"
					+ id;
		}
		function notActiveError(identifier) {
			toastr.error("Microgrid controller is active but not configured");
		}
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>