(function (ng) {
    var mod = ng.module("blogModule");

    mod.controller("blogCtrl", ['$scope', '$state', '$stateParams', '$http', 'libroContext', function ($scope, $state, $stateParams, $http, context) {
            
            $scope.blogContext='/blogs';
            // inicialmente el listado de blogs está vacio
            $scope.records = {};
            // carga las ciudades
            $http.get(context+"/"+$stateParams.libroId+$scope.blogContext).then(function(response){
                $scope.records = response.data;    
            }, responseError);

            // el controlador recibió un blogId ??
            // revisa los parámetros (ver el :blogId en la definición de la ruta)
            if ($stateParams.blogId !== null && $stateParams.blogId !== undefined) {
                
                // toma el id del parámetro
                id = $stateParams.blogId;
                // obtiene el dato del recurso REST
                $http.get(context+"/"+$stateParams.libroId+$scope.blogContext + "/" + id)
                    .then(function (response) {
                        // $http.get es una promesa
                        // cuando llegue el dato, actualice currentRecord
                        $scope.currentRecord = response.data;
                    }, responseError);

            // el controlador no recibió un blogId
            } else
            {
                // el registro actual debe estar vacio
                $scope.currentRecord = {
                    comentarios: '',
                     descripcion: '',
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    name: ''
                   
                };
              
                $scope.alerts = [];
            }


            this.saveRecord = function (id) {
                currentRecord = $scope.currentRecord;
                
                // si el id es null, es un registro nuevo, entonces lo crea
                if (id == null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(context+"/"+$stateParams.libroId+$scope.blogContext, currentRecord)
                        .then(function () {
                            // $http.post es una promesa
                            // cuando termine bien, cambie de estado
                            $state.go('blogList');
                        }, responseError);
                        
                // si el id no es null, es un registro existente entonces lo actualiza
                } else {
                    
                    // ejecuta PUT en el recurso REST
                    return $http.put(context+"/"+$stateParams.libroId+$scope.blogContext + "/" + currentRecord.id, currentRecord)
                        .then(function () {
                            // $http.put es una promesa
                            // cuando termine bien, cambie de estado
                            $state.go('blogList');
                        }, responseError);
                };
            };
           this.deleteRecord = function (record) {
                currentRecord = record;
                
                
          
                    
                    // ejecuta DELETE en el recurso REST
                   return $http.delete(context+"/"+$stateParams.libroId+$scope.blogContext + "/" + currentRecord.id)
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