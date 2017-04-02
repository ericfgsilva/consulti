<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal-content">
	<div class="modal-header">
		<button type="button" class="close" ng-click="close()" >&times;</button>
		<h4 class="modal-title" id="myModalLabel">Agendando uma nova consulta</h4>
	</div>
	<div class="modal-body" ng-controller="CreateUpdateConsultaCtrl as ctrl" >
		<form name="form" method="post" ng-init="ctrl.urlPath=instance.urlPath; ctrl.init(consulta.id); ctrl.callback=instance.getConsultas" >
			<p class="help-block">* Campos Obrigatórios</p>
			<div class="form-group" ng-controller="controllerCalendario as calendario" >
                    <label>Data *</label>
					<div class="form-group input-group">
						<input type="text" class="form-control" required datepicker-popup="dd/MM/yyyy" ng-model="ctrl.diaConsulta" is-open="calendario.opened" ng-required="true" close-text="Close" />
						<span class="input-group-btn">
                            <button type="button" class="btn btn-default" ng-click="calendario.openCalendarWindow($event)"><i class="fa fa-calendar"></i></button>
                        </span>
					</div>
                </div>
                <!-- DATA -->
                <div class="form-group">
                    <label>Hora de Chegada</label>
                    <input type="text" class="form-control" pattern="[0-2]{1}[0-9]{1}:[0-5]{1}[0-9]{1}" placeholder="hrs:mins" ng-model="ctrl.consulta.horaChegada" />
                </div>
                <div class="form-group" >
                    <label>Paciente *</label>
					<div class="form-group input-group">
						<span class="input-group-addon"><label ng-model="ctrl.pacienteTypeAhead.id" >{{ctrl.pacienteTypeAhead.id}}</label></span>
						<input type="text" class="form-control" ng-model="ctrl.pacienteTypeAhead" required typeahead="paciente as paciente.nome for paciente in ctrl.pacienteTypeAheadList | filter:$viewValue" placeholder="Digite o nome de um paciente" />
					</div>
                </div>
                <div class="form-group">
                    <label>Planos de Saúde</label>
                    <select ng-model="ctrl.consulta.planoSaude" ng-options="planoSaude.nome for planoSaude in ctrl.planosSaudeList">
                    <option value="">Consulta Particular</option>
                  </select>
                </div>
                <div class="form-group">
                    <label>Tipo da Consulta *</label>
                    <select ng-model="ctrl.consulta.tipoConsulta" required ng-options="tipoConsulta.tipo for tipoConsulta in ctrl.tiposConsultaList"></select>
                </div>
                <div class="form-group">
                    <label>Nº da Carteira do Plano</label>
                    <input type="text" class="form-control" maxlength="20" placeholder="somente números" ng-model="ctrl.consulta.numeroCarteira" pattern="\d*" />
                </div>
                <sec:access expression="hasRole('ROLE_DOCTOR')">
                    <div class="form-group">
                        <label>Descrição</label>
                        <textarea class="form-control" maxlength="255" rows="10" cols="40" ng-model="consulta.descricao" />
                    </div>
                </sec:access>
			<button type="button" class="btn btn-primary" ng-click="ctrl.submit(); submit();" >Cadastrar</button>
		</form>
	</div>
</div>
<!-- /.modal-content -->