// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('atendimentoMedico');

// Iniciar módulo
var app = angular.module("atendimentoMedico", ['message', 'config', 'ngDragDrop', 'ui.bootstrap', 'consultaRest', 'pacienteRest', 'documentoRest']);

app.controller("atendimentoCtrl", ['$scope', '$rootScope', '$http', '$q', '$modal', 'configService', 'messageService', 'atendimentoService', 'pacienteService', function ($scope, $rootScope, $http, $q, $modal, configService, messageService, atendimentoService, pacienteService) {
    var instance = this;
    this.draggedItem = {};
    this.consultaEmAtendimento = {};

    this.init = function () {
        atendimentoService.initScope();
        instance.clearConsultaEmAtendimento();
    };

    this.clearConsultaEmAtendimento = function () {
        $rootScope.$broadcast("updateContadoresController", {});
        instance.consultaEmAtendimento.consulta = {};
        instance.consultaEmAtendimento.consultas = [];
        instance.consultaEmAtendimento.paciente = {};
    };

    this.firstConsultas = function() {
        return atendimentoService.getLista().firstConsultas;
    };

    this.afterFirstConsultas = function() {
        return atendimentoService.getLista().afterFirstConsultas;
    };

    /*
    Drag and drop
     */
    this.registerDraggedItem = function (event, ui, appointment){
        instance.draggedItem = appointment;
    };

    this.beforeDrop = function () {
        var appointment = instance.draggedItem;
        var deferred = $q.defer();
        instance.draggedItem = null; // reset
        instance.atenderAgora(appointment, deferred);
        return deferred.promise;
    };

    /*
    Atendimento
     */

    this.atenderAgora = function(appointment, deferred) {
        messageService.showConfirmationMessage('Tem certeza que deseja atender o paciente ' + appointment.prontuario.paciente.nome + '?',
            function() { // callback yes
                $('#btn_general_info').click(); // start on menu
                $rootScope.$broadcast("clearInfoController", {});

                if (deferred) {
                    deferred.resolve();
                }

                atendimentoService.iniciarConsulta(appointment.id, function (data) {
                    instance.consultaEmAtendimento = data;
                    $rootScope.$broadcast("setPacienteToController", instance.consultaEmAtendimento.paciente);
                });
            },
            function() { // callback no
                if (deferred) {
                    deferred.reject();
                }
            });
    };

    $scope.$on('updateProntuarioController', function(event, data){
        atendimentoService.refreshProntuario(instance.consultaEmAtendimento.consulta.id ,function(consultas) {
            instance.consultaEmAtendimento.consultas = consultas;
        });
    });

    this.encerrarConsulta = function() {
        messageService.showConfirmationMessage('Tem certeza que deseja finalizar essa consulta? ' +
            'Todas as informações serão salvas.?',
            function() {
                atendimentoService.encerrarConsulta(instance.consultaEmAtendimento.consulta.id,
                    function() {
                        instance.clearConsultaEmAtendimento()
                    });
            }, function() { });
    };

    this.consultaEmAtendimento = function () {
        return instance.consultaEmAtendimento.consulta;
    };

    this.historicoConsultas = function () {
        return instance.consultaEmAtendimento.consultas;
    };

    this.pacienteEmAtendimento = function () {
        return instance.consultaEmAtendimento.paciente;
    };

    this.isConsultaEmAtendimento = function () {
        var result = false;

        if (instance.consultaEmAtendimento.consulta.id) {
            result = true;
        }

        return result;
    };

}]);

app.controller("consultaDescricaoCtrl", ['$http', '$q', '$modal', 'configService', 'messageService', 'atendimentoService', 'consultaService', 'documentService', function ($http, $q, $modal, configService, messageService, atendimentoService, consultaService, documentService) {

    var instance = this;
    this.consulta = null;
    this.openInfoDescricao = false;

    this.openEditDescricao = function () {
        instance.openInfoDescricao = true;
    };

    this.cancelEditDescricao = function () {
        consultaService.getConsultaById(instance.consulta.id, function(data) {
            instance.consulta = data;
            instance.openInfoDescricao = false;
        });
    };

    this.salvarDescricaoProntuario = function () {
        var callbackMetodo = function (dataCallback) {

            consultaService.getConsultaById(instance.consulta.id, function(data) {
                instance.consulta = data;
                instance.openInfoDescricao = false;
            });
        };

        consultaService.salvarDescricao(instance.consulta.id, instance.consulta.descricao, callbackMetodo);
    };

    this.abrirDocumento = function (id) {
        documentService.abrirDocumento(id);
    };

}]);

app.controller("pacienteDescricaoCtrl", ['$scope', '$http', 'pacienteService', function ($scope, $http, pacienteService) {

    var instance = this;
    this.paciente = null;
    this.openInfo = false;

    this.openEdit = function () {
        instance.openInfo = true;
    };

    $scope.$on('clearInfoController', function(event, data){
        instance.paciente = {};
    });

    $scope.$on('setPacienteToController', function(event, data){
        instance.paciente = data;
    });

    this.cancelEdit = function () {
        var paciente = instance.paciente;
        pacienteService.getPacienteById(paciente.id, function(data) {
            instance.paciente = data;
            instance.openInfo = false;
        });
    };

    this.salvarDescricao = function () {
        var paciente = instance.paciente;

        var callbackMethod = function (dataCallback) {
            pacienteService.getPacienteById(paciente.id, function(data) {
                instance.paciente = data;
                instance.openInfo = false;
            });
        };

        pacienteService.salvarDescricao(paciente.id, paciente.descricao, callbackMethod);
    };

}]);

app.controller("gerarAtestadoCtrl", ['$scope', '$rootScope', '$http', 'messageService', 'consultaService', function ($scope, $rootScope, $http, messageService, consultaService) {
    var instance = this;
    this.consulta = null;
    this.atestado = '';

    $scope.$on('clearInfoController', function(event, data){
        instance.atestado = '';
    });

    this.gerarAtestado = function(id, ctrl) {
        messageService.showConfirmationMessage('Ao confirmar essa ação, o documento será armazenado no sistema e não poderá ser mais alterado.',
            function() {
                consultaService.gerarAtestado(id, instance.atestado, null);
                instance.atestado = '';
                $rootScope.$broadcast("updateProntuarioController", {});
            },function() {/* NO */}
        );
    };

}]);

app.controller("gerarPrescricaoCtrl", ['$scope', '$rootScope', '$http', 'messageService', 'consultaService', function ($scope, $rootScope, $http, messageService, consultaService) {
    var instance = this;
    this.consulta = null;
    this.prescricao = '';

    $scope.$on('clearInfoController', function(event, data){
        instance.prescricao = '';
    });

    this.gerarPrescricao = function(id, ctrl) {
        messageService.showConfirmationMessage('Ao confirmar essa ação, o documento será armazenado no sistema e não poderá ser mais alterado.',
            function() {
                consultaService.gerarPrescricao(id, instance.prescricao, null);
                instance.prescricao = '';
                $rootScope.$broadcast("updateProntuarioController", {});
            },function() {/* NO */}
        );
    };
}]);