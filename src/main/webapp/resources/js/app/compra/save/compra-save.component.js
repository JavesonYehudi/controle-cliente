function CompraSaveController(Cliente, Compra, Funcionario, $scope, $location) {
	var ctrl = this;
	ctrl.quantidadeDeProdutos = [];
	ctrl.aVista = true;
	ctrl.quantidadeDeProdutos.push(0);
	
	ctrl.compra = {
		itens : []
	};

	ctrl.compra.quantidadeDeParcelas = 0;
	ctrl.compra.valorDaEntrada = 0;
	ctrl.compra.dataPrimeiraParcela = new Date();
	ctrl.minDate = new Date();

	Cliente.query(function(retorno) {
		ctrl.clientes = retorno;
	});

	Funcionario.query(function(retorno) {
		ctrl.funcionarios = retorno;
	});

	ctrl.adicionaProduto = function(last) {
		ctrl.quantidadeDeProdutos.push(last);
	};

	ctrl.removeProduto = function(index) {
		if (ctrl.quantidadeDeProdutos.length > 0) {
			ctrl.quantidadeDeProdutos.splice(index - 1, 1);
			ctrl.compra.itens.splice(index, 1);
		}
		ctrl.compra.valorDaParcela = calculaPrecoDaParcela(ctrl.compra.itens);
	}

	ctrl.chageAVista = function(){
		if(ctrl.aVista){
			ctrl.compra.valorDaEntrada = calculaPrecoDaEntrada(ctrl.compra.itens);
			ctrl.compra.valorDaParcela = 0;
			ctrl.compra.quantidadeDeParcelas = 0;
		}else{
			ctrl.compra.valorDaEntrada = 0;
			ctrl.compra.quantidadeDeParcelas = 1;
			ctrl.compra.valorDaParcela = calculaPrecoDaParcela(ctrl.compra.itens);
		}
	}

	$scope.$on('onProdutoChange', function() {
		if(ctrl.aVista){
			ctrl.compra.valorDaEntrada = calculaPrecoDaEntrada(ctrl.compra.itens);
			ctrl.compra.valorDaParcela = 0;
			ctrl.compra.quantidadeDeParcelas = 0;
		}else{
			ctrl.compra.valorDaParcela = calculaPrecoDaParcela(ctrl.compra.itens);
		}
	});

	ctrl.onQuantidadeDeParcelaChange = function() {
		if(ctrl.aVista){
			ctrl.compra.valorDaEntrada = calculaPrecoDaEntrada(ctrl.compra.itens);
			ctrl.compra.valorDaParcela = 0;
			ctrl.compra.quantidadeDeParcelas = 0;
		}else{
			ctrl.compra.valorDaParcela = calculaPrecoDaParcela(ctrl.compra.itens);
		}
	};

	ctrl.create = function(compra){
		Compra.save(compra, function(){
			$location.path('/compra');
		});
	};
	
	function calculaPrecoDaEntrada(itens) {
		var valorTotalDosItens = 0;
		for (var i = 0; i < itens.length; i++)
			valorTotalDosItens += itens[i].valorUnitario * itens[i].quantidade;

		return valorTotalDosItens;
	}

	function calculaPrecoDaParcela(itens) {
		var valorTotalDosItens = 0;
		for (var i = 0; i < itens.length; i++)
			valorTotalDosItens += itens[i].valorUnitario * itens[i].quantidade;

		return (valorTotalDosItens - ctrl.compra.valorDaEntrada) / ctrl.compra.quantidadeDeParcelas;
	}

};

angular.module('compraSave').component('compraSave', {
	templateUrl : 'html/compra/compra-save.template.html',
	controller : CompraSaveController
});