<div class="table-responsive">
    <table class="pacientes_table table table-striped table-hover" >
        <tr>
            <th colspan="7">
                <div class="col-md-12">
                    <div class="form-group has-feedback">
                        <label class="control-label" for="searchBox">Buscar medico ou Plano de Saude</label>
                        <input type="text" class="form-control" id="searchBox" aria-describedby="inputSuccess2Status"
                               ng-model="planoTypeAhead" data-selenium="gerPac_listPac_txtbxSearch"
                               typeahead="plano as plano.nome for plano in planoTypeAheadList | filter:$viewValue"
                               typeahead-template-url="listTemplate" typeahead-on-select="selectEntity(planoTypeAhead)">
                        <span ng-show="planoTypeAhead.id" class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                    </div>
                </div>

                <div class="col-md-3">&nbsp;</div>
            </th>
        </tr>
    </table>
</div><!-- end Table-responsive -->