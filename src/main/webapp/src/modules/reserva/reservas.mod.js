(function (ng) {
    var mod = ng.module("reservaModule", ["ngMessages"]);
    mod.constant("reservasContext", "api/reservas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/reservas/';
            $urlRouterProvider.otherwise("/reservasList");
     
            $stateProvider.state('reservasList', {
                url: '/reservas',
                views: {
                    'mainView': {
                        controller: 'reservasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'reservas.list.html'
                    }
                }
            }).state('reservasCreate', {
                url: '/reservas/create',
                views: {
                    'mainView': {
                        controller: 'reservasCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'reservas.create.html'
                    }
                }

            }).state('reservaEdit', {
                url: '/reservas/:reservaId',
                param: {
                    reservaId: null
                },
                views: {
                    'mainView': {
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'reservas.create.html'
                    }
                }
            });
        }]);
})(window.angular);