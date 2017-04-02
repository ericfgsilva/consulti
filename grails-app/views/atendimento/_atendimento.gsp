<div class="col-xs-12 col-sm-6 col-md-6">
    <div class="panel panel-inverse">
        <div class="panel-heading">
            <h4 class="panel-title">Paciente em Atendimento</h4>
        </div>
        <div class="panel-body">

            <!-- begin invoice -->
            <div class="invoice">
                <g:render template="execucao/menu_paciente" />
                <div class="tab-content p-0">

                    <div class="tab-pane fade active in" id="paciente">
                        <g:render template="execucao/info_paciente" />
                    </div><!-- end paciente -->
                    <g:render template="./atestado/formulario" />
                    <g:render template="./prescricao/formulario" />

                </div><!-- end tab-content -->

            </div>
            <!-- end invoice -->

        </div>
    </div>

</div><!-- paciente em atendimento -->

<div class="col-xs-12 col-sm-6 col-md-6">
    <g:render template="./prontuario/formulario" />
</div>
<!-- End Prontuarios -->