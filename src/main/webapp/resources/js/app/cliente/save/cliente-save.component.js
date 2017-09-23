function ClienteSaveController(Cliente, Estado, Cidade, $location, $route) {
	var ctrl = this;
	var clienteId = $route.current.params.clienteId;

	ctrl.cliente = {
		enderecos : [],
		documentos : [],
		telefones : []
	}

	if (clienteId != undefined)
		Cliente.get({
			clienteId : clienteId
		}, function(retorno) {
			ctrl.cliente = retorno;
			ctrl.cliente.nascimento = moment(ctrl.cliente.nascimento).toDate();
			ctrl.cidades = Cidade.query({
				id : retorno.enderecos[0].estado.id
			});
		});

	ctrl.create = function(cliente) {
		Cliente.save(cliente, function(retorno) {
			$location.path('/cliente');
		});
	};

};

angular.module('clienteSave').component('clienteSave', {
	templateUrl : 'html/cliente/cliente-save.template.html',
	controller : ClienteSaveController
});