(function (ng) {
    var mod = ng.module("bibliotecaModule", ["ui.router","ngMessages"]);
    mod.constant("bibliotecaContext", "api/bibliotecas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/biblioteca/';
            $urlRouterProvider.otherwise("/bibliotecasList");
     
            $stateProvider.state('bibliotecasList', {
                url: '/bibliotecas',
                views: {
                    'mainView': {
                        controller: 'bibliotecaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "biblioteca.list.html"
                    }
                }
            }).state('bibliotecaCreate', {
                url: '/bibliotecas/create',
                views: {
                    'mainView': {
                        controller: 'bibliotecaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'biblioteca.create.html'
                    }
                }

            }).state('bibliotecaEdit', {
                url: '/bibliotecas/:bibliotecaId',
                param: {
                    bibliotecaId: null
                },
                views: {
                    'mainView': {
                        controller: 'bibliotecaCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'biblioteca.create.html'
                    }
                }
            });
        }]);
})(window.angular);