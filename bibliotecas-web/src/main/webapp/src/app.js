
(function (ng) {


    var mod = ng.module("mainApp", [
        "ui.router",
        "ngMessages",
        "reservaModule",
        "alquilerModule",
        "bibliotecaModule",
        "libroModule",
        "videoModule",
        "usuarioModule",
        "medioModule",
        "blogModule"

    ]);
     mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$urlRouterProvider', function ($urlRouterProvider) {
            $urlRouterProvider.otherwise('notfound');
        }]);

  
})(window.angular);

