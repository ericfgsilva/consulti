// Deve sempre acrescentar nos módulos do Consulti
consultiModules.push('calendario');

// Iniciar módulo
var app = angular.module("calendario", []);

app.controller("controllerCalendario", ['$http', function($http) {
        var consultorio = this;
        this.opened;
		
		this.openCalendarWindow = function($event) {
            $event.preventDefault();
            $event.stopPropagation();
            
            this.opened = true;
        };

    }]);

app.controller('controllerTimer', function ($scope) {
    $scope.mytime = new Date();
    $scope.opened = false;
    $scope.hstep = 1; // hora em hora
    $scope.mstep = 5; // minutos em minutos

    $scope.options = {
        hstep: [1, 2, 3],
        mstep: [1, 5, 10, 15, 25, 30]
    };

    $scope.update = function() {
        var d = new Date();
        d.setHours( 14 );
        d.setMinutes( 0 );
        $scope.mytime = d;
    };

    $scope.clear = function() {
        $scope.mytime = null;
    };

    $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened = true;
    };
});