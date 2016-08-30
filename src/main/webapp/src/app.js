
(function (ng) {


    var mod = ng.module("mainApp", [
        "ui.router",
        "ngMessages",
        "videoModule",
        "libroModule",
        "alquilerModule",
        "bibliotecaModule",
        "usuarioModule",
        "recursoModule",
        "medioModule",
        "reservaModule",
        "blogModule"

    ]);
     mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$urlRouterProvider', function ($urlRouterProvider) {
            $urlRouterProvider.otherwise('/citiesList');
        }]);

  
})(window.angular);

