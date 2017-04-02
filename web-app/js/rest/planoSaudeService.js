// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('planoSaudeRest');

// Iniciar módulo
var app = angular.module("planoSaudeRest", ['message', 'config']);

app.factory("planoSaudeService", ['$http', '$rootScope', 'configService', 'messageService', function ($http, $rootScope, configService, messageService) {
	var callback;

	/*
	 Method to connect with controller
	 */
	var setCallback = function(method) {
		callback = method;
	};

	var list = function() {
		$http.get(configService.path() + "/planoSaude/list").success(function (data) {
			callback(data);
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	var getPlanoSaudeById = function (id, callbackMethod) {
		$http.get(configService.path() + "/planoSaude/show/" + id).success(function(data) {
			callbackMethod(data);
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	var remove = function (objects, callBackYes) {
		$http.delete(configService.path() + "/planoSaude/remove", {params: {lista: objects}} ).success(function(data) {
			messageService.showMessage(data);
			list();
			callBackYes();
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	var update = function (object) {
		$http.post(configService.path() + "/planoSaude/update", object).success(function(data) {
			messageService.showMessage(data);
			list();
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};

	var save = function (object) {
		$http.post(configService.path() + "/planoSaude/save", object).success(function(data) {
			messageService.showMessage(data);
			list();
		}).error(function(data) {
			messageService.showMessageError(data);
		});
	};


	return {
		setCallback : setCallback,
		list : list,
		getPlanoSaudeById : getPlanoSaudeById,
		remove : remove,
		update : update,
		save : save
	}
}]);