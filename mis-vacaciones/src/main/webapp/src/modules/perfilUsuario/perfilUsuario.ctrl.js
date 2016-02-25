// src/modules/perfilUsuario/perfilUsuario.ctrl.js
// Controlador para el módulo de perfil Usuario

(function (ng) {

    // es parte del módulo "personModule"
    var mod = ng.module("perfilUsuarioModule");

    // crea el controlador con dependencias a $scope y a personService
    mod.controller("perfilUsuarioCtrl", ["$scope", "perfilUsuarioService", function ($scope, svc) {

            // TODO: define los atributos en el scope
            $scope.albumnes = [];
            $scope.idAlbum = "";
            $scope.ciudad = "";
            $scope.descripcion = "";

            // TODO: define funciones que son invocadas desde la pantalla
            // y que usan funciones definidas en el servicio
            $scope.agregarAlbum = function () {
                var album = [$scope.idAlbum, $scope.ciudad, $scope.descripcion];
                svc.saveRecord(album);
            };

            $scope.listarAlbumes = function () {
                return svc.fetchRecords().then(function (response)
                {
                    $scope.albumnes = response.data;
                })
            };

        }]);

})(window.angular);

