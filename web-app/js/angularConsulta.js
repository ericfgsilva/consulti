// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('consulta');

// Iniciar módulo
var app = angular.module("consulta", ["crudConsulTI", "message", "config"]);

/**
 * Modal create Paciente
 */
var agendarConsultaCtrl = function ($rootScope, messageService, configService, $scope, $modalInstance, $http, $filter, paciente, callback) {
	$scope.associaPlano = {};
	$scope.callback = callback;
	$scope.planoTypeAhead = null;
	$scope.planoTypeAheadList = [];
    $scope.tipoConsultaList = [];
    $scope.selectedResult = null; // utilizado no resumo; Step1
    $scope.consulta = {};
    $scope.consulta.datahora = new Date();
	$scope.consulta.paciente = paciente;
	$scope.currentStep = 0;
	$scope.activeStep = 'search';

	/*
	usado no caso 0 - não possui paciente
	 */
	$scope.pacienteTypeAhead = null;
	$scope.pacienteTypeAheadList = [];

    /*
    SELECT
     */
    $scope.listForSelect = [];
    $scope.selectedId = null; // utilizado no resumo

	/*
	 São 4 passos
	 0 - Filtro e consulta de pacientes
	 1 - Filtro e consulta da entidade
	 2 - selecionar o outro componente (médico ou plano)
	 3 - Selecionar a data e hora
	 4 - Gerais
	 5 - Resumo
	 */
	if ($scope.consulta.paciente == null) {
		$scope.currentStep = 0;
		$scope.activeStep = 'searchPaciente';
	} else {
		$scope.currentStep = 1;
		$scope.activeStep = 'search';
	}


    $http.get(configService.path() + "/tipoConsulta/list").success(function(json) {
        $scope.tipoConsultaList = json;
    });

	/*
	PASSO 1
	 */
	if (paciente != null) {
		$http.get(configService.path() + "/consulta/listPlanoSaudeAndUser?param=" + paciente).success(function(json) {
			$scope.planoTypeAheadList = json;
		});
	} else {
		$http.get(configService.path() + "/paciente/list").success(function(json) {
			$scope.pacienteTypeAheadList = json;
		});
	}


	$scope.selectPaciente = function (pacienteTypeAhead) {
		$scope.consulta.paciente = pacienteTypeAhead.id;
	};

	$scope.selectEntity = function (planoTypeAhead) {
		$scope.planoTypeAhead = planoTypeAhead;
	};

	$scope.$watch('planoTypeAhead', function(newValue, oldValue) {
		if(newValue && newValue.id) {
            $scope.consulta.plano = null;
            $scope.consulta.medico = null;

			if(newValue.tipo == 'plano') {
				$http.get(configService.path() + "/planoSaude/show/" + newValue.id).success(function(json) {
                    $scope.consulta.plano = json;
				});
			} else {
				$http.get(configService.path() + "/user/show/" + newValue.id).success(function(json) {
                    $scope.consulta.medico = json;
				});
			}
		}
	}, true);
	/*
	 PASSO 1 - FIM
	 */
    /*
     PASSO 2
     */
    $scope.selectEntityByStep2 = function(item) {
        if ($scope.consulta.medico) {
            $scope.consulta.plano = item;
        } else {
            $scope.consulta.medico = item;
        }
        $scope.nextStep();
    };
    /*
     PASSO 2 - FIM
     */
    $scope.showNextButton = function(activeStep) {
        return  (activeStep ==='datahora' || activeStep ==='general');
    };

    $scope.initSelectCase = function () {
        if ($scope.consulta.medico) {
            /*
            Para usuarios, pesquisar lista de planos de Saúde
             */
            $http.get(configService.path() + "/planoSaude/listByPaciente/" + paciente).success(function(json) {
                $scope.listForSelect = json;
            });
        } else {
            /*
             Para planos de saúde, pesquisar lista de usuários
             */
            $http.get(configService.path() + "/user/listMedics").success(function(json) {
                $scope.listForSelect = json;
            });
        }
    };

	$scope.initPlanoCase = function () {
		$http.get(configService.path() + "/consulta/listPlanoSaudeAndUser?param=" + $scope.consulta.paciente).success(function(json) {
			$scope.planoTypeAheadList = json;
		});
	};

	/*
	 PASSO 1
	 */
	$scope.nextStep = function () {
		$scope.currentStep++;

		switch ($scope.currentStep) {
			case 0:
				$scope.activeStep = 'seachPaciente';
				break;
			case 1:
				$scope.activeStep = 'search';
				$scope.initPlanoCase();
				break;
			case 2:
				$scope.activeStep = 'select';
                $scope.initSelectCase();
				break;
			case 3:
				$scope.activeStep = 'datahora';
				break;
			case 4:
				$scope.activeStep = 'general';
				break;
			case 5:
				$scope.activeStep = 'summary';
				break;
		}
	};
	/*
	 PASSO 1 - FIM
	 */

	/**
	 * fechar modal
	 */
	$scope.close = function () {
		$modalInstance.dismiss('cancel');
	};

    $scope.confirmar = function () {
        var date = $filter('date')($scope.consulta.datahora,'yyyy-MM-dd HH:mm');
        $scope.consulta.datahora = date;

        $http.post(configService.path() + "/consulta/agendar", $scope.consulta).success(function(data) {
			if ($scope.callback != null) {
				$scope.callback();
			}

			messageService.showMessage(data);
        });

		$rootScope.$broadcast("listEntityToController", {});
        $modalInstance.dismiss('cancel');
    };

};

app.controller("AgendarConsultaCtrl", ['$http', '$modal', '$filter', function ($http, $modal, $filter) {
	var instance = this;
	this.pacientes = [];

	this.agendar = function(callback, pacienteid) {
		var modalInstance = $modal.open({
			templateUrl : 'cadastroConsultaTemplate',
			controller : 'agendarConsultaCtrl',
            backdrop: 'static',
            keyboard: false,			
			size : 'md',
			resolve : {
				$http : function() {return $http;},
                $filter : function() {return $filter;},
				paciente : function() {return pacienteid;},
				callback : function() {return callback;}
			}
		});
	};

}]);