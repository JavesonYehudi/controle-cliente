function ClienteSaveController(Produto, $location, $route) {
	var ctrl = this;
	var produtoId = $route.current.params.produtoId;

	if (produtoId === undefined)
		ctrl.produto = {};
	else
		ctrl.produto = Produto.get({
			produtoId : produtoId
		});

	ctrl.create = function(produto) {
		Produto.save(produto, function(retorno) {
			console.log(retorno);
			$location.path('/produto');
		});
	};

};

angular.module('produtoSave').component('produtoSave', {
	templateUrl : 'html/produto/produto-save.template.html',
	controller : ClienteSaveController
});