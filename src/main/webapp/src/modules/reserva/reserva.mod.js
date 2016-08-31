(function (ng) {
    var mod = ng.module("reservaModule", ["ui.router","ngMessages"]);
    mod.constant("reservaContext", "api/reservas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/reserva/';
            $urlRouterProvider.otherwise("/reservaList");
     
            $stateProvider.state('reservaList', {
                url: '/reservas',
                views: {
                    'mainView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "reserva.list.html"
                    }
                }
            }).state('reservaCreate', {
                url: '/reservas/create',
                views: {
                    'mainView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'reserva.create.html'
                    }
                }

            }).state('reservaEdit', {
                url: '/reservas/:reservaId',
                param: {
                    cityId: null
                },
                views: {
                    'mainView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'reserva.create.html'
                    }
                }
            });
        }]);
})(window.angular);