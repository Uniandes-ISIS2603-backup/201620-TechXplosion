(function (ng) {

    var mod = ng.module("mainApp", [
        "ui.router",
        "videoModule",
	   "libroModule",
	   "alquilereModule",
	   "bibliotecaModule",
	   "usuariosModule",
        "recursoModule",
        "medioDePagoModule", 
        "reservaModule",
        "blogModule",
        "ngMessages"
    ]);

    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$urlRouterProvider', function ($urlRouterProvider) {
            $urlRouterProvider.otherwise('/citiesList');
        }]);

  
})(window.angular);