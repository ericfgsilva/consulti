<%@ page contentType="text/html;charset=UTF-8" %>
<script type="text/ng-template" id="protuarioModal">
	
		<div class="modal-content">
			<div class="modal-header">
				<button data-selenium="atend_modalProntuario_btnFechar" type="button" class="close" ng-click="close()" >&times;</button>
				<h4 data-selenium="atend_modalProntuario_labelTitle" class="modal-title" id="myModalLabel">
					Prontu&#225;rio do Paciente: <strong>{{nomePaciente}}</strong>
				</h4>
			</div>
			<div class="modal-body">
				<div class="panel-group" id="accordion" ng-repeat="consulta in listProntuario">

					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#collapse{{consulta.id}}">Consulta dia {{consulta.dia}}</a></h4>
						</div>
						<div id="collapse{{consulta.id}}"
							class="panel-collapse collapse">
							<div class="panel-body">
								<div class="col-lg-12">
									<div class="form-group col-lg-4">
										<label>Chegada</label><p class="form-control-static">{{consulta.horaChegada}}</p>
									</div>
									<div class="form-group col-lg-4">
										<label>Saida</label><p class="form-control-static">{{consulta.horaSaida}}</p>
									</div>
									<div class="form-group col-lg-4">
										<label>Tipo da Consulta</label><p class="form-control-static">{{consulta.tipoConsulta.tipo}}</p>
									</div>
								</div>
								<div class="col-lg-12">
									<div class="form-group col-lg-4">
										<label>Plano de Sa&#250;de</label><p class="form-control-static">{{consulta.planoSaude.nome}}</p>
									</div>
									<div class="form-group col-lg-4">
										<label>Situa&#231;&#227;o da Consulta</label><p class="form-control-static">{{consulta.situacaoConsulta}}</p>
									</div>
									<div class="form-group col-lg-4">
										<label>N&#176; da Carteira do Plano</label><p class="form-control-static">{{consulta.numeroCarteira}}</p>
									</div>
								</div>
								<sec:access expression="hasRole('ROLE_DOCTOR')">
								<div class="form-group">
									<label>Descri&#231;&#227;o</label>
									<p class="form-control-static">{{consulta.descricao}}</p>
								</div>
								</sec:access>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.modal-content -->
	
</script>