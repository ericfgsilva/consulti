<!-- Modal-editar-Paciente -->
<div class="modal_content" id="modal-show-message">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header alert ${messageClass} m-b-0">
				<h4 class="modal-title"><i class="fa fa-warning"></i> ${title}</h4>
			</div>
			<div class="modal-body">
				{{message}}
			</div>
			<div class="modal-footer">
				<a href="javascript:;" class="btn btn-md btn-default" ng-click="close()" >OK</a>
			</div>
		</div>
	</div>
</div>