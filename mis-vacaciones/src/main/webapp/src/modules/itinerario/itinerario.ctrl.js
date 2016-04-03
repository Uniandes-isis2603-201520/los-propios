/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {

    // es parte del módulo "itinerarioModule"
    var mod = ng.module("itinerarioModule");

    // crea el controlador con dependencias a $scope y a personService
    mod.controller("itinerarioCtrl", ["$scope", "itinerarioService", function ($scope, svc) {

            var self = this;
            function responseError(response) {
                self.showError(response.data);
            }

            // listado de los itinerarios
            $scope.itinerarios = [];
            // atributos propios de un itinerario
            $scope.idItinerario = "";
            $scope.nombreItinerario = "";
            $scope.fechaInicio = "";
            $scope.fechaFin = "";
            // listado de paradas
            $scope.paradas = [];
            $scope.ciudadesParadas = [];
            // atributos propios de una parada
            //$scope.idParada = "";
            $scope.nombreParadaUno = "";
            $scope.ciudadParadaUno = "";
            $scope.actividadParadaUno = "";
            $scope.fechaInicioParadaUno = "";
            $scope.fechaFinParadaUno = "";


            // y que usan funciones definidas en el servicio
            $scope.agregarItinerario = function () {
                var itinerario = [$scope.nombreParada, $scope.fechaInicio, $scope.fechaFin];
                svc.saveRecord(itinerario);
            };

            $scope.listarItinerarios = function () {
                return svc.fetchRecords().then(function (response)
                {
                    $scope.itinerarios = response.data;
                });
            };

            $scope.agregarParada = function () {
//                $scope.idParada
                var parada = [$scope.nombreParadaUno, $scope.ciudadParadaUno, $scope.actividadParadaUno, $scope.fechaInicioParadaUno, $scope.fechaFinParadaUno];
                svc.saveRecordDos(parada);
            };

            $scope.listarParadas = function () {
                return svc.fetchRecordsDos().then(function (response)
                {
                    $scope.paradas = response.data;
                });
            };

            this.deleteRecord = function (record) {
                return svc.deleteRecord(record.id).then(function () {
                    self.fetchRecords();
                }, responseError);
            };

            this.deleteRecordDos = function (record) {
                return svc.deleteRecord(record.id).then(function () {
                    self.fetchRecords();
                }, responseError);
            };

//            $scope.listarCiudadesParadas = function()
//            {
//                return
//            }
        }]);

})(window.angular);
