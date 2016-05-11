// src/modules/evento/evento.ctrl.js
// Controlador para el módulo de personas

(function (ng) {

  // es parte del módulo "eventoModule"
  var mod = ng.module("eventoModule");

  // crea el controlador con dependencias a $scope y a personService
  mod.controller("eventoCtrl", ["$scope", "eventoService", function ($scope, svc) {

           $scope.alerts = [];
            $scope.eventos = [];
            $scope.eventoActual={
                id: 0, /**Tipo long**/
                name: "", /** Tipo String**/
                descripcion: "", /**Tipo String**/
                tipo: "", /**Tipo String**/
                lugar: "",/**Tipo String**/
                fecha: "", /**Vacío o null si clasificacion: "sitioInteres" y Tipo Date**/
                precio: 0, /**Tipo Double**/
                img: "", /**Tipo String**/
                clasificacion:"" /**Tipo String**/
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

            this.listarEventos = function () {
                return svc.fetchRecords().then(function (response)
                {
                    $scope.eventos = response.data;
                });
            };

            this.agregarEvento = function () {
                    return svc.saveRecord($scope.eventoActual).then(function () {
                    self.listarEventos();
                }, responseError);
            };

            this.deleteRecord = function (record) {
                return svc.deleteRecord(record.id).then(function () {
                    self.listarEventos();
                }, responseError);
            };

            this.editRecord = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.eventoActual = response.data;
                    $scope.$broadcast("post-edit", $scope.eventoActual);
                    return response;
                }, responseError);
            };

            this.listarEventos();


  }]);

})(window.angular);