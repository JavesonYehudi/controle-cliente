function ClienteListController(Cliente) {
	var ctrl = this;
	Cliente.query(function(retorno){
		ctrl.clientes = retorno;
	});
	
	ctrl.itemsByPage = 15;
};

angular.module('clienteList').component('clienteList', {
	templateUrl : 'html/cliente/cliente-list.template.html',
	controller : ClienteListController
});