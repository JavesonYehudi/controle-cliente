var app = angular.module('controleClienteApp', 
	[ 
		'clienteList', 'clienteSave',
		'produtoList', 'produtoSave', 
		'compraSave', 'compraList', 
		'funcionarioList', 'funcionarioSave', 
		'loading', 'errorMessage', 
		'ngRoute', 'ngCpfCnpj',
		'ui.mask', 'ngMaterial', 
		'botaoHistorico', 'smart-table'
	]);