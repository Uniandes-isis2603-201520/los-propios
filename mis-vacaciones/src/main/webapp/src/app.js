
(function (ng) {

    // define la aplicación con sus dependencias
    var mod = ng.module("mainApp", [
        "ui.router","perfilUsuarioModule","eventoModule","ciudadModule","itinerarioModule"
    ]);
    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/principal");
            $stateProvider
                    .state('principal', {
                        url: '/principal',
                        views: {
                            '': {templateUrl: "src/modules/principal/principal.tpl.html"},
                            'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                        }
                    })
                    .state('evento', {
                        url: '/evento',
                        views: {
                            '': {
                                controller: "eventoCtrl",
                                controllerAs: "ctrl",
                                templateUrl: "src/modules/evento/evento.tpl.html"},
                            'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                        }
                    })
                    .state('perfilUsuario', {
                        url: '/perfil',
                        views: {
                            '': {
                                controller: "perfilUsuarioCtrl",
                                controllerAs: "ctrl",
                                templateUrl: "src/modules/perfilUsuario/perfilUsuario.html"},
                            'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                        }
                    })

                    .state('ciudad', {
                        url: '/ciudad',
                        views: {
                            '': {
                                controller: "ciudadCtrl",
                                controllerAs: "ctrl",
                                templateUrl: "src/modules/ciudad/ciudad.tpl.html"
                            },
                            'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                        }
                    })
                    .state('itinerario', {
                        url: '/itinerario',
                        views: {
                            '': {
                                controller: "itinerarioCtrl",
                                controllerAs: "ctrl",
                                templateUrl: "src/modules/itinerario/itinerario.tpl.html"
                            },
                            'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                        }
                    })
                    .state('foro', {
                        url: '/foro',
                        views: {
                            '': {
                                templateUrl: "src/modules/foro/foro.tpl.html"
                            },
                            'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                        }
                    })
                    .state('contacto', {
                        url: '/contacto',
                        views: {
                            '': {templateUrl: "src/modules/contactenos/contactenos.tpl.html"},'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                        }})
                    .state('infoCiudad', {
                        url: '/infoCiudad',
                        views: {
                            '': {templateUrl: "src/modules/ciudad/infoCiudad.tpl.html"},'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                        }})
                    .state('servicios', {
                        url: '/servicios',
                        views: {
                            '': {templateUrl: "src/modules/servicios/servicios.tpl.html"},'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                        }})
                    .state('about', {
                        url: '/about',
                        views: {
                            '': {templateUrl: "src/modules/about/about.tpl.html"},'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                        }})
                    .state('visitas', {
                        url: '/visitas',
                        views: {
                            '': {templateUrl: "src/modules/visita/visita.tpl.html"},'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                        }})

                    ;
        }]);
})(window.angular);