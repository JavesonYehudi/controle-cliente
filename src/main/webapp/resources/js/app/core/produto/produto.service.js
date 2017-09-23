angular.
  module('core.produto').
  factory('Produto', ['$resource',
    function($resource) {
      return $resource('http://localhost:8080/controle-cliente/produtos/:produtoId', {}, {
        query: {
          method: 'GET',
          params: {produtoId: ''},
          isArray: true
        }
      });
    }
  ]);