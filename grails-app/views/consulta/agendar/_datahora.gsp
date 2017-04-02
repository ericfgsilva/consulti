Selecionar a data e hora que os médicos estarão disponíveis para o atendimento
<div ng-controller="controllerTimer">
    <div class="col-md-6">
        <p class="input-group" style="transform:translateY(80%);">
            <input type="text" class="form-control" datepicker-popup="dd/MM/yyyy" ng-model="consulta.datahora" is-open="opened" ng-required="true" close-text="Close" />
            <span class="input-group-btn">
                <button type="button" class="btn btn-default" ng-click="open($event)"><i class="fa fa-calendar"></i></button>
            </span>
        </p>
    </div>
    <div class="col-md-6">
        <timepicker ng-model="consulta.datahora" hour-step="hstep" minute-step="mstep" show-meridian="false"></timepicker>
    </div>
</div>