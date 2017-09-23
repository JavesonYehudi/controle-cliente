angular.module('controleClienteApp').controller('SideNaveController',
		function($scope, $timeout, $mdSidenav) {
			$scope.toggleLeft = buildToggler('left');

			function buildToggler(componentId) {
				return function() {
					$mdSidenav(componentId).toggle();
				};
			}
		});