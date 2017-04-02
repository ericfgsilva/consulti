// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('consultaRest');

// Iniciar módulo
var app = angular.module("consultaRest", ['message', 'config']);

app.factory("consultaService", ['$http', '$rootScope', 'configService', 'messageService', function ($http, $rootScope, configService, messageService) {
	var callback;

	/*
	 Method to connect with controller
	 */
	var setCallback = function(method) {
		callback = method;
	};

	var getConsultaById = function (id, callbackMethod) {
		$http.get(configService.path() + "/consulta/show/" + id).success(function(data) {
			callbackMethod(data);
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	var salvarDescricao = function (id, descricao, callback) {
		var editar = {'id': id, 'descricao': descricao};
		$http.post(configService.path() + "/consulta/saveDescricao", editar).success(function (data) {
			messageService.showMessage(data);
			if (callback != null) {
				callback(data);
			}
		});
	};

	var gerarPrescricao = function (id, texto, callback) {
		var editar = {'consulta': id, 'texto': texto};
		$http.post(configService.path() + "/consulta/savePrescricao", editar).success(function (data) {
			messageService.showMessage(data);
			if (callback != null) {
				callback(data);
			}
		});
	};

	var gerarAtestado = function (id, texto, callback) {
		var editar = {'consulta': id, 'texto': texto};
		$http.post(configService.path() + "/consulta/saveAtestado", editar).success(function (data) {
			messageService.showMessage(data);
			if (callback != null) {
				callback(data);
			}
		});
	};

	var abrirDocumento = function (id) {
		$http.get(configService.path() + "/consulta/showDocumento/" + id).success(function(data) {
			messageService.showMessage(data.texto);
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	return {
		setCallback : setCallback,
		getConsultaById : getConsultaById,
		salvarDescricao : salvarDescricao,
		gerarAtestado : gerarAtestado,
		gerarPrescricao : gerarPrescricao,
		abrirDocumento : abrirDocumento
	}
}]);