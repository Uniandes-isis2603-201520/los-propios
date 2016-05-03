/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {

    var mod = ng.module("itinerarioModule");
    mod.controller("itinerarioCtrl", ["$scope", "itinerarioService", function ($scope, svc) {

            var self = this;
            this.readOnly = false;
            this.editMode = false;
            function responseError(response) {
                self.showError(response.data);
            }

            $scope.currentRecord = {
                id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                nombreItinerario: '' /*Tipo String*/,
                fechaInicio: '' /*Tipo String*/,
                fechaFin: '' /*Tipo String*/

            };
            $scope.itinerarios = [];
            $scope.paradas = [];
            $scope.ciudadesParadas = [];
            $scope.nombreParadaUno = "";
            $scope.ciudadParadaUno = "";
            $scope.actividadParadaUno = "";
            $scope.fechaInicioParadaUno = "";
            $scope.fechaFinParadaUno = "";


            $scope.agregarItinerario = function () {
                var itinerario = [$scope.nombreParada, $scope.fechaInicio, $scope.fechaFin];
                svc.saveRecord(itinerario);
                this.editMode = false;
            };

            $scope.listarItinerarios = function () {
                return svc.fetchRecords().then(function (response)
                {
                    $scope.itinerarios = response.data;
                });
            };

            $scope.agregarParada = function () {
                var parada = [$scope.nombreParadaUno, $scope.ciudadParadaUno, $scope.actividadParadaUno, $scope.fechaInicioParadaUno, $scope.fechaFinParadaUno];
                svc.saveRecordDos(parada);
            };

            $scope.listarParadas = function () {
                return svc.fetchRecordsDos().then(function (response)
                {
                    $scope.paradas = response.data;
                });
            };

            this.editRecord = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    self.editMode = true;
                    $scope.$broadcast("post-edit", $scope.currentRecord);
                    return response;
                }, responseError);
            };
            this.saveRecord = function () {

                return svc.saveRecord($scope.currentRecord).then(function () {
                    self.fetchRecords();
                }, responseError);

            };
            this.createRecord = function () {
                this.editMode = true;
                $scope.currentRecord = {};
                $scope.$broadcast("post-create", $scope.currentRecord);
            };

            this.fetchRecords = function () {
                return svc.fetchRecords().then(function (response) {
                    $scope.itinerarios = response.data;
                    $scope.currentRecord = {};
                    self.editMode = false;
                    return response;
                }, responseError);
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
            $scope.listarItinerarios();
        }]);

})(window.angular);
