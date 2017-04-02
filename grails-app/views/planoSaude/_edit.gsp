<!-- Modal-novo-edit-Plano -->
<div class="modal_content" id="modal-novo-edit-plano">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header m-b-0">
                <h4 class="modal-title">Editar Plano de Saúde</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div id="cad-plan" class="modal-body">

                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="nome">*Nome:</label>
                                <input data-selenium="gerPlan_editPlan_nome" type="text" class="form-control" id="nome" name="nome" required="" placeholder="Nome" ng-model="plano.nome">
                                <p ng-show="form.nome.$invalid && !form.nome.$pristine" class="text-danger">O campo Nome precisa ser preenchido.</p>
                            </div>

                            <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="num-ans">*Nº Registro ANS:</label>
                                <input data-selenium="gerPlan_editPlan_numAns" type="text" class="form-control" id="num-ans" name="numeroANS" required="" placeholder="Número do Registro ANS" ng-pattern="/^\d+$/" ng-model="plano.registroANS" >
                                <p ng-show="form.numeroANS.$invalid && !form.numeroANS.$pristine" class="text-danger">O campo Registro ANS aceita apenas números.</p>
                            </div>
                        </div> 
                        
                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                <label for="tel-cont">*Contato:</label>
                                <input data-selenium="gerPlan_editPlan_tel" type="tel" class="form-control" id="tel-cont" name="contato" ng-model="plano.contato" >
                            </div>
                        </div>  

                        <div class="row">
                            <div class="form-group col-xs-12 col-sm-12 col-md-12">
                                <textarea data-selenium="gerPlan_editPlan_descricao" class="form-control" id="descricao-plano" rows="4" Placeholder="Escreva uma Descrição." ng-model="plano.descricao" ></textarea>
                            </div>
                        </div>  

                    </div>

                    <div class="modal-footer">
                        <a data-selenium="gerPlan_editPlan_btnCancelar" href="" ng-click="close()" class="btn btn-md btn-default modal-cancelar-plano" data-toggle="modal">Cancelar</a>
                        <a data-selenium="gerPlan_editPlan_btnSalvar" href="" ng-click="save()" class="btn btn-md btn-default modal-editar-plano" ng-disabled="form.$invalid" data-toggle="modal">Salvar</a>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<!-- End modal-novo-edit-Plano -->