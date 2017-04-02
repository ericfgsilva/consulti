<!-- Modal-editar-Paciente -->
<div class="modal_content" id="modal-novo-paciente">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header m-b-1">
                <h4 class="modal-title">Agendando nova consulta médica</h4>
            </div>
            <div class="modal-body">
                <form name="form" >
                    <div class="invoice-company">
                        <ul class="nav nav-pills">

                            <li ng-class="{ 'active' : activeStep == 'searchPaciente' }">
                                <a href="#" disabled="disabled" class="btn btn-default" data-toggle="tab" style="width:80px">
                                    <i class="fa fa-2x fa-user"></i><span class="hidden-xs hidden-sm hidden-md"><br>Paciente</span>
                                </a>
                            </li>

                            <li ng-class="{ 'active' : activeStep == 'search' }">
                                <a href="#" disabled="disabled" class="btn btn-default" data-toggle="tab" style="width:80px">
                                    <i class="fa fa-2x fa-search"></i><span class="hidden-xs hidden-sm hidden-md"><br>Filtro</span>
                                </a>
                            </li>

                            <li ng-class="{ 'active' : activeStep == 'select' }" >
                                <a href="#" disabled="disabled" class="btn btn-default" data-toggle="tab" style="width:80px">
                                    <i class="fa fa-2x fa-user-md"></i><span class="hidden-xs hidden-sm hidden-md"><br>Selecionar</span>
                                </a>
                            </li>
                            <li ng-class="{ 'active' : activeStep == 'datahora' }" >
                                <a href="#" disabled="disabled" class="btn btn-default" data-toggle="tab" style="width:80px">
                                    <i class="fa fa-2x fa-calendar"></i><span class="hidden-xs hidden-sm hidden-md"><br>Data e Hora</span>
                                </a>
                            </li>
                            <li ng-class="{ 'active' : activeStep == 'general' }" >
                                <a href="#" disabled="disabled" class="btn btn-default" data-toggle="tab" style="width:80px">
                                    <i class="fa fa-2x fa-tags"></i><span class="hidden-xs hidden-sm hidden-md"><br>Gerais</span>
                                </a>
                            </li>
                            <li ng-class="{ 'active' : activeStep == 'summary' }" >
                                <a href="#" disabled="disabled" class="btn btn-default" data-toggle="tab" style="width:80px">
                                    <i class="fa fa-2x fa-check"></i><span class="hidden-xs hidden-sm hidden-md"><br>Confirmar</span>
                                </a>
                            </li>
                        </ul>
                    </div>

                    <div class="tab-content p-0">

                        <div ng-class="{ 'active' : activeStep == 'searchPaciente' }" class="tab-pane fade in" id="searchPaciente_tab">
                            <g:render template="/consulta/agendar/searchPaciente" />
                        </div>

                        <div ng-class="{ 'active' : activeStep == 'search' }" class="tab-pane fade in" id="search_tab">
                            <g:render template="/consulta/agendar/search" />
                        </div>

                        <div ng-class="{ 'active' : activeStep == 'select' }" class="tab-pane fade in" id="select_tab">
                            <g:render template="/consulta/agendar/selected" />
                        </div>

                        <div ng-class="{ 'active' : activeStep == 'datahora' }" class="tab-pane fade in" id="datahora_tab">
                            <g:render template="/consulta/agendar/datahora" />
                        </div>
                        <div ng-class="{ 'active' : activeStep == 'general' }" class="tab-pane fade in" id="general_tab">
                            <g:render template="/consulta/agendar/general" />
                        </div>
                        <div ng-class="{ 'active' : activeStep == 'summary' }" class="tab-pane fade in" id="resumo_tab">
                            <g:render template="/consulta/agendar/summary" />
                        </div>

                    </div><!-- end tab-content -->

                    <div class="modal-footer">
                        <a ng-show="(activeStep == 'searchPaciente')" ng-disabled="!pacienteTypeAhead.id" href="#" id="botao-buscar-paciente2"
                            class="btn btn-default" ng-click="nextStep()" >Selecionar</a>

                        <a ng-show="(activeStep == 'search')" ng-disabled="!planoTypeAhead.id"
                                data-selenium="gerPac_listPac_btnSearch" href="#" id="botao-buscar-paciente"
                            class="btn btn-default" ng-click="nextStep()" >Selecionar</a>

                        <a href="#" ng-show="showNextButton(activeStep)"
                           class="btn btn-default" ng-click="nextStep()" >Próximo</a>

                        <a ng-show="(activeStep == 'summary')"
                                ng-click="confirmar()" class="btn btn-md btn-default" >Confirmar</a>

                        <a ng-click="close()" class="btn btn-md btn-default" >Cancelar</a>
                    </div>
                    <!-- end modal footer -->

                </form>
            </div>
            <!-- end modal body -->

        </div>
        <!-- end modal-content -->
    </div>
    <!-- end modal-dialog -->
</div>
<!-- End modal-editar-Paciente -->
<script type="text/ng-template" id="listTemplate">
<a>
    <i class="fa fa-fw" ng-class="{ 'fa-user-md' : match.model.tipo == 'usuario', 'fa-credit-card' : match.model.tipo == 'plano' }" ></i>
    <span>{{match.label}}</span>
</a>
</script>