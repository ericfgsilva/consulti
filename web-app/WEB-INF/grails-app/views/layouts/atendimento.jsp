<html>
    <head>
        <script src="${pageContext.request.contextPath}/resources/javascript/jquery-1.9.1.js"></script>
        <script src="${pageContext.request.contextPath}/resources/javascript/jquery-ui.js"></script>
        <script src="${pageContext.request.contextPath}/resources/javascript/jquery.ui.datepicker-pt-BR.js"></script>
        <script>
            var listConsultas;
            var arrayJSON;
            var startConsulta;

            $(function() {
                var today = $.datepicker.formatDate('dd/mm/yy', new Date());
                getConsultasIdToday(today, true);
            });

            var refreshAtendimento = function refreshAtendimento() {
                var todayRefresh = $.datepicker.formatDate('dd/mm/yy', new Date());
                getConsultasIdToday(todayRefresh, true);
            }

            function getConsultasIdToday(data, isRefresh) {
                $.ajax({
                    type: 'GET',
                    url: "${pageContext.request.contextPath}/sis/atendimento/getConsultasById?data=" + data,
                    context: document.body,
                    responseType: 'json',
                    contentType: "application/json; charset=utf-8",
                    success: function(data) {
                        arrayJSON = $.parseJSON(data);
                        listConsultas = [];
                        $('#menuAtendimento input[type="text"]').val('');

                        $.each(arrayJSON, function(i, obj) {
                            listConsultas.push(obj.id);
                        });

                        if (isRefresh) {
                            if (listConsultas.length > 0) {
                                startConsulta = listConsultas[0];
                                updateMenu(startConsulta);
                            }
                        }
                    },
                    error: function(xhr, ajaxOptions, thrownError) {
                        alert(xhr.status + ' - ' + thrownError);
                    }
                });
            }

            function updateJSONObject(obj) {
                $("#AtendOrdemChegada").val(obj.ordemChegada);
                $("#AtendDiaHora").val(obj.dia + ' ' + obj.horaChegada);
                $("#AtendPaciente").val(obj.paciente);
                $("#AtendTipoConsulta").val(obj.tipoConsulta);
                $("#AtendPlano").val(obj.planoSaude);
                $("#AtendSituacao").val(obj.situacaoConsulta);

                if (obj.preferencial == 'N') {
                    $("#AtendPreferencial").val("Não");
                } else {
                    $("#AtendPreferencial").val("Sim");
                }

                if (obj.ordemChegada == '') {
                    $("#AtendComparecimento").val("Não comparereceu");
                } else {
                    $("#AtendComparecimento").val("Compareceu");
                }
            }

            function updateMenu(id) {
                $.ajax({
                    type: 'GET',
                    url: "${pageContext.request.contextPath}/sis/atendimento/getConsultaInfoById?id=" + id,
                    context: document.body,
                    responseType: 'json',
                    contentType: "application/json; charset=utf-8",
                    success: function(data) {
                        var obj = $.parseJSON(data);
                        updateJSONObject(obj);
                    },
                    error: function(xhr, ajaxOptions, thrownError) {
                        alert(xhr.status + ' - ' + thrownError);
                    }
                });
            }

            function nextId() {

                var index = listConsultas.indexOf(startConsulta);

                index++;

                if (index >= listConsultas.length)
                    index = 0;

                startConsulta = listConsultas[index];
                updateMenu(startConsulta);
            }

            function prevId() {
                var index = listConsultas.indexOf(startConsulta);
                index--;
                if (index < 0)
                    index = listConsultas.length - 1;

                startConsulta = listConsultas[index];
                updateMenu(startConsulta);
            }

            function compareceu() {
                if (startConsulta == null || startConsulta == '') {
                    return false;
                }

                $.ajax({
                    type: 'GET',
                    url: "${pageContext.request.contextPath}/sis/atendimento/compareceu?id=" + startConsulta,
                    context: document.body,
                    responseType: 'json',
                    contentType: "application/json; charset=utf-8",
                    success: function(data) {
                        updateMenu(startConsulta);
                    },
                    error: function(xhr, ajaxOptions, thrownError) {
                        alert(xhr.status + ' - ' + thrownError);
                    }
                });
            }

            function atender() {
                if (startConsulta == null || startConsulta == '') {
                    return false;
                }

                location.href = "${pageContext.request.contextPath}/sis/atendimento/execute?id=" + startConsulta;

            }

            addFunction(refreshAtendimento);
        </script>
    </head>
    <body>
        <div class="section group bar">
            Próximo Paciente do dia            
            <button class="btnduvida" onClick="window.open('${pageContext.request.contextPath}/resources/ajuda/ajuda.html#atender_paciente', '_blank', 'toolbar=0,location=0,menubar=0')" >?</button>
            <button class="refresh" onClick="executeFunctions()" />
        </div>
        <button class="buttonStyle fleft" onclick="prevId()" > < Anterior</button>
        <button class="buttonStyle fright" onclick="nextId()" > Próximo ></button>
        <table width="100%" id="menuAtendimento" >
            <tr><td><label>Ordem de Chegada:</label></td><td><input id="AtendOrdemChegada" readOnly type="text" class="input" value="" /></td></tr>
            <tr><td><label>Dia/Hora:</label></td><td><input id="AtendDiaHora" readOnly type="text" class="input" value="" /></td></tr>
            <tr><td><label>Paciente:</label></td><td><input id="AtendPaciente" readOnly type="text" class="input" value="" /><td></tr>
            <tr><td><label>Situação:</label></td><td><input id="AtendSituacao" readOnly type="text" class="input" value="" /><td></tr>
            <tr><td><label>Tipo:</label></td><td><input id="AtendTipoConsulta" readOnly type="text" class="input" value="" /></td></tr>
            <tr><td><label>Plano:</label></td><td><input id="AtendPlano" readOnly type="text" class="input" value="" /></td></tr>
            <tr><td><label>Preferencial:</label></td><td><input id="AtendPreferencial" readOnly type="text" class="input" value="" /></td></tr>
            <tr><td><label>Comparecimento:</label></td><td><input id="AtendComparecimento" readOnly type="text" class="input" value="" /></td></tr>
        </table>
        <div align="center">
            <sec:authorize access="hasRole('ROLE_DOCTOR')">
                <input type="button" class="buttonStyle" onclick="atender()" value="Atender" />
            </sec:authorize>
            <input type="button" class="buttonStyle" onclick="compareceu()" value="Compareceu" />
        </div>
    </body>
</html>
