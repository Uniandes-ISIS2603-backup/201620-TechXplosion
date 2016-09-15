
(function(ng){
    var mod = ng.module("libroModule",["ui.router","ngMessages"]);

    mod.constant("libroContext", "api/libros");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/libro/';
            $urlRouterProvider.otherwise("/libroList");
     
            $stateProvider.state('libroList', {
                url: '/libro',
                views: {
                    'mainView': {
                        controller: 'libroCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'libro.list.html'
                    }
                }
            }).state('libroCreate', {
                url: '/libro/create',
                views: {
                    'mainView': {
                        controller: 'libroCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'libro.create.html'
                    }
                }

            }).state('libroEdit', {
                url: '/libro/:libroIsbn',
                param: {
                    libroIsbn: null
                },
                views: {
                    'mainView': {
                        controller: 'libroCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'libro.create.html'
                    }
                }
                
            });
        }]);
})(window.angular);