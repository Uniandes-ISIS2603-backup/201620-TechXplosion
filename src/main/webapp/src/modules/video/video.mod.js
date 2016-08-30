(function(ng){
    var mod = angular.module("videoModule",["ui.router","ngMessages"]);

    mod.constant("videoContext", "api/video");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/video/';
            $urlRouterProvider.otherwise("/videoList");
     
            $stateProvider.state('videoList', {
                url: '/video',
                views: {
                    'mainView': {
                        controller: 'videoCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'video.index.html'
                    }
                }
            }).state('videoCreate', {
                url: '/video/create',
                views: {
                    'mainView': {
                        controller: 'videoCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'video.index.html'
                    }
                }

            }).state('videoEdit', {
                url: '/video/:videoId',
                param: {
                    videoId: null
                },
                views: {
                    'mainView': {
                        controller: 'videoCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'video.index.html'
                    }
                }
                
            });
        }]);
})(window.angular);