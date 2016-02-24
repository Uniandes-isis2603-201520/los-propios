(function (ng) {
    /* TODO Se debe declarar las dependencias a los módulos en el módulo principal de la aplicación.*/
//    var mod = ng.module("mainApp", ["ui.router",
//    "perfilUsuarioModule"
//    ]);

    var mod = ng.module("mainApp", ["ui.router"]);

    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/principal");
            $stateProvider
                    .state('principal', {
                        url: '/principal',
                       /* controller: "principalCtrl",
                        controllerAs: "ctrl",*/
                        templateUrl: "src/modules/principal/principal.tpl.html"
                    })
                    .state('evento', {
                        url: '/evento',
                        /*controller: "eventoCtrl",
                        controllerAs: "ctrl",*/
                        templateUrl: "src/modules/evento/evento.tpl.html"
                    })
                    .state('perfilUsuario', {
                        url: '/perfil',
                        controller: "perfilUsuarioCtrl",
                        controllerAs: "ctrl",
                        templateUrl: "src/modules/perfilUsuario/perfilUsuario.html"
                    })

                    .state('ciudad', {
                        url: '/ciudad',
                        /*controller: "ciudadCtrl",
                        controllerAs: "ctrl",*/
                        templateUrl: "src/modules/ciudad/ciudad.tpl.html"
                    })
                    .state('itinerario', {
                        url: '/itinerario',
                       /* controller: "itinerarioCtrl",
                        controllerAs: "ctrl",*/
                        templateUrl: "src/modules/itinerario/itinerario.html"
                    })
                    .state('foro', {
                        url: '/foro',
                       /* controller: "foroCtrl",
                        controllerAs: "ctrl",*/
                        templateUrl: "src/modules/foro/foro.tpl.html"
                    })
                    .state('contacto', {
                        url: '/contacto',
                       /* controller: "contactoCtrl",
                        controllerAs: "ctrl",*/
                        templateUrl: "src/modules/contactenos/contactenos.tpl.html"
                    })

                    .state('infoCiudad', {
                        url: '/infoCiudad',
                       /* controller: "infoCiudadCtrl",
                        controllerAs: "ctrl",*/
                        templateUrl: "src/modules/ciudad/infoCiudad.tpl.html"
                    })
                    .state('servicios', {
                        url: '/servicios',
                        templateUrl: "src/modules/servicios/servicios.tpl.html"
                    })
                    .state('about', {
                        url: '/about',
                       /* controller: "aboutCtrl",
                        controllerAs: "ctrl",*/
                        templateUrl: "src/modules/about/about.tpl.html"
                    })
        }]);
})(window.angular);