<div class="modal fade" id="openModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Alteração - Tipo Consulta</h4>
			</div>
			<div class="modal-body">
			<form name="form" method="post">
				<input type="hidden" name="id" id="id" ng-model="ctrl.editTipoConsulta.id" />
				<label>Novo Tipo de Consulta</label>
				<div class="form-group input-group">
					<input class="form-control" ng-model="ctrl.editTipoConsulta.tipo" >
					<span class="input-group-btn">
						<a href="#close" class="btn btn-primary" title="Close" data-dismiss="modal" ng-click="ctrl.updateTipoConsulta()" >Alterar</a>
					</span>
				</div>
			</form>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>