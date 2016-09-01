(function (ng) {
    var mod = ng.module("medioModule", ["ngMessages"]);
    mod.constant("medioContext", "api/medioPagos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/medioDePago/';
            $urlRouterProvider.otherwise("/medioList");
     
            $stateProvider.state('medioList', {
                url: '/medios',
                views: {
                    'mainView': {
                        controller: 'medioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "medio.list.html"
                    }
                }
            }).state('medioCreate', {
                url: '/medios/create',
                views: {
                    'mainView': {
                        controller: 'medioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'medio.create.html'
                    }
                }

            }).state('medioEdit', {
                url: '/medios/:medioId',
                param: {
                    cityId: null
                },
                views: {
                    'mainView': {
                        controller: 'medioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'medio.create.html'
                    }
                }
            });
        }]);
})(window.angular);