(function (ng){
    var mod = ng.module("libroModule");
    
    mod.controller("libroCtrl",['$scope','$state','$stateParams', '$http', 'libroContext', function ($scope, $state, $stateParams, $http, context)
        { 
    
        $scope.records = {};
        
        $http.get(context).then(function(response)
        {
            $scope.records = response.data;    
        }, responseError);
        
    if ($stateParams.libroId !== null && $stateParams.libroId !== undefined)
    {
                
                id = $stateParams.libroId;
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

                    // ejecuta POST en el recurso REST
                    return $http.post(context, currentRecord)
                        .then(function () 
                {
                            $state.go('libroList');
                        }, responseError);
                        
                
                } else {
                    
                    // ejecuta PUT en el recurso REST
                    return $http.put(context + "/" + currentRecord.id, currentRecord)
                        .then(function () {
                            // $http.put es una promesa
                            // cuando termine bien, cambie de estado
                            $state.go('libroList');
                        }, responseError);
                };
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