<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" ng-click="close()" >&times;</button>
		<h4 class="modal-title" id="myModalLabel">Consulta Médica</h4>
	</div>
	<div class="modal-body">
		<div class="col-lg-12">
			<div class="form-group col-lg-6">
				<label>Data da Consulta</label>
				<p class="form-control-static">{{consulta.dia}}</p>
			</div>
			<div class="form-group col-lg-6">
				<label>Paciente</label><p class="form-control-static">{{consulta.paciente.nome}}</p>
			</div>
		</div>
		<div class="col-lg-12">
			<div class="form-group col-lg-6">
				<label>Hora de Chegada</label><p class="form-control-static">{{consulta.horaChegada}}</p>
			</div>
			<div class="form-group col-lg-6">
				<label>Hora de Saída</label><p class="form-control-static">{{consulta.horaSaida}}</p>
			</div>
		</div>
		<div class="col-lg-12">
			<div class="form-group col-lg-6">
				<label>Nº da Carteira</label><p class="form-control-static">{{consulta.numeroCarteira}}</p>
			</div>
			<div class="form-group col-lg-6">
				<label>Plano de Saúde</label><p class="form-control-static">{{consulta.planoSaude.nome}}</p>
			</div>
		</div>
		<div class="form-group">
			<label>Tipo da Consulta</label><p class="form-control-static">{{consulta.tipoConsulta.tipo}}</p>
		</div>
	</div>
</div>
<!-- /.modal-content -->