// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('pacienteRest');

// Iniciar módulo
var app = angular.module("pacienteRest", ['message', 'config']);

app.factory("pacienteService", ['$http', '$rootScope', 'configService', 'messageService', function ($http, $rootScope, configService, messageService) {
	var callback;

	/*
	 Method to connect with controller
	 */
	var setCallback = function(method) {
		callback = method;
	};

	var getPacienteById = function (id, callbackMethod) {
		$http.get(configService.path() + "/paciente/show/" + id).success(function(data) {
			callbackMethod(data);
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	var getConsultasProntuario = function (id, callbackMethod) {
		$http.get(configService.path() + "/paciente/consultasProntuario/" + id).success(function(data) {
			callbackMethod(data);
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	var list = function() {
		$http.get(configService.path() + "/paciente/list").success(function (data) {
			callback(data);
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	var show = function (object) {
		$http.post(configService.path() + "/paciente/show", object).success(function(data) {
			messageService.showMessage(data);
			list();
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	var update = function (object) {
		$http.post(configService.path() + "/paciente/update", object).success(function(data) {
			messageService.showMessage(data);
			list();
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	var save = function (object) {
		$http.post(configService.path() + "/paciente/save", object).success(function(data) {
			messageService.showMessage(data);
			list();
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	var salvarDescricao = function (id, descricao, callback) {
		var editar = {'id': id, 'descricao': descricao};
		$http.post(configService.path() + "/paciente/salvarDescricao", editar).success(function (data) {
			messageService.showMessage(data);
			if (callback != null) {
				callback(data);
			}
		});
	};

	var getPacienteById = function (id, callbackMethod) {
		$http.get(configService.path() + "/paciente/show/" + id).success(function(data) {
			callbackMethod(data);
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	return {
		setCallback : setCallback,
		salvarDescricao : salvarDescricao,
		getPacienteById : getPacienteById,
		getConsultasProntuario : getConsultasProntuario,
		list : list,
		show : show,
		update : update,
		save : save
	}
}]);