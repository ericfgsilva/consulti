<div class="invoice-header" >
    <div class="invoice-from" ng-controller="pacienteDescricaoCtrl as pacienteCtrl" >
        <address class="m-t-5 m-b-5">
            <p><strong>{{pacienteCtrl.paciente.nome}}</strong></p>
            <p>Plano: <span class="label label-default">{{ctrl.consultaEmAtendimento.planoSaude.nome}}</span></p>
            <p>Número da Carteira: <span class="label label-default">{{ctrl.consultaEmAtendimento.numeroCarteira}}</span></p>
            <p>Tipo da Consulta: <span class="label label-default">{{ctrl.consultaEmAtendimento.tipoConsulta.tipo}}</span></p>
            <p><small>*Consulta Realizada em</small> <strong class="f-s-12">{{ctrl.consultaEmAtendimento.dia}}</strong></p>
            <strong>Informações sobre o Paciente:</strong>
            <div class="m-b-10"></div>
        </address>
        <div class="form-group">
            <textarea id="txarea_info_paciente" class="form-control no-rounded-corner"
                      ng-model="pacienteCtrl.paciente.descricao" ng-readonly="!pacienteCtrl.openInfo" rows="10">
            </textarea>
        </div>
        <div class="form-group">
            <span class="pull-right hidden-print">
                <a href="" ng-click="pacienteCtrl.openEdit()" ng-show="!pacienteCtrl.openInfo" id="btn_editar_info_paciente" class="btn btn-lg btn-default m-b-10">Alterar</a>
                <a href="" ng-click="pacienteCtrl.salvarDescricao();" ng-show="pacienteCtrl.openInfo" class="btn btn-lg btn-default m-b-10">Salvar</a>
                <a href="" ng-click="pacienteCtrl.cancelEdit()" ng-show="pacienteCtrl.openInfo" id="btn_cancelar_info_paciente" class="btn btn-lg btn-default m-b-10">Cancelar</a>
            </span>
        </div>
    </div>

</div><!-- end invoice header -->