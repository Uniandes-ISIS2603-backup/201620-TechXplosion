(function(ng){
    var mod = angular.module("usuarioModule",["ui.router","ngMessages"]);

    mod.constant("usuarioContext", "api/usuarios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/usuario/';
            $urlRouterProvider.otherwise("/usuarios");
     
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
            }).state('usuarioList', {
                url: '/list',
                parent:'usuarios',
                views: {
                    'usuarioView': {
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuario.list.html'
                    }
                }
            }).state('usuarioCreate', {
                url: '/create',
                 parent:'usuarios',
                views: {
                    'usuarioView': {
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuario.index.html'
                    }
                }

            }).state('usuarioEdit', {
                url: '/{usuarioId:int}/edit',
                param: {
                    'usuarioId': null
                },
                parent:'usuarios',
                views: {
                    'usuarioView': {
                        controller: 'usuarioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'usuario.index.html'
                    },
                    'hijoView' : {
                        templateUrl: basePath + 'usuario.instance.html'
                    }
                }
                
            });
        }]);
})(window.angular);