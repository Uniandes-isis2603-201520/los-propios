/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {

    // es parte del módulo "ciudadModule"
    var mod = ng.module("ciudadModule");

    // crea el controlador con dependencias a $scope y a personService
    mod.controller("ciudadCtrl", ["$scope", "ciudadService", function ($scope, svc) {

            // TODO: define los atributos en el scope
            //$scope.nombreCiudad = "";
            //$scope.paisCiudad = "";
            //$scope.sitiosCiudad = "";
            //$scope.eventosCiudad = "";
            $scope.alerts = [];
            $scope.currentRecord = {};
            $scope.records = [];

            $scope.today = function () {
                $scope.value = new Date();
            };

            $scope.clear = function () {
                $scope.value = null;
            };

            $scope.open = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.opened = true;
            };

            //Alertas
            this.closeAlert = function (index) {
                $scope.alerts.splice(index, 1);
            };

            // Función showMessage: Recibe el mensaje en String y su tipo con el fin de almacenarlo en el array $scope.alerts.
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


            //Ejemplo alerta
            showMessage("Bienvenido!, Esto es un ejemplo para mostrar un mensaje de información", "info");



            // TODO: define funciones que son invocadas desde la pantalla
            // y que usan funciones definidas en el servicio
            $scope.agregarCiudad = function () {
                $scope.$broadcast("pre-create", $scope.currentRecord);
                this.editMode = true;
                $scope.currentRecord = {};
                $scope.$broadcast("post-create", $scope.currentRecord);
            };
            //Héctor was here

            this.editarCiudad = function (record) {
                $scope.$broadcast("pre-edit", $scope.currentRecord);
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    $scope.$broadcast("post-edit", $scope.currentRecord);
                    return response;
                }, responseError);
            };


            /*
             * Funcion saveRecord hace un llamado al servicio svc.saveRecord con el fin de
             * persistirlo en base de datos.
             * Muestra el template de la lista de records al finalizar la operación saveRecord
             */
            this.saveRecord = function () {
                    return svc.saveRecord($scope.currentRecord).then(function () {
                        self.fetchRecords();
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

