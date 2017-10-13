function ParcelaModalController(Compra, $route) {
	var ctrl = this;
	var compraId = $route.current.params.compraId;

	Compra.get({
		compraId : compraId
	}, function(retorno){
		ctrl.compra = retorno;
	});

	ctrl.printDiv = function(divName) {
		console.log(divName);
		var printContents = document.getElementById(divName).innerHTML;
		var popupWin = window.open('', '_blank', 'width=300,height=300');
		var html = 
			`<html>
				<head>
				</head>
				<body onload="window.print()">  
					${printContents} 
				</body>
			</html>`;
		popupWin.document.open();
		console.log(html);
		popupWin.document.write(html);
		popupWin.document.close();
	} 
}

angular.module('parcelaModal').component('parcelaModal', {
	templateUrl : 'html/parcela/parcela-modal.template.html',
	controller : ParcelaModalController
});