
<%@ page import="br.com.consultorio.Paciente"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName"
        value="${message(code: 'paciente.label', default: 'Paciente')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
      <div id="content" class="content">
        <div class="row" ng-controller="planoSaudeCtrl as ctrl" ng-init="ctrl.init();"  >

            <div id="cadastro-plano" class="col-xs-12 col-sm-12 col-md-12">
                <div class="panel panel-inverse">
                    <div class="panel-heading">
                        <h4 class="panel-title">Gerenciar Planos de Saúde</h4>
                    </div>
                    <div class="panel-body" >
                        <form class="form-horizontal" name="form">

                            <div class="row">

                                <div class="col-xs-12 col-sm-12 col-md-12">
                                    <div class="table-responsive">

                                        <table class="planos_table table table-striped table-hover" st-table="ctrl.displayedCollection" st-safe-src="ctrl.planos">
                                            <thead>
												<tr>
											    	<th colspan="7">
														<div class="col-md-3">&nbsp;</div>
															<div class="col-md-4">
																<div class="input-group">													
																	<input data-selenium="gerPlan_listPlano_txtbxSearch" id="searchBox" st-search="" class="form-control input-sm" placeholder="Buscar plano de saúde" type="text" size="2" ng-model="busca.text" /> 
																<div class="input-group-btn">	
							                            	        <a data-selenium="gerPlan_listPlano_btnSearch" href="#" id="botao-buscar-paciente" ng-disabled="!busca.text" class="btn btn-default"><i class="fa fa-search"></i></a>
							                                	</div>
							                            	</div>
												    	</div>
												    	
											     		<div class="col-md-5" align="right">
			                                                <a data-selenium="gerPlan_listPlano_btnCriarPlano" id="bt-novo-edit" ng-click="ctrl.novo();" title="Cadastrar Novo Plano de Saúde" class="btn btn-default" >Adicionar Plano</a>
			                                                <a data-selenium="gerPlan_listPlano_btnExcluirPlano" href="#modal-excluir-plano" ng-disabled="!ctrl.checked()" ng-click="ctrl.removerGrupo()" class="btn btn-default" >Excluir</a>
						                                </div>												    	
													</th>
												</tr>                                            
                                                <tr>
                                                    <th width="3%"><input type="checkbox" id="selectedAll" ng-click="ctrl.checkAll()" title="Selecionar Todos"/></th>
                                                    <th>Nome</th>
                                                    <th>Nº Registro ANS</th>
                                                    <th>Contato</th>
                                                    <th>Descrição</th>
                                                    <th width="3%"></th>
                                                </tr>
                                            </thead>
                                            <tbody class="f-s-10">
                                                <tr data-selenium="gerPlan_linPlan_{{plano.id}}" ng-repeat="plano in ctrl.displayedCollection">
                                                    <td><input class="checkbox" type="checkbox" value="{{plano.id}}" ng-model="plano.checked" ng-click="ctrl.updateSelected(plano.id)"></td>
                                                    <td><a ng-click="ctrl.alterar(plano.id);"><h6>{{plano.nome}}</h6></a></td>
                                                    <td><a ng-click="ctrl.alterar(plano.id);"><h6>{{plano.registroANS}}</h6></a></td>
                                                    <td><a ng-click="ctrl.alterar(plano.id);"><h6>{{plano.contato}}</h6></a></td>
                                                    <td><a ng-click="ctrl.alterar(plano.id);"><h6>{{plano.descricao}}</h6></a></td>
                                                    <td>
                                                    	<a data-selenium="gerPlan_linPlano_btnExcluir" href="" ng-click="ctrl.remover(plano.id);" >
                                                    		<i class="fa fa-2x fa-trash-o" title="Excluir" ></i>
                                                    	</a>
                                                    </td>
                                                </tr>
                                            </tbody>
											<tfoot>
												<tr>
													<td colspan="6" class="text-center">
														<div st-pagination="" st-items-by-page="ctrl.itemsByPage"></div>
													</td>
												</tr>
											</tfoot>                                            
                                        </table>

                                    </div><!-- end Table-responsive -->
                                </div>

                            </div><!-- end row -->

                        </form>
                        <!-- End form cadastro plano -->
                    </div>
                </div>
            </div>
            <!-- End Cadastro Plano -->

            <!-- Template -->
            <script type="text/ng-template" id="createPlanoSaudeTemplate">
            <g:render template="create" />
            </script>
            <script type="text/ng-template" id="editPlanoSaudeTemplate">
            <g:render template="edit" />
            </script>
            <g:render template="remove" />
            <g:render template="success" />
        </div>
        <!-- End Row -->
	  </div>	
    </body>
</html>
