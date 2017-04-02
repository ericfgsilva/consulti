<div class="col-xs-12 col-sm-10 col-md-10"  >

    <div class="row"  >

        <div id="ultimas-consultas" ng-repeat="appointment in ctrl.firstConsultas()" >

            <div class="col-md-3 col-sm-4 ui-sortable" id="atd_card_paciente_{{appointment.id}}"
                 name="{{appointment.id}}" aria-disabled="false" ng-model="appointment"
                 data-drag="true" data-jqyoui-options="{revert: 'invalid'}"
                 jqyoui-draggable="{index: {{$index}},animate:true, onStart:'ctrl.registerDraggedItem(appointment)'}"
                 ng-hide="!appointment.id" >
                <div class="widget widget-stats bg-consulti info-paciente-consulta">
                    <div class="stats-info infos-paciente">
                        <h4>{{appointment.prontuario.paciente.nome}}</h4>
                        <h4>{{appointment.prontuario.paciente.telefone}}</h4>
                        <h4>{{ (appointment.planoSaude.nome) ? appointment.planoSaude.nome : 'Particular' }}</h4>
                        <h4>{{appointment.numeroCarteira}}</h4>
                        <h4>{{appointment.horaChegada}} às {{appointment.horaSaida}}</h4>
                        <div class="stats-link">
                            <a id="atd_btn_card_atenderagora" href="" ng-click="ctrl.atenderAgora(appointment)">Atender Agora&nbsp;<i class="fa fa-arrow-circle-o-right"></i></a>
                        </div>
                    </div>
                </div><!--end info-paciente-consulta-->
            </div>

        </div><!--end ultimas-consultas-->

    </div>
</div>

<div class="col-md-1 col-sm-6 hidden-xs hidden-sm ui-sortable">
    <div class="widget-consulti widget-stats bg-consulti">
        <div class="stats-info text-center">
            <div id="bt-all-consultas" class="title"><a href="javascript:;" title="Visualizar Todas as Consultas"><i class="fa fa-3x fa-expand"></i></a></div>
            <div id="bt-off-consultas" class="title"><a href="javascript:;" title="Ocultar Todas as Consultas"><i class="fa fa-3x fa-compress"></i></a></div>
        </div>
    </div><!--end Atendidos-->
</div>
<div id="todas-consultas">
    <div class="row p-l-10 p-r-10">
        <div class="col-xs-12 col-sm-12 col-md-12">
            <div>
                <div class="row">
                    <div class="col-md-4 hidden-xs hidden-sm"></div>
                    <div class="col-md-3 ui-sortable">
                        <div class="input-group">
                            <input type="text" id="txt_busca_consulta" class="form-control" ng-model="query" placeholder="Pesquisar Consulta">
                            <div class="input-group-btn">
                                <button type="button" disabled class="btn btn-default">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 hidden-xs hidden-sm"></div>
                </div>
            </div>
        </div>
    </div>

    <div class="height-500" data-scrollbar="true">
        <div class="row p-l-10 p-r-10"  >
            <div class="col-md-2 col-sm-4 ui-sortable" ng-repeat="appointment in ctrl.afterFirstConsultas() | filter:query">
                <div class="widget widget-stats bg-consulti info-paciente-consulta" id="{{appointment.id}}" name="{{appointment.id}}"
                     aria-disabled="false" ng-model="appointment" data-drag="true" data-jqyoui-options="{revert: 'invalid'}"
                     jqyoui-draggable="{index: {{$index}},animate:true, onStart:'ctrl.registerDraggedItem(appointment)'}"
                     ng-hide="!appointment.id" >
                    <div class="stats-info infos-paciente">
                        <h4>{{appointment.prontuario.paciente.nome}}</h4>
                        <h4>{{appointment.prontuario.paciente.telefone}}</h4>
                        <h4>{{ (appointment.planoSaude.nome) ? appointment.planoSaude.nome : 'Particular' }}</h4>
                        <h4>{{appointment.numeroCarteira}}</h4>
                        <h4>{{appointment.horaChegada}} às {{appointment.horaSaida}}</h4>
                        <div class="stats-link">
                            <a href="" ng-click="ctrl.atenderAgora(appointment)">Atender Agora&nbsp;<i class="fa fa-arrow-circle-o-right"></i></a>
                        </div>
                    </div>
                </div><!--end info-paciente-consulta-->
            </div>
        </div>
    </div>


</div>
<!-- end Todas as Consultas -->