<%@ page import="br.com.consultorio.Paciente"%>
<!DOCTYPE html>
	<html>
    <head>
        <style type="text/css">
            div a{
                color: #fff;
                text-decoration: none;
            }
            div a:hover{
                color: gray;
                text-decoration: none;
            }
            .main-btn{
                width: 90px;
                margin: 0px 20px 10px 20px;
            }
            .btn-group{
                margin-right: 30px;
            }
        </style>
       <meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'secretaria.label', default: 'Secretaria')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>

    <body>
            <div class="col-xs-12 col-sm-1 col-md-1 btn-group">
                <div class="btn-group">
                    <p ng-controller="planoSaudeCtrl as planoCtrl" ng-init="planoCtrl.init();" >
                        <a href="#" id="botao-cadastrar-plano" ng-click="planoCtrl.novo();" class="btn btn-default btn-md btn-block"><i class="fa fa-plus"></i> Plano Saúde</a>
                    </p>
                    <p ng-controller="AgendarConsultaCtrl as agendarCtrl" ng-init="agendarCtrl.urlPath='${resource()}'">
                        <a href="#" id="botao-cadastrar-consulta" ng-click="agendarCtrl.agendar(null, null)" class="btn btn-default btn-md btn-block"><i class="fa fa-plus"></i> Consulta</a>
                    </p>
                    <p ng-controller="pacienteCtrl as paciente" >
                        <a href="#" id="botao-cadastrar-paciente" ng-click="paciente.novoPaciente(ctrl.list);" class="btn btn-default btn-md btn-block"><i class="fa fa-plus"></i> Paciente</a>
                    </p>
                </div>
            </div>
         



    <div class="row"  >
        <div id="ultimas-consultas" >
            <g:render template="/general/contadores" />

            <div class="col-md-6 ui-sortable">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Buscar">
                    <div class="input-group-btn">
                        <a href="#" id="botao-buscar-paciente" class="btn btn-default"><i class="fa fa-search"></i></a>
                    </div>
                </div>
            </div>

          <button>TODOS</button>
        </div>
    </div>
    <div class="row" ng-controller="secretariaCtrl as ctrl" ng-init="ctrl.init();" >
        <div class="col-md-3" ng-repeat="(medico, consultas) in ctrl.consultas">
            <div class="panel panel-inverse">
                <div class="panel-heading">
                    <h4 class="panel-title">{{medico}}</h4>
                </div>
                <div class="panel-body">
                    <div class="col-md-12 col-sm-4 ui-sortable">
                        <!--begin info-paciente-consulta-->
                        <div id="list-ultimas-consultas" ng-repeat="appointment in consultas" >
                            <div class="widget widget-stats bg-consulti info-paciente-consulta">
                                <div class="stats-icon"><i class="fa fa-user"></i></div>
                                <div class="stats-info infos-paciente">
                                    <h4>{{appointment.prontuario.paciente.nome}}</h4>
                                    <h4>{{appointment.horaChegada}}</h4>
                                    <h4>{{appointment.situacaoConsulta}}</h4>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <script type="text/ng-template" id="cadastroConsultaTemplate">
            <g:render template="../consulta/agendar" />
        </script>
        <script type="text/ng-template" id="createPlanoSaudeTemplate">
            <g:render template="../planoSaude/create" />
        </script>
        <script type="text/ng-template" id="createPacienteTemplate">
            <g:render template="../paciente/create" />
        </script>
    </div>

        			
    </body>
</html>
