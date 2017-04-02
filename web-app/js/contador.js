// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('contador');

// Iniciar módulo
var app = angular.module("contador", ['message', 'config', 'atendimentoRest']);

app.controller("contadoresCtrl", ['$scope', '$http', 'atendimentoService', function ($scope, $http, atendimentoService) {
    var instance = this;
    this.consultados = 0;
    this.agendados = 0;

    this.update = function() {
        atendimentoService.getContadores(function(data) {
            instance.consultados = data.consultados;
            instance.agendados = data.agendados;
        });

    };

    $scope.$on('updateContadoresController', function(event, data){
        instance.update();
    });

}]);