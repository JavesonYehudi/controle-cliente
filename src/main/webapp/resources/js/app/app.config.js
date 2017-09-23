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
				controller : widgetsController,
				activetab : 'cliente'
			}).when('/cliente/save', {
				template : '<cliente-save></cliente-save>',
				controller : widgetsController,
				activetab : 'clienteSave'
			}).when('/cliente/:clienteId', {
				template : '<cliente-save></cliente-save>',
				controller : widgetsController,
				activetab : 'clienteDetail'
			}).when('/produto', {
				template : '<produto-list></produto-list>',
				controller : widgetsController,
				activetab : 'produto'
			}).when('/produto/save', {
				template : '<produto-save></produto-save>',
				controller : widgetsController,
				activetab : 'produtoSave'
			}).when('/produto/:produtoId', {
				template : '<produto-save></produto-save>',
				controller : widgetsController,
				activetab : 'produtoDetail'
			}).when('/compra/save', {
				template : '<compra-save></compra-save>',
				controller : widgetsController,
				activetab : 'compraSave'
			}).when('/compra', {
				template : '<compra-list></compra-list>',
				controller : widgetsController,
				activetab : 'compraList'
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