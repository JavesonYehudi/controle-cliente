function ParcelaModalController() {
  var ctrl = this;
  console.log('parcelaModal');
}

angular.module('parcelaModal').component('ParcelaModal', {
  templateUrl : 'html/parcela/parcela.modal.template.html',
  controller : ParcelaModalController
});
