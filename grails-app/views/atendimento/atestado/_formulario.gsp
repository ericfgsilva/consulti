<div class="tab-pane fade" id="atestado" ng-controller="gerarAtestadoCtrl as atestadoCtrl" >
    <div class="panel-body panel-form brasao">
        <form action="/" name="wysihtml5" method="POST">
            <textarea ng-model="atestadoCtrl.atestado" class="form-control height-sm brasao-med" placeholder="Escreva aqui!" rows="32"></textarea>

            <!-- footer-atestado-medico -->
            <div id="footer-medico" class="invoice-header">
                <div class="invoice-from">
                    <address class="m-t-5 m-b-5">
                        <strong>Nome do Médico</strong><br />
                        CRM - 000000/0000<br />
                        Real Hospital Português<br />
                        Telefone: (81) 456-7890<br />
                        www.rhp.com.br
                    </address>
                </div>
                <div class="invoice-date">
                    <div class="date m-t-5">01 Dezembro de 2014</div>
                    <div class="invoice-detail">
                        ID#0000123DSS<br />
                        QRCODE
                    </div>
                </div>
            </div>
            <!-- end footer-atestado-medico -->

            <div class="form-group m-t-20">
                <span class="pull-right hidden-print">
                    <a href="" ng-click="atestadoCtrl.gerarAtestado(ctrl.consultaEmAtendimento.consulta.id)" class="btn btn-lg btn-default">Salvar Atestado Médico</a>
                </span>
            </div>
        </form>
    </div>
</div><!-- end atestado -->