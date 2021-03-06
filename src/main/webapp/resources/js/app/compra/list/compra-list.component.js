function CompraListController(Compra, $scope) {
	var ctrl = this;
	ctrl.totalValorDaEntrada = 0;
	ctrl.totalValorParcelas = 0;
	Compra.query(function(retorno){
		ctrl.compras = retorno;
	});
};

var compraListModule = angular.module('compraList').component('compraList', {
	templateUrl : 'html/compra/compra-list.template.html',
	controller : CompraListController
});


compraListModule.filter('filterAndSum', function($filter){
    return function(input, scope, predicate){
    	scope.$ctrl.totalValorDaEntrada = getTotalEntrada($filter('filter')(input, predicate));
		scope.$ctrl.totalValorParcelas = getTotalParcelas($filter('filter')(input, predicate));
        return $filter('filter')(input, predicate);
    }
});

function getTotalParcelas(compras){
	var totalValorParcelas = 0;
	if(compras != undefined)
		compras.forEach(compra => {
			if(compra.parcelas.length > 0)
				totalValorParcelas += compra.parcelas[0].valorVencimento;
		});	
	return totalValorParcelas;
}

function getTotalEntrada(compras){
	var totalValorDaEntrada = 0;
	if(compras != undefined)
		compras.forEach(compra => {
			if(compra.valorDaEntrada != undefined)
				totalValorDaEntrada += compra.valorDaEntrada;
		});
	return totalValorDaEntrada;
}