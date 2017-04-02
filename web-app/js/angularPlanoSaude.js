// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('planoSaude');

// Iniciar módulo
var app = angular.module("planoSaude", ["message", "config", 'planoSaudeRest']);

/**
 * Modal create Paciente
 */
var cadastroPlanoSaudeCtrl = function ($scope, $rootScope, $modalInstance, $http, messageService, configService, plano, planoSaudeService) {
    $scope.plano = plano;

    /**
     * fechar modal
     */
    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };

    /**
     *
     */
    $scope.save = function () {
        var action = "";
        if ($scope.plano.id) {
            planoSaudeService.update($scope.plano);
        } else {
            planoSaudeService.save($scope.plano);
        }
        $rootScope.$broadcast("listEntityToController", {});

        $modalInstance.dismiss('cancel');
    };

};

/**
 *
 */
app.controller("planoSaudeCtrl", ['$http', '$rootScope', '$modal', 'configService', 'planoSaudeService', 'messageService', function ($http, $rootScope, $modal, configService, planoSaudeService, messageService) {
        var instance = this;
        this.planos = [];
        this.checkAllElement = false;
        this.itemsByPage = 20;
        this.displayedCollection = [].concat(instance.planos); // Faz uma cópia de segurança da lista original
        instance.selectedItems = [];

        /*

         */
        planoSaudeService.setCallback(function(data) {
            instance.planos = data;
        });

        this.init = function() {
            planoSaudeService.list();
        };

        /**
         *
         */
        this.novo = function() {
            var modalInstance = $modal.open({
                templateUrl : 'createPlanoSaudeTemplate',
                controller : 'cadastroPlanoSaudeCtrl',
                backdrop: 'static',
                keyboard: false,                
                size : 'md',
                resolve : {
                    $http : function() {return $http;},
                    plano : function() {return {};}
                }
            });
        };

        /**
         *
         * @param id
         */
        this.alterar = function(id) {
            planoSaudeService.getPlanoSaudeById(id, function(data) {
                var modalInstance = $modal.open({
                    templateUrl : 'editPlanoSaudeTemplate',
                    controller : 'cadastroPlanoSaudeCtrl',
                    backdrop: 'static',
                    keyboard: false,                    
                    size : 'md',
                    resolve : {
                        $http : function() {return $http;},
                        plano : function() {return data;}
                    }
                });
            });
        };

        instance.updateSelected = function(id){
            var found = false;


            for (var i = instance.selectedItems.length - 1; i >= 0; i--) {
                if (instance.selectedItems[i] == id){
                    instance.selectedItems.splice(i,1);
                    found = true;
                }
            };

            if (!found) instance.selectedItems.push(id);
        }

        /**
         *
         * @param id
         */
        this.remover = function(id) {
            messageService.showConfirmationMessage('Tem certeza que deseja excluir esse plano de Saúde?',
                function() {
                    planoSaudeService.remove(id);
                    $rootScope.$broadcast("listEntityToController", {});
                });
        };

        /**
         *
         */
        this.removerGrupo = function() {
            var msg = instance.selectedItems.length > 1 ? "os " + instance.selectedItems.length + " planos selecionados?"
                                                         : "o plano selecionado?";

            messageService.showConfirmationMessage('Tem certeza que deseja excluir ' + msg,
                function() {
                    planoSaudeService.remove(instance.selectedItems, function(){
                        instance.selectedItems = [];
                    });
                }, function(){});
        };

        /**
         * TODO Gostaria de transformar isso em uma função à parte, que fosse chamada pelos demais elementos,
         * TODO Ao meu ver, isso evita dependencia e redundancia de código. Quem sabe em uma directive?
         * @returns {boolean}
         */
        this.checkAll = function () {
            var checkAllElement = false;

            instance.checkAllElement = instance.checkAllElement ? false : true;

            angular.forEach(instance.planos, function (data) {
                data.checked = instance.checkAllElement ? true : false;
                instance.updateSelected(data.id, data.nome);
            });
    
            return checkAllElement;
        };

        /**
         * TODO Gostaria de transformar isso em uma função à parte, que fosse chamada pelos demais elementos,
         * TODO Ao meu ver, isso evita dependencia e redundancia de código. Quem sabe em uma directive?
         * @returns {boolean}
         */
        this.checked = function () {
            var isValid = false;

            angular.forEach(instance.planos, function (data) {
                if (data.checked === true) {
                    isValid = true;
                }
            });
            return isValid;
        };
    }]);