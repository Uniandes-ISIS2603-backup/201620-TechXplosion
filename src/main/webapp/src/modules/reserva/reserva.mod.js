(function (ng) {
    var mod = ng.module("reservaModule", ["ui.router","ngMessages"]);
    mod.constant("reservaContext", "api/reservas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/reserva/';
            $urlRouterProvider.otherwise("/reservaList");
     
            $stateProvider.state('reservaList', {
                url: '/reservas',
                parent:'usuarioEdit',
                views: {
                    'usuarioInstanceView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "reserva.list.html"
                    },
                }
            }).state('reservaCreate', {
                url: '/reservas/create',
                parent:'usuarioEdit',
                views: {
                    'usuarioInstanceView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'reserva.create.html'
                    },
                }

            }).state('reservaEdit', {
                url: '/reservas/:reservaId',
                parent:'usuarioEdit',
                param: {
                    cityId: null
                },
                views: {
                    'usuarioInstanceView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'reserva.create.html'
                    },
                }
            }).state('libroReservaList', {
                url: '/reservas',
                parent:'libroEdit',
                views: {
                    'LibroInstanceView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "reserva.list.html"
                    },
                }
            }).state('libroReservaEdit', {
                url: '/reservas',
                parent:'libroEdit',
                views: {
                    'LibroInstanceView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "reserva.create.html"
                    },
                }
            }).state('libroReservaCreate', {
                url: '/reservas',
                parent:'libroEdit',
                views: {
                    'LibroInstanceView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "reserva.create.html"
                    },
                }
            }).state('videoReservaList', {
                url: '/reservas',
                parent:'videoEdit',
                views: {
                    'VideoInstanceView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "reserva.list.html"
                    },
                }
            }).state('videoReservaEdit', {
                url: '/reservas',
                parent:'videoEdit',
                views: {
                    'VideoInstanceView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "reserva.create.html"
                    },
                }
            }).state('videoReservaCreate', {
                url: '/reservas',
                parent:'videoEdit',
                views: {
                    'VideoInstanceView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "reserva.create.html"
                    },
                }
            });
        }]);
})(window.angular);