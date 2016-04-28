// src/modules/evento/evento.ctrl.js
// Controlador para el módulo de personas

(function (ng) {

  // es parte del módulo "eventoModule"
  var mod = ng.module("eventoModule");

  // crea el controlador con dependencias a $scope y a personService
  mod.controller("eventoCtrl", ["$scope", "eventoService", function ($scope, svc) {


            $scope.eventos = [];
            $scope.eventoActual={
                id: 0, /**Tipo long**/
                nombre: "", /** Tipo String**/
                descripcion: "", /**Tipo String**/
                tipo: "", /**Tipo String**/
                lugar: "",/**Tipo String**/
                fecha: "", /**Vacío o null si clasificacion: "sitioInteres" y Tipo Date**/
                precio: 0, /**Tipo Double**/
                img: "", /**Tipo String**/
                clasificacion:"" /**Tipo String**/
            };
             var self = this;

            $scope.listarEventos = function () {
                return svc.fetchRecords().then(function (response)
                {
                    $scope.eventos = response.data;
                });
            };

            $scope.agregarEvento = function () {
                return svc.saveRecord($scope.eventoActual).then(function () {
                    self.listarEventos();
                }, responseError);
            };

            $scope.deleteRecord = function (record) {
                return svc.deleteRecord(record.id).then(function () {
                    self.listarEventos();
                }, responseError);
            };

            $scope.editRecord = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.eventoActual = response.data;
                    $scope.$broadcast("post-edit", $scope.eventoActual);
                    return response;
                }, responseError);
            };

            $scope.listarEventos();


  }]);

})(window.angular);