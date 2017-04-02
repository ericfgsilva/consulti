// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('atendimentoRest');

// Iniciar módulo
var app = angular.module("atendimentoRest", ['message', 'config']);

app.factory("atendimentoService", ['$http', 'configService', 'messageService', function ($http, configService, messageService) {
    var callback;
    var contador = {};
    contador.consultados = 0;
    contador.agendados = 0;
    var lista = {};
    lista.consultas = [];
    lista.firstConsultas = [];
    lista.afterFirstConsultas = [];

    /**
     * Atualizando os contadores
     */
    var updateContadores = function () {
        $http.get(configService.path() + "/atendimento/mostrarContadores").success(function (data) {
            contador = data;
        });
    };

    var list = function () {
        $http.get(configService.path() + "/atendimento/consultasMarcadasDoDia").success(function (data) {
            lista.consultas = data;

            if(data) {
                lista.firstConsultas = lista.consultas.slice(0, 4);
                lista.afterFirstConsultas = lista.consultas.slice(4);
            }
        });
    };

    var getContadores = function (callback) {
        $http.get(configService.path() + "/atendimento/mostrarContadores").success(function (data) {
            callback(data);
        });
    };

    /**
     * atualizando o escopo da aplicação no geral
     */
    var initScope = function () {
        list();
        updateContadores();
    };

    var getLista = function() {
        return lista;
    };

    var iniciarConsulta = function (id, callback) {
        $http.post(configService.path() + "/atendimento/iniciarConsulta", {'id': id}).success(function (data) {
            initScope();
            callback(data);
        }).error(function () {
            var consultaEmAtendimento = {};
            consultaEmAtendimento.consulta = {};
            consultaEmAtendimento.consultas = [];
            consultaEmAtendimento.paciente = {};

            callback(consultaEmAtendimento);
        });
    };

    var refreshProntuario = function (id, callback) {
        $http.get(configService.path() + "/atendimento/refreshProntuario/" + id).success(function (data) {
            callback(data);
        }).error(function () {
            callback([]);
        });
    };

    var encerrarConsulta = function (id, callback) {
        $http.post(configService.path() + "/atendimento/finalizarConsulta", {'id': id}).success(function (data) {
            messageService.showMessage(data.msg);
            callback();
            initScope();
        });
    };

    return {
        initScope : initScope,
        getLista : getLista,
        list : list,
        getContadores : getContadores,
        iniciarConsulta : iniciarConsulta,
        encerrarConsulta : encerrarConsulta,
        refreshProntuario : refreshProntuario
    }
}]);