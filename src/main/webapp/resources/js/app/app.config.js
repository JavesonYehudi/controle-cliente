function widgetsController($location, $route, $rootScope) {
	var ctrl = $rootScope;
	ctrl.isActive = function(route) {
		return route === $location.path();
	};

}

var app = angular.module('controleClienteApp');

app.config([ '$locationProvider', '$routeProvider',
		function config($locationProvider, $routeProvider) {
			$routeProvider.when('/cliente', {
				template : '<cliente-list></cliente-list>',
				controller : widgetsController
			}).when('/cliente/save', {
				template : '<cliente-save></cliente-save>',
				controller : widgetsController
			}).when('/cliente/:clienteId', {
				template : '<cliente-save></cliente-save>',
				controller : widgetsController
			}).when('/produto', {
				template : '<produto-list></produto-list>',
				controller : widgetsController
			}).when('/produto/save', {
				template : '<produto-save></produto-save>',
				controller : widgetsController
			}).when('/produto/:produtoId', {
				template : '<produto-save></produto-save>',
				controller : widgetsController
			}).when('/compra/save', {
				template : '<compra-save></compra-save>',
				controller : widgetsController
			}).when('/compra', {
				template : '<compra-list></compra-list>',
				controller : widgetsController
			}).when('/funcionario', {
				template : '<funcionario-list></funcionario-list>',
				controller : widgetsController
			}).when('/funcionario/save', {
				template : '<funcionario-save></funcionario-save>',
				controller : widgetsController
			}).when('/funcionario/:funcionarioId', {
				template : '<funcionario-save></funcionario-save>',
				controller : widgetsController
			}).when('/parcela/:compraId', {
				template : '<parcela-modal></parcela-modal>',
				controller : widgetsController
			}).otherwise('/cliente');
			// configure html5 to get links working on jsfiddle
			$locationProvider.html5Mode(true);
		} ]);

app.config([ '$httpProvider', function($httpProvider) {
	$httpProvider.interceptors.push('requestInterceptor');
} ]);

app.config(function($mdDateLocaleProvider) {
    $mdDateLocaleProvider.formatDate = function(date) {
       return moment(date).format('DD/MM/YYYY');
    };
});