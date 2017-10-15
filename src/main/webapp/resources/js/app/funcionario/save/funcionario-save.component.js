function FuncionarioSaveController(Funcionario, $location, $route) {
	var ctrl = this;
	var funcionarioId = $route.current.params.funcionarioId;

	Funcionario.get({
		funcionarioId: funcionarioId
	}, function(retorno){
		console.log(retorno);
		ctrl.funcionario = retorno;
	});

	ctrl.create = function(funcionario){
		console.log(funcionario);
		Funcionario.save(funcionario, function(){
			$location.path('/funcionario');
		});
	};
}

angular.module('funcionarioSave').component('funcionarioSave', {
	templateUrl: 'html/funcionario/funcionario-save.template.html',
	controller: FuncionarioSaveController
});