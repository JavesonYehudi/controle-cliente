function FuncionarioSaveController(Funcionario, $location) {
	var ctrl = this;

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