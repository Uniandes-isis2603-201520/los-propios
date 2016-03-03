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

            // TODO: define los atributos en el scope
            $scope.itinerarios = [];
            $scope.fechaInicio = "";
            $scope.fechaFin = "";
            $scope.idItinerario = "";

            // TODO: define funciones que son invocadas desde la pantalla
            // y que usan funciones definidas en el servicio
            $scope.agregarItinerario = function () {
                var itinerario = [$scope.idItinerario, $scope.fechaInicio, $scope.fechaFin];
                svc.saveRecord(itinerario);
            };

            $scope.listarItinerarios = function () {
                return svc.fetchRecords().then(function (response)
                {
                    $scope.itinerarios = response.data;
                });
            };

        }]);

})(window.angular);
