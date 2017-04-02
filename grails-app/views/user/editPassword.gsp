<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main">
<title>Sistema de Consultório Médico</title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<i class="fa fa-user-md fa-fw"></i> Cadastrando um novo paciente
			<span class="pull-right">
				<button type="button" class="btn btn-default btn-circle" onClick="abrirJanelaAjuda('${resource()}', 'nova_consulta')"><i class="fa fa-question"></i></button>
				<g:link class="btn btn-default btn-circle" controller="paciente" action="index"><i class="fa fa-chevron-left"></i></g:link>
			</span>
		</div>
	</div>
	<!-- /.panel-heading -->
	<div class="panel-body">
		<g:form url="[controller:'user', action:'updatePassword']" >
			<div class="form-group">
				<g:submitButton name="create" class="btn btn-primary" value="Alterar" />
			</div>
			<div class="form-group">
				<label>Username</label>
				<p class="form-control-static">${userInstance.username}</p>
			</div>
			<div class="form-group">
				<label>Nova Senha</label>
				<g:passwordField class="form-control" name="password" required type="text" value="" />
			</div>
		</g:form>
	</div>
</body>
</html>