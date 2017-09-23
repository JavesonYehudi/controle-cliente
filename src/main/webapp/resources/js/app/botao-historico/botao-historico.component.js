function BotaoHistoricoController($window) {
	var ctrl = this;
	ctrl.voltar = function(){
		$window.history.back();
	};
};

angular.module('botaoHistorico').component('botaoHistorico', {
	templateUrl : 'html/botao-historico/botao-historico.template.html',
	controller : BotaoHistoricoController
});