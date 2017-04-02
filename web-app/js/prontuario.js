// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('prontuario');

// Iniciar módulo
var app = angular.module("prontuario", ['message', 'config', 'ngDragDrop', 'ui.bootstrap', 'consultaRest', 'pacienteRest', 'documentoRest']);

app.controller("prontuarioPacienteCtrl", ['$scope', '$http', '$q', '$modal', 'configService', 'messageService', 'atendimentoService', 'pacienteService', function ($scope, $http, $q, $modal, configService, messageService, atendimentoService, pacienteService) {
    var instance = this;
    this.paciente = {};
    this.pacienteId = null;

    this.init = function(pacienteId) {
        instance.pacienteId = pacienteId;
        pacienteService.getPacienteById(pacienteId, function (data) {
            instance.paciente = data;
        });
    };

    $scope.$on('listEntityToController', function(){
        instance.init(instance.pacienteId);
    });

}]);

app.controller("prontuarioConsultaCtrl", ['$http', '$q', '$modal', 'configService', 'messageService', 'atendimentoService', 'pacienteService', function ($http, $q, $modal, configService, messageService, atendimentoService, pacienteService) {
    var instance = this;
    this.consultas = [];

    this.init = function(pacienteId) {
        pacienteService.getConsultasProntuario(pacienteId, function (data) {
            instance.consultas = data;
        });
    };

    this.printTo = function (printSectionId) {
        var innerContents = document.getElementById(printSectionId).innerHTML;
        var popupWinindow = window.open('', '_blank', 'width=600,height=700,scrollbars=no,menubar=no,toolbar=no,location=no,status=no,titlebar=no');
        popupWinindow.document.open();
        popupWinindow.document.write('<html><head><link rel="stylesheet" type="text/css" href="style.css" /></head><body onload="window.print()">' + innerContents + '</html>');
        popupWinindow.document.close();
    };
}]);