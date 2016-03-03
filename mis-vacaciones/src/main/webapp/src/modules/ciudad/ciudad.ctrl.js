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


            //Héctor was here
            var self = this;
            function responseError(response) {
                self.showError(response.data);
            }


            // TODO: define funciones que son invocadas desde la pantalla
            // y que usan funciones definidas en el servicio
            $scope.agregarCiudad = function () {
                var ciudad = [$scope.nombre, $scope.pais, $scope.sitios, $scope.eventos];
                return svc.saveRecord(ciudad),responseError();
            };


            $scope.darCiudades = function () {
                return svc.fetchRecords().then(function (response)
                {
                    $scope.ciudades = response.data;
                }), responseError();
            };


            //Héctor was here

            this.ediitarCiudad = function (record) {
                $scope.$broadcast("pre-edit", $scope.currentRecord);
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    $scope.$broadcast("post-edit", $scope.currentRecord);
                    return response;
                }, responseError);
            };


            this.fetchRecords = function () {
                return svc.fetchRecords().then(function (response) {
                    $scope.records = response.data;
                    $scope.currentRecord = {};
                    return response;
                }, responseError);
            };

        }]);

})(window.angular);

