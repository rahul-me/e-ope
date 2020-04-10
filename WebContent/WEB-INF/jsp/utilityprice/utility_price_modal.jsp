<div id="utilitypricemodal" class="modal fade" tabindex="-1"
	aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body">
				<form class="form-horizontal" id="addUtilityPrice">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Utility Price</h4>
					</div>
					<div style="height: 15px; clear: both;"></div>
					<input type="hidden" id="id_utility_price" name="id">
					
					<div class="modal-footer">
						<button type="button" data-dismiss="modal" class="btn default">Close</button>
						<button type="button" id="saveUtility" class="btn green">Save
							changes</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	$("#addUtilityPrice").click(function(){
		$("#utilitypricemodal").modal("show");
	});
</script>