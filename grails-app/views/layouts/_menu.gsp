<ul class="nav" id="side-menu">
	<li>
		<div class="panel-heading">
			<strong>Menu do Sistema</strong> <span class="pull-right">
				<button type="button" class="btn btn-default btn-circle">
					<i class="fa fa-question"></i>
				</button>
			</span>
		</div>
	</li>
	<li><a href="#"><i class="fa fa-user-md fa-fw"></i> Agenda Médica<span class="fa arrow"></span></a>
		<ul class="nav nav-second-level">
			<li><a href='${resource()}/'>Por dia</a></li>
			<li>
				<!-- <a href='${resource()}/monthly'>Por Mês</a>  --> <a href=''><strike>Por Mês</strike></a>
			</li>
		</ul> <!-- /.nav-second-level --></li>
	<li><a href='${resource()}/paciente'><i class="fa fa-users fa-fw"></i> Pacientes</a></li>
	<li><a href='${resource()}/planoSaude'><i class="fa fa-ambulance fa-fw"></i> Planos de Saúde</a></li>
	<li><a href="#"><i class="fa fa-bar-chart-o fa-fw"></i><strike>Relatórios</strike><span class="fa arrow"></span></a>
		<ul class="nav nav-second-level">
			<li>
				<!-- <a href='${resource()}/relatorios'>Total de Glosas por Plano de Saúde</a> -->
				<a href=''><strike>Total de Glosas por Plano de Saúde</strike></a>
			</li>
			<li>
				<!-- <a href='${resource()}/relatorios'>Pacientes atendidos por Mês</a>  -->
				<a href=''><strike>Pacientes atendidos por Mês</strike></a>
			</li>
			<li>
				<a href=''><strike>Total de Pacientes atendidos por Plano de Saúde</strike></a>
			</li>
		</ul> <!-- /.nav-second-level --></li>
		<li><a href='#' data-toggle="modal" data-target="#about" ><i class="fa fa-question fa-fw"></i> Sobre</a></li>
</ul>

<!-- Modal -->
<div class="modal fade" id="about" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Sobre</h4>
            </div>
            <div class="modal-body">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->