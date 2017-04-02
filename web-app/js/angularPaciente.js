// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('paciente');

// Iniciar módulo
var app = angular.module("paciente", ["crudConsulTI", "message", "config"]);

/**
 * Modal create Paciente
 */
var cadastroPacienteCtrl = function ($scope, $rootScope, $modalInstance, $http, $filter, paciente, messageService, configService) {
    $scope.paciente = {};
    $scope.paciente.planosSaude = [];
    $scope.associaPlano = {};
    $scope.disponiveis = {};
    $scope.planos = {};
    $scope.addDisponiveis = false;
    $scope.editAssociados = false;

    /*
    obtem a lista de planos de saúde
     */
    $http.get(configService.path() + "/planoSaude/list").success(function(json) {
        $scope.disponiveis = json;
    
        if(paciente != null) {
            $scope.paciente = paciente;

            for(var i = 0; i < $scope.paciente.planosSaude.length; i++){
                for(var j = 0; j < $scope.disponiveis.length; j++){
                    if($scope.paciente.planosSaude[i].planoSaude === $scope.disponiveis[j].id){
                        $scope.disponiveis[i].hide = true;
                    }
                }
            }
        }
    });
    
    /**
     * fechar modal
     */
    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };
    
    /**
     * 
     */
    $scope.desvincularPlanoSaude = function () {
        // retirar da lista e dar um show em disponíveis        
        for(var i = $scope.paciente.planosSaude.length - 1; i >= 0; i--){
            if($scope.paciente.planosSaude[i].id == $scope.associaPlano.id){
                $scope.paciente.planosSaude.splice(i,1);
            }
        }
        
        for(var i = 0; i < $scope.disponiveis.length; i++){
            if($scope.disponiveis[i].id == $scope.associaPlano.id){
                $scope.disponiveis[i].hide = false;
            }
        }
        
        $scope.associaPlano = {};
        $scope.editAssociados = false
    };
   
    /**
     * 
     */
    $scope.vincularPlanoSaude = function () {
        // incluir na lista e dar um hide em disponíveis
        var pacientePlano = $scope.associaPlano;
        pacientePlano.dtValidadeInicio = $filter('date')(pacientePlano.dtValidadeInicio,'yyyy-MM-dd');
        pacientePlano.dtValidadeFim = $filter('date')(pacientePlano.dtValidadeFim,'yyyy-MM-dd');

        for(var i = $scope.disponiveis.length - 1; i >= 0; i--){
            if($scope.disponiveis[i].id == $scope.associaPlano.id){
                $scope.disponiveis[i].hide = true;
            }
        }
        $scope.paciente.planosSaude.push(pacientePlano);
        $scope.associaPlano = {};
        $scope.addDisponiveis = false;
    };
    
    /**
     * fechar todos os paineis de plano
     */
    $scope.closeFormularioPlano = function () {
        $scope.associaPlano = {};
        $scope.addDisponiveis = false;
        $scope.editAssociados = false;
    };
    
    /**
     * 
     */
    $scope.openPanelForDisponiveis = function (plano) {
        $scope.addDisponiveis = true;
        
        if($scope.addDisponiveis) {
            $scope.associaPlano = plano;
        }
    };
    
    /**
     * 
     */
    $scope.openPanelForAssociados = function (plano) {
        $scope.editAssociados = true;
        
        if($scope.editAssociados) {
            $scope.associaPlano = plano;
        }
    };

    /**
     * 
     */
    $scope.save = function () {
        var date = $filter('date')($scope.paciente.dataNascimento, 'yyyy-MM-dd');
        $scope.paciente.dataNascimento = date;

        $http.post(configService.path() + "/paciente/save", {pacienteInstance: $scope.paciente}).success(function(data) {
            messageService.showMessage(data);
            $rootScope.$broadcast("listEntityToController", $scope.paciente);
        });
        
        $modalInstance.dismiss('cancel');
    };

};

app.controller("pacienteCtrl", ['$http', '$modal', '$filter', 'configService', function ($http, $modal, $filter, configService) {
    var instance = this;
    this.pacientes = [];

    this.novoPaciente = function(callback) {
        var modalInstance = $modal.open({
            templateUrl : 'createPacienteTemplate',
            controller : 'cadastroPacienteCtrl',
            size : 'md',
            backdrop: 'static',
            keyboard: false,
            resolve : {
                $http : function() {return $http;},
                $filter : function() {return $filter;},
                callback : function() {return callback;},
                paciente : function() {return null;}
            }
        });
    };

    this.editPaciente = function(id, callback) {
        $http.get(configService.path() + "/paciente/edit/"+id).success(function(data) {
            var modalInstance = $modal.open({
                templateUrl : 'editPacienteTemplate',
                controller : 'cadastroPacienteCtrl',
                backdrop: 'static',
                keyboard: false,                
                size : 'md',
                resolve : {
                    $http : function() {return $http;},
                    callback : function() {return callback;},
                    paciente : function() {return data;}
                }
            });

        });
    };

}]);