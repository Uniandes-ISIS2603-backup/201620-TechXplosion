
(function(ng){
    var mod = ng.module("libroModule",["ui.router","ngMessages"]);

    mod.constant("libroContext", "api/libros");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/libro/';
            $urlRouterProvider.otherwise("/libroList");
     
            $stateProvider.state('libro', {
                url: '/libro',
                abstract: true,
                views: {
                    'mainView': {
                        controller: 'libroCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'libro.html'
                    }
                }
            }).state('libroList', {
                url: '/lista',
                parent: 'libro',
                views: {
                    'libroView': {
                        controller: 'libroCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'libro.list.html'
                    }
                }
            }).state('libroCreate', {
                url: '/create',
                views: {
                    'mainView': {
                        controller: 'libroCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'libro.create.html'
                    }
                }

            }).state('libroEdit', {
                url: '/:libroId',
                param: {
                    libroId: null
                },
                parent: 'libro',
                views: {
                    'libroView': {
                        controller: 'libroCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'libro.create.html'
                    },
                    'childView':{
                        templateUrl: basePath + 'libro.instance.html'
                    }
                }
                
            });
        }]);
})(window.angular);