angular.
  module('core.cidade').
  factory('Cidade', ['$resource',
    function($resource) {
      return $resource('http://localhost:8080/controle-cliente/cidades/:id', {}, {
        query: {
          method: 'GET',
          params: {id: ''},
          isArray: true
        }
      });
    }
  ]);