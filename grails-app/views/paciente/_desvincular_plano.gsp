<div class="col-md-6" ng-class="{ 'hide' : editAssociados == false }">
    <div class="row">                        
        <strong id="gerPac_desvinPlan_nomePlano">{{associaPlano.nome}}</strong>
    </div>
    <div class="row">
        <div class="form-group col-xs-8 col-sm-8 col-md-8">
            <label for="num-carteira">Número da Carteira:</label>
            <input data-selenium="gerPac_desvincPlan_numCarteira" type="text" class="form-control" id="num-carteira" ng-model="associaPlano.numeroCarteira" placeholder="">
        </div>
        <div class="form-group col-xs-4 col-sm-4 col-md-4">
            <label for="vis">Via:</label>
            <input data-selenium="gerPac_desvincPlan_viaCarteira" type="text" class="form-control" id="via" ng-model="associaPlano.via" placeholder="">
        </div>
    </div> 

    <div class="row">
        <div class="form-group col-xs-12 col-sm-6 col-md-6">
            <label for="val-inicial">Validade Inicial:</label>
            <input data-selenium="gerPac_desvincPlan_valInicCarteira" type="text" class="form-control" id="val-inicial" ng-model="associaPlano.dtValidadeInicio" placeholder="dd/mm/aaa">
        </div>

        <div class="form-group col-xs-12 col-sm-6 col-md-6">
            <label for="val-final">Validade Final:</label>
            <input data-selenium="gerPac_desvincPlan_valFimCarteira" type="text" class="form-control" id="val-final" ng-model="associaPlano.dtValidadeFim" placeholder="dd/mm/aaa">
        </div>
    </div>

    <div class="row">
        <div class="form-group col-xs-12 col-sm-6 col-md-6">
            <label for="tipo">Tipo</label>
            <input name="gerPac_desvincPlan_tipoPlanoCarteira" type="text" class="form-control" id="val-final" ng-model="associaPlano.tipo" placeholder="Superior, Empresarial, ...">
        </div>

        <div class="form-group col-xs-12 col-sm-6 col-md-6">
            <label for="acomodacao">Acomodação:</label>
            <input name="gerPac_desvincPlan_acomodacaoPlanoCarteira" type="text" class="form-control" id="val-final" ng-model="associaPlano.acomodacao" placeholder="Apartamento, UTI, ...">
        </div>
    </div>
    <div class="row">
        <div class="form-group col-xs-12 col-sm-6 col-md-6">
            <a id="gerPac_desvincPlan_btnDesvincularPlano" title="Vincular" ng-click="desvincularPlanoSaude()" class="btn btn-md btn-default" >Desvincular</a>
        </div>
        <div class="form-group col-xs-12 col-sm-6 col-md-6">
            <a id="gerPac_desvincPlan_btnCancelar" title="Vincular" ng-click="closeFormularioPlano()" class="btn btn-md btn-default" >Cancelar</a>
        </div>

    </div>
</div>