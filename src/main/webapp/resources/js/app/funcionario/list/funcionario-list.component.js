function FuncionarioListController(Funcionario){
	var ctrl = this;

	Funcionario.query(function(retorno){
		console.log(retorno);
		ctrl.funcionarios = retorno;
	});
}

angular.module('funcionarioList').component('funcionarioList', {
	templateUrl:'html/funcionario/funcionario-list.template.html',
	controller: FuncionarioListController
});
