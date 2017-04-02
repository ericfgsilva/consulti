// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('config');

// Iniciar módulo
var app = angular.module("config", []);

app.factory("configService", ['$modal', function ($modal) {
	return {
		path: function() {
			return $('#config').data('resource');
		}
	};
}]);