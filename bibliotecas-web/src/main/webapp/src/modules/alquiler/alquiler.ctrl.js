(function (ng){
    var mod = angular.module("alquilerModule");
    mod.controller("alquilerCtrl",['$scope','$state','$stateParams', '$http', 'alquilerContext', function ($scope, $state, $stateParams, $http, context){ 
        $scope.records = {};
        $http.get(context).then(function(response)
        {
            $scope.records = response.data;    
        }, responseError);
    if ($stateParams.alquilerId !== null && $stateParams.alquilerId !== undefined) {   
                id = $stateParams.alquilerId;
                $http.get(context + "/" + id)
                    .then(function (response) 
                       {
                        // $http.get es una promesa
                        // cuando llegue el dato, actualice currentRecord
                        $scope.currentRecord = response.data;
                    }, responseError);
      }  
      else         
        {
                $scope.currentRecord = {
                    id: undefined /*Tipo Long. El valor se asigna en el backend*/,
                    name: '' /*Tipo String*/,
                };              
                $scope.alerts = [];
            }
            this.saveRecord = function (id) 
            {
                currentRecord = $scope.currentRecord;                
                if (id == null) {
                    return $http.post(context, currentRecord).then(function () 
                {
                            $state.go('alquilerListView');
                        }, responseError);                     
                } else {
                    return $http.put(context + "/" + currentRecord.id, currentRecord)
                        .then(function () {
                            // $http.put es una promesa
                            // cuando termine bien, cambie de estado
                            $state.go('alquilerListView');
                        }, responseError);
                };
            };
            this.deleteRecord = function (record) {
                currentRecord = record;
                    // ejecuta DELETE en el recurso REST
                   return $http.delete(context + "/" + currentRecord.id)
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