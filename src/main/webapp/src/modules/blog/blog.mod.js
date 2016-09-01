(function (ng) {
    var mod = ng.module("blogModule", ["ngMessages"]);
    mod.constant("blogContext", "api/blogs");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/blog/';
            $urlRouterProvider.otherwise("/blogList");
     
            $stateProvider.state('blogList', {
                url: '/blogs',
                views: {
                    'mainView': {
                        controller: 'blogCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + "blog.list.html"
                    }
                }
            }).state('blogCreate', {
                url: '/blogs/create',
                views: {
                    'mainView': {
                        controller: 'blogCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'blog.create.html'
                    }
                }

            }).state('blogEdit', {
                url: '/blogs/:blogId',
                param: {
                    blogId: null
                },
                views: {
                    'mainView': {
                        controller: 'blogCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'blog.create.html'
                    }
                }
            });
        }]);
})(window.angular);