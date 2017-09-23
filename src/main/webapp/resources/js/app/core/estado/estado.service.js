angular.
  module('core.estado').
  factory('Estado', ['$resource',
    function($resource) {
      return $resource('http://localhost:8080/controle-cliente/estados/:estadoId', {}, {
        query: {
          method: 'GET',
          params: {estadoId: ''},
          isArray: true
        }
      });
    }
  ]);