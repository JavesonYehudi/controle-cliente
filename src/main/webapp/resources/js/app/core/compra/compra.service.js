angular.
  module('core.compra').
  factory('Compra', ['$resource',
    function($resource) {
      return $resource('http://localhost:8080/controle-cliente/compras/:compraId', {}, {
        query: {
          method: 'GET',
          params: {compraId: ''},
          isArray: true
        },
        'update': { method:'Put' }
      });
    }
  ]);