function CompraListController(Compra) {
	var ctrl = this;
	Compra.query(function(retorno){
		ctrl.compras = retorno;
	});
	
	ctrl.itemsByPage = 15;
};

angular.module('compraList').component('compraList', {
	templateUrl : 'html/compra/compra-list.template.html',
	controller : CompraListController
});