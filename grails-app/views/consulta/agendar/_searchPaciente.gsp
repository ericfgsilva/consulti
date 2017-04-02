<div class="table-responsive">
    <table class="pacientes_table table table-striped table-hover" >
        <tr>
            <th colspan="7">
                <div class="col-md-12">
                    <div class="form-group has-feedback">
                        <label class="control-label" for="searchBox">Buscar paciente</label>
                        <input type="text" class="form-control" id="searchBox" aria-describedby="inputSuccess2Status"
                               ng-model="pacienteTypeAhead" typeahead="paciente as paciente.nome for paciente in pacienteTypeAheadList | filter:$viewValue"
                               typeahead-template-url="listTemplate" typeahead-on-select="selectPaciente(pacienteTypeAhead)">
                        <span ng-show="pacienteTypeAhead.id" class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                    </div>
                </div>

                <div class="col-md-3">&nbsp;</div>
            </th>
        </tr>
    </table>
</div><!-- end Table-responsive -->