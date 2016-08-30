(function(ng){
    var mod = angular.module("alquilerModule",["ui.router","ngMessages"]);

    mod.constant("alquilerContext", "api/alquiler");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/alquiler/';
            $urlRouterProvider.otherwise("/alquilerList");
     
            $stateProvider.state('alquilerList', {
                url: '/alquiler',
                views: {
                    'mainView': {
                        controller: 'alquilerCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'alquiler.list.html'
                    }
                }
            }).state('alquilerCreate', {
                url: '/alquiler/create',
                views: {
                    'mainView': {
                        controller: 'alquilerCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'alquiler.index.html'
                    }
                }

            }).state('alquilerEdit', {
                url: '/alquiler/:alquilerId',
                param: {
                    alquilerId: null
                },
                views: {
                    'mainView': {
                        controller: 'alquilerCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'alquiler.index.html'
                    }
                }
            }).state('alquilerDelete',{
                url:'/alquiler/delete/:alquilerId',
                param: {
                    alquilerId:null
                },
                views:{
                    'mainView':{
                        controller:'alquilerCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'alquiler.delete.html'
                    }
                }
                       
            });
        }]);
})(window.angular);