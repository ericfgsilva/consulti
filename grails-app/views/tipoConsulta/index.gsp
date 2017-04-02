<!DOCTYPE html>
	<html>
    <head>
       <meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'tipoConsulta.label', default: 'TipoConsulta')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>

    <body>
        <div class="panel panel-default">
            <div class="panel-heading">
                <i class="fa fa-bar-chart-o fa-fw"></i> Tipos de Consulta
            </div>
        </div>
        <!-- /.panel-heading -->
        <div class="panel-body" ng-controller="TipoConsultaIndex as ctrl" >
            <p>
                <form name="form" method="post" ng-submit="ctrl.addTipoConsulta()">
				<label>Novo Tipo de Consulta</label>
					<div class="form-group input-group">
						<input class="form-control" ng-model="ctrl.tipoConsulta.tipo" >
						<span class="input-group-btn">
							<input type="submit" value="Adicionar" class="btn btn-primary" />
						</span>
					</div>
				</form>
            </p>
            <div class="table-responsive" ng-init="ctrl.urlPath='${resource()}'; ctrl.getTiposConsulta();" >
                <table class="table table-bordered table-striped" summary="Tabela de Tipos de Consultas" id="hor-minimalist-b" >
                    <thead>
                        <tr>
                            <th width="80%" >Tipo</th>
                            <th width="20%" >Ações</th>
                        </tr>
                    </thead>
                    <tbody ng-repeat="tipo in ctrl.tiposConsulta" >
                            <tr>
                                <td>{{tipo.tipo}}</td>
								<!-- <a href="edit?id={{tipo.id}}">Editar</a> -->
                                <td>
								<a data-toggle="modal" data-target="#openModal" ng-click="ctrl.getTipoConsulta(tipo.id)" ><i class="fa fa-pencil fa-fw"></i></a>
								<a onclick="return confirm('Tem certeza que deseja excluir este tipo de consulta?')" href="" ng-click="ctrl.removeTipoConsulta(tipo.id)"><i class="fa fa-trash-o fa-fw"></i></a></td>
                            </tr>
                    </tbody>
                </table>
				<g:render template="modal_edit" />
            </div>

        </div>
    </body>
</html>
