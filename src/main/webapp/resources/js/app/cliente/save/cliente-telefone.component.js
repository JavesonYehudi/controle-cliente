function ClienteTelefoneController() {
	var ctrl = this;
};

angular.module('clienteSave').component('clienteTelefone', {
	templateUrl : 'html/cliente/telefone/cliente-telefone.template.html',
	controller : ClienteTelefoneController,
	bindings : {
		cliente : '='
	}
});