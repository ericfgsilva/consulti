<!-- Modal-Excluir-Paciente -->
<div class="modal" id="modal-excluir-paciente">
	<div class="modal-dialog">
		<div data-selenium="gerPac_removeVariosPacModal" class="modal-content">
			<div class="modal-header alert alert-warning m-b-0">
				<h4 class="modal-title"><i class="fa fa-warning"></i>Excluir Paciente</h4>
			</div>
			<div data-selenium="gerPac_remPacVariosConfirm_msg" class="modal-body">
				Tem certeza que deseja excluir este(s) paciente(s)?
			</div>
			<div class="modal-footer">
				<a data-selenium="gerPac_removePacVarios_btnConfirm" href="javascript:;" class="btn btn-md btn-default" ng-click="ctrl.remove()" data-dismiss="modal">Sim</a>
				<a data-selenium="gerPac_removePacVarios_btnCancelar" href="javascript:;" class="btn btn-md btn-default" data-dismiss="modal">Não</a>
			</div>
		</div>
	</div>
</div>
<!-- End Modal-Excluir-Paciente -->

<!-- Modal-Excluir-Linha -->
<div class="modal" id="modal-excluir-linha">
	<div class="modal-dialog">
		<div data-selenium="gerPac_removePacLinhaModal" class="modal-content">
			<div class="modal-header alert alert-warning m-b-0">
				<h4 class="modal-title"><i class="fa fa-warning"></i>Excluir Paciente</h4>
			</div>
			<div data-selenium="gerPac_remPacConfirm_msg" class="modal-body">
				Tem certeza que deseja excluir este paciente?
			</div>
			<div class="modal-footer">
				<a data-selenium="gerPac_removePacLin_btnConfirm" href="javascript:;" class="btn btn-md btn-default" ng-click="ctrl.removeLine()" data-dismiss="modal">Sim</a>
				<a data-selenium="gerPac_removePacLin_btnCancelar" href="javascript:;" class="btn btn-md btn-default" data-dismiss="modal">Não</a>
			</div>
		</div>
	</div>
</div>
<!-- End Modal-Excluir-Paciente -->