(function (ng) {
    var mod = ng.module("libroModule");
    mod.controller("reservaLibroCtrl", ['$scope', '$state', '$stateParams', '$http', 'librosContext', 'reservasContext', '$log',
        function ($scope, $state, $stateParams, $http, librosContext, reservasContext, $log) {

            // carga las reservas del libro $stateParams.libroId
            if ($stateParams.libroId !== null && $stateParams.libroId !== undefined) {

                // toma el id del parámetro
                id = $stateParams.libroId;
                // obtiene el dato del recurso REST
                $log.warn('Get ' + librosContext + "/" + id + "/reservas");
                $http.get(librosContext + "/" + id + "/reservas")
                        .then(function (response) {
                            // $http.get es una promesa
                            // cuando llegue el dato, actualice currentRecord
                            $scope.libroReservas = response.data;
                            $scope.selectedReservas = Array.from($scope.libroReservas);
                        }, responseError);
                // el controlador no recibió un libroId
            } else {
                showError("El libro no existe");
                $scope.libroReservas = {};
                $scope.selectedReservas = []; // Contendra la lista de reservas del libro en $stateParams.libroId
            }


            $scope.records = {}; // Contendra la lista de reservas del libro en $stateParams.bookId
            $scope.allReservas = [];
            // carga todas las reservas
            $log.warn(reservasContext);
            $http.get(reservasContext).then(function (response) {
                $scope.records = response.data;
                var log = [];
                $log.warn(angular.forEach(Array.from($scope.records), function (v, k) {
                    this.push(k + ': ' + v);
                }, log));

                $scope.allReservas = Array.from($scope.records);
            }, responseError);



            this.updateReservasLibros = function (selectedReservas) {
                $log.warn('Put ' + librosContext + "/" + id + "/reservas");
                 var log = [];
                $log.warn(angular.forEach(Array.from(selectedAuthors), function (v, k) {
                    this.push(k + ': ' + v);
                }, log));
                $http.put(librosContext + "/" + id + "/reservas", selectedAuthors).then(function (response) {

                    $state.go('reservaLibroList');
                }, responseError);
            };
            $scope.disabled = undefined;
            $scope.searchEnabled = undefined;

            this.enable = function () {
                $scope.disabled = false;
            };

            this.disable = function () {
                $scope.disabled = true;
            };

            this.enableSearch = function () {
                $scope.searchEnabled = true;
            }

            this.disableSearch = function () {
                $scope.searchEnabled = false;
            }

           
            // -----------------------------------------------------------------
            // Funciones para manejra los mensajes en la aplicación


            //Alertas
            this.closeAlert = function (index) {
                $scope.alerts.splice(index, 1);
            };
            // Función showMessage: Recibe el mensaje en String y su tipo con el fin de almacenarlo en el array $scope.alerts.
            function showMessage(msg, type) {
                var types = ["info", "danger", "warning", "success"];
                if (types.some(function (rc) {
                    return type === rc;
                })) {
                    $scope.alerts.push({type: type, msg: msg});
                }
            }

            this.showError = function (msg) {
                showMessage(msg, "danger");
            };
            this.showSuccess = function (msg) {
                showMessage(msg, "success");
            };
            var self = this;
            function responseError(response) {

                self.showError(response.data);
            }
        }
    ]);
})(window.angular);