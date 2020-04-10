<jsp:include page="../bootstrapheader/css.jsp"></jsp:include>

<!-- END HEAD -->
<!-- BEGIN BODY -->
<style>
.back_image{
    background-image: url(http://graphitetech.in/wp-content/uploads/2015/08/green-city-1400x570.png);
    background-repeat: no-repeat;
    /* width: 100%; */
    background-position: center;
    background-size: 100% 100%;
}
.page-content {    
    padding: 0px 0px 24px 0px;
}
</style>
<body class="page-header-fixed">
<jsp:include page="../bootstrapheader/topmenu.jsp"></jsp:include>
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<jsp:include page="../bootstrapheader/leftmenu.jsp"></jsp:include>
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<header class="jumbotron hero-spacer back_image" style="height:500px;">
			<br>
			<br>
			<br>
	            <h2>Smart Energy 2.0 Profile</h2>
	            <p style="width:650px;font-size: 15px">zigbee Smart Energy is the world's leading standard for interoperable products that monitor, control, inform and automate the delivery and use of energy and water. It helps create greener homes by giving consumers the information and automation needed to easily reduce their consumption and save money, too.</p>
	            <p><a class="btn btn-primary btn-large">View More!</a>
	            </p>
	        </header>
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
							<h4 class="modal-title">Modal title</h4>
						</div>
						<div class="modal-body">
							 Widget settings form goes here
						</div>
						<div class="modal-footer">
							<button type="button" class="btn blue">Save changes</button>
							<button type="button" class="btn default" data-dismiss="modal">Close</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="container">

        <!-- Jumbotron Header -->

        <!-- Title -->
        <div class="row">
            <div class="col-lg-12">
                <h3>Latest Features</h3>
            </div>
        </div>
        <!-- /.row -->

        <!-- Page Features -->
        <div class="row text-center">

            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Metering Support</h3>
                        <p>Multiple measurement types such as load profile, power factor, summation, demand, and tiers.</p>
                        <p>
                            <a href="#" class="btn btn-primary">View More!</a>
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Demand Response</h3>
                        <p>Ability to individually or simultaneously target specific groups of devices.</p>
                        <p>
                            <a href="#" class="btn btn-primary">View More!</a>
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Sample Devices</h3>
                        <p>Electric vehicles and plug-in hybrid electric vehicles.</p>
                        <p>
                            <a href="#" class="btn btn-primary">View More!</a> 
                        </p>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6 hero-feature">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>Directed Messaging</h3>
                        <p>Scheduling/canceling of messages.</p>
                        <p>
                            <a href="#" class="btn btn-primary">View More!</a>
                        </p>
                    </div>
                </div>
            </div>

        </div>
    </div>	
			<div class="clearfix">
			</div>			
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<jsp:include page="../bootstrapheader/footer.jsp"></jsp:include>
<jsp:include page="../bootstrapheader/javascript.jsp"></jsp:include>
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins   
});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
