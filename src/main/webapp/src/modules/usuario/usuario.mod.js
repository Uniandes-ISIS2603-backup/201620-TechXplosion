(function (ng) {
    var mod = ng.module("usarioModule", ["ngMessages"]);
    mod.constant("usuarioContext", "api/usuarios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/uusario/';
            $urlRouterProvider.otherwise("/usuarioList");
     
            $stateProvider.state('usuarioList', {
                url: '/usuarios',
                views: {
                    'mainView': {
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "usuario.list.html"
                    }
                }
            }).state('usuarioCreate', {
                url: '/usuarios/create',
                views: {
                    'mainView': {
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuario.create.html'
                    }
                }

            }).state('usuarioEdit', {
                url: '/usuarios/:usuariosId',
                param: {
                    cityId: null
                },
                views: {
                    'mainView': {
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuarios.create.html'
                    }
                }
            });
        }]);
})(window.angular);
