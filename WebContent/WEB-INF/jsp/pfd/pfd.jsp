<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>

<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
	<div class="clearfix"></div>
	<!-- BEGIN CONTAINER -->
	<div class="page-container">
		<jsp:include page="../bootstrapheader/leftmenu.jsp"></jsp:include>
		<!-- BEGIN CONTENT -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
				<div class="modal fade" id="portlet-config" tabindex="-1"
					role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true"></button>
								<h4 class="modal-title">Modal title</h4>
							</div>
							<div class="modal-body">Widget settings form goes here</div>
							<div class="modal-footer">
								<button type="button" class="btn blue">Save changes</button>
								<button type="button" class="btn default" data-dismiss="modal">Close</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<input type="hidden" id="m_id" value="${m_id}" />
				<!-- /.modal -->
				<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

				<!-- BEGIN PAGE HEADER-->
				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							PFD <small></small>
						</h3>
						<ul class="page-breadcrumb breadcrumb">
							<li><i class="fa fa-home"></i> <a href="index.html">
									Home </a> <i class="fa fa-angle-right"></i></li>
							<li><a
								href="${pageContext.request.contextPath}/rest/sep/devices/index">
									Process Flow Diagram </a></li>
							<li class="pull-right">
							<li class="btn-group"></li>
							</li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->
				<!-- BEGIN DASHBOARD STATS -->

				<!-- END DASHBOARD STATS -->
				<div class="clearfix"></div>
				<div class="portlet box grey">
					<div class="portlet-title">
						<div class="caption"></div>
						<div class="tools">
							<a href="" class="collapse"></a>
						</div>
					</div>
					<div class="portlet-body">
						<!-- <div style="height:10px;clear:both;"></div>	 -->
						<div
							style="width: 100%; height: 570px; background-color: #fff; position: relative"
							id="myDiagramDiv"></div>
						<div id="myholder"></div>
					</div>
				</div>
				<div class="clearfix"></div>

			</div>
		</div>
		<!-- END CONTENT -->
	</div>
	<!-- END CONTAINER -->


	<!-- 	add device modal -->
	<div id="responsive" class="modal fade" tabindex="-1"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-body">
					<form class="form-horizontal" id="addDevice">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">Device</h4>
						</div>
						<div style="height: 15px; clear: both;"></div>
						<input type="hidden" id="id" name="id">
						<!--  <div class="form-group">
							<label for="inputsfId" class="control-label col-xs-3">SFDI
								<label style="color: red;">*</label>
							</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="sfdi"
									placeholder="SFDI">
							</div>
						</div>-->
						<!-- <div class="form-group">
							<label for="inputuserid" class="col-lg-4 control-label">User ID</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="userid"
									placeholder="User ID">
							</div>
						</div> -->
						<div class="form-group">
							<label for="inputsfdi" class="col-lg-4 control-label">SFDI</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="sfdi"
									placeholder="SFDI">
							</div>
						</div>
						<div class="form-group">
							<label for="inputsfdi" class="col-lg-4 control-label">PIN</label>
							<div class="col-lg-8">
								<input type="number" class="form-control" id="pin"
									placeholder="pin">
							</div>
						</div>

						<div class="form-group">
							<label for="inputdevicecat" class="col-lg-4 control-label">Device
								Category Type</label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="devicecattype"
									placeholder="Device Category Type">
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" data-dismiss="modal" class="btn default">Close</button>
							<button type="submit" id="saveDevice" class="btn green">Save
								changes</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- end device modal -->



	<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
	<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
	<script>
		var linkDataCollectionArray = [];
		var $$ = go.GraphObject.make;
		var myDiagram = $$(go.Diagram, "myDiagramDiv", {
			"grid.visible" : false,
			"grid.gridCellSize" : new go.Size(30, 20),
			"draggingTool.isGridSnapEnabled" : true,
			"resizingTool.isGridSnapEnabled" : true,
			"rotatingTool.snapAngleMultiple" : 90,
			"rotatingTool.snapAngleEpsilon" : 45,
			"undoManager.isEnabled" : true
		});

		jQuery(document).ready(function() {
			App.init();
			loadDiagram();
			//loadjointJSDiagram();
		});

		function loadDiagram() {
			/**
			First
			*/
			myDiagram.nodeTemplateMap.add("Image", $$(go.Node, "Auto", {
				locationSpot : new go.Spot(0.5, 0.5, 1, 1),
				locationObjectName : "SHAPE",
				resizable : true,
				resizeObjectName : "SHAPE"
			}, new go.Binding("location", "pos", go.Point.parse)
					.makeTwoWay(go.Point.stringify),

			$$(go.Picture, {
				margin : 10,
				height : 100,
				width : 100,
				background : "red"
			}, new go.Binding("source").makeTwoWay()),

			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "fromPort", // now the Shape is the port, not the whole Node
				fromSpot : go.Spot.Right , // port properties go on the port!
				/* toSpot : go.Spot.Left */
				alignment: go.Spot.Top
			}),
			
			
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "toPort", // now the Shape is the port, not the whole Node
				/* fromSpot : go.Spot.Right , */ // port properties go on the port!
				toSpot : go.Spot.Left,
				alignment: go.Spot.Bottom
			}),

			

			$$(go.TextBlock, {
				alignment : go.Spot.Center,
				textAlign : "center",
				margin : 5,
				editable : true
			}, new go.Binding("text").makeTwoWay(), new go.Binding("angle",
					"angle", function(a) {
						return a === 180 ? 180 : 0;
					}).ofObject())));
			
			//
			//
			//
			//
			//
			//
			myDiagram.nodeTemplateMap.add("inverter", $$(go.Node, "Auto", {
				locationSpot : new go.Spot(0.5, 0.5, 1, 1),
				locationObjectName : "SHAPE",
				resizable : true,
				resizeObjectName : "SHAPE"
			}, new go.Binding("location", "pos", go.Point.parse)
					.makeTwoWay(go.Point.stringify),

			$$(go.Picture, {
				margin : 10,
				height : 100,
				width : 100,
				background : "red"
			}, new go.Binding("source").makeTwoWay()),

			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "batteryin", // now the Shape is the port, not the whole Node
				//fromSpot : go.Spot.Right , // port properties go on the port!
			    toSpot : go.Spot.Left,
				alignment: go.Spot.TopLeft
			}),
			
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "batteryout", // now the Shape is the port, not the whole Node
				fromSpot : go.Spot.Left , // port properties go on the port!
				//toSpot : go.Spot.Left,
				alignment: go.Spot.BottomLeft
			}),
			
			
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "solarin", // now the Shape is the port, not the whole Node
				/* fromSpot : go.Spot.Right , */ // port properties go on the port!
				toSpot : go.Spot.Top,
				alignment: go.Spot.TopCenter
			}),
			
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "gridin", // now the Shape is the port, not the whole Node
				/* fromSpot : go.Spot.Right , */ // port properties go on the port!
				toSpot : go.Spot.Right,
				alignment: go.Spot.RightCenter
			}),
			
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "gridout", // now the Shape is the port, not the whole Node
				/* fromSpot : go.Spot.Right , */ // port properties go on the port!
				fromSpot : go.Spot.Right,
				alignment: go.Spot.TopRight
			}),
						
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "loadout", // now the Shape is the port, not the whole Node
				fromSpot : go.Spot.Bottom , // port properties go on the port!
				//toSpot : go.Spot.Left,
				alignment: go.Spot.BottomCenter
			}),

			

			$$(go.TextBlock, {
				alignment : go.Spot.Center,
				textAlign : "center",
				margin : 5,
				editable : true
			}, new go.Binding("text").makeTwoWay(), new go.Binding("angle",
					"angle", function(a) {
						return a === 180 ? 180 : 0;
					}).ofObject())));
			
			/**
			* Node template for solar. Need only solar out
			*/
			myDiagram.nodeTemplateMap.add("solar", $$(go.Node, "Auto", {
				locationSpot : new go.Spot(0.5, 0.5, 1, 1),
				locationObjectName : "SHAPE",
				resizable : true,
				resizeObjectName : "SHAPE"
			}, new go.Binding("location", "pos", go.Point.parse)
					.makeTwoWay(go.Point.stringify),

			$$(go.Picture, {
				margin : 10,
				height : 100,
				width : 100,
				background : "red"
			}, new go.Binding("source").makeTwoWay()),
			
			//$$(go.Shape, {height: 10, width : 24, fill: red}, new go.Binding("source")),
			
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "solarout", // now the Shape is the port, not the whole Node
				fromSpot : go.Spot.Bottom , // port properties go on the port!
				//toSpot : go.Spot.Left,
				alignment: go.Spot.BottomCenter
			}),
			$$(go.TextBlock, {
				alignment : go.Spot.Center,
				textAlign : "center",
				margin : 5,
				editable : true
			}, new go.Binding("text").makeTwoWay(), new go.Binding("angle",
					"angle", function(a) {
						return a === 180 ? 180 : 0;
					}).ofObject())));
			
			/**
			* Node template for battery. Need only battery in,out
			*/
			myDiagram.nodeTemplateMap.add("battery", $$(go.Node, "Auto", {
				locationSpot : new go.Spot(0.5, 0.5, 1, 1),
				locationObjectName : "SHAPE",
				resizable : true,
				resizeObjectName : "SHAPE"
			}, new go.Binding("location", "pos", go.Point.parse)
					.makeTwoWay(go.Point.stringify),

			$$(go.Picture, {
				margin : 10,
				height : 100,
				width : 100,
				background : "red"
			}, new go.Binding("source").makeTwoWay()),
			
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "batteryout", // now the Shape is the port, not the whole Node
				fromSpot : go.Spot.Right , // port properties go on the port!
				//toSpot : go.Spot.Left,
				alignment: go.Spot.TopRight
			}),
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "batteryin", // now the Shape is the port, not the whole Node
				toSpot : go.Spot.Right , // port properties go on the port!
				//toSpot : go.Spot.Left,
				alignment: go.Spot.BottomRight
			}),
			
			$$(go.TextBlock, {
				alignment : go.Spot.Center,
				textAlign : "center",
				margin : 5,
				editable : true
			}, new go.Binding("text").makeTwoWay(), new go.Binding("angle",
					"angle", function(a) {
						return a === 180 ? 180 : 0;
					}).ofObject())));
			
			/**
			* Node template for load. Need only load in
			*/
			myDiagram.nodeTemplateMap.add("load", $$(go.Node, "Auto", {
				locationSpot : new go.Spot(0.5, 0.5, 1, 1),
				locationObjectName : "SHAPE",
				resizable : true,
				resizeObjectName : "SHAPE"
			}, new go.Binding("location", "pos", go.Point.parse)
					.makeTwoWay(go.Point.stringify),

			$$(go.Picture, {
				margin : 10,
				height : 100,
				width : 100,
				background : "red"
			}, new go.Binding("source").makeTwoWay()),
			
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "loadin", // now the Shape is the port, not the whole Node
				toSpot : go.Spot.Top , // port properties go on the port!
				//toSpot : go.Spot.Left,
				alignment: go.Spot.TopCenter
			}),			
			
			$$(go.TextBlock, {
				alignment : go.Spot.Center,
				textAlign : "center",
				margin : 5,
				editable : true
			}, new go.Binding("text").makeTwoWay(), new go.Binding("angle",
					"angle", function(a) {
						return a === 180 ? 180 : 0;
					}).ofObject())));
			
			
			
			/**
			* Node template for battery. Need only battery in,out
			*/
			myDiagram.nodeTemplateMap.add("grid", $$(go.Node, "Auto", {
				locationSpot : new go.Spot(0.5, 0.5, 1, 1),
				locationObjectName : "SHAPE",
				resizable : true,
				resizeObjectName : "SHAPE"
			}, new go.Binding("location", "pos", go.Point.parse)
					.makeTwoWay(go.Point.stringify),

			$$(go.Picture, {
				margin : 10,
				height : 100,
				width : 100,
				background : "red"
			}, new go.Binding("source").makeTwoWay()),
			
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "gridin", // now the Shape is the port, not the whole Node
				toSpot : go.Spot.Left , // port properties go on the port!
				//toSpot : go.Spot.Left,
				alignment: go.Spot.TopLeft
			}),
			$$(go.Shape, "Ellipse", {
				width : 5,
				height : 5,
				margin: 2,
				fill : "black",
				portId : "gridout", // now the Shape is the port, not the whole Node
				fromSpot : go.Spot.Left , // port properties go on the port!
				//toSpot : go.Spot.Left,
				alignment: go.Spot.LeftCenter
			}),
			
			$$(go.TextBlock, {
				alignment : go.Spot.Center,
				textAlign : "center",
				margin : 5,
				editable : true
			}, new go.Binding("text").makeTwoWay(), new go.Binding("angle",
					"angle", function(a) {
						return a === 180 ? 180 : 0;
					}).ofObject())));
			
			

			myDiagram.linkTemplate = $$(go.Link, {
				routing : go.Link.Normal,
				curve : go.Link.JumpOver,
				curviness : 2,
				corner : 10,
				reshapable : true,
				toShortLength : 7,
				relinkableFrom : true,
				relinkableTo : true,
				adjusting : go.Link.Stretch
			}, new go.Binding("points").makeTwoWay(), $$(go.Shape, {
				isPanelMain : true,
				//stroke : "black",
				strokeWidth : 4
			}, new go.Binding("stroke", "color")), $$(go.Shape, {
				isPanelMain : true,
				stroke : "gray",
				strokeWidth : 3
			}), $$(go.Shape, {
				isPanelMain : true,
				stroke : "white",
				strokeWidth : 1,
				//name : "PIPE",
				strokeDashArray : [ 10, 10 ]
			}, new go.Binding("name", "pipename")), $$(go.Shape, {
				toArrow : "Triangle",
				fill : "black",
				stroke : null
			}));
			
			
			
			
			

			myDiagram.model = go.Model
					.fromJson({
						"class" : "go.GraphLinksModel",
						"linkFromPortIdProperty": "fromPort",  // required information:
				        "linkToPortIdProperty": "toPort",
						"nodeDataArray" : [
								{
									"key" : "solar",
									"category" : "solar",
									"pos" : "500 100",
									"text" : "I1",
									"source" : "${pageContext.request.contextPath}/public/images/solarr.png"
								},
								{
									"key" : "battery",
									"category" : "battery",
									"pos" : "50 300",
									"text" : "I2",
									"source" : "${pageContext.request.contextPath}/public/images/bat.png"
								},  {
											"key" : "inverter",
											"category" : "inverter",	
											"pos" : "500 300",
											"source":"${pageContext.request.contextPath}/public/images/inver.png"
										},
								{
									"key" : "grid",
									"category" : "grid",
									"pos" : "900 300",
									"text" : "I4",
									"source" : "${pageContext.request.contextPath}/public/images/grid.png"
								},
								{
									"key" : "load",
									"category" : "load",
									"pos" : "500 500",
									"text" : "I5",
									"source" : "${pageContext.request.contextPath}/public/images/fires.png"
								} /* , {
										"key" : "I6",
										"category" : "inverter",
										"pos" : "500 450",
										"text": "I6",
										"source":"${pageContext.request.contextPath}/public/images/inver.png"
									} */ ]
					});

			
			linkDataCollection();
			  window.setInterval(function(){
				linkDataCollection();
			},20000); 

			/* myDiagram.model.addLinkDataCollection([ {
				"from" : "I1",
				"to" : "I3",
				"color": "blue",
				"pipename": "PIPE"
			}, {
				"from" : "I3",
				"to" : "I2",
				"color": "red",
				"pipename": "PIP"
			}, {
				"from" : "I4",
				"to" : "I3",
				"pipename": "PIPE"
			}, {
				"from" : "I3",
				"to" : "I5",
				"pipename": "PIPE"
			}, {
				"from" : "I5",
				"to" : "I6",
				"pipename": "PIP"
			} ]);
			
			loop(); */
			
			loop();
			 

		}

		function loop() {
			var diagram = myDiagram;
			setTimeout(function() {
				var oldskips = diagram.skipsUndoManager;
				diagram.skipsUndoManager = true;
				diagram.links.each(function(link) {
					var shape = link.findObject("PIPE");
					console.log(shape);
					if (shape != null) {
						var off = shape.strokeDashOffset - 2;
						shape.strokeDashOffset = (off <= 0) ? 100 : off;
					}
				});
				diagram.skipsUndoManager = oldskips;
				loop();
			}, 100);
		}
		
		

		function linkDataCollection() {
			
			var m_id = $('#m_id').val();
			
			$
					.ajax({
						url : '${pageContext.request.contextPath}/rest/micro_status/get/'
								+ m_id,
						type : 'GET',
						success : function(response) {
							var oldLinkdataArray = linkDataCollectionArray;
							if(oldLinkdataArray.length > 0){
								myDiagram.model.removeLinkDataCollection(oldLinkdataArray);
							}
							linkDataCollectionArray = [];
							console.log(response);
							if (response.status) {
								var data = response.data;
								
								var battery_state = data.battery_state;
								var grid_state = data.grid_state;
								var solar_state = data.solar_state;

								var bat_ins = data.battery_in_source;
								if (bat_ins != null && bat_ins.length > 0) {
									var bat_ins_data_arr = addInDataLinkArray(
											bat_ins, 1, "battery");
									bat_ins_data_arr.forEach(function(element) {
										linkDataCollectionArray.push(element);
									});
								}

								var bat_outs = data.battery_out_source;
								if (bat_outs != null && bat_outs.length > 0) {
									var bat_outs_data_arr = addInDataLinkArray(
											bat_outs, 0, "battery");
									bat_outs_data_arr
											.forEach(function(element) {
												linkDataCollectionArray
														.push(element);
											});
								}

								var sol_outs = data.solar_out_source;
								if (sol_outs != null && sol_outs.length > 0) {
									var sol_outs_data_arr = addInDataLinkArray(
											sol_outs, 0, "solar");
									sol_outs_data_arr
											.forEach(function(element) {
												linkDataCollectionArray
														.push(element);
											});
								}
								//myDiagram.model.removeLinkDataCollection(linkDataCollectionArray);
								
								if(grid_state == 'connected' || grid_state == 'disconnected'){
									var gridlinkfrom = false;
									var gridlinkto = false;
									
									linkDataCollectionArray.forEach(function(element, index){
										if(element.from == 'grid'){
											gridlinkfrom = true;
										}
										if(element.to == 'grid'){
											gridlinkto = true;
										}
									});
									
									if(!gridlinkfrom){
										var obj = new Object();
										obj.from = "grid";
										//obj.to = inout == 1 ? source : element;
										obj.to = "inverter";
										obj.color = "blue";
										obj.pipename = "NOPIPE";
										obj.fromPort = "gridout";
										obj.toPort = "gridin";
										linkDataCollectionArray.push(obj);
									}
									
									if(!gridlinkto){
										var obj = new Object();
										obj.from = "inverter";
										//obj.to = inout == 1 ? source : element;
										obj.to = "grid";
										obj.color = "blue";
										obj.pipename = "NOPIPE";
										obj.fromPort = "gridout";
										obj.toPort = "gridin";
										linkDataCollectionArray.push(obj);
									}
								}
															
								
								myDiagram.model
										.addLinkDataCollection(linkDataCollectionArray);
								
							}
							
						}
					});
		}

		function addInDataLinkArray() {
			var source = arguments[2];
			var sourceColDataLink = [];

			var tableVal = arguments[0];
			var tableValArr = [];

			if (tableVal.indexOf(',') != -1) {
				var tableValTempArr = tableVal.split(",");
				tableValTempArr.forEach(function(element) {
					tableValArr.push(element);
				});
			} else {
				tableValArr.push(tableVal);
			}

			// in = 1 and out = 0;
			var inout = arguments[1];

			tableValArr.forEach(function(element) {
				var obj = new Object();
				obj.from = inout == 1 ? element : source;
				//obj.to = inout == 1 ? source : element;
				obj.to = "inverter";
				obj.color = source == "grid" ? "black" : "blue";
				obj.pipename = "PIPE";
				obj.fromPort = inout == 1 ? element+"out" : source+"out";
				obj.toPort = inout == 1 ? element+"in" : source+"in"; 
				sourceColDataLink.push(obj);
				obj = new Object();
				obj.from = "inverter";
				obj.to = inout == 1 ? source : element;
				obj.color = source == "grid" ? "black" : "blue";
				obj.pipename = "PIPE";
				obj.fromPort = inout == 1 ? source+"out" : element+"out";
				obj.toPort = inout == 1 ? source+"in" : element+"in";
				sourceColDataLink.push(obj);
			});

			console.log(sourceColDataLink);

			return sourceColDataLink;
		}

		function loadjointJSDiagram() {
			var graph = new joint.dia.Graph;
			//console.log(graph);
			//console.log('---');

			var graph = new joint.dia.Graph;

			var paper = new joint.dia.Paper({
				el : $('#myholder'),
				width : 600,
				height : 800,
				model : graph,
				gridSize : 1
			});

			var rect = new joint.shapes.basic.Rect({
				position : {
					x : 100,
					y : 100
				},
				size : {
					width : 100,
					height : 30
				},
				attrs : {
					rect : {
						fill : 'blue'
					},
					text : {
						text : 'my box',
						fill : 'white'
					}
				}
			});

			var image_solar = new joint.shapes.basic.Image(
					{
						position : {
							x : 400,
							y : 100
						},
						size : {
							width : 80,
							height : 80
						},
						attrs : {
							image : {
								"xlink:href" : "${pageContext.request.contextPath}/public/images/solarr.png",
								width : 16,
								height : 16
							}
						}
					});

			var image_bat = new joint.shapes.basic.Image(
					{
						position : {
							x : 400,
							y : 100
						},
						size : {
							width : 80,
							height : 80
						},
						attrs : {
							image : {
								"xlink:href" : "${pageContext.request.contextPath}/public/images/bat.png",
								width : 16,
								height : 16
							}
						}
					});

			var image_inverter = new joint.shapes.basic.Image(
					{
						position : {
							x : 400,
							y : 100
						},
						size : {
							width : 80,
							height : 80
						},
						attrs : {
							image : {
								"xlink:href" : "${pageContext.request.contextPath}/public/images/inver.png",
								width : 16,
								height : 16
							}
						}
					});

			var image_grid = new joint.shapes.basic.Image(
					{
						position : {
							x : 400,
							y : 100
						},
						size : {
							width : 80,
							height : 80
						},
						attrs : {
							image : {
								"xlink:href" : "${pageContext.request.contextPath}/public/images/grid.png",
								width : 16,
								height : 16
							}
						}
					});

			var image_unknown = new joint.shapes.basic.Image(
					{
						position : {
							x : 400,
							y : 100
						},
						size : {
							width : 80,
							height : 80
						},
						attrs : {
							image : {
								"xlink:href" : "${pageContext.request.contextPath}/public/images/unknown.png",
								width : 16,
								height : 16
							}
						}
					});

			var image_fire = new joint.shapes.basic.Image(
					{
						position : {
							x : 400,
							y : 100
						},
						size : {
							width : 80,
							height : 80
						},
						attrs : {
							image : {
								"xlink:href" : "${pageContext.request.contextPath}/public/images/fires.png",
								width : 16,
								height : 16
							}
						}
					});

			var link = new joint.dia.Link({
				source : {
					id : rect.id
				},
				target : {
					id : image_solar.id
				}
			});

			var sa = '5 2';

			link.attr({
				'.connection' : {
					stroke : 'red',
					'stroke-width' : 2,
					'stroke-dasharray' : sa
				}
			//,
			//'.marker-source': { fill: 'red', d: 'M 10 0 L 0 5 L 10 10 z' },
			//'.marker-target': { fill: 'yellow', d: 'M 10 0 L 0 5 L 10 10 z' }
			});
			//link.set('vertices', [{ x: 300, y: 60 }, { x: 400, y: 60 }, { x: 400, y: 20 }])

			graph.addCells([ rect, image_solar, link ]);
		}
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
