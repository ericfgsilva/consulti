<div class="panel panel-inverse">
    <div class="panel-heading">
        <h4 class="panel-title">Prontuário</h4>
    </div>
    <div class="panel-body">

        <div id="prontuario-ativo" ng-repeat="consulta in ctrl.historicoConsultas()">

            <div class="panel panel-inverse" ng-controller="consultaDescricaoCtrl as consultaCtrl" ng-init="consultaCtrl.consulta = consulta" >
                <div class="panel-heading">
                    <div class="row">
                        <div ng-if="consulta.situacaoConsulta == 'ANDAMENTO' " class="col-xs-12 col-sm-8 col-md-5">
                            <select id="tipoatendmento" class="form-control" name="">
                                <option value="1">{{consultaCtrl.consulta.tipoConsulta.tipo}}</option>
                            </select>
                        </div>
                        <div ng-if="consulta.situacaoConsulta != 'ANDAMENTO' " class="col-xs-12 col-sm-2 col-md-2">
                            <h3 class="panel-title">{{consultaCtrl.consulta.tipoConsulta.tipo}}</h3> <!-- data-consulta -->
                        </div>
                        <div class="col-xs-12 col-sm-2 col-md-2">
                            <h3 class="panel-title">{{consultaCtrl.consulta.dia}}</h3> <!-- data-consulta -->
                        </div>
                    </div>
                </div>
                <div class="panel-body" >
                    <div class="btn-group m-t-20 form-control">
                        Documentos:
                        <span ng-repeat="documento in consulta.documentos" >
                            <a href="" class="btn btn-lg btn-default" ng-click="consultaCtrl.abrirDocumento(documento.id)" >
                                <i ng-class="{'fa fa-lg': true, 'fa-file-powerpoint-o': documento.tipoDocumento.id == 1, 'fa-file-o': documento.tipoDocumento.id == 2}"></i>
                            </a>
                        </span>
                    </div>
                    <span >Descrição</span>
                    <textarea ng-if="consultaCtrl.consulta.situacaoConsulta == 'ANDAMENTO' " class="form-control" rows="9" id="prontuario"
                              ng-model="consultaCtrl.consulta.descricao" ng-readonly="!consultaCtrl.openInfoDescricao" ></textarea>

                    <div ng-if="consulta.situacaoConsulta == 'ANDAMENTO' " class="pull-right hidden-print">
                        <a id="atd_btn_salvarprontuario" href="" ng-click="consultaCtrl.salvarDescricaoProntuario();" ng-show="consultaCtrl.openInfoDescricao" class="btn btn-lg btn-default m-b-10" data-toggle="modal">Salvar</a>
                        <a id="atd_btn_cancelarprontuario" href="" ng-click="consultaCtrl.cancelEditDescricao()" ng-show="consultaCtrl.openInfoDescricao" class="btn btn-lg btn-default m-b-10" data-toggle="modal">Cancelar</a>
                        <a id="atd_btn_editarprontuario" href="" ng-click="consultaCtrl.openEditDescricao()" ng-show="!consultaCtrl.openInfoDescricao" class="btn btn-lg btn-default m-b-10" data-toggle="modal">Alterar</a>
                    </div>

                    <p ng-if="consultaCtrl.consulta.situacaoConsulta != 'ANDAMENTO' " class="form-control" >{{consulta.descricao}}</p>
                </div>
            </div>
        </div> <!-- Prontuário ativo -->

        <div class="panel-group" id="accordion"></div> <!-- End Accordions -->
    </div>
</div>