(function(ng){
    var mod = angular.module("usuarioModule",["ui.router","ngMessages"]);

    mod.constant("usuarioContext", "api/usuarios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/usuario/';
            $urlRouterProvider.otherwise("/usuarioList");
     
            $stateProvider.state('usuarios',{
                url:'/usuarios',
                abstract: true,
                views:{
                    'mainView':{
                        controller:'usuarioCtrl',
                        controllerAs:'ctrl',
                        templateUrl:basePath+'usuario.html'
                    }
                }
            })
     
            $stateProvider.state('usuarioList', {
                url: '/usuario',
                views: {
                    'mainView': {
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuario.list.html'
                    }
                }
            }).state('usuarioCreate', {
                url: '/usuario/create',
                views: {
                    'mainView': {
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuario.index.html'
                    }
                }

            }).state('usuarioEdit', {
                url: '/usuario/:usuarioId',
                param: {
                    videoId: null
                },
                views: {
                    'mainView': {
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuario.index.html'
                    }
                }
                
            });
        }]);
})(window.angular);