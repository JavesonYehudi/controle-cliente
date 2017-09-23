function ProdutoListController(Produto) {
	var ctrl = this;
	Produto.query(function(retorno){
		ctrl.produtos = retorno;
	});
	
	ctrl.itemsByPage = 15;
};

angular.module('produtoList').component('produtoList', {
	templateUrl : 'html/produto/produto-list.template.html',
	controller : ProdutoListController
});