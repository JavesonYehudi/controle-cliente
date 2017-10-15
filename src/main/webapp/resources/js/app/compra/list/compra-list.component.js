function CompraListController(Compra, $scope) {
	var ctrl = this;
	ctrl.totalValorDaEntrada = 0;
	ctrl.totalValorParcelas = 0;
	Compra.query(function(retorno){
		ctrl.compras = retorno;
	});

	ctrl.itemsByPage = 15;
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

function getTotalParcelas(compraList){
	var totalValorParcelas = 0;
	compraList.forEach(compra => {
		if(compra.parcelas.length > 0)
			totalValorParcelas += compra.parcelas[0].valorVencimento;
	});	
	return totalValorParcelas;
}

function getTotalEntrada(compraList){
	var totalValorDaEntrada = 0;
	compraList.forEach(compra => {
		totalValorDaEntrada += compra.valorDaEntrada;
	});	
	return totalValorDaEntrada;
}