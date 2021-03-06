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
                <i class="fa fa-user-md fa-fw"></i> Alterando Consulta
                <span class="pull-right">
                    <button type="button" class="btn btn-default btn-circle" onClick="abrirJanelaAjuda('${resource()}', 'nova_consulta')"><i class="fa fa-question"></i></button>
                    <a href="${resource()}" class="btn btn-default btn-circle" ><i class="fa fa-chevron-left"></i></a>
                </span>
            </div>
        </div>
        <!-- /.panel-heading -->
        <div class="panel-body" ng-controller="EditConsultaController as ctrl" >
			
            <form method="post" ng-submit="ctrl.updateConsulta()" >
				<input type="hidden" ng-init="ctrl.editConsulta.id = '${consultaInstance.id}'" />
				<!-- PAINEIS DE BOTOES -->
				<div class="form-group" ng-init="ctrl.urlPath='${resource()}'; ctrl.listTiposConsulta(); ctrl.listPlanosSaude(${consultaInstance.paciente.id});" >
                    <p class="help-block">* Campos Obrigatórios</p>
					<input class="btn btn-primary" type="submit" value="Alterar"/>
                </div>
                <!-- PAINEIS DE BOTOES -->
                <div class="col-lg-12">
	                <div class="form-group col-lg-4">
	                    <label>Data marcada</label>
	                    <p class="form-control-static">${consultaInstance.dia}</p>
	                </div>
	                <div class="form-group col-lg-6">
	                    <label>Paciente</label>
						<p class="form-control-static">${consultaInstance.paciente.nome}</p>
	                </div>
	                <g:if test="${consultaInstance.horaChegada != null}" >
                		<input type="hidden" maxlength="5" ng-init="ctrl.editConsulta.horaChegada = '${consultaInstance.horaChegada}'" />
                	</g:if>
	                <div class="form-group col-lg-6" >
	                    <label>Hora de Chegada</label>
	                    <input type="text" class="form-control" pattern="[0-2]{1}[0-9]{1}:[0-5]{1}[0-9]{1}" placeholder="hrs:mins" ng-model="ctrl.editConsulta.horaChegada" />
	                </div>
	                <g:if test="${consultaInstance.horaSaida != null}" >
                		<input type="hidden" ng-init="ctrl.editConsulta.horaSaida = '${consultaInstance.horaSaida}'" />
                	</g:if>
	                <div class="form-group col-lg-6">
	                    <label>Hora de Saída</label>
	                    <input type="text" class="form-control" pattern="[0-2]{1}[0-9]{1}:[0-5]{1}[0-9]{1}" placeholder="hrs:mins" ng-model="ctrl.editConsulta.horaSaida" />
	                </div>
                </div>
                <g:if test="${consultaInstance.planoSaude != null}" >
                	<input type="hidden" ng-init="ctrl.editConsulta.planoSaude = {id:${consultaInstance.planoSaude.id}}" />
                </g:if>
                <div class="form-group">
                    <label>Planos de Saúde</label>
                    <select ng-model="ctrl.editConsulta.planoSaude" ng-options="planoSaude.nome for planoSaude in ctrl.planosSaude track by planoSaude.id">
                    <option value="">Consulta Particular</option>
                  </select>
                </div>
                <div class="form-group" ng-init="ctrl.editConsulta.tipoConsulta = {id:${consultaInstance.tipoConsulta.id}}" >
                    <label>Tipo da Consulta *</label>
                    <select ng-model="ctrl.editConsulta.tipoConsulta" ng-options="tipoConsulta.tipo for tipoConsulta in ctrl.tiposConsulta track by tipoConsulta.id"></select>
                </div>
                <div class="form-group" ng-init="ctrl.editConsulta.situacaoConsulta = '${consultaInstance.situacaoConsulta}'" >
                    <label>Situação da Consulta *</label>
                    <select ng-model="ctrl.editConsulta.situacaoConsulta">
						<option value="consultado">Consultado</option>
						<option value="cancelado">Cancelado</option>
						<option selected value="marcado">Marcado</option>
						<!-- MUDAR HARD CODE -->
					</select>
                </div>
                <div class="form-group" ng-init="ctrl.editConsulta.numeroCarteira = '${consultaInstance.numeroCarteira}'" >
                    <label>Nº da Carteira do Plano</label>
                    <input type="text" class="form-control" maxlength="20" placeholder="somente números" ng-model="ctrl.editConsulta.numeroCarteira" pattern="\d*" />
                </div>
                <sec:access expression="hasRole('ROLE_DOCTOR')">
                    <div class="form-group" ng-init="ctrl.editConsulta.descricao = '${consultaInstance.descricao}'" >
                        <label>Descrição</label>
                        <textarea maxlength="255" class="form-control" rows="10" cols="40" ng-model="ctrl.editConsulta.descricao" />
                    </div>
                </sec:access>
            </form>
        </div>
    </body>
</html>