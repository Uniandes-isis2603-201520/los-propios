/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {

    // es parte del módulo "personModule"
    var mod = ng.module("ciudadModule");

    // crea el controlador con dependencias a $scope y a personService
    mod.controller("ciudadCtrl", ["$scope", "ciudadService", function ($scope, svc) {

            // TODO: define los atributos en el scope
            $scope.nombreCiudad = "";
            $scope.paisCiudad = "";
            $scope.sitiosCiudad = "";
            $scope.eventosCiudad = "";

            // TODO: define funciones que son invocadas desde la pantalla
            // y que usan funciones definidas en el servicio
            $scope.agregarCiudad = function () {
                var ciudad = [$scope.nombre, $scope.pais, $scope.sitios, $scope.eventos];
                svc.saveRecord(ciudad);
            };

            $scope.darCiudades = function () {
                return svc.fetchRecords().then(function (response)
                {
                    $scope.ciudades = response.data;
                })
            };

        }]);

})(window.angular);

