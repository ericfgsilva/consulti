<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Sistema de Consultório Médico</title>
    </head>
    <body>
        <!-- /.panel-heading -->
        <div class="panel-body" ng-controller="ConsultaController as ctrl">
            <p>
            <div class="col-lg-10" ng-controller="controllerCalendario as calendario" >
                <button class="btn btn-primary" ng-click="ctrl.getToday()" >Hoje!</button>
                <button class="btn btn-primary" ng-click="ctrl.getPreviousDay()" ><</button>
                <button class="btn btn-primary" ng-click="ctrl.getNextDay()" >></button> | 
                <label>{{ctrl.dataConsulta | date: 'dd/MM/yyyy'}}</label> | 
                <hidden datepicker-popup="dd/MM/yyyy" ng-change="ctrl.getConsultas()" ng-model="ctrl.dataConsulta" is-open="calendario.opened" close-text="Close" />
                <button type="button" class="btn btn-primary" ng-click="calendario.openCalendarWindow($event)"><i class="fa fa-calendar"></i></button>
                <button type="button" class="btn btn-primary" ng-click="ctrl.getConsultas();" ><i class="fa fa-refresh"></i></button>
                <div class="col-lg-10 pull-right" ng-controller="AgendarConsultaCtrl as agendarCtrl"
                     ng-init="agendarCtrl.urlPath='${resource()}'" >
                    <button class="btn btn-primary" ng-click="agendarCtrl.agendar(ctrl.getConsultas)" >Agendar Consulta</button>
                </div>
            </div>
        </p>

        <div class="table-responsive" ng-init="ctrl.urlPath='${resource()}'; ctrl.getConsultas();">
        
            <table class="table table-bordered table-striped" summary="Tabela de Consultas" id="hor-minimalist-b" >
                <thead>
                    <tr>
                        <th width="5%" >#</th>
                        <th width="10%" >Hora</th>
                        <th width="30%" >Paciente</th>
                        <th width="10%">Tipo</th>
                        <th width="10%" >Situação</th>
                        <th width="20%" >Plano</th>
                        <th width="10%" >Atendimento</th>
                        <th width="15%" >Ações</th>
                    </tr>
                </thead>
                <tbody ng-repeat="consulta in ctrl.consultas" >
                    <tr>
                        <td>{{consulta.ordemChegada}}</td>
                        <td>{{consulta.horaChegada}}</td>
                        <td>{{consulta.paciente.nome}}</td>
                        <td>{{consulta.tipoConsulta.tipo}}</td>
                        <td>{{consulta.situacaoConsulta}}</td>
                        <td>{{consulta.planoSaude.nome}} </td>
                        <td>
                        	<a title="Compareceu" ng-click="ctrl.setComparecimentoPaciente(consulta.id)" href=""><i class="fa fa-clock-o fa-fw"></i></a>
                        	<a title="Consulta Realizada pelo Médico" ng-click="ctrl.consultaRealizada(consulta.id) " href ="#"><i class="fa fa-check-square-o fa-fw"></i></a>
                        	<sec:access expression="hasRole('ROLE_DOCTOR')">
                            	<g:link controller="consulta" action="atender" id="{{consulta.id}}"><i class="fa fa-stethoscope fa-fw"></i></g:link>
                            </sec:access>
                            <a title="Cancelar Consulta" ng-click="ctrl.cancelarConsulta(consulta.id) " href ="#"><i style="color:Crimson" class="fa fa-times fa-fw"></i></a>
                        </td>
                        <td>
                            <a title="Visualizar Consulta" href="#" ng-click="ctrl.showConsulta(consulta.id)"><i class="fa fa-eye fa-fw"></i></a>
                            <a title="Alterar Consulta" href="consulta/edit/{{consulta.id}}"><i class="fa fa-edit fa-fw"></i></a>
                        </td>
                    </tr>
                </tbody>
            </table>
			<script type="text/ng-template" id="showConsultaModal">
				<g:render template="modal_show" />
			</script>
            <script type="text/ng-template" id="cadastroConsultaTemplate">
                <g:render template="consulta/agendar" />
            </script>
        </div>
    </div>
</body>
</html>
