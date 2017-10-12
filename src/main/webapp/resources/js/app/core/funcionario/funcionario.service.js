angular.
  module('core.funcionario').
  factory('Funcionario', ['$resource',
    function($resource) {
      return $resource('http://localhost:8080/controle-cliente/funcionarios/:funcionarioId', {}, {
        query: {
          method: 'GET',
          params: {funcionarioId: ''},
          isArray: true
        }
      });
    }
  ]);