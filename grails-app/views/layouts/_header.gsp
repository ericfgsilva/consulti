<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="index.html">Sistema de Consultório Médico</a>
</div>
<!-- /.navbar-header -->

<ul class="nav navbar-top-links navbar-right">
	<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
			<i class="fa fa-caret-down"></i>
	</a>
		<ul class="dropdown-menu dropdown-user">
			<li><i class="fa fa-user fa-fw"></i> <sec:loggedInUserInfo field="username" /></li>
			<li><a href='${resource()}/user/editPassword'><i class="fa fa-unlock-alt fa-fw"></i> Mudar Senha</a></li>
			<sec:access expression="hasRole('ROLE_ADMIN')">
				<li><i class="fa fa-cog fa-fw"></i> Admin Sys</li>
				<li><a href='${resource()}/user'><i class="fa fa-users fa-fw"></i> Usuários</a></li>
				<li><a href='${resource()}/tipoConsulta/'><i class="fa fa-tags fa-fw"></i> Tipos de Consulta</a></li>
			</sec:access>

			<li class="divider"></li>
			<li><a href="${resource()}/j_spring_security_logout"><i class="fa fa-sign-out fa-fw"></i> Sair</a></li>
		</ul> <!-- /.dropdown-user --></li>
	<!-- /.dropdown -->
</ul>