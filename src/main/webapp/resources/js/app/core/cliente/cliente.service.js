angular.
  module('core.cliente').
  factory('Cliente', ['$resource',
    function($resource) {
      return $resource('http://localhost:8080/controle-cliente/clientes/:clienteId', {}, {
        query: {
          method: 'GET',
          params: {clienteId: ''},
          isArray: true
        },
        'update': { method:'Put' }
      });
    }
  ]);