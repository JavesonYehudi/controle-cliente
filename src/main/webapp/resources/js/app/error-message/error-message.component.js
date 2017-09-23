function ErrorMessageController($rootScope, $scope, $mdDialog) {
	var root = $rootScope;

	root.$on('showAlert', function(ev) {
		// Appending dialog to document.body to cover sidenav in docs app
		// Modal dialogs should fully cover application
		// to prevent interaction outside of dialog
		$mdDialog.show($mdDialog.alert().parent(
				angular.element(document.querySelector('#error-container')))
				.clickOutsideToClose(true).title('Erro')
				.textContent('Ocorreu um erro ao tentar realizar a ação: ' + root.erroMessage)
				.ariaLabel('Alert Dialog Demo').ok('Tentar Novamente!').targetEvent(ev));
	});
};

angular.module('errorMessage').component('errorMessage', {
	templateUrl : 'html/error-message/error-message.template.html',
	controller : ErrorMessageController
});