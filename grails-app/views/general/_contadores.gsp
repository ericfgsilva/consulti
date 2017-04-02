<div class="col-xs-12 col-sm-1 col-md-1" ng-controller="contadoresCtrl as contadoresCtrl"
     ng-init="contadoresCtrl.update()" >
    <div id="atd_lb_atendidos" class="widget-consulti widget-stats bg-consulti">
        <div class="stats-info text-center">
            <div class="title bg-consulti-darker">Atendidos</div>
            <p>{{contadoresCtrl.consultados}}</p>
        </div>
    </div><!--end Atendidos-->
    <div id="atd_lb_atender" class="widget-consulti widget-stats bg-consulti">
        <div class="stats-info text-center">
            <div class="title bg-consulti-darker">Atender</div>
            <p>{{contadoresCtrl.agendados}}</p>
        </div>
    </div><!--end Atender-->
</div><!--status do dia-->