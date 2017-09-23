function ClienteEnderecoController(Estado, Cidade) {
	var ctrl = this;

	ctrl.estados = Estado.query();

	ctrl.onSelectEstado = function(estado) {
		if (estado === "")
			ctrl.cidades = undefined;
		else
			ctrl.cidades = Cidade.query({
				id : estado
			});
	}
};

angular.module('clienteSave').component('clienteEndereco', {
	templateUrl : 'html/cliente/endereco/cliente-endereco.template.html',
	controller : ClienteEnderecoController,
	bindings : {
		cliente : '=',
		cidades : '='
	}
});