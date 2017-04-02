// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('crudConsulTI');

// Iniciar módulo
var app = angular.module("crudConsulTI", ["smart-table", "config"]);

var showMessageCtrl = function ($scope, $modalInstance, message) {
    $scope.message = message;

    /**
     * fechar modal
     */
    $scope.close = function () {
        $modalInstance.dismiss('cancel');
    };
};

app.controller("crudController", ['$scope', '$rootScope', '$http', '$modal', 'configService', function ($scope, $rootScope, $http, $modal, configService) {
        var instance = this;
        this.rowId = '';
        this.controller = '';
        this.objectList = [];
        this.createObject = {};
        this.updateObject = {};
        this.displayedCollection = [].concat(instance.objectList); // Faz uma cópia de segurança da lista original
        this.itemsByPage = 20; // Qtde de registros por pagina

        this.init = function () {
            instance.list();
        };
        
        this.resetCreate = function () {
            instance.createObject = {};
        };
        
        this.resetUpdate = function () {
            instance.updateObject = {};
        };

        this.list = function () {
            $http.get(configService.path() + "/" + instance.controller +"/list").success(function (data) {
                instance.objectList = data;
            });
        };

        $scope.$on('listEntityToController', function(){
            instance.list();
        });
        
        this.show = function () {
            var object;
            
            angular.forEach(instance.objectList, function (data) {
                if (data.checked === true) {
                    object = data;
                }
            });
            
            $http.get(configService.path() + "/" + instance.controller + "/show/" + object.id).success(function (data) {
                instance.updateObject = data;
            });
        };
        
        this.remove = function () {
            var objects = [];
            
            angular.forEach(instance.objectList, function (data) {
                if (data.checked === true) {
                    objects.push(data.id);
                }
            });
            
            $http.delete(configService.path() + "/" + instance.controller + "/remove", {params: {lista: objects}} ).success(function(data) {
                if(data) {
                    instance.showMessage(data);
                }
                $rootScope.$broadcast("listEntityToController", {});
            });
        };
        
        this.update = function () {
            $http.post(configService.path() + "/" + instance.controller + "/update", instance.updateObject).success(function(data) {
            	instance.updateObject = {};
                $rootScope.$broadcast("listEntityToController", {});
            });
        };
        
        this.save = function () {
            $http.post(configService.path() + "/" + instance.controller + "/save", instance.createObject).success(function(data) {
            	instance.createObject = {};
                $rootScope.$broadcast("listEntityToController", {});
            });
        };

        this.isValidToEdit = function () {
            var isValid = false;
            var isMultipleChecked = false;
            
            angular.forEach(instance.objectList, function (data) {
                if (data.checked === true) {
                    if(isValid) { // there's already checked
                        isMultipleChecked = true;
                    }
                    
                    isValid = true;
                }
            });
            return isValid && !isMultipleChecked;
        };
        
        this.isValidToRemove = function () {
            var isValid = false;
            
            angular.forEach(instance.objectList, function (data) {
                if (data.checked === true) {
                    isValid = true;
                }
            });
            return isValid;
        };
        
        this.checkAll = function() {  
        	var isChecked = false;
        	
            if ($("#selectedAll").attr('checked')){
            	$(".checkbox").attr ( "checked" ,"checked" );
            	isChecked = true;
            }else{
            	$(".checkbox").removeAttr('checked');
            }        	
            
            angular.forEach(instance.objectList, function (data) {
                data.checked = isChecked;
            });            
        };

        this.showMessage = function(message) {
            var modalInstance = $modal.open({
                templateUrl : 'showMessageTemplate',
                controller : 'showMessageCtrl',
                size : 'md',
                resolve : {
                    message : function() {return message;}
                }
            });
        };

        this.removeLine = function() {
        	if (instance.rowId != ''){
                $http.delete(configService.path() + "/" + instance.controller + "/remove", {params: {lista: instance.rowId}} ).success(function(data) {
                    if(data) {
                        instance.showMessage(data);
                    }

                    instance.list();
                });
        	}
        }
    }]);