// src/modules/perfilUsuario/perfilUsuario.ctrl.js
// Controlador para el módulo de personas

(function (ng) {

    // es parte del módulo "personModule"
    var mod = ng.module("perfilUsuarioModule");

    // crea el controlador con dependencias a $scope y a personService
    mod.controller("perfilUsuarioCtrl", ["$scope", "perfilUsuarioService", function ($scope, svc) {

            // TODO: define los atributos en el scope
            $scope.albumnes = [];
            $scope.idPersona = "";
            $scope.nombrePersona = "";
            $scope.emailPersona = "";

            // TODO: define funciones que son invocadas desde la pantalla
            // y que usan funciones definidas en el servicio
            $scope.agregarPersona = function () {
                var persona = [$scope.idPersona, $scope.nombrePersona, $scope.emailPersona];
                svc.saveRecord(persona);
            };

            $scope.listarPersonas = function () {
                return svc.fetchRecords().then(function (response)
                {
                    $scope.personas = response.data;
                })
            };

        }]);

})(window.angular);

