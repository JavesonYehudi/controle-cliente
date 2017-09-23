var app = angular.module('controleClienteApp');

app.factory('requestInterceptor', function($q, $rootScope) {
	var numLoadings = 0;

	return {
		// optional method
		'request' : function(config) {
			numLoadings++;
			$rootScope.loading = true;
			return config;
		},

		// optional method
		'requestError' : function(rejection) {
			// do something on error

			if (canRecover(rejection)) {
				return responseOrNewPromise
			}
			return $q.reject(rejection);
		},

		// optional method
		'response' : function(response) {
			if ((--numLoadings) === 0) {
				// Hide loader
				$rootScope.loading = false;
			}
			// do something on success
			return response;
		},

		// optional method
		'responseError' : function(rejection) {
			// do something on error
			$rootScope.erroMessage = rejection.data;
			$rootScope.erroMessageStatus = true;
			$rootScope.$emit('showAlert');

			if ((--numLoadings) === 0) {
				$rootScope.loading = false;
			}

			return $q.reject(rejection);
		}
	};
});
