var app = angular.module('controleClienteApp');

app.controller('IsActive', function($scope, $location) {
    $scope.isActive = function(route) {
        return route === $location.path();
    }
});