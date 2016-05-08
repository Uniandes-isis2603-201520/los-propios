/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {

    var mod = ng.module("itinerarioModule");
    mod.controller("itinerarioCtrl", ["$scope", "itinerarioService", "$modal", function ($scope, svc, $modal) {


            $scope.alerts = [];
            $scope.currentRecord={
                id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                nombreItinerario: '' /*Tipo String*/,
                fechaInicio: '' /*Tipo date*/,
                fechaFin: '' /*Tipo date*/,
                paradas: [{/* Colección de registros de Parada
                        idParada: undefined /*Tipo Long. El valor se asigna en el backend/,
                        nombreParadaUno: ''/*Tipo String*/,
                        ciudadParadaUno: '' /*Tipo String*/,
                        actividadParadaUno: '' /*Tipo String*/,
                        fechaInicioParadaUno: '' /*Tipo date*/,
                        fechaFinParadaUno: '' /*Tipo date*/
                    },{
                        idParada: undefined /*Tipo Long. El valor se asigna en el backend*/,
                        nombreParadaUno: ""/*Tipo String*/,
                        ciudadParadaUno: "" /*Tipo String*/,
                        actividadParadaUno: "" /*Tipo String*/,
                        fechaInicioParadaUno:"" /*Tipo date*/,
                        fechaFinParadaUno: "" /*Tipo date*/
                }]/*Coleccion de registros de Parada*/
            };

            $scope.itinerarios = [];


             this.closeAlert = function (index) {
                $scope.alerts.splice(index, 1);
            };


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

            //Variables para el controlador
            this.readOnly = false;
            this.editMode = false;

            this.changeTab = function (tab) {
                $scope.tab = tab;
            };

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

 /*
             * Funcion fetchRecords consulta todos los registros del módulo book en base de datos
             * para desplegarlo en el template de la lista.
             */
            this.fetchRecords();


            function updateParada(event, args) {
                $scope.currentRecord.paradas = args;
            }
            ;

            $scope.$on('updateParada', updateParada);

            this.agregarParada = function () {
                var parada = [$scope.nombreParadaUno, $scope.ciudadParadaUno, $scope.actividadParadaUno, $scope.fechaInicioParadaUno, $scope.fechaFinParadaUno];
                svc.saveRecordDos(parada);
            };

            this.listarParadas = function () {
                return svc.fetchRecordsDos().then(function (response)
                {
                    $scope.paradas = response.data;
                });
            };

            this.editParada = function (record) {
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    $scope.$broadcast("post-edit", $scope.currentRecord);
                    return response;
                }, responseError);
            };

            this.deleteRecordDos = function (record) {
                return svc.deleteRecord(record.id).then(function () {
                    self.listarParadas();
                }, responseError);
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


            this.listarItinerarios();
            this.listarParadas();
        }]);

})(window.angular);
