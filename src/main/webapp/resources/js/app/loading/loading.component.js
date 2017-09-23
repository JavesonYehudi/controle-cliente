function LoadingController($rootScope){
	var root = $rootScope;
};

angular.module('loading').component('loading', {
	templateUrl:'html/loading/loading.template.html',
	controller: LoadingController
});