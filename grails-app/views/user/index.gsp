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
        <div class="panel-body" ng-controller="UsuarioController as ctrl" >
            <p>
                <form name="form" method="post" ng-submit="ctrl.addUsuario()">
				<label>Novo Tipo de Consulta</label>
					<div class="form-group input-group">
						<input class="form-control" ng-model="ctrl.usuario.username" >
						<span class="input-group-btn">
							<input type="submit" value="Adicionar" class="btn btn-primary" />
						</span>
					</div>
				</form>
            </p>
            <div class="table-responsive" ng-init="ctrl.urlPath='${resource()}'; ctrl.getUsuarios();" >
                <table class="table table-bordered table-striped" summary="Tabela de Usuarios" id="hor-minimalist-b" >
                    <thead>
                        <tr>
                            <th width="50%" >Nome do Usuário</th>
                            <th width="30%" >Perfís de Acesso</th>
                            <th width="20%" >Ações</th>
                        </tr>
                    </thead>
                    <tbody ng-repeat="user in ctrl.usuarios" >
                            <tr>
                                <td>{{user.username}}</td>
                                <td>
									<a class="btn btn-social-icon {{ctrl.isRole(user.userRoles, 'ROLE_USER')}}" ng-click="ctrl.manageRole('ROLE_USER', user.id)" title="Adicionar Perfil de Acesso Usuário Comum"><i class="fa fa-user fa-fw"></i></a>
									<a class="btn btn-social-icon {{ctrl.isRole(user.userRoles, 'ROLE_DOCTOR')}}" ng-click="ctrl.manageRole('ROLE_DOCTOR', user.id)" title="Adicionar Perfil de Acesso Médico"><i class="fa fa-user-md fa-fw"></i></a>
									<a class="btn btn-social-icon {{ctrl.isRole(user.userRoles, 'ROLE_ADMIN')}}" ng-click="ctrl.manageRole('ROLE_ADMIN', user.id)" title="Adicionar Perfil de Acesso Administrador"><i class="fa fa-cog fa-fw"></i></a>
								</td>
                                <td>
									<a title="Reiniciar a senha" href="" ng-click="ctrl.resetPassword(user.id)" ><i class="fa fa-unlock-alt fa-fw"></i></a>
									<a title="Remover Usuário" href="" ng-click="ctrl.removeUsuario(user.id)"><i class="fa fa-trash-o fa-fw"></i></a>
								</td>
                            </tr>
                    </tbody>
                </table>
            </div>

        </div>
    </body>
</html>
