<div class="col-md-6" ng-class="{ 'hide' : addDisponiveis == false }">
    <div class="row">                        
        <strong id="gerPac_vincPlan_nomePlano" >{{associaPlano.nome}}</strong>
    </div>
    <div class="row">
        <div class="form-group col-xs-8 col-sm-8 col-md-8">
            <label for="num-carteira">Número da Carteira:</label>
            <input data-selenium="gerPac_vincPlan_numCarteira" type="text" class="form-control" id="num-carteira" ng-model="associaPlano.numeroCarteira" placeholder="">
        </div>
        <div class="form-group col-xs-4 col-sm-4 col-md-4">
            <label for="vis">Via:</label>
            <input data-selenium="gerPac_vincPlan_viaCarteira" type="text" class="form-control" id="via" ng-model="associaPlano.via" placeholder="">
        </div>
    </div> 

    <div class="row" >
        <div class="form-group col-xs-12 col-sm-6 col-md-6" ng-controller="controllerTimer" >
            <label for="val-inicial">Validade Inicial:</label>
            <input type="text" data-selenium="gerPac_vincPlan_valInicCarteira" class="form-control" datepicker-popup="dd/MM/yyyy"
                   id="val-inicial" ng-model="associaPlano.dtValidadeInicio" is-open="opened" ng-required="true" close-text="Close" />
            <span class="input-group-btn">
                <button type="button" class="btn btn-default" ng-click="open($event)"><i class="fa fa-calendar"></i></button>
            </span>
        </div>

        <div class="form-group col-xs-12 col-sm-6 col-md-6" ng-controller="controllerTimer" >
            <label for="val-final">Validade Final:</label>

            <input type="text" data-selenium="gerPac_vincPlan_valFimCarteira" class="form-control" datepicker-popup="dd/MM/yyyy"
                   id="val-final" ng-model="associaPlano.dtValidadeFim" is-open="opened" ng-required="true" close-text="Close" />
            <span class="input-group-btn">
                <button type="button" class="btn btn-default" ng-click="open($event)"><i class="fa fa-calendar"></i></button>
            </span>
        </div>
    </div>

    <div class="row">
        <div class="form-group col-xs-12 col-sm-6 col-md-6">
            <label for="tipo">Tipo</label>
            <input name="gerPac_vincPlan_tipoPlanoCarteira" type="text" class="form-control" id="val-tipo" ng-model="associaPlano.tipo" placeholder="Superior, Empresarial, ...">
        </div>

        <div class="form-group col-xs-12 col-sm-6 col-md-6">
            <label for="acomodacao">Acomodação:</label>
            <input name="gerPac_vincPlan_acomodacaoPlanoCarteira" type="text" class="form-control" id="val-acomodacao" ng-model="associaPlano.acomodacao" placeholder="Apartamento, UTI, ...">
        </div>
    </div>
    <div class="row">
        <div class="form-group col-xs-12 col-sm-6 col-md-6">
            <a id="gerPac_vincPlan_btnVincularPlano" title="Vincular" ng-click="vincularPlanoSaude()" class="btn btn-md btn-default" >Vincular</a>
        </div>
        <div class="form-group col-xs-12 col-sm-6 col-md-6">
            <a id="gerPac_vincPlan_btnCancelar" title="Vincular" ng-click="closeFormularioPlano()" class="btn btn-md btn-default" >Cancelar</a>
        </div>

    </div>
</div>