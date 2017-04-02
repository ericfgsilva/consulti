<%@ page import="br.com.consultorio.Consulta" %>
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
                <i class="fa fa-user-md fa-fw"></i>Consulta
                <span class="pull-right">
                    <button type="button" class="btn btn-default btn-circle" onClick="abrirJanelaAjuda('${resource()}', 'nova_consulta')"><i class="fa fa-question"></i></button>
                    <a href="${resource()}" class="btn btn-default btn-circle" ><i class="fa fa-chevron-left"></i></a>
                </span>
            </div>
        </div>
        <!-- /.panel-heading -->
        <div class="panel-body" ng-controller="EditConsultaController as ctrl" >
			
            <div class="col-lg-12">
	                <div class="form-group col-lg-4">
	                    <label>Data marcada</label>
	                    <p class="form-control-static">${consultaInstance.dia}</p>
	                </div>
	                <div class="form-group col-lg-6">
	                    <label>Paciente</label>
						<p class="form-control-static">${consultaInstance.paciente.nome}</p>
	                </div>
	                <div class="form-group col-lg-6" >
	                    <label>Hora de Chegada</label>
	                    <p class="form-control-static">${consultaInstance.horaChegada}</p>
	                </div>
	                <div class="form-group col-lg-6">
	                    <label>Hora de Saída</label>
	                    <p class="form-control-static">${consultaInstance.horaSaida}</p>
	                </div>
                </div>
                <div class="form-group">
                    <label>Planos de Saúde</label>
                    <p class="form-control-static">${consultaInstance?.planoSaude?.nome}</p>
                </div>
                <div class="form-group" ng-init="ctrl.editConsulta.tipoConsulta = {id:${consultaInstance.tipoConsulta.id}}" >
                    <label>Tipo da Consulta *</label>
                    <p class="form-control-static">${consultaInstance.tipoConsulta.tipo}</p>
                </div>
                <div class="form-group" >
                    <label>Situação da Consulta *</label>
                    <p class="form-control-static">${consultaInstance.situacaoConsulta}</p>
                </div>
                <div class="form-group">
                    <label>Nº da Carteira do Plano</label>
                    <p class="form-control-static">${consultaInstance.numeroCarteira}</p>
                </div>
                <sec:access expression="hasRole('ROLE_DOCTOR')">
                    <div class="form-group">
                        <label>Descrição</label>
                        <p class="form-control-static">${consultaInstance.paciente.descricao}</p>
                    </div>
                </sec:access>
        </div>
    </body>
</html>