
(function(ng){
    var mod = ng.module("libroModule",["ui.router","ngMessages"]);

    mod.constant("libroContext", "api/libro");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/libro/';
            $urlRouterProvider.otherwise("/libroList");
     
            $stateProvider.state('libroList', {
                url: '/libro',
                views: {
                    'mainView': {
                        controller: 'libroCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'libro.index.html'
                    }
                }
            }).state('libroCreate', {
                url: '/libro/create',
                views: {
                    'mainView': {
                        controller: 'libroCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'libro.index.html'
                    }
                }

            }).state('libroEdit', {
                url: '/libro/:libroId',
                param: {
                    libroId: null
                },
                views: {
                    'mainView': {
                        controller: 'libroCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'libro.index.html'
                    }
                }
                
            });
        }]);
})(window.angular);