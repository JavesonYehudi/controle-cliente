function CompraProdutoController(Produto, $scope) {
	var ctrl = this;

	Produto.query(function(retorno) {
		ctrl.produtos = retorno;
	});

	ctrl.onProdutoSelect = function(produto, index) {
		if (produto != "") {
			ctrl.compra.itens[index].valorUnitario = produto.valor;
			ctrl.compra.itens[index].quantidade = 1;
		} else {
			ctrl.compra.itens[index].valorUnitario = 0;
			ctrl.compra.itens[index].quantidade = 0;
		}
		produtoChange();
	};

	ctrl.onProdutoChange = function(){
		produtoChange();
	}; 
		
	function produtoChange(){
		$scope.$emit('onProdutoChange');
	}
};

angular.module('compraSave').component('compraProduto', {
	templateUrl : 'html/compra/produto/compra-produto.template.html',
	controller : CompraProdutoController,
	bindings : {
		compra : '=',
		index : '='
	}
});