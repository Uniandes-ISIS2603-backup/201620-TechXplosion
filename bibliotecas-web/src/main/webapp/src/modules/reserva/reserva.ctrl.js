/* global usuarioContext */

(function (ng) {
    var mod = ng.module("reservaModule");

    mod.controller("reservaCtrl", ['$scope', '$state', '$stateParams', '$http', 'usuarioContext', function ($scope, $state, $stateParams, $http, usuarioContext) {

            $scope.reservaContext = '/reservas';
            // inicialmente el listado de reservas está vacio
            $scope.records = {};
            // carga las reservas
            $http.get(usuarioContext + "/" + $stateParams.usuarioId+ $scope.reservaContext).then(function(response){
                $scope.records = response.data;    
            }, responseError);

            // el controlador recibió un reservaId ??
            // revisa los parámetros (ver el :reservaId en la definición de la ruta)
            if ($stateParams.reservaId !== null && $stateParams.reservaId !== undefined) {
                
                // toma el id del parámetro
                id = $stateParams.reservaId;
                // obtiene el dato del recurso REST
                $http.get(usuarioContext + "/" + $stateParams.usuarioId+ $scope.reservaContext + "/" + id)
                    .then(function (response) {
                        // $http.get es una promesa
                        // cuando llegue el dato, actualice currentRecord
                        $scope.currentRecord = response.data;
                    }, responseError);

            // el controlador no recibió un reservaId
            } else
            {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    idUsuario: '',
                    idRecurso: '',
                    fechaSolicitud: '' /*Tipo String*/
                    
                };
              
                $scope.alerts = [];
            }


            this.saveRecord = function (id) {
                currentRecord = $scope.currentRecord;
                
                // si el id es null, es un registro nuevo, entonces lo crea
                if (id == null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(usuarioContext + "/" + $stateParams.usuarioId+ $scope.reservaContext, currentRecord)
                        .then(function () {
                            // $http.post es una promesa
                            // cuando termine bien, cambie de estado
                            $state.go('reservaList');
                        }, responseError);
                        
                // si el id no es null, es un registro existente entonces lo actualiza
                } else {
                    
                    // ejecuta PUT en el recurso REST
                    return $http.put(usuarioContext + "/" + $stateParams.usuarioId+ $scope.reservaContext + "/" + currentRecord.id, currentRecord)
                        .then(function () {
                            // $http.put es una promesa
                            // cuando termine bien, cambie de estado
                            $state.go('reservaList');
                        }, responseError);
                };
            };
            this.deleteRecord = function (record) {
                currentRecord = record;
                    // ejecuta DELETE en el recurso REST
                   return $http.delete(usuarioContext + "/" + $stateParams.usuarioId+ $scope.reservaContext + "/" + currentRecord.id)
                        .then(function () {
                            // $http.delete es una promesa
                            // cuando termine bien, cambie de estado
                            $state.reload();
                        }, responseError);
              
            };



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
        }]);

})(window.angular);