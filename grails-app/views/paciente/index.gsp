
<%@ page import="br.com.consultorio.Paciente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <title><g:message code="default.list.label" args="Paciente" /></title>
        <style>
            label span, .required {
                color: red;
            }
        </style>
    </head>
    <body>
        <div id="content" class="content">

            <div class="row" ng-controller="crudController as ctrl">

                <div id="cadastro-paciente" class="col-xs-12 col-sm-12 col-md-12">
                    <div class="panel panel-inverse" ng-init="ctrl.urlPath='${resource()}'; ctrl.controller='paciente'; ctrl.list();" >
                        <div class="panel panel-inverse" ng-controller="pacienteCtrl as paciente">
                            <div class="panel-heading">
                                <h4 class="panel-title">Gerenciar Pacientes&nbsp;</h4>
                            </div>
                            <div class="panel-body">
                                <form class="form-horizontal">

                                    <div class="row">

                                        <div class="col-xs-12 col-sm-12 col-md-12">
                                            <div class="table-responsive">
                                                <table class="pacientes_table table table-striped table-hover" st-table="ctrl.displayedCollection" st-safe-src="ctrl.objectList">
                                                    <thead>
                                                        <tr>
                                                            <th colspan="7">
                                            					<div class="col-md-3">&nbsp;</div>
																	<div class="col-md-6">
							  											<div class="input-group">
                                											<input name="gerPac_listPac_txtbxSearch" id="searchBox" st-search="" class="form-control" placeholder="Buscar paciente" type="text" ng-model="busca.text">
                                										<div class="input-group-btn" >	
                                    										<a name="gerPac_listPac_btnSearch" href="#" id="botao-buscar-paciente" class="btn btn-default" ng-disabled="!busca.text">Pesquisar</a>
                                    										<a id="gerPac_listPac_btnCriarPac" href="" ng-click="paciente.novoPaciente(ctrl.list);" class="btn btn-default btn_cadastro">Novo Paciente</a>
                                										</div>
                            										</div>
						    									</div>
						    						
						    								<div class="col-md-3">&nbsp;</div>
                                                    	</th> 
                                                    </tr>
                                                    <tr>
                                                        <th width="3%"><input type="checkbox" id="selectedAll" ng-click="ctrl.checkAll()" title="Selecionar Todos"/></th>
                                                        <th width="30%" st-sort="nome">Nome</th>
                                                        <th width="15%" >Telefone</th>
                                                        <th width="15%" st-sort="planosSaude">Plano</th>
                                                        <th width="15%">Data Nascimento</th>
                                                        <th width="15%">&nbsp;</th>
                                                        <th width="3%">&nbsp;</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody class="f-s-10 li-operation-btn " >
                                                        <tr id="gerPac_linPac_{{pacientePlano.id}}" ng-repeat="pacientePlano in ctrl.displayedCollection" >
                                                            <td><input class="checkbox" type="checkbox" value="{{pacientePlano.id}}" ng-model="pacientePlano.checked"></td>
                                                            <td><a style="cursor: pointer;" ng-click="paciente.editPaciente(pacientePlano.id);" ><h6>{{pacientePlano.nome}}</h6></a></td>
                                                            <td><a style="cursor: pointer;" ng-click="paciente.editPaciente(pacientePlano.id);" ><h6>{{pacientePlano.telefone}}</h6></a></td>
                                                            <td><a style="cursor: pointer;" ng-click="paciente.editPaciente(pacientePlano.id);" ><h6>{{pacientePlano.planosSaude.length}}</h6></a></td>
                                                            <td><a style="cursor: pointer;" ng-click="paciente.editPaciente(pacientePlano.id);" ><h6>{{pacientePlano.dataNascimento | date : 'dd/MM/yyyy' }}</h6></a></td>
                                                            <td class="text-center" ng-controller="AgendarConsultaCtrl as agendarCtrl"
                                                                ng-init="agendarCtrl.urlPath='${resource()}'" >
                                                                <a class="operation-btn" id="gerPac_linPac_agenConsul_{{pacientePlano.id}}" href="javascript:;" ng-click="agendarCtrl.agendar(ctrl.list, pacientePlano.id)" title="Agendar Consulta Médica"><i class="fa fa-2x fa-user-plus"></i></a>&nbsp;
                                                                <a class="operation-btn" id="gerPac_linPac_listProntuario_{{pacientePlano.id}}" href="${createLink(controller:'paciente', action:'prontuario')}/{{pacientePlano.id}}" title="Prontuário Médico"><i class="fa fa-2x fa-user-md"></i></a>&nbsp;
                                                            </td>
                                                            <td class="text-center">
                                                                <a class="operation-btn" id="gerPac_linPac_removePaciente_{{pacientePlano.id}}" href="#modal-excluir-linha" title="Excluir Paciente" class="botao-excluir-paciente disabled" data-toggle="modal" data-target="#modal-excluir-linha">
                                                                    <i class="fa fa-2x fa-trash-o" ng-click="ctrl.rowId = pacientePlano.id"></i>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                    <tfoot>
                                                        <tr>
                                                            <td colspan="7" class="text-center">
                                                                <div st-pagination="" st-items-by-page="ctrl.itemsByPage"></div>
                                                            </td>
                                                        </tr>
                                                    </tfoot>  								    
                                                </table>

                                            </div><!-- end Table-responsive -->
                                        </div>

                                    </div><!-- end row -->

                                </form>
                                <!-- End form cadastro paciente -->
                            </div>
                        </div>
                        
                        <script type="text/ng-template" id="createPacienteTemplate">
                            <g:render template="create" />
                        </script>
                        <script type="text/ng-template" id="editPacienteTemplate">
                            <g:render template="edit" />
                        </script>
                        <g:render template="remove" />
                        <script type="text/ng-template" id="cadastroConsultaTemplate">
                            <g:render template="../consulta/agendar" />
                        </script>
                    </div>
                </div>
                <!-- End Cadastro Paciente -->
            </div>
            <!-- End Row -->
        </div>
    </body>
</html>
