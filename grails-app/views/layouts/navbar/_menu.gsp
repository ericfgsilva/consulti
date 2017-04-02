<!-- begin header navigation right -->
<ul class="nav navbar-nav navbar-left">

    <li><a id="navBarSup_btnSecretaria" href="${resource()}/secretaria" data-popover="Secretária" ><i class="fa fa-2x fa-hospital-o"></i></a></li>
    <li class="divider hidden-xs"></li>
    <li><a id="navBarSup_btnAtendimento" href="${resource()}/atendimento" data-popover="Atendimento"><i class="fa fa-2x fa-user-md"></i></a></li>
    <li class="divider hidden-xs"></li>
    <li class="dropdown navbar-user">
        <a id="navBarSup_btnPlanoSaude" href="${resource()}/planoSaude" data-popover="Planos de Saúde">
            <i class="fa fa-2x fa-credit-card"></i>
        </a>
    </li>
    <li class="divider hidden-xs"></li>
    <li><a id="navBarSup_btnPacientes" href="${resource()}/paciente" data-popover="Pacientes"><i class="fa fa-2x fa-male"></i></a></li>
    <li class="divider hidden-xs"></li>
    <li><a id="navBarSup_btnUsers" href="${resource()}/user" data-popover="Usuários"><i class="fa fa-2x fa-user"></i></a></li>

</ul>

<ul class="nav navbar-nav navbar-right">

    <li class="dropdown">
            <a id="navBarSup_btnNotificacoes" href="javascript:" data-toggle="dropdown" class="dropdown-toggle" title="Notificações">
                <i class="fa fa-2x fa-envelope"></i>
                <span class="label">3</span>
            </a>
            <ul class="dropdown-menu media-list pull-right">
                <li class="dropdown-header">Notificações (3)</li>
                <li class="media">
                    <a href="javascript:">
                        <div class="pull-left media-object bg-red"><i class="fa fa-envelope"></i></div>
                        <div class="media-body">
                            <h6 class="media-heading">Dr Celso</h6>
                            <p>Pense numa secretaria gostosa é...</p>
                            <div class="text-muted">2 minutos atrás</div>
                        </div>
                    </a>
                </li>
                <li class="media">
                    <a href="javascript:">
                        <div class="pull-left media-object bg-red"><i class="fa fa-envelope"></i></div>
                        <div class="media-body">
                            <h6 class="media-heading">Dr Thiago</h6>
                            <p>Pense numa secretaria gostosa é...</p>
                            <div class="text-muted">5 minutos atrás</div>
                        </div>
                    </a>
                </li>
                <li class="media">
                    <a href="javascript:">
                        <div class="pull-left media-object bg-red"><i class="fa fa-envelope"></i></div>
                        <div class="media-body">
                            <h6 class="media-heading">Dr Eric</h6>
                            <p>Pense numa secretaria gostosa é essa tal de Chacrete</p>
                            <div class="text-muted">25 minutos atrás</div>
                        </div>
                    </a>
                </li>
                <li class="dropdown-footer text-center">
                    <a href="javascript:">Outras Notificações</a>
                </li>
            </ul>
        </li>
        <li class="divider hidden-xs"></li>
        <li><a id="navBarSup_btnLogOut" href="${resource()}/j_spring_security_logout" title="Sair"><i class="fa fa-2x fa-sign-out"></i></a></li>
</ul>

<!-- end header navigation right -->