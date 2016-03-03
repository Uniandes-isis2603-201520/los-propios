
/* TODO Se debe declarar las dependencias a los módulos en el módulo principal de la aplicación.*/
(function (ng) {

    // define la aplicación con sus dependencias
    var mod = ng.module("mainApp", [
        "ui.router",
        "perfilUsuarioModule",
        "perfilUsuarioMock"

                /*
                 "itinerarioModule",
                 "ciudadModule",
                 "perfilUsuarioMock",
                 "ciudadMock",
                 "itinerarioMock"
                 */
    ]);

    var sesion = true;
    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/principal");
            if (sesion)
            {
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
                                    templateUrl: "src/modules/ciudad/ciudad.tpl.html"
                                },
                                'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                            }
                        })
                        .state('itinerario', {
                            url: '/itinerario',
                            views: {
                                '': {
                                    templateUrl: "src/modules/itinerario/itinerario.html"
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
                                '': {
                                    /* controller: "contactoCtrl",
                                     controllerAs: "ctrl",*/
                                    templateUrl: "src/modules/contactenos/contactenos.tpl.html"
                                },
                                'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                            }
                        })

                        .state('infoCiudad', {
                            url: '/infoCiudad',
                            views: {
                                '': {
                                    templateUrl: "src/modules/ciudad/infoCiudad.tpl.html"},
                                'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                            }
                        })
                        .state('servicios', {
                            url: '/servicios',
                            views: {
                                '': {
                                    templateUrl: "src/modules/servicios/servicios.tpl.html"
                                },
                                'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                            }
                        })
                        .state('about', {
                            url: '/about',
                            views: {
                                '': {
                                    /* controller: "aboutCtrl",
                                     controllerAs: "ctrl",*/
                                    templateUrl: "src/modules/about/about.tpl.html"
                                },
                                'barraLateral': {templateUrl: "src/modules/principal/prueba.tpl.html"}
                            }
                        });
            } else
            {
                $stateProvider
                        .state('principal', {
                            url: '/principal',
                            templateUrl: "src/modules/principal/principal.tpl.html"
                        })
                        .state('evento', {
                            url: '/evento',
                            templateUrl: "src/modules/evento/evento.tpl.html",
                            controller: "eventoCtrl",
                            controllerAs: "ctrl",
                        })
                        .state('perfilUsuario', {
                            url: '/perfil',
                            controller: "perfilUsuarioCtrl",
                            controllerAs: "ctrl",
                            templateUrl: "src/modules/perfilUsuario/perfilUsuario.html",
                        })

                        .state('ciudad', {
                            url: '/ciudad',
                            templateUrl: "src/modules/ciudad/ciudad.tpl.html"
                        })
                        .state('itinerario', {
                            url: '/itinerario',
                            templateUrl: "src/modules/itinerario/itinerario.html"
                        })
                        .state('foro', {
                            url: '/foro',
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
                        });
            }

        }]);
})(window.angular);
