/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {

    var mod = ng.module("itinerarioModule");
    mod.controller("itinerarioCtrl","paradaCtrl" ["$scope", "itinerarioService", "$modal", function ($scope, svc, $modal) {


            $scope.alerts = [];
            $scope.currentRecord={
                id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                nombreItinerario: '' /*Tipo String*/,
                fechaInicio: '' /*Tipo date*/,
                fechaFin: '' /*Tipo date*/,
                paradas: [{/* Colección de registros de Parada*/
                        idParada: undefined /*Tipo Long. El valor se asigna en el backend*/,
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

           }]);

            mod.controller("paradaCtrl", ["$scope", "itinerarioService", function ($scope, Itinerariosvc) {

            $scope.currentRecord = {};
            $scope.paradas = [];
            $scope.refName = "paradas";
            $scope.alerts = [];

             //Alertas
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

            var self = this;
            function responseError(response) {
                self.showError(response.data);
            }

            //Variables para el controlador
            this.readOnly = false;
            this.editMode = false;

            //Escucha de evento cuando se selecciona un registro maestro
            function onCreateOrEdit(event, args) {
                var childName = "paradas";
                if (args[childName] === undefined) {
                    args[childName] = [];
                }
                $scope.paradas = args[childName];
                $scope.refId = args.id;
            }

            $scope.$on("post-create", onCreateOrEdit);
            $scope.$on("post-edit", onCreateOrEdit);

            //Función para encontrar un registro por ID o CID
            function indexOf(rc) {
                var field = rc.id !== undefined ? 'id' : 'cid';
                for (var i in $scope.paradas) {
                    if ($scope.paradas.hasOwnProperty(i)) {
                        var current = $scope.paradas[i];
                        if (current[field] === rc[field]) {
                            return i;
                        }
                    }
                }
            }

             this.createRecordDos = function () {
                this.editMode = true;
                $scope.currentRecord = {};
            };

            var self = this;

            this.agregarParada = function () {
                var rc = $scope.currentRecord;
                if (rc.id || rc.idParada) {
                    var idx = indexOf(rc);
                    $scope.paradas.splice(idx, 1, rc);
                } else {
                    rc.idParada = -Math.floor(Math.random() * 10000);
                    rc[$scope.parent] = {id: $scope.refId};
                    $scope.paradas.push(rc);
                }
                this.listarParadas();
            };

            this.listarParadas = function () {
                 $scope.currentRecord = {};
                this.editMode = false;
             };

//            this.editParada = function (recordDos) {
//                return svc.fetchRecordDos(recordDos.id).then(function (response) {
//                    $scope.currentRecord.paradas = response.data;
//                    $scope.$broadcast("post-edit", $scope.currentRecord.paradas);
//                    return response;
//                }, responseError);
//            };

             this.editParada = function (record) {
                $scope.currentRecord = ng.copy(record);
                this.editMode = true;
            };

            this.deleteParada = function (record) {
                var idx = indexOf(record);
                $scope.paradas.splice(idx, 1);
            };
        }]);

})(window.angular);
