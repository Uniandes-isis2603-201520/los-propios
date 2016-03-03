// src/modules/evento/evento.ctrl.js
// Controlador para el módulo de personas

(function (ng) {

  // es parte del módulo "eventoModule"
  var mod = ng.module("eventoModule");

  // crea el controlador con dependencias a $scope y a personService
  mod.controller("eventoCtrl", ["$scope", "eventoService", function ($scope, svc) {

    // TODO:define los atributos en el escope

            $scope.eventos = [];
            $scope.nombreEv ="";
            $scope.descripcionEv ="";
            $scope.tipoEv ="";
            $scope.lugarEv="";
            $scope.fechaEv="";
            $scope.precioEv="";
            $scope.imgEv="";
            $scope.clasificacionEv="";

            /* $scope.agregarEvento = function () {
                $scope.eventoActual = {$scope.id, $scope.ciudad, $scope.descripcion};
                svc.saveRecord(eventoActual);
            };*/

            $scope.listarEventos = function () {
                return svc.fetchRecords().then(function (response)
                {
                    $scope.eventos = response.data;
                });
            };


  }]);

})(window.angular);