// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('tipoConsulta');

// Iniciar módulo
var app = angular.module("tipoConsulta", ["config"]);

app.controller("TipoConsultaIndex", ['$http', 'configService', function($http, configService) {
        var instance = this;
		this.tiposConsulta = [];
		this.tipoConsulta = {};
		this.editTipoConsulta = {};
		
		this.getTiposConsulta = function() {
            $http.get(configService.path() + "/rest/tipoconsulta/list").success(function(json) {
                instance.tiposConsulta = json;
            });
        };
		
		this.addTipoConsulta = function() {
            $http.post(configService.path() + "/rest/tipoconsulta/add", instance.tipoConsulta).success(function() {
                instance.getTiposConsulta();
            });
        };
		
		this.removeTipoConsulta = function(id) {
            $http.get(configService.path() + "/rest/tipoconsulta/remove?id=" + id).success(function() {
                instance.getTiposConsulta();
            });
        };
		
		this.getTipoConsulta = function(id) {
            $http.get(configService.path() + "/rest/tipoconsulta/show/" + id).success(function(json) {
                instance.editTipoConsulta = json;
            });
        };
		
		this.updateTipoConsulta = function() {
            $http.put(configService.path() + "/rest/tipoconsulta/update", instance.editTipoConsulta).success(function() {
                instance.getTiposConsulta();
            });
        };
}]);