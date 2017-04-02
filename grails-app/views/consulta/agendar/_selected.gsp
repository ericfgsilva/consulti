Após selecionar um médico ou um plano, deverá aparecer uma opção para selecionar:
<ul>
    <li>Um médico, caso tenha sido escolhido um plano de saúde</li>
    <li>Um plano de Saúde, caso tenha sido escolhido um médico. Além disso, a opção de
    consulta particular deverá estar explicitada</li>
</ul>

<span ng-if="consulta.medico" >
    Selecionar os planos de Saúde para <strong>{{consulta.medico.username}}</strong>
</span>
<span ng-if="consulta.plano" >
    Selecionar os médicos para <strong>{{consulta.plano.nome}}</strong>
</span>
<hr/>
<div id="ultimas-consultas" ng-repeat="item in listForSelect" >

    <div class="iffyTip col-sm-4 ui-sortable" id="atd_card_paciente_{{item.id}}" name="{{item.id}}" >
        <div class="widget widget-stats bg-consulti info-paciente-consulta">
            <div class="stats-info infos-paciente">
                <span ng-if="consulta.medico" >
                    <h4>{{item.nome}}</h4>
                    <h4>{{item.contato}}</h4>
                </span>
                <span ng-if="consulta.plano" >
                    <h4>{{item.username}}</h4>
                </span>
                <div class="stats-link">
                    <a id="atd_btn_card_atenderagora" href="#modal-atender-agora" data-toggle="modal" ng-click="selectEntityByStep2(item)">Selecionar&nbsp;<i class="fa fa-arrow-circle-o-right"></i></a>
                </div>
            </div>
        </div>
    </div>

</div>