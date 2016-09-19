(function (ng) {
    var mod = ng.module("blogModule", ["ngMessages"]);
    mod.constant("blogContext", "/blogs");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/blog/';
            $urlRouterProvider.otherwise("/blogList");
     
            $stateProvider.state('blogList', {
                url: '/blogs',
                parent: 'libroEdit',
                views: {
                    'LibroInstanceView': {
                        controller: 'blogCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "blog.list.html"
                    }
                }
            }).state('blogCreate', {
                url: '/blogs/create',
                parent:'libroEdit',
                views: {
                    'LibroInstanceView': {
                        controller: 'blogCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'blog.create.html'
                    }
                }

            }).state('blogEdit', {
                url: '/blogs/:blogId',
                parent: 'libroEdit',
                param: {
                    blogId: null
                },
                views: {
                    'LibroInsatnceView': {
                        controller: 'blogCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'blog.create.html'
                    }
                }
            });
        }]);
})(window.angular);