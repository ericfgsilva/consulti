// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('secretaria');

// Iniciar módulo
var app = angular.module("secretaria", ["crudConsulTI", "message", "config"]);

app.controller("secretariaCtrl", ['$scope', '$rootScope', '$http', '$modal', '$filter', 'configService', function ($scope, $rootScope, $http, $modal, $filter, configService) {
    var consultorio = this;
    this.dataConsulta = new Date();
    this.consultas = [];

    this.getConsultasByMedico = function() {
        var d = consultorio.dataConsulta.toLocaleDateString('pt-BR');
        $http.get(configService.path() + "/consulta/listGroupedByProntuario?dia=" + d).success(function(json) {
            consultorio.consultas = json;
        });
    };

    this.init = function () {
        consultorio.getConsultasByMedico();
    };

    $scope.$on('listEntityToController', function() {
        consultorio.getConsultasByMedico();
    });

}]);