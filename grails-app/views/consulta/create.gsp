<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'consulta.label', default: 'Consulta')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <title>Sistema de Consultório Médico</title>
    </head>

    <body>
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-user-md fa-fw"></i> Agendando uma nova consulta
                <span class="pull-right">
                    <button type="button" class="btn btn-default btn-circle" onClick="abrirJanelaAjuda('${resource()}', 'nova_consulta')"><i class="fa fa-question"></i></button>
                    <a href="${resource()}" class="btn btn-default btn-circle" ><i class="fa fa-chevron-left"></i></a>
                </span>
            </div>
        </div>
        <!-- /.panel-heading -->
        <div class="panel-body" ng-controller="NovaConsultaController as ctrl" >
			
            <form method="post" ng-submit="ctrl.addNovaConsulta()" >
				
				<!-- PAINEIS DE BOTOES -->
				<div class="form-group" ng-init="ctrl.urlPath='${resource()}'; ctrl.listPacientes(); ctrl.listTiposConsulta();" >
                    <p class="help-block">* Campos Obrigatórios</p>
					<input class="btn btn-primary" type="submit" value="Cadastrar"/>
                </div>
                <!-- PAINEIS DE BOTOES -->
                <!-- DATA -->
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
                    <input type="text" class="form-control" pattern="[0-2]{1}[0-9]{1}:[0-5]{1}[0-9]{1}" placeholder="hrs:mins" ng-model="ctrl.newConsulta.horaChegada" />
                </div>
                <div class="form-group">
                    <label>Paciente *</label>
					<div class="form-group input-group">
						<span class="input-group-addon"><label ng-model="newConsulta.paciente" >{{ctrl.pacienteTypeAhead.id}}</label></span>
						<input type="text" class="form-control" ng-model="ctrl.pacienteTypeAhead" required typeahead="paciente as paciente.nome for paciente in ctrl.pacientes | filter:$viewValue" placeholder="Digite o nome de um paciente" />
					</div>
                </div>
                
                <div class="form-group">
                    <label>Planos de Saúde</label>
                    <select ng-model="ctrl.newConsulta.planoSaude" ng-options="planoSaude.nome for planoSaude in ctrl.planosSaude">
                    <option value="">Consulta Particular</option>
                  </select>
                </div>
                <div class="form-group">
                    <label>Tipo da Consulta *</label>
                    <select ng-model="ctrl.newConsulta.tipoConsulta" required ng-options="tipoConsulta.tipo for tipoConsulta in ctrl.tiposConsulta"></select>
                </div>
                <div class="form-group">
                    <label>Nº da Carteira do Plano</label>
                    <input type="text" class="form-control" maxlength="20" placeholder="somente números" ng-model="ctrl.newConsulta.numeroCarteira" pattern="\d*" />
                </div>
                <sec:access expression="hasRole('ROLE_DOCTOR')">
                    <div class="form-group">
                        <label>Descrição</label>
                        <textarea class="form-control" maxlength="255" rows="10" cols="40" ng-model="ctrl.newConsulta.descricao" />
                    </div>
                </sec:access>
            </form>
        </div>
    </body>
</html>
