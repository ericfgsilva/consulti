
<%@ page import="br.com.consultorio.Paciente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <title><g:message code="default.list.label" args="Paciente" /></title>
    </head>
    <body>
        <!-- begin #content -->
        <div id="content" class="content">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 ui-sortable">

                    <div class="panel panel-inverse">
                        <div class="panel-heading" ng-controller="pacienteCtrl as paciente" >
                            <a href="" ng-click="paciente.editPaciente(${pacienteInstance.id}, null);" class="pull-right btn btn-md" ><i class="fa fa-lg fa-edit" ></i></a>
                            <h4 class="panel-title">Paciente</h4>
                        </div>
                        <div class="panel-body">
                            <!-- begin invoice -->
                            <div class="invoice" ng-controller="prontuarioPacienteCtrl as ctrl" ng-init="ctrl.init(${pacienteInstance.id})" >
                                <div class="tab-content p-0">

                                    <div class="tab-pane fade active in" id="paciente">
                                        <div class="invoice-header">
                                            <div class="invoice-from">
                                                <address class="m-t-5 m-b-5">
                                                    <p><strong>{{ctrl.paciente.nome}}</strong></p>
                                                    <p>Data de Nascimento: <span class="label label-default">{{ctrl.paciente.dataNascimento}}</span></p>
                                                    <strong>Informações sobre o Paciente:</strong>
                                                    <div class="m-b-10"></div>
                                                    <p>{{ctrl.paciente.descricao}}</p>
                                                </address>
                                            </div>

                                        </div><!-- end invoice header -->
                                    </div><!-- end paciente -->

                                </div><!-- end tab-content -->

                            </div>
                            <!-- end invoice -->

                        </div>
                    </div>

                </div>
            </div>

            <!-- begin row -->
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12">

                    <div ng-controller="prontuarioConsultaCtrl as ctrl" ng-init="ctrl.init(${pacienteInstance.id})" class="panel panel-inverse">
                        <div class="panel-heading">
                            <a href="" class="pull-right btn btn-md" ng-click="ctrl.printTo('content')" ><i class="fa fa-lg fa-print" ></i></a>
                            <h4 class="panel-title">Prontuário</h4>
                        </div>
                        <div class="panel-body" >
                            <!-- ng-repeat -->
                            <div class="panel panel-inverse" ng-repeat="consulta in ctrl.consultas" >
                                <div class="panel-heading">
                                    <div class="row">
                                        <a href="" class="pull-right btn btn-md" ><i class="fa fa-lg fa-edit" ></i></a>
                                        <span class="m-r-10">{{consulta.tipoConsulta.tipo}}</span>
                                        <span class="">{{consulta.dia}}</span>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    <p>Plano: <span class="label label-default">{{consulta.planoSaude}}</span></p>
                                    <p>Número da Carteira: <span class="label label-default">{{consulta.numeroCarteira}}</span></p>
                                    <p>Situação: <span class="label label-default">{{consulta.situacaoConsulta}}</span></p>
                                    <p>Médico: <span class="label label-default">{{consulta.prontuario.medico}}</span></p>
                                    <p ng-controller="consultaDescricaoCtrl as consultaCtrl" >Documentos:
                                        <span ng-repeat="documento in consulta.documentos" >
                                            <a href="" ng-click="consultaCtrl.abrirDocumento(documento.id)" class="btn btn-lg btn-default" ><i class="fa fa-lg fa-file-powerpoint-o" ></i></a>
                                        </span>
                                    </p>
                                    <strong>Informações da consulta:</strong>
                                    <div class="m-b-10"></div>
                                    <p>{{consulta.descricao}}</p>
                                </div>
                            </div> <!-- Prontuário ativo -->

                        </div>
                    </div>
                    <g:render template="../atendimento/atestado/formulario" />
                    <g:render template="../atendimento/prescricao/formulario" />
                </div><!-- End Prontuarios -->

            </div>
        </div>

        <!-- end #content -->
        <script type="text/ng-template" id="editPacienteTemplate">
            <g:render template="../paciente/edit" />
        </script>

    </body>
</html>
