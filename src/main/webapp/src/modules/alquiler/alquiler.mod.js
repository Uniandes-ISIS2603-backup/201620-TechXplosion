(function(ng){
    var mod = angular.module("alquilerModule",["ui.router","ngMessages"]);

    mod.constant("alquilerContext", "api/alquileres");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/alquiler/';
            $urlRouterProvider.otherwise("/alquilerList");
     
            $stateProvider.state('alquilerList', {
                url: '/alquiler',
                parent:'usuarioEdit',
                views: {
                    'usuarioInstanceView': {
                        controller: 'alquilerCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'alquiler.list.html'
                    }
                }
            }).state('alquilerCreate', {
                url: '/alquiler/create',
                parent:'usuarioEdit',
                views: {
                    'usuarioInstanceView': {
                       controller: 'alquilerCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'alquiler.index.html'
                    }
                }

            }).state('alquilerEdit', {
                url: '/alquiler/:alquilerId',
                parent:'usuarioEdit',
                param: {
                    alquilerId: null
                },
                views: {
                    'usuarioInstanceView': {
                       controller: 'alquilerCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'alquiler.index.html'
                    }
                }
            });
        }]);
})(window.angular);