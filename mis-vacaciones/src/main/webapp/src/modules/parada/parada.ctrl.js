// src/modules/parada/parada.ctrl.js
// Controlador para el módulo de personas

(function (ng) {

  // es parte del módulo "paradaModule"
  var mod = ng.module("paradaModule");

  // crea el controlador con dependencias a $scope y a personService
  mod.controller("paradaCtrl", ["$scope", "paradaService", function ($scope, svcParada) {

           $scope.alerts = [];
            $scope.paradas = [];
            $scope.paradaActual={
                idParada: 0 /*Tipo Long. El valor se asigna en el backend*/,
                nombreParadaUno: ""/*Tipo String*/,
                ciudadParadaUno: "" /*Tipo String*/,
                actividadParadaUno: "" /*Tipo String*/,
                fechaInicioParadaUno: "" /*Tipo date*/,
                fechaFinParadaUno: "" /*Tipo date*/
            };
             var self = this;

             function showMessage(msg, type) {
                 var types = ["info", "danger", "warning", "success"];
                 if (types.some(function (rc) {
                     return type === rc;
                 })) {
                     $scope.alerts.push({type: type, msg: msg});
                 }
             }

             this.showError = function (msg) {
                 showMessage(msg, "danger");
             };
             this.showSuccess = function (msg) {
                 showMessage(msg, "success");
             };
             var self = this;

             function responseError(response) {
                 self.showError(response.data);
             }

             this.closeAlert = function (index) {
                $scope.alerts.splice(index, 1);
            };

            this.listarParadas = function () {
                return svcParada.fetchRecords().then(function (response)
                {
                    $scope.paradas = response.data;
                });
            };

            this.agregarParada = function () {
                return svcParada.saveRecord($scope.paradaActual).then(function () {
                    self.listarParadas();
                }, responseError);
            };

            this.eliminarParada = function (record) {
                return svcParada.deleteRecord(record.id).then(function () {
                    self.listarParadas();
                }, responseError);
            };

            this.editarParada = function (record) {
                return svcParada.fetchRecord(record.id).then(function (response) {
                    $scope.paradaActual = response.data;
                    $scope.$broadcast("post-edit", $scope.paradaActual);
                    return response;
                }, responseError);
            };

            this.listarParadas();
  }]);

})(window.angular);