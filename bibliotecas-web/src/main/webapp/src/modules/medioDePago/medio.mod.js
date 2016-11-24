(function (ng) {
    var mod = ng.module("medioModule", ["ngMessages"]);
    mod.constant("medioContext", "api/medioPagos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/medioDePago/';
            $urlRouterProvider.otherwise("/medioList");
     
            $stateProvider.state('medioList', {
                url: '/medios',
                parent:'usuarioEdit',
                views: {
                    'usuarioInstanceView': {
                        controller: 'medioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "medio.list.html"
                    }
                }
            }).state('medioCreate', {
                url: '/medios/create',
                parent:'usuarioEdit',
                views: {
                    'usuarioInstanceView': {
                        controller: 'medioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'medio.create.html'
                    }
                }

            }).state('medioEdit', {
                url: '/medios/:medioId',
                param: {
                    medioId: null
                },
                parent:'usuarioEdit',
                views: {
                    'usuarioInstanceView': {
                        controller: 'medioCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'medio.create.html'
                    }
                }
            });
        }]);
})(window.angular);