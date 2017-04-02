// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('message');

// Iniciar módulo
var app = angular.module("message", []);

var showMessageController = function ($scope, $modalInstance, message) {
	$scope.message = message;

	/**
	 * fechar modal
	 */
	$scope.close = function () {
		$modalInstance.dismiss('cancel');
	};
};

var showConfirmationMessageController = function ($scope, $modalInstance, message, callbackYes, callbackNo) {
	$scope.message = message;
	if (callbackYes) {
		$scope.callbackYes = callbackYes;
	}

	if (callbackNo) {
		$scope.callbackNo = callbackNo;
	}

	/**
	 * fechar modal
	 */
	$scope.yes = function () {
		$scope.callbackYes();
		$modalInstance.dismiss('cancel');
	};

	$scope.no = function () {
		$scope.callbackNo();
		$modalInstance.dismiss('cancel');
	};
};

app.factory("messageService", ['$modal', function ($modal) {
	return {
		showMessage: function(message) {
			var modalInstance = $modal.open({
				templateUrl : 'showMessageTemplate',
				controller : 'showMessageController',
				size : 'md',
				resolve : {
					message : function() {return message;}
				}
			});
		},
		showConfirmationMessage: function(message, callbackYes, callbackNo) {
			var modalInstance = $modal.open({
				templateUrl : 'showConfirmationMessageTemplate',
				controller : 'showConfirmationMessageController',
				size : 'md',
				resolve : {
					message : function() {return message;},
					callbackYes : function() {return callbackYes;},
					callbackNo : function() {return callbackNo;}
				}
			});
		},
		showMessageError: function(message) {
			var modalInstance = $modal.open({
				templateUrl : 'showMessageErrorTemplate',
				controller : 'showMessageController',
				size : 'md',
				resolve : {
					message : function() {return message;}
				}
			});
		}
	};
}]);