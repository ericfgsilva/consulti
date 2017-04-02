// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('documentoRest');

// Iniciar módulo
var app = angular.module("documentoRest", []);

var documentoController = function ($scope, $modalInstance, message) {
	$scope.message = message;

	/**
	 * fechar modal
	 */
	$scope.close = function () {
		$modalInstance.dismiss('cancel');
	};
};

app.factory("documentService", ['$http', '$modal', 'configService', 'messageService', function ($http, $modal, configService, messageService) {

	var abrirDocumento = function (id) {
		$http.get(configService.path() + "/consulta/showDocumento/" + id).success(function(data) {
			var modalInstance = $modal.open({
				templateUrl : 'documentoTemplate',
				controller : 'documentoController',
				size : 'md',
				resolve : {
					message : function() {return data.texto;}
				}
			});
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	return {
		abrirDocumento : abrirDocumento
	};
}]);