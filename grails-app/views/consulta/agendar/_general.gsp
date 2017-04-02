Informações gerais da consulta: Nesse caso, selecionar o tipo de consulta e outra
informações, como descrição ou alguma informação relevante.
<hr/>
<ul class="media-list">
    <li class="media">
        <div class="media-body">
            <h4 class="media-heading"><i class="fa fa-1x fa-user-md"></i> Médico: {{consulta.medico.username}}</h4>
        </div>
    </li>
    <li class="media">
        <div class="media-body">
            <h4 class="media-heading"><i class="fa fa-1x fa-credit-card"></i> Plano de Saúde: {{consulta.plano.nome}}</h4>
            <p>{{consulta.plano.descricao}}</p>
            <p>{{consulta.plano.registroANS}}</p>
            <p>{{consulta.plano.contato}}</p>
        </div>
    </li>
    <li class="media">
        <div class="media-body">
            <h4 class="media-heading"><i class="fa fa-1x fa-clock-o"></i> Data e Hora da Consulta</h4>
            {{consulta.datahora | date:'dd/MM/yyyy'}} {{consulta.datahora | date:'HH:mm'}}
        </div>
    </li>
    <li class="media">
        <div class="media-body">
            <h4 class="media-heading"><i class="fa fa-1x fa-tags"></i> Tipo da Consulta:</h4>
            <div class="form-group">
                <label >Selecione o tipo da Consulta:</label>
                <select class="form-control" ng-model="consulta.tipoConsulta"
                        ng-options="tipoConsulta.tipo for tipoConsulta in tipoConsultaList track by tipoConsulta.id"></select>
            </div>
        </div>
    </li>
</ul>