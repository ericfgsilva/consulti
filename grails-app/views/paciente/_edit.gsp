<!-- Modal-editar-Paciente -->
<div class="modal_content" id="modal-novo-paciente">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header m-b-1">
                <h4 class="modal-title">Editar Paciente</h4>
            </div>
            <div class="modal-body">

                    <div class="invoice-company">
                        <ul class="nav nav-pills">

                            <li class="active">
                                <a data-selenium="addPac_tabPac" href="#paciente_tab" class="btn btn-default" title="Dados Paciente" data-toggle="tab" style="width:80px">
                                    <i class="fa fa-2x fa-user"></i><span class="hidden-xs hidden-sm hidden-md"><br>Paciente</span>
                                </a>
                            </li>

                            <li>
                                <a data-selenium="addPac_tabPlano" href="#plano_tab" class="btn btn-default" title="Planos de Saúde" data-toggle="tab" style="width:80px">
                                    <i class="fa fa-2x fa-medkit"></i><span class="hidden-xs hidden-sm hidden-md"><br>Plano</span>
                                </a>
                            </li>
                        </ul>
                    </div>

                    <div class="tab-content p-0">

                        <!-- paciente -->
                        <div class="tab-pane fade active in" id="paciente_tab">
                        <form name="form" >
                            <div class="row">
                                <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                    <label for="nome">Nome<span>*</span>:</label>
                                    <input data-selenium="addPac_nomePac" type="text" class="form-control" id="nome" name="nome" required="" placeholder="Nome" ng-model="paciente.nome">
                                    <p id="addPac_msgNomePacVazio" ng-show="form.nome.$invalid && !form.nome.$pristine" class="text-danger">O campo Nome precisa ser preenchido.</p>
                                </div>

                                <div ng-controller="controllerTimer" class="form-group col-xs-12 col-sm-6 col-md-6">
                                    <label for="dtNascimento">Data de Nascimento<span>*</span>:</label>
                                    <input data-selenium="addPac_DtNascPac" type="text" class="form-control" id="dtNascimento" name="dtNascimento" required="" is-open="opened" ng-required="true" close-text="Close" datepicker-popup="dd/MM/yyyy" placeholder="00/00/0000" ng-model="paciente.dataNascimento" >
                                    <span class="input-group-btn">
                                        <button type="button" class="btn btn-default" ng-click="open($event)"><i class="fa fa-calendar"></i></button>
                                    </span>
                                    <p id="addPac_msgDtNasPacVazio" ng-show="form.dtNascimento.$invalid && !form.dtNascimento.$pristine" class="text-danger">O campo Data Nascimento precisa ser preenchido.</p>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                    <label for="cpf">CPF:</label>
                                    <input data-selenium="addPac_cpfPac" type="text" class="form-control" id="cpf" name="cpf" ng-maxlength="11" placeholder="999.999.999-99" ng-pattern="/^\d+$/" ng-model="paciente.cpf">
                                    <p id="addPac_msgCpfPacVazio" ng-show="form.cpf.$invalid && !form.cpf.$pristine" class="text-danger">O campo CPF precisa ser preenchido.</p>
                                    <p ng-show="form.cpf.$error.maxlength" class="text-danger">O campo CPF precisa ser menor que 11 caracteres.</p>
                                </div>

                                <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                    <label for="rg">RG:</label>

                                    <input data-selenium="addPac_rgPac" type="text" class="form-control" id="rg" name="rg" ng-maxlength="11" placeholder="9.999.999" ng-pattern="/^\d+$/" ng-model="paciente.rg">
                                    <p id="addPac_msgRgPacVazio" ng-show="form.rg.$invalid && !form.rg.$pristine" class="text-danger">O campo RG precisa ser preenchido.</p>
                                    <p ng-show="form.rg.$error.maxlength" class="text-danger">O campo RG precisa ser menor que 11 caracteres.</p>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                    <label for="tel-cont">Telefone<span>*</span>:</label>
                                    <input data-selenium="addPac_telPac" type="text" class="form-control" id="tel-cont" required="" name="tel-cont" placeholder="(00) 0000-0000" ng-model="paciente.telefone">
                                    <p id="addPac_msgTelPacVazio" ng-show="form.tel-cont.$invalid && !form.tel-cont.$pristine" class="text-danger">O campo Telefone precisa ser preenchido.</p>
                                </div>

                                <div class="form-group col-xs-12 col-sm-6 col-md-6">
                                    <label for="email-paciente">E-mail:</label>
                                    <input data-selenium="addPac_emailPac" type="text" class="form-control" id="email-paciente" name="email-paciente" placeholder="email@email.com" ng-model="paciente.email">
                                    <p id="addPac_msgEmailPacVazio" ng-show="form.email-paciente.$invalid && !form.email-paciente.$pristine" class="text-danger">O campo Email precisa ser preenchido.</p>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-xs-12 col-sm-12 col-md-12">
                                    <label for="endereco-paciente">Endereço:</label>
                                    <input data-selenium="addPac_enderecoPac" type="tex" class="form-control" id="endereco-paciente" name="endereco-paciente" placeholder="Av,Rua..." ng-model="paciente.endereco">
                                    <p id="addPac_msgEnderecoPacVazio" ng-show="form.endereco-paciente.$invalid && !form.endereco-paciente.$pristine" class="text-danger">O campo Endereço precisa ser preenchido.</p>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group col-xs-12 col-sm-12 col-md-12">
                                    <textarea data-selenium="addPac_descrPac" class="form-control" id="descricao-paciente" name="descricao-paciente" rows="4" Placeholder="Escreva uma Descrição." ng-model="paciente.descricao"></textarea>
                                    <p data-selenium="addPac_msgDescrPacVazio" ng-show="form.descricao-paciente.$invalid && !form.descricao-paciente.$pristine" class="text-danger">O campo Descrição precisa ser preenchido.</p>
                                </div>
                            </div>
                        </form>
                        </div>
                        <!-- end paciente -->

                        <div class="tab-pane fade" id="plano_tab">
                            <div class="row">
                                <div ng-class="{ 'col-md-6' : (addDisponiveis || editAssociados) == true, 'col-md-12' : (addDisponiveis || editAssociados) == false }">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="input-group-btn">
                                                <a data-selenium="addPac_btnAssociados" href="#associados_tab" data-toggle="tab" ng-click="closeFormularioPlano()" id="botao-planos-associados" class="btn btn-default">Associados</a>
                                                <a data-selenium="addPac_btnDisponiveis"href="#disponiveis_tab" data-toggle="tab" ng-click="closeFormularioPlano()" id="botao-planos-disponiveis" class="btn btn-default">Disponíveis</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-content p-0">

                                        <div class="tab-pane fade active in" id="associados_tab">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="input-group m-b-10">
                                                        <input data-selenium="addPac_campoBuscarPlanoAssociado" type="text" class="form-control" placeholder="Buscar Plano">
                                                        <div class="input-group-btn">
                                                            <a data-selenium="addPac_btnBuscarPlanoAssociado" href="#" id="botao-buscar-plano" class="btn btn-default"><i class="fa fa-search"></i></a>
                                                        </div>
                                                    </div>
                                                    <div class="scroll-div height-40per">
                                                    <table class="planos_table table table-striped table-hover">
                                                        <thead>
                                                        <tr>
                                                            <th>Planos</th>
                                                        </tr>
                                                        </thead>

                                                        <tbody class="f-s-10">
                                                        <tr data-selenium="addPac_linPlanoAssociado_{{plano.id}}" ng-repeat="plano in paciente.planosSaude | orderBy:'nome'" >
                                                            <td><span ng-click="openPanelForAssociados(plano);" style="cursor: pointer;" > {{plano.nome}} </span></td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="tab-pane fade" id="disponiveis_tab">
                                            <div class="row">
                                                <div>
                                                    <div class="input-group m-b-10">
                                                        <input data-selenium="addPac_campoBuscarPlanoDisponivel" type="text" class="form-control" placeholder="Buscar Plano">
                                                        <div class="input-group-btn">
                                                            <a data-selenium="addPac_btnBuscarPlanoDisponivel" href="#" id="botao-buscar-plano" class="btn btn-default"><i class="fa fa-search"></i></a>
                                                        </div>
                                                    </div>
                                                    <div class="scroll-div height-40per">
                                                    <table class="planos_table table table-striped table-hover">
                                                        <thead>
                                                        <tr>
                                                            <th>Planos</th>
                                                        </tr>
                                                        </thead>

                                                        <tbody class="f-s-10">
                                                        <tr data-selenium="addPac_linPlanoDisponivel_{{plano.id}}" ng-repeat="plano in disponiveis | orderBy:'nome'" >
                                                            <td ng-hide="plano.hide" > <span ng-click="openPanelForDisponiveis(plano);" style="cursor: pointer;" > {{plano.nome}} </span> </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                    </div>
                                                </div>
                                            </div>




                                        </div>
                                    </div>
                                </div>

                                <!-- VINCULAR E DESVINCULAR -->
                                <g:render template="vincular_plano" />
                                <g:render template="desvincular_plano" />


                            </div>
                        </div><!-- end plano -->

                    </div><!-- end tab-content -->

                    <div class="modal-footer">
                        <a data-selenium="addPac_btnCancelarAddPac" title="Cancelar Cadastro do Paciente" ng-click="close()" class="btn btn-md btn-default" >Cancelar</a>
                        <a data-selenium="addPac_btnSalvarAddPac" href="#" data-dismiss="modal" ng-click="save('Edição realizada com sucesso!');" ng-disabled="form.$invalid" title="Salvar Edição Paciente" class="btn btn-md btn-default" data-toggle="modal" data-dismiss="modal">Salvar</a>
                    </div>
                    <!-- end modal footer -->

            </div>
            <!-- end modal body -->

        </div>
        <!-- end modal-content -->
    </div>
    <!-- end modal-dialog -->
</div>
<!-- End modal-editar-Paciente -->